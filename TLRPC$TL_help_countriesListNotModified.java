package org.telegram.tgnet;

public class TLRPC$TL_help_countriesListNotModified extends TLRPC$help_CountriesList {
    public static int constructor = -1815339214;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
