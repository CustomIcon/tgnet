package org.telegram.tgnet;

public class TLRPC$TL_null extends TLObject {
    public static int constructor = 1450380236;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
