package com.reason.ide.search.reference;

import com.intellij.psi.util.*;
import com.reason.ide.*;
import com.reason.ide.files.*;
import com.reason.lang.core.*;
import com.reason.lang.core.psi.*;
import com.reason.lang.core.psi.impl.*;
import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;

import java.util.*;

import static java.util.List.*;

@RunWith(JUnit4.class)
public class ORModuleResolutionPsiGistRMLTest extends ORBasePlatformTestCase {
    @Test
    public void test_include_no_resolution() {
        FileBase e = configureCode("A.re", "module A1 = {}; include B.B1;");

        ORModuleResolutionPsiGist.Data data = ORModuleResolutionPsiGist.getData(e);

        RPsiInclude ei = PsiTreeUtil.findChildOfType(e, RPsiInclude.class);
        assertEmpty(data.getElement(ei));
        assertEmpty(data.getElement(e));
    }

    @Test
    public void test_open_no_resolution() {
        FileBase e = configureCode("A.re", "module A1 = {}; open B.B1;");

        ORModuleResolutionPsiGist.Data data = ORModuleResolutionPsiGist.getData(e);

        RPsiInclude ei = PsiTreeUtil.findChildOfType(e, RPsiInclude.class);
        assertEmpty(data.getElement(ei));
        assertEmpty(data.getElement(e));
    }

    @Test
    public void test_include_in_file() {
        FileBase e = configureCode("A.re", "module A1 = { module A2 = {}; }; include A1.A2;");

        ORModuleResolutionPsiGist.Data data = ORModuleResolutionPsiGist.getData(e);

        RPsiInclude ei = PsiTreeUtil.findChildOfType(e, RPsiInclude.class);
        assertOrderedEquals(data.getElement(ei/*A1.A2*/), "A.A1.A2");
        assertOrderedEquals(data.getElement(e/*A.re*/), "A.A1.A2");
    }

    @Test
    public void test_open_in_file() {
        FileBase e = configureCode("A.re", "module A1 = { module A2 = {}; }; open A1.A2;");

        ORModuleResolutionPsiGist.Data data = ORModuleResolutionPsiGist.getData(e);

        RPsiOpen eo = PsiTreeUtil.findChildOfType(e, RPsiOpen.class);
        assertOrderedEquals(data.getElement(eo/*A1.A11*/), "A.A1.A2");
        assertEmpty(data.getElement(e/*A.re*/));
    }

    @Test
    public void test_include_in_file_steps() {
        FileBase e = configureCode("A.re", "module A1 = { module A2 = {}; }; include A1; include A2;");

        ORModuleResolutionPsiGist.Data data = ORModuleResolutionPsiGist.getData(e);

        ArrayList<RPsiInclude> eis = new ArrayList<>(PsiTreeUtil.findChildrenOfType(e, RPsiInclude.class));
        assertOrderedEquals(data.getElement(eis.get(0/*A1*/)), "A.A1");
        assertOrderedEquals(data.getElement(eis.get(1/*A2*/)), "A.A1.A2");
        assertOrderedEquals(data.getElement(e/*A.re*/), "A.A1", "A.A1.A2");
    }

    @Test
    public void test_open_in_file_steps() {
        FileBase e = configureCode("A.re", "module A1 = { module A2 = {}; }; open A1; open A2;");

        ORModuleResolutionPsiGist.Data data = ORModuleResolutionPsiGist.getData(e);

        ArrayList<RPsiOpen> eos = new ArrayList<>(PsiTreeUtil.findChildrenOfType(e, RPsiOpen.class));
        assertOrderedEquals(data.getElement(eos.get(0/*A1*/)), "A.A1");
        assertOrderedEquals(data.getElement(eos.get(1/*A2*/)), "A.A1.A2");
        assertEmpty(data.getElement(e/*A.re*/));
    }

    @Test
    public void test_include_in_steps() {
        configureCode("A.re", "module A1 = { module A2 = {}; }");
        FileBase e = configureCode("B.re", "include A.A1; include A2;");

        ORModuleResolutionPsiGist.Data data = ORModuleResolutionPsiGist.getData(e);

        ArrayList<RPsiInclude> eis = new ArrayList<>(PsiTreeUtil.findChildrenOfType(e, RPsiInclude.class));
        assertEmpty(data.getElement(eis.get(0/*A.A1*/))); // Same
        assertOrderedEquals(data.getElement(eis.get(1/*A2*/)), "A.A1.A2");
        assertOrderedEquals(data.getElement(e/*B.re*/), "A.A1", "A.A1.A2");
    }

