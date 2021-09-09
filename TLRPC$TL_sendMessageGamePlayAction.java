package org.telegram.tgnet;

public class TLRPC$TL_sendMessageGamePlayAction extends TLRPC$SendMessageAction {
    public static int constructor = -580219064;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
