package com.yeqian.pojo;

/**
 * 评论类
 */
public class Review {
    private Integer id;
    private String content;
    private Integer postId;
    private Integer userId;
    private Integer likes;
    private Integer reviewId;

    public Review() {
    }

    public Review(Integer id, String content, Integer postId, Integer userId, Integer likes, Integer reviewId) {
        this.id = id;
        this.content = content;
        this.postId = postId;
        this.userId = userId;
        this.likes = likes;
        this.reviewId = reviewId;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", postId=" + postId +
                ", userId=" + userId +
                ", likes=" + likes +
                ", reviewId=" + reviewId +
                '}';
    }
}
