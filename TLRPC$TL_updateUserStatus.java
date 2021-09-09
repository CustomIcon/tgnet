package org.telegram.tgnet;

public class TLRPC$TL_updateUserStatus extends TLRPC$Update {
    public static int constructor = -440534818;
    public TLRPC$UserStatus status;
    public long user_id;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.user_id = abstractSerializedData.readInt64(z);
        this.status = TLRPC$UserStatus.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt64(this.user_id);
        this.status.serializeToStream(abstractSerializedData);
    }
}
