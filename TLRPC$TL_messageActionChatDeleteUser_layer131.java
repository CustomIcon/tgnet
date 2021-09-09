package org.telegram.tgnet;

public class TLRPC$TL_messageActionChatDeleteUser_layer131 extends TLRPC$TL_messageActionChatDeleteUser {
    public static int constructor = -1297179892;

    @Override // org.telegram.tgnet.TLRPC$TL_messageActionChatDeleteUser, org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.user_id = (long) abstractSerializedData.readInt32(z);
    }

    @Override // org.telegram.tgnet.TLRPC$TL_messageActionChatDeleteUser, org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32((int) this.user_id);
    }
}
