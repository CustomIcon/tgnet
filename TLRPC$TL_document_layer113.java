package org.telegram.tgnet;

public class TLRPC$TL_document_layer113 extends TLRPC$TL_document {
    public static int constructor = -1683841855;

    @Override // org.telegram.tgnet.TLRPC$TL_document, org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.flags = abstractSerializedData.readInt32(z);
        this.id = abstractSerializedData.readInt64(z);
        this.access_hash = abstractSerializedData.readInt64(z);
        this.file_reference = abstractSerializedData.readByteArray(z);
        this.date = abstractSerializedData.readInt32(z);
        this.mime_type = abstractSerializedData.readString(z);
        this.size = abstractSerializedData.readInt32(z);
        if ((this.flags & 1) != 0) {
            int readInt32 = abstractSerializedData.readInt32(z);
            if (readInt32 == 481674261) {
                int readInt322 = abstractSerializedData.readInt32(z);
                for (int i = 0; i < readInt322; i++) {
                    TLRPC$PhotoSize TLdeserialize = TLRPC$PhotoSize.TLdeserialize(0, 0, 0, abstractSerializedData, abstractSerializedData.readInt32(z), z);
                    if (TLdeserialize != null) {
                        this.thumbs.add(TLdeserialize);
                    } else {
                        return;
                    }
                }
            } else if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(readInt32)));
            } else {
                return;
            }
        }
        this.dc_id = abstractSerializedData.readInt32(z);
        int readInt323 = abstractSerializedData.readInt32(z);
        if (readInt323 == 481674261) {
            int readInt324 = abstractSerializedData.readInt32(z);
            for (int i2 = 0; i2 < readInt324; i2++) {
                TLRPC$DocumentAttribute TLdeserialize2 = TLRPC$DocumentAttribute.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                if (TLdeserialize2 != null) {
                    this.attributes.add(TLdeserialize2);
                } else {
                    return;
                }
            }
        } else if (z) {
            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(readInt323)));
        }
    }

    @Override // org.telegram.tgnet.TLRPC$TL_document, org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.flags);
        abstractSerializedData.writeInt64(this.id);
        abstractSerializedData.writeInt64(this.access_hash);
        abstractSerializedData.writeByteArray(this.file_reference);
        abstractSerializedData.writeInt32(this.date);
        abstractSerializedData.writeString(this.mime_type);
        abstractSerializedData.writeInt32(this.size);
        if ((this.flags & 1) != 0) {
            abstractSerializedData.writeInt32(481674261);
            int size = this.thumbs.size();
            abstractSerializedData.writeInt32(size);
            for (int i = 0; i < size; i++) {
                this.thumbs.get(i).serializeToStream(abstractSerializedData);
            }
        }
        abstractSerializedData.writeInt32(this.dc_id);
        abstractSerializedData.writeInt32(481674261);
        int size2 = this.attributes.size();
        abstractSerializedData.writeInt32(size2);
        for (int i2 = 0; i2 < size2; i2++) {
            this.attributes.get(i2).serializeToStream(abstractSerializedData);
        }
    }
}
