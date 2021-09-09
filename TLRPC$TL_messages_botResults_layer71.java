package org.telegram.tgnet;

public class TLRPC$TL_messages_botResults_layer71 extends TLRPC$TL_messages_botResults {
    public static int constructor = -858565059;

    @Override // org.telegram.tgnet.TLRPC$TL_messages_botResults, org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int readInt32 = abstractSerializedData.readInt32(z);
        this.flags = readInt32;
        this.gallery = (readInt32 & 1) != 0;
        this.query_id = abstractSerializedData.readInt64(z);
        if ((this.flags & 2) != 0) {
            this.next_offset = abstractSerializedData.readString(z);
        }
        if ((this.flags & 4) != 0) {
            this.switch_pm = TLRPC$TL_inlineBotSwitchPM.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        }
        int readInt322 = abstractSerializedData.readInt32(z);
        if (readInt322 == 481674261) {
            int readInt323 = abstractSerializedData.readInt32(z);
            for (int i = 0; i < readInt323; i++) {
                TLRPC$BotInlineResult TLdeserialize = TLRPC$BotInlineResult.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                if (TLdeserialize != null) {
                    this.results.add(TLdeserialize);
                } else {
                    return;
                }
            }
            this.cache_time = abstractSerializedData.readInt32(z);
        } else if (z) {
            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(readInt322)));
        }
    }

    @Override // org.telegram.tgnet.TLRPC$TL_messages_botResults, org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.gallery ? this.flags | 1 : this.flags & -2;
        this.flags = i;
        abstractSerializedData.writeInt32(i);
        abstractSerializedData.writeInt64(this.query_id);
        if ((this.flags & 2) != 0) {
            abstractSerializedData.writeString(this.next_offset);
        }
        if ((this.flags & 4) != 0) {
            this.switch_pm.serializeToStream(abstractSerializedData);
        }
        abstractSerializedData.writeInt32(481674261);
        int size = this.results.size();
        abstractSerializedData.writeInt32(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.results.get(i2).serializeToStream(abstractSerializedData);
        }
        abstractSerializedData.writeInt32(this.cache_time);
    }
}
