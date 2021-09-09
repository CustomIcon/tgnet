package org.telegram.tgnet;

import java.util.ArrayList;

public class TLRPC$TL_messages_stickerSet extends TLObject {
    public static int constructor = -1240849242;
    public ArrayList<TLRPC$Document> documents = new ArrayList<>();
    public ArrayList<TLRPC$TL_stickerPack> packs = new ArrayList<>();
    public TLRPC$StickerSet set;

    public static TLRPC$TL_messages_stickerSet TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        if (constructor == i) {
            TLRPC$TL_messages_stickerSet tLRPC$TL_messages_stickerSet = new TLRPC$TL_messages_stickerSet();
            tLRPC$TL_messages_stickerSet.readParams(abstractSerializedData, z);
            return tLRPC$TL_messages_stickerSet;
        } else if (!z) {
            return null;
        } else {
            throw new RuntimeException(String.format("can't parse magic %x in TL_messages_stickerSet", Integer.valueOf(i)));
        }
    }

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.set = TLRPC$StickerSet.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        int readInt32 = abstractSerializedData.readInt32(z);
        if (readInt32 == 481674261) {
            int readInt322 = abstractSerializedData.readInt32(z);
            for (int i = 0; i < readInt322; i++) {
                TLRPC$TL_stickerPack TLdeserialize = TLRPC$TL_stickerPack.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                if (TLdeserialize != null) {
                    this.packs.add(TLdeserialize);
                } else {
                    return;
                }
            }
            int readInt323 = abstractSerializedData.readInt32(z);
            if (readInt323 == 481674261) {
                int readInt324 = abstractSerializedData.readInt32(z);
                for (int i2 = 0; i2 < readInt324; i2++) {
                    TLRPC$Document TLdeserialize2 = TLRPC$Document.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                    if (TLdeserialize2 != null) {
                        this.documents.add(TLdeserialize2);
                    } else {
                        return;
                    }
                }
            } else if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(readInt323)));
            }
        } else if (z) {
            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(readInt32)));
        }
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.set.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt32(481674261);
        int size = this.packs.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.packs.get(i).serializeToStream(abstractSerializedData);
        }
        abstractSerializedData.writeInt32(481674261);
        int size2 = this.documents.size();
        abstractSerializedData.writeInt32(size2);
        for (int i2 = 0; i2 < size2; i2++) {
            this.documents.get(i2).serializeToStream(abstractSerializedData);
        }
    }
}
