package org.telegram.tgnet;

public class TLRPC$TL_updateChannelMessageViews extends TLRPC$Update {
    public static int constructor = -1734268085;
    public int channel_id;
    public int id;
    public int views;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.channel_id = abstractSerializedData.readInt32(z);
        this.id = abstractSerializedData.readInt32(z);
        this.views = abstractSerializedData.readInt32(z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.channel_id);
        abstractSerializedData.writeInt32(this.id);
        abstractSerializedData.writeInt32(this.views);
    }
}