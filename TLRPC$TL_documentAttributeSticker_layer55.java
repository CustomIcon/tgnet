package org.telegram.tgnet;

public class TLRPC$TL_documentAttributeSticker_layer55 extends TLRPC$TL_documentAttributeSticker {
    public static int constructor = 978674434;

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_documentAttributeSticker
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.alt = abstractSerializedData.readString(z);
        this.stickerset = TLRPC$InputStickerSet.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
    }

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_documentAttributeSticker
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeString(this.alt);
        this.stickerset.serializeToStream(abstractSerializedData);
    }
}
