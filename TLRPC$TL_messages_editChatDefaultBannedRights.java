package org.telegram.tgnet;

public class TLRPC$TL_messages_editChatDefaultBannedRights extends TLObject {
    public static int constructor = -1517917375;
    public TLRPC$TL_chatBannedRights banned_rights;
    public TLRPC$InputPeer peer;

    @Override // org.telegram.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$Updates.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.peer.serializeToStream(abstractSerializedData);
        this.banned_rights.serializeToStream(abstractSerializedData);
    }
}
