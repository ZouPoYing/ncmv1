package com.graduation.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.graduation.domain.Comment;
import com.graduation.domain.Everyday;
import com.graduation.domain.LikeSong;
import com.graduation.domain.Mv;
import com.graduation.domain.Song;
import com.graduation.domain.SongCommentDetails;
import com.graduation.domain.SongList;
import com.graduation.domain.Type;
import com.graduation.domain.User;
import com.graduation.service.SongService;
import com.graduation.service.UserService;

@RestController
@CrossOrigin(allowCredentials ="true")
public class SongController {
	
	@Autowired
	private SongService songService; 
	
	@Autowired
	private UserService userService; 
	
	// 流行音乐清单
	@RequestMapping("/song/listLXSong")
	@ResponseBody
	public List<Song> listLXSong() {
		List<Song> songs = songService.listLXSong();
		return songs;
	}	
	
	// 流行音乐分页
    @GetMapping("/song/pageLXSong")
    @Transactional(readOnly = true)
    public Page pageLXSong(@RequestParam Integer page, @RequestParam Integer size) {
        //分页并查询
        Page<Song> pageInfo = PageHelper.startPage(page, size);
        List<Song> songs = songService.listLXSong();
        //获取分页信息演示, 实际项目中一般会封装为自己的返回体。
        int pageNum = pageInfo.getPageNum();
        int pageSize = pageInfo.getPageSize();
        long total = pageInfo.getTotal();
        List<Song> result = pageInfo.getResult();//和上面的users结果相同

        return pageInfo;
    }
    
	// 摇滚音乐分页
    @GetMapping("/song/pageYGSong")
    @Transactional(readOnly = true)
    public Page pageYGSong(@RequestParam Integer page, @RequestParam Integer size) {
        //分页并查询
        Page<Song> pageInfo = PageHelper.startPage(page, size);
        List<Song> songs = songService.listYGSong();
        //获取分页信息演示, 实际项目中一般会封装为自己的返回体。
        int pageNum = pageInfo.getPageNum();
        int pageSize = pageInfo.getPageSize();
        long total = pageInfo.getTotal();
        List<Song> result = pageInfo.getResult();//和上面的users结果相同
        return pageInfo;
    }
    
	// 民谣音乐分页
    @GetMapping("/song/pageMYSong")
    @Transactional(readOnly = true)
    public Page pageMYSong(@RequestParam Integer page, @RequestParam Integer size) {
        //分页并查询
        Page<Song> pageInfo = PageHelper.startPage(page, size);
        List<Song> songs = songService.listMYSong();
        //获取分页信息演示, 实际项目中一般会封装为自己的返回体。
        int pageNum = pageInfo.getPageNum();
        int pageSize = pageInfo.getPageSize();
        long total = pageInfo.getTotal();
        List<Song> result = pageInfo.getResult();//和上面的users结果相同
        return pageInfo;
    }
    
	// 古风音乐分页
    @GetMapping("/song/pageGFSong")
    @Transactional(readOnly = true)
    public Page pageGFSong(@RequestParam Integer page, @RequestParam Integer size) {
        //分页并查询
        Page<Song> pageInfo = PageHelper.startPage(page, size);
        List<Song> songs = songService.listGFSong();
        //获取分页信息演示, 实际项目中一般会封装为自己的返回体。
        int pageNum = pageInfo.getPageNum();
        int pageSize = pageInfo.getPageSize();
        long total = pageInfo.getTotal();
        List<Song> result = pageInfo.getResult();//和上面的users结果相同
        return pageInfo;
    }
    
	// 通过songId查询song
	@RequestMapping("/song/querySongBySongId")
	@ResponseBody
	public Song querySongBySongId(@RequestBody String songid) {
		if(songid == "") {
			return null;
		} else {
			int songId=Integer.parseInt(songid);
			Song song = songService.querySongBySongId(songId);
			System.out.println(song.toString());
			return song;
		}
	}
	
	// 通过userId和songId查询like_song
	@GetMapping("/song/selectLikeSongByUserIdAndSongId")
	@ResponseBody
	public Boolean selectSongByUserIdAndSongId(@RequestParam String userid, @RequestParam String songid) {
		int userId=Integer.parseInt(userid);
		int songId=Integer.parseInt(songid);
		Boolean isGet = songService.selectSongByUserIdAndSongId(userId,songId);
		System.out.println(isGet);
		return isGet;
	}
	
