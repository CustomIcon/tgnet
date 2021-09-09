package org.telegram.tgnet;

public class TLRPC$TL_topPeerCategoryPhoneCalls extends TLRPC$TopPeerCategory {
    public static int constructor = 511092620;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
