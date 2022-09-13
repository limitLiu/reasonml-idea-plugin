package com.reason.lang.rescript;

import com.intellij.psi.util.*;
import com.reason.ide.files.*;
import com.reason.lang.core.*;
import com.reason.lang.core.psi.*;
import com.reason.lang.core.psi.impl.*;
import org.junit.*;

import java.util.*;

@SuppressWarnings("ConstantConditions")
public class FunctionCallParsingTest extends ResParsingTestCase {
    @Test
    public void test_call() {
        PsiLet e = first(letExpressions(parseCode("let _ = string_of_int(1)")));

        PsiFunctionCall call = PsiTreeUtil.findChildOfType(e, PsiFunctionCall.class);
        assertNotNull(ORUtil.findImmediateFirstChildOfClass(call, PsiLowerSymbol.class));
        assertNull(PsiTreeUtil.findChildOfType(e, PsiParameterDeclaration.class));
        assertEquals("string_of_int(1)", call.getText());
        assertEquals(1, call.getParameters().size());
    }

    @Test
    public void test_call2() {
        PsiLet e = first(letExpressions(parseCode("let _ = Belt.Option.map(self.state.timerId.contents, Js.Global.clearInterval)")));

        PsiFunctionCall call = PsiTreeUtil.findChildOfType(e.getBinding(), PsiFunctionCall.class);
        List<PsiParameterReference> parameters = call.getParameters();
        assertEquals(2, parameters.size());
        assertEquals("self.state.timerId.contents", parameters.get(0).getText());
        assertEquals("Js.Global.clearInterval", parameters.get(1).getText());
    }

    @Test
    public void test_call3() {
        PsiLet e = first(letExpressions(parseCode("let _ = subscriber->Topic.unsubscribe()")));

        PsiFunctionCall call = PsiTreeUtil.findChildOfType(e.getBinding(), PsiFunctionCall.class);
        assertEmpty(call.getParameters());
    }

    @Test
    public void test_end_comma() {
        PsiLet e = first(letExpressions(parseCode("let _ = style([ color(red), ])")));

        assertEquals("style([ color(red), ])", e.getBinding().getText());
        PsiFunctionCall f = PsiTreeUtil.findChildOfType(e.getBinding(), PsiFunctionCall.class);
        assertNull(PsiTreeUtil.findChildOfType(f, PsiDeconstruction.class));
        assertSize(1, f.getParameters());
    }

    @Test
    public void test_unit_last() {
        PsiLet e = first(letExpressions(parseCode("let _ = f(1, ())")));

        PsiFunctionCall call = PsiTreeUtil.findChildOfType(e, PsiFunctionCall.class);
        assertSize(2, call.getParameters());
    }

    @Test
    public void test_optional_param() {
        PsiFunctionCall e = firstOfType(parseCode("let _ = fn(~margin?, ())"), PsiFunctionCall.class);
        assertSize(2, e.getParameters());
        assertEquals("~margin?", e.getParameters().get(0).getText());
        assertEquals("()", e.getParameters().get(1).getText());
    }

    @Test
    public void test_inner_parenthesis() {
        PsiLet e = first(letExpressions(parseCode("let _ = f(a, (b, c))")));

        PsiFunctionCall call = PsiTreeUtil.findChildOfType(e, PsiFunctionCall.class);
        assertSize(2, call.getParameters());
        PsiParameterReference p1 = call.getParameters().get(1);
        assertEquals("(b, c)", p1.getText());
        assertNull(PsiTreeUtil.findChildOfType(p1, PsiParameters.class));
        assertNull(PsiTreeUtil.findChildOfType(p1, PsiParameterReference.class));
    }

    @Test
    public void test_params() {
        FileBase f = parseCode("call(~decode=x => Ok(), ~task=() => y)");
        PsiFunctionCall e = ORUtil.findImmediateFirstChildOfClass(f, PsiFunctionCall.class);

        assertSize(2, e.getParameters());
    }

    @Test
    public void test_param_name() {
        List<PsiLet> expressions = letAllExpressions(parseCode("describe(\"context\", () => { test(\"should do something\", () => { let inner = 1 }) })"));
        PsiLet e = first(expressions);

        assertEquals("Dummy.describe[1].test[1].inner", e.getQualifiedName());
    }

    @Test
    public void test_nested_parenthesis() {
        PsiFunctionCall f = firstOfType(parseCode("set(x->keep(((y, z)) => y), xx)"), PsiFunctionCall.class);

        assertEquals("set(x->keep(((y, z)) => y), xx)", f.getText());
        assertEquals("x->keep(((y, z)) => y)", f.getParameters().get(0).getText());
        assertEquals("xx", f.getParameters().get(1).getText());
    }

    @Test
    public void test_body() {
        PsiLet e = first(letExpressions(parseCode("let _ = x => { open M\n {k: v} }")));

        PsiFunctionBody body = PsiTreeUtil.findChildOfType(e, PsiFunctionBody.class);
        assertEquals("{ open M\n {k: v} }", body.getText());
    }

    @Test
    public void test_ternary_in_named_param() {
        PsiFunctionCall e = firstOfType(parseCode("fn(~x=a ? b : c);"), PsiFunctionCall.class);

        assertSize(1, e.getParameters());
        PsiParameterReference p0 = e.getParameters().get(0);
        assertEquals("x", p0.getName());
        assertEquals("a ? b : c", p0.getValue().getText());
        assertInstanceOf(p0.getValue().getFirstChild(), PsiTernary.class);
    }

    @Test
    public void test_assignment() {
        PsiFunctionCall e = firstOfType(parseCode("let _ = fn(x => myRef.current = x)"), PsiFunctionCall.class);

        assertEquals("x => myRef.current = x", e.getParameters().get(0).getText());
    }

    @Test
    public void test_GH_120() {
        PsiLet e = first(letExpressions(parseCode("let _ = f(x == U.I, 1)")));

        PsiFunctionCall call = PsiTreeUtil.findChildOfType(e, PsiFunctionCall.class);
        assertSize(2, call.getParameters());
    }
}
