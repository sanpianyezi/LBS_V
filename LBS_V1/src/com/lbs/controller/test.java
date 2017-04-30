package com.lbs.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lbs.dao.UserInfoMapper;
import com.lbs.model.UserInfo;


@Controller
public class test {
	
	@Autowired
	UserInfoMapper userInfoMapper;
	
	
	
	@RequestMapping(value="/haha", method=RequestMethod.POST)
	public Map<String,Object> test1(HttpServletRequest requet,ModelAndView model){
		
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("Token", "Token");
		return map;
	}
	

}
