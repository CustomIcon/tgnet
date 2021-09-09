package org.telegram.tgnet;

public abstract class TLRPC$messages_FoundStickerSets extends TLObject {
    public static TLRPC$messages_FoundStickerSets TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$messages_FoundStickerSets tLRPC$messages_FoundStickerSets;
        if (i != -1963942446) {
            tLRPC$messages_FoundStickerSets = i != 223655517 ? null : new TLRPC$TL_messages_foundStickerSetsNotModified();
        } else {
            tLRPC$messages_FoundStickerSets = new TLRPC$TL_messages_foundStickerSets();
        }
        if (tLRPC$messages_FoundStickerSets != null || !z) {
            if (tLRPC$messages_FoundStickerSets != null) {
                tLRPC$messages_FoundStickerSets.readParams(abstractSerializedData, z);
            }
            return tLRPC$messages_FoundStickerSets;
        }
        throw new RuntimeException(String.format("can't parse magic %x in messages_FoundStickerSets", Integer.valueOf(i)));
    }
}
