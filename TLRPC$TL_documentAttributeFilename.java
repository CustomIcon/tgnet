package org.telegram.tgnet;

public class TLRPC$TL_documentAttributeFilename extends TLRPC$DocumentAttribute {
    public static int constructor = 358154344;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.file_name = abstractSerializedData.readString(z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeString(this.file_name);
    }
}
