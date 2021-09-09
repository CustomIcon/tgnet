package org.telegram.tgnet;

public class TLRPC$TL_inputMessagesFilterMyMentions extends TLRPC$MessagesFilter {
    public static int constructor = -1040652646;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
