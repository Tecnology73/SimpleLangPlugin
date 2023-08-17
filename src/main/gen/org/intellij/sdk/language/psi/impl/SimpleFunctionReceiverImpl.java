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

public class SimpleFunctionReceiverImpl extends ASTWrapperPsiElement implements SimpleFunctionReceiver {

  public SimpleFunctionReceiverImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SimpleVisitor visitor) {
    visitor.visitFunctionReceiver(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SimpleVisitor) accept((SimpleVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public SimpleTypeName getTypeName() {
    return findNotNullChildByClass(SimpleTypeName.class);
  }

  @Override
  @NotNull
  public PsiElement getGreaterThan() {
    return findNotNullChildByType(GREATER_THAN);
  }

  @Override
  @NotNull
  public PsiElement getLessThan() {
    return findNotNullChildByType(LESS_THAN);
  }

}
