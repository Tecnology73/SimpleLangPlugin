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

public class SimpleAssignExprImpl extends SimpleExpressionImpl implements SimpleAssignExpr {

  public SimpleAssignExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull SimpleVisitor visitor) {
    visitor.visitAssignExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SimpleVisitor) accept((SimpleVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<SimpleExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SimpleExpression.class);
  }

  @Override
  @Nullable
  public PsiElement getDiveq() {
    return findChildByType(DIVEQ);
  }

  @Override
  @Nullable
  public PsiElement getEq() {
    return findChildByType(EQ);
  }

  @Override
  @Nullable
  public PsiElement getMinuseq() {
    return findChildByType(MINUSEQ);
  }

  @Override
  @Nullable
  public PsiElement getMuleq() {
    return findChildByType(MULEQ);
  }

  @Override
  @Nullable
  public PsiElement getPluseq() {
    return findChildByType(PLUSEQ);
  }

}
