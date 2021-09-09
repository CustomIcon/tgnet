package org.telegram.tgnet;

public class TLRPC$TL_botInlineMessageMediaGeo_layer119 extends TLRPC$TL_botInlineMessageMediaGeo {
    public static int constructor = -1222451611;

    @Override // org.telegram.tgnet.TLRPC$TL_botInlineMessageMediaGeo, org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.flags = abstractSerializedData.readInt32(z);
        this.geo = TLRPC$GeoPoint.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        this.period = abstractSerializedData.readInt32(z);
        if ((this.flags & 4) != 0) {
            this.reply_markup = TLRPC$ReplyMarkup.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        }
    }

    @Override // org.telegram.tgnet.TLRPC$TL_botInlineMessageMediaGeo, org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.flags);
        this.geo.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt32(this.period);
        if ((this.flags & 4) != 0) {
            this.reply_markup.serializeToStream(abstractSerializedData);
        }
    }
}
