package com.reason.lang.rescript;

import com.intellij.psi.util.*;
import com.reason.ide.files.*;
import com.reason.lang.core.*;
import com.reason.lang.core.psi.*;
import com.reason.lang.core.psi.impl.*;
import org.junit.*;

import java.util.*;

@SuppressWarnings("ConstantConditions")
public class FunctionParsingTest extends ResParsingTestCase {
    @Test
    public void test_anonymous_function() {
        RPsiLet e = firstOfType(parseCode("let _ = Belt.map(items, (. item) => value)"), RPsiLet.class);
        assertNoParserError(e);

        RPsiFunction function = PsiTreeUtil.findChildOfType(e, RPsiFunction.class);
        assertSize(1, function.getParameters());
        assertEquals("item", first(function.getParameters()).getText());
        assertInstanceOf(first(function.getParameters()).getNameIdentifier(), RPsiLowerSymbol.class);
        assertEquals("value", function.getBody().getText());
    }

    @Test
    public void test_brace_function() {
        RPsiLet e = firstOfType(parseCode("let x = (x, y) => { x + y }"), RPsiLet.class);
        assertNoParserError(e);

        RPsiFunction function = (RPsiFunction) e.getBinding().getFirstChild();
        assertSize(2, function.getParameters());
        assertEquals("(x, y) => { x + y }", function.getText());
        assertNotNull(function.getBody());
    }

    @Test
    public void result_function_braces() {
        RPsiLet e = firstOfType(parseCode("let fn = () => {\n" +
                "  let result: (. unit) => unit = (. ()) => ()\n" +
                "}"), RPsiLet.class);
        assertNoParserError(e);

        RPsiLet el = PsiTreeUtil.findChildOfType(e, RPsiLet.class);
        assertEquals("(. unit) => unit", el.getSignature().getText());
        assertEquals("(. ()) => ()", el.getBinding().getText());
    }

    @Test
    public void test_destructuration() {
        RPsiLet e = firstOfType(parseCode("let _ = (a, {b, _}) => b"), RPsiLet.class);
        assertNoParserError(e);

        assertTrue(e.isFunction());
        assertSize(2, e.getFunction().getParameters());
    }

    @Test
    public void test_parenless_function() {
        RPsiLet e = firstOfType(parseCode("let _ = x => x + 10"), RPsiLet.class);
        assertNoParserError(e);

        assertTrue(e.isFunction());
        RPsiFunction function = (RPsiFunction) e.getBinding().getFirstChild();

        assertSize(1, function.getParameters());
        assertInstanceOf(first(function.getParameters()), RPsiParameterDeclaration.class);
        assertNotNull(function.getBody());
    }

    @Test
    public void test_dot_function() {
        RPsiLet e = firstOfType(parseCode("let _ = (. x) => x"), RPsiLet.class);
        assertNoParserError(e);

        assertTrue(e.isFunction());
        RPsiFunction function = e.getFunction();

        assertSize(1, function.getParameters());
        assertEquals("x", first(function.getParameters()).getText());
        assertEquals("x", function.getBody().getText());
    }

    @Test
    public void test_inner_function() {
        RPsiLet e = firstOfType(parseCode("let _ = error => Belt.Array.mapU(errors, (. error) => error[\"message\"])"), RPsiLet.class);
        assertNoParserError(e);

        RPsiFunction functionOuter = (RPsiFunction) e.getBinding().getFirstChild();
        assertEquals("Belt.Array.mapU(errors, (. error) => error[\"message\"])", functionOuter.getBody().getText());

        RPsiFunction functionInner = PsiTreeUtil.findChildOfType(functionOuter, RPsiFunction.class);
        assertEquals("error[\"message\"]", functionInner.getBody().getText());
    }

    @Test
    public void test_inner_function_braces() {
        RPsiLet e = firstOfType(parseCode("let _ = error => { Belt.Array.mapU(errors, (. error) => error[\"message\"]) }"), RPsiLet.class);
        assertNoParserError(e);

        RPsiFunction functionOuter = (RPsiFunction) e.getBinding().getFirstChild();
        assertEquals("{ Belt.Array.mapU(errors, (. error) => error[\"message\"]) }", functionOuter.getBody().getText());

        RPsiFunction functionInner = PsiTreeUtil.findChildOfType(functionOuter, RPsiFunction.class);
        assertEquals("error[\"message\"]", functionInner.getBody().getText());
    }

