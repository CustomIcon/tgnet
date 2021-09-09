package org.telegram.tgnet;

public class TLRPC$TL_messageEntityMentionName_layer131 extends TLRPC$TL_messageEntityMentionName {
    public static int constructor = 892193368;

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_messageEntityMentionName
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.offset = abstractSerializedData.readInt32(z);
        this.length = abstractSerializedData.readInt32(z);
        this.user_id = (long) abstractSerializedData.readInt32(z);
    }

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_messageEntityMentionName
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.offset);
        abstractSerializedData.writeInt32(this.length);
        abstractSerializedData.writeInt32((int) this.user_id);
    }
}
