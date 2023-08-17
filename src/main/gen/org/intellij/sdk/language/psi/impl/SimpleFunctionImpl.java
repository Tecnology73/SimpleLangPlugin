// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.intellij.sdk.language.psi.SimpleTypes.*;
import org.intellij.sdk.language.psi.*;

public class SimpleFunctionImpl extends com.example.sampleplugin.psi.impl.SimpleFunctionImpl implements SimpleFunction {

  public SimpleFunctionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SimpleVisitor visitor) {
    visitor.visitFunction(this);
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
  @Nullable
  public SimpleParameters getParameters() {
    return findChildByClass(SimpleParameters.class);
  }

  @Override
  @Nullable
  public SimpleTypeName getTypeName() {
    return findChildByClass(SimpleTypeName.class);
  }

  @Override
  @NotNull
  public PsiElement getFunc() {
    return findNotNullChildByType(FUNC);
  }

  @Override
  @NotNull
  public PsiElement getIdentifier() {
    return findNotNullChildByType(IDENTIFIER);
  }

}
