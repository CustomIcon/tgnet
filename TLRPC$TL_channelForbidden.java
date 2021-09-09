package org.telegram.tgnet;

import org.telegram.messenger.MessagesController;

public class TLRPC$TL_channelForbidden extends TLRPC$Chat {
    public static int constructor = 681420594;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int readInt32 = abstractSerializedData.readInt32(z);
        this.flags = readInt32;
        boolean z2 = true;
        this.broadcast = (readInt32 & 32) != 0;
        if ((readInt32 & MessagesController.UPDATE_MASK_READ_DIALOG_MESSAGE) == 0) {
            z2 = false;
        }
        this.megagroup = z2;
        this.id = abstractSerializedData.readInt32(z);
        this.access_hash = abstractSerializedData.readInt64(z);
        this.title = abstractSerializedData.readString(z);
        if ((this.flags & MessagesController.UPDATE_MASK_CHECK) != 0) {
            this.until_date = abstractSerializedData.readInt32(z);
        }
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.broadcast ? this.flags | 32 : this.flags & -33;
        this.flags = i;
        int i2 = this.megagroup ? i | MessagesController.UPDATE_MASK_READ_DIALOG_MESSAGE : i & -257;
        this.flags = i2;
        abstractSerializedData.writeInt32(i2);
        abstractSerializedData.writeInt32(this.id);
        abstractSerializedData.writeInt64(this.access_hash);
        abstractSerializedData.writeString(this.title);
        if ((this.flags & MessagesController.UPDATE_MASK_CHECK) != 0) {
            abstractSerializedData.writeInt32(this.until_date);
        }
    }
}
