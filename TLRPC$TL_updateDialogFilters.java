package org.telegram.tgnet;

public class TLRPC$TL_updateDialogFilters extends TLRPC$Update {
    public static int constructor = 889491791;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
