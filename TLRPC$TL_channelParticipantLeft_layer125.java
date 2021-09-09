package org.telegram.tgnet;

public class TLRPC$TL_channelParticipantLeft_layer125 extends TLRPC$TL_channelParticipantLeft {
    public static int constructor = -1010402965;

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_channelParticipantLeft
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
        this.peer = tLRPC$TL_peerUser;
        tLRPC$TL_peerUser.user_id = (long) abstractSerializedData.readInt32(z);
    }

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_channelParticipantLeft
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32((int) this.peer.user_id);
    }
}
