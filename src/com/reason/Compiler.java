package com.reason;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.reason.ide.console.CliType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.Set;

public interface Compiler {

    @FunctionalInterface
    interface ProcessTerminated {
        void run();
    }

    Optional<VirtualFile> findFirstContentRoot(@NotNull Project project);

    Set<VirtualFile> findContentRoots(@NotNull Project project);

    void refresh(@NotNull VirtualFile configFile);

    void run(@NotNull VirtualFile file, @NotNull CliType cliType, @Nullable ProcessTerminated onProcessTerminated);

    CompilerType getType();

    boolean isConfigured(@NotNull Project project);

}
