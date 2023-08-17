// This is a generated file. Not intended for manual editing.
package com.example.sampleplugin.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class SimpleVisitor extends PsiElementVisitor {

  public void visitArguments(@NotNull SimpleArguments o) {
    visitPsiElement(o);
  }

  public void visitAssignExpr(@NotNull SimpleAssignExpr o) {
    visitExpression(o);
  }

  public void visitBlock(@NotNull SimpleBlock o) {
    visitPsiElement(o);
  }

  public void visitConstructorCall(@NotNull SimpleConstructorCall o) {
    visitPsiElement(o);
  }

  public void visitExpression(@NotNull SimpleExpression o) {
    visitPsiElement(o);
  }

  public void visitFunctionCall(@NotNull SimpleFunctionCall o) {
    visitPsiElement(o);
  }

  public void visitFunctionDeclaration(@NotNull SimpleFunctionDeclaration o) {
    visitFunction(o);
  }

  public void visitFunctionId(@NotNull SimpleFunctionId o) {
    visitNamedElement(o);
  }

  public void visitFunctionReceiver(@NotNull SimpleFunctionReceiver o) {
    visitPsiElement(o);
  }

  public void visitGeneric(@NotNull SimpleGeneric o) {
    visitPsiElement(o);
  }

  public void visitMemberAccessExpr(@NotNull SimpleMemberAccessExpr o) {
    visitPsiElement(o);
  }

  public void visitMemberCallExpr(@NotNull SimpleMemberCallExpr o) {
    visitExpression(o);
  }

  public void visitParameter(@NotNull SimpleParameter o) {
    visitPsiElement(o);
  }

  public void visitParameters(@NotNull SimpleParameters o) {
    visitPsiElement(o);
  }

  public void visitPrimaryExpr(@NotNull SimplePrimaryExpr o) {
    visitExpression(o);
  }

  public void visitReturnStatement(@NotNull SimpleReturnStatement o) {
    visitPsiElement(o);
  }

  public void visitStatement(@NotNull SimpleStatement o) {
    visitPsiElement(o);
  }

  public void visitTopLevelDeclaration(@NotNull SimpleTopLevelDeclaration o) {
    visitPsiElement(o);
  }

  public void visitType(@NotNull SimpleType o) {
    visitNamedElement(o);
  }

  public void visitTypeBlock(@NotNull SimpleTypeBlock o) {
    visitPsiElement(o);
  }

  public void visitTypeDeclaration(@NotNull SimpleTypeDeclaration o) {
    visitNamedElement(o);
  }

  public void visitTypeField(@NotNull SimpleTypeField o) {
    visitPsiElement(o);
  }

  public void visitValueExpr(@NotNull SimpleValueExpr o) {
    visitExpression(o);
  }

  public void visitVariableDeclaration(@NotNull SimpleVariableDeclaration o) {
    visitPsiElement(o);
  }

  public void visitFunction(@NotNull SimpleFunction o) {
    visitPsiElement(o);
  }

  public void visitNamedElement(@NotNull SimpleNamedElement o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
