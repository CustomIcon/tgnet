package org.telegram.tgnet;

public class TLRPC$TL_decryptedMessageMediaVideo_layer17 extends TLRPC$TL_decryptedMessageMediaVideo {
    public static int constructor = 1380598109;
    public byte[] thumb;

    @Override // org.telegram.tgnet.TLRPC$TL_decryptedMessageMediaVideo, org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.thumb = abstractSerializedData.readByteArray(z);
        this.thumb_w = abstractSerializedData.readInt32(z);
        this.thumb_h = abstractSerializedData.readInt32(z);
        this.duration = abstractSerializedData.readInt32(z);
        this.mime_type = abstractSerializedData.readString(z);
        this.w = abstractSerializedData.readInt32(z);
        this.h = abstractSerializedData.readInt32(z);
        this.size = abstractSerializedData.readInt32(z);
        this.key = abstractSerializedData.readByteArray(z);
        this.iv = abstractSerializedData.readByteArray(z);
    }

    @Override // org.telegram.tgnet.TLRPC$TL_decryptedMessageMediaVideo, org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeByteArray(this.thumb);
        abstractSerializedData.writeInt32(this.thumb_w);
        abstractSerializedData.writeInt32(this.thumb_h);
        abstractSerializedData.writeInt32(this.duration);
        abstractSerializedData.writeString(this.mime_type);
        abstractSerializedData.writeInt32(this.w);
        abstractSerializedData.writeInt32(this.h);
        abstractSerializedData.writeInt32(this.size);
        abstractSerializedData.writeByteArray(this.key);
        abstractSerializedData.writeByteArray(this.iv);
    }
}
