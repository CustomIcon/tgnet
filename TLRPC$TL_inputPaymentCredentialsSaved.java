package org.telegram.tgnet;

public class TLRPC$TL_inputPaymentCredentialsSaved extends TLRPC$InputPaymentCredentials {
    public static int constructor = -1056001329;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.id = abstractSerializedData.readString(z);
        this.tmp_password = abstractSerializedData.readByteArray(z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeString(this.id);
        abstractSerializedData.writeByteArray(this.tmp_password);
    }
}
