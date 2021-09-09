package org.telegram.tgnet;

public class TLRPC$TL_documentAttributeSticker_old extends TLRPC$TL_documentAttributeSticker {
    public static int constructor = -83208409;

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_documentAttributeSticker
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
    }

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_documentAttributeSticker
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
