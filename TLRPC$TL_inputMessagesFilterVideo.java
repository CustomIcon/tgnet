package org.telegram.tgnet;

public class TLRPC$TL_inputMessagesFilterVideo extends TLRPC$MessagesFilter {
    public static int constructor = -1614803355;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
