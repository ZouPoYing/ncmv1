package com.graduation.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.graduation.domain.Comment;
import com.graduation.domain.Everyday;
import com.graduation.domain.LikeSong;
import com.graduation.domain.Mv;
import com.graduation.domain.Song;
import com.graduation.domain.SongCommentDetails;
import com.graduation.domain.SongList;
import com.graduation.domain.Type;

@Mapper
public interface SongMapper {
	
	// 查询流行歌曲清单
	@Select("select * from song where song_type='流行'")
	@Results({
            @Result(property = "songId", column = "song_id"),
			@Result(property = "songName", column = "song_name"),
			@Result(property = "songAuthor", column = "song_author"),
            @Result(property = "songDate", column = "song_data"),
            @Result(property = "songPic", column = "song_pic"), 
            @Result(property = "songType", column = "song_type"),
            @Result(property = "songTime", column = "song_time"),
            @Result(property = "songLikeNum", column = "song_like_num"),
            @Result(property = "songSong", column = "song_song")})
	public List<Song> listLXSong();
	
	// 查询摇滚歌曲清单
	@Select("select * from song where song_type='摇滚'")
	@Results({
            @Result(property = "songId", column = "song_id"),
			@Result(property = "songName", column = "song_name"),
			@Result(property = "songAuthor", column = "song_author"),
            @Result(property = "songDate", column = "song_data"),
            @Result(property = "songPic", column = "song_pic"), 
            @Result(property = "songType", column = "song_type"),
            @Result(property = "songTime", column = "song_time"),
            @Result(property = "songLikeNum", column = "song_like_num"),
            @Result(property = "songSong", column = "song_song") })
	public List<Song> listYGSong();
	
	// 查询民谣歌曲清单
	@Select("select * from song where song_type='民谣'")
	@Results({
            @Result(property = "songId", column = "song_id"),
			@Result(property = "songName", column = "song_name"),
			@Result(property = "songAuthor", column = "song_author"),
            @Result(property = "songDate", column = "song_data"),
            @Result(property = "songPic", column = "song_pic"), 
            @Result(property = "songType", column = "song_type"),
            @Result(property = "songTime", column = "song_time"),
            @Result(property = "songLikeNum", column = "song_like_num"),
            @Result(property = "songSong", column = "song_song") })
	public List<Song> listMYSong();
	
	// 查询古风歌曲清单
	@Select("select * from song where song_type='古风'")
	@Results({
            @Result(property = "songId", column = "song_id"),
			@Result(property = "songName", column = "song_name"),
			@Result(property = "songAuthor", column = "song_author"),
            @Result(property = "songDate", column = "song_data"),
            @Result(property = "songPic", column = "song_pic"), 
            @Result(property = "songType", column = "song_type"),
            @Result(property = "songTime", column = "song_time"),
            @Result(property = "songLikeNum", column = "song_like_num"),
            @Result(property = "songSong", column = "song_song")})
	public List<Song> listGFSong();
	
	// 通过songId查询song
	@Select("select * from song where song_id=#{songId}")
	@Results({
            @Result(property = "songId", column = "song_id"),
			@Result(property = "songName", column = "song_name"),
			@Result(property = "songAuthor", column = "song_author"),
            @Result(property = "songDate", column = "song_data"),
            @Result(property = "songPic", column = "song_pic"), 
            @Result(property = "songType", column = "song_type"),
            @Result(property = "songTime", column = "song_time"),
            @Result(property = "songLikeNum", column = "song_like_num"),
            @Result(property = "songSong", column = "song_song") })
	public Song queryUserByUserId(int songId);

	// 通过userId和songId查询like_song
	@Select("select * from like_song_list_details where user_id=#{userId} and song_id=#{songId}")
	@Results({
			@Result(property = "wid", column = "wid"),
			@Result(property = "userId", column = "user_id"),
            @Result(property = "songId", column = "song_id"),
			@Result(property = "songName", column = "song_name"),
			@Result(property = "songAuthor", column = "song_author"),
            @Result(property = "songDate", column = "song_date"),
            @Result(property = "songPic", column = "song_pic"), 
            @Result(property = "songType", column = "song_type"),
            @Result(property = "songSong", column = "song_song") })
	public Boolean selectSongByUserIdAndSongId(int userId, int songId);

