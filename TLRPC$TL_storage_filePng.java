package org.telegram.tgnet;

public class TLRPC$TL_storage_filePng extends TLRPC$storage_FileType {
    public static int constructor = 172975040;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
