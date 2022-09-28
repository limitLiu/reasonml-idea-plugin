package com.reason.lang.core.psi.impl;

import com.intellij.lang.*;
import com.intellij.navigation.*;
import com.intellij.psi.*;
import com.intellij.psi.stubs.*;
import com.intellij.util.*;
import com.reason.lang.core.*;
import com.reason.lang.core.psi.*;
import com.reason.lang.core.stub.*;
import com.reason.lang.core.type.*;
import icons.*;
import org.jetbrains.annotations.*;

import javax.swing.*;

public class RPsiClassMethodImpl extends RPsiTokenStub<ORTypes, RPsiClassMethod, RsiClassMethodStub> implements RPsiClassMethod {
    // region Constructors
    public RPsiClassMethodImpl(@NotNull ORTypes types, @NotNull ASTNode node) {
        super(types, node);
    }

    public RPsiClassMethodImpl(@NotNull ORTypes types, @NotNull RsiClassMethodStub stub, @NotNull IStubElementType nodeType) {
        super(types, stub, nodeType);
    }
    // endregion

    @Override
    public @Nullable PsiElement getNameIdentifier() {
        return ORUtil.findImmediateFirstChildOfClass(this, RPsiLowerSymbol.class);
    }

    //region PsiQualifiedName
    @Override
    public @NotNull String getQualifiedName() {
        RsiClassMethodStub stub = getGreenStub();
        if (stub != null) {
            return stub.getQualifiedName();
        }

        return ORUtil.getQualifiedName(this);
    }

    @Override
    public String @NotNull [] getPath() {
        RsiClassMethodStub stub = getGreenStub();
        if (stub != null) {
            return stub.getPath();
        }

        return ORUtil.getQualifiedPath(this);
    }
    //endregion

    @Override
    public String getName() {
        PsiElement nameIdentifier = getNameIdentifier();
        return nameIdentifier == null ? "" : nameIdentifier.getText();
    }

    @Override
    public @Nullable PsiElement setName(@NotNull String name) throws IncorrectOperationException {
        return null;
    }

    public @Nullable RPsiSignature getSignature() {
        return ORUtil.findImmediateFirstChildOfClass(this, RPsiSignature.class);
    }

    public ItemPresentation getPresentation() {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                return getName();
            }

            @Nullable
            @Override
            public String getLocationString() {
                RPsiSignature signature = getSignature();
                return signature == null ? null : signature.getText();
            }

            @NotNull
            @Override
            public Icon getIcon(boolean unused) {
                return ORIcons.METHOD;
            }
        };
    }
}