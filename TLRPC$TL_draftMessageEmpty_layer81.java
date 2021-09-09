package org.telegram.tgnet;

public class TLRPC$TL_draftMessageEmpty_layer81 extends TLRPC$TL_draftMessageEmpty {
    public static int constructor = -1169445179;

    @Override // org.telegram.tgnet.TLRPC$TL_draftMessageEmpty, org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
