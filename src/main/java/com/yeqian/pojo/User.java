package com.yeqian.pojo;

/**
 * 用户类
 */
public class User {
    private Integer id;
    private String username;
    private String password;
    private String tele;
    private String headPortrait;

    public User() {
    }

    public User(Integer id, String username, String password, String tele, String headPortrait) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.tele = tele;
        this.headPortrait = headPortrait;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", tele='" + tele + '\'' +
                ", headPortrait='" + headPortrait + '\'' +
                '}';
    }
}
