package com.yeqian.pojo;

/**
 * 关注板块类
 */
public class InterestPlateList {
    private Integer id;
    private Integer userId;
    private Integer interestedPlateId;

    public InterestPlateList() {
    }

    public InterestPlateList(Integer id, Integer userId, Integer interestedPlateId) {
        this.id = id;
        this.userId = userId;
        this.interestedPlateId = interestedPlateId;
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

    public Integer getInterestedPlateId() {
        return interestedPlateId;
    }

    public void setInterestedPlateId(Integer interestedPlateId) {
        this.interestedPlateId = interestedPlateId;
    }

    @Override
    public String toString() {
        return "InterestPlateList{" +
                "id=" + id +
                ", userId=" + userId +
                ", interestedPlateId=" + interestedPlateId +
                '}';
    }
}
