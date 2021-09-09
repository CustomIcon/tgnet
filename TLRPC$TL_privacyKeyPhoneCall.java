package org.telegram.tgnet;

public class TLRPC$TL_privacyKeyPhoneCall extends TLRPC$PrivacyKey {
    public static int constructor = 1030105979;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
