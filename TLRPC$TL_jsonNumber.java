package org.telegram.tgnet;

public class TLRPC$TL_jsonNumber extends TLRPC$JSONValue {
    public static int constructor = 736157604;
    public double value;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.value = abstractSerializedData.readDouble(z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeDouble(this.value);
    }
}
