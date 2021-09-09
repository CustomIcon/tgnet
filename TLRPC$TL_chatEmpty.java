package org.telegram.tgnet;

public class TLRPC$TL_chatEmpty extends TLRPC$Chat {
    public static int constructor = -1683826688;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.id = abstractSerializedData.readInt32(z);
        this.title = "DELETED";
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.id);
    }
}
