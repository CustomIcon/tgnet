package org.telegram.tgnet;

public class TLRPC$TL_audio_old2 extends TLRPC$TL_audio_layer45 {
    public static int constructor = -945003370;

    @Override // org.telegram.tgnet.TLRPC$TL_audio_layer45, org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.id = abstractSerializedData.readInt64(z);
        this.access_hash = abstractSerializedData.readInt64(z);
        this.user_id = (long) abstractSerializedData.readInt32(z);
        this.date = abstractSerializedData.readInt32(z);
        this.duration = abstractSerializedData.readInt32(z);
        this.mime_type = abstractSerializedData.readString(z);
        this.size = abstractSerializedData.readInt32(z);
        this.dc_id = abstractSerializedData.readInt32(z);
    }

    @Override // org.telegram.tgnet.TLRPC$TL_audio_layer45, org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt64(this.id);
        abstractSerializedData.writeInt64(this.access_hash);
        abstractSerializedData.writeInt32((int) this.user_id);
        abstractSerializedData.writeInt32(this.date);
        abstractSerializedData.writeInt32(this.duration);
        abstractSerializedData.writeString(this.mime_type);
        abstractSerializedData.writeInt32(this.size);
        abstractSerializedData.writeInt32(this.dc_id);
    }
}
