package org.telegram.tgnet;

public class TLRPC$TL_inputPaymentCredentialsGooglePay extends TLRPC$InputPaymentCredentials {
    public static int constructor = -1966921727;

    @Override // org.telegram.tgnet.TLObject
    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
        this.payment_token = TLRPC$TL_dataJSON.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
    }

    @Override // org.telegram.tgnet.TLObject
    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
        abstractSerializedData.writeInt32(constructor);
        this.payment_token.serializeToStream(abstractSerializedData);
    }
}
