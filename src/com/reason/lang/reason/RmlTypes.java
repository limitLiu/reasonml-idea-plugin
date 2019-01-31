package com.reason.lang.reason;

import com.reason.lang.core.stub.type.*;
import com.reason.lang.core.type.ORCompositeElementType;
import com.reason.lang.core.type.ORTokenElementType;
import com.reason.lang.core.type.ORTypes;

public class RmlTypes extends ORTypes {

    public static final RmlTypes INSTANCE = new RmlTypes();

    private RmlTypes() {
        // Composite element types

        EXTERNAL_STMT = new PsiExternalStubElementType("EXTERNAL_STMT", RmlLanguage.INSTANCE);
        LET_STMT = new PsiLetStubElementType("LET_STMT", RmlLanguage.INSTANCE);
        EXP_TYPE = new PsiTypeStubElementType("EXP_TYPE", RmlLanguage.INSTANCE);
        VAL_EXPR = new PsiValStubElementType("VAL_EXPRESSION", RmlLanguage.INSTANCE);
        ANNOTATION_EXPR = new ORCompositeElementType("ANNOTATION_EXPRESSION", RmlLanguage.INSTANCE);
        EXCEPTION_EXPR = new ORCompositeElementType("EXCEPTION_EXPRESSION", RmlLanguage.INSTANCE);
        INCLUDE_STMT = new ORCompositeElementType("INCLUDE_STMT", RmlLanguage.INSTANCE);
        MACRO_EXPR = new ORCompositeElementType("MACRO_EXPR", RmlLanguage.INSTANCE);
        MACRO_NAME = new ORCompositeElementType("MACRO_NAME", RmlLanguage.INSTANCE);
        C_FUN_EXPR = new ORCompositeElementType("C_FUN_EXPR", RmlLanguage.INSTANCE);
        C_FUN_PARAM = new ORCompositeElementType("C_FUNCTION_PARAMETER", RmlLanguage.INSTANCE);
        C_FUN_PARAMS = new ORCompositeElementType("C_FUN_PARAMS", RmlLanguage.INSTANCE);
        C_FUN_BODY = new ORCompositeElementType("C_FUN_BODY", RmlLanguage.INSTANCE);
        C_FUNCTOR = new ORCompositeElementType("C_FUNCTOR", RmlLanguage.INSTANCE);
        C_FUNCTOR_BINDING = new ORCompositeElementType("C_FUNCTOR_BINDING", RmlLanguage.INSTANCE);
        C_FUNCTOR_CONSTRAINTS = new ORCompositeElementType("C_FUNCTOR_CONSTRAINTS", RmlLanguage.INSTANCE);
        C_FUNCTOR_PARAMS = new ORCompositeElementType("C_FUNCTOR_PARAMS", RmlLanguage.INSTANCE);
        C_LET_NAME = new ORCompositeElementType("C_LET_NAME", RmlLanguage.INSTANCE);
        C_JS_OBJECT = new ORCompositeElementType("C_JS_OBJECT", RmlLanguage.INSTANCE);
        C_JS_OBJECT_FIELD = new ORCompositeElementType("C_JS_OBJECT_FIELD", RmlLanguage.INSTANCE);
        C_MACRO_RAW_BODY = new ORCompositeElementType("C_MACRO_RAW_BODY", RmlLanguage.INSTANCE);
        C_OPTION = new ORCompositeElementType("C_OPTION", RmlLanguage.INSTANCE);
        C_RAW = new ORCompositeElementType("C_RAW", RmlLanguage.INSTANCE);
        C_SIG_EXPR = new ORCompositeElementType("C_SIG_EXPR", RmlLanguage.INSTANCE);
        C_SIG_ITEM = new ORCompositeElementType("C_SIG_ITEM", RmlLanguage.INSTANCE);
        C_TAG = new ORCompositeElementType("C_TAG", RmlLanguage.INSTANCE);
        C_TAG_PROP_VALUE = new ORCompositeElementType("C_TAG_PROP_VALUE", RmlLanguage.INSTANCE);
        C_TAG_BODY = new ORCompositeElementType("C_TAG_BODY", RmlLanguage.INSTANCE);
        C_TYPE_BINDING = new ORCompositeElementType("C_TYPE_BINDING", RmlLanguage.INSTANCE);
        C_UNIT = new ORCompositeElementType("C_UNIT", RmlLanguage.INSTANCE);
        C_UNKNOWN_EXPR = new ORCompositeElementType("C_UNKNOWN_EXPR", RmlLanguage.INSTANCE);
        C_VARIANT_EXP = new ORCompositeElementType("C_VARIANT_EXP", RmlLanguage.INSTANCE);
        C_VARIANT_CONSTRUCTOR = new ORCompositeElementType("C_VARIANT_CONSTRUCTOR", RmlLanguage.INSTANCE);
        MIXIN_FIELD = new ORCompositeElementType("MIXIN_FIELD", RmlLanguage.INSTANCE);
        MODULE_STMT = new PsiModuleStubElementType("MODULE_STMT", RmlLanguage.INSTANCE);
        MODULE_PATH = new ORCompositeElementType("MODULE_PATH", RmlLanguage.INSTANCE);
        CLASS_STMT = new ORCompositeElementType("CLASS_STMT", RmlLanguage.INSTANCE);
        CLASS_CONSTR = new ORCompositeElementType("CLASS_CONSTR", RmlLanguage.INSTANCE);
        CLASS_PARAMS = new ORCompositeElementType("CLASS_PARAMS", RmlLanguage.INSTANCE);
        CLASS_FIELD = new ORCompositeElementType("CLASS_FIELD", RmlLanguage.INSTANCE);
        CLASS_METHOD = new ORCompositeElementType("CLASS_METHOD", RmlLanguage.INSTANCE);
        OPEN_STMT = new ORCompositeElementType("OPEN_STMT", RmlLanguage.INSTANCE);
        ASSERT_STMT = new ORCompositeElementType("ASSERT_STMT", RmlLanguage.INSTANCE);
        SCOPED_EXPR = new ORCompositeElementType("SCOPED_EXPR", RmlLanguage.INSTANCE);
        FUN_CALL_PARAMS = new ORCompositeElementType("FUN_CALL_PARAMS", RmlLanguage.INSTANCE);
        LET_BINDING = new ORCompositeElementType("LET_BINDING", RmlLanguage.INSTANCE);
        TYPE_CONSTR_NAME = new ORCompositeElementType("TYPE_CONSTR_NAME", RmlLanguage.INSTANCE);
        PATTERN_MATCH_EXPR = new ORCompositeElementType("PATTERN_MATCH_EXPR", RmlLanguage.INSTANCE);
        IF_STMT = new ORCompositeElementType("IF_STMT", RmlLanguage.INSTANCE);
        BIN_CONDITION = new ORCompositeElementType("BIN_CONDITION", RmlLanguage.INSTANCE);
        SWITCH_EXPR = new ORCompositeElementType("SWITCH_EXPR", RmlLanguage.INSTANCE);
        TAG_START = new ORCompositeElementType("TAG_START", RmlLanguage.INSTANCE);
        TAG_CLOSE = new ORCompositeElementType("TAG_CLOSE", RmlLanguage.INSTANCE);
        TAG_PROPERTY = new ORCompositeElementType("TAG_PROPERTY", RmlLanguage.INSTANCE);
        RECORD_EXPR = new ORCompositeElementType("RECORD_EXPR", RmlLanguage.INSTANCE);
        RECORD_FIELD = new ORCompositeElementType("RECORD_FIELD", RmlLanguage.INSTANCE);
        INTERPOLATION_EXPR = new ORCompositeElementType("INTERPOLATION_EXPR", RmlLanguage.INSTANCE);
        TRY_EXPR = new ORCompositeElementType("TRY_EXPR", RmlLanguage.INSTANCE);
        WITH_EXPR = new ORCompositeElementType("WITH_EXPR", RmlLanguage.INSTANCE);
        STRUCT_EXPR = new ORCompositeElementType("STRUCT_EXPR", RmlLanguage.INSTANCE);
        C_ML_INTERPOLATOR = new ORCompositeElementType("C_ML_INTERPOLATOR", RmlLanguage.INSTANCE);

        // Token element types

        ARRAY = new ORTokenElementType("ARRAY", RmlLanguage.INSTANCE);
        BOOL = new ORTokenElementType("BOOL", RmlLanguage.INSTANCE);
        CHAR = new ORTokenElementType("CHAR", RmlLanguage.INSTANCE);
        FLOAT = new ORTokenElementType("FLOAT", RmlLanguage.INSTANCE);
        INT = new ORTokenElementType("INT", RmlLanguage.INSTANCE);
        LIST = new ORTokenElementType("LIST", RmlLanguage.INSTANCE);
        STRING = new ORTokenElementType("STRING", RmlLanguage.INSTANCE);

        BOOL_VALUE = new ORTokenElementType("BOOL_VALUE", RmlLanguage.INSTANCE);
        STRING_VALUE = new ORTokenElementType("STRING_VALUE", RmlLanguage.INSTANCE);
        FLOAT_VALUE = new ORTokenElementType("FLOAT_VALUE", RmlLanguage.INSTANCE);
        CHAR_VALUE = new ORTokenElementType("CHAR_VALUE", RmlLanguage.INSTANCE);
        INT_VALUE = new ORTokenElementType("INT_VALUE", RmlLanguage.INSTANCE);
        EXCEPTION_NAME = new ORTokenElementType("EXCEPTION_NAME", RmlLanguage.INSTANCE);
        PROPERTY_NAME = new ORTokenElementType("PROPERTY_NAME", RmlLanguage.INSTANCE);
        GENERIC_COND = new ORTokenElementType("GENERIC_COND", RmlLanguage.INSTANCE);
        SWITCH = new ORTokenElementType("SWITCH", RmlLanguage.INSTANCE);
        FUNCTION = new ORTokenElementType("FUNCTION", RmlLanguage.INSTANCE);
        FUN = new ORTokenElementType("FUN", RmlLanguage.INSTANCE);
        FUNCTOR = new ORTokenElementType("FUNCTOR", RmlLanguage.INSTANCE);
        UPPER_SYMBOL = new ORTokenElementType("UPPER_SYMBOL", RmlLanguage.INSTANCE);
        IF = new ORTokenElementType("IF", RmlLanguage.INSTANCE);
        LOCAL_OPEN = new ORTokenElementType("LOCAL_OPEN", RmlLanguage.INSTANCE);
        AND = new ORTokenElementType("AND", RmlLanguage.INSTANCE);
        ANDAND = new ORTokenElementType("ANDAND", RmlLanguage.INSTANCE);
        ARROBASE = new ORTokenElementType("ARROBASE", RmlLanguage.INSTANCE);
        ARROW = new ORTokenElementType("ARROW", RmlLanguage.INSTANCE);
        ASSERT = new ORTokenElementType("ASSERT", RmlLanguage.INSTANCE);
        AS = new ORTokenElementType("AS", RmlLanguage.INSTANCE);
        BACKTICK = new ORTokenElementType("BACKTICK", RmlLanguage.INSTANCE);
        BEGIN = new ORTokenElementType("BEGIN", RmlLanguage.INSTANCE);
        CARRET = new ORTokenElementType("CARRET", RmlLanguage.INSTANCE);
        COLON = new ORTokenElementType("COLON", RmlLanguage.INSTANCE);
        COMMA = new ORTokenElementType("COMMA", RmlLanguage.INSTANCE);
        COMMENT = new ORTokenElementType("COMMENT", RmlLanguage.INSTANCE);
        DIFF = new ORTokenElementType("DIFF", RmlLanguage.INSTANCE);
        LT_OR_EQUAL = new ORTokenElementType("LT_OR_EQUAL", RmlLanguage.INSTANCE);
        GT_OR_EQUAL = new ORTokenElementType("GT_OR_EQUAL", RmlLanguage.INSTANCE);
        DOLLAR = new ORTokenElementType("DOLLAR", RmlLanguage.INSTANCE);
        DOT = new ORTokenElementType("DOT", RmlLanguage.INSTANCE);
        DOTDOTDOT = new ORTokenElementType("DOTDOTDOT", RmlLanguage.INSTANCE);
        DO = new ORTokenElementType("DO", RmlLanguage.INSTANCE);
        DONE = new ORTokenElementType("DONE", RmlLanguage.INSTANCE);
        ELSE = new ORTokenElementType("ELSE", RmlLanguage.INSTANCE);
        END = new ORTokenElementType("END", RmlLanguage.INSTANCE);
        ENDIF = new ORTokenElementType("ENDIF", RmlLanguage.INSTANCE);
        NOT_EQ = new ORTokenElementType("EQ", RmlLanguage.INSTANCE);
        NOT_EQEQ = new ORTokenElementType("EQEQ", RmlLanguage.INSTANCE);
        EQ = new ORTokenElementType("EQ", RmlLanguage.INSTANCE);
        EQEQ = new ORTokenElementType("EQEQ", RmlLanguage.INSTANCE);
        EQEQEQ = new ORTokenElementType("EQEQEQ", RmlLanguage.INSTANCE);
        EXCEPTION = new ORTokenElementType("EXCEPTION", RmlLanguage.INSTANCE);
        EXCLAMATION_MARK = new ORTokenElementType("EXCLAMATION_MARK", RmlLanguage.INSTANCE);
        EXTERNAL = new ORTokenElementType("EXTERNAL", RmlLanguage.INSTANCE);
        FOR = new ORTokenElementType("FOR", RmlLanguage.INSTANCE);
        TYPE_ARGUMENT = new ORTokenElementType("TYPE_ARGUMENT", RmlLanguage.INSTANCE);
        GT = new ORTokenElementType("GT", RmlLanguage.INSTANCE);
        IN = new ORTokenElementType("IN", RmlLanguage.INSTANCE);
        LAZY = new ORTokenElementType("LAZY", RmlLanguage.INSTANCE);
        INCLUDE = new ORTokenElementType("INCLUDE", RmlLanguage.INSTANCE);
        LARRAY = new ORTokenElementType("LARRAY", RmlLanguage.INSTANCE);
        LBRACE = new ORTokenElementType("LBRACE", RmlLanguage.INSTANCE);
        LBRACKET = new ORTokenElementType("LBRACKET", RmlLanguage.INSTANCE);
        LET = new ORTokenElementType("LET", RmlLanguage.INSTANCE);
        LIDENT = new ORTokenElementType("LIDENT", RmlLanguage.INSTANCE);
        LPAREN = new ORTokenElementType("LPAREN", RmlLanguage.INSTANCE);
        LT = new ORTokenElementType("LT", RmlLanguage.INSTANCE);
        MATCH = new ORTokenElementType("MATCH", RmlLanguage.INSTANCE);
        MINUS = new ORTokenElementType("MINUS", RmlLanguage.INSTANCE);
        MINUSDOT = new ORTokenElementType("MINUSDOT", RmlLanguage.INSTANCE);
        MODULE = new ORTokenElementType("MODULE", RmlLanguage.INSTANCE);
        MUTABLE = new ORTokenElementType("MUTABLE", RmlLanguage.INSTANCE);
        NONE = new ORTokenElementType("NONE", RmlLanguage.INSTANCE);
        OF = new ORTokenElementType("OF", RmlLanguage.INSTANCE);
        OPEN = new ORTokenElementType("OPEN", RmlLanguage.INSTANCE);
        OPTION = new ORTokenElementType("OPTION", RmlLanguage.INSTANCE);
        POLY_VARIANT = new ORTokenElementType("POLY_VARIANT", RmlLanguage.INSTANCE);
        VARIANT_NAME = new ORTokenElementType("VARIANT_NAME", RmlLanguage.INSTANCE);
        PIPE = new ORTokenElementType("PIPE", RmlLanguage.INSTANCE);
        PIPE_FORWARD = new ORTokenElementType("PIPE_FORWARD", RmlLanguage.INSTANCE);
        PIPE_FIRST = new ORTokenElementType("PIPE_FIRST", RmlLanguage.INSTANCE);
        PLUS = new ORTokenElementType("PLUS", RmlLanguage.INSTANCE);
        PERCENT = new ORTokenElementType("PERCENT", RmlLanguage.INSTANCE);
        PLUSDOT = new ORTokenElementType("PLUSDOT", RmlLanguage.INSTANCE);
        QUESTION_MARK = new ORTokenElementType("QUESTION_MARK", RmlLanguage.INSTANCE);
        QUOTE = new ORTokenElementType("QUOTE", RmlLanguage.INSTANCE);
        RAISE = new ORTokenElementType("RAISE", RmlLanguage.INSTANCE);
        RARRAY = new ORTokenElementType("RARRAY", RmlLanguage.INSTANCE);
        RBRACE = new ORTokenElementType("RBRACE", RmlLanguage.INSTANCE);
        RBRACKET = new ORTokenElementType("RBRACKET", RmlLanguage.INSTANCE);
        REC = new ORTokenElementType("REC", RmlLanguage.INSTANCE);
        REF = new ORTokenElementType("REF", RmlLanguage.INSTANCE);
        RPAREN = new ORTokenElementType("RPAREN", RmlLanguage.INSTANCE);
        SEMI = new ORTokenElementType("SEMI", RmlLanguage.INSTANCE);
        SIG = new ORTokenElementType("SIG", RmlLanguage.INSTANCE);
        SHARP = new ORTokenElementType("SHARP", RmlLanguage.INSTANCE);
        SHARPSHARP = new ORTokenElementType("SHARPSHARP", RmlLanguage.INSTANCE);
        SHORTCUT = new ORTokenElementType("SHORTCUT", RmlLanguage.INSTANCE);
        SLASH = new ORTokenElementType("SLASH", RmlLanguage.INSTANCE);
        SLASHDOT = new ORTokenElementType("SLASHDOT", RmlLanguage.INSTANCE);
        SOME = new ORTokenElementType("SOME", RmlLanguage.INSTANCE);
        STAR = new ORTokenElementType("STAR", RmlLanguage.INSTANCE);
        STARDOT = new ORTokenElementType("STARDOT", RmlLanguage.INSTANCE);
        STRUCT = new ORTokenElementType("STRUCT", RmlLanguage.INSTANCE);
        TAG_AUTO_CLOSE = new ORTokenElementType("TAG_AUTO_CLOSE", RmlLanguage.INSTANCE);
        TAG_NAME = new ORTokenElementType("TAG_NAME", RmlLanguage.INSTANCE);
        TAG_LT = new ORTokenElementType("TAG_LT", RmlLanguage.INSTANCE);
        TAG_LT_SLASH = new ORTokenElementType("TAG_LT_SLASH", RmlLanguage.INSTANCE);
        TAG_GT = new ORTokenElementType("TAG_GT", RmlLanguage.INSTANCE);
        TILDE = new ORTokenElementType("TILDE", RmlLanguage.INSTANCE);
        TO = new ORTokenElementType("TO", RmlLanguage.INSTANCE);
        THEN = new ORTokenElementType("THEN", RmlLanguage.INSTANCE);
        TRY = new ORTokenElementType("TRY", RmlLanguage.INSTANCE);
        TYPE = new ORTokenElementType("TYPE", RmlLanguage.INSTANCE);
        UIDENT = new ORTokenElementType("UIDENT", RmlLanguage.INSTANCE);
        UNIT = new ORTokenElementType("UNIT", RmlLanguage.INSTANCE);
        VAL = new ORTokenElementType("VAL", RmlLanguage.INSTANCE);
        PUB = new ORTokenElementType("PUB", RmlLanguage.INSTANCE);
        PRI = new ORTokenElementType("PRI", RmlLanguage.INSTANCE);
        LOWER_SYMBOL = new ORTokenElementType("LOWER_SYMBOL", RmlLanguage.INSTANCE);
        WHEN = new ORTokenElementType("WHEN", RmlLanguage.INSTANCE);
        WHILE = new ORTokenElementType("WHILE", RmlLanguage.INSTANCE);
        WITH = new ORTokenElementType("WITH", RmlLanguage.INSTANCE);
        RAW = new ORTokenElementType("RAW", RmlLanguage.INSTANCE);

        ASR = new ORTokenElementType("ASR", RmlLanguage.INSTANCE);
        CLASS = new ORTokenElementType("CLASS", RmlLanguage.INSTANCE);
        CONSTRAINT = new ORTokenElementType("CONSTRAINT", RmlLanguage.INSTANCE);
        DOWNTO = new ORTokenElementType("DOWNTO", RmlLanguage.INSTANCE);
        INHERIT = new ORTokenElementType("INHERIT", RmlLanguage.INSTANCE);
        INITIALIZER = new ORTokenElementType("INITIALIZER", RmlLanguage.INSTANCE);
        LAND = new ORTokenElementType("LAND", RmlLanguage.INSTANCE);
        LOR = new ORTokenElementType("LOR", RmlLanguage.INSTANCE);
        LSL = new ORTokenElementType("LSL", RmlLanguage.INSTANCE);
        LSR = new ORTokenElementType("LSR", RmlLanguage.INSTANCE);
        LXOR = new ORTokenElementType("LXOR", RmlLanguage.INSTANCE);
        METHOD = new ORTokenElementType("METHOD", RmlLanguage.INSTANCE);
        MOD = new ORTokenElementType("MOD", RmlLanguage.INSTANCE);
        NEW = new ORTokenElementType("NEW", RmlLanguage.INSTANCE);
        NONREC = new ORTokenElementType("NONREC", RmlLanguage.INSTANCE);
        OR = new ORTokenElementType("OR", RmlLanguage.INSTANCE);
        PRIVATE = new ORTokenElementType("PRIVATE", RmlLanguage.INSTANCE);
        VIRTUAL = new ORTokenElementType("VIRTUAL", RmlLanguage.INSTANCE);

        COLON_EQ = new ORTokenElementType("COLON_EQ", RmlLanguage.INSTANCE);
        COLON_GT = new ORTokenElementType("COLON_GT", RmlLanguage.INSTANCE);
        DOTDOT = new ORTokenElementType("DOTDOT", RmlLanguage.INSTANCE);
        SEMISEMI = new ORTokenElementType("SEMISEMI", RmlLanguage.INSTANCE);
        GT_BRACKET = new ORTokenElementType("GT_BRACKET", RmlLanguage.INSTANCE);
        GT_BRACE = new ORTokenElementType("GT_BRACE", RmlLanguage.INSTANCE);
        LEFT_ARROW = new ORTokenElementType("LEFT_ARROW", RmlLanguage.INSTANCE);
        RIGHT_ARROW = new ORTokenElementType("RIGHT_ARROW", RmlLanguage.INSTANCE);

        OBJECT = new ORTokenElementType("OBJECT", RmlLanguage.INSTANCE);
        RECORD = new ORTokenElementType("RECORD", RmlLanguage.INSTANCE);

        AMPERSAND = new ORTokenElementType("AMPERSAND", RmlLanguage.INSTANCE);
        BRACKET_GT = new ORTokenElementType("BRACKET_GT", RmlLanguage.INSTANCE);
        BRACKET_LT = new ORTokenElementType("BRACKET_LT", RmlLanguage.INSTANCE);
        BRACE_LT = new ORTokenElementType("BRACE_LT", RmlLanguage.INSTANCE);

        ML_STRING_OPEN = new ORTokenElementType("ML_STRING_OPEN", RmlLanguage.INSTANCE);
        ML_STRING_CLOSE = new ORTokenElementType("ML_STRING_CLOSE", RmlLanguage.INSTANCE);
        JS_STRING_OPEN = new ORTokenElementType("JS_STRING_OPEN", RmlLanguage.INSTANCE);
        JS_STRING_CLOSE = new ORTokenElementType("JS_STRING_CLOSE", RmlLanguage.INSTANCE);
        UNDERSCORE = new ORTokenElementType("UNDERSCORE", RmlLanguage.INSTANCE);
    }
}