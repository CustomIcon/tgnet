package org.telegram.tgnet;

public class TLRPC$TL_page_layer110 extends TLRPC$TL_page {
    public static int constructor = -1366746132;

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_page
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int readInt32 = abstractSerializedData.readInt32(z);
        this.flags = readInt32;
        this.part = (readInt32 & 1) != 0;
        this.rtl = (readInt32 & 2) != 0;
        this.url = abstractSerializedData.readString(z);
        int readInt322 = abstractSerializedData.readInt32(z);
        if (readInt322 == 481674261) {
            int readInt323 = abstractSerializedData.readInt32(z);
            for (int i = 0; i < readInt323; i++) {
                TLRPC$PageBlock TLdeserialize = TLRPC$PageBlock.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                if (TLdeserialize != null) {
                    this.blocks.add(TLdeserialize);
                } else {
                    return;
                }
            }
            int readInt324 = abstractSerializedData.readInt32(z);
            if (readInt324 == 481674261) {
                int readInt325 = abstractSerializedData.readInt32(z);
                for (int i2 = 0; i2 < readInt325; i2++) {
                    TLRPC$Photo TLdeserialize2 = TLRPC$Photo.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                    if (TLdeserialize2 != null) {
                        this.photos.add(TLdeserialize2);
                    } else {
                        return;
                    }
                }
                int readInt326 = abstractSerializedData.readInt32(z);
                if (readInt326 == 481674261) {
                    int readInt327 = abstractSerializedData.readInt32(z);
                    for (int i3 = 0; i3 < readInt327; i3++) {
                        TLRPC$Document TLdeserialize3 = TLRPC$Document.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                        if (TLdeserialize3 != null) {
                            this.documents.add(TLdeserialize3);
                        } else {
                            return;
                        }
                    }
                } else if (z) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(readInt326)));
                }
            } else if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(readInt324)));
            }
        } else if (z) {
            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(readInt322)));
        }
    }

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_page
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.part ? this.flags | 1 : this.flags & -2;
        this.flags = i;
        int i2 = this.rtl ? i | 2 : i & -3;
        this.flags = i2;
        abstractSerializedData.writeInt32(i2);
        abstractSerializedData.writeString(this.url);
        abstractSerializedData.writeInt32(481674261);
        int size = this.blocks.size();
        abstractSerializedData.writeInt32(size);
        for (int i3 = 0; i3 < size; i3++) {
            this.blocks.get(i3).serializeToStream(abstractSerializedData);
        }
        abstractSerializedData.writeInt32(481674261);
        int size2 = this.photos.size();
        abstractSerializedData.writeInt32(size2);
        for (int i4 = 0; i4 < size2; i4++) {
            this.photos.get(i4).serializeToStream(abstractSerializedData);
        }
        abstractSerializedData.writeInt32(481674261);
        int size3 = this.documents.size();
        abstractSerializedData.writeInt32(size3);
        for (int i5 = 0; i5 < size3; i5++) {
            this.documents.get(i5).serializeToStream(abstractSerializedData);
        }
    }
}
