package com.graduation.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SongCommentDetails {
	
    private Integer wid;
    
    private Integer songId;
    
    private Integer userId;
    
    private String userHeadPic;
    
    private String text;

    private Integer praiseNum;
    
    private String userName;
    
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date commentDate;

	public SongCommentDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getWid() {
		return wid;
	}

	public void setWid(Integer wid) {
		this.wid = wid;
	}

	public Integer getSongId() {
		return songId;
	}

	public void setSongId(Integer songId) {
		this.songId = songId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserHeadPic() {
		return userHeadPic;
	}

	public void setUserHeadPic(String userHeadPic) {
		this.userHeadPic = userHeadPic;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getPraiseNum() {
		return praiseNum;
	}

	public void setPraiseNum(Integer praiseNum) {
		this.praiseNum = praiseNum;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	@Override
	public String toString() {
		return "SongCommentDetails [wid=" + wid + ", songId=" + songId + ", userId=" + userId + ", userHeadPic="
				+ userHeadPic + ", text=" + text + ", praiseNum=" + praiseNum + ", userName=" + userName
				+ ", commentDate=" + commentDate + "]";
	}
	
}
