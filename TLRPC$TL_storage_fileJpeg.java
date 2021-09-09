package org.telegram.tgnet;

public class TLRPC$TL_storage_fileJpeg extends TLRPC$storage_FileType {
    public static int constructor = 8322574;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
