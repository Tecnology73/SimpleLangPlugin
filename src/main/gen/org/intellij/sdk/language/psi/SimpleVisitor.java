// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class SimpleVisitor extends PsiElementVisitor {

  public void visitArguments(@NotNull SimpleArguments o) {
    visitPsiElement(o);
  }

  public void visitBaseExpression(@NotNull SimpleBaseExpression o) {
    visitPsiElement(o);
  }

  public void visitBlock(@NotNull SimpleBlock o) {
    visitPsiElement(o);
  }

  public void visitConstructorCall(@NotNull SimpleConstructorCall o) {
    visitNamedElement(o);
  }

  public void visitExpression(@NotNull SimpleExpression o) {
    visitPsiElement(o);
  }

  public void visitFunction(@NotNull SimpleFunction o) {
    visitNamedElement(o);
  }

  public void visitFunctionCall(@NotNull SimpleFunctionCall o) {
    visitNamedElement(o);
  }

  public void visitGeneric(@NotNull SimpleGeneric o) {
    visitPsiElement(o);
  }

  public void visitMemberAccessExpr(@NotNull SimpleMemberAccessExpr o) {
    visitNamedElement(o);
  }

  public void visitMemberField(@NotNull SimpleMemberField o) {
    visitNamedElement(o);
  }

  public void visitParameters(@NotNull SimpleParameters o) {
    visitPsiElement(o);
  }

  public void visitReturnStatement(@NotNull SimpleReturnStatement o) {
    visitPsiElement(o);
  }

  public void visitStatement(@NotNull SimpleStatement o) {
    visitPsiElement(o);
  }

  public void visitTypeDeclaration(@NotNull SimpleTypeDeclaration o) {
    visitNamedElement(o);
  }

  public void visitTypeName(@NotNull SimpleTypeName o) {
    visitNamedElement(o);
  }

  public void visitVariableDeclaration(@NotNull SimpleVariableDeclaration o) {
    visitNamedElement(o);
  }

  public void visitVariableName(@NotNull SimpleVariableName o) {
    visitPsiElement(o);
  }

  public void visitNamedElement(@NotNull SimpleNamedElement o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
