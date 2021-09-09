package org.telegram.tgnet;

public class TLRPC$TL_privacyKeyPhoneP2P extends TLRPC$PrivacyKey {
    public static int constructor = 961092808;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
