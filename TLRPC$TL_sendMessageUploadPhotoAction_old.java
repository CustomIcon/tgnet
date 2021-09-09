package org.telegram.tgnet;

public class TLRPC$TL_sendMessageUploadPhotoAction_old extends TLRPC$TL_sendMessageUploadPhotoAction {
    public static int constructor = -1727382502;

    @Override // org.telegram.tgnet.TLRPC$TL_sendMessageUploadPhotoAction, org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
    }

    @Override // org.telegram.tgnet.TLRPC$TL_sendMessageUploadPhotoAction, org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
