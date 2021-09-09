package org.telegram.tgnet;

public class TLRPC$TL_messages_foundStickerSetsNotModified extends TLRPC$messages_FoundStickerSets {
    public static int constructor = 223655517;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
