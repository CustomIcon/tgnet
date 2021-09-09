package org.telegram.tgnet;

public class TLRPC$TL_inputThemeSlug extends TLRPC$InputTheme {
    public static int constructor = -175567375;
    public String slug;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.slug = abstractSerializedData.readString(z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeString(this.slug);
    }
}
