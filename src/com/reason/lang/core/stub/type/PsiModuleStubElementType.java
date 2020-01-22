package com.reason.lang.core.stub.type;

import java.io.*;
import org.jetbrains.annotations.NotNull;
import com.intellij.lang.Language;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.stubs.IndexSink;
import com.intellij.psi.stubs.StubElement;
import com.intellij.psi.stubs.StubInputStream;
import com.intellij.psi.stubs.StubOutputStream;
import com.intellij.util.io.StringRef;
import com.reason.ide.search.index.IndexKeys;
import com.reason.lang.core.psi.PsiInnerModule;
import com.reason.lang.core.psi.impl.PsiInnerModuleImpl;
import com.reason.lang.core.stub.PsiModuleStub;
import com.reason.lang.core.type.ORTypesUtil;

public class PsiModuleStubElementType extends IStubElementType<PsiModuleStub, PsiInnerModule> {

    public PsiModuleStubElementType(@NotNull String name, Language language) {
        super(name, language);
    }

    @NotNull
    public PsiInnerModuleImpl createPsi(@NotNull final PsiModuleStub stub) {
        return new PsiInnerModuleImpl(ORTypesUtil.getInstance(getLanguage()), stub, this);
    }

    @NotNull
    public PsiModuleStub createStub(@NotNull final PsiInnerModule psi, final StubElement parentStub) {
        return new PsiModuleStub(parentStub, this, psi.getName(), psi.getQualifiedName(), psi.getAlias(), psi.isComponent(), psi.isInterface());
    }

    public void serialize(@NotNull final PsiModuleStub stub, @NotNull final StubOutputStream dataStream) throws IOException {
        dataStream.writeName(stub.getName());
        dataStream.writeUTFFast(stub.getQualifiedName());
        dataStream.writeBoolean(stub.isComponent());
        dataStream.writeBoolean(stub.isInterface());

        String alias = stub.getAlias();
        dataStream.writeBoolean(alias != null);
        if (alias != null) {
            dataStream.writeUTFFast(stub.getAlias());
        }
    }

    @NotNull
    public PsiModuleStub deserialize(@NotNull final StubInputStream dataStream, final StubElement parentStub) throws IOException {
        StringRef moduleName = dataStream.readName();
        String qname = dataStream.readUTFFast();
        boolean isComponent = dataStream.readBoolean();
        boolean isInterface = dataStream.readBoolean();

        String alias = null;
        boolean isAlias = dataStream.readBoolean();
        if (isAlias) {
            alias = dataStream.readUTFFast();
        }

        return new PsiModuleStub(parentStub, this, moduleName, qname, alias, isComponent, isInterface);
    }

    public void indexStub(@NotNull final PsiModuleStub stub, @NotNull final IndexSink sink) {
        String name = stub.getName();
        if (name != null) {
            sink.occurrence(IndexKeys.MODULES, name);
        }

        String fqn = stub.getQualifiedName();
        if (fqn != null && stub.isInterface()) {
            sink.occurrence(IndexKeys.MODULES_FQN, fqn.hashCode());
            if (stub.isComponent()) {
                sink.occurrence(IndexKeys.MODULES_COMP, fqn);
            }
        }
    }

    @NotNull
    public String getExternalId() {
        return getLanguage() + "." + super.toString();
    }
}
