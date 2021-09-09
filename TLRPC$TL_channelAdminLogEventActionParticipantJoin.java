package org.telegram.tgnet;

public class TLRPC$TL_channelAdminLogEventActionParticipantJoin extends TLRPC$ChannelAdminLogEventAction {
    public static int constructor = 405815507;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
