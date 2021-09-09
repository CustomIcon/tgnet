package org.telegram.tgnet;

public class TLRPC$TL_updateReadFeaturedStickers extends TLRPC$Update {
    public static int constructor = 1461528386;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
