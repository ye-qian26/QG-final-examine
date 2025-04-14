package com.yeqian.pojo;

/**
 * 板块类
 */
public class Plate {
    private Integer id;
    private String name;
    private Integer userId;
    private String notice;
    private Integer pageView;
    private Integer likes;

    public Plate() {
    }

    public Plate(Integer id, String name, Integer userId, String notice, Integer pageView, Integer likes) {
        this.id = id;
        this.name = name;
        this.userId = userId;
        this.notice = notice;
        this.pageView = pageView;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPageView() {
        return pageView;
    }

    public void setPageView(Integer pageView) {
        this.pageView = pageView;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", userId=" + userId +
                ", notice='" + notice + '\'' +
                ", pageView=" + pageView +
                ", likes=" + likes +
                '}';
    }
}
