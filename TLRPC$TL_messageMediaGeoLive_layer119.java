package org.telegram.tgnet;

public class TLRPC$TL_messageMediaGeoLive_layer119 extends TLRPC$TL_messageMediaGeoLive {
    public static int constructor = 2084316681;

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_messageMediaGeoLive
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.geo = TLRPC$GeoPoint.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        this.period = abstractSerializedData.readInt32(z);
    }

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_messageMediaGeoLive
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.geo.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt32(this.period);
    }
}
