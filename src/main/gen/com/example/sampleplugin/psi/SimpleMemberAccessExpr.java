// This is a generated file. Not intended for manual editing.
package com.example.sampleplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;

public interface SimpleMemberAccessExpr extends PsiElement {

  @NotNull
  SimpleExpression getExpression();

  @NotNull
  PsiElement getDot();

  @Nullable
  PsiElement getId();

  @Nullable
  PsiReference getReference();

  //WARNING: isCallExpression(...) is skipped
  //matching isCallExpression(SimpleMemberAccessExpr, ...)
  //methods are not found in SimplePsiImplUtil

  //WARNING: getLHS(...) is skipped
  //matching getLHS(SimpleMemberAccessExpr, ...)
  //methods are not found in SimplePsiImplUtil

  //WARNING: getRHS(...) is skipped
  //matching getRHS(SimpleMemberAccessExpr, ...)
  //methods are not found in SimplePsiImplUtil

}
