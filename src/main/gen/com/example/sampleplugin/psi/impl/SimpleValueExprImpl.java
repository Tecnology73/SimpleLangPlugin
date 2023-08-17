// This is a generated file. Not intended for manual editing.
package com.example.sampleplugin.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.example.sampleplugin.psi.SimpleTypes.*;
import com.example.sampleplugin.psi.*;

public class SimpleValueExprImpl extends SimpleExpressionImpl implements SimpleValueExpr {

  public SimpleValueExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull SimpleVisitor visitor) {
    visitor.visitValueExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SimpleVisitor) accept((SimpleVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SimpleConstructorCall getConstructorCall() {
    return findChildByClass(SimpleConstructorCall.class);
  }

  @Override
  @Nullable
  public PsiElement getId() {
    return findChildByType(ID);
  }

  @Override
  @Nullable
  public PsiElement getValueBool() {
    return findChildByType(VALUE_BOOL);
  }

  @Override
  @Nullable
  public PsiElement getValueFloat() {
    return findChildByType(VALUE_FLOAT);
  }

  @Override
  @Nullable
  public PsiElement getValueInteger() {
    return findChildByType(VALUE_INTEGER);
  }

  @Override
  @Nullable
  public PsiElement getValueNull() {
    return findChildByType(VALUE_NULL);
  }

}
