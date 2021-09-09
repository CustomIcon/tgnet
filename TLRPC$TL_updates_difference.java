package org.telegram.tgnet;

public class TLRPC$TL_updates_difference extends TLRPC$updates_Difference {
    public static int constructor = 16030880;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int readInt32 = abstractSerializedData.readInt32(z);
        if (readInt32 == 481674261) {
            int readInt322 = abstractSerializedData.readInt32(z);
            for (int i = 0; i < readInt322; i++) {
                TLRPC$Message TLdeserialize = TLRPC$Message.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                if (TLdeserialize != null) {
                    this.new_messages.add(TLdeserialize);
                } else {
                    return;
                }
            }
            int readInt323 = abstractSerializedData.readInt32(z);
            if (readInt323 == 481674261) {
                int readInt324 = abstractSerializedData.readInt32(z);
                for (int i2 = 0; i2 < readInt324; i2++) {
                    TLRPC$EncryptedMessage TLdeserialize2 = TLRPC$EncryptedMessage.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                    if (TLdeserialize2 != null) {
                        this.new_encrypted_messages.add(TLdeserialize2);
                    } else {
                        return;
                    }
                }
                int readInt325 = abstractSerializedData.readInt32(z);
                if (readInt325 == 481674261) {
                    int readInt326 = abstractSerializedData.readInt32(z);
                    for (int i3 = 0; i3 < readInt326; i3++) {
                        TLRPC$Update TLdeserialize3 = TLRPC$Update.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                        if (TLdeserialize3 != null) {
                            this.other_updates.add(TLdeserialize3);
                        } else {
                            return;
                        }
                    }
                    int readInt327 = abstractSerializedData.readInt32(z);
                    if (readInt327 == 481674261) {
                        int readInt328 = abstractSerializedData.readInt32(z);
                        for (int i4 = 0; i4 < readInt328; i4++) {
                            TLRPC$Chat TLdeserialize4 = TLRPC$Chat.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                            if (TLdeserialize4 != null) {
                                this.chats.add(TLdeserialize4);
                            } else {
                                return;
                            }
                        }
                        int readInt329 = abstractSerializedData.readInt32(z);
                        if (readInt329 == 481674261) {
                            int readInt3210 = abstractSerializedData.readInt32(z);
                            for (int i5 = 0; i5 < readInt3210; i5++) {
                                TLRPC$User TLdeserialize5 = TLRPC$User.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                                if (TLdeserialize5 != null) {
                                    this.users.add(TLdeserialize5);
                                } else {
                                    return;
                                }
                            }
                            this.state = TLRPC$TL_updates_state.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                        } else if (z) {
                            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(readInt329)));
                        }
                    } else if (z) {
                        throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(readInt327)));
                    }
                } else if (z) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(readInt325)));
                }
            } else if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(readInt323)));
            }
        } else if (z) {
            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(readInt32)));
        }
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(481674261);
        int size = this.new_messages.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.new_messages.get(i).serializeToStream(abstractSerializedData);
        }
        abstractSerializedData.writeInt32(481674261);
        int size2 = this.new_encrypted_messages.size();
        abstractSerializedData.writeInt32(size2);
        for (int i2 = 0; i2 < size2; i2++) {
            this.new_encrypted_messages.get(i2).serializeToStream(abstractSerializedData);
        }
        abstractSerializedData.writeInt32(481674261);
        int size3 = this.other_updates.size();
        abstractSerializedData.writeInt32(size3);
        for (int i3 = 0; i3 < size3; i3++) {
            this.other_updates.get(i3).serializeToStream(abstractSerializedData);
        }
        abstractSerializedData.writeInt32(481674261);
        int size4 = this.chats.size();
        abstractSerializedData.writeInt32(size4);
        for (int i4 = 0; i4 < size4; i4++) {
            this.chats.get(i4).serializeToStream(abstractSerializedData);
        }
        abstractSerializedData.writeInt32(481674261);
        int size5 = this.users.size();
        abstractSerializedData.writeInt32(size5);
        for (int i5 = 0; i5 < size5; i5++) {
            this.users.get(i5).serializeToStream(abstractSerializedData);
        }
        this.state.serializeToStream(abstractSerializedData);
    }
}
