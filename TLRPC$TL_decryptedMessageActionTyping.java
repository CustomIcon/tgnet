package org.telegram.tgnet;

public class TLRPC$TL_decryptedMessageActionTyping extends TLRPC$DecryptedMessageAction {
    public static int constructor = -860719551;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.action = TLRPC$SendMessageAction.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.action.serializeToStream(abstractSerializedData);
    }
}
