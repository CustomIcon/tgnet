package org.telegram.tgnet;

public class TLRPC$TL_channelMessagesFilterEmpty extends TLRPC$ChannelMessagesFilter {
    public static int constructor = -1798033689;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
