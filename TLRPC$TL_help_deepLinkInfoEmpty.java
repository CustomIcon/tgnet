package org.telegram.tgnet;

public class TLRPC$TL_help_deepLinkInfoEmpty extends TLRPC$help_DeepLinkInfo {
    public static int constructor = 1722786150;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
