package org.telegram.tgnet;

public class TLRPC$TL_pageBlockCover extends TLRPC$PageBlock {
    public static int constructor = 972174080;
    public TLRPC$PageBlock cover;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.cover = TLRPC$PageBlock.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.cover.serializeToStream(abstractSerializedData);
    }
}
