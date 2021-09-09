package org.telegram.tgnet;

public class TLRPC$TL_messageUserVote extends TLRPC$MessageUserVote {
    public static int constructor = 886196148;
    public byte[] option;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.user_id = abstractSerializedData.readInt64(z);
        this.option = abstractSerializedData.readByteArray(z);
        this.date = abstractSerializedData.readInt32(z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt64(this.user_id);
        abstractSerializedData.writeByteArray(this.option);
        abstractSerializedData.writeInt32(this.date);
    }
}
