package org.telegram.tgnet;

public class TLRPC$TL_secureValueTypeRentalAgreement extends TLRPC$SecureValueType {
    public static int constructor = -1954007928;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
