package org.telegram.tgnet;

public class TLRPC$TL_pageBlockUnsupported extends TLRPC$PageBlock {
    public static int constructor = 324435594;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
