package org.telegram.tgnet;

public class TLRPC$TL_inputPrivacyValueDisallowAll extends TLRPC$InputPrivacyRule {
    public static int constructor = -697604407;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