    @Test
    public void test_inner_function_no_parens() {
        RPsiLet e = firstOfType(parseCode("let _ = funcall(result => 2)"), RPsiLet.class);
        assertNoParserError(e);

        RPsiFunction functionInner = PsiTreeUtil.findChildOfType(e, RPsiFunction.class);
        assertEquals("2", functionInner.getBody().getText());
    }

    @Test
    public void test_parameter_anon_function() {
        FileBase e = parseCode("describe('a', () => test('b', () => true))");
        assertNoParserError(e);

        List<RPsiFunction> funcs = new ArrayList<>(PsiTreeUtil.findChildrenOfType(e, RPsiFunction.class));
        assertSize(2, funcs);
        assertEquals("() => test('b', () => true)", funcs.get(0).getText());
        assertEquals("() => true", funcs.get(1).getText());
    }

    @Test
    public void test_parameters_named_symbols() {
        RPsiLet e = firstOfType(parseCode("let make = (~p1: (. int) => unit, ~p2: option<'a>, children) => null"), RPsiLet.class);
        assertNoParserError(e);

        RPsiFunction function = (RPsiFunction) e.getBinding().getFirstChild();
        List<RPsiParameterDeclaration> parameters = new ArrayList<>(function.getParameters());
        assertSize(3, parameters);

        assertEquals("p1", parameters.get(0).getName());
        assertSize(2, parameters.get(0).getSignature().getItems());
        assertEquals("p2", parameters.get(1).getName());
        assertEquals("children", parameters.get(2).getName());
    }

    @Test
    public void test_parameters_named_symbols2() {
        RPsiLet e = firstOfType(parseCode(
                "let make = (~text, ~id=?, ~values=?, ~className=\"\", ~tag=\"span\", ~transform=\"unset\", ~marginLeft=\"0\", ~onClick=?, ~onKeyPress=?, _children, ) => {}"), RPsiLet.class);
        assertNoParserError(e);

        RPsiFunction function = (RPsiFunction) e.getBinding().getFirstChild();
        assertSize(10, function.getParameters());
        assertEmpty(PsiTreeUtil.findChildrenOfType(e, RPsiTernary.class));
    }

    @Test
    public void test_parameters_named_symbols3() {
        RPsiLet e = firstOfType(parseCode("let fn = (~a:t, ~b=2, ~c) => ();"), RPsiLet.class);
        assertNoParserError(e);

        RPsiFunction function = (RPsiFunction) e.getBinding().getFirstChild();
        assertSize(3, function.getParameters());
    }

    @Test
    public void test_paren_function() {
        RPsiLet e = firstOfType(parseCode("let _ = (x,y) => x + y"), RPsiLet.class);
        assertNoParserError(e);

        assertTrue(e.isFunction());
        RPsiFunction function = e.getFunction();

        assertSize(2, function.getParameters());
        assertEquals("x", first(function.getParameters()).getText());
        assertEquals("y", second(function.getParameters()).getText());
        assertEquals("x + y", function.getBody().getText());
    }

    @Test
    public void test_unit_function() {
        RPsiLet e = firstOfType(parseCode("let _ = () => 1"), RPsiLet.class);
        assertNoParserError(e);

        assertTrue(e.isFunction());
        RPsiFunction function = e.getFunction();

        assertSize(0, function.getParameters());
        assertEquals("1", function.getBody().getText());
    }

    @Test
    public void test_parameters_LIdent() {
        RPsiLet e = firstOfType(parseCode("let make = (id, values, children) => null;"), RPsiLet.class);
        assertNoParserError(e);

        RPsiFunction function = (RPsiFunction) e.getBinding().getFirstChild();
        List<RPsiParameterDeclaration> parameters = new ArrayList<>(function.getParameters());
        assertSize(3, parameters);

        assertEquals("id", parameters.get(0).getName());
        assertEquals("values", parameters.get(1).getName());
        assertEquals("children", parameters.get(2).getName());
    }

