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
import com.intellij.psi.PsiReference;

public class SimpleMemberAccessExprImpl extends SimpleMemberAccessExprMixinImpl implements SimpleMemberAccessExpr {

  public SimpleMemberAccessExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SimpleVisitor visitor) {
    visitor.visitMemberAccessExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SimpleVisitor) accept((SimpleVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public SimpleExpression getExpression() {
    return findNotNullChildByClass(SimpleExpression.class);
  }

  @Override
  @NotNull
  public PsiElement getDot() {
    return findNotNullChildByType(DOT);
  }

  @Override
  @Nullable
  public PsiElement getId() {
    return findChildByType(ID);
  }

  @Override
  @Nullable
  public PsiReference getReference() {
    return SimplePsiImplUtil.getReference(this);
  }

}
