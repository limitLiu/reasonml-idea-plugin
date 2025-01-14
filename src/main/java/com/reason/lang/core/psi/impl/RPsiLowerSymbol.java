package com.reason.lang.core.psi.impl;

import com.intellij.psi.impl.source.tree.*;
import com.intellij.psi.tree.*;
import com.reason.ide.search.reference.*;
import com.reason.lang.core.psi.*;
import com.reason.lang.core.type.*;
import org.jetbrains.annotations.*;

public class RPsiLowerSymbol extends LeafPsiElement implements RPsiAtom {
    protected final ORLangTypes myTypes;

    // region Constructors
    public RPsiLowerSymbol(@NotNull ORLangTypes types, @NotNull IElementType tokenType, @NotNull CharSequence text) {
        super(tokenType, text);
        myTypes = types;
    }
    // endregion

    @Override
    public @NotNull PsiLowerSymbolReference getReference() {
        return new PsiLowerSymbolReference(this, myTypes);
    }

    @Override
    public String toString() {
        return "RPsiLowerSymbol:" + getElementType();
    }
}
