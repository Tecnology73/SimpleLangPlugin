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
  // LPAREN (Literal COMMA?)* RPAREN
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

  // (Literal COMMA?)*
  private static boolean Arguments_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Arguments_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Arguments_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Arguments_1", c)) break;
    }
    return true;
  }

  // Literal COMMA?
  private static boolean Arguments_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Arguments_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Literal(b, l + 1);
    r = r && Arguments_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean Arguments_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Arguments_1_0_1")) return false;
    consumeToken(b, COMMA);
    return true;
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
  // new identifier Arguments
  public static boolean ConstructorCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstructorCall")) return false;
    if (!nextTokenIs(b, NEW)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, NEW, IDENTIFIER);
    r = r && Arguments(b, l + 1);
    exit_section_(b, m, CONSTRUCTOR_CALL, r);
    return r;
  }

  /* ********************************************************** */
  // Literal | ConstructorCall
  public static boolean Expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION, "<expression>");
    r = Literal(b, l + 1);
    if (!r) r = ConstructorCall(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // func identifier Parameters identifier? Block
  public static boolean Function(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Function")) return false;
    if (!nextTokenIs(b, FUNC)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, FUNC, IDENTIFIER);
    r = r && Parameters(b, l + 1);
    r = r && Function_3(b, l + 1);
    r = r && Block(b, l + 1);
    exit_section_(b, m, FUNCTION, r);
    return r;
  }

  // identifier?
  private static boolean Function_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Function_3")) return false;
    consumeToken(b, IDENTIFIER);
    return true;
  }

  /* ********************************************************** */
  // int
  //     | identifier
  static boolean Literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Literal")) return false;
    if (!nextTokenIs(b, "", IDENTIFIER, INT)) return false;
    boolean r;
    r = consumeToken(b, INT);
    if (!r) r = consumeToken(b, IDENTIFIER);
    return r;
  }

  /* ********************************************************** */
  // LPAREN (identifier COLON identifier COMMA?)* RPAREN
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

  // (identifier COLON identifier COMMA?)*
  private static boolean Parameters_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Parameters_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Parameters_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Parameters_1", c)) break;
    }
    return true;
  }

  // identifier COLON identifier COMMA?
  private static boolean Parameters_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Parameters_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, COLON, IDENTIFIER);
    r = r && Parameters_1_0_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean Parameters_1_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Parameters_1_0_3")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // return Expression?
  public static boolean ReturnStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ReturnStatement")) return false;
    if (!nextTokenIs(b, RETURN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RETURN);
    r = r && ReturnStatement_1(b, l + 1);
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
  // (
  //       ReturnStatement
  //     | VariableDeclaration
  //     | ConstructorCall
  // ) semi
  public static boolean Statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT, "<statement>");
    r = Statement_0(b, l + 1);
    r = r && semi(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ReturnStatement
  //     | VariableDeclaration
  //     | ConstructorCall
  private static boolean Statement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement_0")) return false;
    boolean r;
    r = ReturnStatement(b, l + 1);
    if (!r) r = VariableDeclaration(b, l + 1);
    if (!r) r = ConstructorCall(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // TypeDeclaration
  //     | Function
  static boolean TopDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TopDeclaration")) return false;
    if (!nextTokenIs(b, "", FUNC, TYPE_)) return false;
    boolean r;
    r = TypeDeclaration(b, l + 1);
    if (!r) r = Function(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // !<<eof>> TopDeclaration semi
  static boolean TopLevelDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TopLevelDeclaration")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = TopLevelDeclaration_0(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, TopDeclaration(b, l + 1));
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
  // TYPE_ identifier Block
  public static boolean TypeDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeDeclaration")) return false;
    if (!nextTokenIs(b, TYPE_)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, TYPE_, IDENTIFIER);
    r = r && Block(b, l + 1);
    exit_section_(b, m, TYPE_DECLARATION, r);
    return r;
  }

  /* ********************************************************** */
  // identifier (COLON identifier)? ASSIGN Expression  // a: T = value
  //     | identifier COLON identifier                       // a: T
  //     | identifier ASSIGN Expression
  public static boolean VariableDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDeclaration")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = VariableDeclaration_0(b, l + 1);
    if (!r) r = parseTokens(b, 0, IDENTIFIER, COLON, IDENTIFIER);
    if (!r) r = VariableDeclaration_2(b, l + 1);
    exit_section_(b, m, VARIABLE_DECLARATION, r);
    return r;
  }

  // identifier (COLON identifier)? ASSIGN Expression
  private static boolean VariableDeclaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDeclaration_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && VariableDeclaration_0_1(b, l + 1);
    r = r && consumeToken(b, ASSIGN);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COLON identifier)?
  private static boolean VariableDeclaration_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDeclaration_0_1")) return false;
    VariableDeclaration_0_1_0(b, l + 1);
    return true;
  }

  // COLON identifier
  private static boolean VariableDeclaration_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDeclaration_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COLON, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  // identifier ASSIGN Expression
  private static boolean VariableDeclaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDeclaration_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, ASSIGN);
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

  /* ********************************************************** */
  // '<NL>' | ';' | <<eof>>
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