package org.telegram.tgnet;

public class TLRPC$TL_messages_messagesNotModified extends TLRPC$messages_Messages {
    public static int constructor = 1951620897;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.count = abstractSerializedData.readInt32(z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.count);
    }
}
