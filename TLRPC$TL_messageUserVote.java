package org.telegram.tgnet;

public class TLRPC$TL_messageUserVote extends TLRPC$MessageUserVote {
    public static int constructor = -1567730343;
    public byte[] option;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.user_id = abstractSerializedData.readInt32(z);
        this.option = abstractSerializedData.readByteArray(z);
        this.date = abstractSerializedData.readInt32(z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.user_id);
        abstractSerializedData.writeByteArray(this.option);
        abstractSerializedData.writeInt32(this.date);
    }
}
