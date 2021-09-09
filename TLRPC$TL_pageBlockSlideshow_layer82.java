package org.telegram.tgnet;

public class TLRPC$TL_pageBlockSlideshow_layer82 extends TLRPC$TL_pageBlockSlideshow {
    public static int constructor = 319588707;

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_pageBlockSlideshow
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int readInt32 = abstractSerializedData.readInt32(z);
        if (readInt32 == 481674261) {
            int readInt322 = abstractSerializedData.readInt32(z);
            for (int i = 0; i < readInt322; i++) {
                TLRPC$PageBlock TLdeserialize = TLRPC$PageBlock.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                if (TLdeserialize != null) {
                    this.items.add(TLdeserialize);
                } else {
                    return;
                }
            }
            TLRPC$TL_pageCaption tLRPC$TL_pageCaption = new TLRPC$TL_pageCaption();
            this.caption = tLRPC$TL_pageCaption;
            tLRPC$TL_pageCaption.text = TLRPC$RichText.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
            this.caption.credit = new TLRPC$TL_textEmpty();
        } else if (z) {
            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(readInt32)));
        }
    }

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_pageBlockSlideshow
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(481674261);
        int size = this.items.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.items.get(i).serializeToStream(abstractSerializedData);
        }
        this.caption.text.serializeToStream(abstractSerializedData);
    }
}
