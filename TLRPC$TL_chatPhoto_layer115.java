package org.telegram.tgnet;

public class TLRPC$TL_chatPhoto_layer115 extends TLRPC$TL_chatPhoto {
    public static int constructor = 1197267925;

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_chatPhoto
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.photo_small = TLRPC$FileLocation.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        this.photo_big = TLRPC$FileLocation.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        this.dc_id = abstractSerializedData.readInt32(z);
    }

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_chatPhoto
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.photo_small.serializeToStream(abstractSerializedData);
        this.photo_big.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt32(this.dc_id);
    }
}
