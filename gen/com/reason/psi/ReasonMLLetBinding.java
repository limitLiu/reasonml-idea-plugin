// This is a generated file. Not intended for manual editing.
package com.reason.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ReasonMLLetBinding extends PsiElement {

  @NotNull
  List<ReasonMLExpr> getExprList();

  @NotNull
  ReasonMLLetName getLetName();

  @NotNull
  List<ReasonMLParameter> getParameterList();

  @Nullable
  ReasonMLTypeExpr getTypeExpr();

  @Nullable
  ReasonMLValueName getValueName();

  boolean isFunction();

}
