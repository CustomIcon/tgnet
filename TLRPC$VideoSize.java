package org.telegram.tgnet;

import android.text.TextUtils;

public abstract class TLRPC$VideoSize extends TLObject {
    public int flags;
    public int h;
    public TLRPC$FileLocation location;
    public int size;
    public String type;
    public double video_start_ts;
    public int w;

    public static TLRPC$VideoSize TLdeserialize(long j, long j2, AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$VideoSize tLRPC$VideoSize;
        if (i == -567037804) {
            tLRPC$VideoSize = new TLRPC$TL_videoSize();
        } else if (i != -399391402) {
            tLRPC$VideoSize = i != 1130084743 ? null : new TLRPC$TL_videoSize_layer115();
        } else {
            tLRPC$VideoSize = new TLRPC$TL_videoSize_layer127();
        }
        if (tLRPC$VideoSize != null || !z) {
            if (tLRPC$VideoSize != null) {
                tLRPC$VideoSize.readParams(abstractSerializedData, z);
                if (tLRPC$VideoSize.location == null) {
                    if (TextUtils.isEmpty(tLRPC$VideoSize.type) || (j == 0 && j2 == 0)) {
                        tLRPC$VideoSize.location = new TLRPC$TL_fileLocationUnavailable();
                    } else {
                        TLRPC$TL_fileLocationToBeDeprecated tLRPC$TL_fileLocationToBeDeprecated = new TLRPC$TL_fileLocationToBeDeprecated();
                        tLRPC$VideoSize.location = tLRPC$TL_fileLocationToBeDeprecated;
                        if (j != 0) {
                            tLRPC$TL_fileLocationToBeDeprecated.volume_id = -j;
                            tLRPC$TL_fileLocationToBeDeprecated.local_id = tLRPC$VideoSize.type.charAt(0);
                        } else {
                            tLRPC$TL_fileLocationToBeDeprecated.volume_id = -j2;
                            tLRPC$TL_fileLocationToBeDeprecated.local_id = tLRPC$VideoSize.type.charAt(0) + 1000;
                        }
                    }
                }
            }
            return tLRPC$VideoSize;
        }
        throw new RuntimeException(String.format("can't parse magic %x in VideoSize", Integer.valueOf(i)));
    }
}
