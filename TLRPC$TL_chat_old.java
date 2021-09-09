package org.telegram.tgnet;

public class TLRPC$TL_chat_old extends TLRPC$TL_chat {
    public static int constructor = 1855757255;

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_chat
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.id = (long) abstractSerializedData.readInt32(z);
        this.title = abstractSerializedData.readString(z);
        this.photo = TLRPC$ChatPhoto.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        this.participants_count = abstractSerializedData.readInt32(z);
        this.date = abstractSerializedData.readInt32(z);
        this.left = abstractSerializedData.readBool(z);
        this.version = abstractSerializedData.readInt32(z);
    }

    @Override // org.telegram.tgnet.TLObject, org.telegram.tgnet.TLRPC$TL_chat
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32((int) this.id);
        abstractSerializedData.writeString(this.title);
        this.photo.serializeToStream(abstractSerializedData);
        abstractSerializedData.writeInt32(this.participants_count);
        abstractSerializedData.writeInt32(this.date);
        abstractSerializedData.writeBool(this.left);
        abstractSerializedData.writeInt32(this.version);
    }
}
