package org.telegram.tgnet;

import java.util.ArrayList;

public class TLRPC$TL_contacts_importedContacts extends TLObject {
    public static int constructor = 2010127419;
    public ArrayList<TLRPC$TL_importedContact> imported = new ArrayList<>();
    public ArrayList<TLRPC$TL_popularContact> popular_invites = new ArrayList<>();
    public ArrayList<Long> retry_contacts = new ArrayList<>();
    public ArrayList<TLRPC$User> users = new ArrayList<>();

    public static TLRPC$TL_contacts_importedContacts TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        if (constructor == i) {
            TLRPC$TL_contacts_importedContacts tLRPC$TL_contacts_importedContacts = new TLRPC$TL_contacts_importedContacts();
            tLRPC$TL_contacts_importedContacts.readParams(abstractSerializedData, z);
            return tLRPC$TL_contacts_importedContacts;
        } else if (!z) {
            return null;
        } else {
            throw new RuntimeException(String.format("can't parse magic %x in TL_contacts_importedContacts", Integer.valueOf(i)));
        }
    }

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        int readInt32 = abstractSerializedData.readInt32(z);
        if (readInt32 == 481674261) {
            int readInt322 = abstractSerializedData.readInt32(z);
            for (int i = 0; i < readInt322; i++) {
                TLRPC$TL_importedContact TLdeserialize = TLRPC$TL_importedContact.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                if (TLdeserialize != null) {
                    this.imported.add(TLdeserialize);
                } else {
                    return;
                }
            }
            int readInt323 = abstractSerializedData.readInt32(z);
            if (readInt323 == 481674261) {
                int readInt324 = abstractSerializedData.readInt32(z);
                for (int i2 = 0; i2 < readInt324; i2++) {
                    TLRPC$TL_popularContact TLdeserialize2 = TLRPC$TL_popularContact.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                    if (TLdeserialize2 != null) {
                        this.popular_invites.add(TLdeserialize2);
                    } else {
                        return;
                    }
                }
                int readInt325 = abstractSerializedData.readInt32(z);
                if (readInt325 == 481674261) {
                    int readInt326 = abstractSerializedData.readInt32(z);
                    for (int i3 = 0; i3 < readInt326; i3++) {
                        this.retry_contacts.add(Long.valueOf(abstractSerializedData.readInt64(z)));
                    }
                    int readInt327 = abstractSerializedData.readInt32(z);
                    if (readInt327 == 481674261) {
                        int readInt328 = abstractSerializedData.readInt32(z);
                        for (int i4 = 0; i4 < readInt328; i4++) {
                            TLRPC$User TLdeserialize3 = TLRPC$User.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                            if (TLdeserialize3 != null) {
                                this.users.add(TLdeserialize3);
                            } else {
                                return;
                            }
                        }
                    } else if (z) {
                        throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(readInt327)));
                    }
                } else if (z) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(readInt325)));
                }
            } else if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(readInt323)));
            }
        } else if (z) {
            throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(readInt32)));
        }
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        abstractSerializedData.writeInt32(481674261);
        int size = this.imported.size();
        abstractSerializedData.writeInt32(size);
        for (int i = 0; i < size; i++) {
            this.imported.get(i).serializeToStream(abstractSerializedData);
        }
        abstractSerializedData.writeInt32(481674261);
        int size2 = this.popular_invites.size();
        abstractSerializedData.writeInt32(size2);
        for (int i2 = 0; i2 < size2; i2++) {
            this.popular_invites.get(i2).serializeToStream(abstractSerializedData);
        }
        abstractSerializedData.writeInt32(481674261);
        int size3 = this.retry_contacts.size();
        abstractSerializedData.writeInt32(size3);
        for (int i3 = 0; i3 < size3; i3++) {
            abstractSerializedData.writeInt64(this.retry_contacts.get(i3).longValue());
        }
        abstractSerializedData.writeInt32(481674261);
        int size4 = this.users.size();
        abstractSerializedData.writeInt32(size4);
        for (int i4 = 0; i4 < size4; i4++) {
            this.users.get(i4).serializeToStream(abstractSerializedData);
        }
    }
}
