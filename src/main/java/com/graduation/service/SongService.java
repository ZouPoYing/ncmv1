package com.graduation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graduation.domain.Comment;
import com.graduation.domain.Everyday;
import com.graduation.domain.LikeSong;
import com.graduation.domain.Mv;
import com.graduation.domain.Song;
import com.graduation.domain.SongCommentDetails;
import com.graduation.domain.SongList;
import com.graduation.domain.Type;
import com.graduation.mapper.SongMapper;

@Service
public class SongService {

	@Autowired(required = false)
	private SongMapper mapper;
	
	public List<Song> listLXSong() {
		List<Song> songs=mapper.listLXSong();
		return songs;
	}
	
	public List<Song> listYGSong() {
		List<Song> songs=mapper.listYGSong();
		return songs;
	}
	
	public List<Song> listMYSong() {
		List<Song> songs=mapper.listMYSong();
		return songs;
	}
	
	public List<Song> listGFSong() {
		List<Song> songs=mapper.listGFSong();
		return songs;
	}
	
	public Song querySongBySongId(int songId) {
		Song song=mapper.queryUserByUserId(songId);
		return song;
	}

	public Boolean selectSongByUserIdAndSongId(int userId, int songId) {
		// TODO Auto-generated method stub
		Boolean isGet=mapper.selectSongByUserIdAndSongId(userId,songId);
		return isGet;
	}

	public Boolean insertLikeSong(int userId, int songId, String songName, String songAuthor, String songType,
			String songPic, String songSong) {
		// TODO Auto-generated method stub
		Boolean isIsert=mapper.insertLikeSong(userId,songId,songName,songAuthor,songType,songPic,songSong);
		return isIsert;
	}

	public void updateSongLikeNum(int songId) {
		// TODO Auto-generated method stub
		mapper.updateSongLikeNum(songId);
	}
	
	public void updateSongLikeNum2(int songId) {
		// TODO Auto-generated method stub
		mapper.updateSongLikeNum2(songId);
	}

	public Boolean deleteLikeSong(int userId, int songId) {
		// TODO Auto-generated method stub
		Boolean isDelete = mapper.deleteLikeSong(userId,songId);
		return isDelete;
	}

	public List<LikeSong> listLikeSongByUserId(int userId) {
		// TODO Auto-generated method stub
		List<LikeSong> likesonglist = mapper.listLikeSongByUserId(userId);
		return likesonglist;
	}

	public LikeSong selectReSongByUserIdAndSongId(int userId, int songId) {
		// TODO Auto-generated method stub
		LikeSong ReSong = mapper.selectReSongByUserIdAndSongId(userId,songId);
		return ReSong;
	}

	public Boolean insertReSong(int userId, int songId, String songName, String songAuthor, String songType,
			String songPic, String songSong) {
		// TODO Auto-generated method stub
		Boolean isIsert=mapper.insertReSong(userId,songId,songName,songAuthor,songType,songPic,songSong);
		return isIsert;
	}

	public void updateReSong(int userId, int songId) {
		// TODO Auto-generated method stub
		mapper.updateReSong(userId, songId);
	}

	public List<LikeSong> listReSongByUserId(int userId) {
		// TODO Auto-generated method stub
		List<LikeSong> likesonglist = mapper.listReSongByUserId(userId);
		return likesonglist;
	}

	public List<SongList> listSongListByUserId(int userId) {
		// TODO Auto-generated method stub
		List<SongList> songlistlist = mapper.listSongListByUserId(userId);
		return songlistlist;
	}

	public void insertSongListByUserIdAndSongListName(int userId, String songListName) {
		// TODO Auto-generated method stub
		mapper.insertSongListByUserIdAndSongListName(userId,songListName);
	}

	public SongList selectSongListByUserIdSongIdWid(int userId, int songId, int id) {
		// TODO Auto-generated method stub
		SongList songlist=mapper.selectSongListByUserIdSongIdWid(userId,songId,id);
		return songlist;
	}

	public void insertSongListByUserIdSongIdWid(int userId, int songId, int id, String songName, String songAuthor,
			String songType, String songPic, String songSong) {
		// TODO Auto-generated method stub
		mapper.insertSongListByUserIdSongIdWid(userId,songId,id,songName,songAuthor,songType,songPic,songSong);		
	}

