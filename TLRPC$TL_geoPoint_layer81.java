package org.telegram.tgnet;

public class TLRPC$TL_geoPoint_layer81 extends TLRPC$TL_geoPoint {
    public static int constructor = 541710092;

    @Override // org.telegram.tgnet.TLRPC$TL_geoPoint, org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this._long = abstractSerializedData.readDouble(z);
        this.lat = abstractSerializedData.readDouble(z);
    }

    @Override // org.telegram.tgnet.TLRPC$TL_geoPoint, org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeDouble(this._long);
        abstractSerializedData.writeDouble(this.lat);
    }
}
