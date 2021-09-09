package org.telegram.tgnet;

public class TLRPC$TL_contacts_topPeersDisabled extends TLRPC$contacts_TopPeers {
    public static int constructor = -1255369827;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
