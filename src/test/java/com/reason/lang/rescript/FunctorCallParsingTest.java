package com.reason.lang.rescript;

import com.intellij.psi.*;
import com.intellij.psi.util.*;
import com.reason.lang.core.psi.*;
import com.reason.lang.core.psi.impl.*;
import org.junit.*;

import java.util.*;

@SuppressWarnings("ConstantConditions")
public class FunctorCallParsingTest extends ResParsingTestCase {
    @Test
    public void test_instantiation() {
        RPsiInnerModule e = first(moduleExpressions(parseCode("module Printing = Make({ let encode = encode_record })")));

        assertTrue(e.isFunctorCall());
        RPsiFunctorCall call = PsiTreeUtil.findChildOfType(e, RPsiFunctorCall.class);
        assertEquals("Make({ let encode = encode_record })", call.getText());
        assertEquals(myTypes.A_MODULE_NAME, call.getNavigationElement().getNode().getElementType());
        assertSize(1, call.getParameters());
        assertEquals("{ let encode = encode_record }", call.getParameters().iterator().next().getText());
        RPsiLet let = PsiTreeUtil.findChildOfType(e, RPsiLet.class);
        assertEquals("Dummy.Printing.Make[0].encode", let.getQualifiedName());
    }

    @Test
    public void test_with_path() {
        RPsiInnerModule e = first(moduleExpressions(parseCode("module X = A.B.Make({})")));

        assertTrue(e.isFunctorCall());
        RPsiFunctorCall call = PsiTreeUtil.findChildOfType(e, RPsiFunctorCall.class);
        assertEquals("Make({})", call.getText());
    }

    @Test
    public void test_chaining() {
        PsiFile file = parseCode("module KeyTable = Hashtbl.Make(KeyHash)\n type infos");
        List<PsiNamedElement> es = new ArrayList<>(expressions(file));

        assertEquals(2, es.size());

        RPsiInnerModule module = (RPsiInnerModule) es.get(0);
        assertTrue(module.isFunctorCall());
        RPsiFunctorCall call = PsiTreeUtil.findChildOfType(module, RPsiFunctorCall.class);
        assertNotNull(call);
        assertEquals("Make(KeyHash)", call.getText());
    }
}
