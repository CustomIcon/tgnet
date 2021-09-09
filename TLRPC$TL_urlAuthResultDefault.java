package org.telegram.tgnet;

public class TLRPC$TL_urlAuthResultDefault extends TLRPC$UrlAuthResult {
    public static int constructor = -1445536993;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
