package org.telegram.tgnet;

public class TLRPC$TL_secureValueTypePersonalDetails extends TLRPC$SecureValueType {
    public static int constructor = -1658158621;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
