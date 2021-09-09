package org.telegram.tgnet;

import java.util.ArrayList;

public abstract class TLRPC$BotInfo extends TLObject {
    public ArrayList<TLRPC$TL_botCommand> commands = new ArrayList<>();
    public String description;
    public int user_id;
    public int version;

    public static TLRPC$BotInfo TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$BotInfo tLRPC$BotInfo;
        if (i == -1729618630) {
            tLRPC$BotInfo = new TLRPC$TL_botInfo();
        } else if (i != -1154598962) {
            tLRPC$BotInfo = i != 164583517 ? null : new TLRPC$TL_botInfo_layer48();
        } else {
            tLRPC$BotInfo = new TLRPC$TL_botInfoEmpty_layer48();
        }
        if (tLRPC$BotInfo != null || !z) {
            if (tLRPC$BotInfo != null) {
                tLRPC$BotInfo.readParams(abstractSerializedData, z);
            }
            return tLRPC$BotInfo;
        }
        throw new RuntimeException(String.format("can't parse magic %x in BotInfo", Integer.valueOf(i)));
    }
}
