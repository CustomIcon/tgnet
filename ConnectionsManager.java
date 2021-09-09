package org.telegram.tgnet;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.File;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.telegram.messenger.AccountInstance;
import org.telegram.messenger.AndroidUtilities;
import org.telegram.messenger.ApplicationLoader;
import org.telegram.messenger.BaseController;
import org.telegram.messenger.BuildVars;
import org.telegram.messenger.EmuDetector;
import org.telegram.messenger.FileLog;
import org.telegram.messenger.KeepAliveJob;
import org.telegram.messenger.LocaleController;
import org.telegram.messenger.MessagesController;
import org.telegram.messenger.NotificationCenter;
import org.telegram.messenger.SharedConfig;
import org.telegram.messenger.StatsController;
import org.telegram.messenger.UserConfig;
import org.telegram.messenger.Utilities;

public class ConnectionsManager extends BaseController {
    private static final int CORE_POOL_SIZE;
    public static final int CPU_COUNT;
    public static final int ConnectionStateConnected = 3;
    public static final int ConnectionStateConnecting = 1;
    public static final int ConnectionStateConnectingToProxy = 4;
    public static final int ConnectionStateUpdating = 5;
    public static final int ConnectionStateWaitingForNetwork = 2;
    public static final int ConnectionTypeDownload = 2;
    public static final int ConnectionTypeDownload2 = 65538;
    public static final int ConnectionTypeGeneric = 1;
    public static final int ConnectionTypePush = 8;
    public static final int ConnectionTypeUpload = 4;
    public static final int DEFAULT_DATACENTER_ID = Integer.MAX_VALUE;
    public static final Executor DNS_THREAD_POOL_EXECUTOR;
    public static final int FileTypeAudio = 50331648;
    public static final int FileTypeFile = 67108864;
    public static final int FileTypePhoto = 16777216;
    public static final int FileTypeVideo = 33554432;
    private static volatile ConnectionsManager[] Instance = new ConnectionsManager[3];
    private static final int KEEP_ALIVE_SECONDS = 30;
    private static final int MAXIMUM_POOL_SIZE;
    public static final int RequestFlagCanCompress = 4;
    public static final int RequestFlagEnableUnauthorized = 1;
    public static final int RequestFlagFailOnServerErrors = 2;
    public static final int RequestFlagForceDownload = 32;
    public static final int RequestFlagInvokeAfter = 64;
    public static final int RequestFlagNeedQuickAck = 128;
    public static final int RequestFlagTryDifferentDc = 16;
    public static final int RequestFlagWithoutLogin = 8;
    public static final byte USE_IPV4_IPV6_RANDOM = 2;
    public static final byte USE_IPV4_ONLY = 0;
    public static final byte USE_IPV6_ONLY = 1;
    private static AsyncTask currentTask;
    private static HashMap<String, ResolvedDomain> dnsCache = new HashMap<>();
    private static int lastClassGuid = 1;
    private static long lastDnsRequestTime;
    private static HashMap<String, ResolveHostByNameTask> resolvingHostnameTasks = new HashMap<>();
    private static final BlockingQueue<Runnable> sPoolWorkQueue;
    private static final ThreadFactory sThreadFactory;
    private boolean appPaused = true;
    private int appResumeCount;
    private int connectionState = native_getConnectionState(this.currentAccount);
    private boolean isUpdating;
    private long lastPauseTime = System.currentTimeMillis();
    private AtomicInteger lastRequestToken = new AtomicInteger(1);

    public static native void native_applyDatacenterAddress(int i, int i2, String str, int i3);

    public static native void native_applyDnsConfig(int i, long j, String str, int i2);

    public static native void native_bindRequestToGuid(int i, int i2, int i3);

    public static native void native_cancelRequest(int i, int i2, boolean z);

    public static native void native_cancelRequestsForGuid(int i, int i2);

    public static native long native_checkProxy(int i, String str, int i2, String str2, String str3, String str4, RequestTimeDelegate requestTimeDelegate);

    public static native void native_cleanUp(int i, boolean z);

    public static native int native_getConnectionState(int i);

    public static native int native_getCurrentDatacenterId(int i);

    public static native int native_getCurrentTime(int i);

    public static native long native_getCurrentTimeMillis(int i);

    public static native int native_getTimeDifference(int i);

    public static native void native_init(int i, int i2, int i3, int i4, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i5, int i6, boolean z, boolean z2, int i7);

    public static native int native_isTestBackend(int i);

    public static native void native_onHostNameResolved(String str, long j, String str2);

    public static native void native_pauseNetwork(int i);

    public static native void native_resumeNetwork(int i, boolean z);

    public static native void native_seSystemLangCode(int i, String str);

    public static native void native_sendRequest(int i, long j, RequestDelegateInternal requestDelegateInternal, QuickAckDelegate quickAckDelegate, WriteToSocketDelegate writeToSocketDelegate, int i2, int i3, int i4, boolean z, int i5);

    public static native void native_setIpStrategy(int i, byte b);

    public static native void native_setJava(boolean z);

    public static native void native_setLangCode(int i, String str);

    public static native void native_setNetworkAvailable(int i, boolean z, int i2, boolean z2);

    public static native void native_setProxySettings(int i, String str, int i2, String str2, String str3, String str4);

    public static native void native_setPushConnectionEnabled(int i, boolean z);

    public static native void native_setRegId(int i, String str);

    public static native void native_setSystemLangCode(int i, String str);

