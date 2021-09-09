package org.telegram.tgnet;

public class TLRPC$TL_channels_getParticipants extends TLObject {
    public static int constructor = 306054633;
    public TLRPC$InputChannel channel;
    public TLRPC$ChannelParticipantsFilter filter;
    public int hash;
    public int limit;
    public int offset;

    @Override // org.telegram.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$channels_ChannelParticipants.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.channel.serializeToStream(abstractSerializedData);
        this.filter.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt32(this.offset);
        abstractSerializedData.writeInt32(this.limit);
        abstractSerializedData.writeInt32(this.hash);
    }
}
