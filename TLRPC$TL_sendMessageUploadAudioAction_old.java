package org.telegram.tgnet;

public class TLRPC$TL_sendMessageUploadAudioAction_old extends TLRPC$TL_sendMessageUploadAudioAction {
    public static int constructor = -424899985;

    @Override // org.telegram.tgnet.TLRPC$TL_sendMessageUploadAudioAction, org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
    }

    @Override // org.telegram.tgnet.TLRPC$TL_sendMessageUploadAudioAction, org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
