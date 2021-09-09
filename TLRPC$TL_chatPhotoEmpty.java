package org.telegram.tgnet;

public class TLRPC$TL_chatPhotoEmpty extends TLRPC$ChatPhoto {
    public static int constructor = 935395612;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
