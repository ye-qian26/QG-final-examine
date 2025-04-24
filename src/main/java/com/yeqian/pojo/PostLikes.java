package com.yeqian.pojo;

public class PostLikes {
    private Integer id;
    private Integer userId;
    private Integer likesUserId;
    private Integer postId;

    public PostLikes() {
    }

    public PostLikes(Integer id, Integer userId, Integer likesUserId, Integer postId) {
        this.id = id;
        this.userId = userId;
        this.likesUserId = likesUserId;
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

    public Integer getLikesUserId() {
        return likesUserId;
    }

    public void setLikesUserId(Integer likesUserId) {
        this.likesUserId = likesUserId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    @Override
    public String toString() {
        return "PostLikes{" +
                "id=" + id +
                ", userId=" + userId +
                ", likesUserId=" + likesUserId +
                ", postId=" + postId +
                '}';
    }
}
