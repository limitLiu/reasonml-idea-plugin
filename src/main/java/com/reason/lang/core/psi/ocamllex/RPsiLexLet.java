package com.reason.lang.core.psi.ocamllex;

import com.intellij.extapi.psi.*;
import com.intellij.lang.*;
import com.intellij.navigation.*;
import com.intellij.openapi.util.*;
import com.intellij.psi.*;
import com.intellij.psi.tree.*;
import com.intellij.util.*;
import com.reason.ide.*;
import com.reason.lang.core.*;
import com.reason.lang.core.psi.*;
import com.reason.lang.core.type.*;
import com.reason.lang.ocamllex.*;
import org.jetbrains.annotations.*;

import javax.swing.*;

public class RPsiLexLet extends ASTWrapperPsiElement implements RPsiStructuredElement, PsiNameIdentifierOwner {
    public RPsiLexLet(@NotNull ASTNode node) {
        super(node);
    }

    // region PsiNamedElement
    public @Nullable PsiElement getNameIdentifier() {
        return ORUtil.findImmediateFirstChildOfType(this, OclLexTypes.INSTANCE.IDENT);
    }

    @Override
    public @Nullable String getName() {
        PsiElement nameIdentifier = getNameIdentifier();
        return nameIdentifier == null ? null : nameIdentifier.getText();
    }

    @Override
    public @NotNull PsiElement setName(@NotNull String name) throws IncorrectOperationException {
        return this;
    }
    // endregion

    // region RPsiStructuredElement
    @Nullable
    @Override
    public ItemPresentation getPresentation() {
        return new ItemPresentation() {
            @Override
            public @NotNull String getPresentableText() {
                String name = getName();
                return name == null ? "unknown" : name;
            }

            @Override
            public @NotNull Icon getIcon(boolean unused) {
                return ORIcons.LET;
            }
        };
    }
    // endregion
}
