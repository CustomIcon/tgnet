package org.telegram.tgnet;

public class TLRPC$TL_messageMediaDocument_old extends TLRPC$TL_messageMediaDocument {
    public static int constructor = 802824708;

    @Override // org.telegram.tgnet.TLRPC$TL_messageMediaDocument, org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.document = TLRPC$Document.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
    }

    @Override // org.telegram.tgnet.TLRPC$TL_messageMediaDocument, org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.document.serializeToStream(abstractSerializedData);
    }
}
