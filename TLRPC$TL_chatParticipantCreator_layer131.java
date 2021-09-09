package org.telegram.tgnet;

public class TLRPC$TL_chatParticipantCreator_layer131 extends TLRPC$TL_chatParticipantCreator {
    public static int constructor = -636267638;

    @Override // org.telegram.tgnet.TLRPC$TL_chatParticipantCreator, org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.user_id = (long) abstractSerializedData.readInt32(z);
    }

    @Override // org.telegram.tgnet.TLRPC$TL_chatParticipantCreator, org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32((int) this.user_id);
    }
}
