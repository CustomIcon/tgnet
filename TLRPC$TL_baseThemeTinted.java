package org.telegram.tgnet;

public class TLRPC$TL_baseThemeTinted extends TLRPC$BaseTheme {
    public static int constructor = 1834973166;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
