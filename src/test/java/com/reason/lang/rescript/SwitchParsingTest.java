package com.reason.lang.rescript;

import com.intellij.psi.*;
import com.intellij.psi.util.*;
import com.reason.ide.files.*;
import com.reason.lang.core.*;
import com.reason.lang.core.psi.*;
import com.reason.lang.core.psi.impl.*;
import org.junit.*;

import java.util.*;

@SuppressWarnings("ConstantConditions")
public class SwitchParsingTest extends ResParsingTestCase {
    @Test
    public void test_pattern_variant() {
        FileBase f = parseCode("switch x { | Variant1(x) => x\n () | Variant2 => () }");

        assertEquals(1, childrenCount(f));
        RPsiSwitch switch_ = first(PsiTreeUtil.findChildrenOfType(f, RPsiSwitch.class));
        assertNotNull(switch_);

        RPsiBinaryCondition condition = ORUtil.findImmediateFirstChildOfClass(switch_, RPsiBinaryCondition.class);
        assertEquals("x", condition.getText());

        List<RPsiPatternMatch> patterns = switch_.getPatterns();
        assertSize(2, patterns);

        assertEmpty(PsiTreeUtil.findChildrenOfType(switch_, RPsiVariantDeclaration.class));

        // first pattern
        RPsiPatternMatch p1 = patterns.get(0);
        assertEquals("Variant1(x) => x\n ()", p1.getText());
        RPsiPatternMatchBody p1Body = p1.getBody();
        assertEquals("x\n ()", p1Body.getText());
        // assertNotNull(ORUtil.findImmediateFirstChildOfClass(p1Body, RPsiUnit.class));

        // second pattern
        RPsiPatternMatch p2 = patterns.get(1);
        assertEquals("Variant2 => ()", p2.getText());
        RPsiPatternMatchBody p2Body = p2.getBody();
        assertEquals("()", p2Body.getText());
        // assertNotNull(ORUtil.findImmediateFirstChildOfClass(p1Body, RPsiUnit.class));
    }

    @Test
    public void test_pattern_option() {
        FileBase f = parseCode("switch x { | Some(x) => x\n () | None => () }");

        assertEquals(1, childrenCount(f));
        RPsiSwitch switch_ = first(PsiTreeUtil.findChildrenOfType(f, RPsiSwitch.class));
        assertNotNull(switch_);

        RPsiBinaryCondition condition = switch_.getCondition();
        assertEquals("x", condition.getText());

        List<RPsiPatternMatch> patterns = switch_.getPatterns();
        assertSize(2, patterns);

        assertEmpty(PsiTreeUtil.findChildrenOfType(switch_, RPsiVariantDeclaration.class));

        // first pattern
        RPsiPatternMatch p1 = patterns.get(0);
        RPsiPatternMatchBody p1Body = p1.getBody();
        assertEquals("x\n ()", p1Body.getText());
        // assertNotNull(ORUtil.findImmediateFirstChildOfClass(p1Body, RPsiUnit.class));

        // second pattern
        RPsiPatternMatch p2 = patterns.get(1);
        RPsiPatternMatchBody p2Body = p2.getBody();
        assertEquals("()", p2Body.getText());
        // assertNotNull(ORUtil.findImmediateFirstChildOfClass(p2Body, RPsiUnit.class));
    }

    @Test
    public void test_pattern_token_type() {
        PsiFile psiFile = parseCode("switch action { | Incr => counter + 1 }");

        RPsiSwitch switch_ = first(PsiTreeUtil.findChildrenOfType(psiFile, RPsiSwitch.class));
        Collection<RPsiPatternMatch> patterns = PsiTreeUtil.findChildrenOfType(switch_, RPsiPatternMatch.class);
        assertSize(1, patterns);
        RPsiPatternMatch psiPatternMatch = patterns.iterator().next();
        RPsiPatternMatch patternMatch = patterns.iterator().next();
        RPsiUpperSymbol variant = ORUtil.findImmediateFirstChildOfClass(patternMatch, RPsiUpperSymbol.class);
        // assertTrue(variant.isVariant());
        assertEquals("Incr", variant.getText());
        assertEquals("counter + 1", psiPatternMatch.getBody().getText());
    }

    @Test
    public void test_pattern_match() {
        FileBase f = parseCode("switch p { | Typedtree.Partial => \"Partial\" | Total => \"Total\" }");
        RPsiSwitch e = first(PsiTreeUtil.findChildrenOfType(f, RPsiSwitch.class));

        List<RPsiPatternMatch> patterns = e.getPatterns();
        assertSize(2, patterns);

        RPsiPatternMatch m1 = patterns.get(0);
        assertEquals("Typedtree", PsiTreeUtil.findChildOfType(m1, RPsiUpperSymbol.class).getText());
        assertEquals("\"Partial\"", m1.getBody().getText());

        RPsiPatternMatch m2 = patterns.get(1);
        assertEquals("\"Total\"", m2.getBody().getText());
    }

