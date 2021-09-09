package org.telegram.tgnet;

public class TLRPC$TL_encryptedFileEmpty extends TLRPC$EncryptedFile {
    public static int constructor = -1038136962;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
