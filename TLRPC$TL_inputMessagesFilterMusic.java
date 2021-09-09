package org.telegram.tgnet;

public class TLRPC$TL_inputMessagesFilterMusic extends TLRPC$MessagesFilter {
    public static int constructor = 928101534;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
