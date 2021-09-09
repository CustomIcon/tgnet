package org.telegram.tgnet;

public class TLRPC$TL_updateNotifySettings extends TLRPC$Update {
    public static int constructor = -1094555409;
    public TLRPC$PeerNotifySettings notify_settings;
    public TLRPC$NotifyPeer peer;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.peer = TLRPC$NotifyPeer.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
        this.notify_settings = TLRPC$PeerNotifySettings.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.peer.serializeToStream(abstractSerializedData);
        this.notify_settings.serializeToStream(abstractSerializedData);
    }
}
