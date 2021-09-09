package org.telegram.tgnet;

public class TLRPC$TL_messageMediaWebPage extends TLRPC$MessageMedia {
    public static int constructor = -1557277184;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.webpage = TLRPC$WebPage.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.webpage.serializeToStream(abstractSerializedData);
    }
}
