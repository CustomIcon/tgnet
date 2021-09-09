package org.telegram.tgnet;

public class TLRPC$TL_pageBlockList_layer82 extends TLRPC$TL_pageBlockList {
    public static int constructor = 978896884;

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_pageBlockList
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.ordered = abstractSerializedData.readBool(z);
        int readInt32 = abstractSerializedData.readInt32(z);
        if (readInt32 == 481674261) {
            int readInt322 = abstractSerializedData.readInt32(z);
            for (int i = 0; i < readInt322; i++) {
                TLRPC$RichText TLdeserialize = TLRPC$RichText.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                if (TLdeserialize != null) {
                    TLRPC$TL_pageListItemText tLRPC$TL_pageListItemText = new TLRPC$TL_pageListItemText();
                    tLRPC$TL_pageListItemText.text = TLdeserialize;
                    this.items.add(tLRPC$TL_pageListItemText);
                } else {
                    return;
                }
            }
        } else if (z) {
            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(readInt32)));
        }
    }

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_pageBlockList
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeBool(this.ordered);
        abstractSerializedData.writeInt32(481674261);
        int size = this.items.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            ((TLRPC$TL_pageListItemText) this.items.get(i)).text.serializeToStream(abstractSerializedData);
        }
    }
}
