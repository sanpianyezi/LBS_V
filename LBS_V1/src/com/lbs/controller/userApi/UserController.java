package com.lbs.controller.userApi;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import com.lbs.dao.UserTrajectoryMapper;
import com.lbs.model.UserInfo;
import com.lbs.model.UserInfoExample;
import com.lbs.model.UserInfoExample.Criteria;
import com.lbs.model.UserTrajectory;
import com.lbs.model.UserTrajectoryExample;
import com.lbs.utils.DateUtils;
import com.lbs.vo.UserListResult;
import com.mysql.jdbc.StringUtils;


@Controller
@RequestMapping(value="/userApi")
public class UserController {

	@Autowired
	UserInfoMapper userInfoMapper;
	
	@Autowired
	UserInfoCustMapper userInfoCustMapper;
	
	@Autowired
	UserTrajectoryMapper userTrajectoryMapper;
	
	
	/*
	 * 用户登录
	 */
	@RequestMapping(value="/GetUserList", method=RequestMethod.POST)
	@ResponseBody
	public String GetUserList(HttpServletRequest request,HttpServletResponse response ,String getUserListJson ,ModelAndView model) throws IOException{
		System.out.println(getUserListJson);
		getUserListJson = getUserListJson.trim();
		JSONObject object = new JSONObject();
		try{
			object = JSON.parseObject(getUserListJson);
		}catch(Exception e){
			UserListResult data = new UserListResult();
			data.setCode("999");
			data.setMessage("获取失败");
			data.setUserList(null);
			return JSONObject.toJSONString(data);
		}
		String userName = object.getString("userName").trim();
		String powers = object.getString("powers").trim();
//		String sessionId = request.getSession().getId();
//		if(!StringUtils.isNullOrEmpty(sessionId)){
//			request.setCharacterEncoding("UTF-8");
//            response.setCharacterEncoding("UTF-8");
//            PrintWriter out = response.getWriter();
//            String loginPage = "http://"+request.getHeader("Host")+"/LBS_V1";
//            StringBuilder builder = new StringBuilder();
//            builder.append("<script type=\"text/javascript\">");
//            builder.append("alert('用户名不存在，请重新登录！');");
//            builder.append("window.top.location.href='");
//            builder.append(loginPage);
//            builder.append("';");
//            builder.append("</script>");
//            out.print(builder.toString());
//            return null;
//		}else{
		UserListResult data = new UserListResult();
		List<UserInfo> userList = new ArrayList<UserInfo>();
			UserInfoExample example = new UserInfoExample();
			Criteria criteria = example.createCriteria();
			criteria.andUserNameEqualTo(userName);
			criteria.andPowersEqualTo(powers);
			List<UserInfo> userInfoList = userInfoMapper.selectByExample(example);
			if(userInfoList.size()>0){
				List<Long> childUserList = userInfoCustMapper.selectChildUserListByParentId(userInfoList.get(0).getId());
				int i=1;
				for(Long childId : childUserList){
					UserInfo userInfo = userInfoMapper.selectByPrimaryKey(childId);
					UserInfo temp = new UserInfo();
					temp.setUserName(userInfo.getUserName());
					temp.setRealName(userInfo.getRealName());
					temp.setTelNo(userInfo.getTelNo());
					temp.setPowers(userInfo.getPowers());
					
					UserTrajectoryExample example1 = new UserTrajectoryExample();
					com.lbs.model.UserTrajectoryExample.Criteria criteria1 = example1.createCriteria();
					criteria1.andUserIdEqualTo(userInfo.getId().toString());
					example1.setOrderByClause("create_time desc");
					List<UserTrajectory> userTrajectoryList = userTrajectoryMapper.selectByExample(example1 );
					if(userTrajectoryList.size()==0){
						temp.setState("01");
					}else{
						if(DateUtils.IsOnline(Long.valueOf(userTrajectoryList.get(0).getCreateTime()), 300)){
							temp.setState("00");
						}else{
							temp.setState("01");
						}
					}
					
					temp.setImagePath(userInfo.getImagePath());
					userList.add(temp);
				}
			}
			
				
			
			data.setCode("000");
			data.setMessage("获取成功");
			data.setUserList(userList);
			return JSONObject.toJSONString(data);
		
		}
			
	
	
//	}
	
	
	
	
	
	
	
}
