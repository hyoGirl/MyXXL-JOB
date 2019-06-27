package com.xxl.jobTest.Job;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: xulei
 * @Date: 2019/6/26 0026 15:22
 * @Description:
 */
public class WxMpMassOpenIdsMessage implements Serializable {

    private static final long serialVersionUID = -8022910911104788999L;

    /**
     * openid列表，最多支持10,000个
     */
    private List<String> toUsers = new ArrayList<>();
    private String msgType;
    private String content;
    private String mediaId;
    /**
     * 文章被判定为转载时，是否继续进行群发操作。
     */
    private boolean sendIgnoreReprint = false;

    /**
     * 开发者侧群发msgid，长度限制64字节，如不填，则后台默认以群发范围和群发内容的摘要值做为clientmsgid
     */
    private String clientMsgId;

    public WxMpMassOpenIdsMessage() {
        super();
    }


    /**
     * 添加openid，最多支持10,000个
     */
    public void addUser(String openid) {
        this.toUsers.add(openid);
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<String> getToUsers() {
        return toUsers;
    }

    public void setToUsers(List<String> toUsers) {
        this.toUsers = toUsers;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public boolean isSendIgnoreReprint() {
        return sendIgnoreReprint;
    }

    public void setSendIgnoreReprint(boolean sendIgnoreReprint) {
        this.sendIgnoreReprint = sendIgnoreReprint;
    }

    public String getClientMsgId() {
        return clientMsgId;
    }

    public void setClientMsgId(String clientMsgId) {
        this.clientMsgId = clientMsgId;
    }
}
