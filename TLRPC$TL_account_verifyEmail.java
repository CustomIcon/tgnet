package org.telegram.tgnet;

public class TLRPC$TL_account_verifyEmail extends TLObject {
    public static int constructor = -323339813;
    public String code;
    public String email;

    @Override // org.telegram.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$Bool.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeString(this.email);
        abstractSerializedData.writeString(this.code);
    }
}
