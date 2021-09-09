package org.telegram.tgnet;

public class TLRPC$TL_updateStickerSets extends TLRPC$Update {
    public static int constructor = 1135492588;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
