package org.telegram.tgnet;

public class TLRPC$TL_botInfo_layer48 extends TLRPC$TL_botInfo {
    public static int constructor = 164583517;

    @Override // org.telegram.tgnet.TLRPC$TL_botInfo, org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.user_id = abstractSerializedData.readInt32(z);
        this.version = abstractSerializedData.readInt32(z);
        abstractSerializedData.readString(z);
        this.description = abstractSerializedData.readString(z);
        int readInt32 = abstractSerializedData.readInt32(z);
        if (readInt32 == 481674261) {
            int readInt322 = abstractSerializedData.readInt32(z);
            for (int i = 0; i < readInt322; i++) {
                TLRPC$TL_botCommand TLdeserialize = TLRPC$TL_botCommand.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                if (TLdeserialize != null) {
                    this.commands.add(TLdeserialize);
                } else {
                    return;
                }
            }
        } else if (z) {
            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(readInt32)));
        }
    }

    @Override // org.telegram.tgnet.TLRPC$TL_botInfo, org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.user_id);
        abstractSerializedData.writeInt32(this.version);
        abstractSerializedData.writeString("");
        abstractSerializedData.writeString(this.description);
        abstractSerializedData.writeInt32(481674261);
        int size = this.commands.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.commands.get(i).serializeToStream(abstractSerializedData);
        }
    }
}