	// 增加like_song
	@Insert("insert into like_song_list_details (user_id,song_id,song_name,song_author,song_type,song_pic,song_song) values (#{userId} ,#{songId} ,#{songName} ,#{songAuthor} ,#{songType} ,#{songPic} ,#{songSong})")
	@Options(useGeneratedKeys=true)
	public Boolean insertLikeSong(@Param("userId") int userId,@Param("songId") int songId,@Param("songName") String songName,@Param("songAuthor") String songAuthor,@Param("songType") String songType,
			@Param("songPic") String songPic,@Param("songSong") String songSong);

	// 对应的songlikenum+1
	@Update("update song set song_like_num=song_like_num+1 where song_id =#{songId}")
	public void updateSongLikeNum(int songId);
	
	// 对应的songlikenum-1
	@Update("update song set song_like_num=song_like_num-1 where song_id =#{songId}")
	public void updateSongLikeNum2(int songId);

	// 删除like_song
	@Delete("delete from like_song_list_details where user_id=#{userId} and song_id=#{songId}")
	public Boolean deleteLikeSong(@Param("userId") int userId,@Param("songId") int songId);
	
	// 通过userId查询like_song list并且按照时间降序排序
	@Select("select * from like_song_list_details where user_id=#{userId} order by song_date desc")
	@Results({
			@Result(property = "wid", column = "wid"),
			@Result(property = "userId", column = "user_id"),
            @Result(property = "songId", column = "song_id"),
			@Result(property = "songName", column = "song_name"),
			@Result(property = "songAuthor", column = "song_author"),
            @Result(property = "songDate", column = "song_date"),
            @Result(property = "songPic", column = "song_pic"), 
            @Result(property = "songType", column = "song_type"),
            @Result(property = "songTime", column = "song_time"),
            @Result(property = "songLikeNum", column = "song_like_num"),
            @Result(property = "songSong", column = "song_song") })
	public List<LikeSong> listLikeSongByUserId(int userId);

	// 通过userId和songId查询re_song
	@Select("select * from re_song_list_details where user_id=#{userId} and song_id=#{songId}")
	@Results({
			@Result(property = "wid", column = "wid"),
			@Result(property = "userId", column = "user_id"),
            @Result(property = "songId", column = "song_id"),
			@Result(property = "songName", column = "song_name"),
			@Result(property = "songAuthor", column = "song_author"),
            @Result(property = "songDate", column = "song_date"),
            @Result(property = "songPic", column = "song_pic"), 
            @Result(property = "songType", column = "song_type"),
            @Result(property = "songSong", column = "song_song") })
	public LikeSong selectReSongByUserIdAndSongId(int userId, int songId);

	// 增加re_song
	@Insert("insert into re_song_list_details (user_id,song_id,song_name,song_author,song_type,song_pic,song_song) values (#{userId} ,#{songId} ,#{songName} ,#{songAuthor} ,#{songType} ,#{songPic} ,#{songSong})")
	@Options(useGeneratedKeys=true)
	public Boolean insertReSong(int userId, int songId, String songName, String songAuthor, String songType,
			String songPic, String songSong);
	
	// 根据user_id和song_id更新re_song
	@Update("update re_song_list_details set song_date=now() where user_id =#{userId} and song_id =#{songId}")
	public void updateReSong(int userId, int songId);
	
	// 通过userId查询re_song list并且按照时间降序排序
	@Select("select * from re_song_list_details where user_id=#{userId} order by song_date desc")
	@Results({
			@Result(property = "wid", column = "wid"),
			@Result(property = "userId", column = "user_id"),
            @Result(property = "songId", column = "song_id"),
			@Result(property = "songName", column = "song_name"),
			@Result(property = "songAuthor", column = "song_author"),
            @Result(property = "songDate", column = "song_date"),
            @Result(property = "songPic", column = "song_pic"), 
            @Result(property = "songType", column = "song_type"),
            @Result(property = "songTime", column = "song_time"),
            @Result(property = "songLikeNum", column = "song_like_num"),
            @Result(property = "songSong", column = "song_song") })
	public List<LikeSong> listReSongByUserId(int userId);

