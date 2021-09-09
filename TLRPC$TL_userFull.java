package org.telegram.tgnet;

import org.telegram.messenger.MessagesController;

public class TLRPC$TL_userFull extends TLRPC$UserFull {
    public static int constructor = -694681851;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int readInt32 = abstractSerializedData.readInt32(z);
        this.flags = readInt32;
        boolean z2 = false;
        this.blocked = (readInt32 & 1) != 0;
        this.phone_calls_available = (readInt32 & 16) != 0;
        this.phone_calls_private = (readInt32 & 32) != 0;
        this.can_pin_message = (readInt32 & 128) != 0;
        this.has_scheduled = (readInt32 & MessagesController.UPDATE_MASK_SEND_STATE) != 0;
        if ((readInt32 & MessagesController.UPDATE_MASK_CHAT) != 0) {
            z2 = true;
        }
        this.video_calls_available = z2;
        this.user = TLRPC$User.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        if ((this.flags & 2) != 0) {
            this.about = abstractSerializedData.readString(z);
        }
        this.settings = TLRPC$TL_peerSettings.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        if ((this.flags & 4) != 0) {
            this.profile_photo = TLRPC$Photo.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        }
        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        if ((this.flags & 8) != 0) {
            this.bot_info = TLRPC$BotInfo.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        }
        if ((this.flags & 64) != 0) {
            this.pinned_msg_id = abstractSerializedData.readInt32(z);
        }
        this.common_chats_count = abstractSerializedData.readInt32(z);
        if ((this.flags & MessagesController.UPDATE_MASK_NEW_MESSAGE) != 0) {
            this.folder_id = abstractSerializedData.readInt32(z);
        }
        if ((this.flags & 16384) != 0) {
            this.ttl_period = abstractSerializedData.readInt32(z);
        }
        if ((this.flags & MessagesController.UPDATE_MASK_MESSAGE_TEXT) != 0) {
            this.theme_emoticon = abstractSerializedData.readString(z);
        }
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.blocked ? this.flags | 1 : this.flags & -2;
        this.flags = i;
        int i2 = this.phone_calls_available ? i | 16 : i & -17;
        this.flags = i2;
        int i3 = this.phone_calls_private ? i2 | 32 : i2 & -33;
        this.flags = i3;
        int i4 = this.can_pin_message ? i3 | 128 : i3 & -129;
        this.flags = i4;
        int i5 = this.has_scheduled ? i4 | MessagesController.UPDATE_MASK_SEND_STATE : i4 & -4097;
        this.flags = i5;
        int i6 = this.video_calls_available ? i5 | MessagesController.UPDATE_MASK_CHAT : i5 & -8193;
        this.flags = i6;
        abstractSerializedData.writeInt32(i6);
        this.user.serializeToStream(abstractSerializedData);
        if ((this.flags & 2) != 0) {
            abstractSerializedData.writeString(this.about);
        }
        this.settings.serializeToStream(abstractSerializedData);
        if ((this.flags & 4) != 0) {
            this.profile_photo.serializeToStream(abstractSerializedData);
        }
        this.notify_settings.serializeToStream(abstractSerializedData);
        if ((this.flags & 8) != 0) {
            this.bot_info.serializeToStream(abstractSerializedData);
        }
        if ((this.flags & 64) != 0) {
            abstractSerializedData.writeInt32(this.pinned_msg_id);
        }
        abstractSerializedData.writeInt32(this.common_chats_count);
        if ((this.flags & MessagesController.UPDATE_MASK_NEW_MESSAGE) != 0) {
            abstractSerializedData.writeInt32(this.folder_id);
        }
        if ((this.flags & 16384) != 0) {
            abstractSerializedData.writeInt32(this.ttl_period);
        }
        if ((this.flags & MessagesController.UPDATE_MASK_MESSAGE_TEXT) != 0) {
            abstractSerializedData.writeString(this.theme_emoticon);
        }
    }
}
