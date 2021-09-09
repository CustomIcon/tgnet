package org.telegram.tgnet;

public class TLRPC$TL_messageMediaUnsupported_old extends TLRPC$TL_messageMediaUnsupported {
    public static int constructor = 694364726;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.bytes = abstractSerializedData.readByteArray(z);
    }

    @Override // org.telegram.tgnet.TLRPC$TL_messageMediaUnsupported, org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeByteArray(this.bytes);
    }
}
