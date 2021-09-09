package org.telegram.tgnet;

import java.util.ArrayList;

public class TLRPC$TL_groupCallParticipantVideoSourceGroup extends TLObject {
    public static int constructor = -592373577;
    public String semantics;
    public ArrayList<Integer> sources = new ArrayList<>();

    public static TLRPC$TL_groupCallParticipantVideoSourceGroup TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        if (constructor == i) {
            TLRPC$TL_groupCallParticipantVideoSourceGroup tLRPC$TL_groupCallParticipantVideoSourceGroup = new TLRPC$TL_groupCallParticipantVideoSourceGroup();
            tLRPC$TL_groupCallParticipantVideoSourceGroup.readParams(abstractSerializedData, z);
            return tLRPC$TL_groupCallParticipantVideoSourceGroup;
        } else if (!z) {
            return null;
        } else {
            throw new RuntimeException(String.format("can't parse magic %x in TL_groupCallParticipantVideoSourceGroup", Integer.valueOf(i)));
        }
    }

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.semantics = abstractSerializedData.readString(z);
        int readInt32 = abstractSerializedData.readInt32(z);
        if (readInt32 == 481674261) {
            int readInt322 = abstractSerializedData.readInt32(z);
            for (int i = 0; i < readInt322; i++) {
                this.sources.add(Integer.valueOf(abstractSerializedData.readInt32(z)));
            }
        } else if (z) {
            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(readInt32)));
        }
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeString(this.semantics);
        abstractSerializedData.writeInt32(481674261);
        int size = this.sources.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            abstractSerializedData.writeInt32(this.sources.get(i).intValue());
        }
    }
}
