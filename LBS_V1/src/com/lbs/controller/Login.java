package com.lbs.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mybatis.generator.internal.util.StringUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lbs.dao.UserInfoCustMapper;
import com.lbs.dao.UserInfoMapper;
import com.lbs.model.UserInfo;
import com.mysql.jdbc.StringUtils;

/**
 * 用户登录
 * @author wanchuanye
 *
 */
@Controller
public class Login {
	
	@Autowired
	UserInfoMapper userInfoMapper;
	@Autowired
	UserInfoCustMapper userInfoCustMapper;

	/*
	 * 用户登录
	 */
	@RequestMapping(value="/login", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> login(HttpServletRequest request,HttpServletResponse response ,String userJson,ModelAndView model){
		System.out.println(userJson);
		Map<String,Object> map = new HashMap<String,Object>();
		userJson = userJson.trim();
		JSONObject object = new JSONObject();
		try{
			object = JSON.parseObject(userJson);
		}catch(Exception e){
			map.put("code", "011");//插入失败
			map.put("message", "传值数据格式不匹配");
			return map;
		}
		String userName = object.getString("userName").trim();
		String passWord = object.getString("passWord");
//		System.out.println(response.getCharacterEncoding());
		if(StringUtils.isNullOrEmpty(userName)){
			map.put("code", "011");//用户名不存在
			map.put("message", "用户名不存在");
			return map;
		}
		UserInfo userInfo = userInfoCustMapper.selectByUserName(userName);
		if(userInfo==null){
			map.put("code", "011");//用户名不存在
			map.put("message", "用户名不存在");
			return map;
		}
		passWord = passWord.trim();
		if(StringUtils.isNullOrEmpty(passWord)){
			map.put("code", "021");//密码错误
			map.put("message", "密码错误");
			return map;
		}
		if(!passWord.equals(userInfo.getPassWord())){
			map.put("code", "031");//用户名密码不匹配
			map.put("message", "用户名密码不匹配");
			return map;
		}
		if("C".equals(userInfo.getState())){
			map.put("code", "041");//用户名密码不匹配
			map.put("message", "用户权限已关闭");
			return map;
		}
			
		HttpSession session = request.getSession();
		String sessionId = session.getId();
		session.setAttribute(sessionId, userInfo.getId());
		session.setAttribute("userName", userName);
		session.setAttribute(userName, userInfo);
		map.put("code", "000");//登录成功
		map.put("message", "登陆成功");
		map.put("userInfo", JSON.toJSONString(userInfo));
		return map;
	}
	
	/*
	 * 登出
	 */
	@RequestMapping(value="/loginout", method=RequestMethod.GET)
	public ModelAndView test2(HttpServletRequest request,HttpServletResponse response ,ModelAndView model){
		HttpSession session = request.getSession();
		String sessionId = session.getId();
		Long userId = (Long) session.getAttribute(sessionId);
		String userName = (String ) session.getAttribute("userName");
		if(userName !=null){
			UserInfo userInfo = (UserInfo)session.getAttribute(userName);
			if(userInfo !=null){
				session.removeAttribute(userName);
			}
		}
		
		
		
		if(userId !=null){
			session.removeAttribute(sessionId);
		}
		session.removeAttribute("userName");
		model.setViewName("login");
		return model;
	}
}
