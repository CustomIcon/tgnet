package org.telegram.tgnet;

public class TLRPC$TL_langpack_getLanguage extends TLObject {
    public static int constructor = 1784243458;
    public String lang_code;
    public String lang_pack;

    @Override // org.telegram.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$TL_langPackLanguage.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeString(this.lang_pack);
        abstractSerializedData.writeString(this.lang_code);
    }
}
