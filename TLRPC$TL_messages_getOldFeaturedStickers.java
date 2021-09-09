package org.telegram.tgnet;

public class TLRPC$TL_messages_getOldFeaturedStickers extends TLObject {
    public static int constructor = 1608974939;
    public int hash;
    public int limit;
    public int offset;

    @Override // org.telegram.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$messages_FeaturedStickers.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.offset);
        abstractSerializedData.writeInt32(this.limit);
        abstractSerializedData.writeInt32(this.hash);
    }
}
