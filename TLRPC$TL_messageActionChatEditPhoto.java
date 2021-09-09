package org.telegram.tgnet;

public class TLRPC$TL_messageActionChatEditPhoto extends TLRPC$MessageAction {
    public static int constructor = 2144015272;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.photo = TLRPC$Photo.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.photo.serializeToStream(abstractSerializedData);
    }
}
