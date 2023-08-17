// This is a generated file. Not intended for manual editing.
package com.example.sampleplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SimpleStatement extends PsiElement {

  @Nullable
  SimpleExpression getExpression();

  @Nullable
  SimpleReturnStatement getReturnStatement();

  @Nullable
  SimpleVariableDeclaration getVariableDeclaration();

  @Nullable
  PsiElement getSemicolon();

}
