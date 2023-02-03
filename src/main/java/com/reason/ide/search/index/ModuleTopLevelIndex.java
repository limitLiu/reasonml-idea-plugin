package com.reason.ide.search.index;

import com.intellij.openapi.project.*;
import com.intellij.psi.search.*;
import com.intellij.psi.stubs.*;
import com.reason.lang.core.psi.impl.*;
import com.reason.lang.core.stub.type.*;
import org.jetbrains.annotations.*;

import java.util.*;

public class ModuleTopLevelIndex extends StringStubIndexExtension<RPsiFakeModule> {
    @Override
    public int getVersion() {
        return super.getVersion() + ORStubVersions.MODULE;
    }

    @Override
    public @NotNull StubIndexKey<String, RPsiFakeModule> getKey() {
        return IndexKeys.MODULES_TOP_LEVEL;
    }

    public static void processModules(@NotNull Project project, @Nullable GlobalSearchScope scope, @NotNull IndexKeys.ProcessElement<RPsiFakeModule> processor) {
        StubIndex.getInstance().processAllKeys(IndexKeys.MODULES_TOP_LEVEL, project,
                name -> {
                    Collection<RPsiFakeModule> collection = getModules(name, project, scope);
                    for (RPsiFakeModule module : collection) {
                        processor.process(module);
                    }
                    return true;
                });
    }

    public static @NotNull Collection<RPsiFakeModule> getModules(@NotNull String key, @NotNull Project project, @Nullable GlobalSearchScope scope) {
        return StubIndex.getElements(IndexKeys.MODULES_TOP_LEVEL, key, project, scope, RPsiFakeModule.class);
    }
}