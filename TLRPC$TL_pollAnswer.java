package org.telegram.tgnet;

public class TLRPC$TL_pollAnswer extends TLObject {
    public static int constructor = 1823064809;
    public byte[] option;
    public String text;

    public static TLRPC$TL_pollAnswer TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        if (constructor == i) {
            TLRPC$TL_pollAnswer tLRPC$TL_pollAnswer = new TLRPC$TL_pollAnswer();
            tLRPC$TL_pollAnswer.readParams(abstractSerializedData, z);
            return tLRPC$TL_pollAnswer;
        } else if (!z) {
            return null;
        } else {
            throw new RuntimeException(String.format("can't parse magic %x in TL_pollAnswer", Integer.valueOf(i)));
        }
    }

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.text = abstractSerializedData.readString(z);
        this.option = abstractSerializedData.readByteArray(z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeString(this.text);
        abstractSerializedData.writeByteArray(this.option);
    }
}
