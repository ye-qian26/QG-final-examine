package com.yeqian.pojo;

/**
 * 被举报的帖子类
 */
public class ReportedPost {
    private Integer id;
    private Integer userId;
    private Integer plateId;
    private Integer postId;
    private String reportContent;
    private Integer isClean;

    public ReportedPost() {
    }

    public ReportedPost(Integer id, Integer userId, Integer plateId, Integer postId, String reportContent, Integer isClean) {
        this.id = id;
        this.userId = userId;
        this.plateId = plateId;
        this.postId = postId;
        this.reportContent = reportContent;
        this.isClean = isClean;
    }

    public Integer getIsClean() {
        return isClean;
    }

    public void setIsClean(Integer isClean) {
        this.isClean = isClean;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    @Override
    public String toString() {
        return "ReportedPost{" +
                "id=" + id +
                ", userId=" + userId +
                ", plateId=" + plateId +
                ", postId=" + postId +
                ", reportContent='" + reportContent + '\'' +
                ", isClean=" + isClean +
                '}';
    }
}
