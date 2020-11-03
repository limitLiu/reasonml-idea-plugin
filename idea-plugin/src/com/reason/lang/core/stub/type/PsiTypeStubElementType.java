package com.reason.lang.core.stub.type;

import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.psi.stubs.*;
import com.intellij.util.io.StringRef;
import com.reason.ide.search.index.IndexKeys;
import com.reason.lang.core.psi.PsiType;
import com.reason.lang.core.psi.impl.PsiTypeImpl;
import com.reason.lang.core.stub.PsiTypeStub;
import com.reason.lang.core.type.ORTypesUtil;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;

public class PsiTypeStubElementType extends ORStubElementType<PsiTypeStub, PsiType> {

  public PsiTypeStubElementType(@NotNull Language language) {
    super("C_TYPE_DECLARATION", language);
  }

  @NotNull
  public PsiTypeImpl createPsi(@NotNull final PsiTypeStub stub) {
    return new PsiTypeImpl(ORTypesUtil.getInstance(getLanguage()), stub, this);
  }

  @NotNull
  public PsiTypeImpl createPsi(@NotNull ASTNode node) {
    return new PsiTypeImpl(ORTypesUtil.getInstance(getLanguage()), node);
  }

  @NotNull
  public PsiTypeStub createStub(@NotNull final PsiType psi, final StubElement parentStub) {
    return new PsiTypeStub(parentStub, this, psi.getName(), psi.getPath());
  }

  public void serialize(@NotNull final PsiTypeStub stub, @NotNull final StubOutputStream dataStream)
      throws IOException {
    dataStream.writeName(stub.getName());
    dataStream.writeUTFFast(stub.getPath());
  }

  @NotNull
  public PsiTypeStub deserialize(
      @NotNull final StubInputStream dataStream, final StubElement parentStub) throws IOException {
    StringRef name = dataStream.readName();
    String path = dataStream.readUTFFast();
    return new PsiTypeStub(parentStub, this, name, path);
  }

  public void indexStub(@NotNull final PsiTypeStub stub, @NotNull final IndexSink sink) {
    String name = stub.getName();
    if (name != null) {
      sink.occurrence(IndexKeys.TYPES, name);
    }
  }

  @NotNull
  public String getExternalId() {
    return getLanguage().getID() + "." + super.toString();
  }
}
