package org.telegram.tgnet;

public class TLRPC$TL_inputEncryptedFileUploaded extends TLRPC$InputEncryptedFile {
    public static int constructor = 1690108678;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.id = abstractSerializedData.readInt64(z);
        this.parts = abstractSerializedData.readInt32(z);
        this.md5_checksum = abstractSerializedData.readString(z);
        this.key_fingerprint = abstractSerializedData.readInt32(z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt64(this.id);
        abstractSerializedData.writeInt32(this.parts);
        abstractSerializedData.writeString(this.md5_checksum);
        abstractSerializedData.writeInt32(this.key_fingerprint);
    }
}
