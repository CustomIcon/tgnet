package org.telegram.tgnet;

public class TLRPC$TL_chatParticipants_old extends TLRPC$TL_chatParticipants {
    public static int constructor = 2017571861;

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_chatParticipants
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.chat_id = abstractSerializedData.readInt32(z);
        this.admin_id = abstractSerializedData.readInt32(z);
        int readInt32 = abstractSerializedData.readInt32(z);
        if (readInt32 == 481674261) {
            int readInt322 = abstractSerializedData.readInt32(z);
            for (int i = 0; i < readInt322; i++) {
                TLRPC$ChatParticipant TLdeserialize = TLRPC$ChatParticipant.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                if (TLdeserialize != null) {
                    this.participants.add(TLdeserialize);
                } else {
                    return;
                }
            }
            this.version = abstractSerializedData.readInt32(z);
        } else if (z) {
            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(readInt32)));
        }
    }

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_chatParticipants
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.chat_id);
        abstractSerializedData.writeInt32(this.admin_id);
        abstractSerializedData.writeInt32(481674261);
        int size = this.participants.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.participants.get(i).serializeToStream(abstractSerializedData);
        }
        abstractSerializedData.writeInt32(this.version);
    }
}
