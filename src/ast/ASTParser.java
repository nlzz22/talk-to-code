/* Generated By:JavaCC: Do not edit this line. ASTParser.java */
package ast;
import java.util.*;
public class ASTParser implements ASTParserConstants {
  public static void main(String args []) throws ParseException
  {
    ASTParser parser = new ASTParser(System.in);
    while (true)
    {
      System.out.println("Reading from standard input...");
      System.out.print("Enter an expression like \u005c"1+(2+3)*4;\u005c" :");
      try
      {
        parser.statement();
        System.out.println("OK");
      }
      catch (Exception e)
      {
        System.out.println("NOK.");
        System.out.println(e.getMessage());
        ASTParser.ReInit(System.in);
      }
      catch (Error e)
      {
        System.out.println("Oops.");
        System.out.println(e.getMessage());
        break;
      }
    }
  }

  static final public ASTExpressionUnitValue value() throws ParseException {
  Token n;
  Token sign;
  ASTExpressionUnitValue valueNode;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INTEGER_LITERAL:
      n = jj_consume_token(INTEGER_LITERAL);
    valueNode = new ASTExpressionUnitValue(n.image);
    //System.out.println(valueNode.print());
    {if (true) return valueNode;}
      break;
    case FLOATING_POINT_LITERAL:
      n = jj_consume_token(FLOATING_POINT_LITERAL);
    valueNode = new ASTExpressionUnitValue(n.image);
    //System.out.println(valueNode.print());
    {if (true) return valueNode;}
      break;
    case CHARACTER_LITERAL:
      n = jj_consume_token(CHARACTER_LITERAL);
    valueNode = new ASTExpressionUnitValue(n.image);
    //System.out.println(valueNode.print());
    {if (true) return valueNode;}
      break;
    case STRING_LITERAL:
      n = jj_consume_token(STRING_LITERAL);
    valueNode = new ASTExpressionUnitValue(n.image);
    //System.out.println(valueNode.print());
    {if (true) return valueNode;}
      break;
    case TRUE:
      n = jj_consume_token(TRUE);
         valueNode = new ASTExpressionUnitValue(n.image);
         {if (true) return valueNode;}
      break;
    case FALSE:
      n = jj_consume_token(FALSE);
    valueNode = new ASTExpressionUnitValue(n.image);
         {if (true) return valueNode;}
      break;
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public String primitive_types() throws ParseException {
 Token n;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case BYTE:
      n = jj_consume_token(BYTE);
                  //System.out.println(n.image);
                  {if (true) return n.image;}
      break;
    case INT:
      n = jj_consume_token(INT);
                  //System.out.println(n.image);
                  {if (true) return n.image;}
      break;
    case CHAR:
      n = jj_consume_token(CHAR);
                  //System.out.println(n.image);
                  {if (true) return n.image;}
      break;
    case DOUBLE:
      n = jj_consume_token(DOUBLE);
                  //System.out.println(n.image);
                  {if (true) return n.image;}
      break;
    case FLOAT:
      n = jj_consume_token(FLOAT);
                  //System.out.println(n.image);
                  {if (true) return n.image;}
      break;
    case LONG:
      n = jj_consume_token(LONG);
                  //System.out.println(n.image);
                  {if (true) return n.image;}
      break;
    case SHORT:
      n = jj_consume_token(SHORT);
                  //System.out.println(n.image);
                  {if (true) return n.image;}
      break;
    case BOOLEAN:
      n = jj_consume_token(BOOLEAN);
                  {if (true) return n.image;}
      break;
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public String types() throws ParseException {
  String type;
  Token n;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFIER:
      n = jj_consume_token(IDENTIFIER);
    {if (true) return n.image;}
      break;
    case BOOLEAN:
    case BYTE:
    case CHAR:
    case DOUBLE:
    case FLOAT:
    case INT:
    case LONG:
    case SHORT:
      type = primitive_types();
    {if (true) return type;}
      break;
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public ASTNode create_variable() throws ParseException {
  String type;
  Token id;
  ASTExpressionAssignment result;
  ASTExpressionUnitIdentifier var;
  ASTExpression exp = new ASTExpression();
    jj_consume_token(CREATE);
    type = types();
    jj_consume_token(VARIABLE);
    id = jj_consume_token(IDENTIFIER);
    exp = expression();
    jj_consume_token(TERMINATOR);
          var = new ASTExpressionUnitIdentifier(id.image,type,true);
          result = new ASTExpressionAssignment();

          result = new ASTExpressionAssignment(var,exp);

          //System.out.println(result.print());
          {if (true) return result;}
    throw new Error("Missing return statement in function");
  }

  static final public ASTExpression fragment() throws ParseException {
  Token var = new Token();
  Token check = new Token();
  ASTExpressionUnitValue v = new ASTExpressionUnitValue();
  ASTExpression result = new ASTExpression();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VALUE:
      jj_consume_token(VALUE);
      v = value();
     {if (true) return v;}
      break;
    case VARIABLE:
      jj_consume_token(VARIABLE);
      var = jj_consume_token(IDENTIFIER);
     {if (true) return new ASTExpressionUnitIdentifier(var.image);}
      break;
    case FUNCTION:
      jj_consume_token(FUNCTION);
     {if (true) return v;}
      break;
    case LPAREN:
      check = jj_consume_token(LPAREN);
      result = expression();
      jj_consume_token(RPAREN);
     result.setQuote();
     {if (true) return result;}
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public ASTExpression term() throws ParseException {
  ArrayList<Token > operators = new ArrayList<Token >();
  ArrayList<ASTExpression > operands = new ArrayList<ASTExpression >();
  Token operator = new Token();
  ASTExpression operand1;
  ASTExpression operand2 = new ASTExpression();
  ASTExpression result;
    operand1 = fragment();
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INFIX_OPERATOR:
        ;
        break;
      default:
        jj_la1[4] = jj_gen;
        break label_1;
      }
      operator = jj_consume_token(INFIX_OPERATOR);
         operators.add(operator);
      operand2 = fragment();
         operands.add(operand2);
    }
                if(operator.image == null||operators.isEmpty())
                {
                  result = operand1;
                  {if (true) return result;}
                }
                result = new ASTExpression();
                while(!operators.isEmpty())
                {
                        result = new ASTExpressionInfixOperation(operators.remove(0).image,operand1,operands.remove(0));
                        operand1 = result;
                }
                {if (true) return result;}
    throw new Error("Missing return statement in function");
  }

  static final public ASTExpression infix_expression() throws ParseException {
  ASTExpression result;
    result = term();
                {if (true) return result;}
    throw new Error("Missing return statement in function");
  }

  static final public ASTExpression prefix_expression() throws ParseException {
  Token operator1;
  Token operator2;
  Token var_name;
  ASTExpressionUnitValue v = new ASTExpressionUnitValue();
  ASTExpressionUnitIdentifier i = new ASTExpressionUnitIdentifier();
  ASTExpressionPrefixOperation result;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case TEXT_BIT_NOT:
      operator1 = jj_consume_token(TEXT_BIT_NOT);
      jj_consume_token(VALUE);
      v = value();
          result = new ASTExpressionPrefixOperation(operator1.image,v);
          {if (true) return result;}
      break;
    case PREFIX_OPERATOR:
      operator2 = jj_consume_token(PREFIX_OPERATOR);
      jj_consume_token(VARIABLE);
      var_name = jj_consume_token(IDENTIFIER);
          result = new ASTExpressionPrefixOperation();

          i = new ASTExpressionUnitIdentifier(var_name.image);
          result = new ASTExpressionPrefixOperation(operator2.image,i);

          {if (true) return result;}
      break;
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public ASTExpression postfix_expression() throws ParseException {
  Token operator;
  Token var;
    jj_consume_token(POST);
    jj_consume_token(VARIABLE);
    var = jj_consume_token(IDENTIFIER);
    operator = jj_consume_token(POSTFIX_OPERATOR);
    ASTExpressionUnitIdentifier i = new ASTExpressionUnitIdentifier(var.image);
    ASTExpressionPostfixOperation result = new ASTExpressionPostfixOperation(operator.image,i);
    //System.out.println(result.typeof());
        {if (true) return result;}
    throw new Error("Missing return statement in function");
  }

  static final public ASTExpression expression() throws ParseException {
  ASTExpression result1 = new ASTExpression();
  ASTExpression result2 = new ASTExpression();
  ASTExpression result3 = new ASTExpression();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PREFIX_OPERATOR:
    case TEXT_BIT_NOT:
      result1 = prefix_expression();
        //System.out.println("image"+result.print());
        //System.out.println("Hi");
          {if (true) return result1;}
      break;
    case LPAREN:
    case VARIABLE:
    case VALUE:
    case FUNCTION:
      result2 = infix_expression();
          //System.out.println("image"+result2.print());
          //System.out.println("result3 "+result3.typeof());
          {if (true) return result2;}
      break;
    case POST:
      result3 = postfix_expression();
          //System.out.println("image"+result.print());
          //System.out.println(result3.typeof());
          {if (true) return result3;}
      break;
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public ASTNode compoundStatement() throws ParseException {
  Token var;
  Token operator;
  ASTExpression exp;
    jj_consume_token(VARIABLE);
    var = jj_consume_token(IDENTIFIER);
    operator = jj_consume_token(COMPOUND_OPERATOR);
    exp = expression();
    jj_consume_token(TERMINATOR);
    ASTExpressionUnitIdentifier variable = new ASTExpressionUnitIdentifier(var.image);
    ASTExpressionInfixOperation result = new ASTExpressionInfixOperation(operator.image,variable,exp);
    result.end();
    {if (true) return result;}
    throw new Error("Missing return statement in function");
  }

  static final public ASTNode assignment() throws ParseException {
  Token var;
  ASTExpression exp;
    jj_consume_token(ASSIGNMENT);
    jj_consume_token(VARIABLE);
    var = jj_consume_token(IDENTIFIER);
    jj_consume_token(WITH);
    exp = expression();
    jj_consume_token(TERMINATOR);
          ASTExpressionUnitIdentifier variable = new ASTExpressionUnitIdentifier(var.image);
          ASTExpressionAssignment result = new ASTExpressionAssignment(variable,exp);
          //System.out.println(result.print());
          {if (true) return result;}
    throw new Error("Missing return statement in function");
  }

  static final public ASTIfStatement if_statement() throws ParseException {
  ASTExpression condition;
  ASTNode stat1;
  ASTNode stat2;
  ArrayList<ASTNode > ifStat = new ArrayList<ASTNode >();
  ArrayList<ASTNode > elseStat = new ArrayList<ASTNode >();
    jj_consume_token(IF);
    jj_consume_token(CONDITION);
    condition = expression();
    jj_consume_token(IF_BRANCH_START);
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IF:
      case PREFIX_OPERATOR:
      case TEXT_BIT_NOT:
      case ASSIGNMENT:
      case CREATE:
      case VARIABLE:
      case POST:
        ;
        break;
      default:
        jj_la1[7] = jj_gen;
        break label_2;
      }
      stat1 = statement();
   ifStat.add(stat1);
    }
    jj_consume_token(IF_BRANCH_END);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ELSE_BRANCH_START:
      jj_consume_token(ELSE_BRANCH_START);
      label_3:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case IF:
        case PREFIX_OPERATOR:
        case TEXT_BIT_NOT:
        case ASSIGNMENT:
        case CREATE:
        case VARIABLE:
        case POST:
          ;
          break;
        default:
          jj_la1[8] = jj_gen;
          break label_3;
        }
        stat2 = statement();
   elseStat.add(stat2);
      }
      jj_consume_token(ELSE_BRANCH_END);
      break;
    default:
      jj_la1[9] = jj_gen;
      ;
    }
    jj_consume_token(TERMINATOR);
    //System.out.println(condition.print());
        ASTIfStatement result = new ASTIfStatement(condition,ifStat,elseStat);

