package org.telegram.tgnet;

public class TLRPC$TL_messageMediaPhoto_layer68 extends TLRPC$TL_messageMediaPhoto {
    public static int constructor = 1032643901;

    @Override // org.telegram.tgnet.TLRPC$TL_messageMediaPhoto, org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.photo = TLRPC$Photo.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        this.captionLegacy = abstractSerializedData.readString(z);
    }

    @Override // org.telegram.tgnet.TLRPC$TL_messageMediaPhoto, org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.photo.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeString(this.captionLegacy);
    }
}
