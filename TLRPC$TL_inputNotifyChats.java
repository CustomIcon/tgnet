package org.telegram.tgnet;

public class TLRPC$TL_inputNotifyChats extends TLRPC$InputNotifyPeer {
    public static int constructor = 1251338318;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
