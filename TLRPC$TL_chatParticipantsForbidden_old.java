package org.telegram.tgnet;

public class TLRPC$TL_chatParticipantsForbidden_old extends TLRPC$TL_chatParticipantsForbidden {
    public static int constructor = 265468810;

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_chatParticipantsForbidden
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.chat_id = abstractSerializedData.readInt32(z);
    }

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_chatParticipantsForbidden
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.chat_id);
    }
}
