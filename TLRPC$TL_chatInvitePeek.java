package org.telegram.tgnet;

public class TLRPC$TL_chatInvitePeek extends TLRPC$ChatInvite {
    public static int constructor = 1634294960;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.chat = TLRPC$Chat.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        this.expires = abstractSerializedData.readInt32(z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.chat.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt32(this.expires);
    }
}
