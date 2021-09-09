package org.telegram.tgnet;

public class TLRPC$TL_help_getDeepLinkInfo extends TLObject {
    public static int constructor = 1072547679;
    public String path;

    @Override // org.telegram.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$help_DeepLinkInfo.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeString(this.path);
    }
}
