package org.telegram.tgnet;

public class TLRPC$TL_sendMessageChooseStickerAction extends TLRPC$SendMessageAction {
    public static int constructor = -1336228175;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
