package org.telegram.tgnet;

public class TLRPC$TL_messageReplies_layer131 extends TLRPC$TL_messageReplies {
    public static int constructor = 1093204652;

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_messageReplies
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int readInt32 = abstractSerializedData.readInt32(z);
        this.flags = readInt32;
        this.comments = (readInt32 & 1) != 0;
        this.replies = abstractSerializedData.readInt32(z);
        this.replies_pts = abstractSerializedData.readInt32(z);
        if ((this.flags & 2) != 0) {
            int readInt322 = abstractSerializedData.readInt32(z);
            if (readInt322 == 481674261) {
                int readInt323 = abstractSerializedData.readInt32(z);
                for (int i = 0; i < readInt323; i++) {
                    TLRPC$Peer TLdeserialize = TLRPC$Peer.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                    if (TLdeserialize != null) {
                        this.recent_repliers.add(TLdeserialize);
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
        if ((this.flags & 1) != 0) {
            this.channel_id = (long) abstractSerializedData.readInt32(z);
        }
        if ((this.flags & 4) != 0) {
            this.max_id = abstractSerializedData.readInt32(z);
        }
        if ((this.flags & 8) != 0) {
            this.read_max_id = abstractSerializedData.readInt32(z);
        }
    }

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_messageReplies
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.comments ? this.flags | 1 : this.flags & -2;
        this.flags = i;
        abstractSerializedData.writeInt32(i);
        abstractSerializedData.writeInt32(this.replies);
        abstractSerializedData.writeInt32(this.replies_pts);
        if ((this.flags & 2) != 0) {
            abstractSerializedData.writeInt32(481674261);
            int size = this.recent_repliers.size();
            abstractSerializedData.writeInt32(size);
            for (int i2 = 0; i2 < size; i2++) {
                this.recent_repliers.get(i2).serializeToStream(abstractSerializedData);
            }
        }
        if ((this.flags & 1) != 0) {
            abstractSerializedData.writeInt32((int) this.channel_id);
        }
        if ((this.flags & 4) != 0) {
            abstractSerializedData.writeInt32(this.max_id);
        }
        if ((this.flags & 8) != 0) {
            abstractSerializedData.writeInt32(this.read_max_id);
        }
    }
}
