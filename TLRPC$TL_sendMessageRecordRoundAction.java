package org.telegram.tgnet;

public class TLRPC$TL_sendMessageRecordRoundAction extends TLRPC$SendMessageAction {
    public static int constructor = -1997373508;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
