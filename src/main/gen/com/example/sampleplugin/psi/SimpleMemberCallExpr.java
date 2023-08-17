// This is a generated file. Not intended for manual editing.
package com.example.sampleplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;

public interface SimpleMemberCallExpr extends SimpleExpression {

  @NotNull
  SimpleArguments getArguments();

  @NotNull
  SimpleMemberAccessExpr getMemberAccessExpr();

  @Nullable
  PsiReference getReference();

}
