package org.telegram.tgnet;

public class TLRPC$TL_updateDialogFilter extends TLRPC$Update {
    public static int constructor = 654302845;
    public TLRPC$TL_dialogFilter filter;
    public int flags;
    public int id;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.flags = abstractSerializedData.readInt32(z);
        this.id = abstractSerializedData.readInt32(z);
        if ((this.flags & 1) != 0) {
            this.filter = TLRPC$TL_dialogFilter.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        }
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.flags);
        abstractSerializedData.writeInt32(this.id);
        if ((this.flags & 1) != 0) {
            this.filter.serializeToStream(abstractSerializedData);
        }
    }
}
