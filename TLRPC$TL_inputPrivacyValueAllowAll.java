package org.telegram.tgnet;

public class TLRPC$TL_inputPrivacyValueAllowAll extends TLRPC$InputPrivacyRule {
    public static int constructor = 407582158;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
