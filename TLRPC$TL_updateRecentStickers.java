package org.telegram.tgnet;

public class TLRPC$TL_updateRecentStickers extends TLRPC$Update {
    public static int constructor = -1706939360;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
