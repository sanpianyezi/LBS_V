package com.lbs.controller.traj;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lbs.dao.UserInfoCustMapper;
import com.lbs.dao.UserTrajectoryMapper;
import com.lbs.model.UserTrajectoryExample.Criteria;
import com.lbs.model.UserInfo;
import com.lbs.model.UserInfoExample;
import com.lbs.model.UserTrajectory;
import com.lbs.model.UserTrajectoryExample;
import com.lbs.utils.DateUtils;
import com.lbs.vo.BootStrapResult;
import com.lbs.vo.CommonResult;
import com.lbs.vo.TrajListResult;
import com.lbs.vo.UserListResult;


@Controller
@RequestMapping(value="traj")
public class TrajController {

	@Autowired
	UserTrajectoryMapper userTrajectoryMapper;
	
	@Autowired
	UserInfoCustMapper userInfoCustMapper;

	
	/*
	 * 2.6  轨迹数据上传
	 */
	@RequestMapping(value="/UploadTrajList", method=RequestMethod.POST)
	@ResponseBody
	public String GetUserList(HttpServletRequest request,HttpServletResponse response ,String trajListJson ,ModelAndView model) throws IOException{
		System.out.println("UploadTrajList request>>>>>>>>"+trajListJson);
		trajListJson = trajListJson.trim();
		JSONObject object = new JSONObject();
		List<UserTrajectory> tempList = new ArrayList<UserTrajectory>(); 
		UserInfo userInfo = new UserInfo();
		try{
			object = JSON.parseObject(trajListJson);
			String userName = object.getString("userName").trim();
			Object trajListObject =object.get("trajList");
			userInfo = userInfoCustMapper.selectByUserName(userName);
			tempList = JSON.parseArray(trajListObject.toString(), UserTrajectory.class);
		}catch(Exception e){
			CommonResult data = new CommonResult();
			data.setCode("999");
			data.setMessage("上传失败");
			return JSONObject.toJSONString(data);
		}
		
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
		
		
		 for(UserTrajectory record : tempList){
			 try{
			 record.setUserId(userInfo.getId().toString());
			 record.setState("N");
			 record.setUpdateTime(DateUtils.getTimeString().replaceAll("-","").replaceAll(":","").replaceAll(" ","").substring(0, 14));	
			 userTrajectoryMapper.insert(record);
			 }catch(Exception e){
				 continue;
			 }
		 }
		 
		 	CommonResult data = new CommonResult();
			data.setCode("000");
			data.setMessage("上传成功");
			System.out.println("UploadTrajList response>>>>>>>>"+JSONObject.toJSONString(data));
			return JSONObject.toJSONString(data);
		
		}
	
	
	/*
	 * 2.5查询用户轨迹  获取时间段轨迹数据List
	 */
	@RequestMapping(value="/GetTrajList", method=RequestMethod.POST)
	@ResponseBody
	public String GetTrajList(HttpServletRequest request,HttpServletResponse response ,String gettrajListJson ,ModelAndView model) throws IOException{
		System.out.println("GetTrajList request>>>>>>>>"+gettrajListJson);
		gettrajListJson = gettrajListJson.trim();
		JSONObject object = new JSONObject();
		List<UserTrajectory> tempList = new ArrayList<UserTrajectory>(); 
		UserInfo userInfo = new UserInfo();
		try{
			object = JSON.parseObject(gettrajListJson);
			String userName = object.getString("userName").trim();
			String startTime = object.getString("startTime").trim();
			String endTime = object.getString("endTime").trim();
			userInfo = userInfoCustMapper.selectByUserName(userName);
			UserTrajectoryExample example = new UserTrajectoryExample();
			Criteria criteria = example.createCriteria();
			criteria.andUserIdEqualTo(userInfo.getId().toString());
			criteria.andCreateTimeBetween(startTime, endTime);
			tempList = userTrajectoryMapper.selectByExample(example);
			TrajListResult data = new TrajListResult();
			data.setCode("000");
			data.setTrajList(tempList);
			data.setMessage("获取成功");
			System.out.println("UploadTrajList response>>>>>>>>"+JSONObject.toJSONString(data));
			return JSONObject.toJSONString(data);
		}catch(Exception e){
			TrajListResult data = new TrajListResult();
			data.setCode("999");
			data.setTrajList(null);
			data.setMessage("获取失败");
			return JSONObject.toJSONString(data);
		}
		
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
		
		
		}
	
}
