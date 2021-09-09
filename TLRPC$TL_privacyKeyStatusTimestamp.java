package org.telegram.tgnet;

public class TLRPC$TL_privacyKeyStatusTimestamp extends TLRPC$PrivacyKey {
    public static int constructor = -1137792208;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
