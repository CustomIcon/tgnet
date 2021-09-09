package org.telegram.tgnet;

public class TLRPC$TL_inputMessagesFilterVoice extends TLRPC$MessagesFilter {
    public static int constructor = 1358283666;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
