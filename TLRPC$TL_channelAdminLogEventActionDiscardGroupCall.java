package org.telegram.tgnet;

public class TLRPC$TL_channelAdminLogEventActionDiscardGroupCall extends TLRPC$ChannelAdminLogEventAction {
    public static int constructor = -610299584;
    public TLRPC$TL_inputGroupCall call;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.call = TLRPC$TL_inputGroupCall.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.call.serializeToStream(abstractSerializedData);
    }
}
