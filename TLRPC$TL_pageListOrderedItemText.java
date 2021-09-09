package org.telegram.tgnet;

public class TLRPC$TL_pageListOrderedItemText extends TLRPC$PageListOrderedItem {
    public static int constructor = 1577484359;
    public String num;
    public TLRPC$RichText text;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.num = abstractSerializedData.readString(z);
        this.text = TLRPC$RichText.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeString(this.num);
        this.text.serializeToStream(abstractSerializedData);
    }
}
