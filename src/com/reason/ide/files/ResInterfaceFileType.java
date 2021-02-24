package com.reason.ide.files;

import com.intellij.openapi.fileTypes.LanguageFileType;
import com.reason.lang.napkin.ResLanguage;
import icons.ORIcons;

import javax.swing.*;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ResInterfaceFileType extends LanguageFileType {
    public static final ResInterfaceFileType INSTANCE = new ResInterfaceFileType();

    private ResInterfaceFileType() {
        super(ResLanguage.INSTANCE);
    }

    @Override
    public @NotNull String getName() {
        return "RESCRIPT_INTF";
    }

    @Override
    public @NotNull String getDescription() {
        return "Rescript language interface file";
    }

    @Override
    public @NotNull String getDefaultExtension() {
        return "resi";
    }

    @Override
    public @NotNull Icon getIcon() {
        return ORIcons.NS_INTERFACE_FILE;
    }

    @Override
    public @NotNull String toString() {
        return getName();
    }
}
