package com.lbs.controller.admin;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.mybatis.generator.internal.util.StringUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lbs.dao.FuncInfoMapper;
import com.lbs.dao.UserInfoCustMapper;
import com.lbs.dao.UserInfoMapper;
import com.lbs.dao.UserRoleCustMapper;
import com.lbs.model.FuncInfo;
import com.lbs.model.FuncInfoExample;
import com.lbs.model.UserInfo;
import com.lbs.model.UserInfoExample;
import com.lbs.model.UserInfoExample.Criteria;
import com.lbs.utils.DateUtils;
import com.lbs.vo.BootStrapResult;
import com.lbs.vo.FuncInfoVO;

/**
 * 后端用户管理
 * @author wanchuanye
 *
 */
@Controller
public class AdminUserManager {
	
	@Autowired
	UserInfoMapper userInfoMapper;
	@Autowired
	FuncInfoMapper funcInfoMapper;
	@Autowired
	UserRoleCustMapper userRoleCustMapper;
	
	@Autowired
	UserInfoCustMapper userInfoCustMapper;

	/*
	 * 进入后端用户管理
	 */
	@RequestMapping(value="/AdminUserManager", method=RequestMethod.GET)
	public ModelAndView AdminUserManager1(HttpServletRequest request,HttpServletResponse response ,ModelAndView model) {
		
		model.setViewName("AdminUserManager");
		model.addObject("title","后端用户配置");
		return model;
	}
	
	
	
	
	@RequestMapping(value="/AdminjsonList", method=RequestMethod.GET)
	@ResponseBody
	public String AdminjsonList(HttpServletRequest request,HttpServletResponse response ,String pageNumber,String sortOrder,String pageSize,String userName ,String realName,String telNo,ModelAndView model) throws IOException{
		String sessionId = request.getSession().getId();
		long userId = (long) request.getSession().getAttribute(sessionId);
		UserInfo userInfo = new UserInfo();
		userInfo = userInfoMapper.selectByPrimaryKey(Long.valueOf(userId));
		
		List<UserInfo> userList = new ArrayList<UserInfo>();
		if("99".equals(userInfo.getPowers())){
			UserInfoExample example = new UserInfoExample();
			Criteria criteria = example.createCriteria();
			if(StringUtils.isNotBlank(userName)){
				criteria.andUserNameEqualTo(userName);
			}
			if(StringUtils.isNotBlank(realName)){
				criteria.andRealNameEqualTo(realName);
			}
			if(StringUtils.isNotBlank(telNo)){
				criteria.andTelNoEqualTo(telNo);
			}
			criteria.andPowersEqualTo("02");
			userList =userInfoMapper.selectByExample(example);
//			for(int i=0;i<userList.size();i++){
//				UserInfo ui = userList.get(i);
//				switch (ui.getState()){
//					case "N" :ui.setState("正常");break;
//					case "C" :ui.setState("关闭");break;
//					default:ui.setState("正常"); 
//				}
//				ui.setPowers("前端管理员");
//				
//			}
		}
		
		BootStrapResult result = new BootStrapResult();
		result.setTotal(userList.size());
		result.setRows(new ArrayList(userList));
		result.setMessages("成功");
//		model.addObject("userList",userList);
//	System.out.println("ss");
	return JSONObject.toJSONString(result);
	}
	
	
	/**
	 * 删除用户
	 * @param request
	 * @param response
	 * @param userIds
	 * @param model
	 * @return
	 * @throws IOException
	 */
	 
