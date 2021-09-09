package org.telegram.tgnet;

public class TLRPC$TL_secureValueTypeEmail extends TLRPC$SecureValueType {
    public static int constructor = -1908627474;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
