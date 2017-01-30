// This is a generated file. Not intended for manual editing.
package com.reason.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.reason.psi.ReasonMLTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.reason.psi.*;

public class ReasonMLJsxImpl extends ASTWrapperPsiElement implements ReasonMLJsx {

  public ReasonMLJsxImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ReasonMLVisitor visitor) {
    visitor.visitJsx(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ReasonMLVisitor) accept((ReasonMLVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ReasonMLETag getETag() {
    return findChildByClass(ReasonMLETag.class);
  }

  @Override
  @NotNull
  public ReasonMLSTag getSTag() {
    return findNotNullChildByClass(ReasonMLSTag.class);
  }

  @Override
  @NotNull
  public List<ReasonMLJsxContent> getJsxContentList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ReasonMLJsxContent.class);
  }

}