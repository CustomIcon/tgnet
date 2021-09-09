package org.telegram.tgnet;

import java.util.ArrayList;

public class TLRPC$TL_secureValueErrorFiles extends TLRPC$SecureValueError {
    public static int constructor = 1717706985;
    public ArrayList<byte[]> file_hash = new ArrayList<>();
    public String text;
    public TLRPC$SecureValueType type;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.type = TLRPC$SecureValueType.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        int readInt32 = abstractSerializedData.readInt32(z);
        if (readInt32 == 481674261) {
            int readInt322 = abstractSerializedData.readInt32(z);
            for (int i = 0; i < readInt322; i++) {
                this.file_hash.add(abstractSerializedData.readByteArray(z));
            }
            this.text = abstractSerializedData.readString(z);
        } else if (z) {
            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(readInt32)));
        }
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.type.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt32(481674261);
        int size = this.file_hash.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            abstractSerializedData.writeByteArray(this.file_hash.get(i));
        }
        abstractSerializedData.writeString(this.text);
    }
}
