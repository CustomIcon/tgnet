package org.telegram.tgnet;

public class TLRPC$TL_secureValueTypeBankStatement extends TLRPC$SecureValueType {
    public static int constructor = -1995211763;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
