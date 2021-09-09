package org.telegram.tgnet;

public class TLRPC$TL_boolTrue extends TLRPC$Bool {
    public static int constructor = -1720552011;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
