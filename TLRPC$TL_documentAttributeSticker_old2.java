package org.telegram.tgnet;

public class TLRPC$TL_documentAttributeSticker_old2 extends TLRPC$TL_documentAttributeSticker {
    public static int constructor = -1723033470;

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_documentAttributeSticker
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.alt = abstractSerializedData.readString(z);
    }

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_documentAttributeSticker
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeString(this.alt);
    }
}
