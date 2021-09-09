package org.telegram.tgnet;

public class TLRPC$TL_topPeerCategoryForwardChats extends TLRPC$TopPeerCategory {
    public static int constructor = -68239120;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
