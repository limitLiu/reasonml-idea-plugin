package com.reason.lang.core.psi.impl;

import com.intellij.psi.*;
import com.intellij.psi.tree.*;
import com.reason.lang.core.*;
import com.reason.lang.core.psi.*;
import com.reason.lang.core.type.*;
import org.jetbrains.annotations.*;

public class PsiTagPropertyImpl extends CompositeTypePsiElement<ORTypes> implements PsiTagProperty {
    // region Constructors
    protected PsiTagPropertyImpl(@NotNull ORTypes types, @NotNull IElementType elementType) {
        super(types, elementType);
    }
    // endregion

    @Nullable
    private PsiElement getNameElement() {
        return ORUtil.findImmediateFirstChildOfType(this, m_types.PROPERTY_NAME);
    }

    @NotNull
    @Override
    public String getName() {
        PsiElement nameElement = getNameElement();
        return nameElement == null ? "" : nameElement.getText();
    }

    @Nullable
    @Override
    public PsiElement getValue() {
        PsiElement eq = ORUtil.nextSiblingWithTokenType(getFirstChild(), m_types.EQ);
        return eq == null ? null : eq.getNextSibling();
    }
}
