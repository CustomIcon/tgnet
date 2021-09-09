package org.telegram.tgnet;

public class TLRPC$TL_inputDialogPeerFolder extends TLRPC$InputDialogPeer {
    public static int constructor = 1684014375;
    public int folder_id;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.folder_id = abstractSerializedData.readInt32(z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(this.folder_id);
    }
}
