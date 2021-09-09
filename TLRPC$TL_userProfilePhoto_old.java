package org.telegram.tgnet;

public class TLRPC$TL_userProfilePhoto_old extends TLRPC$TL_userProfilePhoto {
    public static int constructor = -1727196013;

    @Override // org.telegram.tgnet.TLRPC$TL_userProfilePhoto, org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.photo_small = TLRPC$FileLocation.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        this.photo_big = TLRPC$FileLocation.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
    }

    @Override // org.telegram.tgnet.TLRPC$TL_userProfilePhoto, org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.photo_small.serializeToStream(abstractSerializedData);
        this.photo_big.serializeToStream(abstractSerializedData);
    }
}
