package com.yeqian.pojo;

/**
 * 关注用户类
 */
public class InterestUserList {
    private Integer id;
    private Integer userId;
    private Integer interestedUserId;

    public InterestUserList() {
    }

    public InterestUserList(Integer id, Integer userId, Integer interestedUserId) {
        this.id = id;
        this.userId = userId;
        this.interestedUserId = interestedUserId;
    }

    public Integer getInterestedUserId() {
        return interestedUserId;
    }

    public void setInterestedUserId(Integer interestedUserId) {
        this.interestedUserId = interestedUserId;
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

    @Override
    public String toString() {
        return "InterestUserList{" +
                "id=" + id +
                ", userId=" + userId +
                ", interestedUserId=" + interestedUserId +
                '}';
    }
}