    @Test
    public void test_pattern_match_2() {
        FileBase f = parseCode("let greeting = name => switch name { | FirstName(fn) => \"hello \" ++ fn | LastName(ln) => \"hello \" ++ ln }");
        RPsiSwitch e = first(PsiTreeUtil.findChildrenOfType(f, RPsiSwitch.class));

        List<RPsiPatternMatch> patterns = e.getPatterns();
        assertSize(2, patterns);
    }

    @Test
    public void test_let() {
        RPsiLet e = firstOfType(parseCode("let makeId = () => switch id { | None => text | Some(i) => i }"), RPsiLet.class);

        RPsiFunction function = e.getFunction();
        assertEquals("switch id { | None => text | Some(i) => i }", function.getBody().getText());
    }

    @Test
    public void test_react() {
        FileBase psiFile = parseCode("switch reasonStateUpdate { | NoUpdate => (None, curTotalState) | Update(nextReasonState) => (None, {\"reasonState\": nextReasonState}) }");

        assertEquals(1, childrenCount(psiFile));
        RPsiSwitch e = (RPsiSwitch) psiFile.getChildren()[0];

        assertEquals("reasonStateUpdate", e.getCondition().getText());
        assertSize(2, e.getPatterns());
    }

    @Test
    public void test_tuple() {
        RPsiSwitch e = firstOfType(parseCode("switch (a, b, c) { | (None, Some(x), _) => do(. z) | (_, _, _) => let x = 1\n () }"), RPsiSwitch.class);

        List<RPsiPatternMatch> patterns = e.getPatterns();
        assertSize(2, patterns);
        assertEquals("(None, Some(x), _) => do(. z)", patterns.get(0).getText());
        assertEquals("(_, _, _) => let x = 1\n ()", patterns.get(1).getText());
    }

    @Test
    public void test_switch_of_switch() {
        RPsiSwitch e = firstOfType(parseCode("switch a { | None => switch b { | X => 1 | Y => 2 } | Some => 3 }"), RPsiSwitch.class);

        List<RPsiPatternMatch> patterns = e.getPatterns();
        assertSize(2, patterns);
        assertEquals("None => switch b { | X => 1 | Y => 2 }", patterns.get(0).getText());
        assertEquals("Some => 3", patterns.get(1).getText());
        RPsiSwitch inner = PsiTreeUtil.findChildOfType(patterns.get(0), RPsiSwitch.class);
        assertSize(2, inner.getPatterns());
    }

    @Test
    public void test_group() {
        RPsiSwitch e = firstOfType(parseCode("switch x { | V1(y) => Some(y) | V2(_) | Empty | Unknown => None }"), RPsiSwitch.class);

        List<RPsiPatternMatch> patterns = e.getPatterns();
        assertSize(4, patterns);
        assertEquals("V1(y) => Some(y)", patterns.get(0).getText());
        assertEquals("V2(_)", patterns.get(1).getText());
        assertEquals("Empty", patterns.get(2).getText());
        assertEquals("Unknown => None", patterns.get(3).getText());
    }

    @Test
    public void test_guard() {
        RPsiSwitch e = firstOfType(parseCode("let _ = switch x { | M1 if x == 1 => 2 | _ => 3 }"), RPsiSwitch.class);

        assertNoParserError(e);
        assertSize(2, e.getPatterns());
        assertEquals("2", e.getPatterns().get(0).getBody().getText());
        assertEquals("3", e.getPatterns().get(1).getBody().getText());
    }

    // https://github.com/giraud/reasonml-idea-plugin/issues/275
    @Test
    public void test_GH_275() {
        RPsiFunction e = firstOfType(parseCode("items->Belt.Array.map(i => switch (i: t) { | Value => 1 })"), RPsiFunction.class);

        assertEquals("i => switch (i: t) { | Value => 1 }", e.getText());
        RPsiSwitch s = (RPsiSwitch) e.getBody().getFirstChild();
        assertEquals("(i: t)", s.getCondition().getText());
        assertEquals("Value => 1", s.getPatterns().get(0).getText());
    }

    @Test
    public void test_GH_275b() {
        RPsiSwitch e = firstOfType(parseCode("switch (a, b) { | (Some(a'), Some(b')) => let _ = switch x { | None => None } }"), RPsiSwitch.class);

        assertEquals("switch (a, b) { | (Some(a'), Some(b')) => let _ = switch x { | None => None } }", e.getText());
        assertEquals("let _ = switch x { | None => None }", e.getPatterns().get(0).getBody().getText());
    }
}
