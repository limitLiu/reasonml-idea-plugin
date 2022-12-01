package com.reason.ide.search.index;

import com.intellij.openapi.project.*;
import com.intellij.psi.search.*;
import com.intellij.psi.stubs.*;
import com.reason.lang.core.psi.impl.*;
import com.reason.lang.core.stub.type.*;
import org.jetbrains.annotations.*;

import java.util.*;

public class ObjectFieldIndex extends StringStubIndexExtension<RPsiObjectField> {
    @Override
    public int getVersion() {
        return super.getVersion() + ORStubVersions.OBJECT_FIELD;
    }

    @Override
    public @NotNull StubIndexKey<String, RPsiObjectField> getKey() {
        return IndexKeys.OBJECT_FIELDS;
    }

    public static @NotNull Collection<RPsiObjectField> getElements(@NotNull String key, @NotNull Project project, @Nullable GlobalSearchScope scope) {
        return StubIndex.getElements(IndexKeys.OBJECT_FIELDS, key, project, scope, RPsiObjectField.class);
    }
}
