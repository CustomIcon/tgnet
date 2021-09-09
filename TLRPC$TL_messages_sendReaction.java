package org.telegram.tgnet;

public class TLRPC$TL_messages_sendReaction extends TLObject {
    public static int constructor = 627641572;
    public int flags;
    public int msg_id;
    public TLRPC$InputPeer peer;
    public String reaction;

    @Override // org.telegram.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$Updates.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.flags);
        this.peer.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt32(this.msg_id);
        if ((this.flags & 1) != 0) {
            abstractSerializedData.writeString(this.reaction);
        }
    }
}
