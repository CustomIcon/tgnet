package org.telegram.tgnet;

public class TLRPC$TL_messages_featuredStickersNotModified extends TLRPC$messages_FeaturedStickers {
    public static int constructor = -958657434;
    public int count;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.count = abstractSerializedData.readInt32(z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.count);
    }
}
