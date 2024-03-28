package com.reason.ide;

import com.intellij.openapi.project.*;
import com.intellij.openapi.startup.*;
import com.reason.comp.ocaml.*;
import com.reason.ide.console.*;
import com.reason.ide.settings.*;
import jpsplugin.com.reason.*;
import kotlin.*;
import kotlin.coroutines.*;
import org.jetbrains.annotations.*;

import static com.intellij.openapi.application.ApplicationManager.*;

/**
 * Ensure all services have started after the startup.
 */
public class ORPostStartupActivity implements ProjectActivity, DumbAware {
    private static final Log LOG = Log.create("activity.startup");

    @Override
    public @Nullable Object execute(@NotNull Project project, @NotNull Continuation<? super Unit> continuation) {
        ORFileDocumentListener.ensureSubscribed(project);
        LOG.debug("Subscribed project and document listeners.");

        DumbService.getInstance(project).smartInvokeLater(() -> {
            ORSettings settings = project.getService(ORSettings.class);

            OpamEnv opamEnv = getApplication().getService(OpamEnv.class);
            opamEnv.computeEnv(settings.getOpamLocation(), settings.getSwitchName(), settings.getCygwinBash(),
                    data -> LOG.debug("Computed opam env for " + settings.getSwitchName()));

            project.getService(ORToolWindowManager.class).shouldShowToolWindows();
        });

        return null;
    }
}
