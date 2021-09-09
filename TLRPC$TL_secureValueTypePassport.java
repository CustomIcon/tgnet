package org.telegram.tgnet;

public class TLRPC$TL_secureValueTypePassport extends TLRPC$SecureValueType {
    public static int constructor = 1034709504;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
