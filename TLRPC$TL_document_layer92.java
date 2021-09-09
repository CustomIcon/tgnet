package org.telegram.tgnet;

public class TLRPC$TL_document_layer92 extends TLRPC$TL_document {
    public static int constructor = 1498631756;

    @Override // org.telegram.tgnet.TLRPC$TL_document, org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.id = abstractSerializedData.readInt64(z);
        this.access_hash = abstractSerializedData.readInt64(z);
        this.file_reference = abstractSerializedData.readByteArray(z);
        this.date = abstractSerializedData.readInt32(z);
        this.mime_type = abstractSerializedData.readString(z);
        this.size = abstractSerializedData.readInt32(z);
        this.thumbs.add(TLRPC$PhotoSize.TLdeserialize(0, 0, 0, abstractSerializedData, abstractSerializedData.readInt32(z), z));
        this.dc_id = abstractSerializedData.readInt32(z);
        int readInt32 = abstractSerializedData.readInt32(z);
        if (readInt32 == 481674261) {
            int readInt322 = abstractSerializedData.readInt32(z);
            for (int i = 0; i < readInt322; i++) {
                TLRPC$DocumentAttribute TLdeserialize = TLRPC$DocumentAttribute.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                if (TLdeserialize != null) {
                    this.attributes.add(TLdeserialize);
                } else {
                    return;
                }
            }
        } else if (z) {
            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(readInt32)));
        }
    }

    @Override // org.telegram.tgnet.TLRPC$TL_document, org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt64(this.id);
        abstractSerializedData.writeInt64(this.access_hash);
        abstractSerializedData.writeByteArray(this.file_reference);
        abstractSerializedData.writeInt32(this.date);
        abstractSerializedData.writeString(this.mime_type);
        abstractSerializedData.writeInt32(this.size);
        this.thumbs.get(0).serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt32(this.dc_id);
        abstractSerializedData.writeInt32(481674261);
        int size = this.attributes.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.attributes.get(i).serializeToStream(abstractSerializedData);
        }
    }
}
