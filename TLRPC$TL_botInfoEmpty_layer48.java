package org.telegram.tgnet;

public class TLRPC$TL_botInfoEmpty_layer48 extends TLRPC$TL_botInfo {
    public static int constructor = -1154598962;

    @Override // org.telegram.tgnet.TLRPC$TL_botInfo, org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