        //System.out.println(result.print());	
    {if (true) return result;}
    throw new Error("Missing return statement in function");
  }

  static final public ASTNode statement() throws ParseException {
  ASTNode result;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ASSIGNMENT:
      result = assignment();
       //System.out.println(result.print());
       {if (true) return result;}
      break;
    case IF:
      result = if_statement();
       //System.out.println(result.print());
       {if (true) return result;}
      break;
    case CREATE:
      result = create_variable();
        //System.out.println(result.print());
                {if (true) return result;}
      break;
    case VARIABLE:
      result = compoundStatement();
        //System.out.println(result.print());
                {if (true) return result;}
      break;
    case PREFIX_OPERATOR:
    case TEXT_BIT_NOT:
      result = prefix_expression();
      jj_consume_token(TERMINATOR);
       //System.out.println(result.print());
       {if (true) return result;}
      break;
    case POST:
      result = postfix_expression();
      jj_consume_token(TERMINATOR);
       //System.out.println(result.print());
       {if (true) return result;}
      break;
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public ASTParserTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[11];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static private int[] jj_la1_2;
  static private int[] jj_la1_3;
  static private int[] jj_la1_4;
  static private int[] jj_la1_5;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
      jj_la1_init_2();
      jj_la1_init_3();
      jj_la1_init_4();
      jj_la1_init_5();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x0,0x4a00000,0x4a00000,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x10,0x2014081,0x2014081,0x0,0x0,0x0,0x0,0x400,0x400,0x0,0x400,};
   }
   private static void jj_la1_init_2() {
      jj_la1_2 = new int[] {0x61108,0x0,0x0,0x80000,0x0,0x0,0x80000,0x0,0x0,0x0,0x0,};
   }
   private static void jj_la1_init_3() {
      jj_la1_3 = new int[] {0x0,0x0,0x0,0x0,0x4000000,0x0,0x0,0x0,0x0,0x0,0x0,};
   }
   private static void jj_la1_init_4() {
      jj_la1_4 = new int[] {0x0,0x0,0x0,0x0,0x0,0x8800000,0x8800000,0x8800000,0x8800000,0x0,0x8800000,};
   }
   private static void jj_la1_init_5() {
      jj_la1_5 = new int[] {0x0,0x0,0x40000,0xe0,0x0,0x0,0x100e0,0x1002c,0x1002c,0x2000,0x1002c,};
   }

  /** Constructor with InputStream. */
  public ASTParser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public ASTParser(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new ASTParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public ASTParser(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new ASTParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public ASTParser(ASTParserTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(ASTParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 11; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[181];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 11; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
          if ((jj_la1_2[i] & (1<<j)) != 0) {
            la1tokens[64+j] = true;
          }
          if ((jj_la1_3[i] & (1<<j)) != 0) {
            la1tokens[96+j] = true;
          }
          if ((jj_la1_4[i] & (1<<j)) != 0) {
            la1tokens[128+j] = true;
          }
          if ((jj_la1_5[i] & (1<<j)) != 0) {
            la1tokens[160+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 181; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
