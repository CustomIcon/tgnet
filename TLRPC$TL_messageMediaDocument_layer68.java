package org.telegram.tgnet;

public class TLRPC$TL_messageMediaDocument_layer68 extends TLRPC$TL_messageMediaDocument {
    public static int constructor = -203411800;

    @Override // org.telegram.tgnet.TLRPC$TL_messageMediaDocument, org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.document = TLRPC$Document.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        this.captionLegacy = abstractSerializedData.readString(z);
    }

    @Override // org.telegram.tgnet.TLRPC$TL_messageMediaDocument, org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.document.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeString(this.captionLegacy);
    }
}
