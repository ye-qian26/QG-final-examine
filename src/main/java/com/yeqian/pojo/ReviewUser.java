package com.yeqian.pojo;

public class ReviewUser {
    private Integer id;
    private Integer userId;
    private Integer remindUserId;
    private Integer postId;
    private Integer reviewId;

    public ReviewUser() {
    }

    public ReviewUser(Integer id, Integer userId, Integer remindUserId, Integer postId, Integer reviewId) {
        this.id = id;
        this.userId = userId;
        this.remindUserId = remindUserId;
        this.postId = postId;
        this.reviewId = reviewId;
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

    public Integer getRemindUserId() {
        return remindUserId;
    }

    public void setRemindUserId(Integer remindUserId) {
        this.remindUserId = remindUserId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    @Override
    public String toString() {
        return "ReviewUser{" +
                "id=" + id +
                ", userId=" + userId +
                ", remindUserId=" + remindUserId +
                ", postId=" + postId +
                ", reviewId=" + reviewId +
                '}';
    }
}