	// 通过userId查询song_list list并且按照时间降序排序
	@Select("select * from song_list_details where user_id=#{userId} and song_list_id is null order by song_date desc")
	@Results({
			@Result(property = "wid", column = "wid"),
			@Result(property = "userId", column = "user_id"),
            @Result(property = "songId", column = "song_id"),
            @Result(property = "songListId", column = "song_list_id"),
			@Result(property = "songListName", column = "song_list_name"),
			@Result(property = "songName", column = "song_name"),
			@Result(property = "songAuthor", column = "song_author"),
            @Result(property = "songDate", column = "song_date"),
            @Result(property = "songPic", column = "song_pic"), 
            @Result(property = "songType", column = "song_type"),
            @Result(property = "songSong", column = "song_song") })
	public List<SongList> listSongListByUserId(int userId);

	// 增加song_list
	@Insert("insert into song_list_details (user_id,song_list_name) values (#{userId} ,#{songListName})")
	@Options(useGeneratedKeys=true)
	public void insertSongListByUserIdAndSongListName(int userId, String songListName);

	// 通过userId songId wid查询song_list
	@Select("select * from song_list_details where user_id=#{userId} and song_id=#{songId} and song_list_id=#{id}")
	@Results({
			@Result(property = "wid", column = "wid"),
			@Result(property = "userId", column = "user_id"),
            @Result(property = "songId", column = "song_id"),
            @Result(property = "songListId", column = "song_list_id"),
			@Result(property = "songListName", column = "song_list_name"),
			@Result(property = "songName", column = "song_name"),
			@Result(property = "songAuthor", column = "song_author"),
            @Result(property = "songDate", column = "song_date"),
            @Result(property = "songPic", column = "song_pic"), 
            @Result(property = "songType", column = "song_type"),
            @Result(property = "songSong", column = "song_song") })
	public SongList selectSongListByUserIdSongIdWid(int userId, int songId, int id);

	// 增加song_list_details
	@Insert("insert into song_list_details (user_id,song_id,song_list_id,song_name,song_author,song_type,song_pic,song_song) values (#{userId} ,#{songId} ,#{id} ,#{songName} ,#{songAuthor} ,#{songType} ,#{songPic} ,#{songSong})")
	@Options(useGeneratedKeys=true)
	public void insertSongListByUserIdSongIdWid(int userId, int songId, int id, String songName, String songAuthor,
			String songType, String songPic, String songSong);

	// 通过wid查询song_list_name
	@Select("select song_list_name from song_list_details where wid=#{id}")
	@Results({
			@Result(property = "songListName", column = "song_list_name") })
	public String querySongListNameByWid(int id);

	// 通过user_id song_list_id查询song_list_details list
	@Select("select * from song_list_details where user_id=#{userId} and song_list_id=#{id} order by song_date desc")
	@Results({
			@Result(property = "wid", column = "wid"),
			@Result(property = "userId", column = "user_id"),
            @Result(property = "songId", column = "song_id"),
            @Result(property = "songListId", column = "song_list_id"),
			@Result(property = "songListName", column = "song_list_name"),
			@Result(property = "songName", column = "song_name"),
			@Result(property = "songAuthor", column = "song_author"),
            @Result(property = "songDate", column = "song_date"),
            @Result(property = "songPic", column = "song_pic"), 
            @Result(property = "songType", column = "song_type"),
            @Result(property = "songSong", column = "song_song") })
	public List<SongList> listSongListDetailsByUserIdAndSongListId(int userId, int id);

	// 通过wid删除song_list和song_list_details
	@Delete("delete from song_list_details where wid=#{id} or song_list_id=#{id}")
	public void deleteSongListAndSongListDetailsByWid(int id);
	
	// 通过wid删除like_song_list_details
	@Delete("delete from like_song_list_details where wid=#{id}")
	public void deleteLikeSongListDetailsByWid(int id);

	// 通过wid删除re_song_list_details
	@Delete("delete from re_song_list_details where wid=#{id}")
	public void deleteReSongListDetailsByWid(int id);

	// 通过wid删除song_list_details
	@Delete("delete from song_list_details where wid=#{id}")
	public void deleteSongListDetailsByWid(int id);
	
	// 增加song_comment_details
	@Insert("insert into song_comment_details (song_id,user_id,user_name,user_head_pic,text) values (#{songId} ,#{userId} ,#{userName} ,#{userHeadPic} ,#{text})")
	@Options(useGeneratedKeys=true)
	public void insertCommentBySongIdUserIdText(int songId, int userId, String text, String userHeadPic,
			String userName);

