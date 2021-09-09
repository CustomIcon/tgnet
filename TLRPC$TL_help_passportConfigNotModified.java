package org.telegram.tgnet;

public class TLRPC$TL_help_passportConfigNotModified extends TLRPC$help_PassportConfig {
    public static int constructor = -1078332329;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
