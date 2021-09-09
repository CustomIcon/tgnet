package org.telegram.tgnet;

public class TLRPC$TL_messages_addChatUser extends TLObject {
    public static int constructor = -106911223;
    public int chat_id;
    public int fwd_limit;
    public TLRPC$InputUser user_id;

    @Override // org.telegram.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$Updates.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.chat_id);
        this.user_id.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt32(this.fwd_limit);
    }
}
