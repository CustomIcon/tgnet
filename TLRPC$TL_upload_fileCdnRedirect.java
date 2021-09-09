package org.telegram.tgnet;

public class TLRPC$TL_upload_fileCdnRedirect extends TLRPC$upload_File {
    public static int constructor = -242427324;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.dc_id = abstractSerializedData.readInt32(z);
        this.file_token = abstractSerializedData.readByteArray(z);
        this.encryption_key = abstractSerializedData.readByteArray(z);
        this.encryption_iv = abstractSerializedData.readByteArray(z);
        int readInt32 = abstractSerializedData.readInt32(z);
        if (readInt32 == 481674261) {
            int readInt322 = abstractSerializedData.readInt32(z);
            for (int i = 0; i < readInt322; i++) {
                TLRPC$TL_fileHash TLdeserialize = TLRPC$TL_fileHash.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                if (TLdeserialize != null) {
                    this.file_hashes.add(TLdeserialize);
                } else {
                    return;
                }
            }
        } else if (z) {
            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(readInt32)));
        }
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.dc_id);
        abstractSerializedData.writeByteArray(this.file_token);
        abstractSerializedData.writeByteArray(this.encryption_key);
        abstractSerializedData.writeByteArray(this.encryption_iv);
        abstractSerializedData.writeInt32(481674261);
        int size = this.file_hashes.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.file_hashes.get(i).serializeToStream(abstractSerializedData);
        }
    }
}
