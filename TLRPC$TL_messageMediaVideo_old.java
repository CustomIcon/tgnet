package org.telegram.tgnet;

public class TLRPC$TL_messageMediaVideo_old extends TLRPC$TL_messageMediaVideo_layer45 {
    public static int constructor = -1563278704;

    @Override // org.telegram.tgnet.TLRPC$TL_messageMediaVideo_layer45, org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.video_unused = TLRPC$Video.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
    }

    @Override // org.telegram.tgnet.TLRPC$TL_messageMediaVideo_layer45, org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.video_unused.serializeToStream(abstractSerializedData);
    }
}
