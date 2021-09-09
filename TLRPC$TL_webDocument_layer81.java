package org.telegram.tgnet;

public class TLRPC$TL_webDocument_layer81 extends TLRPC$TL_webDocument {
    public static int constructor = -971322408;

    @Override // org.telegram.tgnet.TLRPC$TL_webDocument, org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.url = abstractSerializedData.readString(z);
        this.access_hash = abstractSerializedData.readInt64(z);
        this.size = abstractSerializedData.readInt32(z);
        this.mime_type = abstractSerializedData.readString(z);
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
            abstractSerializedData.readInt32(z);
        } else if (z) {
            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(readInt32)));
        }
    }

    @Override // org.telegram.tgnet.TLRPC$TL_webDocument, org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeString(this.url);
        abstractSerializedData.writeInt64(this.access_hash);
        abstractSerializedData.writeInt32(this.size);
        abstractSerializedData.writeString(this.mime_type);
        abstractSerializedData.writeInt32(481674261);
        int size = this.attributes.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.attributes.get(i).serializeToStream(abstractSerializedData);
        }
        abstractSerializedData.writeInt32(0);
    }
}
