package org.telegram.tgnet;

public class TLRPC$TL_updateUserTyping extends TLRPC$Update {
    public static int constructor = 1548249383;
    public TLRPC$SendMessageAction action;
    public int user_id;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.user_id = abstractSerializedData.readInt32(z);
        this.action = TLRPC$SendMessageAction.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.user_id);
        this.action.serializeToStream(abstractSerializedData);
    }
}
