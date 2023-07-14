/* The following code was generated by JFlex 1.7.0 tweaked for IntelliJ platform */

package com.reason.lang.ocamlgrammar;

import com.intellij.psi.tree.IElementType;
import com.intellij.lexer.FlexLexer;

import static com.intellij.psi.TokenType.*;

@SuppressWarnings("ALL")

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file <tt>mlg.flex</tt>
 */
public class OclGrammarLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int INITIAL = 2;
  public static final int IN_TEMPLATE = 4;
  public static final int IN_STRING = 6;
  public static final int IN_ML_COMMENT = 8;
  public static final int IN_SL_COMMENT = 10;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2,  2,  3,  3,  4,  4,  5, 5
  };

  /** 
   * Translates characters to character classes
   * Chosen bits are [9, 6, 6]
   * Total runtime size is 1568 bytes
   */
  public static int ZZ_CMAP(int ch) {
    return ZZ_CMAP_A[(ZZ_CMAP_Y[ZZ_CMAP_Z[ch>>12]|((ch>>6)&0x3f)]<<6)|(ch&0x3f)];
  }

  /* The ZZ_CMAP_Z table has 272 entries */
  static final char ZZ_CMAP_Z[] = zzUnpackCMap(
    "\1\0\1\100\1\200\u010d\100");

  /* The ZZ_CMAP_Y table has 192 entries */
  static final char ZZ_CMAP_Y[] = zzUnpackCMap(
    "\1\0\1\1\1\2\175\3\1\4\77\3");

  /* The ZZ_CMAP_A table has 320 entries */
  static final char ZZ_CMAP_A[] = zzUnpackCMap(
    "\11\0\1\3\1\1\1\41\1\42\1\2\22\0\1\3\1\0\1\40\5\0\1\32\1\33\1\37\2\0\1\27"+
    "\1\0\1\36\12\4\4\0\1\30\2\0\1\11\1\4\1\7\1\5\1\6\1\4\1\15\1\4\1\16\2\4\1\10"+
    "\1\20\1\17\1\24\1\13\1\4\1\12\1\4\1\22\1\14\1\21\1\4\1\23\2\4\1\34\1\0\1\35"+
    "\1\0\1\4\1\0\32\4\1\25\1\31\1\26\7\0\1\41\242\0\2\41\26\0");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\6\0\1\1\1\2\1\3\11\4\1\5\1\6\1\2"+
    "\1\7\1\10\1\11\1\12\1\13\1\2\1\14\1\15"+
    "\1\16\1\17\1\20\1\16\1\21\1\15\1\22\1\16"+
    "\11\4\1\23\1\24\1\25\1\0\1\26\1\0\1\4"+
    "\1\27\30\4\1\30\2\4\1\31\1\4\1\32\1\33"+
    "\1\34\1\35\1\4\1\36\1\37";

  private static int [] zzUnpackAction() {
    int [] result = new int[90];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\43\0\106\0\151\0\214\0\257\0\322\0\322"+
    "\0\365\0\u0118\0\u013b\0\u015e\0\u0181\0\u01a4\0\u01c7\0\u01ea"+
    "\0\u020d\0\u0230\0\322\0\322\0\u0253\0\322\0\u0276\0\322"+
    "\0\322\0\322\0\u0299\0\322\0\322\0\u02bc\0\322\0\322"+
    "\0\322\0\322\0\u02df\0\322\0\u0302\0\u0325\0\u0348\0\u036b"+
    "\0\u038e\0\u03b1\0\u03d4\0\u03f7\0\u041a\0\u043d\0\322\0\322"+
    "\0\322\0\u02bc\0\322\0\u0302\0\u0460\0\u0118\0\u0483\0\u04a6"+
    "\0\u04c9\0\u04ec\0\u050f\0\u0532\0\u0555\0\u0578\0\u059b\0\u05be"+
    "\0\u05e1\0\u0604\0\u0627\0\u064a\0\u066d\0\u0690\0\u06b3\0\u06d6"+
    "\0\u06f9\0\u071c\0\u073f\0\u0762\0\u0785\0\u07a8\0\u0118\0\u07cb"+
    "\0\u07ee\0\u0118\0\u0811\0\u0118\0\u0118\0\u0118\0\u0118\0\u0834"+
    "\0\u0118\0\u0118";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[90];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\43\7\1\10\3\11\1\12\1\13\1\14\1\15\1\12"+
    "\1\16\1\12\1\17\1\12\1\20\3\12\1\21\1\22"+
    "\2\12\1\23\1\24\1\25\1\10\1\26\1\27\1\30"+
    "\1\31\1\32\1\33\1\10\1\34\1\10\1\11\2\35"+
    "\1\36\22\35\1\37\1\40\12\35\2\41\2\35\1\36"+
    "\35\35\1\42\2\41\2\35\1\36\34\35\1\43\1\35"+
    "\2\41\1\35\1\44\1\45\36\35\2\41\44\0\3\11"+
    "\36\0\1\11\4\0\21\12\22\0\2\12\1\46\16\12"+
    "\22\0\13\12\1\47\3\12\1\50\1\12\22\0\20\12"+
    "\1\51\22\0\6\12\1\52\12\12\22\0\4\12\1\53"+
    "\14\12\22\0\6\12\1\54\12\12\22\0\2\12\1\55"+
    "\16\12\22\0\5\12\1\56\13\12\46\0\1\57\51\0"+
    "\1\60\41\0\1\61\1\60\4\0\1\35\1\62\73\0"+
    "\1\63\2\0\1\63\5\0\1\44\1\64\44\0\3\12"+
    "\1\65\15\12\22\0\1\12\1\66\17\12\22\0\16\12"+
    "\1\67\2\12\22\0\14\12\1\70\4\12\22\0\11\12"+
    "\1\71\7\12\22\0\10\12\1\72\10\12\22\0\5\12"+
    "\1\73\13\12\22\0\6\12\1\74\12\12\22\0\3\12"+
    "\1\75\15\12\22\0\4\12\1\76\14\12\22\0\2\12"+
    "\1\77\16\12\22\0\14\12\1\100\4\12\22\0\10\12"+
    "\1\101\10\12\22\0\11\12\1\102\7\12\22\0\14\12"+
    "\1\103\4\12\22\0\13\12\1\104\5\12\22\0\16\12"+
    "\1\105\2\12\22\0\5\12\1\106\13\12\22\0\13\12"+
    "\1\107\5\12\22\0\5\12\1\110\13\12\22\0\14\12"+
    "\1\111\4\12\22\0\12\12\1\112\6\12\22\0\14\12"+
    "\1\113\4\12\22\0\5\12\1\114\13\12\22\0\12\12"+
    "\1\115\6\12\22\0\6\12\1\116\12\12\22\0\1\12"+
    "\1\117\17\12\22\0\13\12\1\120\5\12\22\0\2\12"+
    "\1\121\16\12\22\0\13\12\1\122\5\12\22\0\5\12"+
    "\1\123\13\12\22\0\3\12\1\124\15\12\22\0\3\12"+
    "\1\125\15\12\22\0\2\12\1\126\16\12\22\0\1\12"+
    "\1\127\17\12\22\0\13\12\1\130\5\12\22\0\6\12"+
    "\1\131\12\12\22\0\16\12\1\132\2\12\16\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[2135];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String[] ZZ_ERROR_MSG = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\6\0\2\11\12\1\2\11\1\1\1\11\1\1\3\11"+
    "\1\1\2\11\1\1\4\11\1\1\1\11\12\1\3\11"+
    "\1\0\1\11\1\0\46\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[90];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /* user code: */
  private OclGrammarTypes types;
  private int tokenStartIndex;
  private CharSequence quotedStringId;
  private int braceDepth;
  private boolean rulesDone = false;
  private boolean zzEOFDone = false;
  private boolean zzAtBOL = false;

   public OclGrammarLexer() {
      this((java.io.Reader)null);
      this.types = OclGrammarTypes.INSTANCE;
   }

  // Store the start index of a token
  private void tokenStart() {
    tokenStartIndex = zzStartRead;
  }

  // Set the start index of the token to the stored index
  private void tokenEnd() {
    zzStartRead = tokenStartIndex;
  }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public OclGrammarLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    int size = 0;
    for (int i = 0, length = packed.length(); i < length; i += 2) {
      size += packed.charAt(i);
    }
    char[] map = new char[size];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < packed.length()) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd() {
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end, int initialState) {
    zzBuffer = buffer;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      {@code false}, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position {@code pos} from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + ZZ_CMAP(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        zzDoEOF();
        switch (zzLexicalState) {
            case IN_TEMPLATE: {
              yybegin(INITIAL); tokenEnd(); return types.TEMPLATE_OCAML_TEXT;
            }  // fall though
            case 91: break;
            case IN_STRING: {
              yybegin(INITIAL); tokenEnd(); return types.STRING_VALUE;
            }  // fall though
            case 92: break;
            case IN_ML_COMMENT: {
              yybegin(INITIAL); tokenEnd(); return types.MULTI_COMMENT;
            }  // fall though
            case 93: break;
            case IN_SL_COMMENT: {
              yybegin(INITIAL); tokenEnd(); return types.SINGLE_COMMENT;
            }  // fall though
            case 94: break;
            default:
        return null;
        }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { yybegin(INITIAL); yypushback(1);
            } 
            // fall through
          case 32: break;
          case 2: 
            { return types.ATOM;
            } 
            // fall through
          case 33: break;
          case 3: 
            { return WHITE_SPACE;
            } 
            // fall through
          case 34: break;
          case 4: 
            { return types.IDENT;
            } 
            // fall through
          case 35: break;
          case 5: 
            { yybegin(IN_TEMPLATE); braceDepth = 1; tokenStart(); return types.LBRACE;
            } 
            // fall through
          case 36: break;
          case 6: 
            { return types.RBRACE;
            } 
            // fall through
          case 37: break;
          case 7: 
            { return types.PIPE;
            } 
            // fall through
          case 38: break;
          case 8: 
            { return types.LPAREN;
            } 
            // fall through
          case 39: break;
          case 9: 
            { return types.RPAREN;
            } 
            // fall through
          case 40: break;
          case 10: 
            { return types.LBRACKET;
            } 
            // fall through
          case 41: break;
          case 11: 
            { return types.RBRACKET;
            } 
            // fall through
          case 42: break;
          case 12: 
            { yybegin(IN_STRING); tokenStart();
            } 
            // fall through
          case 43: break;
          case 13: 
            { 
            } 
            // fall through
          case 44: break;
          case 14: 
            { return BAD_CHARACTER;
            } 
            // fall through
          case 45: break;
          case 15: 
            { braceDepth += 1;
            } 
            // fall through
          case 46: break;
          case 16: 
            { braceDepth -= 1; if(braceDepth == 0) { yypushback(1); tokenEnd(); yybegin(INITIAL); return types.TEMPLATE_OCAML_TEXT; }
            } 
            // fall through
          case 47: break;
          case 17: 
            { yybegin(INITIAL); tokenEnd(); return types.STRING_VALUE;
            } 
            // fall through
          case 48: break;
          case 18: 
            { yybegin(INITIAL); tokenEnd(); return types.SINGLE_COMMENT;
            } 
            // fall through
          case 49: break;
          case 19: 
            { return types.ARROW;
            } 
            // fall through
          case 50: break;
          case 20: 
            { yybegin(IN_ML_COMMENT); tokenStart();
            } 
            // fall through
          case 51: break;
          case 21: 
            { yybegin(IN_SL_COMMENT); tokenStart();
            } 
            // fall through
          case 52: break;
          case 22: 
            { yybegin(INITIAL); tokenEnd(); return types.MULTI_COMMENT;
            } 
            // fall through
          case 53: break;
          case 23: 
            { return types.END;
            } 
            // fall through
          case 54: break;
          case 24: 
            { return types.EXTEND;
            } 
            // fall through
          case 55: break;
          case 25: 
            { return types.PLUGIN;
            } 
            // fall through
          case 56: break;
          case 26: 
            { return types.VERNAC;
            } 
            // fall through
          case 57: break;
          case 27: 
            { return types.TACTIC;
            } 
            // fall through
          case 58: break;
          case 28: 
            { return types.DECLARE;
            } 
            // fall through
          case 59: break;
          case 29: 
            { return types.COMMAND;
            } 
            // fall through
          case 60: break;
          case 30: 
            { return types.GRAMMAR;
            } 
            // fall through
          case 61: break;
          case 31: 
            { return types.ARGUMENT;
            } 
            // fall through
          case 62: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}