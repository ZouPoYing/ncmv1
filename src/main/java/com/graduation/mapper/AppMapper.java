package com.graduation.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.graduation.domain.App;

@Mapper
public interface AppMapper {

	@Select("select * from app where type='banner'")
	@Results({
            @Result(property = "id", column = "id"),
			@Result(property = "img", column = "img"),
			@Result(property = "title", column = "title"),
            @Result(property = "link", column = "link"),
            @Result(property = "type", column = "type") })
	public List<App> queryAllAppBannersList();
	
	@Select("select * from app where type='recommend'")
	@Results({
            @Result(property = "id", column = "id"),
			@Result(property = "img", column = "img"),
			@Result(property = "title", column = "title"),
            @Result(property = "link", column = "link"),
            @Result(property = "type", column = "type") })
	public List<App> queryAllAppRecommendsList();
}
