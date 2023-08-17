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

public class SimpleFunctionDeclarationImpl extends SimpleFunctionImpl implements SimpleFunctionDeclaration {

  public SimpleFunctionDeclarationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SimpleVisitor visitor) {
    visitor.visitFunctionDeclaration(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SimpleVisitor) accept((SimpleVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SimpleBlock getBlock() {
    return findChildByClass(SimpleBlock.class);
  }

  @Override
  @NotNull
  public SimpleFunctionId getFunctionId() {
    return findNotNullChildByClass(SimpleFunctionId.class);
  }

  @Override
  @Nullable
  public SimpleFunctionReceiver getFunctionReceiver() {
    return findChildByClass(SimpleFunctionReceiver.class);
  }

  @Override
  @Nullable
  public SimpleGeneric getGeneric() {
    return findChildByClass(SimpleGeneric.class);
  }

  @Override
  @NotNull
  public SimpleParameters getParameters() {
    return findNotNullChildByClass(SimpleParameters.class);
  }

  @Override
  @NotNull
  public PsiElement getFuncKw() {
    return findNotNullChildByType(FUNC_KW);
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
