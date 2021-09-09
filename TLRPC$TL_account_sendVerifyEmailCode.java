package org.telegram.tgnet;

public class TLRPC$TL_account_sendVerifyEmailCode extends TLObject {
    public static int constructor = 1880182943;
    public String email;

    @Override // org.telegram.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$TL_account_sentEmailCode.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeString(this.email);
    }
}
