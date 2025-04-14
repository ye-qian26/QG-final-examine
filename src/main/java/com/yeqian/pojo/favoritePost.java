package com.yeqian.pojo;

public class favoritePost {
    private Integer id;
    private Integer postId;
    private Integer userId;

    public favoritePost() {
    }

    public favoritePost(Integer id, Integer postId, Integer userId) {
        this.id = id;
        this.postId = postId;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "favoritePost{" +
                "id=" + id +
                ", postId=" + postId +
                ", userId=" + userId +
                '}';
    }
}
