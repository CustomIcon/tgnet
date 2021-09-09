package org.telegram.tgnet;

public abstract class TLRPC$EncryptedFile extends TLObject {
    public long access_hash;
    public int dc_id;
    public long id;
    public int key_fingerprint;
    public int size;

    public static TLRPC$EncryptedFile TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$EncryptedFile tLRPC$EncryptedFile;
        if (i != -1038136962) {
            tLRPC$EncryptedFile = i != 1248893260 ? null : new TLRPC$TL_encryptedFile();
        } else {
            tLRPC$EncryptedFile = new TLRPC$TL_encryptedFileEmpty();
        }
        if (tLRPC$EncryptedFile != null || !z) {
            if (tLRPC$EncryptedFile != null) {
                tLRPC$EncryptedFile.readParams(abstractSerializedData, z);
            }
            return tLRPC$EncryptedFile;
        }
        throw new RuntimeException(String.format("can't parse magic %x in EncryptedFile", Integer.valueOf(i)));
    }
}
