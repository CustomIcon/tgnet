package org.telegram.tgnet;

public class TLRPC$TL_sendMessageUploadVideoAction_old extends TLRPC$TL_sendMessageUploadVideoAction {
    public static int constructor = -1845219337;

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_sendMessageUploadVideoAction
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
    }

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_sendMessageUploadVideoAction
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
