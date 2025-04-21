package com.yeqian.pojo;

/**
 * 需审核的信息类
 */
public class Audit {
    private Integer id;
    private Integer userId;
    private String plateName;
    private Integer status;
    private Integer isClean;

    public Audit() {
    }

    public Audit(Integer id, Integer userId, String plateName, Integer status, Integer isClean) {
        this.id = id;
        this.userId = userId;
        this.plateName = plateName;
        this.status = status;
        this.isClean = isClean;
    }

    public Integer getIsClean() {
        return isClean;
    }

    public void setIsClean(Integer isClean) {
        this.isClean = isClean;
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

    public String getPlateName() {
        return plateName;
    }

    public void setPlateName(String plateName) {
        this.plateName = plateName;
    }

    public Integer getStatus() {
        return status;
    }

    //逻辑视图
    public String getStatusStr() {
        if (status == null){
            return "未知";
        }
        return status == 1 ? "已处理" : "未处理";
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Audit{" +
                "id=" + id +
                ", userId=" + userId +
                ", plateName='" + plateName + '\'' +
                ", status=" + status +
                ", isClean=" + isClean +
                '}';
    }
}
