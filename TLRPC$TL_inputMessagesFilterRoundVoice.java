package org.telegram.tgnet;

public class TLRPC$TL_inputMessagesFilterRoundVoice extends TLRPC$MessagesFilter {
    public static int constructor = 2054952868;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
