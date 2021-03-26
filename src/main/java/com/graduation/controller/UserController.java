package com.graduation.controller;

import java.io.IOException;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.graduation.domain.Register;
import com.graduation.domain.User;
import com.graduation.service.UserService;
import com.graduation.util.RandomCode;
import com.graduation.util.Sendmail;

@RestController
//实现跨域注解
//origin="*"代表所有域名都可访问
//maxAge飞行前响应的缓存持续时间的最大年龄，简单来说就是Cookie的有效期 单位为秒
//若maxAge是负数,则代表为临时Cookie,不会被持久化,Cookie信息保存在浏览器内存中,浏览器关闭Cookie就消失
@CrossOrigin(allowCredentials ="true")
public class UserController {
	
	@Autowired
	private UserService userService; 
	
	// 通过userId查询user
	@RequestMapping("/user/queryUserByUserId")
	@ResponseBody
	public User queryUserByUserId(@RequestBody String userid) {
		if(userid == "") {
			return null;
		} else {
			int userId=Integer.parseInt(userid);
			User user = userService.queryUserByUserId(userId);
			System.out.println(user.toString());
			return user;
		}
	}
	
	// 登录注册模块 获取邮箱号码并发送验证码
	@PostMapping("/user/getEmailNumber")
	@ResponseBody
	public void getEailNumberAndSendCode(@RequestBody String emailNumber,HttpSession session) throws AddressException, IOException, MessagingException {
		System.out.println("注册QQ邮箱号码：" + emailNumber);
		Sendmail send_email=new Sendmail(); 
		RandomCode randomCode=RandomCode.getRandomCode(); 
		String code=randomCode.getCode(6); // 获取一个随机的6位验证码 
		send_email.send_email(emailNumber,"nec注册验证码",code);
		session.setAttribute("sessionCode", code); // 把验证码存到用户的session里 
		session.setAttribute("sessionEmail", emailNumber); // 把用户注册的邮箱号存到用户的session里 
		System.out.println(emailNumber+"收到的验证码：" + code);
	}
	
	// 登录注册模块 验证验证码并获取用户的密码并注册
	@PostMapping("/user/register")
	@ResponseBody
	public String rigester(@RequestBody Register register,HttpSession session) { 
		System.out.println(register);
		String sessionCode=(String)session.getAttribute("sessionCode"); // 取出用户的session里面的code
		String sessionEmail=(String)session.getAttribute("sessionEmail"); // 取出用户的session里面的email
		System.out.println("sc"+sessionCode);
		System.out.println("se"+sessionEmail);
		if(register.getEmail().equals(sessionEmail)) {
			if(register.getCode().equals(sessionCode)) {
				User user=userService.queryUserByEmail(register.getEmail());
				if(user==null) {
					userService.insertUser(register.getEmail(),register.getPassword());
					return "注册成功";
				} else {
					return "该邮箱已经注册过账号";
				}
			} else {
				 
				return "验证码错误";
			}
		} else {
			return "邮箱号和获取验证码的邮箱号不一致";
		}
	}
	
	// 登录注册模块 用户登录
	@PostMapping("/user/login")
	@ResponseBody
	public User login(@RequestBody Register register) {
		System.out.println(register);
		User user=userService.queryUserByEmailAndPassword(register.getEmail(), register.getPassword());
		if(user==null) {
			return null;
		} else {
			return user;
		}
	}
	
    // 登录注册模块 重置密码 获取验证码	
	@PostMapping("/user/reGetEmailNumber")
	@ResponseBody
	public void reGetEailNumberAndSendCode(@RequestBody String emailNumber,HttpSession session) throws AddressException, IOException, MessagingException {
		System.out.println("注册QQ邮箱号码：" + emailNumber);
		Sendmail send_email=new Sendmail(); 
		RandomCode randomCode=RandomCode.getRandomCode(); 
		String code=randomCode.getCode(6); // 获取一个随机的6位验证码 
		send_email.send_email(emailNumber,"nec注册验证码",code);
		session.setAttribute("reSessionCode", code); // 把验证码存到用户的session里 
		session.setAttribute("reSessionEmail", emailNumber); // 把用户注册的邮箱号存到用户的session里 
		System.out.println(emailNumber+"收到的验证码：" + code);
	}
	
	// 登录注册模块 验证验证码并获取用户的密码并注册
	@PostMapping("/user/rePassword")
	@ResponseBody
	public String rePassword(@RequestBody Register register,HttpSession session) { 
		System.out.println(register);
		String sessionCode=(String)session.getAttribute("reSessionCode"); // 取出用户的session里面的code
		String sessionEmail=(String)session.getAttribute("reSessionEmail"); // 取出用户的session里面的email
		System.out.println("sc"+sessionCode);
		System.out.println("se"+sessionEmail);
		if(register.getEmail().equals(sessionEmail)) {
			if(register.getCode().equals(sessionCode)) {
				userService.updateUserPasswordByEmail(register.getPassword(), sessionEmail);
				return "重置成功";
			} else {
				return "验证码错误";
			}
		} else {
			return "邮箱号和获取验证码的邮箱号不一致";
		}
	}
	
	// 修改用户信息模块 根据用户的id修改用户名
    @PostMapping("/user/updateNameById")
	@ResponseBody
	public String updateNameById(@RequestBody User user) { 
    	System.out.println(user);
    	userService.updateNameById(user.getUserId(), user.getUserName());
		return "修改成功";
	}
}
