package org.telegram.tgnet;

public class TLRPC$TL_account_updateNotifySettings extends TLObject {
    public static int constructor = -2067899501;
    public TLRPC$InputNotifyPeer peer;
    public TLRPC$TL_inputPeerNotifySettings settings;

    @Override // org.telegram.tgnet.TLObject
    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return TLRPC$Bool.TLdeserialize(abstractSerializedData, i, z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.peer.serializeToStream(abstractSerializedData);
        this.settings.serializeToStream(abstractSerializedData);
    }
}
