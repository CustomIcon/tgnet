package org.telegram.tgnet;

public class TLRPC$TL_geoPointEmpty extends TLRPC$GeoPoint {
    public static int constructor = 286776671;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
