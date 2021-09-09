package org.telegram.tgnet;

import org.telegram.messenger.MessagesController;

public class TLRPC$TL_documentAttributeAudio extends TLRPC$DocumentAttribute {
    public static int constructor = -1739392570;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int readInt32 = abstractSerializedData.readInt32(z);
        this.flags = readInt32;
        this.voice = (readInt32 & MessagesController.UPDATE_MASK_PHONE) != 0;
        this.duration = abstractSerializedData.readInt32(z);
        if ((this.flags & 1) != 0) {
            this.title = abstractSerializedData.readString(z);
        }
        if ((this.flags & 2) != 0) {
            this.performer = abstractSerializedData.readString(z);
        }
        if ((this.flags & 4) != 0) {
            this.waveform = abstractSerializedData.readByteArray(z);
        }
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        int i = this.voice ? this.flags | MessagesController.UPDATE_MASK_PHONE : this.flags & -1025;
        this.flags = i;
        abstractSerializedData.writeInt32(i);
        abstractSerializedData.writeInt32(this.duration);
        if ((this.flags & 1) != 0) {
            abstractSerializedData.writeString(this.title);
        }
        if ((this.flags & 2) != 0) {
            abstractSerializedData.writeString(this.performer);
        }
        if ((this.flags & 4) != 0) {
            abstractSerializedData.writeByteArray(this.waveform);
        }
    }
}
