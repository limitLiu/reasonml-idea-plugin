package com.reason.comp.ocaml;

import com.intellij.openapi.application.*;
import com.intellij.openapi.components.*;
import jpsplugin.com.reason.*;
import org.jetbrains.annotations.*;

import java.util.*;

@Service(Service.Level.APP)
public final class OpamEnv {
    private final Map<String, Map<String, String>> myEnvs = new HashMap<>();

    public @Nullable Map<String, String> getEnv(@Nullable String switchName) {
        return switchName == null ? null : myEnvs.get(switchName);
    }

    public void computeEnv(@Nullable String opamLocation, @Nullable String switchName, @Nullable String cygwinBash,
                           @Nullable ORProcessTerminated<Map<String, String>> onEnvTerminated) {
        if (opamLocation != null && switchName != null) {
            ApplicationManager.getApplication()
                    .getService(OpamProcess.class)
                    .env(opamLocation, switchName, cygwinBash, data -> {
                        myEnvs.put(switchName, data);
                        if (onEnvTerminated != null) {
                            onEnvTerminated.run(data);
                        }
                    });
        }
    }
}
