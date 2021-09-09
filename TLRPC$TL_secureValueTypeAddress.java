package org.telegram.tgnet;

public class TLRPC$TL_secureValueTypeAddress extends TLRPC$SecureValueType {
    public static int constructor = -874308058;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
