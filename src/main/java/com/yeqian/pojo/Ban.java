package com.yeqian.pojo;

/**
 * 被封禁的用户类
 */
public class Ban {
    private Integer id;
    private Integer userId;

    public Ban() {
    }

    public Ban(Integer id, Integer userId) {
        this.id = id;
        this.userId = userId;
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
                '}';
    }
}
