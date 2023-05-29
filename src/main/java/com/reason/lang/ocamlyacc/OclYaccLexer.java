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
public class OclYaccLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int INITIAL = 2;
  public static final int IN_HEADER = 4;
  public static final int IN_SEMANTIC_ACTION = 6;
  public static final int IN_ML_COMMENT = 8;
  public static final int IN_SL_COMMENT = 10;
  public static final int IN_TRAILER = 12;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2,  2,  3,  3,  4,  4,  5,  5,  6, 6
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
    "\11\0\1\3\1\1\1\41\1\42\1\2\22\0\1\3\4\0\1\5\2\0\1\40\1\43\1\37\3\0\1\30\1"+
    "\36\12\4\1\31\1\32\1\34\1\0\1\35\2\0\32\4\4\0\1\4\1\0\1\16\1\4\1\27\1\4\1"+
    "\13\1\23\1\25\1\26\1\24\1\4\1\12\1\22\1\4\1\14\1\11\1\21\1\4\1\17\1\15\1\10"+
    "\4\4\1\20\1\4\1\6\1\33\1\7\7\0\1\41\242\0\2\41\26\0");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\7\0\1\1\1\2\1\3\1\4\1\2\1\5\1\6"+
    "\1\7\1\10\1\11\1\12\1\13\1\14\2\2\1\15"+
    "\1\16\1\15\1\16\1\17\1\20\1\15\1\21\1\16"+
    "\1\22\1\23\1\24\6\0\1\25\1\26\1\0\1\27"+
    "\1\30\20\0\1\31\3\0\1\32\1\0\1\33\1\0"+
    "\1\34\1\35\2\0\1\36\1\0\1\37";

  private static int [] zzUnpackAction() {
    int [] result = new int[76];
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
    "\0\0\0\44\0\110\0\154\0\220\0\264\0\330\0\374"+
    "\0\374\0\u0120\0\u0144\0\u0168\0\374\0\374\0\374\0\374"+
    "\0\374\0\374\0\374\0\374\0\u018c\0\u01b0\0\374\0\u01d4"+
    "\0\u01f8\0\374\0\374\0\374\0\u021c\0\374\0\u0240\0\374"+
    "\0\374\0\374\0\u0264\0\u0288\0\u02ac\0\u02d0\0\u02f4\0\u0318"+
    "\0\374\0\374\0\u01d4\0\374\0\374\0\u0240\0\u033c\0\u0360"+
    "\0\u0384\0\u03a8\0\u03cc\0\u03f0\0\u0414\0\u0438\0\u045c\0\u0480"+
    "\0\u04a4\0\u04c8\0\u04ec\0\u0510\0\u0534\0\374\0\u0558\0\u057c"+
    "\0\u05a0\0\374\0\u05c4\0\374\0\u05e8\0\374\0\374\0\u060c"+
    "\0\u0630\0\374\0\u0654\0\374";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[76];
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
    "\44\10\1\11\3\12\1\13\1\14\1\15\1\16\20\13"+
    "\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\11"+
    "\1\26\1\11\1\12\1\11\2\27\1\30\2\27\1\31"+
    "\33\27\2\32\3\27\1\30\3\27\1\33\1\34\31\27"+
    "\2\32\3\27\1\30\34\27\1\35\1\27\2\32\2\27"+
    "\1\36\1\37\36\27\2\32\3\27\1\30\36\27\2\32"+
    "\1\27\45\0\3\12\36\0\1\12\5\0\1\13\3\0"+
    "\20\13\21\0\1\40\1\41\1\42\1\43\3\0\1\44"+
    "\1\45\1\0\1\46\2\0\1\47\1\0\1\50\55\0"+
    "\1\51\1\52\43\0\1\52\5\0\1\27\1\53\50\0"+
    "\1\54\72\0\1\55\4\0\1\55\1\0\1\36\1\56"+
    "\52\0\1\57\6\0\1\60\34\0\1\61\42\0\1\62"+
    "\57\0\1\63\32\0\1\64\44\0\1\65\41\0\1\66"+
    "\52\0\1\67\36\0\1\70\45\0\1\71\52\0\1\72"+
    "\41\0\1\73\42\0\1\74\34\0\1\75\43\0\1\76"+
    "\46\0\1\77\44\0\1\100\52\0\1\101\25\0\1\102"+
    "\57\0\1\103\33\0\1\104\44\0\1\105\36\0\1\106"+
    "\43\0\1\107\47\0\1\110\44\0\1\111\41\0\1\112"+
    "\41\0\1\113\61\0\1\114\14\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[1656];
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
    "\7\0\2\11\3\1\10\11\2\1\1\11\2\1\3\11"+
    "\1\1\1\11\1\1\3\11\6\0\2\11\1\0\2\11"+
    "\20\0\1\11\3\0\1\11\1\0\1\11\1\0\2\11"+
    "\2\0\1\11\1\0\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[76];
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
  private OclYaccTypes types;
  private int tokenStartIndex;
  private CharSequence quotedStringId;
  private int braceDepth;
  private boolean rulesDone = false;
  private boolean zzEOFDone = false;
  private boolean zzAtBOL = false;

   public OclYaccLexer() {
      this((java.io.Reader)null);
      this.types = OclYaccTypes.INSTANCE;
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
  public OclYaccLexer(java.io.Reader in) {
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
              yybegin(INITIAL); tokenEnd(); return types.TEMPLATE_OCAML_TEXT;
            }  // fall though
            case 77: break;
            case IN_SEMANTIC_ACTION: {
              yybegin(INITIAL); tokenEnd(); return types.TEMPLATE_OCAML_TEXT;
            }  // fall though
            case 78: break;
            case IN_ML_COMMENT: {
              yybegin(INITIAL); tokenEnd(); return types.MULTI_COMMENT;
            }  // fall though
            case 79: break;
            case IN_SL_COMMENT: {
              yybegin(INITIAL); tokenEnd(); return types.SINGLE_COMMENT;
            }  // fall though
            case 80: break;
            case IN_TRAILER: {
              yybegin(INITIAL); tokenEnd(); return types.TEMPLATE_OCAML_TEXT;
            }  // fall though
            case 81: break;
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
            { yybegin(IN_SEMANTIC_ACTION); braceDepth = 1; tokenStart(); return types.LBRACE;
            } 
            // fall through
          case 36: break;
          case 6: 
            { return types.RBRACE;
            } 
            // fall through
          case 37: break;
          case 7: 
            { return types.DOT;
            } 
            // fall through
          case 38: break;
          case 8: 
            { return types.COLON;
            } 
            // fall through
          case 39: break;
          case 9: 
            { return types.SEMI;
            } 
            // fall through
          case 40: break;
          case 10: 
            { return types.PIPE;
            } 
            // fall through
          case 41: break;
          case 11: 
            { return types.LT;
            } 
            // fall through
          case 42: break;
          case 12: 
            { return types.GT;
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
            { yybegin(INITIAL); tokenEnd(); return types.SINGLE_COMMENT;
            } 
            // fall through
          case 48: break;
          case 18: 
            { if (rulesDone) { yybegin(IN_TRAILER); } rulesDone = true; return types.SECTION_SEPARATOR;
            } 
            // fall through
          case 49: break;
          case 19: 
            { yybegin(IN_HEADER); tokenStart(); return types.HEADER_START;
            } 
            // fall through
          case 50: break;
          case 20: 
            { return types.HEADER_STOP;
            } 
            // fall through
          case 51: break;
          case 21: 
            { yybegin(IN_SL_COMMENT); tokenStart();
            } 
            // fall through
          case 52: break;
          case 22: 
            { yybegin(IN_ML_COMMENT); tokenStart();
            } 
            // fall through
          case 53: break;
          case 23: 
            { yypushback(2); tokenEnd(); yybegin(INITIAL); return types.TEMPLATE_OCAML_TEXT;
            } 
            // fall through
          case 54: break;
          case 24: 
            { yybegin(INITIAL); tokenEnd(); return types.MULTI_COMMENT;
            } 
            // fall through
          case 55: break;
          case 25: 
            { return types.TYPE;
            } 
            // fall through
          case 56: break;
          case 26: 
            { return types.LEFT;
            } 
            // fall through
          case 57: break;
          case 27: 
            { return types.TOKEN;
            } 
            // fall through
          case 58: break;
          case 28: 
            { return types.START;
            } 
            // fall through
          case 59: break;
          case 29: 
            { return types.RIGHT;
            } 
            // fall through
          case 60: break;
          case 30: 
            { return types.INLINE;
            } 
            // fall through
          case 61: break;
          case 31: 
            { return types.NON_ASSOC;
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
