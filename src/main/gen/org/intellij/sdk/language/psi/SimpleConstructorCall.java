// This is a generated file. Not intended for manual editing.
package org.intellij.sdk.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiReference;

public interface SimpleConstructorCall extends SimpleNamedElement {

  @NotNull
  SimpleArguments getArguments();

  @NotNull
  SimpleTypeName getTypeName();

  @NotNull
  PsiElement getNew();

  String getKey();

  String getName();

  PsiElement setName(String newName);

  PsiElement getNameIdentifier();

  ItemPresentation getPresentation();

  PsiReference getReference();

}
