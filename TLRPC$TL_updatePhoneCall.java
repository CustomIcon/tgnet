package org.telegram.tgnet;

public class TLRPC$TL_updatePhoneCall extends TLRPC$Update {
    public static int constructor = -1425052898;
    public TLRPC$PhoneCall phone_call;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.phone_call = TLRPC$PhoneCall.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.phone_call.serializeToStream(abstractSerializedData);
    }
}