	// 通过song_id user_id查询歌曲对应用户的全部的song_comment_details list并且通过点赞数排序
	@Select("select wid,song_id,user_id,user_name,DATE_FORMAT(comment_date,'%Y-%m-%d %H:%i:%s') comment_date,user_head_pic,text,praise_num from song_comment_details where user_id=#{userId} and song_id=#{songId} order by praise_num desc")
	@Results({
			@Result(property = "wid", column = "wid"),
            @Result(property = "songId", column = "song_id"),
			@Result(property = "userId", column = "user_id"),
            @Result(property = "userHeadPic", column = "user_head_pic"),
			@Result(property = "text", column = "text"),
			@Result(property = "praiseNum", column = "praise_num"),
			@Result(property = "userName", column = "user_name"),
            @Result(property = "commentDate", column = "comment_date") })
	public List<SongCommentDetails> listSongCommentDetailsByUserIdAndSongId(int songId, int userId);

	// 通过song_id查询歌曲对应全部的song_comment_details list并且通过点赞数排序
	@Select("select wid,song_id,user_id,user_name,DATE_FORMAT(comment_date,'%Y-%m-%d %H:%i:%s') comment_date,user_head_pic,text,praise_num from song_comment_details where song_id=#{songId} order by praise_num desc")
	@Results({
			@Result(property = "wid", column = "wid"),
            @Result(property = "songId", column = "song_id"),
			@Result(property = "userId", column = "user_id"),
            @Result(property = "userHeadPic", column = "user_head_pic"),
			@Result(property = "text", column = "text"),
			@Result(property = "praiseNum", column = "praise_num"),
			@Result(property = "userName", column = "user_name"),
            @Result(property = "commentDate", column = "comment_date") })
	public List<SongCommentDetails> listSongCommentDetailsBySongId(int songId);

	// 排行榜
	@Select("select * from song ORDER BY song_like_num DESC LIMIT 0,10")
	@Results({
            @Result(property = "songId", column = "song_id"),
			@Result(property = "songName", column = "song_name"),
			@Result(property = "songAuthor", column = "song_author"),
            @Result(property = "songDate", column = "song_data"),
            @Result(property = "songPic", column = "song_pic"), 
            @Result(property = "songType", column = "song_type"),
            @Result(property = "songTime", column = "song_time"),
            @Result(property = "songLikeNum", column = "song_like_num"),
            @Result(property = "songSong", column = "song_song")})
	public List<Song> listRanking();
	
	// 歌单
	@Select("select * from song_list_details where song_list_id is null")
	@Results({
			@Result(property = "wid", column = "wid"),
			@Result(property = "userId", column = "user_id"),
            @Result(property = "songId", column = "song_id"),
            @Result(property = "songListId", column = "song_list_id"),
			@Result(property = "songListName", column = "song_list_name"),
			@Result(property = "songName", column = "song_name"),
			@Result(property = "songAuthor", column = "song_author"),
            @Result(property = "songDate", column = "song_date"),
            @Result(property = "songPic", column = "song_pic"), 
            @Result(property = "songType", column = "song_type"),
            @Result(property = "songSong", column = "song_song") })
	public List<SongList> listSongList();

	// 通过user_id查询每日推荐歌单
	@Select("select * from everyday where user_id=#{userId}")
	@Results({
			@Result(property = "wid", column = "wid"),
			@Result(property = "userId", column = "user_id"),
            @Result(property = "songId", column = "song_id"),
            @Result(property = "songName", column = "song_name"),
			@Result(property = "songAuthor", column = "song_author"),
            @Result(property = "date", column = "date"),
            @Result(property = "songType", column = "song_type")})
	public List<Everyday> listEverydayByUserId(int userId);

	// 通过user_id查询每日推荐歌单
		@Select("SELECT\r\n" + 
				"	song_type,\r\n" + 
				"	CONCAT(ROUND(a.cnt / b.sum * 10) ) AS num\r\n" + 
				"FROM\r\n" + 
				"	(\r\n" + 
				"		SELECT\r\n" + 
				"			song_type,\r\n" + 
				"			COUNT(song_type) AS cnt\r\n" + 
				"		FROM\r\n" + 
				"			like_song_list_details\r\n" + 
				"		WHERE\r\n" + 
				"			user_id=#{userId}\r\n" + 
				"		GROUP BY\r\n" + 
				"			song_type\r\n" + 
				"		ORDER BY\r\n" + 
				"			cnt DESC\r\n" + 
				"	) AS a,\r\n" + 
				"	(\r\n" + 
				"		SELECT\r\n" + 
				"			COUNT(*) AS sum\r\n" + 
				"		FROM\r\n" + 
				"			like_song_list_details\r\n" + 
				"	) AS b;")
		@Results({
	            @Result(property = "songType", column = "song_type"),
	            @Result(property = "num", column = "num") })
	public List<Type> listTypeSongByUserId(int userId);

