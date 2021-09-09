package org.telegram.tgnet;

public class TLRPC$TL_inputChannel_layer131 extends TLRPC$TL_inputChannel {
    public static int constructor = -1343524562;

    @Override // org.telegram.tgnet.TLRPC$TL_inputChannel, org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.channel_id = (long) abstractSerializedData.readInt32(z);
        this.access_hash = abstractSerializedData.readInt64(z);
    }

    @Override // org.telegram.tgnet.TLRPC$TL_inputChannel, org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32((int) this.channel_id);
        abstractSerializedData.writeInt64(this.access_hash);
    }
}
