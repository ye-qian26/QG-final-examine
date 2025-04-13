package com.yeqian.pojo;

/**
 * 被举报的帖子类
 */
public class ReportedPost {
    private Integer id;
    private Integer postId;
    private String reportContent;

    public ReportedPost() {
    }

    public ReportedPost(Integer id, Integer postId, String reportContent) {
        this.id = id;
        this.postId = postId;
        this.reportContent = reportContent;
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
                ", postId=" + postId +
                ", reportContent='" + reportContent + '\'' +
                '}';
    }
}
