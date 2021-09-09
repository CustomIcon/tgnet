package org.telegram.tgnet;

import java.util.ArrayList;

public class TLRPC$TL_messageUserVoteMultiple extends TLRPC$MessageUserVote {
    public static int constructor = -1973033641;
    public ArrayList<byte[]> options = new ArrayList<>();

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.user_id = abstractSerializedData.readInt64(z);
        int readInt32 = abstractSerializedData.readInt32(z);
        if (readInt32 == 481674261) {
            int readInt322 = abstractSerializedData.readInt32(z);
            for (int i = 0; i < readInt322; i++) {
                this.options.add(abstractSerializedData.readByteArray(z));
            }
            this.date = abstractSerializedData.readInt32(z);
        } else if (z) {
            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(readInt32)));
        }
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt64(this.user_id);
        abstractSerializedData.writeInt32(481674261);
        int size = this.options.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            abstractSerializedData.writeByteArray(this.options.get(i));
        }
        abstractSerializedData.writeInt32(this.date);
    }
}
