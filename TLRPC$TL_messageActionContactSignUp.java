package org.telegram.tgnet;

public class TLRPC$TL_messageActionContactSignUp extends TLRPC$MessageAction {
    public static int constructor = -202219658;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