    @Test
    public void test_record_function() {
        RPsiLet e = firstOfType(parseCode("let make = (children) => { ...component, render: self => <div/>, }"), RPsiLet.class);
        assertNoParserError(e);

        RPsiFunctionBody body = e.getFunction().getBody();
        RPsiFunction innerFunction = PsiTreeUtil.findChildOfType(body, RPsiFunction.class);

        assertSize(1, innerFunction.getParameters());
        assertEquals("self", first(innerFunction.getParameters()).getName());
        assertEquals("<div/>", innerFunction.getBody().getText());
    }

    @Test
    public void test_underscore() {
        RPsiLet e = firstOfType(parseCode("let onCancel = _ => setUpdatedAttribute(_ => initialAttribute)"), RPsiLet.class);
        assertNoParserError(e);

        assertTrue(e.isFunction());
        RPsiFunction f1 = e.getFunction();
        assertSize(1, f1.getParameters());
        assertEquals("setUpdatedAttribute(_ => initialAttribute)", f1.getBody().getText());
        assertEquals("_ => setUpdatedAttribute(_ => initialAttribute)", e.getBinding().getText());
        RPsiFunctionCall call = PsiTreeUtil.findChildOfType(e.getBinding(), RPsiFunctionCall.class);
        RPsiParameterReference callParam = call.getParameters().get(0);
        RPsiFunction f2 = PsiTreeUtil.findChildOfType(callParam, RPsiFunction.class);
        assertSize(1, f2.getParameters());
        assertEquals("initialAttribute", f2.getBody().getText());
    }

    @Test
    public void test_first_class_module() {
        RPsiFunction e = firstOfType(parseCode("let make = (~selectors: module(SelectorsIntf)=module(Selectors)) => {}"), RPsiFunction.class);
        assertNoParserError(e);

        RPsiParameterDeclaration p0 = e.getParameters().get(0);
        RPsiSignature s = p0.getSignature();
        RPsiSignatureItem s0 = s.getItems().get(0);
        assertEquals("module(SelectorsIntf)", s0.getText());
        assertNull(PsiTreeUtil.findChildOfType(s, RPsiInnerModule.class));
        assertSize(2, PsiTreeUtil.findChildrenOfType(p0, RPsiModuleValue.class));
        assertEquals("module(Selectors)", p0.getDefaultValue().getText());
        assertNull(ORUtil.findImmediateFirstChildOfType(PsiTreeUtil.findChildOfType(s0, RPsiModuleValue.class), myTypes.A_VARIANT_NAME));
    }

    @Test
    public void test_signature() {
        RPsiFunction e = firstOfType(parseCode("let _ = (~p: (option(string), option(int)) => unit) => p;"), RPsiFunction.class);
        assertNoParserError(e);

        RPsiParameterDeclaration p0 = e.getParameters().get(0);
        assertEquals("(option(string), option(int)) => unit", p0.getSignature().getText());
        //assertEquals("option(string)", p0.getSignature().getItems().get(0).getText());       TODO
        //assertEquals("option(int)", p0.getSignature().getItems().get(1).getText());
        //assertEquals("unit", p0.getSignature().getItems().get(2).getText());
    }

    @Test
    public void test_curry_uncurry() {
        RPsiFunction e = firstOfType(parseCode("let fn = p => (. p1) => p + p1"), RPsiFunction.class);
        assertNoParserError(e);

        assertEquals("p", e.getParameters().get(0).getText());
        assertEquals("(. p1) => p + p1", e.getBody().getText());
    }

    @Test
    public void test_rollback_01() {
        RPsiFunction f = firstOfType(parseCode("let _ = { let x = 1\n let y = 2\n () => 3 }"), RPsiFunction.class); // test infinite rollback
        assertNoParserError(f);

        assertEquals("() => 3", f.getText());
    }

    @Test
    public void test_rollback_02() {
        List<RPsiFunction> es = childrenOfType(parseCode("let _ = (() => 1, () => 2);"), RPsiFunction.class); // test infinite rollback

        assertEquals("() => 1", es.get(0).getText());
        assertEquals("() => 2", es.get(1).getText());
    }

