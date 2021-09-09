package org.telegram.tgnet;

public class TLRPC$TL_chatInviteAlready extends TLRPC$ChatInvite {
    public static int constructor = 1516793212;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.chat = TLRPC$Chat.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.chat.serializeToStream(abstractSerializedData);
    }
}
