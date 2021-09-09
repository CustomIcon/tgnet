package org.telegram.tgnet;

public class TLRPC$TL_storage_fileMov extends TLRPC$storage_FileType {
    public static int constructor = 1258941372;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
