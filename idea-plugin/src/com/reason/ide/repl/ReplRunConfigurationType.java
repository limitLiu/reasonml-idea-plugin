package com.reason.ide.repl;

import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.icons.AllIcons;
import javax.swing.*;

import icons.ORIcons;
import org.jetbrains.annotations.NotNull;

public class ReplRunConfigurationType implements ConfigurationType {
  @NotNull
  @Override
  public String getDisplayName() {
    return "OCaml REPL";
  }

  @NotNull
  @Override
  public String getConfigurationTypeDescription() {
    return "OCaml REPL configuration Type";
  }

  @Override
  public @NotNull Icon getIcon() {
    return ORIcons.OCAML;
  }

  @NotNull
  @Override
  public String getId() {
    return "OCAML_RUN_CONFIGURATION";
  }

  @NotNull
  @Override
  public ConfigurationFactory @NotNull [] getConfigurationFactories() {
    return new ConfigurationFactory[] {new ReplConfigurationFactory(this)};
  }
}
