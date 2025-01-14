package com.reason.ide.files;

import com.intellij.extapi.psi.*;
import com.intellij.lang.*;
import com.intellij.pom.*;
import com.intellij.psi.*;
import com.intellij.psi.util.*;
import com.reason.lang.*;
import com.reason.lang.core.*;
import com.reason.lang.core.psi.*;
import org.jetbrains.annotations.*;

import java.util.*;

public abstract class FileBase extends PsiFileBase implements RPsiModule, Navigatable {
    private final @NotNull String m_moduleName;

    FileBase(@NotNull FileViewProvider viewProvider, @NotNull Language language) {
        super(viewProvider, language);
        m_moduleName = ORUtil.fileNameToModuleName(getName());
    }

    public @NotNull String getModuleName() {
        return m_moduleName;
    }

    //region PsiQualifiedName
    @Override
    public String @Nullable [] getPath() {
        return null;
    }

    @Override
    public @NotNull String getQualifiedName() {
        return getModuleName();
    }
    //endregion


    @Override
    public @Nullable PsiElement getBody() {
        return this;
    }

    public boolean isComponent() {
        if (FileHelper.isOCaml(getFileType())) {
            return false;
        }

        return ModuleHelper.isComponent(this);
    }

    //region Navigatable
    @Override
    public PsiElement getNavigationElement() {
        if (isComponent()) {
            for (RPsiLet let : PsiTreeUtil.getStubChildrenOfTypeAsList(this, RPsiLet.class)) {
                if ("make".equals(let.getName())) {
                    return let;
                }
            }
            for (RPsiExternal external : PsiTreeUtil.getStubChildrenOfTypeAsList(this, RPsiExternal.class)) {
                if ("make".equals(external.getName())) {
                    return external;
                }
            }
        }

        return this;
    }
    //endregion

    @SafeVarargs
    public @NotNull final <T extends PsiQualifiedNamedElement> List<T> getQualifiedExpressions(@Nullable String name, @NotNull Class<? extends T>... clazz) {
        List<T> result = new ArrayList<>();

        if (name != null) {
            Collection<T> children = PsiTreeUtil.findChildrenOfAnyType(this, clazz);
            for (T child : children) {
                if (name.equals(child.getQualifiedName())) {
                    result.add(child);
                }
            }
        }

        return result;
    }

    public boolean isInterface() {
        return FileHelper.isInterface(getFileType());
    }

    @Override
    public boolean equals(@Nullable Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FileBase fileBase = (FileBase) o;
        return m_moduleName.equals(fileBase.m_moduleName) && isInterface() == fileBase.isInterface();
    }

    @Override
    public int hashCode() {
        return Objects.hash(m_moduleName, isInterface());
    }
}
