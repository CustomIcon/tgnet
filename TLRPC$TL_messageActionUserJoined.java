package org.telegram.tgnet;

public class TLRPC$TL_messageActionUserJoined extends TLRPC$MessageAction {
    public static int constructor = 1431655760;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
