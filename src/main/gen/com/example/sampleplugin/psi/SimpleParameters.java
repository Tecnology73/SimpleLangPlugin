// This is a generated file. Not intended for manual editing.
package com.example.sampleplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SimpleParameters extends PsiElement {

  @NotNull
  List<SimpleParameter> getParameterList();

  @NotNull
  PsiElement getLparen();

  @NotNull
  PsiElement getRparen();

}