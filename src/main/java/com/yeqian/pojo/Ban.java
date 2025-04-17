package com.yeqian.pojo;

/**
 * 被封禁的用户类
 */
public class Ban {
    private Integer id;
    private Integer userId;
    private Integer plateId;

    public Ban() {
    }

    public Ban(Integer id, Integer userId, Integer plateId) {
        this.id = id;
        this.userId = userId;
        this.plateId = plateId;
    }

    public Integer getPlateId() {
        return plateId;
    }

    public void setPlateId(Integer plateId) {
        this.plateId = plateId;
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
        return "Ban{" +
                "id=" + id +
                ", userId=" + userId +
                ", plateId=" + plateId +
                '}';
    }
}
