// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SimpleStatement extends PsiElement {

  @Nullable
  SimpleConstructorCall getConstructorCall();

  @Nullable
  SimpleFunctionCall getFunctionCall();

  @Nullable
  SimpleMemberAccessExpr getMemberAccessExpr();

  @Nullable
  SimpleReturnStatement getReturnStatement();

  @Nullable
  SimpleVariableDeclaration getVariableDeclaration();

  @Nullable
  PsiElement getSemicolon();

  @Nullable
  PsiElement getSemicolonSynthetic();

}
