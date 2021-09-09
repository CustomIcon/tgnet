package org.telegram.tgnet;

public class TLRPC$TL_secureValueTypePassportRegistration extends TLRPC$SecureValueType {
    public static int constructor = -1713143702;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
