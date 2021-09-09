package org.telegram.tgnet;

public class TLRPC$TL_sendMessageGeoLocationAction extends TLRPC$SendMessageAction {
    public static int constructor = 393186209;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
