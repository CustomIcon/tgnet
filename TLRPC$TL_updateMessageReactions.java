package org.telegram.tgnet;

public class TLRPC$TL_updateMessageReactions extends TLRPC$Update {
    public static int constructor = 357013699;
    public int msg_id;
    public TLRPC$Peer peer;
    public TLRPC$TL_messageReactions reactions;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.peer = TLRPC$Peer.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        this.msg_id = abstractSerializedData.readInt32(z);
        this.reactions = TLRPC$TL_messageReactions.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.peer.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt32(this.msg_id);
        this.reactions.serializeToStream(abstractSerializedData);
    }
}
