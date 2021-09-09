package org.telegram.tgnet;

public class TLRPC$TL_themeDocumentNotModified_layer106 extends TLRPC$Theme {
    public static int constructor = 1211967244;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
