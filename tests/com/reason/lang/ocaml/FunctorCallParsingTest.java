package com.reason.lang.ocaml;

import com.intellij.psi.*;
import com.intellij.psi.tree.*;
import com.intellij.psi.util.*;
import com.reason.lang.core.psi.PsiParameter;
import com.reason.lang.core.psi.*;
import com.reason.lang.core.psi.impl.*;

import java.util.*;
import java.util.stream.*;

@SuppressWarnings("ConstantConditions")
public class FunctorCallParsingTest extends OclParsingTestCase {
    public void test_instantiation() {
        PsiInnerModule e = (PsiInnerModule) first(moduleExpressions(parseCode("module Printing = Make(struct let encode = encode_record end)")));

        assertTrue(e.isFunctorCall());
        assertNull(e.getBody());
        PsiFunctorCall call = PsiTreeUtil.findChildOfType(e, PsiFunctorCall.class);
        assertEquals("Make(struct let encode = encode_record end)", call.getText());
        assertSize(1, call.getParameters());
        assertEquals("struct let encode = encode_record end", call.getParameters().iterator().next().getText());
        PsiLet let = PsiTreeUtil.findChildOfType(e, PsiLet.class);
        assertEquals("Dummy.Printing.Make[0].encode", let.getQualifiedName());
    }

    public void test_functor_instanciation_chaining() {
        PsiFile e = parseCode("module KeyTable = Hashtbl.Make(KeyHash)\ntype infos");
        List<PsiNamedElement> expressions = new ArrayList<>(expressions(e));

        assertEquals(2, expressions.size());

        PsiInnerModule module = (PsiInnerModule) expressions.get(0);
        PsiFunctorCall call = PsiTreeUtil.findChildOfType(e, PsiFunctorCall.class);
        assertNotNull(call);
        assertEquals("Hashtbl.Make(KeyHash)", call.getText());
    }
}
