package org.telegram.tgnet;

public class TLRPC$TL_messageActionInviteToGroupCall_layer131 extends TLRPC$TL_messageActionInviteToGroupCall {
    public static int constructor = 1991897370;

    @Override // org.telegram.tgnet.TLRPC$TL_messageActionInviteToGroupCall, org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.call = TLRPC$TL_inputGroupCall.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        int readInt32 = abstractSerializedData.readInt32(z);
        if (readInt32 == 481674261) {
            int readInt322 = abstractSerializedData.readInt32(z);
            for (int i = 0; i < readInt322; i++) {
                this.users.add(Long.valueOf((long) abstractSerializedData.readInt32(z)));
            }
        } else if (z) {
            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(readInt32)));
        }
    }

    @Override // org.telegram.tgnet.TLRPC$TL_messageActionInviteToGroupCall, org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.call.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt32(481674261);
        int size = this.users.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            abstractSerializedData.writeInt32((int) this.users.get(i).longValue());
        }
    }
}
