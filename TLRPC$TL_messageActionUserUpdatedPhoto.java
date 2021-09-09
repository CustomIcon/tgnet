package org.telegram.tgnet;

public class TLRPC$TL_messageActionUserUpdatedPhoto extends TLRPC$MessageAction {
    public static int constructor = 1431655761;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.newUserPhoto = TLRPC$UserProfilePhoto.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.newUserPhoto.serializeToStream(abstractSerializedData);
    }
}
