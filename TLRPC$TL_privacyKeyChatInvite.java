package org.telegram.tgnet;

public class TLRPC$TL_privacyKeyChatInvite extends TLRPC$PrivacyKey {
    public static int constructor = 1343122938;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
