package org.telegram.tgnet;

public class TLRPC$TL_messages_savedGifsNotModified extends TLRPC$messages_SavedGifs {
    public static int constructor = -402498398;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
