package org.telegram.tgnet;

public abstract class TLRPC$EncryptedMessage extends TLObject {
    public byte[] bytes;
    public int chat_id;
    public int date;
    public TLRPC$EncryptedFile file;
    public long random_id;

    public static TLRPC$EncryptedMessage TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$EncryptedMessage tLRPC$EncryptedMessage;
        if (i != -317144808) {
            tLRPC$EncryptedMessage = i != 594758406 ? null : new TLRPC$TL_encryptedMessageService();
        } else {
            tLRPC$EncryptedMessage = new TLRPC$TL_encryptedMessage();
        }
        if (tLRPC$EncryptedMessage != null || !z) {
            if (tLRPC$EncryptedMessage != null) {
                tLRPC$EncryptedMessage.readParams(abstractSerializedData, z);
            }
            return tLRPC$EncryptedMessage;
        }
        throw new RuntimeException(String.format("can't parse magic %x in EncryptedMessage", Integer.valueOf(i)));
    }
}
