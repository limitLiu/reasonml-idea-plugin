// This is a generated file. Not intended for manual editing.
package com.reason.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ReasonMLTypeExpr extends PsiElement {

  @NotNull
  List<ReasonMLFieldTypeDecl> getFieldTypeDeclList();

  @NotNull
  List<ReasonMLLabelName> getLabelNameList();

  @NotNull
  List<ReasonMLTypeConstr> getTypeConstrList();

  @NotNull
  List<ReasonMLTypeExpr> getTypeExprList();

  @NotNull
  List<ReasonMLValuePath> getValuePathList();

}
