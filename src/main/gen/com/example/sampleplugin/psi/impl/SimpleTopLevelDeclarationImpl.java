// This is a generated file. Not intended for manual editing.
package com.example.sampleplugin.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.example.sampleplugin.psi.SimpleTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.example.sampleplugin.psi.*;

public class SimpleTopLevelDeclarationImpl extends ASTWrapperPsiElement implements SimpleTopLevelDeclaration {

  public SimpleTopLevelDeclarationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SimpleVisitor visitor) {
    visitor.visitTopLevelDeclaration(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SimpleVisitor) accept((SimpleVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SimpleFunctionDeclaration getFunctionDeclaration() {
    return findChildByClass(SimpleFunctionDeclaration.class);
  }

  @Override
  @Nullable
  public SimpleTypeDeclaration getTypeDeclaration() {
    return findChildByClass(SimpleTypeDeclaration.class);
  }

}
