// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SimpleTopLevelDeclaration extends PsiElement {

  @Nullable
  SimpleFunction getFunction();

  @Nullable
  SimpleTypeDeclaration getTypeDeclaration();

  @Nullable
  PsiElement getSemicolon();

  @Nullable
  PsiElement getSemicolonSynthetic();

}
