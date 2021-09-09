package org.telegram.tgnet;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class TLRPC$Message extends TLObject {
    public TLRPC$MessageAction action;
    public String attachPath = "";
    public int date;
    public int destroyTime;
    public long dialog_id;
    public int edit_date;
    public boolean edit_hide;
    public ArrayList<TLRPC$MessageEntity> entities = new ArrayList<>();
    public int flags;
    public int forwards;
    public TLRPC$Peer from_id;
    public boolean from_scheduled;
    public TLRPC$MessageFwdHeader fwd_from;
    public int fwd_msg_id = 0;
    public long grouped_id;
    public int id;
    public boolean isThreadMessage;
    public int layer;
    public boolean legacy;
    public int local_id = 0;
    public TLRPC$MessageMedia media;
    public boolean media_unread;
    public boolean mentioned;
    public String message;
    public boolean out;
    public HashMap<String, String> params;
    public TLRPC$Peer peer_id;
    public boolean pinned;
    public boolean post;
    public String post_author;
    public long random_id;
    public TLRPC$TL_messageReactions reactions;
    public int realId;
    public TLRPC$TL_messageReplies replies;
    public TLRPC$Message replyMessage;
    public TLRPC$ReplyMarkup reply_markup;
    public TLRPC$TL_messageReplyHeader reply_to;
    public int reqId;
    public ArrayList<TLRPC$TL_restrictionReason> restriction_reason = new ArrayList<>();
    public int send_state = 0;
    public int seq_in;
    public int seq_out;
    public boolean silent;
    public int stickerVerified = 1;
    public int ttl;
    public int ttl_period;
    public boolean unread;
    public int via_bot_id;
    public String via_bot_name;
    public int views;
    public boolean with_my_score;

    public static TLRPC$Message TLdeserialize(AbstractSerializedData abstractSerializedData, int i, boolean z) {
        TLRPC$Message tLRPC$Message;
        switch (i) {
            case -2082087340:
                tLRPC$Message = new TLRPC$TL_messageEmpty_layer122();
                break;
            case -1868117372:
                tLRPC$Message = new TLRPC$TL_messageEmpty();
                break;
            case -1864508399:
                tLRPC$Message = new TLRPC$TL_message_layer72();
                break;
            case -1752573244:
                tLRPC$Message = new TLRPC$TL_message_layer104_3();
                break;
            case -1642487306:
                tLRPC$Message = new TLRPC$TL_messageService_layer118();
                break;
            case -1618124613:
                tLRPC$Message = new TLRPC$TL_messageService_old();
                break;
            case -1553471722:
                tLRPC$Message = new TLRPC$TL_messageForwarded_old2();
                break;
            case -1481959023:
                tLRPC$Message = new TLRPC$TL_message_old3();
                break;
            case -1125940270:
                tLRPC$Message = new TLRPC$TL_message();
                break;
            case -1066691065:
                tLRPC$Message = new TLRPC$TL_messageService_layer48();
                break;
            case -1063525281:
                tLRPC$Message = new TLRPC$TL_message_layer68();
                break;
            case -1023016155:
                tLRPC$Message = new TLRPC$TL_message_old4();
                break;
            case -913120932:
                tLRPC$Message = new TLRPC$TL_message_layer47();
                break;
            case -260565816:
                tLRPC$Message = new TLRPC$TL_message_old5();
                break;
            case -181507201:
                tLRPC$Message = new TLRPC$TL_message_layer118();
                break;
            case 99903492:
                tLRPC$Message = new TLRPC$TL_messageForwarded_old();
                break;
            case 479924263:
                tLRPC$Message = new TLRPC$TL_message_layer104_2();
                break;
            case 495384334:
                tLRPC$Message = new TLRPC$TL_messageService_old2();
                break;
            case 585853626:
                tLRPC$Message = new TLRPC$TL_message_old();
                break;
            case 678405636:
                tLRPC$Message = new TLRPC$TL_messageService_layer123();
                break;
            case 721967202:
                tLRPC$Message = new TLRPC$TL_messageService();
                break;
            case 736885382:
                tLRPC$Message = new TLRPC$TL_message_old6();
                break;
            case 1157215293:
                tLRPC$Message = new TLRPC$TL_message_layer104();
                break;
            case 1160515173:
                tLRPC$Message = new TLRPC$TL_message_layer117();
                break;
            case 1431655928:
                tLRPC$Message = new TLRPC$TL_message_secret_old();
                break;
            case 1431655929:
                tLRPC$Message = new TLRPC$TL_message_secret_layer72();
                break;
            case 1431655930:
                tLRPC$Message = new TLRPC$TL_message_secret();
                break;
            case 1450613171:
                tLRPC$Message = new TLRPC$TL_message_old2();
                break;
            case 1487813065:
                tLRPC$Message = new TLRPC$TL_message_layer123();
                break;
            case 1537633299:
                tLRPC$Message = new TLRPC$TL_message_old7();
                break;
            default:
                tLRPC$Message = null;
                break;
        }
        if (tLRPC$Message != null || !z) {
            if (tLRPC$Message != null) {
                tLRPC$Message.readParams(abstractSerializedData, z);
                if (tLRPC$Message.from_id == null) {
                    tLRPC$Message.from_id = tLRPC$Message.peer_id;
                }
            }
            return tLRPC$Message;
        }
        throw new RuntimeException(String.format("can't parse magic %x in Message", Integer.valueOf(i)));
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x00a1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void readAttachPath(org.telegram.tgnet.AbstractSerializedData r8, int r9) {
        /*
        // Method dump skipped, instructions count: 299
        */
        throw new UnsupportedOperationException("Method not decompiled: org.telegram.tgnet.TLRPC$Message.readAttachPath(org.telegram.tgnet.AbstractSerializedData, int):void");
    }

    /* access modifiers changed from: protected */
    public void writeAttachPath(AbstractSerializedData abstractSerializedData) {
        HashMap<String, String> hashMap;
        HashMap<String, String> hashMap2;
        if ((this instanceof TLRPC$TL_message_secret) || (this instanceof TLRPC$TL_message_secret_layer72)) {
            String str = this.attachPath;
            if (str == null) {
                str = "";
            }
            if (this.send_state == 1 && (hashMap = this.params) != null && hashMap.size() > 0) {
                for (Map.Entry<String, String> entry : this.params.entrySet()) {
                    str = entry.getKey() + "|=|" + entry.getValue() + "||" + str;
                }
                str = "||" + str;
            }
            abstractSerializedData.writeString(str);
            return;
        }
        String str2 = !TextUtils.isEmpty(this.attachPath) ? this.attachPath : " ";
        if (this.legacy) {
            if (this.params == null) {
                this.params = new HashMap<>();
            }
            this.layer = 132;
            this.params.put("legacy_layer", "132");
        }
        if ((this.id < 0 || this.send_state == 3 || this.legacy) && (hashMap2 = this.params) != null && hashMap2.size() > 0) {
            for (Map.Entry<String, String> entry2 : this.params.entrySet()) {
                str2 = entry2.getKey() + "|=|" + entry2.getValue() + "||" + str2;
            }
            str2 = "||" + str2;
        }
        abstractSerializedData.writeString(str2);
        if ((this.flags & 4) != 0 && this.id < 0) {
            abstractSerializedData.writeInt32(this.fwd_msg_id);
        }
    }
}
