package org.telegram.tgnet;

public class TLRPC$TL_inputMessagesFilterGeo extends TLRPC$MessagesFilter {
    public static int constructor = -419271411;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
