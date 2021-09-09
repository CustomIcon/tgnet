package org.telegram.tgnet;

public class TLRPC$TL_privacyKeyProfilePhoto extends TLRPC$PrivacyKey {
    public static int constructor = -1777000467;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
