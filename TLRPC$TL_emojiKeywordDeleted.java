package org.telegram.tgnet;

import java.util.ArrayList;

public class TLRPC$TL_emojiKeywordDeleted extends TLRPC$EmojiKeyword {
    public static int constructor = 594408994;
    public ArrayList<String> emoticons = new ArrayList<>();
    public String keyword;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.keyword = abstractSerializedData.readString(z);
        int readInt32 = abstractSerializedData.readInt32(z);
        if (readInt32 == 481674261) {
            int readInt322 = abstractSerializedData.readInt32(z);
            for (int i = 0; i < readInt322; i++) {
                this.emoticons.add(abstractSerializedData.readString(z));
            }
        } else if (z) {
            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(readInt32)));
        }
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeString(this.keyword);
        abstractSerializedData.writeInt32(481674261);
        int size = this.emoticons.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            abstractSerializedData.writeString(this.emoticons.get(i));
        }
    }
}
