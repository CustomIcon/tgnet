package org.telegram.tgnet;

public class TLRPC$TL_messages_deleteHistory extends TLObject {
    public static int constructor = 469850889;
    public int flags;
    public boolean just_clear;
    public int max_id;
    public TLRPC$InputPeer peer;
    public boolean revoke;

    @Override // org.telegram.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$TL_messages_affectedHistory.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.just_clear ? this.flags | 1 : this.flags & -2;
        this.flags = i;
        int i2 = this.revoke ? i | 2 : i & -3;
        this.flags = i2;
        abstractSerializedData.writeInt32(i2);
        this.peer.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt32(this.max_id);
    }
}
