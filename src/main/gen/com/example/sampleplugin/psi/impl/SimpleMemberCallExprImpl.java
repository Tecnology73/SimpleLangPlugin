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

public class SimpleMemberCallExprImpl extends SimpleMemberCallExprMixinImpl implements SimpleMemberCallExpr {

  public SimpleMemberCallExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SimpleVisitor visitor) {
    visitor.visitMemberCallExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SimpleVisitor) accept((SimpleVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public SimpleArguments getArguments() {
    return findNotNullChildByClass(SimpleArguments.class);
  }

  @Override
  @NotNull
  public SimpleMemberAccessExpr getMemberAccessExpr() {
    return findNotNullChildByClass(SimpleMemberAccessExpr.class);
  }

  @Override
  @Nullable
  public PsiReference getReference() {
    return SimplePsiImplUtil.getReference(this);
  }

}