    @Test
    public void test_open_in_steps() {
        configureCode("A.re", "module A1 = { module A2 = {}; }");
        FileBase e = configureCode("B.re", "open A.A1; open A2;");

        ORModuleResolutionPsiGist.Data data = ORModuleResolutionPsiGist.getData(e);

        ArrayList<RPsiOpen> eos = new ArrayList<>(PsiTreeUtil.findChildrenOfType(e, RPsiOpen.class));
        assertEmpty(data.getElement(eos.get(0/*A.A1*/))); // Same
        assertOrderedEquals(data.getElement(eos.get(1/*A2*/)), "A.A1.A2");
        assertEmpty(data.getElement(e/*B*/));
    }

    @Test
    public void test_aliases_01() {
        FileBase e = configureCode("A.re", "module A1 = { module A2 = {}; };" +
                "module B1 = A1;" +
                "include B1;" +
                "module B2 = A2;" +
                "include B2;");

        ORModuleResolutionPsiGist.Data data = ORModuleResolutionPsiGist.getData(e);

        List<RPsiInclude> eis = new ArrayList<>(PsiTreeUtil.findChildrenOfType(e, RPsiInclude.class));
        assertOrderedEquals(data.getElement(eis.get(0/*B1*/)), "A.A1");
        assertOrderedEquals(data.getElement(eis.get(1/*B2*/)), "A.A1.A2");

        List<RPsiModule> ems = new ArrayList<>(PsiTreeUtil.findChildrenOfType(e, RPsiModule.class));
        assertOrderedEquals(data.getElement(ems.get(2/*B1*/)), "A.A1");
        assertOrderedEquals(data.getElement(ems.get(3/*B2*/)), "A.A1.A2");

        assertOrderedEquals(data.getElement(e/*A*/), "A.A1", "A.A1.A2");
    }

    @Test
    public void test_aliases_02() {
        FileBase e = configureCode("A.re", "module A1 = { module A2 = {}; module B2 = A2; };" +
                "module B1 = A1;" +
                "include B1.B2;");

        ORModuleResolutionPsiGist.Data data = ORModuleResolutionPsiGist.getData(e);

        RPsiInclude ei = PsiTreeUtil.findChildOfType(e, RPsiInclude.class);
        assertOrderedEquals(data.getElement(ei/*B1.B2*/), "A.A1.A2");
        assertOrderedEquals(data.getElement(e/*A*/), "A.A1.A2");
    }

    @Test
    public void test_aliases_03() {
        configureCode("A.re", "");
        FileBase e = configureCode("B.re", "module B1 = A;");

        ORModuleResolutionPsiGist.Data data = ORModuleResolutionPsiGist.getData(e);

        RPsiModule em = PsiTreeUtil.findChildOfType(e, RPsiModule.class);
        assertOrderedEquals(data.getElement(em/*B1*/), "A");
        assertEmpty(data.getElement(e/*B*/));
    }

    @Test
    public void test_aliases_04() {
        configureCode("A.re", "module W = { module X = { module Y = { module Z = { let z = 1; }; }; }; };");
        FileBase e = configureCode("B.re", "module C = A.W.X; module D = C.Y.Z;");

        ORModuleResolutionPsiGist.Data data = ORModuleResolutionPsiGist.getData(e);

        List<RPsiModule> ems = copyOf(PsiTreeUtil.findChildrenOfType(e, RPsiModule.class));
        assertOrderedEquals(data.getElement(ems.get(0/*C*/)), "A.W.X");
        assertOrderedEquals(data.getElement(ems.get(1/*D*/)), "A.W.X.Y.Z");
        assertEmpty(data.getElement(e/*B*/));
    }


    @Test
    public void test_include_in_module() {
        configureCode("A.re", "");
        FileBase e = configureCode("B.re", "module B1 = { include A; };");

        ORModuleResolutionPsiGist.Data data = ORModuleResolutionPsiGist.getData(e);

        RPsiModule em = PsiTreeUtil.findChildOfType(e, RPsiModule.class);
        assertOrderedEquals(data.getElement(em/*B.B1*/), "A");
    }

    @Test
    public void test_same_includes() {
        FileBase e = configureCode("A.re", "module A1 = { module A2 = {}; }; open A1; include A2; module A2 = {}; include A2;");

        ORModuleResolutionPsiGist.Data data = ORModuleResolutionPsiGist.getData(e);

        ArrayList<RPsiInclude> eis = new ArrayList<>(PsiTreeUtil.findChildrenOfType(e, RPsiInclude.class));
        assertOrderedEquals(data.getElement(eis.get(0)/*A2*/), "A.A1.A2");
        assertOrderedEquals(data.getElement(eis.get(1)/*A2*/), "A.A2");
    }

