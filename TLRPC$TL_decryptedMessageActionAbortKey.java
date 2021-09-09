package org.telegram.tgnet;

public class TLRPC$TL_decryptedMessageActionAbortKey extends TLRPC$DecryptedMessageAction {
    public static int constructor = -586814357;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.exchange_id = abstractSerializedData.readInt64(z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt64(this.exchange_id);
    }
}
