package org.telegram.tgnet;

public class TLRPC$TL_chatPhoto_layer97 extends TLRPC$TL_chatPhoto {
    public static int constructor = 1632839530;

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_chatPhoto
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.photo_small = TLRPC$FileLocation.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        this.photo_big = TLRPC$FileLocation.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
    }

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_chatPhoto
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.photo_small.serializeToStream(abstractSerializedData);
        this.photo_big.serializeToStream(abstractSerializedData);
    }
}
