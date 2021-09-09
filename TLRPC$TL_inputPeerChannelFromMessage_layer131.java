package org.telegram.tgnet;

public class TLRPC$TL_inputPeerChannelFromMessage_layer131 extends TLRPC$TL_inputPeerChannelFromMessage {
    public static int constructor = -1667893317;

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_inputPeerChannelFromMessage
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.peer = TLRPC$InputPeer.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        this.msg_id = abstractSerializedData.readInt32(z);
        this.channel_id = (long) abstractSerializedData.readInt32(z);
    }

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_inputPeerChannelFromMessage
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.peer.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt32(this.msg_id);
        abstractSerializedData.writeInt32((int) this.channel_id);
    }
}
