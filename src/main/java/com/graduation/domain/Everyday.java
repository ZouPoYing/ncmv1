package com.graduation.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Everyday {

	
    private Integer wid;
    
    private Integer userId;
    
    private Integer songId;
    
    private String songName;

    private String songAuthor;
    
    private String songType;
    
    @JsonFormat(pattern="yyyy-MM-dd")//, timezone = "GMT+8"
	private Date date;

	public Everyday() {
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

	public Integer getSongId() {
		return songId;
	}

	public void setSongId(Integer songId) {
		this.songId = songId;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getSongAuthor() {
		return songAuthor;
	}

	public void setSongAuthor(String songAuthor) {
		this.songAuthor = songAuthor;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSongType() {
		return songType;
	}

	public void setSongType(String songType) {
		this.songType = songType;
	}

	@Override
	public String toString() {
		return "Everyday [wid=" + wid + ", userId=" + userId + ", songId=" + songId + ", songName=" + songName
				+ ", songAuthor=" + songAuthor + ", songType=" + songType + ", date=" + date + "]";
	}
	
	
}
