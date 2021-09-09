package org.telegram.tgnet;

public class TLRPC$TL_messages_saveRecentSticker extends TLObject {
    public static int constructor = 958863608;
    public boolean attached;
    public int flags;
    public TLRPC$InputDocument id;
    public boolean unsave;

    @Override // org.telegram.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$Bool.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.attached ? this.flags | 1 : this.flags & -2;
        this.flags = i;
        abstractSerializedData.writeInt32(i);
        this.id.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeBool(this.unsave);
    }
}
