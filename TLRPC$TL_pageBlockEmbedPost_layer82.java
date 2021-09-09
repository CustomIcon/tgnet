package org.telegram.tgnet;

public class TLRPC$TL_pageBlockEmbedPost_layer82 extends TLRPC$TL_pageBlockEmbedPost {
    public static int constructor = 690781161;

    @Override // org.telegram.tgnet.TLRPC$TL_pageBlockEmbedPost, org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.url = abstractSerializedData.readString(z);
        this.webpage_id = abstractSerializedData.readInt64(z);
        this.author_photo_id = abstractSerializedData.readInt64(z);
        this.author = abstractSerializedData.readString(z);
        this.date = abstractSerializedData.readInt32(z);
        int readInt32 = abstractSerializedData.readInt32(z);
        if (readInt32 == 481674261) {
            int readInt322 = abstractSerializedData.readInt32(z);
            for (int i = 0; i < readInt322; i++) {
                TLRPC$PageBlock TLdeserialize = TLRPC$PageBlock.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                if (TLdeserialize != null) {
                    this.blocks.add(TLdeserialize);
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

    @Override // org.telegram.tgnet.TLRPC$TL_pageBlockEmbedPost, org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeString(this.url);
        abstractSerializedData.writeInt64(this.webpage_id);
        abstractSerializedData.writeInt64(this.author_photo_id);
        abstractSerializedData.writeString(this.author);
        abstractSerializedData.writeInt32(this.date);
        abstractSerializedData.writeInt32(481674261);
        int size = this.blocks.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.blocks.get(i).serializeToStream(abstractSerializedData);
        }
        this.caption.text.serializeToStream(abstractSerializedData);
    }
}
