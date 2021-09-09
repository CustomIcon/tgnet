package org.telegram.tgnet;

public class TLRPC$TL_messageActionLoginUnknownLocation extends TLRPC$MessageAction {
    public static int constructor = 1431655925;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.title = abstractSerializedData.readString(z);
        this.address = abstractSerializedData.readString(z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeString(this.title);
        abstractSerializedData.writeString(this.address);
    }
}
