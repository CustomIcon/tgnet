package org.telegram.tgnet;

import java.util.ArrayList;

public class TLRPC$TL_account_chatThemes extends TLRPC$account_ChatThemes {
    public static int constructor = -28524867;
    public int hash;
    public ArrayList<TLRPC$TL_chatTheme> themes = new ArrayList<>();

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.hash = abstractSerializedData.readInt32(z);
        int readInt32 = abstractSerializedData.readInt32(z);
        if (readInt32 == 481674261) {
            int readInt322 = abstractSerializedData.readInt32(z);
            for (int i = 0; i < readInt322; i++) {
                TLRPC$TL_chatTheme TLdeserialize = TLRPC$TL_chatTheme.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                if (TLdeserialize != null) {
                    this.themes.add(TLdeserialize);
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
        int size = this.themes.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.themes.get(i).serializeToStream(abstractSerializedData);
        }
    }
}
