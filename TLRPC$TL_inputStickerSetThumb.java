package org.telegram.tgnet;

public class TLRPC$TL_inputStickerSetThumb extends TLRPC$InputFileLocation {
    public static int constructor = -1652231205;
    public TLRPC$InputStickerSet stickerset;
    public int thumb_version;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.stickerset = TLRPC$InputStickerSet.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        this.thumb_version = abstractSerializedData.readInt32(z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.stickerset.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt32(this.thumb_version);
    }
}
