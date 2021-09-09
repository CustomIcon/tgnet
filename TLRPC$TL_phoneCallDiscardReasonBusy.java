package org.telegram.tgnet;

public class TLRPC$TL_phoneCallDiscardReasonBusy extends TLRPC$PhoneCallDiscardReason {
    public static int constructor = -84416311;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
