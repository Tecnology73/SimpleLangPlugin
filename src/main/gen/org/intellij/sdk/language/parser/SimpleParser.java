// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static org.intellij.sdk.language.psi.SimpleTypes.*;
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
    b = adapt_builder_(t, b, this, null);
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
  // identifier ASSIGN Expression
  public static boolean AssignExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AssignExpr")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ASSIGN_EXPR, null);
    r = consumeTokens(b, 1, IDENTIFIER, ASSIGN);
    p = r; // pin = 1
    r = r && Expression(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // LBRACE Statement* RBRACE
  public static boolean Block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Block")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && Block_1(b, l + 1);
    r = r && consumeToken(b, RBRACE);
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
  // identifier Arguments
  public static boolean CallExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CallExpr")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
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
  // new TypeName Arguments
  public static boolean ConstructorCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstructorCall")) return false;
    if (!nextTokenIs(b, NEW)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NEW);
    r = r && TypeName(b, l + 1);
    r = r && Arguments(b, l + 1);
    exit_section_(b, m, CONSTRUCTOR_CALL, r);
    return r;
  }

  /* ********************************************************** */
  // AssignExpr
  //     | CallGroup
  //     | ValueExpr
  //     | MemberAccessExpr
  public static boolean Expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION, "<expression>");
    r = AssignExpr(b, l + 1);
    if (!r) r = CallGroup(b, l + 1);
    if (!r) r = ValueExpr(b, l + 1);
    if (!r) r = MemberAccessExpr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // func FunctionReceiver? identifier Generic? Parameters TypeName? Block
  public static boolean Function(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Function")) return false;
    if (!nextTokenIs(b, FUNC)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION, null);
    r = consumeToken(b, FUNC);
    r = r && Function_1(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    p = r; // pin = 3
    r = r && report_error_(b, Function_3(b, l + 1));
    r = p && report_error_(b, Parameters(b, l + 1)) && r;
    r = p && report_error_(b, Function_5(b, l + 1)) && r;
    r = p && Block(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // FunctionReceiver?
  private static boolean Function_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Function_1")) return false;
    FunctionReceiver(b, l + 1);
    return true;
  }

  // Generic?
  private static boolean Function_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Function_3")) return false;
    Generic(b, l + 1);
    return true;
  }

  // TypeName?
  private static boolean Function_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Function_5")) return false;
    TypeName(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // identifier Arguments
  public static boolean FunctionCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionCall")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && Arguments(b, l + 1);
    exit_section_(b, m, FUNCTION_CALL, r);
    return r;
  }

  /* ********************************************************** */
  // LESS_THAN TypeName GREATER_THAN
  public static boolean FunctionReceiver(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionReceiver")) return false;
    if (!nextTokenIs(b, LESS_THAN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LESS_THAN);
    r = r && TypeName(b, l + 1);
    r = r && consumeToken(b, GREATER_THAN);
    exit_section_(b, m, FUNCTION_RECEIVER, r);
    return r;
  }

  /* ********************************************************** */
  // LESS_THAN TypeName GREATER_THAN
  public static boolean Generic(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Generic")) return false;
    if (!nextTokenIs(b, LESS_THAN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LESS_THAN);
    r = r && TypeName(b, l + 1);
    r = r && consumeToken(b, GREATER_THAN);
    exit_section_(b, m, GENERIC, r);
    return r;
  }

  /* ********************************************************** */
  // int | identifier
  public static boolean Literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Literal")) return false;
    if (!nextTokenIs(b, "<literal>", IDENTIFIER, INT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LITERAL, "<literal>");
    r = consumeToken(b, INT);
    if (!r) r = consumeToken(b, IDENTIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Expression DOT identifier
  public static boolean MemberAccessExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MemberAccessExpr")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MEMBER_ACCESS_EXPR, "<member access expr>");
    r = Expression(b, l + 1);
    r = r && consumeTokens(b, 1, DOT, IDENTIFIER);
    p = r; // pin = 2
    exit_section_(b, l, m, r, p, SimpleParser::MemberAccessExprRecover);
    return r || p;
  }

  /* ********************************************************** */
  // !(DOT | semi | RBRACE | identifier | '\n')
  static boolean MemberAccessExprRecover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MemberAccessExprRecover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !MemberAccessExprRecover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DOT | semi | RBRACE | identifier | '\n'
  private static boolean MemberAccessExprRecover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MemberAccessExprRecover_0")) return false;
    boolean r;
    r = consumeToken(b, DOT);
    if (!r) r = semi(b, l + 1);
    if (!r) r = consumeToken(b, RBRACE);
    if (!r) r = consumeToken(b, IDENTIFIER);
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
  // identifier COLON TypeName
  public static boolean Parameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Parameter")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, COLON);
    r = r && TypeName(b, l + 1);
    exit_section_(b, m, PARAMETER, r);
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
  // return Expression? semi
  public static boolean ReturnStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ReturnStatement")) return false;
    if (!nextTokenIs(b, RETURN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RETURN);
    r = r && ReturnStatement_1(b, l + 1);
    r = r && semi(b, l + 1);
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
  //     | Expression semi
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

  // Expression semi
  private static boolean Statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Expression(b, l + 1);
    r = r && semi(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // !<<eof>> (TypeDeclaration | Function) semi
  public static boolean TopLevelDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TopLevelDeclaration")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, TOP_LEVEL_DECLARATION, "<top level declaration>");
    r = TopLevelDeclaration_0(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, TopLevelDeclaration_1(b, l + 1));
    r = p && semi(b, l + 1) && r;
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

  // TypeDeclaration | Function
  private static boolean TopLevelDeclaration_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TopLevelDeclaration_1")) return false;
    boolean r;
    r = TypeDeclaration(b, l + 1);
    if (!r) r = Function(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // !(SEMICOLON | TYPE_ | func)
  static boolean TopLevelDeclarationRecover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TopLevelDeclarationRecover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !TopLevelDeclarationRecover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SEMICOLON | TYPE_ | func
  private static boolean TopLevelDeclarationRecover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TopLevelDeclarationRecover_0")) return false;
    boolean r;
    r = consumeToken(b, SEMICOLON);
    if (!r) r = consumeToken(b, TYPE_);
    if (!r) r = consumeToken(b, FUNC);
    return r;
  }

  /* ********************************************************** */
  // LBRACE TypeField* RBRACE
  public static boolean TypeBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeBlock")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && TypeBlock_1(b, l + 1);
    r = r && consumeToken(b, RBRACE);
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
  // TYPE_ TypeName TypeBlock
  public static boolean TypeDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeDeclaration")) return false;
    if (!nextTokenIs(b, TYPE_)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TYPE_);
    r = r && TypeName(b, l + 1);
    r = r && TypeBlock(b, l + 1);
    exit_section_(b, m, TYPE_DECLARATION, r);
    return r;
  }

  /* ********************************************************** */
  // identifier (
  //         COLON TypeName ASSIGN ValueExpr   // a: T = value
  //       | COLON TypeName                    // a: T
  //       | ASSIGN ValueExpr                  // a = value
  // ) semi
  public static boolean TypeField(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeField")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && TypeField_1(b, l + 1);
    r = r && semi(b, l + 1);
    exit_section_(b, m, TYPE_FIELD, r);
    return r;
  }

  // COLON TypeName ASSIGN ValueExpr   // a: T = value
  //       | COLON TypeName                    // a: T
  //       | ASSIGN ValueExpr
  private static boolean TypeField_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeField_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = TypeField_1_0(b, l + 1);
    if (!r) r = TypeField_1_1(b, l + 1);
    if (!r) r = TypeField_1_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COLON TypeName ASSIGN ValueExpr
  private static boolean TypeField_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeField_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && TypeName(b, l + 1);
    r = r && consumeToken(b, ASSIGN);
    r = r && ValueExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COLON TypeName
  private static boolean TypeField_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeField_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && TypeName(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ASSIGN ValueExpr
  private static boolean TypeField_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeField_1_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASSIGN);
    r = r && ValueExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifier
  public static boolean TypeName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeName")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, TYPE_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // int
  //     | identifier
  //     | ConstructorCall
  public static boolean ValueExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ValueExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VALUE_EXPR, "<value expr>");
    r = consumeToken(b, INT);
    if (!r) r = consumeToken(b, IDENTIFIER);
    if (!r) r = ConstructorCall(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // identifier (
  //       COLON TypeName ASSIGN Expression   // a: T = value
  //     | COLON TypeName                     // a: T
  //     | ASSIGN Expression                  // a = value
  // ) semi
  public static boolean VariableDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDeclaration")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && VariableDeclaration_1(b, l + 1);
    r = r && semi(b, l + 1);
    exit_section_(b, m, VARIABLE_DECLARATION, r);
    return r;
  }

  // COLON TypeName ASSIGN Expression   // a: T = value
  //     | COLON TypeName                     // a: T
  //     | ASSIGN Expression
  private static boolean VariableDeclaration_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDeclaration_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = VariableDeclaration_1_0(b, l + 1);
    if (!r) r = VariableDeclaration_1_1(b, l + 1);
    if (!r) r = VariableDeclaration_1_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COLON TypeName ASSIGN Expression
  private static boolean VariableDeclaration_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDeclaration_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && TypeName(b, l + 1);
    r = r && consumeToken(b, ASSIGN);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COLON TypeName
  private static boolean VariableDeclaration_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDeclaration_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && TypeName(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ASSIGN Expression
  private static boolean VariableDeclaration_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDeclaration_1_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASSIGN);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifier
  public static boolean VariableName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableName")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, VARIABLE_NAME, r);
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

  /* ********************************************************** */
  // SEMICOLON_SYNTHETIC | SEMICOLON | <<eof>>
  static boolean semi(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "semi")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SEMICOLON_SYNTHETIC);
    if (!r) r = consumeToken(b, SEMICOLON);
    if (!r) r = eof(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

}
