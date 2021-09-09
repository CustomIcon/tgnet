package org.telegram.tgnet;

public class TLRPC$TL_userEmpty_layer131 extends TLRPC$TL_userEmpty {
    public static int constructor = 537022650;

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_userEmpty
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.id = (long) abstractSerializedData.readInt32(z);
    }

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_userEmpty
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32((int) this.id);
    }
}
