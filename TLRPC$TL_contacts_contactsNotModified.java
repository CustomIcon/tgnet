package org.telegram.tgnet;

public class TLRPC$TL_contacts_contactsNotModified extends TLRPC$contacts_Contacts {
    public static int constructor = -1219778094;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
