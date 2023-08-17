// This is a generated file. Not intended for manual editing.
package com.example.sampleplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;

public interface SimpleFunctionDeclaration extends SimpleFunction {

  @Nullable
  SimpleBlock getBlock();

  @NotNull
  SimpleFunctionId getFunctionId();

  @Nullable
  SimpleFunctionReceiver getFunctionReceiver();

  @Nullable
  SimpleGeneric getGeneric();

  @NotNull
  SimpleParameters getParameters();

  @NotNull
  PsiElement getFuncKw();

  @Nullable
  PsiElement getId();

  //WARNING: getName(...) is skipped
  //matching getName(SimpleFunctionDeclaration, ...)
  //methods are not found in SimplePsiImplUtil

  //WARNING: getNameIdentifier(...) is skipped
  //matching getNameIdentifier(SimpleFunctionDeclaration, ...)
  //methods are not found in SimplePsiImplUtil

  @Nullable
  PsiReference getReference();

}
