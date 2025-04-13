package com.yeqian.pojo;

/**
 * 被举报的用户类
 */
public class ReportedUser {
    private Integer id;
    private Integer userId;
    private String reportContent;

    public ReportedUser() {
    }

    public ReportedUser(Integer id, Integer userId, String reportContent) {
        this.id = id;
        this.userId = userId;
        this.reportContent = reportContent;
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

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    @Override
    public String toString() {
        return "ReportedUser{" +
                "id=" + id +
                ", userId=" + userId +
                ", reportContent='" + reportContent + '\'' +
                '}';
    }
}
