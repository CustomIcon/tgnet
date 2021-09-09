package org.telegram.tgnet;

public class TLRPC$TL_peerNotifySettingsEmpty_layer77 extends TLRPC$PeerNotifySettings {
    public static int constructor = 1889961234;

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
    }
}
