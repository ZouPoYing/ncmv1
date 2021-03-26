package com.graduation.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.graduation.domain.User;

@Mapper
public interface UserMapper {
	//mybatis注解开发
	@Select("select * from user where user_id=#{userId}")
	@Results({
            @Result(property = "userId", column = "user_id"),
			@Result(property = "userName", column = "user_name"),
			@Result(property = "userPassword", column = "user_password"),
            @Result(property = "userEmail", column = "user_email"),
            @Result(property = "userPicHead", column = "user_pic_head") })
	public User queryUserByUserId(int userId);
	
	@Select("select * from user where user_email=#{email}")
	@Results({
            @Result(property = "userId", column = "user_id"),
			@Result(property = "userName", column = "user_name"),
			@Result(property = "userPassword", column = "user_password"),
            @Result(property = "userEmail", column = "user_email"),
            @Result(property = "userPicHead", column = "user_pic_head") })
	public User queryUserByEmail(String email);
	
	@Insert("insert into user (user_password, user_email) values (#{password} ,#{email})")
	@Options(useGeneratedKeys=true)
	void insertUser(@Param("email") String email,@Param("password") String password);
	
	@Select("select * from user where user_email=#{email} and user_password=#{password}")
	@Results({
            @Result(property = "userId", column = "user_id"),
			@Result(property = "userName", column = "user_name"),
			@Result(property = "userPassword", column = "user_password"),
            @Result(property = "userEmail", column = "user_email"),
            @Result(property = "userPicHead", column = "user_pic_head") })
	public User queryUserByEmailAndPassword(@Param("email") String email,@Param("password") String password);
	
	@Update("update user set user_password=#{password} WHERE user_email =#{email}")
    void updateUserPasswordByEmail(String password, String email);
	
	@Update("update user set user_name=#{userName} WHERE user_id =#{userId}")
	void updateNameById(int userId,String userName);
	
}