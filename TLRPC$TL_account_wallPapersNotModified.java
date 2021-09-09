package org.telegram.tgnet;

public class TLRPC$TL_account_wallPapersNotModified extends TLRPC$account_WallPapers {
    public static int constructor = 471437699;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
