// This is a generated file. Not intended for manual editing.
package com.example.sampleplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SimpleValueExpr extends SimpleExpression {

  @Nullable
  SimpleConstructorCall getConstructorCall();

  @Nullable
  PsiElement getId();

  @Nullable
  PsiElement getValueBool();

  @Nullable
  PsiElement getValueFloat();

  @Nullable
  PsiElement getValueInteger();

  @Nullable
  PsiElement getValueNull();

}
