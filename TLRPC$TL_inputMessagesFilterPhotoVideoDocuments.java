package org.telegram.tgnet;

public class TLRPC$TL_inputMessagesFilterPhotoVideoDocuments extends TLRPC$MessagesFilter {
    public static int constructor = -648121413;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
