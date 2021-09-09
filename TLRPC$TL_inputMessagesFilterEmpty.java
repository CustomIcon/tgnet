package org.telegram.tgnet;

public class TLRPC$TL_inputMessagesFilterEmpty extends TLRPC$MessagesFilter {
    public static int constructor = 1474492012;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
