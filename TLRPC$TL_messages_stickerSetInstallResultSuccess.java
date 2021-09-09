package org.telegram.tgnet;

public class TLRPC$TL_messages_stickerSetInstallResultSuccess extends TLRPC$messages_StickerSetInstallResult {
    public static int constructor = 946083368;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
