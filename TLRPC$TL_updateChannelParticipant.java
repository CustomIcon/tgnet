package org.telegram.tgnet;

public class TLRPC$TL_updateChannelParticipant extends TLRPC$Update {
    public static int constructor = -1738720581;
    public long actor_id;
    public long channel_id;
    public int date;
    public int flags;
    public TLRPC$ExportedChatInvite invite;
    public TLRPC$ChannelParticipant new_participant;
    public TLRPC$ChannelParticipant prev_participant;
    public int qts;
    public long user_id;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.flags = abstractSerializedData.readInt32(z);
        this.channel_id = abstractSerializedData.readInt64(z);
        this.date = abstractSerializedData.readInt32(z);
        this.actor_id = abstractSerializedData.readInt64(z);
        this.user_id = abstractSerializedData.readInt64(z);
        if ((this.flags & 1) != 0) {
            this.prev_participant = TLRPC$ChannelParticipant.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        }
        if ((this.flags & 2) != 0) {
            this.new_participant = TLRPC$ChannelParticipant.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        }
        if ((this.flags & 4) != 0) {
            this.invite = TLRPC$ExportedChatInvite.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        }
        this.qts = abstractSerializedData.readInt32(z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.flags);
        abstractSerializedData.writeInt64(this.channel_id);
        abstractSerializedData.writeInt32(this.date);
        abstractSerializedData.writeInt64(this.actor_id);
        abstractSerializedData.writeInt64(this.user_id);
        if ((this.flags & 1) != 0) {
            this.prev_participant.serializeToStream(abstractSerializedData);
        }
        if ((this.flags & 2) != 0) {
            this.new_participant.serializeToStream(abstractSerializedData);
        }
        if ((this.flags & 4) != 0) {
            this.invite.serializeToStream(abstractSerializedData);
        }
        abstractSerializedData.writeInt32(this.qts);
    }
}
