package org.telegram.tgnet;

public class TLRPC$TL_updateChannelAvailableMessages extends TLRPC$Update {
    public static int constructor = 1893427255;
    public int available_min_id;
    public int channel_id;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.channel_id = abstractSerializedData.readInt32(z);
        this.available_min_id = abstractSerializedData.readInt32(z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.channel_id);
        abstractSerializedData.writeInt32(this.available_min_id);
    }
}
