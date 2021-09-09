package org.telegram.tgnet;

public class TLRPC$TL_channels_channelParticipantsNotModified extends TLRPC$channels_ChannelParticipants {
    public static int constructor = -266911767;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
