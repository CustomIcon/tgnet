package org.telegram.tgnet;

public class TLRPC$TL_chatFull_layer132 extends TLRPC$TL_chatFull {
    public static int constructor = 1235264985;

    @Override // org.telegram.tgnet.TLRPC$TL_chatFull, org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int readInt32 = abstractSerializedData.readInt32(z);
        this.flags = readInt32;
        this.can_set_username = (readInt32 & ConnectionsManager.RequestFlagNeedQuickAck) != 0;
        this.has_scheduled = (readInt32 & 256) != 0;
        this.id = (long) abstractSerializedData.readInt32(z);
        this.about = abstractSerializedData.readString(z);
        this.participants = TLRPC$ChatParticipants.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        if ((this.flags & 4) != 0) {
            this.chat_photo = TLRPC$Photo.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        }
        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        if ((this.flags & 8192) != 0) {
            this.exported_invite = (TLRPC$TL_chatInviteExported) TLRPC$ExportedChatInvite.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        }
        if ((this.flags & 8) != 0) {
            int readInt322 = abstractSerializedData.readInt32(z);
            if (readInt322 == 481674261) {
                int readInt323 = abstractSerializedData.readInt32(z);
                for (int i = 0; i < readInt323; i++) {
                    TLRPC$BotInfo TLdeserialize = TLRPC$BotInfo.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                    if (TLdeserialize != null) {
                        this.bot_info.add(TLdeserialize);
                    } else {
                        return;
                    }
                }
            } else if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(readInt322)));
            } else {
                return;
            }
        }
        if ((this.flags & 64) != 0) {
            this.pinned_msg_id = abstractSerializedData.readInt32(z);
        }
        if ((this.flags & 2048) != 0) {
            this.folder_id = abstractSerializedData.readInt32(z);
        }
        if ((this.flags & 4096) != 0) {
            this.call = TLRPC$TL_inputGroupCall.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        }
        if ((this.flags & 16384) != 0) {
            this.ttl_period = abstractSerializedData.readInt32(z);
        }
        if ((this.flags & 32768) != 0) {
            this.groupcall_default_join_as = TLRPC$Peer.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        }
        if ((this.flags & 65536) != 0) {
            this.theme_emoticon = abstractSerializedData.readString(z);
        }
    }

    @Override // org.telegram.tgnet.TLRPC$TL_chatFull, org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.can_set_username ? this.flags | ConnectionsManager.RequestFlagNeedQuickAck : this.flags & -129;
        this.flags = i;
        int i2 = this.has_scheduled ? i | 256 : i & -257;
        this.flags = i2;
        abstractSerializedData.writeInt32(i2);
        abstractSerializedData.writeInt32((int) this.id);
        abstractSerializedData.writeString(this.about);
        this.participants.serializeToStream(abstractSerializedData);
        if ((this.flags & 4) != 0) {
            this.chat_photo.serializeToStream(abstractSerializedData);
        }
        this.notify_settings.serializeToStream(abstractSerializedData);
        if ((this.flags & 8192) != 0) {
            this.exported_invite.serializeToStream(abstractSerializedData);
        }
        if ((this.flags & 8) != 0) {
            abstractSerializedData.writeInt32(481674261);
            int size = this.bot_info.size();
            abstractSerializedData.writeInt32(size);
            for (int i3 = 0; i3 < size; i3++) {
                this.bot_info.get(i3).serializeToStream(abstractSerializedData);
            }
        }
        if ((this.flags & 64) != 0) {
            abstractSerializedData.writeInt32(this.pinned_msg_id);
        }
        if ((this.flags & 2048) != 0) {
            abstractSerializedData.writeInt32(this.folder_id);
        }
        if ((this.flags & 4096) != 0) {
            this.call.serializeToStream(abstractSerializedData);
        }
        if ((this.flags & 16384) != 0) {
            abstractSerializedData.writeInt32(this.ttl_period);
        }
        if ((this.flags & 32768) != 0) {
            this.groupcall_default_join_as.serializeToStream(abstractSerializedData);
        }
        if ((this.flags & 65536) != 0) {
            abstractSerializedData.writeString(this.theme_emoticon);
        }
    }
}
