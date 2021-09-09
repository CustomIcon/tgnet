package org.telegram.tgnet;

public class TLRPC$TL_phone_toggleGroupCallStartSubscription extends TLObject {
    public static int constructor = 563885286;
    public TLRPC$TL_inputGroupCall call;
    public boolean subscribed;

    @Override // org.telegram.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$Updates.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.call.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeBool(this.subscribed);
    }
}
