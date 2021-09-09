package org.telegram.tgnet;

public class TLRPC$TL_inputPeerChat_layer131 extends TLRPC$TL_inputPeerChat {
    public static int constructor = 396093539;

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_inputPeerChat
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.chat_id = (long) abstractSerializedData.readInt32(z);
    }

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_inputPeerChat
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32((int) this.chat_id);
    }
}
