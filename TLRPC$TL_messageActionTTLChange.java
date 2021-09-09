package org.telegram.tgnet;

public class TLRPC$TL_messageActionTTLChange extends TLRPC$MessageAction {
    public static int constructor = 1431655762;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.ttl = abstractSerializedData.readInt32(z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.ttl);
    }
}
