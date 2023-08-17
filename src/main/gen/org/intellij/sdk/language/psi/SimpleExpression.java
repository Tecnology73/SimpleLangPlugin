// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SimpleExpression extends PsiElement {

  @Nullable
  SimpleBaseExpression getBaseExpression();

  @Nullable
  SimpleConstructorCall getConstructorCall();

  @Nullable
  SimpleFunctionCall getFunctionCall();

  @Nullable
  SimpleMemberAccessExpr getMemberAccessExpr();

}
