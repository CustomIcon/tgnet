package org.telegram.tgnet;

public class TLRPC$TL_messages_savedGifs extends TLRPC$messages_SavedGifs {
    public static int constructor = 772213157;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.hash = abstractSerializedData.readInt32(z);
        int readInt32 = abstractSerializedData.readInt32(z);
        if (readInt32 == 481674261) {
            int readInt322 = abstractSerializedData.readInt32(z);
            for (int i = 0; i < readInt322; i++) {
                TLRPC$Document TLdeserialize = TLRPC$Document.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                if (TLdeserialize != null) {
                    this.gifs.add(TLdeserialize);
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
        abstractSerializedData.writeInt32(this.hash);
        abstractSerializedData.writeInt32(481674261);
        int size = this.gifs.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.gifs.get(i).serializeToStream(abstractSerializedData);
        }
    }
}
