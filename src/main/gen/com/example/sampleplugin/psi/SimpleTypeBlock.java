// This is a generated file. Not intended for manual editing.
package com.example.sampleplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SimpleTypeBlock extends PsiElement {

  @NotNull
  List<SimpleTypeField> getTypeFieldList();

  @NotNull
  PsiElement getLcurly();

  @NotNull
  PsiElement getRcurly();

}
