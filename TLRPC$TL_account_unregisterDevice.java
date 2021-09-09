package org.telegram.tgnet;

import java.util.ArrayList;

public class TLRPC$TL_account_unregisterDevice extends TLObject {
    public static int constructor = 813089983;
    public ArrayList<Integer> other_uids = new ArrayList<>();
    public String token;
    public int token_type;

    @Override // org.telegram.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$Bool.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.token_type);
        abstractSerializedData.writeString(this.token);
        abstractSerializedData.writeInt32(481674261);
        int size = this.other_uids.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            abstractSerializedData.writeInt32(this.other_uids.get(i).intValue());
        }
    }
}
