// This is a generated file. Not intended for manual editing.
package com.reason.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.navigation.ItemPresentation;

public interface ReasonMLModuleStatement extends PsiElement {

  @Nullable
  ReasonMLModuleBody getModuleBody();

  @NotNull
  ReasonMLModuleName getModuleName();

  @Nullable
  ReasonMLModulePath getModulePath();

  ItemPresentation getPresentation();

}
