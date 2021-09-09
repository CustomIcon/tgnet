package org.telegram.tgnet;

public class TLRPC$TL_channelParticipantCreator_layer103 extends TLRPC$TL_channelParticipantCreator {
    public static int constructor = -471670279;

    @Override // org.telegram.tgnet.TLRPC$TL_channelParticipantCreator, org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
        this.peer = tLRPC$TL_peerUser;
        tLRPC$TL_peerUser.user_id = (long) abstractSerializedData.readInt32(z);
    }

    @Override // org.telegram.tgnet.TLRPC$TL_channelParticipantCreator, org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32((int) this.peer.user_id);
    }
}