	@RequestMapping(value="/deleteAdminUser", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> deleteAdminUser(HttpServletRequest request,HttpServletResponse response ,String userIds,ModelAndView model) throws IOException{
		Map<String ,Object> map = new HashMap<String , Object>();
		
		String[] userList = userIds.split(",");
		try{
			for(int i=0;i<userList.length;i++){
				userInfoMapper.deleteByPrimaryKey(Long.valueOf(userList[i]));
				map.put("success", true);
			}
		}catch(Exception e){
			map.put("error", true);
		}
	return map;
	}
	
	
	/**
	 * 进入新增用户页面
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	
	 
	@RequestMapping(value="/ToAddAdminUser", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView ToAddAdminUser(HttpServletRequest request,HttpServletResponse response ,ModelAndView model) {
		
		model.setViewName("AddAdminUser");
		return model;
	}
	
	
	/**
	 * 新增用户
	 * @param request
	 * @param response
	 * @param userIds
	 * @param model
	 * @return
	 * @throws IOException
	 */
	 
	@RequestMapping(value="/AddAdminUser", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> AddAdminUser(HttpServletRequest request,HttpServletResponse response ,String userName,String passWord,String realName,String telNo,String email,ModelAndView model) throws IOException{
		Map<String ,Object> map = new HashMap<String , Object>();
		
		String sessionId = request.getSession().getId();
		long userId = (long) request.getSession().getAttribute(sessionId);
		if(StringUtils.isBlank(userName)){
			map.put("error", true);
			map.put("message", "用户名不能为空!");
			return map;
		}
		
		UserInfo ui = userInfoCustMapper.selectByUserName(userName);
		if(ui != null){
			map.put("error", true);
			map.put("message", "用户名已存在!");
			return map;
		}
		
		UserInfo userInfo = new UserInfo();
		if(StringUtils.isNotBlank(email)){
			userInfo.setEmail(email);
		}
		userInfo.setRegTime(DateUtils.getTimeString().replaceAll("-","").replaceAll(":","").replaceAll(" ","").substring(0, 14));
		userInfo.setLogNtime(DateUtils.getTimeString().replaceAll("-","").replaceAll(":","").replaceAll(" ","").substring(0, 14));
		userInfo.setParentId(userId);
		userInfo.setPowers("02");//超级管理员只能创建前端管理员02的权限
		userInfo.setRealName(realName);
		userInfo.setUserName(userName);
		if(StringUtils.isNotBlank(telNo)){
			userInfo.setTelNo(telNo);
		}
		if(StringUtils.isNotBlank(passWord)){
			userInfo.setPassWord(passWord);
		}else{
			userInfo.setPassWord("111111");
		}
		userInfo.setState("N");
		try{
			userInfoMapper.insert(userInfo);
			map.put("success", true);
		}catch(Exception e){
			e.printStackTrace();
			map.put("error", true);
		}
	return map;
	}
	
	
	
	/**
	 * 进入编辑用户页面
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	
	 
	@RequestMapping(value="/ToUpdateAdminUser", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView ToUpdateAdminUser(HttpServletRequest request,HttpServletResponse response ,String id ,ModelAndView model) {
		UserInfo userInfo = new UserInfo();
		try{
			userInfo = userInfoMapper.selectByPrimaryKey(Long.valueOf(id));
		}catch(Exception e){
			
		}
		model.addObject("userInfo",userInfo);
		model.setViewName("UpdateAdminUser");
		return model;
	}
	
	
	/**
	 * 编辑保存用户
	 * @param request
	 * @param response
	 * @param userIds
	 * @param model
	 * @return
	 * @throws IOException
	 */
	 
	@RequestMapping(value="/SaveAdminUser", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> SaveAdminUser(HttpServletRequest request,HttpServletResponse response ,String id,String userName,String passWord,String realName,String telNo,String state , String email,ModelAndView model) throws IOException{
		Map<String ,Object> map = new HashMap<String , Object>();
		
		UserInfo userInfo = userInfoMapper.selectByPrimaryKey(Long.valueOf(id));
		if(StringUtils.isNotBlank(userName)){
			userInfo.setUserName(userName);
		}
		if(StringUtils.isNotBlank(passWord)){
			userInfo.setPassWord(passWord);
		}
		if(StringUtils.isNotBlank(realName)){
			userInfo.setRealName(realName);
		}
		if(StringUtils.isNotBlank(telNo)){
			userInfo.setTelNo(telNo);
		}
		if(StringUtils.isNotBlank(state)){
			userInfo.setState(state);
		}
		if(StringUtils.isNotBlank(email)){
			userInfo.setEmail(email);
		}
		userInfo.setLogNtime(DateUtils.getTimeString().replaceAll("-","").replaceAll(":","").replaceAll(" ","").substring(0, 14));
		try{
			userInfoMapper.updateByPrimaryKey(userInfo);
			map.put("success", true);
		}catch(Exception e){
			e.printStackTrace();
			map.put("error", true);
		}
	return map;
	}
}
