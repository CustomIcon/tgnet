package org.telegram.tgnet;

public class TLRPC$TL_inputMessagesFilterContacts extends TLRPC$MessagesFilter {
    public static int constructor = -530392189;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
