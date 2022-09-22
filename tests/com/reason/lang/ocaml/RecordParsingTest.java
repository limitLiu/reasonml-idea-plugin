package com.reason.lang.ocaml;

import com.intellij.psi.util.*;
import com.reason.lang.core.psi.*;
import com.reason.lang.core.psi.impl.*;
import org.junit.*;

import java.util.*;

@SuppressWarnings("ConstantConditions")
public class RecordParsingTest extends OclParsingTestCase {
    @Test
    public void test_declaration() {
        PsiType e = first(typeExpressions(parseCode("type r = { a: int; b: string list }")));
        PsiRecord record = (PsiRecord) e.getBinding().getFirstChild();

        List<RPsiRecordField> fields = record.getFields();
        assertEquals("a", fields.get(0).getName());
        assertEquals("int", fields.get(0).getSignature().asText(getLangProps()));
        assertEquals("b", fields.get(1).getName());
        assertEquals("string list", fields.get(1).getSignature().asText(getLangProps()));
    }

    @Test
    public void test_usage() {
        PsiLet e = first(letExpressions(parseCode("let r = { a = 1; b = 2; c = 3 }")));
        PsiRecord record = (PsiRecord) e.getBinding().getFirstChild();

        List<RPsiRecordField> fields = new ArrayList<>(record.getFields());
        assertSize(3, fields);
        assertEquals("a", fields.get(0).getName());
        assertNull(fields.get(0).getSignature());
        assertEquals("b", fields.get(1).getName());
        assertNull(fields.get(1).getSignature());
        assertEquals("c", fields.get(2).getName());
        assertNull(fields.get(2).getSignature());
    }

    @Test
    public void test_usage_deep() {
        PsiLet e = first(letExpressions(parseCode("let r = { a = [| 1; 2 |]; b = { b1 = { b11 = 3 } }; c = 4 }")));
        PsiRecord record = (PsiRecord) e.getBinding().getFirstChild();

        List<RPsiRecordField> fields = new ArrayList<>(record.getFields());
        assertSize(3, fields);
        assertEquals("a", fields.get(0).getName());
        assertEquals("b", fields.get(1).getName());
        assertEquals("c", fields.get(2).getName());

        List<RPsiRecordField> allFields = new ArrayList<>(PsiTreeUtil.findChildrenOfType(fields.get(1), RPsiRecordField.class));
        assertEquals("b1", allFields.get(0).getName());
        assertEquals("b11", allFields.get(1).getName());
    }

    //public void test_mixin() {   zzz
    //    PsiLet let = first(letExpressions(parseCode("let x = { component with otherField = 1 }")));
    //
    //    PsiRecord record = (PsiRecord) let.getBinding().getFirstChild();
    //    RPsiRecordField field = record.getFields().iterator().next();
    //    assertEquals(field.getName(), "otherField");
    //}

    //public void test_annotations() {
    //    PsiType e = first(typeExpressions(parseCode("type props = { [@bs.optional] key: string, [@bs.optional] [@bs.as \"aria-label\"] ariaLabel: string, };")));
    //    PsiRecord record = (PsiRecord) e.getBinding().getFirstChild();
    //
    //    List<RPsiRecordField> fields = new ArrayList<>(record.getFields());
    //    assertSize(2, fields);
    //    assertEquals("key", fields.get(0).getName());
    //    assertEquals("ariaLabel", fields.get(1).getName());
    //}
}
