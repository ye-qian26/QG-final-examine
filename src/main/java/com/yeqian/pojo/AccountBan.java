package com.yeqian.pojo;

public class AccountBan {
    private Integer id;
    private Integer userId;
    private Integer banUserId;

    public AccountBan() {
    }

    public AccountBan(Integer id, Integer userId, Integer banUserId) {
        this.id = id;
        this.userId = userId;
        this.banUserId = banUserId;
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

    public Integer getBanUserId() {
        return banUserId;
    }

    public void setBanUserId(Integer banUserId) {
        this.banUserId = banUserId;
    }

    @Override
    public String toString() {
        return "AccountBan{" +
                "id=" + id +
                ", userId=" + userId +
                ", banUserId=" + banUserId +
                '}';
    }
}
