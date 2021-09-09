package org.telegram.tgnet;

public class TLRPC$TL_recentMeUrlStickerSet extends TLRPC$RecentMeUrl {
    public static int constructor = -1140172836;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.url = abstractSerializedData.readString(z);
        this.set = TLRPC$StickerSetCovered.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeString(this.url);
        this.set.serializeToStream(abstractSerializedData);
    }
}