	// 根据歌曲类型随机查询一定数量的歌曲
	@Select("SELECT song_id,song_name,song_author,song_type FROM song WHERE song_type=#{songType} ORDER BY RAND() limit #{num}")
	@Results({
	        @Result(property = "songId", column = "song_id"),
	        @Result(property = "songName", column = "song_name"),
			@Result(property = "songAuthor", column = "song_author"),
	        @Result(property = "songType", column = "song_type")})
	public List<Song> listSongBySongTypeAndNum(String songType, Integer num);

	// 插入歌曲
	@Insert("insert into everyday (user_id, song_id, song_name,song_author,song_type) values (#{userId} ,#{songId} ,#{songName} ,#{songAuthor} ,#{songType})")
	@Options(useGeneratedKeys=true)
	public void insertEveryday(int userId, Integer songId, String songName, String songAuthor, String songType);

	// 通过user_id删除everyday
	@Delete("delete from everyday where user_id=#{userId}")
	public void deleteEverydayByUserId(int userId);
	
	// 搜索歌曲
	@Select("select * from song where song_name like '%${text}%' or song_author like '%${text}%'")
	@Results({
            @Result(property = "songId", column = "song_id"),
			@Result(property = "songName", column = "song_name"),
			@Result(property = "songAuthor", column = "song_author"),
            @Result(property = "songDate", column = "song_data"),
            @Result(property = "songPic", column = "song_pic"), 
            @Result(property = "songType", column = "song_type"),
            @Result(property = "songTime", column = "song_time"),
            @Result(property = "songLikeNum", column = "song_like_num"),
            @Result(property = "songSong", column = "song_song")})
	public List<Song> listSearch(String text);

	// 获取故事mv list
	@Select("select * from mv where mv_type='故事类'")
	@Results({
            @Result(property = "mvId", column = "mv_id"),
			@Result(property = "mvName", column = "mv_name"),
			@Result(property = "mvAuthor", column = "mv_author"),
            @Result(property = "mvDate", column = "mv_data"),
            @Result(property = "mvPic", column = "mv_pic"), 
            @Result(property = "mvType", column = "mv_type"),
            @Result(property = "mvMv", column = "mv_mv"),
            @Result(property = "mvInfo", column = "mv_info")})
	public List<Mv> listGSMv();

	// 获取mv list
	@Select("select * from mv where mv_type=#{mvType}")
	@Results({
            @Result(property = "mvId", column = "mv_id"),
			@Result(property = "mvName", column = "mv_name"),
			@Result(property = "mvAuthor", column = "mv_author"),
            @Result(property = "mvDate", column = "mv_data"),
            @Result(property = "mvPic", column = "mv_pic"), 
            @Result(property = "mvType", column = "mv_type"),
            @Result(property = "mvMv", column = "mv_mv"),
            @Result(property = "mvInfo", column = "mv_info")})
	public List<Mv> listMv(String mvType);

	// 获取comment list
	@Select("select * from comment")
	@Results({
            @Result(property = "wid", column = "wid"),
			@Result(property = "userId", column = "user_id"),
			@Result(property = "userName", column = "user_name"),
            @Result(property = "userHeadPic", column = "user_head_pic"),
            @Result(property = "comment", column = "comment"), 
            @Result(property = "commentDate", column = "comment_date")})
	public List<Comment> listComment();

	// 增加comment
	@Insert("insert into comment (user_id,user_name,user_head_pic,comment) values (#{userId} ,#{userName} ,#{userHeadPic} ,#{text})")
	@Options(useGeneratedKeys=true)
	public void insertCommentByUserIdText(int userId, String text, String userHeadPic, String userName);

	// 获取comment list
	@Select("select * from comment where user_id=#{userId}")
	@Results({
            @Result(property = "wid", column = "wid"),
			@Result(property = "userId", column = "user_id"),
			@Result(property = "userName", column = "user_name"),
            @Result(property = "userHeadPic", column = "user_head_pic"),
            @Result(property = "comment", column = "comment"), 
            @Result(property = "commentDate", column = "comment_date")})
	public List<Comment> listCommentByUserId(int userId);
}
