package org.telegram.tgnet;

public class TLRPC$TL_pageBlockAnchor extends TLRPC$PageBlock {
    public static int constructor = -837994576;
    public String name;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.name = abstractSerializedData.readString(z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeString(this.name);
    }
}
