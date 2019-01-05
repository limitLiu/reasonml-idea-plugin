package com.reason.lang.core.psi;

import com.reason.lang.core.ORSignature;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface PsiSignatureElement {

    @Nullable
    PsiSignature getSignature();

    @NotNull
    ORSignature getHMSignature();

}
