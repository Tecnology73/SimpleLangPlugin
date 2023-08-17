// This is a generated file. Not intended for manual editing.
package com.example.sampleplugin.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.example.sampleplugin.psi.impl.*;

public interface SimpleTypes {

  IElementType ARGUMENTS = new SimpleElementType("ARGUMENTS");
  IElementType ASSIGN_EXPR = new SimpleElementType("ASSIGN_EXPR");
  IElementType BLOCK = new SimpleElementType("BLOCK");
  IElementType CONSTRUCTOR_CALL = new SimpleElementType("CONSTRUCTOR_CALL");
  IElementType EXPRESSION = new SimpleElementType("EXPRESSION");
  IElementType FUNCTION_CALL = new SimpleElementType("FUNCTION_CALL");
  IElementType FUNCTION_DECLARATION = new SimpleElementType("FUNCTION_DECLARATION");
  IElementType FUNCTION_ID = new SimpleElementType("FUNCTION_ID");
  IElementType FUNCTION_RECEIVER = new SimpleElementType("FUNCTION_RECEIVER");
  IElementType GENERIC = new SimpleElementType("GENERIC");
  IElementType MEMBER_ACCESS_EXPR = new SimpleElementType("MEMBER_ACCESS_EXPR");
  IElementType MEMBER_CALL_EXPR = new SimpleElementType("MEMBER_CALL_EXPR");
  IElementType PARAMETER = new SimpleElementType("PARAMETER");
  IElementType PARAMETERS = new SimpleElementType("PARAMETERS");
  IElementType PRIMARY_EXPR = new SimpleElementType("PRIMARY_EXPR");
  IElementType RETURN_STATEMENT = new SimpleElementType("RETURN_STATEMENT");
  IElementType STATEMENT = new SimpleElementType("STATEMENT");
  IElementType TOP_LEVEL_DECLARATION = new SimpleElementType("TOP_LEVEL_DECLARATION");
  IElementType TYPE = new SimpleElementType("TYPE");
  IElementType TYPE_BLOCK = new SimpleElementType("TYPE_BLOCK");
  IElementType TYPE_DECLARATION = new SimpleElementType("TYPE_DECLARATION");
  IElementType TYPE_FIELD = new SimpleElementType("TYPE_FIELD");
  IElementType VALUE_EXPR = new SimpleElementType("VALUE_EXPR");
  IElementType VARIABLE_DECLARATION = new SimpleElementType("VARIABLE_DECLARATION");

  IElementType AND = new SimpleTokenType("&&");
  IElementType BLOCK_COMMENT = new SimpleTokenType("BLOCK_COMMENT");
  IElementType COLON = new SimpleTokenType(":");
  IElementType COLONCOLON = new SimpleTokenType("::");
  IElementType COMMA = new SimpleTokenType(",");
  IElementType DIV = new SimpleTokenType("/");
  IElementType DIVEQ = new SimpleTokenType("/=");
  IElementType DOT = new SimpleTokenType(".");
  IElementType DOTDOT = new SimpleTokenType("..");
  IElementType EQ = new SimpleTokenType("=");
  IElementType EQEQ = new SimpleTokenType("==");
  IElementType FUNC_KW = new SimpleTokenType("func");
  IElementType GE = new SimpleTokenType(">=");
  IElementType ID = new SimpleTokenType("ID");
  IElementType LANGLE = new SimpleTokenType("<");
  IElementType LBRACK = new SimpleTokenType("[");
  IElementType LCURLY = new SimpleTokenType("{");
  IElementType LE = new SimpleTokenType("<=");
  IElementType LINE_COMMENT = new SimpleTokenType("LINE_COMMENT");
  IElementType LPAREN = new SimpleTokenType("(");
  IElementType MINUS = new SimpleTokenType("-");
  IElementType MINUSEQ = new SimpleTokenType("-=");
  IElementType MUL = new SimpleTokenType("*");
  IElementType MULEQ = new SimpleTokenType("*=");
  IElementType NE = new SimpleTokenType("!=");
  IElementType NEW_KW = new SimpleTokenType("new");
  IElementType NOT = new SimpleTokenType("!");
  IElementType OR = new SimpleTokenType("||");
  IElementType PLUS = new SimpleTokenType("+");
  IElementType PLUSEQ = new SimpleTokenType("+=");
  IElementType RANGLE = new SimpleTokenType(">");
  IElementType RBRACK = new SimpleTokenType("]");
  IElementType RCURLY = new SimpleTokenType("}");
  IElementType RETURN_KW = new SimpleTokenType("return");
  IElementType RPAREN = new SimpleTokenType(")");
  IElementType SEMICOLON = new SimpleTokenType(";");
  IElementType TYPE_KW = new SimpleTokenType("type");
  IElementType VALUE_BOOL = new SimpleTokenType("VALUE_BOOL");
  IElementType VALUE_FLOAT = new SimpleTokenType("VALUE_FLOAT");
  IElementType VALUE_INTEGER = new SimpleTokenType("VALUE_INTEGER");
  IElementType VALUE_NULL = new SimpleTokenType("VALUE_NULL");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ARGUMENTS) {
        return new SimpleArgumentsImpl(node);
      }
      else if (type == ASSIGN_EXPR) {
        return new SimpleAssignExprImpl(node);
      }
      else if (type == BLOCK) {
        return new SimpleBlockImpl(node);
      }
      else if (type == CONSTRUCTOR_CALL) {
        return new SimpleConstructorCallImpl(node);
      }
      else if (type == EXPRESSION) {
        return new SimpleExpressionImpl(node);
      }
      else if (type == FUNCTION_CALL) {
        return new SimpleFunctionCallImpl(node);
      }
      else if (type == FUNCTION_DECLARATION) {
        return new SimpleFunctionDeclarationImpl(node);
      }
      else if (type == FUNCTION_ID) {
        return new SimpleFunctionIdImpl(node);
      }
      else if (type == FUNCTION_RECEIVER) {
        return new SimpleFunctionReceiverImpl(node);
      }
      else if (type == GENERIC) {
        return new SimpleGenericImpl(node);
      }
      else if (type == MEMBER_ACCESS_EXPR) {
        return new SimpleMemberAccessExprImpl(node);
      }
      else if (type == MEMBER_CALL_EXPR) {
        return new SimpleMemberCallExprImpl(node);
      }
      else if (type == PARAMETER) {
        return new SimpleParameterImpl(node);
      }
      else if (type == PARAMETERS) {
        return new SimpleParametersImpl(node);
      }
      else if (type == PRIMARY_EXPR) {
        return new SimplePrimaryExprImpl(node);
      }
      else if (type == RETURN_STATEMENT) {
        return new SimpleReturnStatementImpl(node);
      }
      else if (type == STATEMENT) {
        return new SimpleStatementImpl(node);
      }
      else if (type == TOP_LEVEL_DECLARATION) {
        return new SimpleTopLevelDeclarationImpl(node);
      }
      else if (type == TYPE) {
        return new SimpleTypeImpl(node);
      }
      else if (type == TYPE_BLOCK) {
        return new SimpleTypeBlockImpl(node);
      }
      else if (type == TYPE_DECLARATION) {
        return new SimpleTypeDeclarationImpl(node);
      }
      else if (type == TYPE_FIELD) {
        return new SimpleTypeFieldImpl(node);
      }
      else if (type == VALUE_EXPR) {
        return new SimpleValueExprImpl(node);
      }
      else if (type == VARIABLE_DECLARATION) {
        return new SimpleVariableDeclarationImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
