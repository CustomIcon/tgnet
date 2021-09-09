package org.telegram.tgnet;

public class TLRPC$TL_channelParticipantsAdmins extends TLRPC$ChannelParticipantsFilter {
    public static int constructor = -1268741783;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
