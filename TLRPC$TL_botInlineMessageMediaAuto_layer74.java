package org.telegram.tgnet;

public class TLRPC$TL_botInlineMessageMediaAuto_layer74 extends TLRPC$TL_botInlineMessageMediaAuto {
    public static int constructor = 175419739;

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_botInlineMessageMediaAuto
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.flags = abstractSerializedData.readInt32(z);
        this.message = abstractSerializedData.readString(z);
        if ((this.flags & 4) != 0) {
            this.reply_markup = TLRPC$ReplyMarkup.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        }
    }

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_botInlineMessageMediaAuto
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.flags);
        abstractSerializedData.writeString(this.message);
        if ((this.flags & 4) != 0) {
            this.reply_markup.serializeToStream(abstractSerializedData);
        }
    }
}
