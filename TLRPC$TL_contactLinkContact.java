package org.telegram.tgnet;

public class TLRPC$TL_contactLinkContact extends TLRPC$ContactLink_layer101 {
    public static int constructor = -721239344;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
