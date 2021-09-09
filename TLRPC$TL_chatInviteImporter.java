package org.telegram.tgnet;

public class TLRPC$TL_chatInviteImporter extends TLObject {
    public static int constructor = 507405952;
    public int date;
    public int user_id;

    public static TLRPC$TL_chatInviteImporter TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        if (constructor == i) {
            TLRPC$TL_chatInviteImporter tLRPC$TL_chatInviteImporter = new TLRPC$TL_chatInviteImporter();
            tLRPC$TL_chatInviteImporter.readParams(abstractSerializedData, z);
            return tLRPC$TL_chatInviteImporter;
        } else if (!z) {
            return null;
        } else {
            throw new RuntimeException(String.format("can't parse magic %x in TL_chatInviteImporter", Integer.valueOf(i)));
        }
    }

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.user_id = abstractSerializedData.readInt32(z);
        this.date = abstractSerializedData.readInt32(z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.user_id);
        abstractSerializedData.writeInt32(this.date);
    }
}
