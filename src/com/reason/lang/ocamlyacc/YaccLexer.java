/* The following code was generated by JFlex 1.7.0 tweaked for IntelliJ platform */

package com.reason.lang.ocamlyacc;

import com.intellij.psi.tree.IElementType;
import com.intellij.lexer.FlexLexer;

import static com.intellij.psi.TokenType.*;

@SuppressWarnings("ALL")

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file <tt>mly.flex</tt>
 */
class YaccLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int INITIAL = 2;
  public static final int IN_HEADER = 4;
  public static final int IN_SEMANTIC_ACTION = 6;
  public static final int IN_COMMENT = 8;
  public static final int IN_TRAILER = 10;

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
    "\11\0\1\3\1\1\1\37\1\40\1\2\22\0\1\3\4\0\1\5\2\0\1\35\1\0\1\36\3\0\1\27\1"+
    "\35\12\4\1\30\1\31\1\33\1\0\1\34\2\0\32\4\4\0\1\4\1\0\1\16\3\4\1\13\1\23\1"+
    "\25\1\26\1\24\1\4\1\12\1\22\1\4\1\14\1\11\1\21\1\4\1\17\1\15\1\10\4\4\1\20"+
    "\1\4\1\6\1\32\1\7\7\0\1\37\242\0\2\37\26\0");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\6\0\1\1\1\2\1\3\1\4\1\2\1\5\1\6"+
    "\1\7\1\10\1\11\1\12\1\13\1\14\1\2\1\15"+
    "\1\2\1\15\1\16\1\17\1\20\1\2\1\21\1\22"+
    "\1\23\4\0\1\24\1\0\1\25\14\0\1\26\2\0"+
    "\1\27\1\30\1\31\1\32";

  private static int [] zzUnpackAction() {
    int [] result = new int[56];
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
    "\0\0\0\41\0\102\0\143\0\204\0\245\0\306\0\306"+
    "\0\347\0\u0108\0\u0129\0\306\0\306\0\306\0\306\0\306"+
    "\0\306\0\306\0\306\0\u014a\0\306\0\u016b\0\u018c\0\306"+
    "\0\306\0\306\0\u01ad\0\306\0\306\0\306\0\u01ce\0\u01ef"+
    "\0\u0210\0\u0231\0\306\0\u016b\0\306\0\u01ad\0\u0252\0\u0273"+
    "\0\u0294\0\u02b5\0\u02d6\0\u02f7\0\u0318\0\u0339\0\u035a\0\u037b"+
    "\0\u039c\0\306\0\u03bd\0\u03de\0\306\0\306\0\306\0\306";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[56];
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
    "\41\7\1\10\3\11\1\12\1\13\1\14\1\15\17\12"+
    "\1\16\1\17\1\20\1\21\1\22\1\23\1\24\2\10"+
    "\1\11\2\25\1\26\2\25\1\27\31\25\2\10\2\25"+
    "\1\26\3\25\1\30\1\31\27\25\2\10\1\25\1\32"+
    "\1\33\34\25\2\10\2\25\1\26\34\25\2\10\42\0"+
    "\3\11\34\0\1\11\4\0\1\12\3\0\17\12\17\0"+
    "\1\34\1\35\1\36\1\37\4\0\1\40\1\0\1\41"+
    "\2\0\1\42\54\0\1\43\3\0\1\25\1\44\45\0"+
    "\1\45\32\0\1\32\1\46\47\0\1\47\6\0\1\50"+
    "\30\0\1\51\54\0\1\52\27\0\1\53\37\0\1\54"+
    "\47\0\1\55\35\0\1\56\47\0\1\57\36\0\1\60"+
    "\30\0\1\61\40\0\1\62\44\0\1\63\47\0\1\64"+
    "\22\0\1\65\44\0\1\66\34\0\1\67\40\0\1\70"+
    "\30\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[1023];
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
    "\6\0\2\11\3\1\10\11\1\1\1\11\2\1\3\11"+
    "\1\1\3\11\4\0\1\11\1\0\1\11\14\0\1\11"+
    "\2\0\4\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[56];
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

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
  private int tokenStartIndex;
  private CharSequence quotedStringId;
  private int braceDepth;
  private boolean rulesDone = false;

   public YaccLexer() {
      this((java.io.Reader)null);
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
  YaccLexer(java.io.Reader in) {
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
            case IN_HEADER: {
              yybegin(INITIAL); tokenEnd(); return OclYaccTypes.INSTANCE.OCAML_LAZY_NODE;
            }  // fall though
            case 57: break;
            case IN_SEMANTIC_ACTION: {
              yybegin(INITIAL); tokenEnd(); return OclYaccTypes.INSTANCE.OCAML_LAZY_NODE;
            }  // fall though
            case 58: break;
            case IN_COMMENT: {
              yybegin(INITIAL); tokenEnd(); return OclYaccTypes.INSTANCE.SINGLE_COMMENT;
            }  // fall though
            case 59: break;
            case IN_TRAILER: {
              yybegin(INITIAL); tokenEnd(); return OclYaccTypes.INSTANCE.OCAML_LAZY_NODE;
            }  // fall though
            case 60: break;
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
          case 27: break;
          case 2: 
            { return BAD_CHARACTER;
            } 
            // fall through
          case 28: break;
          case 3: 
            { return WHITE_SPACE;
            } 
            // fall through
          case 29: break;
          case 4: 
            { return OclYaccTypes.INSTANCE.IDENT;
            } 
            // fall through
          case 30: break;
          case 5: 
            { yybegin(IN_SEMANTIC_ACTION); braceDepth = 1; tokenStart(); return OclYaccTypes.INSTANCE.LBRACE;
            } 
            // fall through
          case 31: break;
          case 6: 
            { return OclYaccTypes.INSTANCE.RBRACE;
            } 
            // fall through
          case 32: break;
          case 7: 
            { return OclYaccTypes.INSTANCE.DOT;
            } 
            // fall through
          case 33: break;
          case 8: 
            { return OclYaccTypes.INSTANCE.COLON;
            } 
            // fall through
          case 34: break;
          case 9: 
            { return OclYaccTypes.INSTANCE.SEMI;
            } 
            // fall through
          case 35: break;
          case 10: 
            { return OclYaccTypes.INSTANCE.PIPE;
            } 
            // fall through
          case 36: break;
          case 11: 
            { return OclYaccTypes.INSTANCE.LT;
            } 
            // fall through
          case 37: break;
          case 12: 
            { return OclYaccTypes.INSTANCE.GT;
            } 
            // fall through
          case 38: break;
          case 13: 
            { 
            } 
            // fall through
          case 39: break;
          case 14: 
            { braceDepth += 1;
            } 
            // fall through
          case 40: break;
          case 15: 
            { braceDepth -= 1; if(braceDepth == 0) { yypushback(1); tokenEnd(); yybegin(INITIAL); return OclYaccTypes.INSTANCE.OCAML_LAZY_NODE; }
            } 
            // fall through
          case 41: break;
          case 16: 
            { yybegin(INITIAL); tokenEnd(); return OclYaccTypes.INSTANCE.SINGLE_COMMENT;
            } 
            // fall through
          case 42: break;
          case 17: 
            { if (rulesDone) { yybegin(IN_TRAILER); } rulesDone = true; return OclYaccTypes.INSTANCE.SECTION_SEPARATOR;
            } 
            // fall through
          case 43: break;
          case 18: 
            { yybegin(IN_HEADER); tokenStart(); return OclYaccTypes.INSTANCE.HEADER_START;
            } 
            // fall through
          case 44: break;
          case 19: 
            { return OclYaccTypes.INSTANCE.HEADER_STOP;
            } 
            // fall through
          case 45: break;
          case 20: 
            { yybegin(IN_COMMENT); tokenStart();
            } 
            // fall through
          case 46: break;
          case 21: 
            { yypushback(2); tokenEnd(); yybegin(INITIAL); return OclYaccTypes.INSTANCE.OCAML_LAZY_NODE;
            } 
            // fall through
          case 47: break;
          case 22: 
            { return OclYaccTypes.INSTANCE.TYPE;
            } 
            // fall through
          case 48: break;
          case 23: 
            { return OclYaccTypes.INSTANCE.LEFT;
            } 
            // fall through
          case 49: break;
          case 24: 
            { return OclYaccTypes.INSTANCE.TOKEN;
            } 
            // fall through
          case 50: break;
          case 25: 
            { return OclYaccTypes.INSTANCE.START;
            } 
            // fall through
          case 51: break;
          case 26: 
            { return OclYaccTypes.INSTANCE.RIGHT;
            } 
            // fall through
          case 52: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
