package org.telegram.tgnet;

public class TLRPC$TL_pollResults_layer108 extends TLRPC$TL_pollResults {
    public static int constructor = 1465219162;

    @Override // org.telegram.tgnet.TLRPC$TL_pollResults, org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int readInt32 = abstractSerializedData.readInt32(z);
        this.flags = readInt32;
        this.min = (readInt32 & 1) != 0;
        if ((readInt32 & 2) != 0) {
            int readInt322 = abstractSerializedData.readInt32(z);
            if (readInt322 == 481674261) {
                int readInt323 = abstractSerializedData.readInt32(z);
                for (int i = 0; i < readInt323; i++) {
                    TLRPC$TL_pollAnswerVoters TLdeserialize = TLRPC$TL_pollAnswerVoters.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                    if (TLdeserialize != null) {
                        this.results.add(TLdeserialize);
                    } else {
                        return;
                    }
                }
            } else if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(readInt322)));
            } else {
                return;
            }
        }
        if ((this.flags & 4) != 0) {
            this.total_voters = abstractSerializedData.readInt32(z);
        }
    }

    @Override // org.telegram.tgnet.TLRPC$TL_pollResults, org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.min ? this.flags | 1 : this.flags & -2;
        this.flags = i;
        abstractSerializedData.writeInt32(i);
        if ((this.flags & 2) != 0) {
            abstractSerializedData.writeInt32(481674261);
            int size = this.results.size();
            abstractSerializedData.writeInt32(size);
            for (int i2 = 0; i2 < size; i2++) {
                this.results.get(i2).serializeToStream(abstractSerializedData);
            }
        }
        if ((this.flags & 4) != 0) {
            abstractSerializedData.writeInt32(this.total_voters);
        }
    }
}
