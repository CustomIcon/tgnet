package org.telegram.tgnet;

public class TLRPC$TL_messages_favedStickersNotModified extends TLRPC$messages_FavedStickers {
    public static int constructor = -1634752813;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
