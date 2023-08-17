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
import com.intellij.navigation.ItemPresentation;
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
  @NotNull
  public SimpleBlock getBlock() {
    return findNotNullChildByClass(SimpleBlock.class);
  }

  @Override
  @NotNull
  public SimpleTypeName getTypeName() {
    return findNotNullChildByClass(SimpleTypeName.class);
  }

  @Override
  @NotNull
  public PsiElement getType_() {
    return findNotNullChildByType(TYPE_);
  }

  @Override
  public String getKey() {
    return SimplePsiImplUtil.getKey(this);
  }

  @Override
  public String getName() {
    return SimplePsiImplUtil.getName(this);
  }

  @Override
  public PsiElement setName(String newName) {
    return SimplePsiImplUtil.setName(this, newName);
  }

  @Override
  public PsiElement getNameIdentifier() {
    return SimplePsiImplUtil.getNameIdentifier(this);
  }

  @Override
  public ItemPresentation getPresentation() {
    return SimplePsiImplUtil.getPresentation(this);
  }

  @Override
  public PsiReference getReference() {
    return SimplePsiImplUtil.getReference(this);
  }

}
