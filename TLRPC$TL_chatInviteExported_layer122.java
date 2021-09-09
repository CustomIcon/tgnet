package org.telegram.tgnet;

public class TLRPC$TL_chatInviteExported_layer122 extends TLRPC$TL_chatInviteExported {
    public static int constructor = -64092740;

    @Override // org.telegram.tgnet.TLRPC$TL_chatInviteExported, org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.link = abstractSerializedData.readString(z);
    }

    @Override // org.telegram.tgnet.TLRPC$TL_chatInviteExported, org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeString(this.link);
    }
}
