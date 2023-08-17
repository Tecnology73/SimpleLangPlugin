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
    create_token_set_(ASSIGN_EXPR, CALL_EXPR, EXPRESSION, MEMBER_CALL_EXPR,
      VALUE_EXPR),
  };

  /* ********************************************************** */
  // LPAREN (Expression (COMMA Expression)*)? RPAREN
  public static boolean Arguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Arguments")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && Arguments_1(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, ARGUMENTS, r);
    return r;
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
  // Expression (EQ | PLUSEQ | MINUSEQ | MULEQ | DIVEQ) Expression
  public static boolean AssignExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AssignExpr")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _COLLAPSE_, ASSIGN_EXPR, "<assign expr>");
    r = Expression(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, AssignExpr_1(b, l + 1));
    r = p && Expression(b, l + 1) && r;
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
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LCURLY);
    r = r && Block_1(b, l + 1);
    r = r && consumeToken(b, RCURLY);
    exit_section_(b, m, BLOCK, r);
    return r;
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
  // ID Arguments
  public static boolean CallExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CallExpr")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    r = r && Arguments(b, l + 1);
    exit_section_(b, m, CALL_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // CallExpr | MemberCallExpr
  static boolean CallGroup(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CallGroup")) return false;
    boolean r;
    r = CallExpr(b, l + 1);
    if (!r) r = MemberCallExpr(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // NEW_KW ID Arguments
  public static boolean ConstructorCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstructorCall")) return false;
    if (!nextTokenIs(b, NEW_KW)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, NEW_KW, ID);
    r = r && Arguments(b, l + 1);
    exit_section_(b, m, CONSTRUCTOR_CALL, r);
    return r;
  }

  /* ********************************************************** */
  // AssignExpr
  //     | CallGroup
  //     | MemberAccessExpr
  //     | ValueExpr
  public static boolean Expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, EXPRESSION, "<expression>");
    r = AssignExpr(b, l + 1);
    if (!r) r = CallGroup(b, l + 1);
    if (!r) r = MemberAccessExpr(b, l + 1);
    if (!r) r = ValueExpr(b, l + 1);
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
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_DECLARATION, "<function declaration>");
    r = consumeToken(b, FUNC_KW);
    r = r && FunctionDeclaration_1(b, l + 1);
    r = r && FunctionId(b, l + 1);
    r = r && FunctionDeclaration_3(b, l + 1);
    r = r && Parameters(b, l + 1);
    r = r && FunctionDeclaration_5(b, l + 1);
    p = r; // pin = 6
    r = r && Block(b, l + 1);
    exit_section_(b, l, m, r, p, SimpleParser::FunctionDeclarationRecover);
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
  // !(RCURLY | FUNC_KW | TYPE_KW | <<eof>>)
  static boolean FunctionDeclarationRecover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDeclarationRecover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !FunctionDeclarationRecover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // RCURLY | FUNC_KW | TYPE_KW | <<eof>>
  private static boolean FunctionDeclarationRecover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDeclarationRecover_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RCURLY);
    if (!r) r = consumeToken(b, FUNC_KW);
    if (!r) r = consumeToken(b, TYPE_KW);
    if (!r) r = eof(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
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
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LANGLE, ID, RANGLE);
    exit_section_(b, m, FUNCTION_RECEIVER, r);
    return r;
  }

  /* ********************************************************** */
  // LANGLE ID RANGLE
  public static boolean Generic(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Generic")) return false;
    if (!nextTokenIs(b, LANGLE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LANGLE, ID, RANGLE);
    exit_section_(b, m, GENERIC, r);
    return r;
  }

  /* ********************************************************** */
  // Expression DOT ID
  public static boolean MemberAccessExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MemberAccessExpr")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MEMBER_ACCESS_EXPR, "<member access expr>");
    r = Expression(b, l + 1);
    r = r && consumeTokens(b, 1, DOT, ID);
    p = r; // pin = 2
    exit_section_(b, l, m, r, p, SimpleParser::MemberAccessExprRecover);
    return r || p;
  }

  /* ********************************************************** */
  // !(DOT | SEMICOLON | RCURLY | ID | '\n')
  static boolean MemberAccessExprRecover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MemberAccessExprRecover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !MemberAccessExprRecover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DOT | SEMICOLON | RCURLY | ID | '\n'
  private static boolean MemberAccessExprRecover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MemberAccessExprRecover_0")) return false;
    boolean r;
    r = consumeToken(b, DOT);
    if (!r) r = consumeToken(b, SEMICOLON);
    if (!r) r = consumeToken(b, RCURLY);
    if (!r) r = consumeToken(b, ID);
    if (!r) r = consumeToken(b, "\\n");
    return r;
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
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ID, COLON, ID);
    r = r && Parameter_3(b, l + 1);
    exit_section_(b, m, PARAMETER, r);
    return r;
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
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && Parameters_1(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, PARAMETERS, r);
    return r;
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
  // RETURN_KW Expression? SEMICOLON
  public static boolean ReturnStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ReturnStatement")) return false;
    if (!nextTokenIs(b, RETURN_KW)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RETURN_KW);
    r = r && ReturnStatement_1(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, RETURN_STATEMENT, r);
    return r;
  }

  // Expression?
  private static boolean ReturnStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ReturnStatement_1")) return false;
    Expression(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ReturnStatement
  //     | VariableDeclaration
  //     | Expression SEMICOLON
  public static boolean Statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT, "<statement>");
    r = ReturnStatement(b, l + 1);
    if (!r) r = VariableDeclaration(b, l + 1);
    if (!r) r = Statement_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // Expression SEMICOLON
  private static boolean Statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Expression(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // !<<eof>> (TypeDeclaration | FunctionDeclaration)
  public static boolean TopLevelDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TopLevelDeclaration")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, TOP_LEVEL_DECLARATION, "<top level declaration>");
    r = TopLevelDeclaration_0(b, l + 1);
    p = r; // pin = 1
    r = r && TopLevelDeclaration_1(b, l + 1);
    exit_section_(b, l, m, r, p, SimpleParser::TopLevelDeclarationRecover);
    return r || p;
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
    Marker m = enter_section_(b);
    r = TypeDeclaration(b, l + 1);
    if (!r) r = FunctionDeclaration(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // !(SEMICOLON | TYPE_KW | FUNC_KW)
  static boolean TopLevelDeclarationRecover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TopLevelDeclarationRecover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !TopLevelDeclarationRecover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SEMICOLON | TYPE_KW | FUNC_KW
  private static boolean TopLevelDeclarationRecover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TopLevelDeclarationRecover_0")) return false;
    boolean r;
    r = consumeToken(b, SEMICOLON);
    if (!r) r = consumeToken(b, TYPE_KW);
    if (!r) r = consumeToken(b, FUNC_KW);
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
  // LCURLY TypeField* RCURLY
  public static boolean TypeBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeBlock")) return false;
    if (!nextTokenIs(b, LCURLY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LCURLY);
    r = r && TypeBlock_1(b, l + 1);
    r = r && consumeToken(b, RCURLY);
    exit_section_(b, m, TYPE_BLOCK, r);
    return r;
  }

  // TypeField*
  private static boolean TypeBlock_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeBlock_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!TypeField(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "TypeBlock_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // TYPE_KW ID TypeBlock
  public static boolean TypeDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeDeclaration")) return false;
    if (!nextTokenIs(b, TYPE_KW)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, TYPE_KW, ID);
    r = r && TypeBlock(b, l + 1);
    exit_section_(b, m, TYPE_DECLARATION, r);
    return r;
  }

  /* ********************************************************** */
  // ID (
  //         COLON ID EQ ValueExpr   // a: T = value
  //       | COLON ID                    // a: T
  //       | EQ ValueExpr            // a = value
  // ) SEMICOLON
  public static boolean TypeField(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeField")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    r = r && TypeField_1(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, TYPE_FIELD, r);
    return r;
  }

  // COLON ID EQ ValueExpr   // a: T = value
  //       | COLON ID                    // a: T
  //       | EQ ValueExpr
  private static boolean TypeField_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeField_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = TypeField_1_0(b, l + 1);
    if (!r) r = parseTokens(b, 0, COLON, ID);
    if (!r) r = TypeField_1_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COLON ID EQ ValueExpr
  private static boolean TypeField_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeField_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COLON, ID, EQ);
    r = r && ValueExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // EQ ValueExpr
  private static boolean TypeField_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeField_1_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQ);
    r = r && ValueExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
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
  // ID (
  //       COLON ID EQ Expression   // a: T = value
  //     | COLON ID                     // a: T
  //     | EQ Expression                  // a = value
  // ) SEMICOLON
  public static boolean VariableDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDeclaration")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    r = r && VariableDeclaration_1(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, VARIABLE_DECLARATION, r);
    return r;
  }

  // COLON ID EQ Expression   // a: T = value
  //     | COLON ID                     // a: T
  //     | EQ Expression
  private static boolean VariableDeclaration_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDeclaration_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = VariableDeclaration_1_0(b, l + 1);
    if (!r) r = parseTokens(b, 0, COLON, ID);
    if (!r) r = VariableDeclaration_1_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COLON ID EQ Expression
  private static boolean VariableDeclaration_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDeclaration_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COLON, ID, EQ);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // EQ Expression
  private static boolean VariableDeclaration_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDeclaration_1_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQ);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
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
