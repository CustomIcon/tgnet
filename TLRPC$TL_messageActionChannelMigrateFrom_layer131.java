package org.telegram.tgnet;

public class TLRPC$TL_messageActionChannelMigrateFrom_layer131 extends TLRPC$TL_messageActionChannelMigrateFrom {
    public static int constructor = -1336546578;

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_messageActionChannelMigrateFrom
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.title = abstractSerializedData.readString(z);
        this.chat_id = (long) abstractSerializedData.readInt32(z);
    }

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_messageActionChannelMigrateFrom
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeString(this.title);
        abstractSerializedData.writeInt32((int) this.chat_id);
    }
}
