package org.telegram.tgnet;

public class TLRPC$TL_inputPrivacyKeyPhoneP2P extends TLRPC$InputPrivacyKey {
    public static int constructor = -610373422;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
