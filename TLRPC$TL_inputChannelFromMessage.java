package org.telegram.tgnet;

public class TLRPC$TL_inputChannelFromMessage extends TLRPC$InputChannel {
    public static int constructor = 707290417;
    public int msg_id;
    public TLRPC$InputPeer peer;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.peer = TLRPC$InputPeer.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        this.msg_id = abstractSerializedData.readInt32(z);
        this.channel_id = abstractSerializedData.readInt32(z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.peer.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt32(this.msg_id);
        abstractSerializedData.writeInt32(this.channel_id);
    }
}
