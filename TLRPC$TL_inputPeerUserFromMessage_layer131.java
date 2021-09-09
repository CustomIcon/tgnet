package org.telegram.tgnet;

public class TLRPC$TL_inputPeerUserFromMessage_layer131 extends TLRPC$TL_inputPeerUserFromMessage {
    public static int constructor = 398123750;

    @Override // org.telegram.tgnet.TLRPC$TL_inputPeerUserFromMessage, org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.peer = TLRPC$InputPeer.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        this.msg_id = abstractSerializedData.readInt32(z);
        this.user_id = (long) abstractSerializedData.readInt32(z);
    }

    @Override // org.telegram.tgnet.TLRPC$TL_inputPeerUserFromMessage, org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.peer.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt32(this.msg_id);
        abstractSerializedData.writeInt32((int) this.user_id);
    }
}
