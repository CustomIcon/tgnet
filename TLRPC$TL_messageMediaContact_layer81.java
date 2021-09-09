package org.telegram.tgnet;

public class TLRPC$TL_messageMediaContact_layer81 extends TLRPC$TL_messageMediaContact {
    public static int constructor = 1585262393;

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_messageMediaContact
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.phone_number = abstractSerializedData.readString(z);
        this.first_name = abstractSerializedData.readString(z);
        this.last_name = abstractSerializedData.readString(z);
        this.user_id = abstractSerializedData.readInt32(z);
    }

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_messageMediaContact
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeString(this.phone_number);
        abstractSerializedData.writeString(this.first_name);
        abstractSerializedData.writeString(this.last_name);
        abstractSerializedData.writeInt32(this.user_id);
    }
}
