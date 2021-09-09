package org.telegram.tgnet;

import org.telegram.messenger.MessagesController;

public class TLRPC$TL_user_old extends TLRPC$TL_user {
    public static int constructor = 585404530;

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_user
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int readInt32 = abstractSerializedData.readInt32(z);
        this.flags = readInt32;
        boolean z2 = false;
        this.self = (readInt32 & MessagesController.UPDATE_MASK_PHONE) != 0;
        this.contact = (readInt32 & MessagesController.UPDATE_MASK_NEW_MESSAGE) != 0;
        this.mutual_contact = (readInt32 & MessagesController.UPDATE_MASK_SEND_STATE) != 0;
        this.deleted = (readInt32 & MessagesController.UPDATE_MASK_CHAT) != 0;
        this.bot = (readInt32 & 16384) != 0;
        this.bot_chat_history = (32768 & readInt32) != 0;
        this.bot_nochats = (65536 & readInt32) != 0;
        this.verified = (131072 & readInt32) != 0;
        if ((readInt32 & 262144) != 0) {
            z2 = true;
        }
        this.explicit_content = z2;
        this.id = abstractSerializedData.readInt32(z);
        if ((this.flags & 1) != 0) {
            this.access_hash = abstractSerializedData.readInt64(z);
        }
        if ((this.flags & 2) != 0) {
            this.first_name = abstractSerializedData.readString(z);
        }
        if ((this.flags & 4) != 0) {
            this.last_name = abstractSerializedData.readString(z);
        }
        if ((this.flags & 8) != 0) {
            this.username = abstractSerializedData.readString(z);
        }
        if ((this.flags & 16) != 0) {
            this.phone = abstractSerializedData.readString(z);
        }
        if ((this.flags & 32) != 0) {
            this.photo = TLRPC$UserProfilePhoto.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        }
        if ((this.flags & 64) != 0) {
            this.status = TLRPC$UserStatus.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        }
        if ((this.flags & 16384) != 0) {
            this.bot_info_version = abstractSerializedData.readInt32(z);
        }
    }

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_user
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.self ? this.flags | MessagesController.UPDATE_MASK_PHONE : this.flags & -1025;
        this.flags = i;
        int i2 = this.contact ? i | MessagesController.UPDATE_MASK_NEW_MESSAGE : i & -2049;
        this.flags = i2;
        int i3 = this.mutual_contact ? i2 | MessagesController.UPDATE_MASK_SEND_STATE : i2 & -4097;
        this.flags = i3;
        int i4 = this.deleted ? i3 | MessagesController.UPDATE_MASK_CHAT : i3 & -8193;
        this.flags = i4;
        int i5 = this.bot ? i4 | 16384 : i4 & -16385;
        this.flags = i5;
        int i6 = this.bot_chat_history ? i5 | MessagesController.UPDATE_MASK_MESSAGE_TEXT : i5 & -32769;
        this.flags = i6;
        int i7 = this.bot_nochats ? i6 | MessagesController.UPDATE_MASK_CHECK : i6 & -65537;
        this.flags = i7;
        int i8 = this.verified ? i7 | MessagesController.UPDATE_MASK_REORDER : i7 & -131073;
        this.flags = i8;
        int i9 = this.explicit_content ? i8 | 262144 : i8 & -262145;
        this.flags = i9;
        abstractSerializedData.writeInt32(i9);
        abstractSerializedData.writeInt32(this.id);
        if ((this.flags & 1) != 0) {
            abstractSerializedData.writeInt64(this.access_hash);
        }
        if ((this.flags & 2) != 0) {
            abstractSerializedData.writeString(this.first_name);
        }
        if ((this.flags & 4) != 0) {
            abstractSerializedData.writeString(this.last_name);
        }
        if ((this.flags & 8) != 0) {
            abstractSerializedData.writeString(this.username);
        }
        if ((this.flags & 16) != 0) {
            abstractSerializedData.writeString(this.phone);
        }
        if ((this.flags & 32) != 0) {
            this.photo.serializeToStream(abstractSerializedData);
        }
        if ((this.flags & 64) != 0) {
            this.status.serializeToStream(abstractSerializedData);
        }
        if ((this.flags & 16384) != 0) {
            abstractSerializedData.writeInt32(this.bot_info_version);
        }
    }
}
