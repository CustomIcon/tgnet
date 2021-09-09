package org.telegram.tgnet;

import java.util.ArrayList;

public abstract class TLRPC$messages_FavedStickers extends TLObject {
    public int hash;
    public ArrayList<TLRPC$TL_stickerPack> packs = new ArrayList<>();
    public ArrayList<TLRPC$Document> stickers = new ArrayList<>();

    public static TLRPC$messages_FavedStickers TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$messages_FavedStickers tLRPC$messages_FavedStickers;
        if (i != -1634752813) {
            tLRPC$messages_FavedStickers = i != -209768682 ? null : new TLRPC$TL_messages_favedStickers();
        } else {
            tLRPC$messages_FavedStickers = new TLRPC$TL_messages_favedStickersNotModified();
        }
        if (tLRPC$messages_FavedStickers != null || !z) {
            if (tLRPC$messages_FavedStickers != null) {
                tLRPC$messages_FavedStickers.readParams(abstractSerializedData, z);
            }
            return tLRPC$messages_FavedStickers;
        }
        throw new RuntimeException(String.format("can't parse magic %x in messages_FavedStickers", Integer.valueOf(i)));
    }
}
