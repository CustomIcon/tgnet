package org.telegram.tgnet;

public class TLRPC$TL_messageActionPaymentSent extends TLRPC$MessageAction {
    public static int constructor = 1080663248;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.currency = abstractSerializedData.readString(z);
        this.total_amount = abstractSerializedData.readInt64(z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeString(this.currency);
        abstractSerializedData.writeInt64(this.total_amount);
    }
}
