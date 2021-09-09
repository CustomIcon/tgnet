package org.telegram.tgnet;

public class TLRPC$TL_peerUser_layer131 extends TLRPC$TL_peerUser {
    public static int constructor = -1649296275;

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_peerUser
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.user_id = (long) abstractSerializedData.readInt32(z);
    }

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_peerUser
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32((int) this.user_id);
    }
}
