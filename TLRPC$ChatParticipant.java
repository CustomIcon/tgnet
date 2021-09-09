package org.telegram.tgnet;

public abstract class TLRPC$ChatParticipant extends TLObject {
    public int date;
    public int inviter_id;
    public int user_id;

    public static TLRPC$ChatParticipant TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$ChatParticipant tLRPC$ChatParticipant;
        if (i == -925415106) {
            tLRPC$ChatParticipant = new TLRPC$TL_chatParticipant();
        } else if (i != -636267638) {
            tLRPC$ChatParticipant = i != -489233354 ? null : new TLRPC$TL_chatParticipantAdmin();
        } else {
            tLRPC$ChatParticipant = new TLRPC$TL_chatParticipantCreator();
        }
        if (tLRPC$ChatParticipant != null || !z) {
            if (tLRPC$ChatParticipant != null) {
                tLRPC$ChatParticipant.readParams(abstractSerializedData, z);
            }
            return tLRPC$ChatParticipant;
        }
        throw new RuntimeException(String.format("can't parse magic %x in ChatParticipant", Integer.valueOf(i)));
    }
}
