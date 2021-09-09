package org.telegram.tgnet;

public abstract class TLRPC$InputChannel extends TLObject {
    public long access_hash;
    public int channel_id;

    public static TLRPC$InputChannel TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$InputChannel tLRPC$InputChannel;
        if (i == -1343524562) {
            tLRPC$InputChannel = new TLRPC$TL_inputChannel();
        } else if (i != -292807034) {
            tLRPC$InputChannel = i != 707290417 ? null : new TLRPC$TL_inputChannelFromMessage();
        } else {
            tLRPC$InputChannel = new TLRPC$TL_inputChannelEmpty();
        }
        if (tLRPC$InputChannel != null || !z) {
            if (tLRPC$InputChannel != null) {
                tLRPC$InputChannel.readParams(abstractSerializedData, z);
            }
            return tLRPC$InputChannel;
        }
        throw new RuntimeException(String.format("can't parse magic %x in InputChannel", Integer.valueOf(i)));
    }
}
