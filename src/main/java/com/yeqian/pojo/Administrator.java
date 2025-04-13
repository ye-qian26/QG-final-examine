package com.yeqian.pojo;

/**
 * 管理员类
 */
public class Administrator {
    private Integer id;
    private String name;
    private String password;
    private String tele;
    private String headPortrait;

    public Administrator() {
    }

    public Administrator(Integer id, String name, String password, String tele, String headPortrait) {
        this.id = id;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "Administrator{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", tele='" + tele + '\'' +
                ", headPortrait='" + headPortrait + '\'' +
                '}';
    }
}
