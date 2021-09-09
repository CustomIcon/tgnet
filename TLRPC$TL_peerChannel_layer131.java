package org.telegram.tgnet;

public class TLRPC$TL_peerChannel_layer131 extends TLRPC$TL_peerChannel {
    public static int constructor = -1109531342;

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_peerChannel
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.channel_id = (long) abstractSerializedData.readInt32(z);
    }

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_peerChannel
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32((int) this.channel_id);
    }
}
