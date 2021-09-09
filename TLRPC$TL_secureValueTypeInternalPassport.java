package org.telegram.tgnet;

public class TLRPC$TL_secureValueTypeInternalPassport extends TLRPC$SecureValueType {
    public static int constructor = -1717268701;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
