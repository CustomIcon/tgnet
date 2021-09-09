package org.telegram.tgnet;

public class TLRPC$TL_keyboardButtonUrl extends TLRPC$KeyboardButton {
    public static int constructor = 629866245;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.text = abstractSerializedData.readString(z);
        this.url = abstractSerializedData.readString(z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeString(this.text);
        abstractSerializedData.writeString(this.url);
    }
}
