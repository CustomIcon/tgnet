package org.telegram.tgnet;

public class TLRPC$TL_messages_getChatInviteImporters extends TLObject {
    public static int constructor = 654013065;
    public int limit;
    public String link;
    public int offset_date;
    public TLRPC$InputUser offset_user;
    public TLRPC$InputPeer peer;

    @Override // org.telegram.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$TL_messages_chatInviteImporters.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.peer.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeString(this.link);
        abstractSerializedData.writeInt32(this.offset_date);
        this.offset_user.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt32(this.limit);
    }
}
