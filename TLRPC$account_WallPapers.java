package org.telegram.tgnet;

public abstract class TLRPC$account_WallPapers extends TLObject {
    public static TLRPC$account_WallPapers TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$account_WallPapers tLRPC$account_WallPapers;
        if (i != 471437699) {
            tLRPC$account_WallPapers = i != 1881892265 ? null : new TLRPC$TL_account_wallPapers();
        } else {
            tLRPC$account_WallPapers = new TLRPC$TL_account_wallPapersNotModified();
        }
        if (tLRPC$account_WallPapers != null || !z) {
            if (tLRPC$account_WallPapers != null) {
                tLRPC$account_WallPapers.readParams(abstractSerializedData, z);
            }
            return tLRPC$account_WallPapers;
        }
        throw new RuntimeException(String.format("can't parse magic %x in account_WallPapers", Integer.valueOf(i)));
    }
}