	// 增加like_song,并且对应的songlikenum自动＋1
	@GetMapping("/song/insertLikeSongByUserIdAndSongId")
	@ResponseBody
	public Boolean insertLikeSongByUserIdAndSongId(@RequestParam String userid, @RequestParam String songid) {
		int userId=Integer.parseInt(userid);
		int songId=Integer.parseInt(songid);
		Song song = songService.querySongBySongId(songId);
		String songName = song.getSongName();
		String songAuthor = song.getSongAuthor();
		String songType = song.getSongType();
		String songPic = song.getSongPic();
		String songSong = song.getSongSong();
		Boolean isIsert = songService.insertLikeSong(userId,songId,songName,songAuthor,songType,songPic,songSong);
		songService.updateSongLikeNum(songId);
		System.out.println(isIsert);
		return isIsert;
	}
	
	// 删除like_song,并且对应的songlikenum自动-1
	@GetMapping("/song/deleteLikeSongByUserIdAndSongId")
	@ResponseBody
	public Boolean deleteLikeSongByUserIdAndSongId(@RequestParam String userid, @RequestParam String songid) {
		int userId=Integer.parseInt(userid);
		int songId=Integer.parseInt(songid);
		Boolean isDelete = songService.deleteLikeSong(userId,songId);
		songService.updateSongLikeNum2(songId);
		System.out.println(isDelete);
		return isDelete;
	}
	
	// 通过userId查询like_song并且通过时间降序排序
	@RequestMapping("/song/listLikeSongByUserId")
	@ResponseBody
	public List<LikeSong> listLikeSongByUserId(@RequestBody String userid) {
		int userId=Integer.parseInt(userid);
		List<LikeSong> likesonglist = songService.listLikeSongByUserId(userId);
		System.out.println(likesonglist.toString());
		return likesonglist;
	}
	
	// 增加用户浏览记录或者更新用户浏览记录的时间
	@GetMapping("/song/insertOrUpdateReSong")
	@ResponseBody
	public String insertOrUpdateReSong(@RequestParam String userid, @RequestParam String songid) {
		int userId=Integer.parseInt(userid);
		int songId=Integer.parseInt(songid);
		LikeSong ReSong = songService.selectReSongByUserIdAndSongId(userId,songId);
		System.out.println(ReSong);
		Song song = songService.querySongBySongId(songId);
		String songName = song.getSongName();
		String songAuthor = song.getSongAuthor();
		String songType = song.getSongType();
		String songPic = song.getSongPic();
		String songSong = song.getSongSong();
		if(ReSong==null) {
			Boolean isIsert = songService.insertReSong(userId,songId,songName,songAuthor,songType,songPic,songSong);
			return "insert";
		} else {
			songService.updateReSong(userId,songId);
			return "update";
		}
	}
	
	// 通过userId查询re_song list并且通过时间降序排序
	@RequestMapping("/song/listReSongByUserId")
	@ResponseBody
	public List<LikeSong> listReSongByUserId(@RequestBody String userid) {
		int userId=Integer.parseInt(userid);
		List<LikeSong> likesonglist = songService.listReSongByUserId(userId);
		System.out.println(likesonglist.toString());
		return likesonglist;
	}	
	
	// 通过userId查询song_list list并且通过时间降序排序
	@RequestMapping("/song/listSongListByUserId")
	@ResponseBody
	public List<SongList> listSongListByUserId(@RequestBody String userid) {
		int userId=Integer.parseInt(userid);
		List<SongList> songlistlist = songService.listSongListByUserId(userId);
		System.out.println(songlistlist);
		return songlistlist;
	}
	
	// 增加用户浏览记录或者更新用户浏览记录的时间
	@GetMapping("/song/insertSongListByUserIdAndSongListName")
	@ResponseBody
	public void insertSongListByUserIdAndSongListName(@RequestParam String userid, @RequestParam String songListName) {
		int userId=Integer.parseInt(userid);
		songService.insertSongListByUserIdAndSongListName(userId,songListName);
	}
		
