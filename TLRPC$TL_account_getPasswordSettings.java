package org.telegram.tgnet;

public class TLRPC$TL_account_getPasswordSettings extends TLObject {
    public static int constructor = -1663767815;
    public TLRPC$InputCheckPasswordSRP password;

    @Override // org.telegram.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$TL_account_passwordSettings.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.password.serializeToStream(abstractSerializedData);
    }
}
