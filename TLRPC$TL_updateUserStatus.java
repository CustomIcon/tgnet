package org.telegram.tgnet;

public class TLRPC$TL_updateUserStatus extends TLRPC$Update {
    public static int constructor = 469489699;
    public TLRPC$UserStatus status;
    public int user_id;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.user_id = abstractSerializedData.readInt32(z);
        this.status = TLRPC$UserStatus.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.user_id);
        this.status.serializeToStream(abstractSerializedData);
    }
}
