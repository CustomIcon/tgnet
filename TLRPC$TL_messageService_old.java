package org.telegram.tgnet;

import org.telegram.messenger.MessagesController;

public class TLRPC$TL_messageService_old extends TLRPC$TL_messageService {
    public static int constructor = -1618124613;

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_messageService
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.id = abstractSerializedData.readInt32(z);
        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
        this.from_id = tLRPC$TL_peerUser;
        tLRPC$TL_peerUser.user_id = abstractSerializedData.readInt32(z);
        this.peer_id = TLRPC$Peer.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        this.out = abstractSerializedData.readBool(z);
        this.unread = abstractSerializedData.readBool(z);
        this.flags |= MessagesController.UPDATE_MASK_READ_DIALOG_MESSAGE;
        this.date = abstractSerializedData.readInt32(z);
        this.action = TLRPC$MessageAction.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
    }

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_messageService
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.id);
        abstractSerializedData.writeInt32(this.from_id.user_id);
        this.peer_id.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeBool(this.out);
        abstractSerializedData.writeBool(this.unread);
        abstractSerializedData.writeInt32(this.date);
        this.action.serializeToStream(abstractSerializedData);
    }
}
