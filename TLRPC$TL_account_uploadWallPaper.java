package org.telegram.tgnet;

public class TLRPC$TL_account_uploadWallPaper extends TLObject {
    public static int constructor = -578472351;
    public TLRPC$InputFile file;
    public String mime_type;
    public TLRPC$TL_wallPaperSettings settings;

    @Override // org.telegram.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$WallPaper.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.file.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeString(this.mime_type);
        this.settings.serializeToStream(abstractSerializedData);
    }
}
