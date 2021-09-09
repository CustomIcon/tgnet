package org.telegram.tgnet;

public class TLRPC$TL_secureValueTypeIdentityCard extends TLRPC$SecureValueType {
    public static int constructor = -1596951477;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
