package org.telegram.tgnet;

public class TLRPC$TL_updates_differenceEmpty extends TLRPC$updates_Difference {
    public static int constructor = 1567990072;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.date = abstractSerializedData.readInt32(z);
        this.seq = abstractSerializedData.readInt32(z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.date);
        abstractSerializedData.writeInt32(this.seq);
    }
}
