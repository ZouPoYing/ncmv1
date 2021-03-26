/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : ncm

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2020-06-16 12:17:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for app
-- ----------------------------
DROP TABLE IF EXISTS `app`;
CREATE TABLE `app` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id，没啥意义，就是搞个主键',
  `img` varchar(255) DEFAULT NULL COMMENT '图片路径',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `link` varchar(255) DEFAULT NULL COMMENT '链接',
  `type` varchar(255) DEFAULT NULL COMMENT '类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of app
-- ----------------------------
INSERT INTO `app` VALUES ('1', 'app/banners/banners1.jpg', null, null, 'banner');
INSERT INTO `app` VALUES ('2', 'app/banners/banners2.jpg', null, null, 'banner');
INSERT INTO `app` VALUES ('3', 'app/banners/banners3.jpg', null, null, 'banner');
INSERT INTO `app` VALUES ('4', 'app/banners/banners4.jpg', null, null, 'banner');
INSERT INTO `app` VALUES ('5', 'app/banners/banners5.jpg', null, null, 'banner');
INSERT INTO `app` VALUES ('6', 'app/banners/banners6.jpg', null, null, 'banner');
INSERT INTO `app` VALUES ('7', 'app/recommends/每日推荐.png', '每日推荐', null, 'recommend');
INSERT INTO `app` VALUES ('8', 'app/recommends/歌单.png', '歌单', null, 'recommend');
INSERT INTO `app` VALUES ('9', 'app/recommends/排行榜.png', '排行榜', null, 'recommend');
INSERT INTO `app` VALUES ('10', 'app/recommends/电台.png', '电台', null, 'recommend');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `wid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` varchar(255) DEFAULT NULL COMMENT '用户id',
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户姓名',
  `user_head_pic` varchar(255) DEFAULT 'head/head.jpg' COMMENT '用户头像',
  `comment` varchar(255) DEFAULT NULL COMMENT '评论',
  `comment_date` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '评论时间',
  PRIMARY KEY (`wid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '4', '网易云音乐fans', 'head/head.jpg', '测试', '2020-05-20 02:26:51');
INSERT INTO `comment` VALUES ('2', '4', '网易云音乐fans', 'head/head.jpg', '多测试几个', '2020-05-20 02:31:12');
INSERT INTO `comment` VALUES ('3', '4', '网易云音乐fans', 'head/head.jpg', '在测试', '2020-05-20 02:31:22');
INSERT INTO `comment` VALUES ('4', '4', '网易云音乐fans', 'head/head.jpg', '测试测试', '2020-05-20 02:31:26');
INSERT INTO `comment` VALUES ('5', '1', '邹平', 'head/head1.jpeg', '换一个用户测试', '2020-05-20 02:44:42');
INSERT INTO `comment` VALUES ('6', '1', '邹平', 'head/head1.jpeg', '再发一个', '2020-05-20 02:45:50');
INSERT INTO `comment` VALUES ('7', '1', '邹平', 'head/head1.jpeg', '再来一次', '2020-05-20 02:46:28');
INSERT INTO `comment` VALUES ('8', '1', '邹平', 'head/head1.jpeg', '测试测试', '2020-05-20 02:46:38');

-- ----------------------------
-- Table structure for comment_praise_details
-- ----------------------------
DROP TABLE IF EXISTS `comment_praise_details`;
CREATE TABLE `comment_praise_details` (
  `wid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `song_id` int(11) DEFAULT NULL COMMENT '歌曲id',
  `comment_id` int(11) DEFAULT NULL COMMENT '评论id',
  PRIMARY KEY (`wid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment_praise_details
-- ----------------------------

-- ----------------------------
-- Table structure for everyday
-- ----------------------------
DROP TABLE IF EXISTS `everyday`;
CREATE TABLE `everyday` (
  `wid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `song_id` int(11) DEFAULT NULL COMMENT '歌曲id',
  `song_name` varchar(255) DEFAULT NULL COMMENT '歌曲名',
  `song_author` varchar(255) DEFAULT NULL COMMENT '歌曲作者',
  `date` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '每日推荐时间',
  `song_type` varchar(255) DEFAULT NULL COMMENT '歌曲类型',
  PRIMARY KEY (`wid`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of everyday
-- ----------------------------
INSERT INTO `everyday` VALUES ('74', '4', '2', '嗜好', '颜人中', '2020-05-19 23:24:21', '流行');
INSERT INTO `everyday` VALUES ('75', '4', '21', '雪花谣', '许嵩', '2020-05-19 23:24:21', '流行');
INSERT INTO `everyday` VALUES ('76', '4', '32', '最佳歌手', '许嵩', '2020-05-19 23:24:21', '流行');
INSERT INTO `everyday` VALUES ('77', '4', '18', '通关', '许嵩', '2020-05-19 23:24:21', '流行');
INSERT INTO `everyday` VALUES ('78', '4', '31', '玫瑰花的葬礼', '许嵩', '2020-05-19 23:24:21', '流行');
INSERT INTO `everyday` VALUES ('79', '4', '33', '怒放的生命', '汪峰', '2020-05-19 23:24:21', '摇滚');
INSERT INTO `everyday` VALUES ('80', '4', '35', 'Bohemian Rhapsody', 'Queen', '2020-05-19 23:24:21', '摇滚');
INSERT INTO `everyday` VALUES ('81', '4', '34', 'Another One Bites the Dust', 'Queen', '2020-05-19 23:24:21', '摇滚');

-- ----------------------------
-- Table structure for like_song_list_details
-- ----------------------------
DROP TABLE IF EXISTS `like_song_list_details`;
CREATE TABLE `like_song_list_details` (
  `wid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'wid主键',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `song_id` int(11) DEFAULT NULL COMMENT '歌曲id',
  `song_name` varchar(255) DEFAULT NULL COMMENT '歌曲名',
  `song_author` varchar(255) DEFAULT NULL COMMENT '歌曲作者',
  `song_date` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '时间',
  `song_pic` varchar(255) DEFAULT 'song/song.jpg' COMMENT '歌曲封面',
  `song_type` varchar(255) DEFAULT NULL COMMENT '歌曲类型',
  `song_song` varchar(255) DEFAULT 'mp3/song.mp3' COMMENT '歌曲mp3静态资源路径',
  PRIMARY KEY (`wid`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of like_song_list_details
-- ----------------------------
INSERT INTO `like_song_list_details` VALUES ('1', '4', '1', '爱我别走', '张震岳', '2020-05-13 01:01:53', 'song/song1.jpg', '流行', 'mp3/song1.mp3');
INSERT INTO `like_song_list_details` VALUES ('12', '4', '2', '嗜好', '颜人中', '2020-05-12 02:30:11', 'song/song2.jpg', '流行', 'mp3/song2.mp3');
INSERT INTO `like_song_list_details` VALUES ('13', '8', '7', '外面的世界', '莫文蔚', '2020-05-12 03:32:47', 'song/song7.jpg', '流行', 'mp3/song7.mp3');
INSERT INTO `like_song_list_details` VALUES ('17', '4', '34', 'Another One Bites the Dust', 'Queen', '2020-05-19 21:51:45', 'song/song34.jpg', '摇滚', 'mp3/song34.mp3');
INSERT INTO `like_song_list_details` VALUES ('18', '4', '15', '再见', 'G.E.M.邓紫棋', '2020-05-20 01:36:36', 'song/song9.jpg', '流行', 'mp3/song15.mp3');
INSERT INTO `like_song_list_details` VALUES ('19', '4', '3', '麻雀', '李荣浩', '2020-05-20 11:58:45', 'song/song3.jpg', '流行', 'mp3/song3.mp3');
INSERT INTO `like_song_list_details` VALUES ('20', '4', '12', '绿色', '陈雪凝', '2020-05-20 12:00:18', 'song/song12.jpg', '流行', 'mp3/song12.mp3');

-- ----------------------------
-- Table structure for mv
-- ----------------------------
DROP TABLE IF EXISTS `mv`;
CREATE TABLE `mv` (
  `mv_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'mv名',
  `mv_name` varchar(255) DEFAULT NULL,
  `mv_author` varchar(255) DEFAULT 'mv作者' COMMENT 'mv作者',
  `mv_info` varchar(255) DEFAULT NULL COMMENT 'mv内容简介',
  `mv_date` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT 'mv创作时间',
  `mv_pic` varchar(255) DEFAULT 'mv/mvPic.jpg' COMMENT 'mv封面',
  `mv_type` varchar(255) DEFAULT '故事类' COMMENT 'mv类型',
  `mv_mv` varchar(255) DEFAULT 'mv/mv.mp4' COMMENT 'mv静态资源路径',
  PRIMARY KEY (`mv_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mv
-- ----------------------------
INSERT INTO `mv` VALUES ('1', '多余的解释', '许嵩', '音乐纯粹，爱V绝对', '2020-05-20 00:39:31', 'mv/mvPic.jpg', '故事类', 'mv/mv1.mp4');
INSERT INTO `mv` VALUES ('2', '素颜', '许嵩', '音乐纯粹，爱V绝对', '2020-05-20 00:39:56', 'mv/mvPic.jpg', '片段类', 'mv/mv2.mp4');
INSERT INTO `mv` VALUES ('3', '庐州月', '许嵩', '音乐纯粹，爱V绝对', '2020-05-20 00:41:47', 'mv/mvPic.jpg', '动画类', 'mv/mv3.mp4');
INSERT INTO `mv` VALUES ('4', '玫瑰花的葬礼', '许嵩', '音乐纯粹，爱V绝对', '2020-05-20 00:43:55', 'mv/mvPic.jpg', '歌舞类', 'mv/mv4.mp4');
INSERT INTO `mv` VALUES ('5', '燕归巢', '许嵩', '音乐纯粹，爱V绝对', '2020-05-20 00:43:46', 'mv/mvPic.jpg', '演唱会', 'mv/mv5.mp4');

-- ----------------------------
-- Table structure for re_song_list_details
-- ----------------------------
DROP TABLE IF EXISTS `re_song_list_details`;
CREATE TABLE `re_song_list_details` (
  `wid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'wid主键无实际意义',
  `user_id` int(11) DEFAULT NULL COMMENT '对应的用户id',
  `song_id` int(11) DEFAULT NULL COMMENT '对应的歌曲id',
  `song_name` varchar(255) DEFAULT NULL COMMENT '歌曲名字',
  `song_author` varchar(255) DEFAULT NULL COMMENT '歌曲作者',
  `song_date` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '加入时间',
  `song_pic` varchar(255) DEFAULT 'song/song.jpg' COMMENT '图片路径',
  `song_type` varchar(255) DEFAULT '流行' COMMENT '歌曲类型',
  `song_song` varchar(255) DEFAULT 'mp3/song.mp3' COMMENT '歌曲路径',
  PRIMARY KEY (`wid`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of re_song_list_details
-- ----------------------------
INSERT INTO `re_song_list_details` VALUES ('1', '1', '1', '爱我别走', '张震岳', '2020-05-12 21:25:08', 'song/song1.jpg', '流行', 'mp3/song1.mp3');
INSERT INTO `re_song_list_details` VALUES ('3', '4', '2', '嗜好', '颜人中', '2020-05-20 12:07:54', 'song/song2.jpg', '流行', 'mp3/song2.mp3');
INSERT INTO `re_song_list_details` VALUES ('4', '4', '4', '夜夜夜夜', '齐秦', '2020-05-16 22:32:33', 'song/song4.jpg', '流行', 'mp3/song4.mp3');
INSERT INTO `re_song_list_details` VALUES ('5', '4', '1', '爱我别走', '张震岳', '2020-05-20 01:36:27', 'song/song1.jpg', '流行', 'mp3/song1.mp3');
INSERT INTO `re_song_list_details` VALUES ('7', '4', '5', '左手指月', '萨顶顶', '2020-05-23 18:21:18', 'song/song5.jpg', '流行', 'mp3/song5.mp3');
INSERT INTO `re_song_list_details` VALUES ('10', '4', '9', '来自天堂的魔鬼', 'G.E.M.邓紫棋', '2020-05-13 22:57:37', 'song/song9.jpg', '流行', 'mp3/song9.mp3');
INSERT INTO `re_song_list_details` VALUES ('11', '4', '18', '通关', '许嵩', '2020-05-14 22:37:33', 'song/song18.jpg', '流行', 'mp3/song18.mp3');
INSERT INTO `re_song_list_details` VALUES ('12', '4', '43', '红昭愿', '音阙诗听', '2020-05-13 22:58:00', 'song/song43.jpg', '古风', 'mp3/song43.mp3');
INSERT INTO `re_song_list_details` VALUES ('13', '4', '16', '烦恼歌', '张学友', '2020-05-14 09:03:57', 'song/song16.jpg', '流行', 'mp3/song16.mp3');
INSERT INTO `re_song_list_details` VALUES ('14', '4', '42', '山水之间', '许嵩', '2020-05-13 23:01:58', 'song/song42.jpg', '古风', 'mp3/song42.mp3');
INSERT INTO `re_song_list_details` VALUES ('15', '4', '6', '狂浪', '花姐', '2020-05-13 23:11:28', 'song/song6.jpg', '流行', 'mp3/song6.mp3');
INSERT INTO `re_song_list_details` VALUES ('16', '4', '8', '你的酒馆对我打了烊', '陈雪凝', '2020-05-14 22:55:46', 'song/song8.jpg', '流行', 'mp3/song8.mp3');
INSERT INTO `re_song_list_details` VALUES ('17', '4', '19', '艺术家们', '许嵩', '2020-05-13 23:11:40', 'song/song19.jpg', '流行', 'mp3/song19.mp3');
INSERT INTO `re_song_list_details` VALUES ('18', '4', '3', '麻雀', '李荣浩', '2020-05-20 11:59:27', 'song/song3.jpg', '流行', 'mp3/song3.mp3');
INSERT INTO `re_song_list_details` VALUES ('19', '4', '40', '燕归巢', '许嵩', '2020-05-14 00:40:17', 'song/song32.jpg', '古风', 'mp3/song40.mp3');
INSERT INTO `re_song_list_details` VALUES ('22', '4', '34', 'Another One Bites the Dust', 'Queen', '2020-05-19 23:29:21', 'song/song34.jpg', '摇滚', 'mp3/song34.mp3');
INSERT INTO `re_song_list_details` VALUES ('23', '4', '36', '理想三旬', '陈泓宇', '2020-05-14 14:13:23', 'song/song36.jpg', '民谣', 'mp3/song36.mp3');
INSERT INTO `re_song_list_details` VALUES ('24', '4', '10', '那女孩对我说', '梁文音', '2020-05-14 21:05:20', 'song/song10.jpg', '流行', 'mp3/song10.mp3');
INSERT INTO `re_song_list_details` VALUES ('26', '4', '21', '雪花谣', '许嵩', '2020-05-14 22:37:50', 'song/song21.jpg', '流行', 'mp3/song21.mp3');
INSERT INTO `re_song_list_details` VALUES ('27', '4', '15', '再见', 'G.E.M.邓紫棋', '2020-05-26 11:59:53', 'song/song9.jpg', '流行', 'mp3/song15.mp3');
INSERT INTO `re_song_list_details` VALUES ('28', '4', '7', '外面的世界', '莫文蔚', '2020-05-16 22:32:16', 'song/song7.jpg', '流行', 'mp3/song7.mp3');
INSERT INTO `re_song_list_details` VALUES ('29', '1', '15', '再见', 'G.E.M.邓紫棋', '2020-05-16 22:49:31', 'song/song9.jpg', '流行', 'mp3/song15.mp3');
INSERT INTO `re_song_list_details` VALUES ('30', '4', '17', '如果当时', '许嵩', '2020-05-20 00:06:23', 'song/song17.jpg', '流行', 'mp3/song17.mp3');
INSERT INTO `re_song_list_details` VALUES ('31', '4', '12', '绿色', '陈雪凝', '2020-05-20 12:00:16', 'song/song12.jpg', '流行', 'mp3/song12.mp3');
INSERT INTO `re_song_list_details` VALUES ('32', '4', '22', '星座书上', '许嵩', '2020-05-20 12:07:11', 'song/song17.jpg', '流行', 'mp3/song22.mp3');
INSERT INTO `re_song_list_details` VALUES ('33', '4', '23', '有何不可', '许嵩', '2020-05-20 12:00:50', 'song/song17.jpg', '流行', 'mp3/song23.mp3');
INSERT INTO `re_song_list_details` VALUES ('34', '4', '14', '我曾', '隔壁老樊', '2020-05-20 12:11:53', 'song/song14.jpg', '流行', 'mp3/song14.mp3');

-- ----------------------------
-- Table structure for song
-- ----------------------------
DROP TABLE IF EXISTS `song`;
CREATE TABLE `song` (
  `song_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '歌曲id',
  `song_name` varchar(255) DEFAULT NULL COMMENT '歌曲名',
  `song_author` varchar(255) DEFAULT NULL COMMENT '歌曲作者',
  `song_data` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '创作时间',
  `song_pic` varchar(255) DEFAULT 'song/song.jpg' COMMENT '封面图片路径',
  `song_type` varchar(255) DEFAULT '' COMMENT '歌曲类型',
  `song_time` varchar(255) DEFAULT NULL COMMENT '时长',
  `song_like_num` int(11) DEFAULT 0 COMMENT '喜爱数量',
  `song_song` varchar(255) DEFAULT 'mp3/song.mp3' COMMENT 'mp3',
  PRIMARY KEY (`song_id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of song
-- ----------------------------
INSERT INTO `song` VALUES ('1', '爱我别走', '张震岳', '2020-05-12 00:30:23', 'song/song1.jpg', '流行', '04:44', '1', 'mp3/song1.mp3');
INSERT INTO `song` VALUES ('2', '嗜好', '颜人中', '2020-05-12 02:30:11', 'song/song2.jpg', '流行', '04:44', '1', 'mp3/song2.mp3');
INSERT INTO `song` VALUES ('3', '麻雀', '李荣浩', '2020-05-20 11:58:45', 'song/song3.jpg', '流行', '04:12', '1', 'mp3/song3.mp3');
INSERT INTO `song` VALUES ('4', '夜夜夜夜', '齐秦', '2020-05-12 01:56:58', 'song/song4.jpg', '流行', '04:57', '1', 'mp3/song4.mp3');
INSERT INTO `song` VALUES ('5', '左手指月', '萨顶顶', '2020-05-10 00:00:00', 'song/song5.jpg', '流行', '03:50', '0', 'mp3/song5.mp3');
INSERT INTO `song` VALUES ('6', '狂浪', '花姐', '2020-05-10 00:00:00', 'song/song6.jpg', '流行', '03:01', '0', 'mp3/song6.mp3');
INSERT INTO `song` VALUES ('7', '外面的世界', '莫文蔚', '2020-05-12 03:32:47', 'song/song7.jpg', '流行', '04:33', '1', 'mp3/song7.mp3');
INSERT INTO `song` VALUES ('8', '你的酒馆对我打了烊', '陈雪凝', '2020-05-12 03:34:37', 'song/song8.jpg', '流行', '04:11', '0', 'mp3/song8.mp3');
INSERT INTO `song` VALUES ('9', '来自天堂的魔鬼', 'G.E.M.邓紫棋', '2020-05-10 00:00:00', 'song/song9.jpg', '流行', '04:05', '0', 'mp3/song9.mp3');
INSERT INTO `song` VALUES ('10', '那女孩对我说', '梁文音', '2020-05-10 00:00:00', 'song/song10.jpg', '流行', '04:28', '0', 'mp3/song10.mp3');
INSERT INTO `song` VALUES ('11', '红色高跟鞋', '蔡健雅', '2020-05-10 00:00:00', 'song/song11.jpg', '流行', '03:26', '0', 'mp3/song11.mp3');
INSERT INTO `song` VALUES ('12', '绿色', '陈雪凝', '2020-05-20 12:00:18', 'song/song12.jpg', '流行', '04:29', '2', 'mp3/song12.mp3');
INSERT INTO `song` VALUES ('13', '还有多少个十年', '叶圣涛', '2020-05-10 00:00:00', 'song/song13.jpg', '流行', '04:12', '0', 'mp3/song13.mp3');
INSERT INTO `song` VALUES ('14', '我曾', '隔壁老樊', '2020-05-14 22:01:46', 'song/song14.jpg', '流行', '04:45', '0', 'mp3/song14.mp3');
INSERT INTO `song` VALUES ('15', '再见', 'G.E.M.邓紫棋', '2020-05-20 01:36:36', 'song/song9.jpg', '流行', '03:26', '1', 'mp3/song15.mp3');
INSERT INTO `song` VALUES ('16', '烦恼歌', '张学友', '2020-05-10 00:00:00', 'song/song16.jpg', '流行', '04:14', '0', 'mp3/song16.mp3');
INSERT INTO `song` VALUES ('17', '如果当时', '许嵩', '2020-05-10 00:00:00', 'song/song17.jpg', '流行', '05:16', '0', 'mp3/song17.mp3');
INSERT INTO `song` VALUES ('18', '通关', '许嵩', '2020-05-10 00:00:00', 'song/song18.jpg', '流行', '04:09', '0', 'mp3/song18.mp3');
INSERT INTO `song` VALUES ('19', '艺术家们', '许嵩', '2020-05-10 00:00:00', 'song/song19.jpg', '流行', '03:34', '0', 'mp3/song19.mp3');
INSERT INTO `song` VALUES ('20', '医生', '许嵩', '2020-05-10 00:00:00', 'song/song20.jpg', '流行', '04:06', '0', 'mp3/song20.mp3');
INSERT INTO `song` VALUES ('21', '雪花谣', '许嵩', '2020-05-10 00:00:00', 'song/song21.jpg', '流行', '04:26', '0', 'mp3/song21.mp3');
INSERT INTO `song` VALUES ('22', '星座书上', '许嵩', '2020-05-20 12:00:27', 'song/song17.jpg', '流行', '03:58', '1', 'mp3/song22.mp3');
INSERT INTO `song` VALUES ('23', '有何不可', '许嵩', '2020-05-20 12:00:31', 'song/song17.jpg', '流行', '04:01', '1', 'mp3/song23.mp3');
INSERT INTO `song` VALUES ('24', '秋千坠', '许嵩', '2020-05-10 00:00:00', 'song/song.jpg', '流行', '04:16', '0', 'mp3/song24.mp3');
INSERT INTO `song` VALUES ('25', '安徒生不后悔', '许嵩', '2020-05-10 00:00:00', 'song/song25.jpg', '流行', '03:49', '0', 'mp3/song25.mp3');
INSERT INTO `song` VALUES ('26', '遛你玩', '许嵩', '2020-05-10 00:00:00', 'song/song.jpg', '流行', '03:23', '0', 'mp3/song26.mp3');
INSERT INTO `song` VALUES ('27', '别咬我', '许嵩', '2020-05-10 00:00:00', 'song/song.jpg', '流行', '04:02', '0', 'mp3/song27.mp3');
INSERT INTO `song` VALUES ('28', '天使', '许嵩', '2020-05-10 00:00:00', 'song/song25.jpg', '流行', '03:48', '0', 'mp3/song28.mp3');
INSERT INTO `song` VALUES ('29', '看不见的风景', '许嵩', '2020-05-10 00:00:00', 'song/song25.jpg', '流行', '04:37', '0', 'mp3/song29.mp3');
INSERT INTO `song` VALUES ('30', '多余的解释', '许嵩', '2020-05-10 00:00:00', 'song/song17.jpg', '流行', '04:37', '0', 'mp3/song30.mp3');
INSERT INTO `song` VALUES ('31', '玫瑰花的葬礼', '许嵩', '2020-05-10 00:00:00', 'song/song31.jpg', '流行', '04:19', '0', 'mp3/song31.mp3');
INSERT INTO `song` VALUES ('32', '最佳歌手', '许嵩', '2020-05-10 00:00:00', 'song/song32.jpg', '流行', '04:27', '0', 'mp3/song32.mp3');
INSERT INTO `song` VALUES ('33', '怒放的生命', '汪峰', '2020-05-10 00:00:00', 'song/song33.jpg', '摇滚', '04:35', '0', 'mp3/song33.mp3');
INSERT INTO `song` VALUES ('34', 'Another One Bites the Dust', 'Queen', '2020-05-19 21:51:45', 'song/song34.jpg', '摇滚', '03:35', '1', 'mp3/song34.mp3');
INSERT INTO `song` VALUES ('35', 'Bohemian Rhapsody', 'Queen', '2020-05-10 00:00:00', 'song/song35.jpg', '摇滚', '05:56', '0', 'mp3/song35.mp3');
INSERT INTO `song` VALUES ('36', '理想三旬', '陈泓宇', '2020-05-10 00:00:00', 'song/song36.jpg', '民谣', '03:30', '0', 'mp3/song36.mp3');
INSERT INTO `song` VALUES ('37', '奇妙能力歌', '陈粒', '2020-05-10 00:00:00', 'song/song37.jpg', '民谣', '04:13', '0', 'mp3/song37.mp3');
INSERT INTO `song` VALUES ('38', '白莲', '翁大涵', '2020-05-10 00:00:00', 'song/song38.jpg', '民谣', '04:05', '0', 'mp3/song38.mp3');
INSERT INTO `song` VALUES ('39', '雨幕', '许嵩', '2020-05-10 00:00:00', 'song/song39.jpg', '古风', '04:00', '0', 'mp3/song39.mp3');
INSERT INTO `song` VALUES ('40', '燕归巢', '许嵩', '2020-05-10 00:00:00', 'song/song32.jpg', '古风', '04:54', '0', 'mp3/song40.mp3');
INSERT INTO `song` VALUES ('41', '弹指一挥间', '许嵩', '2020-05-10 00:00:00', 'song/song41.jpg', '古风', '04:47', '0', 'mp3/song41.mp3');
INSERT INTO `song` VALUES ('42', '山水之间', '许嵩', '2020-05-10 00:00:00', 'song/song42.jpg', '古风', '04:36', '0', 'mp3/song42.mp3');
INSERT INTO `song` VALUES ('43', '红昭愿', '音阙诗听', '2020-05-10 00:00:00', 'song/song43.jpg', '古风', '02:53', '0', 'mp3/song43.mp3');
INSERT INTO `song` VALUES ('44', 'We Will Rock You', 'Queen', '2020-05-20 02:56:51', 'song/song44.jpg', '摇滚', null, '0', 'mp3/song44.mp3');
INSERT INTO `song` VALUES ('45', 'Taibian ', 'Queen', '2020-05-20 03:18:21', 'song/song45.jpg', '摇滚', null, '0', 'mp3/song45.mp3');
INSERT INTO `song` VALUES ('46', '我管你', '华晨宇', '2020-05-20 03:18:22', 'song/song46.jpg', '摇滚', null, '0', 'mp3/song46.mp3');
INSERT INTO `song` VALUES ('47', '奇迹再现', '毛华锋 ', '2020-05-20 03:18:23', 'song/song.jpg', '摇滚', null, '0', 'mp3/song47.mp3');
INSERT INTO `song` VALUES ('48', '夜空中最亮的星', '逃跑计划', '2020-05-20 03:18:23', 'song/song48.jpg', '摇滚', null, '0', 'mp3/song48.mp3');
INSERT INTO `song` VALUES ('49', '像梦一样自由', '汪峰', '2020-05-20 03:18:24', 'song/song49.jpg', '摇滚', null, '0', 'mp3/song49.mp3');
INSERT INTO `song` VALUES ('50', '生活不止眼前的苟且', '许巍 ', '2020-05-20 03:18:24', 'song/song50.jpg', '摇滚', null, '0', 'mp3/song50.mp3');
INSERT INTO `song` VALUES ('51', '私奔', '郑钧', '2020-05-20 03:18:27', 'song/song51.jpg', '摇滚', null, '0', 'mp3/song51.mp3');
INSERT INTO `song` VALUES ('52', '暗河', '冯佳界 ', '2020-05-20 03:22:52', 'song/song52.jpg', '民谣', null, '0', 'mp3/song52.mp3');
INSERT INTO `song` VALUES ('53', '贤良', '苏阳乐队', '2020-05-20 03:23:29', 'song/song53.jpg', '民谣', null, '0', 'mp3/song53.mp3');

-- ----------------------------
-- Table structure for song_comment_details
-- ----------------------------
DROP TABLE IF EXISTS `song_comment_details`;
CREATE TABLE `song_comment_details` (
  `wid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'wid主键',
  `song_id` int(11) DEFAULT NULL COMMENT '歌曲id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户名字',
  `comment_date` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '评论时间',
  `user_head_pic` varchar(255) DEFAULT '' COMMENT '用户头像路径',
  `text` varchar(255) DEFAULT '' COMMENT '评论内容',
  `praise_num` int(11) DEFAULT 0 COMMENT '点赞数量',
  PRIMARY KEY (`wid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of song_comment_details
-- ----------------------------
INSERT INTO `song_comment_details` VALUES ('1', '15', '4', '网易云音乐fans', '2020-05-14 23:27:44', 'head/head.jpg', 'test', '0');
INSERT INTO `song_comment_details` VALUES ('2', '15', '4', '网易云音乐fans', '2020-05-15 00:49:30', 'head/head.jpg', '测试实时刷新评论', '0');
INSERT INTO `song_comment_details` VALUES ('3', '17', '4', '网易云音乐fans', '2020-05-20 00:06:33', 'head/head.jpg', '测试评论1', '0');
INSERT INTO `song_comment_details` VALUES ('4', '15', '4', '网易云音乐fans', '2020-05-20 12:13:23', 'head/head.jpg', '11111', '0');

-- ----------------------------
-- Table structure for song_list_details
-- ----------------------------
DROP TABLE IF EXISTS `song_list_details`;
CREATE TABLE `song_list_details` (
  `wid` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增列为主键',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `song_id` int(11) DEFAULT NULL COMMENT '歌曲id',
  `song_list_id` int(11) DEFAULT NULL COMMENT '歌单id',
  `song_list_name` varchar(255) DEFAULT NULL COMMENT '歌单名',
  `song_name` varchar(255) DEFAULT NULL COMMENT '歌曲名字',
  `song_author` varchar(255) DEFAULT '' COMMENT '歌曲作者',
  `song_date` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '时间',
  `song_pic` varchar(255) DEFAULT NULL COMMENT '图片路径',
  `song_type` varchar(255) DEFAULT NULL COMMENT '歌曲类型',
  `song_song` varchar(255) DEFAULT NULL COMMENT '歌曲路径',
  PRIMARY KEY (`wid`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of song_list_details
-- ----------------------------
INSERT INTO `song_list_details` VALUES ('10', '4', null, null, '踩踩踩踩踩', null, null, '2020-05-13 14:06:25', null, null, null);
INSERT INTO `song_list_details` VALUES ('12', '4', null, null, 'test', null, null, '2020-05-13 15:16:43', null, null, null);
INSERT INTO `song_list_details` VALUES ('13', '4', null, null, 'test1', null, null, '2020-05-13 15:18:06', null, null, null);
INSERT INTO `song_list_details` VALUES ('14', '4', null, null, 'test2', null, null, '2020-05-13 15:19:30', null, null, null);
INSERT INTO `song_list_details` VALUES ('36', '4', '7', '14', null, '外面的世界', '莫文蔚', '2020-05-14 00:40:11', 'song/song7.jpg', '流行', 'mp3/song7.mp3');
INSERT INTO `song_list_details` VALUES ('39', '4', '14', '14', null, '我曾', '隔壁老樊', '2020-05-14 09:03:01', 'song/song14.jpg', '流行', 'mp3/song14.mp3');
INSERT INTO `song_list_details` VALUES ('49', '4', '18', '14', null, '通关', '许嵩', '2020-05-14 22:37:45', 'song/song18.jpg', '流行', 'mp3/song18.mp3');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(255) DEFAULT '网易云音乐用户' COMMENT '用户姓名',
  `user_password` varchar(255) NOT NULL COMMENT '用户密码',
  `user_email` varchar(255) NOT NULL COMMENT '用户邮箱',
  `user_pic_head` varchar(255) DEFAULT 'head/head.jpg' COMMENT '用户头像地址',
  `user_type` varchar(255) DEFAULT '用户' COMMENT '用户类型',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '邹平', '123456', '123@qq.com', 'head/head1.jpeg', '管理员');
INSERT INTO `user` VALUES ('2', 'zp', '123456', '321@qq.com', 'head/head2.jpg', '用户');
INSERT INTO `user` VALUES ('3', '网易云音乐用户', '123456', '3@qq.com', 'head/head.jpg', '用户');
INSERT INTO `user` VALUES ('4', '网易云音乐fans', '123456', 'zp@qq.com', 'head/head.jpg', '用户');
INSERT INTO `user` VALUES ('8', 'zoupin', '654321', '28@qq.com', 'head/head.jpg', '用户');
INSERT INTO `user` VALUES ('9', '网易云', '123456', '2870212632@qq.com', 'head/head.jpg', '用户');
