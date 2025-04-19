package com.yeqian.pojo;

public class HistoricalRecord {
    private Integer id;
    private Integer userId;
    private Integer postId;

    public HistoricalRecord() {
    }

    public HistoricalRecord(Integer id, Integer userId, Integer postId) {
        this.id = id;
        this.userId = userId;
        this.postId = postId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    @Override
    public String toString() {
        return "HistoricalRecord{" +
                "id=" + id +
                ", userId=" + userId +
                ", postId=" + postId +
                '}';
    }
}
