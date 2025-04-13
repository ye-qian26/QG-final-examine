package com.yeqian.pojo;

/**
 * 评论类
 */
public class Review {
    private Integer id;
    private String content;
    private Integer postId;

    public Review() {
    }

    public Review(Integer id, String content, Integer postId) {
        this.id = id;
        this.content = content;
        this.postId = postId;
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
                '}';
    }
}
