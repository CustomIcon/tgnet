package org.telegram.tgnet;

public class TLRPC$TL_messages_getStickers extends TLObject {
    public static int constructor = 71126828;
    public String emoticon;
    public int hash;

    @Override // org.telegram.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$messages_Stickers.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeString(this.emoticon);
        abstractSerializedData.writeInt32(this.hash);
    }
}
