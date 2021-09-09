package org.telegram.tgnet;

public class TLRPC$TL_documentAttributeVideo_layer65 extends TLRPC$TL_documentAttributeVideo {
    public static int constructor = 1494273227;

    @Override // org.telegram.tgnet.TLRPC$TL_documentAttributeVideo, org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.duration = abstractSerializedData.readInt32(z);
        this.w = abstractSerializedData.readInt32(z);
        this.h = abstractSerializedData.readInt32(z);
    }

    @Override // org.telegram.tgnet.TLRPC$TL_documentAttributeVideo, org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.duration);
        abstractSerializedData.writeInt32(this.w);
        abstractSerializedData.writeInt32(this.h);
    }
}
