package org.telegram.tgnet;

import java.util.ArrayList;

public class TLRPC$TL_account_authorizations extends TLObject {
    public static int constructor = 307276766;
    public ArrayList<TLRPC$TL_authorization> authorizations = new ArrayList<>();

    public static TLRPC$TL_account_authorizations TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        if (constructor == i) {
            TLRPC$TL_account_authorizations tLRPC$TL_account_authorizations = new TLRPC$TL_account_authorizations();
            tLRPC$TL_account_authorizations.readParams(abstractSerializedData, z);
            return tLRPC$TL_account_authorizations;
        } else if (!z) {
            return null;
        } else {
            throw new RuntimeException(String.format("can't parse magic %x in TL_account_authorizations", Integer.valueOf(i)));
        }
    }

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int readInt32 = abstractSerializedData.readInt32(z);
        if (readInt32 == 481674261) {
            int readInt322 = abstractSerializedData.readInt32(z);
            for (int i = 0; i < readInt322; i++) {
                TLRPC$TL_authorization TLdeserialize = TLRPC$TL_authorization.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                if (TLdeserialize != null) {
                    this.authorizations.add(TLdeserialize);
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
        abstractSerializedData.writeInt32(481674261);
        int size = this.authorizations.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.authorizations.get(i).serializeToStream(abstractSerializedData);
        }
    }
}
