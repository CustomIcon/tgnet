package org.telegram.tgnet;

public class TLObject {
    private static final ThreadLocal<NativeByteBuffer> sizeCalculator = new ThreadLocal<NativeByteBuffer>() {
        /* class org.telegram.tgnet.TLObject.AnonymousClass1 */

        /* access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public NativeByteBuffer initialValue() {
            return new NativeByteBuffer(true);
        }
    };
    public boolean disableFree = false;
    public int networkType;

    public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        return null;
    }

    public void freeResources() {
    }

    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
    }

    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
    }

    public int getObjectSize() {
        ThreadLocal<NativeByteBuffer> threadLocal = sizeCalculator;
        NativeByteBuffer nativeByteBuffer = threadLocal.get();
        nativeByteBuffer.rewind();
        serializeToStream(threadLocal.get());
        return nativeByteBuffer.length();
    }
}
