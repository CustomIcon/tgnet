package org.telegram.tgnet;

public class TLRPC$TL_keyboardButtonRequestPoll extends TLRPC$KeyboardButton {
    public static int constructor = -1144565411;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int readInt32 = abstractSerializedData.readInt32(z);
        this.flags = readInt32;
        if ((readInt32 & 1) != 0) {
            this.quiz = abstractSerializedData.readBool(z);
        }
        this.text = abstractSerializedData.readString(z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.flags);
        if ((this.flags & 1) != 0) {
            abstractSerializedData.writeBool(this.quiz);
        }
        abstractSerializedData.writeString(this.text);
    }
}
