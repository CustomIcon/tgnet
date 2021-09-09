package org.telegram.tgnet;

public class TLRPC$TL_langPackString extends TLRPC$LangPackString {
    public static int constructor = -892239370;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.key = abstractSerializedData.readString(z);
        this.value = abstractSerializedData.readString(z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeString(this.key);
        abstractSerializedData.writeString(this.value);
    }
}
