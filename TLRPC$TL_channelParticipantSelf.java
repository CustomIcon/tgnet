package org.telegram.tgnet;

public class TLRPC$TL_channelParticipantSelf extends TLRPC$ChannelParticipant {
    public static int constructor = 682146919;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
        this.peer = tLRPC$TL_peerUser;
        tLRPC$TL_peerUser.user_id = abstractSerializedData.readInt64(z);
        this.inviter_id = abstractSerializedData.readInt64(z);
        this.date = abstractSerializedData.readInt32(z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt64(this.peer.user_id);
        abstractSerializedData.writeInt64(this.inviter_id);
        abstractSerializedData.writeInt32(this.date);
    }
}
