package org.telegram.tgnet;

public abstract class TLRPC$ExportedChatInvite extends TLObject {
    public static TLRPC$ExportedChatInvite TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$ExportedChatInvite tLRPC$ExportedChatInvite;
        if (i == -64092740) {
            tLRPC$ExportedChatInvite = new TLRPC$TL_chatInviteExported_layer122();
        } else if (i != 1776236393) {
            tLRPC$ExportedChatInvite = i != 1847917725 ? null : new TLRPC$TL_chatInviteExported();
        } else {
            tLRPC$ExportedChatInvite = new TLRPC$TL_chatInviteEmpty_layer122();
        }
        if (tLRPC$ExportedChatInvite != null || !z) {
            if (tLRPC$ExportedChatInvite != null) {
                tLRPC$ExportedChatInvite.readParams(abstractSerializedData, z);
            }
            return tLRPC$ExportedChatInvite;
        }
        throw new RuntimeException(String.format("can't parse magic %x in ExportedChatInvite", Integer.valueOf(i)));
    }
}