	public String querySongListNameByWid(int id) {
		// TODO Auto-generated method stub
		String songlistname = mapper.querySongListNameByWid(id);
		return songlistname;
	}

	public List<SongList> listSongListDetailsByUserIdAndSongListId(int userId, int id) {
		// TODO Auto-generated method stub
		List<SongList> songlistlist = mapper.listSongListDetailsByUserIdAndSongListId(userId,id);
		return songlistlist;
	}

	public void deleteSongListAndSongListDetailsByWid(int id) {
		// TODO Auto-generated method stub
		mapper.deleteSongListAndSongListDetailsByWid(id);
	}

	public void deleteLikeSongListDetailsByWid(int id) {
		// TODO Auto-generated method stub
		mapper.deleteLikeSongListDetailsByWid(id);
	}

	public void deleteReSongListDetailsByWid(int id) {
		// TODO Auto-generated method stub
		mapper.deleteReSongListDetailsByWid(id);
	}

	public void deleteSongListDetailsByWid(int id) {
		// TODO Auto-generated method stub
		mapper.deleteSongListDetailsByWid(id);
	}

	public void insertCommentBySongIdUserIdText(int songId, int userId, String text, String userHeadPic, String userName) {
		// TODO Auto-generated method stub
		mapper.insertCommentBySongIdUserIdText(songId,userId,text,userHeadPic,userName);
	}

	public List<SongCommentDetails> listSongCommentDetailsByUserIdAndSongId(int songId, int userId) {
		// TODO Auto-generated method stub
		List<SongCommentDetails> listcomment = mapper.listSongCommentDetailsByUserIdAndSongId(songId,userId);
		return listcomment;
	}

	public List<SongCommentDetails> listSongCommentDetailsBySongId(int songId) {
		// TODO Auto-generated method stub
		List<SongCommentDetails> listcomment = mapper.listSongCommentDetailsBySongId(songId);
		return listcomment;
	}

	public List<Song> listRanking() {
		// TODO Auto-generated method stub
		List<Song> songs = mapper.listRanking();
		return songs;
	}

	public List<SongList> listSongList() {
		// TODO Auto-generated method stub
		List<SongList> songlists = mapper.listSongList();
		return songlists;
	}

	public List<Everyday> listEverydayByUserId(int userId) {
		// TODO Auto-generated method stub
		List<Everyday> everydaylists = mapper.listEverydayByUserId(userId);
		return everydaylists;
	}

	public List<Type> listTypeSongByUserId(int userId) {
		// TODO Auto-generated method stub
		List<Type> type = mapper.listTypeSongByUserId(userId);
		return type;
	}

	public List<Song> listSongBySongTypeAndNum(String songType, Integer num) {
		// TODO Auto-generated method stub
		List<Song> listSong = mapper.listSongBySongTypeAndNum(songType,num);
		return listSong;
	}

	public void insertEveryday(int userId, Integer songId, String songName, String songAuthor, String songType) {
		// TODO Auto-generated method stub
		mapper.insertEveryday(userId,songId,songName,songAuthor,songType);
	}

	public void deleteEverydayByUserId(int userId) {
		// TODO Auto-generated method stub
		mapper.deleteEverydayByUserId(userId);
	}

	public List<Song> listSearch(String text) {
		// TODO Auto-generated method stub
		List<Song> songlists = mapper.listSearch(text);
		return songlists;
	}

	public List<Mv> listGSMv() {
		// TODO Auto-generated method stub
		List<Mv> mvlists = mapper.listGSMv();
		return mvlists;
	}

	public List<Mv> listMv(String mvType) {
		// TODO Auto-generated method stub
		List<Mv> mvlists = mapper.listMv(mvType);
		return mvlists;
	}

	public List<Comment> listComment() {
		// TODO Auto-generated method stub
		List<Comment> commentlists = mapper.listComment();
		return commentlists;
	}

	public void insertCommentByUserIdText(int userId, String text, String userHeadPic, String userName) {
		// TODO Auto-generated method stub
		mapper.insertCommentByUserIdText(userId,text,userHeadPic,userName);
	}

	public List<Comment> listCommentByUserId(int userId) {
		// TODO Auto-generated method stub
		List<Comment> commentlists = mapper.listCommentByUserId(userId);
		return commentlists;
	}

}
