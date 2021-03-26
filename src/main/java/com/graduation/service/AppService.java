package com.graduation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graduation.domain.App;
import com.graduation.mapper.AppMapper;

@Service
public class AppService {

	@Autowired(required = false)
	private AppMapper mapper;	
	
	public List<App> queryAllAppBannersList(){
		List<App> appList=mapper.queryAllAppBannersList();
		return appList;
	}
	
	public List<App> queryAllAppRecommendsList(){
		List<App> appList=mapper.queryAllAppRecommendsList();
		return appList;
	}
}
