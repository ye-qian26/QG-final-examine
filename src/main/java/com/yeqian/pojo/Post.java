package com.yeqian.pojo;

/**
 * 帖子类
 */
public class Post {
    private Integer id;
    private String content;
    private String image;
    private Integer pageView;
    private Integer likes;
    private Integer plateId;
    private Integer userId;

    public Post() {
    }

    public Post(Integer id, String content, String image, Integer pageView, Integer likes, Integer plateId, Integer userId) {
        this.id = id;
        this.content = content;
        this.image = image;
        this.pageView = pageView;
        this.likes = likes;
        this.plateId = plateId;
        this.userId = userId;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getPageView() {
        return pageView;
    }

    public void setPageView(Integer pageView) {
        this.pageView = pageView;
    }

    public Integer getPlateId() {
        return plateId;
    }

    public void setPlateId(Integer plateId) {
        this.plateId = plateId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", image='" + image + '\'' +
                ", pageView=" + pageView +
                ", likes=" + likes +
                ", plateId=" + plateId +
                ", userId=" + userId +
                '}';
    }
}
