package org.telegram.tgnet;

public class TLRPC$TL_auth_codeTypeSms extends TLRPC$auth_CodeType {
    public static int constructor = 1923290508;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
