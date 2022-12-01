package com.reason.ide.reference;

import com.intellij.psi.*;
import com.reason.ide.*;
import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;

@RunWith(JUnit4.class)
public class ResolveJsxPropertyElementRESTest extends ORBasePlatformTestCase {
    @Test
    public void test_basic() {
        configureCode("X.res", "let make = (~value) => <div/>");
        configureCode("A.res", "<X value<caret> =1></X>");

        PsiElement e = myFixture.getElementAtCaret();
        assertEquals("X.make[value]", ((PsiQualifiedNamedElement) e).getQualifiedName());
    }

    @Test
    public void test_basic_multiple_props() {
        configureCode("X.res", "let make = (~propA, ~propB, ~propC) => <div/>");
        configureCode("A.res", "<X propA propB propC<caret> />");

        PsiElement e = myFixture.getElementAtCaret();
        assertEquals("X.make[propC]", ((PsiQualifiedNamedElement) e).getQualifiedName());
    }

    @Test
    public void test_basic_nested() {
        configureCode("A.res", "module X = { let make = (~value) => <div/>; }; <X value<caret> =1></X>");

        PsiElement e = myFixture.getElementAtCaret();
        assertEquals("A.X.make[value]", ((PsiQualifiedNamedElement) e).getQualifiedName());
    }

    @Test
    public void test_autoclose() {
        configureCode("X.res", "let make = (~value) => <div/>");
        configureCode("A.res", "<X value<caret> =1/>");

        PsiElement e = myFixture.getElementAtCaret();
        assertEquals("X.make[value]", ((PsiQualifiedNamedElement) e).getQualifiedName());
    }

    @Test
    public void test_open() {
        configureCode("A.res", "module X = { let make = (~value) => <div/>; }");
        configureCode("B.res", "open A; <X value<caret>=1");

        PsiElement e = myFixture.getElementAtCaret();
        assertEquals("A.X.make[value]", ((PsiQualifiedNamedElement) e).getQualifiedName());
    }

    @Test
    public void test_multiple() {
        configureCode("A.res", "module X = { let make = (~value) => <div/> }\n module Y = { let make = (~value) => <div/> }");
        configureCode("B.res", "open A; <X value<caret>=1");

        PsiElement e = myFixture.getElementAtCaret();
        assertEquals("A.X.make[value]", ((PsiQualifiedNamedElement) e).getQualifiedName());
    }

    @Test
    public void test_make_make() {
        configureCode("A.res", "module X = { let make = (~value) => <div/> }\n let make = (~value) => <X value<caret> = 1>");

        PsiElement e = myFixture.getElementAtCaret();
        assertEquals("A.X.make[value]", ((PsiQualifiedNamedElement) e).getQualifiedName());
    }
}
