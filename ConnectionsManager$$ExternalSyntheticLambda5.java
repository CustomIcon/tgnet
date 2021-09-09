package org.telegram.tgnet;

public final /* synthetic */ class ConnectionsManager$$ExternalSyntheticLambda5 implements Runnable {
    public final /* synthetic */ int f$0;
    public final /* synthetic */ TLObject f$1;

    public /* synthetic */ ConnectionsManager$$ExternalSyntheticLambda5(int i, TLObject tLObject) {
        this.f$0 = i;
        this.f$1 = tLObject;
    }

    public final void run() {
        ConnectionsManager.lambda$onUnparsedMessageReceived$3(this.f$0, this.f$1);
    }
}
