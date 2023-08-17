// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import org.intellij.sdk.language.psi.impl.*;

public interface SimpleTypes {

  IElementType ARGUMENTS = new SimpleElementType("ARGUMENTS");
  IElementType BASE_EXPRESSION = new SimpleElementType("BASE_EXPRESSION");
  IElementType BLOCK = new SimpleElementType("BLOCK");
  IElementType CONSTRUCTOR_CALL = new SimpleElementType("CONSTRUCTOR_CALL");
  IElementType EXPRESSION = new SimpleElementType("EXPRESSION");
  IElementType FUNCTION = new SimpleElementType("FUNCTION");
  IElementType FUNCTION_CALL = new SimpleElementType("FUNCTION_CALL");
  IElementType GENERIC = new SimpleElementType("GENERIC");
  IElementType MEMBER_ACCESS_EXPR = new SimpleElementType("MEMBER_ACCESS_EXPR");
  IElementType MEMBER_FIELD = new SimpleElementType("MEMBER_FIELD");
  IElementType PARAMETERS = new SimpleElementType("PARAMETERS");
  IElementType RETURN_STATEMENT = new SimpleElementType("RETURN_STATEMENT");
  IElementType STATEMENT = new SimpleElementType("STATEMENT");
  IElementType TYPE_DECLARATION = new SimpleElementType("TYPE_DECLARATION");
  IElementType TYPE_NAME = new SimpleElementType("TYPE_NAME");
  IElementType VARIABLE_DECLARATION = new SimpleElementType("VARIABLE_DECLARATION");
  IElementType VARIABLE_NAME = new SimpleElementType("VARIABLE_NAME");

  IElementType ASSIGN = new SimpleTokenType("=");
  IElementType COLON = new SimpleTokenType(":");
  IElementType COMMA = new SimpleTokenType(",");
  IElementType DOT = new SimpleTokenType(".");
  IElementType DOUBLE_DOT = new SimpleTokenType("..");
  IElementType EQUAL = new SimpleTokenType("==");
  IElementType FUNC = new SimpleTokenType("func");
  IElementType GREATER_THAN = new SimpleTokenType(">");
  IElementType IDENTIFIER = new SimpleTokenType("identifier");
  IElementType INT = new SimpleTokenType("int");
  IElementType LBRACE = new SimpleTokenType("{");
  IElementType LBRACK = new SimpleTokenType("[");
  IElementType LESS_THAN = new SimpleTokenType("<");
  IElementType LPAREN = new SimpleTokenType("(");
  IElementType NEW = new SimpleTokenType("new");
  IElementType RBRACE = new SimpleTokenType("}");
  IElementType RBRACK = new SimpleTokenType("]");
  IElementType RETURN = new SimpleTokenType("return");
  IElementType RPAREN = new SimpleTokenType(")");
  IElementType SEMICOLON = new SimpleTokenType(";");
  IElementType SEMICOLON_SYNTHETIC = new SimpleTokenType("<NL>");
  IElementType TYPE_ = new SimpleTokenType("type");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ARGUMENTS) {
        return new SimpleArgumentsImpl(node);
      }
      else if (type == BASE_EXPRESSION) {
        return new SimpleBaseExpressionImpl(node);
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
      else if (type == FUNCTION) {
        return new SimpleFunctionImpl(node);
      }
      else if (type == FUNCTION_CALL) {
        return new SimpleFunctionCallImpl(node);
      }
      else if (type == GENERIC) {
        return new SimpleGenericImpl(node);
      }
      else if (type == MEMBER_ACCESS_EXPR) {
        return new SimpleMemberAccessExprImpl(node);
      }
      else if (type == MEMBER_FIELD) {
        return new SimpleMemberFieldImpl(node);
      }
      else if (type == PARAMETERS) {
        return new SimpleParametersImpl(node);
      }
      else if (type == RETURN_STATEMENT) {
        return new SimpleReturnStatementImpl(node);
      }
      else if (type == STATEMENT) {
        return new SimpleStatementImpl(node);
      }
      else if (type == TYPE_DECLARATION) {
        return new SimpleTypeDeclarationImpl(node);
      }
      else if (type == TYPE_NAME) {
        return new SimpleTypeNameImpl(node);
      }
      else if (type == VARIABLE_DECLARATION) {
        return new SimpleVariableDeclarationImpl(node);
      }
      else if (type == VARIABLE_NAME) {
        return new SimpleVariableNameImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
