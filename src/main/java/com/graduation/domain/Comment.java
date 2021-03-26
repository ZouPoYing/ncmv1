package com.graduation.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Comment {
	
	private Integer wid;
	
    private Integer userId;
    
    private String userName;
    
    private String userHeadPic;
    
    private String comment;
    
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date commentDate;

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getWid() {
		return wid;
	}

	public void setWid(Integer wid) {
		this.wid = wid;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserHeadPic() {
		return userHeadPic;
	}

	public void setUserHeadPic(String userHeadPic) {
		this.userHeadPic = userHeadPic;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	@Override
	public String toString() {
		return "Comment [wid=" + wid + ", userId=" + userId + ", userName=" + userName + ", userHeadPic=" + userHeadPic
				+ ", comment=" + comment + ", commentDate=" + commentDate + "]";
	}
    
}
