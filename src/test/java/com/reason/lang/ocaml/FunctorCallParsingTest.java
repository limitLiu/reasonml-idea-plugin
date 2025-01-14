package com.reason.lang.ocaml;

import com.intellij.psi.*;
import com.intellij.psi.util.*;
import com.reason.lang.core.psi.*;
import com.reason.lang.core.psi.impl.*;
import org.junit.*;

import java.util.*;

@SuppressWarnings("ConstantConditions")
public class FunctorCallParsingTest extends OclParsingTestCase {
    @Test
    public void test_instantiation() {
        RPsiInnerModule e = first(moduleExpressions(parseCode("module Printing = Make(struct let encode = encode_record end)")));

        assertTrue(e.isFunctorCall());
        RPsiFunctorCall call = PsiTreeUtil.findChildOfType(e, RPsiFunctorCall.class);
        assertEquals("Make(struct let encode = encode_record end)", call.getText());
        assertEquals(myTypes.A_MODULE_NAME, call.getNavigationElement().getNode().getElementType());
        assertSize(1, call.getParameters());
        assertEquals("struct let encode = encode_record end", call.getParameters().iterator().next().getText());
        RPsiLet let = PsiTreeUtil.findChildOfType(e, RPsiLet.class);
        assertEquals("Dummy.Printing.Make[0].encode", let.getQualifiedName());
    }

    @Test
    public void test_parens() {
        RPsiFunctorCall e = firstOfType(parseCode("module EHashtbl = Make(struct let equal = (==) end)"), RPsiFunctorCall.class);

        assertNoParserError(e);
        assertSize(1, e.getParameters());
        assertEquals("Make(struct let equal = (==) end)", e.getText());
    }

    @Test
    public void test_let_operator() {
        RPsiFunctorCall e = firstOfType(parseCode("include Monad.Make(struct let (>>) a k = (); fun () -> a (); k () end)"), RPsiFunctorCall.class);

        assertNoParserError(e);
        assertSize(1, e.getParameters());
        assertEquals("struct let (>>) a k = (); fun () -> a (); k () end", e.getParameters().get(0).getText());
    }

    @Test
    public void test_functor_instanciation_chaining() {
        PsiFile file = parseCode("module KeyTable = Hashtbl.Make(KeyHash)\ntype infos");
        List<PsiNamedElement> es = new ArrayList<>(expressions(file));

        assertEquals(2, es.size());

        RPsiInnerModule module = (RPsiInnerModule) es.get(0);
        assertTrue(module.isFunctorCall());
        RPsiFunctorCall call = PsiTreeUtil.findChildOfType(module, RPsiFunctorCall.class);
        assertEquals("Make(KeyHash)", call.getText());
        assertEquals("Make", call.getName());
        assertNull(PsiTreeUtil.findChildOfType(module, RPsiParameterDeclaration.class));
    }
}
