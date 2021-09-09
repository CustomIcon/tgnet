package org.telegram.tgnet;

public class TLRPC$TL_updateNewStickerSet extends TLRPC$Update {
    public static int constructor = 1753886890;
    public TLRPC$TL_messages_stickerSet stickerset;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.stickerset = TLRPC$TL_messages_stickerSet.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.stickerset.serializeToStream(abstractSerializedData);
    }
}
