package org.telegram.tgnet;

import java.util.ArrayList;

public abstract class TLRPC$Poll extends TLObject {
    public ArrayList<TLRPC$TL_pollAnswer> answers = new ArrayList<>();
    public int close_date;
    public int close_period;
    public boolean closed;
    public int flags;
    public long id;
    public boolean multiple_choice;
    public boolean public_voters;
    public String question;
    public boolean quiz;

    public static TLRPC$Poll TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$Poll tLRPC$Poll;
        if (i == -2032041631) {
            tLRPC$Poll = new TLRPC$TL_poll();
        } else if (i != -1351325818) {
            tLRPC$Poll = i != -716006138 ? null : new TLRPC$TL_poll_layer111();
        } else {
            tLRPC$Poll = new TLRPC$TL_poll_toDelete();
        }
        if (tLRPC$Poll != null || !z) {
            if (tLRPC$Poll != null) {
                tLRPC$Poll.readParams(abstractSerializedData, z);
            }
            return tLRPC$Poll;
        }
        throw new RuntimeException(String.format("can't parse magic %x in Poll", Integer.valueOf(i)));
    }
}
