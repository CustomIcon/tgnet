package org.telegram.tgnet;

public class TLRPC$TL_decryptedMessageMediaGeoPoint extends TLRPC$DecryptedMessageMedia {
    public static int constructor = 893913689;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.lat = abstractSerializedData.readDouble(z);
        this._long = abstractSerializedData.readDouble(z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeDouble(this.lat);
        abstractSerializedData.writeDouble(this._long);
    }
}
