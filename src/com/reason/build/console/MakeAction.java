package com.reason.build.console;

import com.intellij.execution.ui.ConsoleView;
import com.intellij.execution.ui.ConsoleViewContentType;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.DumbAwareAction;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiFile;
import com.reason.Platform;
import com.reason.build.CompilerManager;

public class MakeAction extends DumbAwareAction {

    private final ConsoleView m_console;
    private final Project m_project;

    MakeAction(ConsoleView console, Project project) {
        super("Make", "Make", AllIcons.Actions.Compile);
        m_project = project;
        m_console = console;
    }

    @Override
    public void actionPerformed(AnActionEvent e) {
        CompilerManager compilerManager = CompilerManager.getInstance();

        // Try to detect the current active editor
        Editor editor = FileEditorManager.getInstance(m_project).getSelectedTextEditor();
        if (editor == null) {
            VirtualFile baseDir = Platform.findBaseRoot(m_project);
            m_console.print("No active text editor found, using root directory " + baseDir.getPath() + "\n", ConsoleViewContentType.NORMAL_OUTPUT);
            compilerManager.getCompiler(m_project).run(baseDir, CliType.make);
        } else {
            Document document = editor.getDocument();
            PsiFile psiFile = PsiDocumentManager.getInstance(m_project).getPsiFile(document);
            if (psiFile != null) {
                compilerManager.getCompiler(m_project).run(psiFile.getVirtualFile(), CliType.make);
            }
        }
    }
}