	// 通过user_id song_id wid增加歌单详情
	@GetMapping("/song/insertSongListByUserIdSongIdWid")
	@ResponseBody
	public void insertSongListByUserIdSongIdWid(@RequestParam String userid, @RequestParam String songid, @RequestParam String wid) {
		int userId=Integer.parseInt(userid);
		int songId=Integer.parseInt(songid);
		int id=Integer.parseInt(wid);
		SongList songlist=songService.selectSongListByUserIdSongIdWid(userId,songId,id);
		System.out.println(songlist);
		if (songlist==null) {
			Song song = songService.querySongBySongId(songId);
			String songName = song.getSongName();
			String songAuthor = song.getSongAuthor();
			String songType = song.getSongType();
			String songPic = song.getSongPic();
			String songSong = song.getSongSong();
			songService.insertSongListByUserIdSongIdWid(userId,songId,id,songName,songAuthor,songType,songPic,songSong);
		}
	}
	
	// 通过wid查询song_list_name
	@RequestMapping("/song/querySongListNameByWid")
	@ResponseBody
	public String querySongListNameByWid(@RequestBody String wid) {
		int id=Integer.parseInt(wid);
		String songlistname = songService.querySongListNameByWid(id);
		System.out.println(songlistname.toString());
		return songlistname;
	}	
	
	// 通过userId查询song_list list并且通过时间降序排序
	@GetMapping("/song/listSongListDetailsByUserIdAndSongListId")
	@ResponseBody
	public List<SongList> listSongListDetailsByUserIdAndSongListId(@RequestParam String userid,@RequestParam String wid) {
		int userId=Integer.parseInt(userid);
		int id=Integer.parseInt(wid);
		List<SongList> songlistlist = songService.listSongListDetailsByUserIdAndSongListId(userId,id);
		System.out.println(songlistlist);
		return songlistlist;
	}
	
	// 通过wid删除song_list和song_list_details
	@RequestMapping("/song/deleteSongListAndSongListDetails")
	@ResponseBody
	public void deleteSongListAndSongListDetails(@RequestBody String wid) {
		int id=Integer.parseInt(wid);
		songService.deleteSongListAndSongListDetailsByWid(id);
	}	
	
	// 通过wid删除like_song_list_details或re_song_list_details或song_list_details
	@GetMapping("/song/deleteSongListDetail")
	@ResponseBody
	public void deleteSongListDetail(@RequestParam String params,@RequestParam String wid) {
		int id=Integer.parseInt(wid);
		if (params.equals("我喜欢的音乐")) {
			songService.deleteLikeSongListDetailsByWid(id);
		} else if (params.equals("最近播放")) {
			songService.deleteReSongListDetailsByWid(id);
		} else {
			songService.deleteSongListDetailsByWid(id);
		}
	}
	
	// 通过song_id user_id text插入song_comment_details
	@GetMapping("/song/insertCommentBySongIdUserIdText")
	@ResponseBody
	public void insertCommentBySongIdUserIdText(@RequestParam String songid,@RequestParam String userid,@RequestParam String text) {		
		int songId=Integer.parseInt(songid);
		int userId=Integer.parseInt(userid);
		User user = userService.queryUserByUserId(userId);
		System.out.println(user.toString());
		String userHeadPic = user.getUserPicHead();
		String userName = user.getUserName();
		songService.insertCommentBySongIdUserIdText(songId,userId,text,userHeadPic,userName);
	}
	
	// 通过song_id user_id查询歌曲对应用户的全部的song_comment_details list并且通过点赞数排序
	@GetMapping("/song/listSongCommentDetailsByUserIdAndSongId")
	@ResponseBody
	public List<SongCommentDetails> listSongCommentDetailsByUserIdAndSongId(@RequestParam String userid,@RequestParam String songid) {		
		int songId=Integer.parseInt(songid);
		int userId=Integer.parseInt(userid);
		List<SongCommentDetails> listcomment = songService.listSongCommentDetailsByUserIdAndSongId(songId,userId);
		System.out.println(listcomment.toString());
		return listcomment;
	}
	
	// 通过song_id查询歌曲对应全部的song_comment_details list并且通过点赞数排序
	@GetMapping("/song/listSongCommentDetailsBySongId")
	@ResponseBody
	public List<SongCommentDetails> listSongCommentDetailsBySongId(@RequestParam String songid) {		
		int songId=Integer.parseInt(songid);
		List<SongCommentDetails> listcomment = songService.listSongCommentDetailsBySongId(songId);
		System.out.println(listcomment.toString());
		return listcomment;
	}
	
	// 排行榜
	@RequestMapping("/song/listRanking")
	@ResponseBody
	public List<Song> listRanking() {
		List<Song> songs = songService.listRanking();
		return songs;
	}
		
	// 歌单
	@RequestMapping("/song/listSongList")
	@ResponseBody
	public List<SongList> listSongList() {
		List<SongList> songlists = songService.listSongList();
		return songlists;
	}
	
