package org.telegram.tgnet;

import java.util.ArrayList;

public class TLRPC$TL_updatePrivacy extends TLRPC$Update {
    public static int constructor = -298113238;
    public TLRPC$PrivacyKey key;
    public ArrayList<TLRPC$PrivacyRule> rules = new ArrayList<>();

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.key = TLRPC$PrivacyKey.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        int readInt32 = abstractSerializedData.readInt32(z);
        if (readInt32 == 481674261) {
            int readInt322 = abstractSerializedData.readInt32(z);
            for (int i = 0; i < readInt322; i++) {
                TLRPC$PrivacyRule TLdeserialize = TLRPC$PrivacyRule.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                if (TLdeserialize != null) {
                    this.rules.add(TLdeserialize);
                } else {
                    return;
                }
            }
        } else if (z) {
            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(readInt32)));
        }
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.key.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt32(481674261);
        int size = this.rules.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.rules.get(i).serializeToStream(abstractSerializedData);
        }
    }
}
