package com.graduation.domain;

import java.util.Date;

public class SongList {
	
    private Integer wid;
    
    private Integer userId;
    
    private Integer songId;
    
    private Integer songListId;

    private String songListName;

    private String songName;

    private String songAuthor;
    
	private Date songDate;
    
    private String songPic;
    
    private String songType;
    
    private String songSong;

	public SongList() {
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

	public Integer getSongListId() {
		return songListId;
	}

	public void setSongListId(Integer songListId) {
		this.songListId = songListId;
	}

	public String getSongListName() {
		return songListName;
	}

	public void setSongListName(String songListName) {
		this.songListName = songListName;
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

	public Date getSongDate() {
		return songDate;
	}

	public void setSongDate(Date songDate) {
		this.songDate = songDate;
	}

	public String getSongPic() {
		return songPic;
	}

	public void setSongPic(String songPic) {
		this.songPic = songPic;
	}

	public String getSongType() {
		return songType;
	}

	public void setSongType(String songType) {
		this.songType = songType;
	}

	public String getSongSong() {
		return songSong;
	}

	public void setSongSong(String songSong) {
		this.songSong = songSong;
	}

	@Override
	public String toString() {
		return "SongList [wid=" + wid + ", userId=" + userId + ", songId=" + songId + ", songListId=" + songListId
				+ ", songListName=" + songListName + ", songName=" + songName + ", songAuthor=" + songAuthor
				+ ", songDate=" + songDate + ", songPic=" + songPic + ", songType=" + songType + ", songSong="
				+ songSong + "]";
	}
    
}
