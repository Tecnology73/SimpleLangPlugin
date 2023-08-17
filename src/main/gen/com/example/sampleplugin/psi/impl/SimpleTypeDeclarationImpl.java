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

public class SimpleTypeDeclarationImpl extends SimpleNamedElementImpl implements SimpleTypeDeclaration {

  public SimpleTypeDeclarationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SimpleVisitor visitor) {
    visitor.visitTypeDeclaration(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SimpleVisitor) accept((SimpleVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SimpleType getType() {
    return findChildByClass(SimpleType.class);
  }

  @Override
  @Nullable
  public SimpleTypeBlock getTypeBlock() {
    return findChildByClass(SimpleTypeBlock.class);
  }

  @Override
  @NotNull
  public PsiElement getTypeKw() {
    return findNotNullChildByType(TYPE_KW);
  }

  @Override
  @Nullable
  public String getName() {
    return SimplePsiImplUtil.getName(this);
  }

  @Override
  @Nullable
  public PsiElement getNameIdentifier() {
    return SimplePsiImplUtil.getNameIdentifier(this);
  }

  @Override
  @Nullable
  public PsiReference getReference() {
    return SimplePsiImplUtil.getReference(this);
  }

}
