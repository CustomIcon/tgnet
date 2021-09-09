package org.telegram.tgnet;

public class TLRPC$TL_documentAttributeAnimated extends TLRPC$DocumentAttribute {
    public static int constructor = 297109817;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
