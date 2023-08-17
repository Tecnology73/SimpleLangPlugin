// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.intellij.sdk.language.psi.SimpleTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import org.intellij.sdk.language.psi.*;

public class SimpleExpressionImpl extends ASTWrapperPsiElement implements SimpleExpression {

  public SimpleExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SimpleVisitor visitor) {
    visitor.visitExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SimpleVisitor) accept((SimpleVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SimpleAssignExpr getAssignExpr() {
    return findChildByClass(SimpleAssignExpr.class);
  }

  @Override
  @Nullable
  public SimpleCallExpr getCallExpr() {
    return findChildByClass(SimpleCallExpr.class);
  }

  @Override
  @Nullable
  public SimpleMemberAccessExpr getMemberAccessExpr() {
    return findChildByClass(SimpleMemberAccessExpr.class);
  }

  @Override
  @Nullable
  public SimpleMemberCallExpr getMemberCallExpr() {
    return findChildByClass(SimpleMemberCallExpr.class);
  }

  @Override
  @Nullable
  public SimpleValueExpr getValueExpr() {
    return findChildByClass(SimpleValueExpr.class);
  }

}
