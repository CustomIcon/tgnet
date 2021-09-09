package org.telegram.tgnet;

public class TLRPC$TL_inputChannelEmpty extends TLRPC$InputChannel {
    public static int constructor = -292807034;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
