package org.telegram.tgnet;

public class TLRPC$TL_privacyKeyAddedByPhone extends TLRPC$PrivacyKey {
    public static int constructor = 1124062251;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