    @Test
    public void test_rollback_03() {
        RPsiInnerModule e = firstOfType(parseCode("module M: I with type t = t = {" +
                " let fn = p => (. p1) => { let _ = a let _ = x => x } " +
                "}"), RPsiInnerModule.class);
        assertNoParserError(e);

        assertSize(1, e.getConstraints());
        RPsiFunction f = PsiTreeUtil.findChildOfType(e, RPsiFunction.class);
        assertEquals("p", f.getParameters().get(0).getText());
        assertEquals("(. p1) => { let _ = a let _ = x => x }", f.getBody().getText());
    }

    @Test
    public void test_rollback_04() {
        RPsiFunction e = firstOfType(parseCode("let fn = () => { let _ = 1\n (x) => 2 }"), RPsiFunction.class);
        assertNoParserError(e);
        assertEquals("{ let _ = 1\n (x) => 2 }", e.getBody().getText());
    }

    @Test
    public void test_in_Some() {
        RPsiSwitch e = firstOfType(parseCode("let _ = switch (a, b) { | (Some(_), None) => Some((. ()) => 1) | (_, _) => None }"), RPsiSwitch.class);
        assertNoParserError(e);

        assertSize(2, e.getPatterns());
        RPsiFunction f = PsiTreeUtil.findChildOfType(e, RPsiFunction.class);
        assertEquals("(. ()) => 1", f.getText());
    }

    @Test
    public void test_x() {
        RPsiLet e = firstOfType(parseCode("\n" +
                "  let _ = (. s) =>\n" +
                "    memoize2(\n" +
                "      x,\n" +
                "      fnCall(. s),\n" +
                "      ((\n" +
                "        types,\n" +
                "        aMap: Belt.Map.String.t<array<MyMod.Function.t>>,\n" +
                "      )) => {\n" +
                "        types\n" +
                "        ->Belt.List.sort((type1, type2) => compare(type1.value, type2.value))\n" +
                "      },\n" +
                "    )\n"), RPsiLet.class);

        assertNoParserError(e);
        RPsiFunctionCall efc = (RPsiFunctionCall) e.getFunction().getBody().getFirstChild();
        assertEquals("memoize2", efc.getName());
        assertSize(3, efc.getParameters());

        // TODO assertDoesntContain(collection, myTypes.A_LOWER_TAG_NAME);
    }

    @Test
    public void test_ternary() {
        RPsiFunction e = firstOfType(parseCode("let fn = (p) => p == true ? Time.H12 : Time.H24\nMod.fn()"), RPsiFunction.class);

        assertNoParserError(e);
        RPsiTernary et = PsiTreeUtil.findChildOfType(e, RPsiTernary.class);
        assertEquals("p == true", et.getCondition().getText());
        assertEquals("Time.H12", et.getThenExpression().getText());
        assertEquals("Time.H24", et.getElseExpression().getText());
    }

    @Test
    public void test_current() {
        FileBase code = parseCode("let _ = () => { v.current = () => fn(p) }");

        RPsiLet e = firstOfType(code, RPsiLet.class);
        assertNoParserError(e);

        List<RPsiFunction> efs = childrenOfType(code, RPsiFunction.class);
        assertEquals("() => { v.current = () => fn(p) }", efs.get(0).getText());
        assertEquals("() => fn(p)", efs.get(1).getText());
    }

    // https://github.com/giraud/reasonml-idea-plugin/issues/113
    @Test
    public void test_GH_113() {
        RPsiFunction e = firstOfType(parseCode("let x = () => switch isBuggy() { | _ => \"buggy\" }"), RPsiFunction.class);
        assertNoParserError(e);

        assertSize(0, e.getParameters());
        RPsiFunctionBody b = e.getBody();
        assertInstanceOf(b.getFirstChild(), RPsiSwitch.class);
        RPsiSwitch s = (RPsiSwitch) b.getFirstChild();
        assertEquals("isBuggy()", s.getCondition().getText());
    }
}
