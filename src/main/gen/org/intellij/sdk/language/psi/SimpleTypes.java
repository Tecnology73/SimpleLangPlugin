// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import org.intellij.sdk.language.psi.impl.*;

public interface SimpleTypes {

  IElementType ARGUMENTS = new SimpleElementType("ARGUMENTS");
  IElementType BLOCK = new SimpleElementType("BLOCK");
  IElementType CONSTRUCTOR_CALL = new SimpleElementType("CONSTRUCTOR_CALL");
  IElementType EXPRESSION = new SimpleElementType("EXPRESSION");
  IElementType FUNCTION = new SimpleElementType("FUNCTION");
  IElementType PARAMETERS = new SimpleElementType("PARAMETERS");
  IElementType RETURN_STATEMENT = new SimpleElementType("RETURN_STATEMENT");
  IElementType STATEMENT = new SimpleElementType("STATEMENT");
  IElementType TYPE_DECLARATION = new SimpleElementType("TYPE_DECLARATION");
  IElementType VARIABLE_DECLARATION = new SimpleElementType("VARIABLE_DECLARATION");

  IElementType ASSIGN = new SimpleTokenType("=");
  IElementType COLON = new SimpleTokenType(":");
  IElementType COMMA = new SimpleTokenType(",");
  IElementType DOT = new SimpleTokenType(".");
  IElementType DOUBLE_DOT = new SimpleTokenType("..");
  IElementType EQUAL = new SimpleTokenType("==");
  IElementType FUNC = new SimpleTokenType("func");
  IElementType IDENTIFIER = new SimpleTokenType("identifier");
  IElementType INT = new SimpleTokenType("int");
  IElementType LBRACE = new SimpleTokenType("{");
  IElementType LBRACK = new SimpleTokenType("[");
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
      else if (type == VARIABLE_DECLARATION) {
        return new SimpleVariableDeclarationImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
