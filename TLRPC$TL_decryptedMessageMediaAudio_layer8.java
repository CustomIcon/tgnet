package org.telegram.tgnet;

public class TLRPC$TL_decryptedMessageMediaAudio_layer8 extends TLRPC$TL_decryptedMessageMediaAudio {
    public static int constructor = 1619031439;

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_decryptedMessageMediaAudio
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.duration = abstractSerializedData.readInt32(z);
        this.size = abstractSerializedData.readInt32(z);
        this.key = abstractSerializedData.readByteArray(z);
        this.iv = abstractSerializedData.readByteArray(z);
    }

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_decryptedMessageMediaAudio
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.duration);
        abstractSerializedData.writeInt32(this.size);
        abstractSerializedData.writeByteArray(this.key);
        abstractSerializedData.writeByteArray(this.iv);
    }
}
