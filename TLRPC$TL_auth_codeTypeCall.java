package org.telegram.tgnet;

public class TLRPC$TL_auth_codeTypeCall extends TLRPC$auth_CodeType {
    public static int constructor = 1948046307;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
