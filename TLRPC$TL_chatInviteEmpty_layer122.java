package org.telegram.tgnet;

public class TLRPC$TL_chatInviteEmpty_layer122 extends TLRPC$ExportedChatInvite {
    public static int constructor = 1776236393;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
