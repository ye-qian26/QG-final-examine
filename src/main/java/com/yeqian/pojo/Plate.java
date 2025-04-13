package com.yeqian.pojo;

/**
 * 板块类
 */
public class Plate {
    private Integer id;
    private String name;
    private Integer user_id;
    private String notice;
    private Integer page_view;
    private Integer likes;

    public Plate() {
    }

    public Plate(Integer id, String name, Integer user_id, String notice, Integer page_view, Integer likes) {
        this.id = id;
        this.name = name;
        this.user_id = user_id;
        this.notice = notice;
        this.page_view = page_view;
        this.likes = likes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
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

    @Override
    public String toString() {
        return "Plate{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", user_id=" + user_id +
                ", notice='" + notice + '\'' +
                ", page_view=" + page_view +
                ", likes=" + likes +
                '}';
    }
}
