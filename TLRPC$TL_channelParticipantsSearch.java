package org.telegram.tgnet;

public class TLRPC$TL_channelParticipantsSearch extends TLRPC$ChannelParticipantsFilter {
    public static int constructor = 106343499;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.q = abstractSerializedData.readString(z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeString(this.q);
    }
}
