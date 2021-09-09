package org.telegram.tgnet;

public class TLRPC$TL_peerChat_layer131 extends TLRPC$TL_peerChat {
    public static int constructor = -1160714821;

    @Override // org.telegram.tgnet.TLRPC$TL_peerChat, org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.chat_id = (long) abstractSerializedData.readInt32(z);
    }

    @Override // org.telegram.tgnet.TLRPC$TL_peerChat, org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32((int) this.chat_id);
    }
}
