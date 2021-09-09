package org.telegram.tgnet;

import java.util.ArrayList;

public class TLRPC$TL_updateGroupCallParticipants extends TLRPC$Update {
    public static int constructor = -219423922;
    public TLRPC$TL_inputGroupCall call;
    public ArrayList<TLRPC$TL_groupCallParticipant> participants = new ArrayList<>();
    public int version;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.call = TLRPC$TL_inputGroupCall.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        int readInt32 = abstractSerializedData.readInt32(z);
        if (readInt32 == 481674261) {
            int readInt322 = abstractSerializedData.readInt32(z);
            for (int i = 0; i < readInt322; i++) {
                TLRPC$TL_groupCallParticipant TLdeserialize = TLRPC$TL_groupCallParticipant.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
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

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.call.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt32(481674261);
        int size = this.participants.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.participants.get(i).serializeToStream(abstractSerializedData);
        }
        abstractSerializedData.writeInt32(this.version);
    }
}