    public static native void native_setUserId(int i, int i2);

    public static native void native_switchBackend(int i, boolean z);

    public static native void native_updateDcSettings(int i);

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = availableProcessors;
        int max = Math.max(2, Math.min(availableProcessors - 1, 4));
        CORE_POOL_SIZE = max;
        int i = (availableProcessors * 2) + 1;
        MAXIMUM_POOL_SIZE = i;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(128);
        sPoolWorkQueue = linkedBlockingQueue;
        AnonymousClass1 r10 = new ThreadFactory() {
            /* class org.telegram.tgnet.ConnectionsManager.AnonymousClass1 */
            private final AtomicInteger mCount = new AtomicInteger(1);

            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "DnsAsyncTask #" + this.mCount.getAndIncrement());
            }
        };
        sThreadFactory = r10;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(max, i, 30, TimeUnit.SECONDS, linkedBlockingQueue, r10);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        DNS_THREAD_POOL_EXECUTOR = threadPoolExecutor;
    }

    /* access modifiers changed from: private */
    public static class ResolvedDomain {
        public ArrayList<String> addresses;
        long ttl;

        public ResolvedDomain(ArrayList<String> arrayList, long j) {
            this.addresses = arrayList;
            this.ttl = j;
        }

        public String getAddress() {
            ArrayList<String> arrayList = this.addresses;
            return arrayList.get(Utilities.random.nextInt(arrayList.size()));
        }
    }

    public static ConnectionsManager getInstance(int i) {
        ConnectionsManager connectionsManager = Instance[i];
        if (connectionsManager == null) {
            synchronized (ConnectionsManager.class) {
                connectionsManager = Instance[i];
                if (connectionsManager == null) {
                    ConnectionsManager[] connectionsManagerArr = Instance;
                    ConnectionsManager connectionsManager2 = new ConnectionsManager(i);
                    connectionsManagerArr[i] = connectionsManager2;
                    connectionsManager = connectionsManager2;
                }
            }
        }
        return connectionsManager;
    }

    public ConnectionsManager(int i) {
        super(i);
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        File filesDirFixed = ApplicationLoader.getFilesDirFixed();
        if (i != 0) {
            File file = new File(filesDirFixed, "account" + i);
            file.mkdirs();
            filesDirFixed = file;
        }
        String file2 = filesDirFixed.toString();
        boolean isPushConnectionEnabled = isPushConnectionEnabled();
        try {
            str5 = LocaleController.getSystemLocaleStringIso639().toLowerCase();
            String lowerCase = LocaleController.getLocaleStringIso639().toLowerCase();
            str3 = Build.MANUFACTURER + Build.MODEL;
            PackageInfo packageInfo = ApplicationLoader.applicationContext.getPackageManager().getPackageInfo(ApplicationLoader.applicationContext.getPackageName(), 0);
            str2 = packageInfo.versionName + " (" + packageInfo.versionCode + ")";
            if (BuildVars.DEBUG_PRIVATE_VERSION) {
                str2 = str2 + " pbeta";
            } else if (BuildVars.DEBUG_VERSION) {
                str2 = str2 + " beta";
            }
            str4 = "SDK " + Build.VERSION.SDK_INT;
            str = lowerCase;
        } catch (Exception unused) {
            str4 = "SDK " + Build.VERSION.SDK_INT;
            str = "";
            str2 = "App version unknown";
            str3 = "Android unknown";
            str5 = "en";
        }
        if (str5.trim().length() == 0) {
            str6 = "en";
        } else {
            str6 = str5;
        }
        if (str3.trim().length() == 0) {
            str7 = "Android unknown";
        } else {
            str7 = str3;
        }
        if (str2.trim().length() == 0) {
            str8 = "App version unknown";
        } else {
            str8 = str2;
        }
        String str9 = str4.trim().length() == 0 ? "SDK Unknown" : str4;
        getUserConfig().loadConfig();
        init(BuildVars.BUILD_VERSION, 132, BuildVars.APP_ID, str7, str9, str8, str, str6, file2, FileLog.getNetworkLogPath(), getRegId(), AndroidUtilities.getCertificateSHA256Fingerprint(), (TimeZone.getDefault().getRawOffset() + TimeZone.getDefault().getDSTSavings()) / 1000, getUserConfig().getClientUserId(), isPushConnectionEnabled);
    }

    private String getRegId() {
        String str = SharedConfig.pushString;
        if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(SharedConfig.pushStringStatus)) {
            str = SharedConfig.pushStringStatus;
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String str2 = "__FIREBASE_GENERATING_SINCE_" + getCurrentTime() + "__";
        SharedConfig.pushStringStatus = str2;
        return str2;
    }

    public boolean isPushConnectionEnabled() {
        SharedPreferences globalNotificationsSettings = MessagesController.getGlobalNotificationsSettings();
        if (globalNotificationsSettings.contains("pushConnection")) {
            return globalNotificationsSettings.getBoolean("pushConnection", true);
        }
        return MessagesController.getMainSettings(UserConfig.selectedAccount).getBoolean("backgroundConnection", false);
    }

    public long getCurrentTimeMillis() {
        return native_getCurrentTimeMillis(this.currentAccount);
    }

    public int getCurrentTime() {
        return native_getCurrentTime(this.currentAccount);
    }

    public int getCurrentDatacenterId() {
        return native_getCurrentDatacenterId(this.currentAccount);
    }

    public int getTimeDifference() {
        return native_getTimeDifference(this.currentAccount);
    }

    public int sendRequest(TLObject tLObject, RequestDelegate requestDelegate) {
        return sendRequest(tLObject, requestDelegate, (QuickAckDelegate) null, 0);
    }

    public int sendRequest(TLObject tLObject, RequestDelegate requestDelegate, int i) {
        return sendRequest(tLObject, requestDelegate, null, null, null, i, DEFAULT_DATACENTER_ID, 1, true);
    }

    public int sendRequest(TLObject tLObject, RequestDelegate requestDelegate, int i, int i2) {
        return sendRequest(tLObject, requestDelegate, null, null, null, i, DEFAULT_DATACENTER_ID, i2, true);
    }

    public int sendRequest(TLObject tLObject, RequestDelegateTimestamp requestDelegateTimestamp, int i, int i2, int i3) {
        return sendRequest(tLObject, null, requestDelegateTimestamp, null, null, i, i3, i2, true);
    }

    public int sendRequest(TLObject tLObject, RequestDelegate requestDelegate, QuickAckDelegate quickAckDelegate, int i) {
        return sendRequest(tLObject, requestDelegate, null, quickAckDelegate, null, i, DEFAULT_DATACENTER_ID, 1, true);
    }

    public int sendRequest(TLObject tLObject, RequestDelegate requestDelegate, QuickAckDelegate quickAckDelegate, WriteToSocketDelegate writeToSocketDelegate, int i, int i2, int i3, boolean z) {
        return sendRequest(tLObject, requestDelegate, null, quickAckDelegate, writeToSocketDelegate, i, i2, i3, z);
    }

    public int sendRequest(TLObject tLObject, RequestDelegate requestDelegate, RequestDelegateTimestamp requestDelegateTimestamp, QuickAckDelegate quickAckDelegate, WriteToSocketDelegate writeToSocketDelegate, int i, int i2, int i3, boolean z) {
        int andIncrement = this.lastRequestToken.getAndIncrement();
        Utilities.stageQueue.postRunnable(new ConnectionsManager$$ExternalSyntheticLambda9(this, tLObject, andIncrement, requestDelegate, requestDelegateTimestamp, quickAckDelegate, writeToSocketDelegate, i, i2, i3, z));
        return andIncrement;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$sendRequest$2(TLObject tLObject, int i, RequestDelegate requestDelegate, RequestDelegateTimestamp requestDelegateTimestamp, QuickAckDelegate quickAckDelegate, WriteToSocketDelegate writeToSocketDelegate, int i2, int i3, int i4, boolean z) {
        Exception e;
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("send request " + tLObject + " with token = " + i);
        }
        try {
            NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(tLObject.getObjectSize());
            tLObject.serializeToStream(nativeByteBuffer);
            tLObject.freeResources();
            try {
                native_sendRequest(this.currentAccount, nativeByteBuffer.address, new ConnectionsManager$$ExternalSyntheticLambda13(tLObject, requestDelegate, requestDelegateTimestamp), quickAckDelegate, writeToSocketDelegate, i2, i3, i4, z, i);
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            FileLog.e(e);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$sendRequest$1(TLObject tLObject, RequestDelegate requestDelegate, RequestDelegateTimestamp requestDelegateTimestamp, long j, int i, String str, int i2, long j2) {
        TLRPC$TL_error tLRPC$TL_error;
        TLObject tLObject2;
        if (j != 0) {
            try {
                NativeByteBuffer wrap = NativeByteBuffer.wrap(j);
                wrap.reused = true;
                tLObject2 = tLObject.deserializeResponse(wrap, wrap.readInt32(true), true);
                tLRPC$TL_error = null;
            } catch (Exception e) {
                FileLog.e(e);
                return;
            }
        } else if (str != null) {
            TLRPC$TL_error tLRPC$TL_error2 = new TLRPC$TL_error();
            tLRPC$TL_error2.code = i;
            tLRPC$TL_error2.text = str;
            if (BuildVars.LOGS_ENABLED) {
                FileLog.e(tLObject + " got error " + tLRPC$TL_error2.code + " " + tLRPC$TL_error2.text);
            }
            tLRPC$TL_error = tLRPC$TL_error2;
            tLObject2 = null;
        } else {
            tLObject2 = null;
            tLRPC$TL_error = null;
        }
        if (tLObject2 != null) {
            tLObject2.networkType = i2;
        }
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("java received " + tLObject2 + " error = " + tLRPC$TL_error);
        }
        Utilities.stageQueue.postRunnable(new ConnectionsManager$$ExternalSyntheticLambda11(requestDelegate, tLObject2, tLRPC$TL_error, requestDelegateTimestamp, j2));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$sendRequest$0(RequestDelegate requestDelegate, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error, RequestDelegateTimestamp requestDelegateTimestamp, long j) {
        if (requestDelegate != null) {
            requestDelegate.run(tLObject, tLRPC$TL_error);
        } else if (requestDelegateTimestamp != null) {
            requestDelegateTimestamp.run(tLObject, tLRPC$TL_error, j);
        }
        if (tLObject != null) {
            tLObject.freeResources();
        }
    }

    public void cancelRequest(int i, boolean z) {
        native_cancelRequest(this.currentAccount, i, z);
    }

    public void cleanup(boolean z) {
        native_cleanUp(this.currentAccount, z);
    }

    public void cancelRequestsForGuid(int i) {
        native_cancelRequestsForGuid(this.currentAccount, i);
    }

    public void bindRequestToGuid(int i, int i2) {
        native_bindRequestToGuid(this.currentAccount, i, i2);
    }

    public void applyDatacenterAddress(int i, String str, int i2) {
        native_applyDatacenterAddress(this.currentAccount, i, str, i2);
    }

    public int getConnectionState() {
        int i = this.connectionState;
        if (i != 3 || !this.isUpdating) {
            return i;
        }
        return 5;
    }

    public void setUserId(int i) {
        native_setUserId(this.currentAccount, i);
    }

    public void checkConnection() {
        native_setIpStrategy(this.currentAccount, getIpStrategy());
        native_setNetworkAvailable(this.currentAccount, ApplicationLoader.isNetworkOnline(), ApplicationLoader.getCurrentNetworkType(), ApplicationLoader.isConnectionSlow());
    }

    public void setPushConnectionEnabled(boolean z) {
        native_setPushConnectionEnabled(this.currentAccount, z);
    }

    public void init(int i, int i2, int i3, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i4, int i5, boolean z) {
        String str10;
        String str11;
        String str12;
        String str13;
        SharedPreferences sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences("mainconfig", 0);
        String string = sharedPreferences.getString("proxy_ip", "");
        String string2 = sharedPreferences.getString("proxy_user", "");
        String string3 = sharedPreferences.getString("proxy_pass", "");
        String string4 = sharedPreferences.getString("proxy_secret", "");
        int i6 = sharedPreferences.getInt("proxy_port", 1080);
        if (sharedPreferences.getBoolean("proxy_enabled", false) && !TextUtils.isEmpty(string)) {
            native_setProxySettings(this.currentAccount, string, i6, string2, string3, string4);
        }
        try {
            str10 = ApplicationLoader.applicationContext.getPackageManager().getInstallerPackageName(ApplicationLoader.applicationContext.getPackageName());
        } catch (Throwable unused) {
            str10 = "";
        }
        if (str10 == null) {
            str11 = "";
        } else {
            str11 = str10;
        }
        try {
            str12 = ApplicationLoader.applicationContext.getPackageName();
        } catch (Throwable unused2) {
            str12 = "";
        }
        if (str12 == null) {
            str13 = "";
        } else {
            str13 = str12;
        }
        native_init(this.currentAccount, i, i2, i3, str, str2, str3, str4, str5, str6, str7, str8, str9, str11, str13, i4, i5, z, ApplicationLoader.isNetworkOnline(), ApplicationLoader.getCurrentNetworkType());
        checkConnection();
    }

    public static void setLangCode(String str) {
        String lowerCase = str.replace('_', '-').toLowerCase();
        for (int i = 0; i < 3; i++) {
            native_setLangCode(i, lowerCase);
        }
    }

    public static void setRegId(String str, String str2) {
        if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            str = str2;
        }
        if (TextUtils.isEmpty(str)) {
            str = "__FIREBASE_GENERATING_SINCE_" + getInstance(0).getCurrentTime() + "__";
            SharedConfig.pushStringStatus = str;
        }
        for (int i = 0; i < 3; i++) {
            native_setRegId(i, str);
        }
    }

    public static void setSystemLangCode(String str) {
        String lowerCase = str.replace('_', '-').toLowerCase();
        for (int i = 0; i < 3; i++) {
            native_setSystemLangCode(i, lowerCase);
        }
    }

    public void switchBackend(boolean z) {
        MessagesController.getGlobalMainSettings().edit().remove("language_showed2").commit();
        native_switchBackend(this.currentAccount, z);
    }

    public boolean isTestBackend() {
        return native_isTestBackend(this.currentAccount) != 0;
    }

    public void resumeNetworkMaybe() {
        native_resumeNetwork(this.currentAccount, true);
    }

    public void updateDcSettings() {
        native_updateDcSettings(this.currentAccount);
    }

    public long getPauseTime() {
        return this.lastPauseTime;
    }

    public long checkProxy(String str, int i, String str2, String str3, String str4, RequestTimeDelegate requestTimeDelegate) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return native_checkProxy(this.currentAccount, str == null ? "" : str, i, str2 == null ? "" : str2, str3 == null ? "" : str3, str4 == null ? "" : str4, requestTimeDelegate);
    }

    public void setAppPaused(boolean z, boolean z2) {
        if (!z2) {
            this.appPaused = z;
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("app paused = " + z);
            }
            if (z) {
                this.appResumeCount--;
            } else {
                this.appResumeCount++;
            }
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("app resume count " + this.appResumeCount);
            }
            if (this.appResumeCount < 0) {
                this.appResumeCount = 0;
            }
        }
        if (this.appResumeCount == 0) {
            if (this.lastPauseTime == 0) {
                this.lastPauseTime = System.currentTimeMillis();
            }
            native_pauseNetwork(this.currentAccount);
        } else if (!this.appPaused) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("reset app pause time");
            }
            if (this.lastPauseTime != 0 && System.currentTimeMillis() - this.lastPauseTime > 5000) {
                getContactsController().checkContacts();
            }
            this.lastPauseTime = 0;
            native_resumeNetwork(this.currentAccount, false);
        }
    }

    public static void onUnparsedMessageReceived(long j, int i) {
        try {
            NativeByteBuffer wrap = NativeByteBuffer.wrap(j);
            wrap.reused = true;
            int readInt32 = wrap.readInt32(true);
            TLObject TLdeserialize = TLClassStore.Instance().TLdeserialize(wrap, readInt32, true);
            if (TLdeserialize instanceof TLRPC$Updates) {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("java received " + TLdeserialize);
                }
                KeepAliveJob.finishJob();
                Utilities.stageQueue.postRunnable(new ConnectionsManager$$ExternalSyntheticLambda5(i, TLdeserialize));
            } else if (BuildVars.LOGS_ENABLED) {
                FileLog.d(String.format("java received unknown constructor 0x%x", Integer.valueOf(readInt32)));
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onUnparsedMessageReceived$3(int i, TLObject tLObject) {
        AccountInstance.getInstance(i).getMessagesController().processUpdates((TLRPC$Updates) tLObject, false);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onUpdate$4(int i) {
        AccountInstance.getInstance(i).getMessagesController().updateTimerProc();
    }

    public static void onUpdate(int i) {
        Utilities.stageQueue.postRunnable(new ConnectionsManager$$ExternalSyntheticLambda1(i));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onSessionCreated$5(int i) {
        AccountInstance.getInstance(i).getMessagesController().getDifference();
    }

    public static void onSessionCreated(int i) {
        Utilities.stageQueue.postRunnable(new ConnectionsManager$$ExternalSyntheticLambda2(i));
    }

    public static void onConnectionStateChanged(int i, int i2) {
        AndroidUtilities.runOnUIThread(new ConnectionsManager$$ExternalSyntheticLambda3(i2, i));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onConnectionStateChanged$6(int i, int i2) {
        getInstance(i).connectionState = i2;
        AccountInstance.getInstance(i).getNotificationCenter().postNotificationName(NotificationCenter.didUpdateConnectionState, new Object[0]);
    }

    public static void onLogout(int i) {
        AndroidUtilities.runOnUIThread(new ConnectionsManager$$ExternalSyntheticLambda0(i));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onLogout$7(int i) {
        AccountInstance instance = AccountInstance.getInstance(i);
        if (instance.getUserConfig().getClientUserId() != 0) {
            instance.getUserConfig().clearConfig();
            instance.getMessagesController().performLogout(0);
        }
    }

    public static int getInitFlags() {
        if (!EmuDetector.with(ApplicationLoader.applicationContext).detect()) {
            return 0;
        }
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("detected emu");
        }
        return MessagesController.UPDATE_MASK_PHONE;
    }

    public static void onBytesSent(int i, int i2, int i3) {
        try {
            AccountInstance.getInstance(i3).getStatsController().incrementSentBytesCount(i2, 6, (long) i);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public static void onRequestNewServerIpAndPort(int i, int i2) {
        Utilities.globalQueue.postRunnable(new ConnectionsManager$$ExternalSyntheticLambda4(i, i2));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onRequestNewServerIpAndPort$9(int i, int i2) {
        Utilities.stageQueue.postRunnable(new ConnectionsManager$$ExternalSyntheticLambda7(i, ApplicationLoader.isNetworkOnline(), i2));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onRequestNewServerIpAndPort$8(int i, boolean z, int i2) {
        if (currentTask == null && ((i != 0 || Math.abs(lastDnsRequestTime - System.currentTimeMillis()) >= 10000) && z)) {
            lastDnsRequestTime = System.currentTimeMillis();
            if (i == 3) {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("start mozilla txt task");
                }
                MozillaDnsLoadTask mozillaDnsLoadTask = new MozillaDnsLoadTask(i2);
                mozillaDnsLoadTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null, null, null);
                currentTask = mozillaDnsLoadTask;
            } else if (i == 2) {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("start google txt task");
                }
                GoogleDnsLoadTask googleDnsLoadTask = new GoogleDnsLoadTask(i2);
                googleDnsLoadTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null, null, null);
                currentTask = googleDnsLoadTask;
            } else if (i == 1) {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("start dns txt task");
                }
                DnsTxtLoadTask dnsTxtLoadTask = new DnsTxtLoadTask(i2);
                dnsTxtLoadTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null, null, null);
                currentTask = dnsTxtLoadTask;
            } else {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("start firebase task");
                }
                FirebaseTask firebaseTask = new FirebaseTask(i2);
                firebaseTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null, null, null);
                currentTask = firebaseTask;
            }
        } else if (BuildVars.LOGS_ENABLED) {
            FileLog.d("don't start task, current task = " + currentTask + " next task = " + i + " time diff = " + Math.abs(lastDnsRequestTime - System.currentTimeMillis()) + " network = " + ApplicationLoader.isNetworkOnline());
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onProxyError$10() {
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.needShowAlert, 3);
    }

    public static void onProxyError() {
        AndroidUtilities.runOnUIThread(ConnectionsManager$$ExternalSyntheticLambda12.INSTANCE);
    }

    public static void getHostByName(String str, long j) {
        AndroidUtilities.runOnUIThread(new ConnectionsManager$$ExternalSyntheticLambda8(str, j));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$getHostByName$11(String str, long j) {
        ResolvedDomain resolvedDomain = dnsCache.get(str);
        if (resolvedDomain == null || SystemClock.elapsedRealtime() - resolvedDomain.ttl >= 300000) {
            ResolveHostByNameTask resolveHostByNameTask = resolvingHostnameTasks.get(str);
            if (resolveHostByNameTask == null) {
                resolveHostByNameTask = new ResolveHostByNameTask(str);
                try {
                    resolveHostByNameTask.executeOnExecutor(DNS_THREAD_POOL_EXECUTOR, null, null, null);
                    resolvingHostnameTasks.put(str, resolveHostByNameTask);
                } catch (Throwable th) {
                    FileLog.e(th);
                    native_onHostNameResolved(str, j, "");
                    return;
                }
            }
            resolveHostByNameTask.addAddress(j);
            return;
        }
        native_onHostNameResolved(str, j, resolvedDomain.getAddress());
    }

    public static void onBytesReceived(int i, int i2, int i3) {
        try {
            StatsController.getInstance(i3).incrementReceivedBytesCount(i2, 6, (long) i);
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public static void onUpdateConfig(long j, int i) {
        try {
            NativeByteBuffer wrap = NativeByteBuffer.wrap(j);
            wrap.reused = true;
            TLRPC$TL_config TLdeserialize = TLRPC$TL_config.TLdeserialize(wrap, wrap.readInt32(true), true);
            if (TLdeserialize != null) {
                Utilities.stageQueue.postRunnable(new ConnectionsManager$$ExternalSyntheticLambda6(i, TLdeserialize));
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onUpdateConfig$12(int i, TLRPC$TL_config tLRPC$TL_config) {
        AccountInstance.getInstance(i).getMessagesController().updateConfig(tLRPC$TL_config);
    }

    public static void onInternalPushReceived(int i) {
        KeepAliveJob.startJob();
    }

    public static void setProxySettings(boolean z, String str, int i, String str2, String str3, String str4) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        if (str3 == null) {
            str3 = "";
        }
        if (str4 == null) {
            str4 = "";
        }
        for (int i2 = 0; i2 < 3; i2++) {
            if (!z || TextUtils.isEmpty(str)) {
                native_setProxySettings(i2, "", 1080, "", "", "");
            } else {
                native_setProxySettings(i2, str, i, str2, str3, str4);
            }
            AccountInstance instance = AccountInstance.getInstance(i2);
            if (instance.getUserConfig().isClientActivated()) {
                instance.getMessagesController().checkPromoInfo(true);
            }
        }
    }

    public static int generateClassGuid() {
        int i = lastClassGuid;
        lastClassGuid = i + 1;
        return i;
    }

    public void setIsUpdating(boolean z) {
        AndroidUtilities.runOnUIThread(new ConnectionsManager$$ExternalSyntheticLambda10(this, z));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setIsUpdating$13(boolean z) {
        if (this.isUpdating != z) {
            this.isUpdating = z;
            if (this.connectionState == 3) {
                AccountInstance.getInstance(this.currentAccount).getNotificationCenter().postNotificationName(NotificationCenter.didUpdateConnectionState, new Object[0]);
            }
        }
    }

    @SuppressLint({"NewApi"})
    protected static byte getIpStrategy() {
        if (Build.VERSION.SDK_INT < 19) {
            return 0;
        }
        if (BuildVars.LOGS_ENABLED) {
            try {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    NetworkInterface nextElement = networkInterfaces.nextElement();
                    if (nextElement.isUp() && !nextElement.isLoopback()) {
                        if (!nextElement.getInterfaceAddresses().isEmpty()) {
                            if (BuildVars.LOGS_ENABLED) {
                                FileLog.d("valid interface: " + nextElement);
                            }
                            List<InterfaceAddress> interfaceAddresses = nextElement.getInterfaceAddresses();
                            for (int i = 0; i < interfaceAddresses.size(); i++) {
                                InetAddress address = interfaceAddresses.get(i).getAddress();
                                if (BuildVars.LOGS_ENABLED) {
                                    FileLog.d("address: " + address.getHostAddress());
                                }
                                if (!address.isLinkLocalAddress() && !address.isLoopbackAddress()) {
                                    if (!address.isMulticastAddress()) {
                                        if (BuildVars.LOGS_ENABLED) {
                                            FileLog.d("address is good");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                FileLog.e(th);
            }
        }
        try {
            Enumeration<NetworkInterface> networkInterfaces2 = NetworkInterface.getNetworkInterfaces();
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            while (networkInterfaces2.hasMoreElements()) {
                NetworkInterface nextElement2 = networkInterfaces2.nextElement();
                if (nextElement2.isUp()) {
                    if (!nextElement2.isLoopback()) {
                        List<InterfaceAddress> interfaceAddresses2 = nextElement2.getInterfaceAddresses();
                        for (int i2 = 0; i2 < interfaceAddresses2.size(); i2++) {
                            InetAddress address2 = interfaceAddresses2.get(i2).getAddress();
                            if (!address2.isLinkLocalAddress() && !address2.isLoopbackAddress()) {
                                if (!address2.isMulticastAddress()) {
                                    if (address2 instanceof Inet6Address) {
                                        z = true;
                                    } else if (address2 instanceof Inet4Address) {
                                        if (!address2.getHostAddress().startsWith("192.0.0.")) {
                                            z3 = true;
                                        } else {
                                            z2 = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (z) {
                if (z2) {
                    return 2;
                }
                if (!z3) {
                    return 1;
                }
            }
        } catch (Throwable th2) {
            FileLog.e(th2);
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public static class ResolveHostByNameTask extends AsyncTask<Void, Void, ResolvedDomain> {
        private ArrayList<Long> addresses = new ArrayList<>();
        private String currentHostName;

        public ResolveHostByNameTask(String str) {
            this.currentHostName = str;
        }

        public void addAddress(long j) {
            if (!this.addresses.contains(Long.valueOf(j))) {
                this.addresses.add(Long.valueOf(j));
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x00be A[SYNTHETIC, Splitter:B:43:0x00be] */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x00c8 A[SYNTHETIC, Splitter:B:48:0x00c8] */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x00cf A[SYNTHETIC, Splitter:B:52:0x00cf] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public org.telegram.tgnet.ConnectionsManager.ResolvedDomain doInBackground(java.lang.Void... r11) {
            /*
            // Method dump skipped, instructions count: 259
            */
            throw new UnsupportedOperationException("Method not decompiled: org.telegram.tgnet.ConnectionsManager.ResolveHostByNameTask.doInBackground(java.lang.Void[]):org.telegram.tgnet.ConnectionsManager$ResolvedDomain");
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(ResolvedDomain resolvedDomain) {
            int i = 0;
            if (resolvedDomain != null) {
                ConnectionsManager.dnsCache.put(this.currentHostName, resolvedDomain);
                int size = this.addresses.size();
                while (i < size) {
                    ConnectionsManager.native_onHostNameResolved(this.currentHostName, this.addresses.get(i).longValue(), resolvedDomain.getAddress());
                    i++;
                }
            } else {
                int size2 = this.addresses.size();
                while (i < size2) {
                    ConnectionsManager.native_onHostNameResolved(this.currentHostName, this.addresses.get(i).longValue(), "");
                    i++;
                }
            }
            ConnectionsManager.resolvingHostnameTasks.remove(this.currentHostName);
        }
    }

    /* access modifiers changed from: private */
    public static class DnsTxtLoadTask extends AsyncTask<Void, Void, NativeByteBuffer> {
        private int currentAccount;
        private int responseDate;

        public DnsTxtLoadTask(int i) {
            this.currentAccount = i;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x0149 A[SYNTHETIC, Splitter:B:54:0x0149] */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x0153 A[SYNTHETIC, Splitter:B:59:0x0153] */
        /* JADX WARNING: Removed duplicated region for block: B:77:0x0156 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public org.telegram.tgnet.NativeByteBuffer doInBackground(java.lang.Void... r14) {
            /*
            // Method dump skipped, instructions count: 364
            */
            throw new UnsupportedOperationException("Method not decompiled: org.telegram.tgnet.ConnectionsManager.DnsTxtLoadTask.doInBackground(java.lang.Void[]):org.telegram.tgnet.NativeByteBuffer");
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ int lambda$doInBackground$0(String str, String str2) {
            int length = str.length();
            int length2 = str2.length();
            if (length > length2) {
                return -1;
            }
            return length < length2 ? 1 : 0;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(NativeByteBuffer nativeByteBuffer) {
            Utilities.stageQueue.postRunnable(new ConnectionsManager$DnsTxtLoadTask$$ExternalSyntheticLambda0(this, nativeByteBuffer));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onPostExecute$1(NativeByteBuffer nativeByteBuffer) {
            AsyncTask unused = ConnectionsManager.currentTask = null;
            if (nativeByteBuffer != null) {
                int i = this.currentAccount;
                ConnectionsManager.native_applyDnsConfig(i, nativeByteBuffer.address, AccountInstance.getInstance(i).getUserConfig().getClientPhone(), this.responseDate);
                return;
            }
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("failed to get dns txt result");
                FileLog.d("start google task");
            }
            GoogleDnsLoadTask googleDnsLoadTask = new GoogleDnsLoadTask(this.currentAccount);
            googleDnsLoadTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null, null, null);
            AsyncTask unused2 = ConnectionsManager.currentTask = googleDnsLoadTask;
        }
    }

    /* access modifiers changed from: private */
    public static class GoogleDnsLoadTask extends AsyncTask<Void, Void, NativeByteBuffer> {
        private int currentAccount;
        private int responseDate;

        public GoogleDnsLoadTask(int i) {
            this.currentAccount = i;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x012d A[SYNTHETIC, Splitter:B:51:0x012d] */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x0137 A[SYNTHETIC, Splitter:B:56:0x0137] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public org.telegram.tgnet.NativeByteBuffer doInBackground(java.lang.Void... r12) {
            /*
            // Method dump skipped, instructions count: 334
            */
            throw new UnsupportedOperationException("Method not decompiled: org.telegram.tgnet.ConnectionsManager.GoogleDnsLoadTask.doInBackground(java.lang.Void[]):org.telegram.tgnet.NativeByteBuffer");
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ int lambda$doInBackground$0(String str, String str2) {
            int length = str.length();
            int length2 = str2.length();
            if (length > length2) {
                return -1;
            }
            return length < length2 ? 1 : 0;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(NativeByteBuffer nativeByteBuffer) {
            Utilities.stageQueue.postRunnable(new ConnectionsManager$GoogleDnsLoadTask$$ExternalSyntheticLambda0(this, nativeByteBuffer));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onPostExecute$1(NativeByteBuffer nativeByteBuffer) {
            AsyncTask unused = ConnectionsManager.currentTask = null;
            if (nativeByteBuffer != null) {
                int i = this.currentAccount;
                ConnectionsManager.native_applyDnsConfig(i, nativeByteBuffer.address, AccountInstance.getInstance(i).getUserConfig().getClientPhone(), this.responseDate);
                return;
            }
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("failed to get google result");
                FileLog.d("start mozilla task");
            }
            MozillaDnsLoadTask mozillaDnsLoadTask = new MozillaDnsLoadTask(this.currentAccount);
            mozillaDnsLoadTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null, null, null);
            AsyncTask unused2 = ConnectionsManager.currentTask = mozillaDnsLoadTask;
        }
    }

    /* access modifiers changed from: private */
    public static class MozillaDnsLoadTask extends AsyncTask<Void, Void, NativeByteBuffer> {
        private int currentAccount;
        private int responseDate;

        public MozillaDnsLoadTask(int i) {
            this.currentAccount = i;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x0134 A[SYNTHETIC, Splitter:B:51:0x0134] */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x013e A[SYNTHETIC, Splitter:B:56:0x013e] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public org.telegram.tgnet.NativeByteBuffer doInBackground(java.lang.Void... r12) {
            /*
            // Method dump skipped, instructions count: 341
            */
            throw new UnsupportedOperationException("Method not decompiled: org.telegram.tgnet.ConnectionsManager.MozillaDnsLoadTask.doInBackground(java.lang.Void[]):org.telegram.tgnet.NativeByteBuffer");
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ int lambda$doInBackground$0(String str, String str2) {
            int length = str.length();
            int length2 = str2.length();
            if (length > length2) {
                return -1;
            }
            return length < length2 ? 1 : 0;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(NativeByteBuffer nativeByteBuffer) {
            Utilities.stageQueue.postRunnable(new ConnectionsManager$MozillaDnsLoadTask$$ExternalSyntheticLambda0(this, nativeByteBuffer));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onPostExecute$1(NativeByteBuffer nativeByteBuffer) {
            AsyncTask unused = ConnectionsManager.currentTask = null;
            if (nativeByteBuffer != null) {
                int i = this.currentAccount;
                ConnectionsManager.native_applyDnsConfig(i, nativeByteBuffer.address, AccountInstance.getInstance(i).getUserConfig().getClientPhone(), this.responseDate);
            } else if (BuildVars.LOGS_ENABLED) {
                FileLog.d("failed to get mozilla txt result");
            }
        }
    }

    /* access modifiers changed from: private */
    public static class FirebaseTask extends AsyncTask<Void, Void, NativeByteBuffer> {
        private int currentAccount;
        private FirebaseRemoteConfig firebaseRemoteConfig;

        /* access modifiers changed from: protected */
        public void onPostExecute(NativeByteBuffer nativeByteBuffer) {
        }

        public FirebaseTask(int i) {
            this.currentAccount = i;
        }

        /* access modifiers changed from: protected */
        public NativeByteBuffer doInBackground(Void... voidArr) {
            try {
                if (ConnectionsManager.native_isTestBackend(this.currentAccount) == 0) {
                    FirebaseRemoteConfig instance = FirebaseRemoteConfig.getInstance();
                    this.firebaseRemoteConfig = instance;
                    String string = instance.getString("ipconfigv3");
                    if (BuildVars.LOGS_ENABLED) {
                        FileLog.d("current firebase value = " + string);
                    }
                    this.firebaseRemoteConfig.fetch(0).addOnCompleteListener(new ConnectionsManager$FirebaseTask$$ExternalSyntheticLambda1(this));
                    return null;
                }
                throw new Exception("test backend");
            } catch (Throwable th) {
                Utilities.stageQueue.postRunnable(new ConnectionsManager$FirebaseTask$$ExternalSyntheticLambda2(this));
                FileLog.e(th);
                return null;
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$doInBackground$2(Task task) {
            Utilities.stageQueue.postRunnable(new ConnectionsManager$FirebaseTask$$ExternalSyntheticLambda3(this, task.isSuccessful()));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$doInBackground$1(boolean z) {
            if (z) {
                this.firebaseRemoteConfig.activate().addOnCompleteListener(new ConnectionsManager$FirebaseTask$$ExternalSyntheticLambda0(this));
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$doInBackground$0(Task task) {
            AsyncTask unused = ConnectionsManager.currentTask = null;
            String string = this.firebaseRemoteConfig.getString("ipconfigv3");
            if (!TextUtils.isEmpty(string)) {
                byte[] decode = Base64.decode(string, 0);
                try {
                    NativeByteBuffer nativeByteBuffer = new NativeByteBuffer(decode.length);
                    nativeByteBuffer.writeBytes(decode);
                    int fetchTimeMillis = (int) (this.firebaseRemoteConfig.getInfo().getFetchTimeMillis() / 1000);
                    int i = this.currentAccount;
                    ConnectionsManager.native_applyDnsConfig(i, nativeByteBuffer.address, AccountInstance.getInstance(i).getUserConfig().getClientPhone(), fetchTimeMillis);
                } catch (Exception e) {
                    FileLog.e(e);
                }
            } else {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("failed to get firebase result");
                    FileLog.d("start dns txt task");
                }
                DnsTxtLoadTask dnsTxtLoadTask = new DnsTxtLoadTask(this.currentAccount);
                dnsTxtLoadTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null, null, null);
                AsyncTask unused2 = ConnectionsManager.currentTask = dnsTxtLoadTask;
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$doInBackground$3() {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("failed to get firebase result");
                FileLog.d("start dns txt task");
            }
            DnsTxtLoadTask dnsTxtLoadTask = new DnsTxtLoadTask(this.currentAccount);
            dnsTxtLoadTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null, null, null);
            AsyncTask unused = ConnectionsManager.currentTask = dnsTxtLoadTask;
        }
    }
}
