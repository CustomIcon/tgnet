package org.telegram.tgnet;

public class TLRPC$TL_channels_editLocation extends TLObject {
    public static int constructor = 1491484525;
    public String address;
    public TLRPC$InputChannel channel;
    public TLRPC$InputGeoPoint geo_point;

    @Override // org.telegram.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$Bool.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.channel.serializeToStream(abstractSerializedData);
        this.geo_point.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeString(this.address);
    }
}
