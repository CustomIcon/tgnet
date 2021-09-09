package org.telegram.tgnet;

public class TLRPC$TL_decryptedMessageActionSetMessageTTL extends TLRPC$DecryptedMessageAction {
    public static int constructor = -1586283796;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.ttl_seconds = abstractSerializedData.readInt32(z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.ttl_seconds);
    }
}
