// This is a generated file. Not intended for manual editing.
package com.example.sampleplugin.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.example.sampleplugin.psi.SimpleTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class SimpleParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, EXTENDS_SETS_);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return program(b, l + 1);
  }

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(ASSIGN_EXPR, EXPRESSION, MEMBER_CALL_EXPR, PRIMARY_EXPR,
      VALUE_EXPR),
  };

  /* ********************************************************** */
  // LPAREN (Expression (COMMA Expression)*)? RPAREN
  public static boolean Arguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Arguments")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ARGUMENTS, null);
    r = consumeToken(b, LPAREN);
    p = r; // pin = 1
    r = r && report_error_(b, Arguments_1(b, l + 1));
    r = p && consumeToken(b, RPAREN) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (Expression (COMMA Expression)*)?
  private static boolean Arguments_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Arguments_1")) return false;
    Arguments_1_0(b, l + 1);
    return true;
  }

  // Expression (COMMA Expression)*
  private static boolean Arguments_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Arguments_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Expression(b, l + 1);
    r = r && Arguments_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA Expression)*
  private static boolean Arguments_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Arguments_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Arguments_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Arguments_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA Expression
  private static boolean Arguments_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Arguments_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PrimaryExpr (EQ | PLUSEQ | MINUSEQ | MULEQ | DIVEQ) Expression
  public static boolean AssignExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AssignExpr")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _COLLAPSE_, ASSIGN_EXPR, "<assign expr>");
    r = PrimaryExpr(b, l + 1);
    r = r && AssignExpr_1(b, l + 1);
    p = r; // pin = 2
    r = r && Expression(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // EQ | PLUSEQ | MINUSEQ | MULEQ | DIVEQ
  private static boolean AssignExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AssignExpr_1")) return false;
    boolean r;
    r = consumeToken(b, EQ);
    if (!r) r = consumeToken(b, PLUSEQ);
    if (!r) r = consumeToken(b, MINUSEQ);
    if (!r) r = consumeToken(b, MULEQ);
    if (!r) r = consumeToken(b, DIVEQ);
    return r;
  }

  /* ********************************************************** */
  // LCURLY Statement* RCURLY
  public static boolean Block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Block")) return false;
    if (!nextTokenIs(b, LCURLY)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, BLOCK, null);
    r = consumeToken(b, LCURLY);
    p = r; // pin = 1
    r = r && report_error_(b, Block_1(b, l + 1));
    r = p && consumeToken(b, RCURLY) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // Statement*
  private static boolean Block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Block_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Block_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // NEW_KW ID Arguments
  public static boolean ConstructorCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstructorCall")) return false;
    if (!nextTokenIs(b, NEW_KW)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CONSTRUCTOR_CALL, null);
    r = consumeTokens(b, 1, NEW_KW, ID);
    p = r; // pin = 1
    r = r && Arguments(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // MemberCallExpr
  //     | MemberAccessExpr
  //     | AssignExpr
  //     | PrimaryExpr
  public static boolean Expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, EXPRESSION, "<expression>");
    r = MemberCallExpr(b, l + 1);
    if (!r) r = MemberAccessExpr(b, l + 1);
    if (!r) r = AssignExpr(b, l + 1);
    if (!r) r = PrimaryExpr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ID Arguments
  public static boolean FunctionCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionCall")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    r = r && Arguments(b, l + 1);
    exit_section_(b, m, FUNCTION_CALL, r);
    return r;
  }

  /* ********************************************************** */
  // FUNC_KW FunctionReceiver? FunctionId Generic? Parameters ID? Block
  public static boolean FunctionDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDeclaration")) return false;
    if (!nextTokenIs(b, FUNC_KW)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_DECLARATION, null);
    r = consumeToken(b, FUNC_KW);
    p = r; // pin = 1
    r = r && report_error_(b, FunctionDeclaration_1(b, l + 1));
    r = p && report_error_(b, FunctionId(b, l + 1)) && r;
    r = p && report_error_(b, FunctionDeclaration_3(b, l + 1)) && r;
    r = p && report_error_(b, Parameters(b, l + 1)) && r;
    r = p && report_error_(b, FunctionDeclaration_5(b, l + 1)) && r;
    r = p && Block(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // FunctionReceiver?
  private static boolean FunctionDeclaration_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDeclaration_1")) return false;
    FunctionReceiver(b, l + 1);
    return true;
  }

  // Generic?
  private static boolean FunctionDeclaration_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDeclaration_3")) return false;
    Generic(b, l + 1);
    return true;
  }

  // ID?
  private static boolean FunctionDeclaration_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDeclaration_5")) return false;
    consumeToken(b, ID);
    return true;
  }

  /* ********************************************************** */
  // ID
  public static boolean FunctionId(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionId")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    exit_section_(b, m, FUNCTION_ID, r);
    return r;
  }

  /* ********************************************************** */
  // LANGLE ID RANGLE
  public static boolean FunctionReceiver(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionReceiver")) return false;
    if (!nextTokenIs(b, LANGLE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_RECEIVER, null);
    r = consumeTokens(b, 1, LANGLE, ID, RANGLE);
    p = r; // pin = 1
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // LANGLE ID RANGLE
  public static boolean Generic(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Generic")) return false;
    if (!nextTokenIs(b, LANGLE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, GENERIC, null);
    r = consumeTokens(b, 1, LANGLE, ID, RANGLE);
    p = r; // pin = 1
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // PrimaryExpr DOT ID
  public static boolean MemberAccessExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MemberAccessExpr")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MEMBER_ACCESS_EXPR, "<member access expr>");
    r = PrimaryExpr(b, l + 1);
    r = r && consumeTokens(b, 1, DOT, ID);
    p = r; // pin = 2
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // MemberAccessExpr Arguments
  public static boolean MemberCallExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MemberCallExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MEMBER_CALL_EXPR, "<member call expr>");
    r = MemberAccessExpr(b, l + 1);
    r = r && Arguments(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ID COLON ID (EQ Expression)?
  public static boolean Parameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Parameter")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, PARAMETER, null);
    r = consumeTokens(b, 1, ID, COLON, ID);
    p = r; // pin = 1
    r = r && Parameter_3(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (EQ Expression)?
  private static boolean Parameter_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Parameter_3")) return false;
    Parameter_3_0(b, l + 1);
    return true;
  }

  // EQ Expression
  private static boolean Parameter_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Parameter_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQ);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LPAREN (Parameter (COMMA Parameter)*)? RPAREN
  public static boolean Parameters(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Parameters")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, PARAMETERS, null);
    r = consumeToken(b, LPAREN);
    p = r; // pin = 1
    r = r && report_error_(b, Parameters_1(b, l + 1));
    r = p && consumeToken(b, RPAREN) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (Parameter (COMMA Parameter)*)?
  private static boolean Parameters_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Parameters_1")) return false;
    Parameters_1_0(b, l + 1);
    return true;
  }

  // Parameter (COMMA Parameter)*
  private static boolean Parameters_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Parameters_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Parameter(b, l + 1);
    r = r && Parameters_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA Parameter)*
  private static boolean Parameters_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Parameters_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Parameters_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Parameters_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA Parameter
  private static boolean Parameters_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Parameters_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && Parameter(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // FunctionCall
  //     | ValueExpr
  public static boolean PrimaryExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrimaryExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, PRIMARY_EXPR, "<primary expr>");
    r = FunctionCall(b, l + 1);
    if (!r) r = ValueExpr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // RETURN_KW Expression?
  public static boolean ReturnStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ReturnStatement")) return false;
    if (!nextTokenIs(b, RETURN_KW)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, RETURN_STATEMENT, null);
    r = consumeToken(b, RETURN_KW);
    p = r; // pin = 1
    r = r && ReturnStatement_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // Expression?
  private static boolean ReturnStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ReturnStatement_1")) return false;
    Expression(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (
  //       ReturnStatement
  //     | VariableDeclaration
  //     | Expression
  // ) SEMICOLON
  public static boolean Statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT, "<statement>");
    r = Statement_0(b, l + 1);
    p = r; // pin = 1
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ReturnStatement
  //     | VariableDeclaration
  //     | Expression
  private static boolean Statement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement_0")) return false;
    boolean r;
    r = ReturnStatement(b, l + 1);
    if (!r) r = VariableDeclaration(b, l + 1);
    if (!r) r = Expression(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // !<<eof>> (TypeDeclaration | FunctionDeclaration)
  public static boolean TopLevelDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TopLevelDeclaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TOP_LEVEL_DECLARATION, "<top level declaration>");
    r = TopLevelDeclaration_0(b, l + 1);
    r = r && TopLevelDeclaration_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // !<<eof>>
  private static boolean TopLevelDeclaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TopLevelDeclaration_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !eof(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // TypeDeclaration | FunctionDeclaration
  private static boolean TopLevelDeclaration_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TopLevelDeclaration_1")) return false;
    boolean r;
    r = TypeDeclaration(b, l + 1);
    if (!r) r = FunctionDeclaration(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // ID
  public static boolean Type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Type")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    exit_section_(b, m, TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // LCURLY (TypeField SEMICOLON)* RCURLY
  public static boolean TypeBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeBlock")) return false;
    if (!nextTokenIs(b, LCURLY)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, TYPE_BLOCK, null);
    r = consumeToken(b, LCURLY);
    p = r; // pin = 1
    r = r && report_error_(b, TypeBlock_1(b, l + 1));
    r = p && consumeToken(b, RCURLY) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (TypeField SEMICOLON)*
  private static boolean TypeBlock_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeBlock_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!TypeBlock_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "TypeBlock_1", c)) break;
    }
    return true;
  }

  // TypeField SEMICOLON
  private static boolean TypeBlock_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeBlock_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = TypeField(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // TYPE_KW Type TypeBlock
  public static boolean TypeDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeDeclaration")) return false;
    if (!nextTokenIs(b, TYPE_KW)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, TYPE_DECLARATION, null);
    r = consumeToken(b, TYPE_KW);
    p = r; // pin = 1
    r = r && report_error_(b, Type(b, l + 1));
    r = p && TypeBlock(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // ID (TypeFieldWithType | TypeFieldWithoutType)
  public static boolean TypeField(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeField")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    r = r && TypeField_1(b, l + 1);
    exit_section_(b, m, TYPE_FIELD, r);
    return r;
  }

  // TypeFieldWithType | TypeFieldWithoutType
  private static boolean TypeField_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeField_1")) return false;
    boolean r;
    r = TypeFieldWithType(b, l + 1);
    if (!r) r = TypeFieldWithoutType(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // COLON ID (EQ Expression)?
  static boolean TypeFieldWithType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeFieldWithType")) return false;
    if (!nextTokenIs(b, COLON)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeTokens(b, 1, COLON, ID);
    p = r; // pin = 1
    r = r && TypeFieldWithType_2(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (EQ Expression)?
  private static boolean TypeFieldWithType_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeFieldWithType_2")) return false;
    TypeFieldWithType_2_0(b, l + 1);
    return true;
  }

  // EQ Expression
  private static boolean TypeFieldWithType_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeFieldWithType_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQ);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // EQ Expression
  static boolean TypeFieldWithoutType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeFieldWithoutType")) return false;
    if (!nextTokenIs(b, EQ)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, EQ);
    p = r; // pin = 1
    r = r && Expression(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // ConstructorCall
  //     | VALUE_INTEGER
  //     | VALUE_FLOAT
  //     | VALUE_NULL
  //     | VALUE_BOOL
  //     | ID
  public static boolean ValueExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ValueExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VALUE_EXPR, "<value expr>");
    r = ConstructorCall(b, l + 1);
    if (!r) r = consumeToken(b, VALUE_INTEGER);
    if (!r) r = consumeToken(b, VALUE_FLOAT);
    if (!r) r = consumeToken(b, VALUE_NULL);
    if (!r) r = consumeToken(b, VALUE_BOOL);
    if (!r) r = consumeToken(b, ID);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // COLON ID (EQ Expression)?
  static boolean VarDeclWithType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarDeclWithType")) return false;
    if (!nextTokenIs(b, COLON)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeTokens(b, 1, COLON, ID);
    p = r; // pin = 1
    r = r && VarDeclWithType_2(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (EQ Expression)?
  private static boolean VarDeclWithType_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarDeclWithType_2")) return false;
    VarDeclWithType_2_0(b, l + 1);
    return true;
  }

  // EQ Expression
  private static boolean VarDeclWithType_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarDeclWithType_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQ);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // EQ Expression
  static boolean VarDeclWithoutType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarDeclWithoutType")) return false;
    if (!nextTokenIs(b, EQ)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, EQ);
    p = r; // pin = 1
    r = r && Expression(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // ID (VarDeclWithType | VarDeclWithoutType)
  public static boolean VariableDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDeclaration")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    r = r && VariableDeclaration_1(b, l + 1);
    exit_section_(b, m, VARIABLE_DECLARATION, r);
    return r;
  }

  // VarDeclWithType | VarDeclWithoutType
  private static boolean VariableDeclaration_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDeclaration_1")) return false;
    boolean r;
    r = VarDeclWithType(b, l + 1);
    if (!r) r = VarDeclWithoutType(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // TopLevelDeclaration*
  static boolean program(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "program")) return false;
    while (true) {
      int c = current_position_(b);
      if (!TopLevelDeclaration(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "program", c)) break;
    }
    return true;
  }

}
