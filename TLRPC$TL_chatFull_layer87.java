package org.telegram.tgnet;

public class TLRPC$TL_chatFull_layer87 extends TLRPC$TL_chatFull {
    public static int constructor = 771925524;

    @Override // org.telegram.tgnet.TLRPC$TL_chatFull, org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.id = (long) abstractSerializedData.readInt32(z);
        this.participants = TLRPC$ChatParticipants.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        this.chat_photo = TLRPC$Photo.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        TLRPC$ExportedChatInvite TLdeserialize = TLRPC$ExportedChatInvite.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        if (TLdeserialize instanceof TLRPC$TL_chatInviteExported) {
            this.exported_invite = (TLRPC$TL_chatInviteExported) TLdeserialize;
        }
        int readInt32 = abstractSerializedData.readInt32(z);
        if (readInt32 == 481674261) {
            int readInt322 = abstractSerializedData.readInt32(z);
            for (int i = 0; i < readInt322; i++) {
                TLRPC$BotInfo TLdeserialize2 = TLRPC$BotInfo.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                if (TLdeserialize2 != null) {
                    this.bot_info.add(TLdeserialize2);
                } else {
                    return;
                }
            }
        } else if (z) {
            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(readInt32)));
        }
    }

    @Override // org.telegram.tgnet.TLRPC$TL_chatFull, org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32((int) this.id);
        this.participants.serializeToStream(abstractSerializedData);
        this.chat_photo.serializeToStream(abstractSerializedData);
        this.notify_settings.serializeToStream(abstractSerializedData);
        this.exported_invite.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt32(481674261);
        int size = this.bot_info.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.bot_info.get(i).serializeToStream(abstractSerializedData);
        }
    }
}
