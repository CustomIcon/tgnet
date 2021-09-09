package org.telegram.tgnet;

public class TLRPC$TL_decryptedMessageMediaEmpty extends TLRPC$DecryptedMessageMedia {
    public static int constructor = 144661578;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
