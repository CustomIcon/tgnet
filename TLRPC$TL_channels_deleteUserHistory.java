package org.telegram.tgnet;

public class TLRPC$TL_channels_deleteUserHistory extends TLObject {
    public static int constructor = -787622117;
    public TLRPC$InputChannel channel;
    public TLRPC$InputUser user_id;

    @Override // org.telegram.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$TL_messages_affectedHistory.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.channel.serializeToStream(abstractSerializedData);
        this.user_id.serializeToStream(abstractSerializedData);
    }
}
