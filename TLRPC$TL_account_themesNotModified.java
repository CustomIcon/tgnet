package org.telegram.tgnet;

public class TLRPC$TL_account_themesNotModified extends TLRPC$account_Themes {
    public static int constructor = -199313886;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
