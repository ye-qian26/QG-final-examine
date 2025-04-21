package com.yeqian.pojo;

public class ChatRecord {
    private Integer id;
    private Integer senderId;
    private Integer receiverId;
    private String content;
    private String sendTime;

    public ChatRecord() {
    }

    public ChatRecord(Integer id, Integer senderId, Integer receiverId, String content, String sendTime) {
        this.id = id;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.content = content;
        this.sendTime = sendTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    @Override
    public String toString() {
        return "ChatRecord{" +
                "id='" + id + '\'' +
                ", senderId='" + senderId + '\'' +
                ", receiverId='" + receiverId + '\'' +
                ", content='" + content + '\'' +
                ", sendTime='" + sendTime + '\'' +
                '}';
    }
}
