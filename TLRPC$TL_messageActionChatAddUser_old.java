package org.telegram.tgnet;

public class TLRPC$TL_messageActionChatAddUser_old extends TLRPC$TL_messageActionChatAddUser {
    public static int constructor = 1581055051;

    @Override // org.telegram.tgnet.TLRPC$TL_messageActionChatAddUser, org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.user_id = (long) abstractSerializedData.readInt32(z);
    }

    @Override // org.telegram.tgnet.TLRPC$TL_messageActionChatAddUser, org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32((int) this.user_id);
    }
}
