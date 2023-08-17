// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SimpleExpression extends PsiElement {

  @Nullable
  SimpleAssignExpr getAssignExpr();

  @Nullable
  SimpleCallExpr getCallExpr();

  @Nullable
  SimpleMemberAccessExpr getMemberAccessExpr();

  @Nullable
  SimpleMemberCallExpr getMemberCallExpr();

  @Nullable
  SimpleValueExpr getValueExpr();

}
