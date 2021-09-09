package org.telegram.tgnet;

public class TLRPC$TL_videoSize_layer115 extends TLRPC$TL_videoSize {
    public static int constructor = 1130084743;

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_videoSize
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.type = abstractSerializedData.readString(z);
        this.location = TLRPC$FileLocation.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        this.w = abstractSerializedData.readInt32(z);
        this.h = abstractSerializedData.readInt32(z);
        this.size = abstractSerializedData.readInt32(z);
    }

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_videoSize
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeString(this.type);
        this.location.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt32(this.w);
        abstractSerializedData.writeInt32(this.h);
        abstractSerializedData.writeInt32(this.size);
    }
}
