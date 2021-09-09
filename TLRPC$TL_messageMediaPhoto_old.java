package org.telegram.tgnet;

public class TLRPC$TL_messageMediaPhoto_old extends TLRPC$TL_messageMediaPhoto {
    public static int constructor = -926655958;

    @Override // org.telegram.tgnet.TLRPC$TL_messageMediaPhoto, org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.photo = TLRPC$Photo.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
    }

    @Override // org.telegram.tgnet.TLRPC$TL_messageMediaPhoto, org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.photo.serializeToStream(abstractSerializedData);
    }
}
