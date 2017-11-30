package com.reason.lang.core.stub.type;

import com.intellij.lang.LighterAST;
import com.intellij.lang.LighterASTNode;
import com.intellij.lang.LighterASTTokenNode;
import com.intellij.psi.impl.source.tree.LightTreeUtil;
import com.intellij.psi.stubs.*;
import com.intellij.util.CharTable;
import com.intellij.util.io.StringRef;
import com.reason.lang.RmlLanguage;
import com.reason.lang.RmlTypes;
import com.reason.lang.core.psi.PsiLet;
import com.reason.lang.core.stub.LetStub;
import com.reason.lang.core.stub.LetStubImpl;
import com.reason.lang.core.stub.index.RmlStubIndexKeys;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class LetStubElementType extends ILightStubElementType<LetStub, PsiLet> {
    public static final IStubElementType INSTANCE = new LetStubElementType();

    private LetStubElementType() {
        super("LET_EXPRESSION", RmlLanguage.INSTANCE);
    }


    public PsiLet createPsi(@NotNull final LetStub stub) {
        return new PsiLet(stub, this);
    }

    @NotNull
    public LetStub createStub(@NotNull final PsiLet psi, final StubElement parentStub) {
        return new LetStubImpl(parentStub, psi.getName());
    }

    @NotNull
    public String getExternalId() {
        return "ReasonML.index.let";
    }

    public void serialize(@NotNull final LetStub stub, @NotNull final StubOutputStream dataStream) throws IOException {
        dataStream.writeName(stub.getName());
    }

    @NotNull
    public LetStub deserialize(@NotNull final StubInputStream dataStream, final StubElement parentStub) throws IOException {
        final StringRef ref = dataStream.readName();
        return new LetStubImpl(parentStub, ref.getString());
    }

    public void indexStub(@NotNull final LetStub stub, @NotNull final IndexSink sink) {
        sink.occurrence(RmlStubIndexKeys.LETS, stub.getName());
    }

    @Override
    public LetStub createStub(LighterAST tree, LighterASTNode node, StubElement parentStub) {
        LighterASTNode keyNode = LightTreeUtil.firstChildOfType(tree, node, RmlTypes.VALUE_NAME);
        String key = intern(tree.getCharTable(), keyNode);
        return new LetStubImpl(parentStub, key);
    }

    private static String intern(@NotNull CharTable table, @NotNull LighterASTNode node) {
        assert node instanceof LighterASTTokenNode : node;
        return table.intern(((LighterASTTokenNode) node).getText()).toString();
    }
}
