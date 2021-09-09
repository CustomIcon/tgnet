package org.telegram.tgnet;

public class TLRPC$TL_messages_dialogsNotModified extends TLRPC$messages_Dialogs {
    public static int constructor = -253500010;

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
