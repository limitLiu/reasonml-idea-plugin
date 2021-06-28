package com.reason.lang.rescript;

import com.reason.lang.core.psi.*;

public class ExceptionParsingTest extends ResParsingTestCase {
    public void test_basic() {
        PsiException e = firstOfType(parseCode("exception Ex"), PsiException.class);

        assertEquals("Ex", e.getName());
        assertEquals("Dummy.Ex", e.getQualifiedName());
    }

    public void test_parameter() {
        PsiException e = firstOfType(parseCode("exception Ex(string)"), PsiException.class);

        assertEquals("Ex", e.getName());
        assertEquals("Dummy.Ex", e.getQualifiedName());
    }
}
