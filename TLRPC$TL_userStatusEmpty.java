package org.telegram.tgnet;

public class TLRPC$TL_userStatusEmpty extends TLRPC$UserStatus {
    public static int constructor = 164646985;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
