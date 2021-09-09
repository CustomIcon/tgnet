package org.telegram.tgnet;

public class TLRPC$TL_privacyKeyForwards extends TLRPC$PrivacyKey {
    public static int constructor = 1777096355;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
