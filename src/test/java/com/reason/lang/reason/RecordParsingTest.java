package com.reason.lang.reason;

import com.intellij.psi.util.*;
import com.reason.lang.core.psi.*;
import com.reason.lang.core.psi.impl.*;
import org.junit.*;

import java.util.*;

@SuppressWarnings("ConstantConditions")
public class RecordParsingTest extends RmlParsingTestCase {
    @Test
    public void test_declaration() {
        RPsiType e = first(typeExpressions(parseCode("type r = { a: int, b: option(string) };")));
        RPsiRecord record = (RPsiRecord) e.getBinding().getFirstChild();

        List<RPsiRecordField> fields = record.getFields();
        assertEquals("a", fields.get(0).getName());
        assertEquals("int", fields.get(0).getSignature().asText(getLangProps()));
        assertEquals("b", fields.get(1).getName());
        assertEquals("option(string)", fields.get(1).getSignature().asText(getLangProps()));
    }

    @Test
    public void test_usage() {
        RPsiLet e = firstOfType(parseCode("let r = { a: 1, b: 2, c: 3, };"), RPsiLet.class);
        RPsiRecord record = (RPsiRecord) e.getBinding().getFirstChild();

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
    public void test_usage_with_sig() {
        RPsiLet e = firstOfType(parseCode("let r: M.t = { a: 1, b: 2, c: 3, };"), RPsiLet.class);
        RPsiRecord record = (RPsiRecord) e.getBinding().getFirstChild();

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
        RPsiLet e = firstOfType(parseCode("let r = { a: [| 1, 2 |], b: { b1: { b11: 3 } }, c: 4 };"), RPsiLet.class);
        RPsiRecord record = (RPsiRecord) e.getBinding().getFirstChild();

        List<RPsiRecordField> fields = new ArrayList<>(record.getFields());
        assertSize(3, fields);
        assertEquals("a", fields.get(0).getName());
        assertEquals("b", fields.get(1).getName());
        assertEquals("c", fields.get(2).getName());

        List<RPsiRecordField> allFields = new ArrayList<>(PsiTreeUtil.findChildrenOfType(fields.get(1), RPsiRecordField.class));
        assertEquals("b1", allFields.get(0).getName());
        assertEquals("b11", allFields.get(1).getName());
    }

    @Test
    public void test_mixin() {
        RPsiLet let = firstOfType(parseCode("let x = {...component, otherField: 1};"), RPsiLet.class);

        RPsiRecord record = (RPsiRecord) let.getBinding().getFirstChild();
        RPsiRecordField field = record.getFields().iterator().next();
        assertEquals("otherField", field.getName());
    }

    @Test
    public void test_annotations() {
        RPsiType e = first(typeExpressions(parseCode("type props = { [@bs.optional] key: string, [@bs.optional] [@bs.as \"aria-label\"] ariaLabel: string, };")));
        RPsiRecord record = (RPsiRecord) e.getBinding().getFirstChild();

        List<RPsiRecordField> fields = new ArrayList<>(record.getFields());
        assertSize(2, fields);
        assertEquals("key", fields.get(0).getName());
        assertEquals("ariaLabel", fields.get(1).getName());
    }

    @Test
    public void test_inside_module() {
        RPsiInnerModule e = firstOfType(parseCode("module M = { let _ = (x) => { ...x, }; };"), RPsiInnerModule.class);

        RPsiFunction ef = PsiTreeUtil.findChildOfType(e, RPsiFunction.class);
        assertEquals("{ ...x, }", ef.getBody().getText());
        assertEquals("{ let _ = (x) => { ...x, }; }", e.getBody().getText());
    }
}