	// 每日推荐
	@RequestMapping("/song/listDay")
	@ResponseBody
	public List<Everyday> listDay(@RequestBody String userid) {
		int userId=Integer.parseInt(userid);
		List<Everyday> everydaylists = songService.listEverydayByUserId(userId);
		if(everydaylists.isEmpty()) {
			System.out.println("1----------");
			List<Type> type = songService.listTypeSongByUserId(userId);
			for(int i=0;i<type.size();i++) {
				List<Song> listSong = songService.listSongBySongTypeAndNum(type.get(i).getSongType(),type.get(i).getNum());
				for(int j=0;j<listSong.size();j++) {
					songService.insertEveryday(userId,listSong.get(j).getSongId(),listSong.get(j).getSongName(),listSong.get(j).getSongAuthor(),listSong.get(j).getSongType());
				}
			}
			List<Everyday> everydaylists1 = songService.listEverydayByUserId(userId);
			return everydaylists1;
		} else {
			System.out.println("2----------");
			Date date = everydaylists.get(0).getDate();
			System.out.println("everydaylists.get(0)"+everydaylists.get(0));
			System.out.println("date"+date);
			Date d = new Date();
			System.out.println(d);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateNowStr = sdf.format(d);
			String dateSong = sdf.format(date);
			System.out.println("dateNowStr"+dateNowStr);
			System.out.println("dateSong"+dateSong);
			if(!dateSong.equals(dateNowStr)) {
				System.out.println("3----------");
				songService.deleteEverydayByUserId(userId);
				List<Type> type = songService.listTypeSongByUserId(userId);
				for(int i=0;i<type.size();i++) {
					List<Song> listSong = songService.listSongBySongTypeAndNum(type.get(i).getSongType(),type.get(i).getNum());
					for(int j=0;j<listSong.size();j++) {
						songService.insertEveryday(userId,listSong.get(j).getSongId(),listSong.get(j).getSongName(),listSong.get(j).getSongAuthor(),listSong.get(j).getSongType());
					}
				}
				List<Everyday> everydaylists1 = songService.listEverydayByUserId(userId);
				return everydaylists1;
			} else {
				System.out.println("4----------");
				return everydaylists;
			}
		}
	}
	
	// 搜索歌曲
	@RequestMapping("/song/listSearch")
	@ResponseBody
	public List<Song> listSearch(@RequestBody String text) {
		List<Song> songlists = songService.listSearch(text);
		return songlists;
	}
	
	// 获取故事mv list
	@RequestMapping("/song/listGSMv")
	@ResponseBody
	public List<Mv> listGSMv() {
		List<Mv> mvlists = songService.listGSMv();
		return mvlists;
	}
	
	// 获取mv list
	@RequestMapping("/song/listMv")
	@ResponseBody
	public List<Mv> listMv(@RequestBody String index) {
		int i=Integer.parseInt(index);
		String mvType="";
		switch(i){
	    case 0 :
	    	mvType="故事类";
	       break; 
	    case 1 :
	    	mvType="片段类";
	       break;
	    case 2 :
	    	mvType="演唱会";
	       break;
	    case 3 :
	    	mvType="歌舞类";
	       break;
	    case 4 :
	    	mvType="动画类";
	       break;
		}
		List<Mv> mvlists = songService.listMv(mvType);
		return mvlists;
	}
		
	// 获取comment list
	@RequestMapping("/song/listComment")
	@ResponseBody
	public List<Comment> listComment() {
		List<Comment> commentlists = songService.listComment();
		return commentlists;
	}	
	
	// 通过user_id text插入comment
	@GetMapping("/song/insertCommentByUserIdText")
	@ResponseBody
	public void insertCommentByUserIdText(@RequestParam String userid,@RequestParam String text) {
		int userId=Integer.parseInt(userid);
		User user = userService.queryUserByUserId(userId);
		String userHeadPic = user.getUserPicHead();
		String userName = user.getUserName();
		songService.insertCommentByUserIdText(userId,text,userHeadPic,userName);
	}
	
	// 获取用户的comment list
	@RequestMapping("/song/listCommentByUserId")
	@ResponseBody
	public List<Comment> listCommentByUserId(@RequestBody String userid) {
		int userId=Integer.parseInt(userid);
		List<Comment> commentlists = songService.listCommentByUserId(userId);
		return commentlists;
	}	
}
