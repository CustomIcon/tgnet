package org.telegram.tgnet;

public class TLRPC$TL_sendMessageChooseContactAction extends TLRPC$SendMessageAction {
    public static int constructor = 1653390447;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
