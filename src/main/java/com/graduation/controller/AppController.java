package com.graduation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.graduation.domain.App;
import com.graduation.service.AppService;

@RestController
@CrossOrigin(allowCredentials ="true")
public class AppController {

	@Autowired
	private AppService appService; 
	
	// 获取app banners数据
	@RequestMapping("/app/bannersList")
	public List<App> queryAllAppBannersList()
	{
		List<App> banners = appService.queryAllAppBannersList();
		System.out.println(banners.toString());
		return banners;
	}
	
	// 获取app recommends数据
	@RequestMapping("/app/recommendsList")
	public List<App> queryAllAppRecommendsList()
	{
		List<App> recommends = appService.queryAllAppRecommendsList();
		System.out.println(recommends.toString());
		return recommends;
	}
}
