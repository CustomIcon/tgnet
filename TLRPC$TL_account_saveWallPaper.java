package org.telegram.tgnet;

public class TLRPC$TL_account_saveWallPaper extends TLObject {
    public static int constructor = 1817860919;
    public TLRPC$TL_wallPaperSettings settings;
    public boolean unsave;
    public TLRPC$InputWallPaper wallpaper;

    @Override // org.telegram.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$Bool.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.wallpaper.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeBool(this.unsave);
        this.settings.serializeToStream(abstractSerializedData);
    }
}
