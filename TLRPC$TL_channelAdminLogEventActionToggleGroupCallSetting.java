package org.telegram.tgnet;

public class TLRPC$TL_channelAdminLogEventActionToggleGroupCallSetting extends TLRPC$ChannelAdminLogEventAction {
    public static int constructor = 1456906823;
    public boolean join_muted;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.join_muted = abstractSerializedData.readBool(z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeBool(this.join_muted);
    }
}
