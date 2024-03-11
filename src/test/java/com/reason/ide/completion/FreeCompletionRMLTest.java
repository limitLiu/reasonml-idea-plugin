package com.reason.ide.completion;

import com.intellij.codeInsight.completion.*;
import com.reason.comp.*;
import com.reason.ide.*;
import com.reason.ide.insight.*;
import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;

import java.util.*;

@SuppressWarnings("ConstantConditions")
@RunWith(JUnit4.class)
public class FreeCompletionRMLTest extends ORBasePlatformTestCase {
    @Override
    protected String getTestDataPath() {
        return "src/test/testData/ns";
    }

    // TODO: polyvariant completion

    @Test
    public void test_pervasives() {
        configureCode("pervasives.mli", "val int_of_string : str -> int");
        configureCode("belt_Array.mli", "val length: t -> int");
        configureCode("belt.ml", "module Array = Belt_Array");

        configureCode("Dummy.re", "let x = <caret>");

        myFixture.complete(CompletionType.BASIC, 1);
        List<String> elements = myFixture.getLookupElementStrings();

        assertContainsElements(elements, "int_of_string", "Belt", "Belt_Array", "Pervasives");
        assertSize(4, elements);
    }

    @Test
    public void test_underscore() {
        configureCode("Dummy.re", "let _ = 1; <caret>");

        myFixture.complete(CompletionType.BASIC, 1);
        List<String> elements = myFixture.getLookupElementStrings();

        assertSameElements(elements, RmlKeywordCompletionContributor.KEYWORDS);
        assertSize(RmlKeywordCompletionContributor.KEYWORDS.length, elements);
    }

    @Test
    public void test_deconstruction() {
        configureCode("Dummy.re", "let (first, second) = myVar; <caret>");

        myFixture.complete(CompletionType.BASIC, 1);
        List<String> elements = myFixture.getLookupElementStrings();

        assertContainsElements(elements, "first", "second");
    }

    @Test
    public void test_let_private_from_outside() {
        configureCode("A.re", "let x%private = 1;");
        configureCode("B.re", "open A; <caret>");

        myFixture.complete(CompletionType.BASIC, 1);
        List<String> elements = myFixture.getLookupElementStrings();

        assertDoesntContain(elements, "x");
    }

    @Test
    public void test_let_private_from_inside() {
        configureCode("A.re", "let x%private = 1; <caret>");

        myFixture.complete(CompletionType.BASIC, 1);
        List<String> elements = myFixture.getLookupElementStrings();

        assertContainsElements(elements, "x");
    }

    @Test
    public void test_include() {
        myFixture.configureByText("A.re", "let x = 1;");
        myFixture.configureByText("B.re", """
                include A;
                <caret>
                """);

        myFixture.complete(CompletionType.BASIC, 1);
        List<String> strings = myFixture.getLookupElementStrings();

        assertContainsElements(strings, "x", "A");
    }

    @Test
    public void test_include_after() {
        myFixture.configureByText("A.re", "let x = 1;");
        myFixture.configureByText("B.re", """
                <caret>
                include A;
                """);

        myFixture.complete(CompletionType.BASIC, 1);
        List<String> strings = myFixture.getLookupElementStrings();

        assertContainsElements(strings, "A");
    }

    @Test
    public void test_include_eof() {
        myFixture.configureByText("A.re", "let x = 1;");
        myFixture.configureByText("B.re", """
                include A;
                let y = 2;
                <caret>
                """);

        myFixture.complete(CompletionType.BASIC, 1);
        List<String> strings = myFixture.getLookupElementStrings();

        assertSameElements(strings, "exception", "external", "include", "let", "module", "open", "type", "A", "y", "x");
        assertSize(10, strings);
    }

    @Test
    public void test_namespace() {
        myFixture.configureByFile(ORConstants.BS_CONFIG_FILENAME);
        configureCode("A.re", "module A1 = {};");
        configureCode("B.re", "<caret>");

        myFixture.complete(CompletionType.BASIC, 1);
        List<String> strings = myFixture.getLookupElementStrings();

        assertSameElements(strings, "exception", "external", "include", "let", "module", "open", "type", "MyNamespace");
        assertSize(8, strings);
    }

    @Test
    public void test_include_functor() {
        configureCode("A.re", """
                module type I = { type renderer; };
                module type R = { type rule; let style: unit => array(rule); };
                                    
                module Core = {
                  let color = "red";
                  module Make = (I): R => { type rule; let style = () => [||]; };
                }
                                    
                module Css = {
                  include Core
                  include Core.Make({type renderer;});
                };
                                    
                open Css;
                                    
                let y = <caret>
                """);

        myFixture.complete(CompletionType.BASIC, 1);
        List<String> strings = myFixture.getLookupElementStrings();

        assertSameElements(strings, "color", "Core", "Css", "I", "Make", "R", "rule", "style", "y"); // <- y because caret is not inside the let binding
    }

    @Test
    public void test_open_include() {
        configureCode("A.re", "let x = 1;");
        configureCode("B.re", "include A;");
        configureCode("C.re", "include B;");
        configureCode("D.re", """
                open C;
                <caret>
                """);

        myFixture.complete(CompletionType.BASIC, 1);
        List<String> strings = myFixture.getLookupElementStrings();

        assertContainsElements(strings, "A", "B", "C", "x");
    }
}
