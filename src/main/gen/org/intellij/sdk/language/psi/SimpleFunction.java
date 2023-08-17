// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SimpleFunction extends com.example.sampleplugin.psi.SimpleFunction {

  @Nullable
  SimpleBlock getBlock();

  @Nullable
  SimpleFunctionReceiver getFunctionReceiver();

  @Nullable
  SimpleGeneric getGeneric();

  @Nullable
  SimpleParameters getParameters();

  @Nullable
  SimpleTypeName getTypeName();

  @NotNull
  PsiElement getFunc();

  @NotNull
  PsiElement getIdentifier();

  //WARNING: getName(...) is skipped
  //matching getName(SimpleFunction, ...)
  //methods are not found in SimplePsiImplUtil

  //WARNING: getNameIdentifier(...) is skipped
  //matching getNameIdentifier(SimpleFunction, ...)
  //methods are not found in SimplePsiImplUtil

  //WARNING: getReference(...) is skipped
  //matching getReference(SimpleFunction, ...)
  //methods are not found in SimplePsiImplUtil

}
