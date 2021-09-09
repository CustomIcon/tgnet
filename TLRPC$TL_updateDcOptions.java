package org.telegram.tgnet;

import java.util.ArrayList;

public class TLRPC$TL_updateDcOptions extends TLRPC$Update {
    public static int constructor = -1906403213;
    public ArrayList<TLRPC$TL_dcOption> dc_options = new ArrayList<>();

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int readInt32 = abstractSerializedData.readInt32(z);
        if (readInt32 == 481674261) {
            int readInt322 = abstractSerializedData.readInt32(z);
            for (int i = 0; i < readInt322; i++) {
                TLRPC$TL_dcOption TLdeserialize = TLRPC$TL_dcOption.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                if (TLdeserialize != null) {
                    this.dc_options.add(TLdeserialize);
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
        int size = this.dc_options.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.dc_options.get(i).serializeToStream(abstractSerializedData);
        }
    }
}
