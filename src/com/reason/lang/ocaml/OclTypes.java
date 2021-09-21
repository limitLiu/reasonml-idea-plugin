package com.reason.lang.ocaml;

import com.reason.lang.core.stub.*;
import com.reason.lang.core.type.*;

public class OclTypes extends ORTypes {

    public static final OclTypes INSTANCE = new OclTypes();

    private OclTypes() {
        // Stub element types

        C_FAKE_MODULE = (ORCompositeType) OclStubBasedElementTypes.C_FAKE_MODULE;
        C_CLASS_DECLARATION = (ORCompositeType) OclStubBasedElementTypes.C_CLASS_DECLARATION;
        C_EXCEPTION_DECLARATION = (ORCompositeType) OclStubBasedElementTypes.C_EXCEPTION_DECLARATION;
        C_TYPE_DECLARATION = (ORCompositeType) OclStubBasedElementTypes.C_TYPE_DECLARATION;
        C_EXTERNAL_DECLARATION = (ORCompositeType) OclStubBasedElementTypes.C_EXTERNAL_DECLARATION;
        C_LET_DECLARATION = (ORCompositeType) OclStubBasedElementTypes.C_LET_DECLARATION;
        C_MODULE_DECLARATION = (ORCompositeType) OclStubBasedElementTypes.C_MODULE_DECLARATION;
        C_VAL_DECLARATION = (ORCompositeType) OclStubBasedElementTypes.C_VAL_DECLARATION;
        C_FUN_PARAM = (ORCompositeType) OclStubBasedElementTypes.C_FUN_PARAM;
        C_FUNCTOR_DECLARATION = (ORCompositeType) OclStubBasedElementTypes.C_FUNCTOR_DECLARATION;
        C_FUNCTOR_PARAM = (ORCompositeType) OclStubBasedElementTypes.C_FUNCTOR_PARAM;
        C_RECORD_FIELD = (ORCompositeType) OclStubBasedElementTypes.C_RECORD_FIELD;
        C_VARIANT_DECLARATION = (ORCompositeType) OclStubBasedElementTypes.C_VARIANT_DECLARATION;
        C_INCLUDE = (ORCompositeType) OclStubBasedElementTypes.C_INCLUDE;
        C_OPEN = (ORCompositeType) OclStubBasedElementTypes.C_OPEN;

        // Composite element types

        C_ANNOTATION = new ORCompositeElementType("C_ANNOTATION", OclLanguage.INSTANCE);
        C_ASSERT_STMT = new ORCompositeElementType("C_ASSERT_STMT", OclLanguage.INSTANCE);
        C_BINARY_CONDITION = new ORCompositeElementType("C_BIN_CONDITION", OclLanguage.INSTANCE);
        C_CLASS_CONSTR = new ORCompositeElementType("C_CLASS_CONSTR", OclLanguage.INSTANCE);
        C_CLASS_PARAMS = new ORCompositeElementType("C_CLASS_PARAMS", OclLanguage.INSTANCE);
        C_CLASS_FIELD = new ORCompositeElementType("C_CLASS_FIELD", OclLanguage.INSTANCE);
        C_CLASS_METHOD = new ORCompositeElementType("C_CLASS_METHOD", OclLanguage.INSTANCE);
        C_CONSTRAINTS = new ORCompositeElementType("C_CONSTRAINTS", OclLanguage.INSTANCE);
        C_CONSTRAINT = new ORCompositeElementType("C_CONSTRAINT", OclLanguage.INSTANCE);
        C_CUSTOM_OPERATOR = new ORCompositeElementType("C_CUSTOM_OPERATOR", OclLanguage.INSTANCE);
        C_DECONSTRUCTION = new ORCompositeElementType("C_DECONSTRUCTION", OclLanguage.INSTANCE);
        C_DEFAULT_VALUE = new ORCompositeElementType("C_DEFAULT_VALUE", OclLanguage.INSTANCE);
        C_DIRECTIVE = new ORCompositeElementType("C_DIRECTIVE", OclLanguage.INSTANCE);
        C_DO_LOOP = new ORCompositeElementType("C_DO_LOOP", OclLanguage.INSTANCE);
        C_LOWER_IDENTIFIER = new ORCompositeElementType("C_LOWER_IDENTIFIER", OclLanguage.INSTANCE);
        C_UPPER_IDENTIFIER = new ORCompositeElementType("C_UPPER_IDENTIFIER", OclLanguage.INSTANCE);
        C_FUN_CALL_PARAMS = new ORCompositeElementType("C_FUN_CALL_PARAMS", OclLanguage.INSTANCE);
        C_FUN_EXPR = new ORCompositeElementType("C_FUN_EXPR", OclLanguage.INSTANCE);
        C_FUN_PARAMS = new ORCompositeElementType("C_FUN_PARAMS", OclLanguage.INSTANCE);
        C_FUN_BODY = new ORCompositeElementType("C_FUN_BODY", OclLanguage.INSTANCE);
        C_FUNCTOR_BINDING = new ORCompositeElementType("C_FUNCTOR_BINDING", OclLanguage.INSTANCE);
        C_FUNCTOR_CALL = new ORCompositeElementType("C_FUNCTOR_CALL", OclLanguage.INSTANCE);
        C_FUNCTOR_PARAMS = new ORCompositeElementType("C_FUNCTOR_PARAMS", OclLanguage.INSTANCE);
        C_FUNCTOR_RESULT = new ORCompositeElementType("C_FUNCTOR_RESULT", OclLanguage.INSTANCE);
        C_INTERPOLATION_EXPR = new ORCompositeElementType("C_INTERPOLATION_EXPR", OclLanguage.INSTANCE);
        C_INTERPOLATION_PART = new ORCompositeElementType("C_INTERPOLATION_PART", OclLanguage.INSTANCE);
        C_INTERPOLATION_REF = new ORCompositeElementType("C_INTERPOLATION_REF", OclLanguage.INSTANCE);
        C_JS_OBJECT = new ORCompositeElementType("C_JS_OBJECT", OclLanguage.INSTANCE);
        C_LET_ATTR = new ORCompositeElementType("C_LET_ATTR", OclLanguage.INSTANCE);
        C_LET_BINDING = new ORCompositeElementType("C_LET_BINDING", OclLanguage.INSTANCE);
        C_LOCAL_OPEN = new ORCompositeElementType("C_LOCAL_OPEN", OclLanguage.INSTANCE);
        C_LOWER_BOUND_CONSTRAINT = new ORCompositeElementType("C_LOWER_BOUND_CONSTRAINT", OclLanguage.INSTANCE);
        C_TYPE_VARIABLE = new ORCompositeElementType("C_TYPE_VARIABLE", OclLanguage.INSTANCE);
        C_LOWER_SYMBOL = new ORCompositeElementType("C_LOWER_SYMBOL", OclLanguage.INSTANCE);
        C_MACRO_EXPR = new ORCompositeElementType("C_MACRO_EXPR", OclLanguage.INSTANCE);
        C_MACRO_NAME = new ORCompositeElementType("C_MACRO_NAME", OclLanguage.INSTANCE);
        C_MACRO_RAW_BODY = new ORCompositeElementType("C_MACRO_RAW_BODY", OclLanguage.INSTANCE);
        C_MODULE_TYPE = new ORCompositeElementType("C_MODULE_TYPE", OclLanguage.INSTANCE);
        C_ML_INTERPOLATOR = new ORCompositeElementType("C_ML_INTERPOLATOR", OclLanguage.INSTANCE);
        C_MATCH_EXPR = new ORCompositeElementType("C_MATCH_EXPR", OclLanguage.INSTANCE);
        C_NAMED_PARAM = new ORCompositeElementType("C_NAMED_PARAM", OclLanguage.INSTANCE);
        C_OBJECT = new ORCompositeElementType("C_OBJECT", OclLanguage.INSTANCE);
        C_OBJECT_FIELD = new ORCompositeElementType("C_OBJECT_FIELD", OclLanguage.INSTANCE);
        C_OPTION = new ORCompositeElementType("C_OPTION", OclLanguage.INSTANCE);
        C_PARAMETERS = new ORCompositeElementType("C_PARAMETERS", OclLanguage.INSTANCE);
        C_PATTERN_MATCH_BODY = new ORCompositeElementType("C_PATTERN_MATCH_BODY", OclLanguage.INSTANCE);
        C_PATTERN_MATCH_EXPR = new ORCompositeElementType("C_PATTERN_MATCH_EXPR", OclLanguage.INSTANCE);
        C_RECORD_EXPR = new ORCompositeElementType("C_RECORD_EXPR", OclLanguage.INSTANCE);
        C_SIG_EXPR = new ORCompositeElementType("C_SIG_EXPR", OclLanguage.INSTANCE);
        C_SIG_ITEM = new ORCompositeElementType("C_SIG_ITEM", OclLanguage.INSTANCE);
        C_TAG = new ORCompositeElementType("C_TAG", OclLanguage.INSTANCE);
        C_TAG_BODY = new ORCompositeElementType("C_TAG_BODY", OclLanguage.INSTANCE);
        C_TAG_CLOSE = new ORCompositeElementType("C_TAG_CLOSE", OclLanguage.INSTANCE);
        C_TAG_PROP_VALUE = new ORCompositeElementType("C_TAG_PROP_VALUE", OclLanguage.INSTANCE);
        C_TAG_PROPERTY = new ORCompositeElementType("C_TAG_PROPERTY", OclLanguage.INSTANCE);
        C_TAG_START = new ORCompositeElementType("C_TAG_START", OclLanguage.INSTANCE);
        C_TERNARY = new ORCompositeElementType("C_TERNARY", OclLanguage.INSTANCE);
        C_TRY_EXPR = new ORCompositeElementType("C_TRY_EXPR", OclLanguage.INSTANCE);
        C_TRY_BODY = new ORCompositeElementType("C_TRY_BODY", OclLanguage.INSTANCE);
        C_TRY_HANDLER = new ORCompositeElementType("C_TRY_HANDLER", OclLanguage.INSTANCE);
        C_TRY_HANDLERS = new ORCompositeElementType("C_TRY_HANDLERS", OclLanguage.INSTANCE);
        C_TYPE_BINDING = new ORCompositeElementType("C_TYPE_BINDING", OclLanguage.INSTANCE);
        C_UNIT = new ORCompositeElementType("C_UNIT", OclLanguage.INSTANCE);
        C_UPPER_BOUND_CONSTRAINT = new ORCompositeElementType("C_UPPER_BOUND_CONSTRAINT", OclLanguage.INSTANCE);
        C_DUMMY = new ORCompositeElementType("C_DUMMY", OclLanguage.INSTANCE);
        C_VARIANT = new ORCompositeElementType("C_VARIANT", OclLanguage.INSTANCE);
        C_VARIANT_CONSTRUCTOR =
                new ORCompositeElementType("C_VARIANT_CONSTRUCTOR", OclLanguage.INSTANCE);
        C_IF = new ORCompositeElementType("C_IF", OclLanguage.INSTANCE);
        C_IF_THEN_SCOPE = new ORCompositeElementType("C_IF_THEN_SCOPE", OclLanguage.INSTANCE);
        C_SCOPED_EXPR = new ORCompositeElementType("C_SCOPED_EXPR", OclLanguage.INSTANCE);
        C_SWITCH_EXPR = new ORCompositeElementType("C_SWITCH_EXPR", OclLanguage.INSTANCE);
        C_UPPER_SYMBOL = new ORCompositeElementType("C_UPPER_SYMBOL", OclLanguage.INSTANCE);
        C_STRUCT_EXPR = new ORCompositeElementType("C_STRUCT_EXPR", OclLanguage.INSTANCE);
        C_MIXIN_FIELD = new ORCompositeElementType("C_MIXIN_FIELD", OclLanguage.INSTANCE);
        C_WHILE = new ORCompositeElementType("C_WHILE", OclLanguage.INSTANCE);

        // Token element types

        BOOL_VALUE = new ORTokenElementType("BOOL_VALUE", OclLanguage.INSTANCE);
        STRING_VALUE = new ORTokenElementType("STRING_VALUE", OclLanguage.INSTANCE);
        FLOAT_VALUE = new ORTokenElementType("FLOAT_VALUE", OclLanguage.INSTANCE);
        CATCH = new ORTokenElementType("CATCH", OclLanguage.INSTANCE);
        CHAR_VALUE = new ORTokenElementType("CHAR_VALUE", OclLanguage.INSTANCE);
        INT_VALUE = new ORTokenElementType("INT_VALUE", OclLanguage.INSTANCE);
        SWITCH = new ORTokenElementType("SWITCH", OclLanguage.INSTANCE);
        FUNCTION = new ORTokenElementType("FUNCTION", OclLanguage.INSTANCE);
        FUN = new ORTokenElementType("FUN", OclLanguage.INSTANCE);
        FUNCTOR = new ORTokenElementType("FUNCTOR", OclLanguage.INSTANCE);
        IF = new ORTokenElementType("IF", OclLanguage.INSTANCE);
        EXCEPTION_NAME = new ORTokenElementType("EXCEPTION_NAME", OclLanguage.INSTANCE);
        PROPERTY_NAME = new ORTokenElementType("PROPERTY_NAME", OclLanguage.INSTANCE);
        AND = new ORTokenElementType("AND", OclLanguage.INSTANCE);
        L_AND = new ORTokenElementType("L_AND", OclLanguage.INSTANCE);
        L_OR = new ORTokenElementType("L_OR", OclLanguage.INSTANCE);
        ARROBASE = new ORTokenElementType("ARROBASE", OclLanguage.INSTANCE);
        ARROBASE_2 = new ORTokenElementType("ARROBASE_2", OclLanguage.INSTANCE);
        ARROBASE_3 = new ORTokenElementType("ARROBASE_3", OclLanguage.INSTANCE);
        ARROW = new ORTokenElementType("ARROW", OclLanguage.INSTANCE);
        ASSERT = new ORTokenElementType("ASSERT", OclLanguage.INSTANCE);
        AS = new ORTokenElementType("AS", OclLanguage.INSTANCE);
        BACKTICK = new ORTokenElementType("BACKTICK", OclLanguage.INSTANCE);
        BEGIN = new ORTokenElementType("BEGIN", OclLanguage.INSTANCE);
        CARRET = new ORTokenElementType("CARRET", OclLanguage.INSTANCE);
        COLON = new ORTokenElementType("COLON", OclLanguage.INSTANCE);
        COMMA = new ORTokenElementType("COMMA", OclLanguage.INSTANCE);
        SINGLE_COMMENT = new ORTokenElementType("SINGLE_COMMENT", OclLanguage.INSTANCE);
        MULTI_COMMENT = new ORTokenElementType("MULTI_COMMENT", OclLanguage.INSTANCE);
        DIFF = new ORTokenElementType("DIFF", OclLanguage.INSTANCE);
        DIRECTIVE_IF = new ORTokenElementType("DIRECTIVE_IF", OclLanguage.INSTANCE);
        DIRECTIVE_ELSE = new ORTokenElementType("DIRECTIVE_ELSE", OclLanguage.INSTANCE);
        DIRECTIVE_ELIF = new ORTokenElementType("DIRECTIVE_ELIF", OclLanguage.INSTANCE);
        DIRECTIVE_END = new ORTokenElementType("DIRECTIVE_END", OclLanguage.INSTANCE);
        DIRECTIVE_ENDIF = new ORTokenElementType("DIRECTIVE_ENDIF", OclLanguage.INSTANCE);
        LT_OR_EQUAL = new ORTokenElementType("LT_OR_EQUAL", OclLanguage.INSTANCE);
        GT_OR_EQUAL = new ORTokenElementType("GT_OR_EQUAL", OclLanguage.INSTANCE);
        DOLLAR = new ORTokenElementType("DOLLAR", OclLanguage.INSTANCE);
        DOT = new ORTokenElementType("DOT", OclLanguage.INSTANCE);
        DOTDOTDOT = new ORTokenElementType("DOTDOTDOT", OclLanguage.INSTANCE);
        DO = new ORTokenElementType("DO", OclLanguage.INSTANCE);
        DONE = new ORTokenElementType("DONE", OclLanguage.INSTANCE);
        ELSE = new ORTokenElementType("ELSE", OclLanguage.INSTANCE);
        END = new ORTokenElementType("END", OclLanguage.INSTANCE);
        ENDIF = new ORTokenElementType("ENDIF", OclLanguage.INSTANCE);
        NOT_EQ = new ORTokenElementType("EQ", OclLanguage.INSTANCE);
        NOT_EQEQ = new ORTokenElementType("EQEQ", OclLanguage.INSTANCE);
        EQ = new ORTokenElementType("EQ", OclLanguage.INSTANCE);
        EQEQ = new ORTokenElementType("EQEQ", OclLanguage.INSTANCE);
        EQEQEQ = new ORTokenElementType("EQEQEQ", OclLanguage.INSTANCE);
        EXCEPTION = new ORTokenElementType("EXCEPTION", OclLanguage.INSTANCE);
        EXCLAMATION_MARK = new ORTokenElementType("EXCLAMATION_MARK", OclLanguage.INSTANCE);
        EXTERNAL = new ORTokenElementType("EXTERNAL", OclLanguage.INSTANCE);
        FOR = new ORTokenElementType("FOR", OclLanguage.INSTANCE);
        TYPE_ARGUMENT = new ORTokenElementType("TYPE_ARGUMENT", OclLanguage.INSTANCE);
        GT = new ORTokenElementType("GT", OclLanguage.INSTANCE);
        IN = new ORTokenElementType("IN", OclLanguage.INSTANCE);
        LAZY = new ORTokenElementType("LAZY", OclLanguage.INSTANCE);
        INCLUDE = new ORTokenElementType("INCLUDE", OclLanguage.INSTANCE);
        LARRAY = new ORTokenElementType("LARRAY", OclLanguage.INSTANCE);
        LBRACE = new ORTokenElementType("LBRACE", OclLanguage.INSTANCE);
        LBRACKET = new ORTokenElementType("LBRACKET", OclLanguage.INSTANCE);
        LET = new ORTokenElementType("LET", OclLanguage.INSTANCE);
        LIDENT = new ORTokenElementType("LIDENT", OclLanguage.INSTANCE);
        LPAREN = new ORTokenElementType("LPAREN", OclLanguage.INSTANCE);
        LT = new ORTokenElementType("LT", OclLanguage.INSTANCE);
        MATCH = new ORTokenElementType("MATCH", OclLanguage.INSTANCE);
        MINUS = new ORTokenElementType("MINUS", OclLanguage.INSTANCE);
        MINUSDOT = new ORTokenElementType("MINUSDOT", OclLanguage.INSTANCE);
        MODULE = new ORTokenElementType("MODULE", OclLanguage.INSTANCE);
        MUTABLE = new ORTokenElementType("MUTABLE", OclLanguage.INSTANCE);
        NONE = new ORTokenElementType("NONE", OclLanguage.INSTANCE);
        OF = new ORTokenElementType("OF", OclLanguage.INSTANCE);
        OPEN = new ORTokenElementType("OPEN", OclLanguage.INSTANCE);
        OPTION = new ORTokenElementType("OPTION", OclLanguage.INSTANCE);
        POLY_VARIANT = new ORTokenElementType("POLY_VARIANT", OclLanguage.INSTANCE);
        VARIANT_NAME = new ORTokenElementType("VARIANT_NAME", OclLanguage.INSTANCE);
        PIPE = new ORTokenElementType("PIPE", OclLanguage.INSTANCE);
        PIPE_FORWARD = new ORTokenElementType("PIPE_FORWARD", OclLanguage.INSTANCE);
        PLUS = new ORTokenElementType("PLUS", OclLanguage.INSTANCE);
        PERCENT = new ORTokenElementType("PERCENT", OclLanguage.INSTANCE);
        PLUSDOT = new ORTokenElementType("PLUSDOT", OclLanguage.INSTANCE);
        QUESTION_MARK = new ORTokenElementType("QUESTION_MARK", OclLanguage.INSTANCE);
        SINGLE_QUOTE = new ORTokenElementType("SINGLE_QUOTE", OclLanguage.INSTANCE);
        DOUBLE_QUOTE = new ORTokenElementType("DOUBLE_QUOTE", OclLanguage.INSTANCE);
        RAISE = new ORTokenElementType("RAISE", OclLanguage.INSTANCE);
        RARRAY = new ORTokenElementType("RARRAY", OclLanguage.INSTANCE);
        RBRACE = new ORTokenElementType("RBRACE", OclLanguage.INSTANCE);
        RBRACKET = new ORTokenElementType("RBRACKET", OclLanguage.INSTANCE);
        REC = new ORTokenElementType("REC", OclLanguage.INSTANCE);
        REF = new ORTokenElementType("REF", OclLanguage.INSTANCE);
        RPAREN = new ORTokenElementType("RPAREN", OclLanguage.INSTANCE);
        SEMI = new ORTokenElementType("SEMI", OclLanguage.INSTANCE);
        SIG = new ORTokenElementType("SIG", OclLanguage.INSTANCE);
        SHARP = new ORTokenElementType("SHARP", OclLanguage.INSTANCE);
        SHARPSHARP = new ORTokenElementType("SHARPSHARP", OclLanguage.INSTANCE);
        SHORTCUT = new ORTokenElementType("SHORTCUT", OclLanguage.INSTANCE);
        SLASH = new ORTokenElementType("SLASH", OclLanguage.INSTANCE);
        SLASH_2 = new ORTokenElementType("SLASH_2", OclLanguage.INSTANCE);
        SLASHDOT = new ORTokenElementType("SLASHDOT", OclLanguage.INSTANCE);
        SOME = new ORTokenElementType("SOME", OclLanguage.INSTANCE);
        STAR = new ORTokenElementType("STAR", OclLanguage.INSTANCE);
        STARDOT = new ORTokenElementType("STARDOT", OclLanguage.INSTANCE);
        STRUCT = new ORTokenElementType("STRUCT", OclLanguage.INSTANCE);
        OP_STRUCT_DIFF = new ORTokenElementType("OP_STRUCT_DIFF", OclLanguage.INSTANCE);
        TAG_AUTO_CLOSE = new ORTokenElementType("TAG_AUTO_CLOSE", OclLanguage.INSTANCE);
        TAG_NAME = new ORTokenElementType("TAG_NAME", OclLanguage.INSTANCE);
        TAG_LT = new ORTokenElementType("TAG_LT", OclLanguage.INSTANCE);
        TAG_GT = new ORTokenElementType("TAG_GT", OclLanguage.INSTANCE);
        TAG_LT_SLASH = new ORTokenElementType("TAG_LT_SLASH", OclLanguage.INSTANCE);
        TILDE = new ORTokenElementType("TILDE", OclLanguage.INSTANCE);
        TO = new ORTokenElementType("TO", OclLanguage.INSTANCE);
        THEN = new ORTokenElementType("THEN", OclLanguage.INSTANCE);
        TRY = new ORTokenElementType("TRY", OclLanguage.INSTANCE);
        TYPE = new ORTokenElementType("TYPE", OclLanguage.INSTANCE);
        UIDENT = new ORTokenElementType("UIDENT", OclLanguage.INSTANCE);
        UNIT = new ORTokenElementType("UNIT", OclLanguage.INSTANCE);
        VAL = new ORTokenElementType("VAL", OclLanguage.INSTANCE);
        PUB = new ORTokenElementType("PUB", OclLanguage.INSTANCE);
        PRI = new ORTokenElementType("PRI", OclLanguage.INSTANCE);
        WHEN = new ORTokenElementType("WHEN", OclLanguage.INSTANCE);
        WHILE = new ORTokenElementType("WHILE", OclLanguage.INSTANCE);
        WITH = new ORTokenElementType("WITH", OclLanguage.INSTANCE);
        RAW = new ORTokenElementType("RAW", OclLanguage.INSTANCE);

        ASR = new ORTokenElementType("ASR", OclLanguage.INSTANCE);
        CLASS = new ORTokenElementType("CLASS", OclLanguage.INSTANCE);
        CONSTRAINT = new ORTokenElementType("CONSTRAINT", OclLanguage.INSTANCE);
        DOWNTO = new ORTokenElementType("DOWNTO", OclLanguage.INSTANCE);
        INHERIT = new ORTokenElementType("INHERIT", OclLanguage.INSTANCE);
        INITIALIZER = new ORTokenElementType("INITIALIZER", OclLanguage.INSTANCE);
        LAND = new ORTokenElementType("LAND", OclLanguage.INSTANCE);
        LOR = new ORTokenElementType("LOR", OclLanguage.INSTANCE);
        LSL = new ORTokenElementType("LSL", OclLanguage.INSTANCE);
        LSR = new ORTokenElementType("LSR", OclLanguage.INSTANCE);
        LXOR = new ORTokenElementType("LXOR", OclLanguage.INSTANCE);
        METHOD = new ORTokenElementType("METHOD", OclLanguage.INSTANCE);
        MOD = new ORTokenElementType("MOD", OclLanguage.INSTANCE);
        NEW = new ORTokenElementType("NEW", OclLanguage.INSTANCE);
        NONREC = new ORTokenElementType("NONREC", OclLanguage.INSTANCE);
        OR = new ORTokenElementType("OR", OclLanguage.INSTANCE);
        PRIVATE = new ORTokenElementType("PRIVATE", OclLanguage.INSTANCE);
        VIRTUAL = new ORTokenElementType("VIRTUAL", OclLanguage.INSTANCE);

        COLON_EQ = new ORTokenElementType("COLON_EQ", OclLanguage.INSTANCE);
        COLON_GT = new ORTokenElementType("COLON_GT", OclLanguage.INSTANCE);
        DOTDOT = new ORTokenElementType("DOTDOT", OclLanguage.INSTANCE);
        SEMISEMI = new ORTokenElementType("SEMISEMI", OclLanguage.INSTANCE);
        GT_BRACKET = new ORTokenElementType("GT_BRACKET", OclLanguage.INSTANCE);
        GT_BRACE = new ORTokenElementType("GT_BRACE", OclLanguage.INSTANCE);
        LEFT_ARROW = new ORTokenElementType("LEFT_ARROW", OclLanguage.INSTANCE);
        RIGHT_ARROW = new ORTokenElementType("RIGHT_ARROW", OclLanguage.INSTANCE);

        OBJECT = new ORTokenElementType("OBJECT", OclLanguage.INSTANCE);
        RECORD = new ORTokenElementType("RECORD", OclLanguage.INSTANCE);

        AMPERSAND = new ORTokenElementType("AMPERSAND", OclLanguage.INSTANCE);
        BRACKET_GT = new ORTokenElementType("BRACKET_GT", OclLanguage.INSTANCE);
        BRACKET_LT = new ORTokenElementType("BRACKET_LT", OclLanguage.INSTANCE);
        BRACE_LT = new ORTokenElementType("BRACE_LT", OclLanguage.INSTANCE);

        ML_STRING_VALUE = new ORTokenElementType("ML_STRING_VALUE", OclLanguage.INSTANCE);
        ML_STRING_OPEN = new ORTokenElementType("ML_STRING_OPEN", OclLanguage.INSTANCE);
        ML_STRING_CLOSE = new ORTokenElementType("ML_STRING_CLOSE", OclLanguage.INSTANCE);
        JS_STRING_OPEN = new ORTokenElementType("JS_STRING_OPEN", OclLanguage.INSTANCE);
        JS_STRING_CLOSE = new ORTokenElementType("JS_STRING_CLOSE", OclLanguage.INSTANCE);
        UNDERSCORE = new ORTokenElementType("UNDERSCORE", OclLanguage.INSTANCE);
    }
}
