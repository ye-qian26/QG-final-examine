package com.yeqian.pojo;

/**
 * 帖子类
 */
public class Post {
    private Integer id;
    private String content;
    private String image;
    private Integer page_view;
    private Integer likes;
    private Integer plate_id;

    public Post() {
    }

    public Post(Integer id, String content, String image, Integer page_view, Integer likes, Integer plate_id) {
        this.id = id;
        this.content = content;
        this.image = image;
        this.page_view = page_view;
        this.likes = likes;
        this.plate_id = plate_id;
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

    public Integer getPage_view() {
        return page_view;
    }

    public void setPage_view(Integer page_view) {
        this.page_view = page_view;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getPlate_id() {
        return plate_id;
    }

    public void setPlate_id(Integer plate_id) {
        this.plate_id = plate_id;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", page_view=" + page_view +
                ", likes=" + likes +
                ", plate_id=" + plate_id +
                '}';
    }
}
