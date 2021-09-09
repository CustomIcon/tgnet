package org.telegram.tgnet;

public class TLRPC$TL_inputMessagesFilterPhotoVideo extends TLRPC$MessagesFilter {
    public static int constructor = 1458172132;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