    @Test
    public void test_functor_in_file() {
        FileBase e = configureCode("A.re", "module type S = { module P: {}; };" +
                "module F = () : S => { module P = {}; };" +
                "module M = F({});");

        ORModuleResolutionPsiGist.Data data = ORModuleResolutionPsiGist.getData(e);

        List<RPsiModule> ems = ORUtil.findImmediateChildrenOfClass(e, RPsiModule.class);
        assertOrderedEquals(data.getElement(ems.get(1)/*F*/), "A.S");
        assertOrderedEquals(data.getElement(ems.get(2)/*M*/), "A.F");
    }

    @Test
    public void test_functor_result_out_file() {
        configureCode("A.re", "module type Result = { let a: int; };");
        FileBase e = configureCode("B.re", "module T = A; module Make = (M:Intf): T.Result => { let b = 3; };");

        ORModuleResolutionPsiGist.Data data = ORModuleResolutionPsiGist.getData(e);

        List<RPsiModule> ems = ORUtil.findImmediateChildrenOfClass(e, RPsiModule.class);
        assertOrderedEquals(data.getElement(ems.get(1)/*Make*/), "A.Result");
    }

    @Test
    public void test_functor_no_signature() {
        FileBase e = configureCode("A.re", "module M = () => { let x = true; }; module X = M();");

        ORModuleResolutionPsiGist.Data data = ORModuleResolutionPsiGist.getData(e);

        List<RPsiModule> ems = ORUtil.findImmediateChildrenOfClass(e, RPsiModule.class);
        assertOrderedEquals(data.getElement(ems.get(1)/*M*/), "A.M");
    }

    @Test
    public void test_functor_outside() {
        configureCode("A.re", "module type S = { module P: {}; }; module F = () : S => { module P = {}; };");
        FileBase e = configureCode("B.re", "module M = A.F({});");

        ORModuleResolutionPsiGist.Data data = ORModuleResolutionPsiGist.getData(e);

        RPsiModule em = ORUtil.findImmediateFirstChildOfClass(e, RPsiModule.class);
        assertOrderedEquals(data.getElement(em/*M*/), "A.F");
        assertEmpty(data.getElement(e));
    }

    @Test
    public void test_functor_open() {
        configureCode("A.re", "module type Intf = { let x: bool; }; module MakeIntf = (I:Intf) : Intf => { let y = 1; };");
        FileBase e = configureCode("B.re", "open A; module Instance = MakeIntf({let x = true});");

        ORModuleResolutionPsiGist.Data data = ORModuleResolutionPsiGist.getData(e);

        RPsiModule em = ORUtil.findImmediateFirstChildOfClass(e, RPsiModule.class);
        assertOrderedEquals(data.getElement(em/*Instance*/), "A.MakeIntf");
        assertEmpty(data.getElement(e));
    }

    @Test
    public void test_file_include_functor() {
        FileBase e = configureCode("A.re", "module Make = () => { let y = 1; }; include Make();");

        ORModuleResolutionPsiGist.Data data = ORModuleResolutionPsiGist.getData(e);

        assertOrderedEquals(data.getElement(e), "A.Make");
    }

    @Test
    public void test_tag_inside() {
        FileBase e = configureCode("A.re", "module X = { [@react.component] let make = (~value) => <div/>; }; <X value=1></X>;");

        ORModuleResolutionPsiGist.Data data = ORModuleResolutionPsiGist.getData(e);

        RPsiTag et = ORUtil.findImmediateFirstChildOfClass(e, RPsiTag.class);
        assertOrderedEquals(data.getElement(et.getFirstChild()/*X*/), "A.X");
    }

    @Test
    public void test_tag_outside() {
        configureCode("X.re", "[@react.component] let make = (~value) => <div/>;");
        FileBase e = configureCode("A.re", "<X value=1></X>;");

        ORModuleResolutionPsiGist.Data data = ORModuleResolutionPsiGist.getData(e);

        RPsiTagStart et = PsiTreeUtil.findChildOfType(e, RPsiTagStart.class);
        assertOrderedEquals(data.getElement(et/*X*/), "X");
    }

    @Test
    public void test_tag_open_outside() {
        configureCode("X.re", "module Y = { [@react.component] let make = (~value) => <div/>; }");
        FileBase e = configureCode("A.re", "open X; <Y value=1></X>;");

        ORModuleResolutionPsiGist.Data data = ORModuleResolutionPsiGist.getData(e);

        RPsiTagStart et = PsiTreeUtil.findChildOfType(e, RPsiTagStart.class);
        assertOrderedEquals(data.getElement(et/*Y*/), "X.Y");
    }
}
