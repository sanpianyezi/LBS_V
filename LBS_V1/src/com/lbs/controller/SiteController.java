package com.lbs.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lbs.dao.SiteInfoMapper;
import com.lbs.dao.SitePictureCustMapper;
import com.lbs.dao.SitePictureMapper;
import com.lbs.dao.UserInfoCustMapper;
import com.lbs.dao.UserInfoMapper;
import com.lbs.dao.UserSiteMapMapper;
import com.lbs.model.SiteInfo;
import com.lbs.model.SiteInfoExample;
import com.lbs.model.UserInfo;
import com.lbs.model.UserInfoExample;
import com.lbs.model.UserSiteMap;
import com.lbs.model.UserSiteMapExample;
import com.lbs.model.SiteInfoExample.Criteria;
import com.lbs.model.SitePicture;
import com.lbs.utils.DateUtils;
import com.lbs.vo.BootStrapResult;
import com.lbs.vo.SiteDetail;
import com.lbs.vo.SiteDetailResult;
import com.lbs.vo.SiteInfoListVO;
import com.lbs.vo.SiteList;
import com.lbs.vo.UserListResult;
import com.mysql.jdbc.StringUtils;

/**
 * 站点信息
 * @author wanchuanye
 *
 */
@Controller
public class SiteController {
	
	@Autowired
	UserInfoMapper userInfoMapper;
	@Autowired
	UserInfoCustMapper userInfoCustMapper;
	
	@Autowired
	SiteInfoMapper siteInfoMapper;
	
	@Autowired
	SitePictureCustMapper sitePictureCustMapper;
	
	@Autowired
	UserSiteMapMapper userSiteMapMapper;
	
	/*
	 * 进入添加站点页面
	 */
	@RequestMapping(value="/ToAddSite", method=RequestMethod.GET)
	public ModelAndView test2(HttpServletRequest request,HttpServletResponse response ,ModelAndView model){
		model.setViewName("addSite");
		return model;
	}

	/*
	 * 添加站点
	 */
	@RequestMapping(value="/addSite", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> addSite(HttpServletRequest request,HttpServletResponse response ,String siteListJson,ModelAndView model){
		Map<String,Object> map = new HashMap<String,Object>();
		System.out.println("siteListJson"+siteListJson);
		siteListJson = siteListJson.trim();
		List<SiteInfo> siteList = new ArrayList<SiteInfo>();
		try{
			siteList = JSON.parseArray(siteListJson, SiteInfo.class);
		}catch(Exception e){
			map.put("code", "011");//插入失败
			map.put("message", "传值数据格式不匹配");
			return map;
		}
		//		HttpSession session = request.getSession();
//		String sessionId = session.getId();
//		long userId =(long) session.getAttribute(sessionId);
		int count = 0;
		try{
			for(SiteInfo siteInfo : siteList){
				siteInfo.setUpdateTime(DateUtils.getNow(DateUtils.FORMAT_DateAndTime));
//				siteInfo.setUserId(userId);
				siteInfo.setComeFrom("前端采集");
				siteInfoMapper.insertSelective(siteInfo);
				count++;
			}
		}catch(Exception e){
			map.put("code", "011");//插入失败
			map.put("message", "添加站点成功插入数据库异常");
			return map;
		}
		
			
		map.put("code", "000");//登录成功
		map.put("message", "添加站点成功");
		return map;
	}
	
	
	/*
	 * 根据用户名字获取站点列表
	 * 
	 */
	/*
	 * 获取站点List
	 */
	@RequestMapping(value="/getSiteListByUserNameAPI", method=RequestMethod.POST)
	@ResponseBody
	public String getSiteListByUserNameAPI(HttpServletRequest request,HttpServletResponse response ,String siteListAPIJson,ModelAndView model){
		
		System.out.println(siteListAPIJson);
		siteListAPIJson = siteListAPIJson.trim();
		JSONObject object = new JSONObject();
		try{
			object = JSON.parseObject(siteListAPIJson);
		}catch(Exception e){
			SiteInfoListVO data = new SiteInfoListVO();
			data.setCode("999");
			data.setMessage("获取失败");
			data.setSiteList(null);
			return JSONObject.toJSONString(data);
		}
		String userName = object.getString("userName").trim();
		
		
		UserInfo userInfo = new UserInfo();
		userInfo = userInfoCustMapper.selectByUserName(userName);
		
		List<SiteInfo> siteList = new ArrayList<SiteInfo>();
		if("99".equals(userInfo.getPowers())){
			SiteInfoExample example = new SiteInfoExample();
			Criteria criteria= example.createCriteria();
			example.setOrderByClause("id ");
			siteList =siteInfoMapper.selectByExample(example);
		}
		else if("02".equals(userInfo.getPowers())){
			List<Long> childUserList = userInfoCustMapper.selectChildUserListByParentId(userInfo.getId());
			SiteInfoExample example = new SiteInfoExample();
			Criteria criteria = example.createCriteria();
			
			
				criteria.andUserIdIn(childUserList);
			example.setOrderByClause("id ");
			siteList =siteInfoMapper.selectByExample(example);
		}else if("01".equals(userInfo.getPowers())){
			SiteInfoExample example = new SiteInfoExample();
			Criteria criteria = example.createCriteria();
			
			criteria.andUserIdEqualTo(userInfo.getId());
			example.setOrderByClause("id ");
			siteList =siteInfoMapper.selectByExample(example);
		}else if("00".equals(userInfo.getPowers())){
			
			UserSiteMapExample userSiteMapexample = new UserSiteMapExample();
			userSiteMapexample.createCriteria().andUserIdEqualTo(userInfo.getId()).andStatEqualTo("N");
			List<UserSiteMap> userSiteMapList = userSiteMapMapper.selectByExample(userSiteMapexample );
			for(UserSiteMap userSiteMap : userSiteMapList){
				SiteInfo siteInfo = siteInfoMapper.selectByPrimaryKey(userSiteMap.getSiteId());
				
				if(siteInfo !=null){
					siteList.add(siteInfo);
				}
			}
			
			
		}
//		for(SiteInfo siteInfo :siteList){
//			if(siteInfo.getUserId()==0){
//				siteInfo.setUpdateTime("admin");
//			}else{
//				siteInfo.setUpdateTime((userInfoMapper.selectByPrimaryKey(siteInfo.getUserId()).getUserName()));
//			}
//		}
		
		SiteInfoListVO result = new SiteInfoListVO();
		List<SiteList> tempList = new ArrayList<SiteList>();
		result.setCode("000");
		result.setMessage("获取成功");
		for(SiteInfo siteInfo :siteList){
			SiteList siteList1 = new SiteList();
			siteList1.setSiteId(siteInfo.getId().toString());
			siteList1.setSiteCode(siteInfo.getSiteCode()!=null?siteInfo.getSiteCode().toString():"");
			siteList1.setSiteName(siteInfo.getSiteName());
			siteList1.setSiteAddr(siteInfo.getSiteAddr());
			siteList1.setLatitudePoint(siteInfo.getLatitudePoint()!=null?siteInfo.getLatitudePoint().toString():"");
			siteList1.setLongitudePoint(siteInfo.getLongitudePoint()!=null?siteInfo.getLongitudePoint().toString():"");
			siteList1.setImagePath(siteInfo.getImagePath());
			tempList.add(siteList1);
	}
		result.setSiteList(tempList);
		System.out.println("response:"+JSONObject.toJSONString(result));
	return JSONObject.toJSONString(result);
	}
	
	
	
	
	/*
	 * 根据站点ID查询取站点列表
	 * 
	 */
	/*
	 * 获取站点Detail
	 */
	@RequestMapping(value="/getSiteDetailByIdAPI", method=RequestMethod.POST)
	@ResponseBody
	public String getSiteDetailByIdAPI(HttpServletRequest request,HttpServletResponse response ,String siteDetailAPIJson,ModelAndView model){
		
		System.out.println(siteDetailAPIJson);
		siteDetailAPIJson = siteDetailAPIJson.trim();
		JSONObject object = new JSONObject();
		try{
			object = JSON.parseObject(siteDetailAPIJson);
		}catch(Exception e){
			SiteDetailResult data = new SiteDetailResult();
			data.setCode("999");
			data.setMessage("获取失败");
			data.setSiteDetail(null);
			return JSONObject.toJSONString(data);
		}
		String siteId = object.getString("siteId").trim();
		SiteDetailResult  result = new SiteDetailResult();
		SiteDetail  siteDetail = new SiteDetail();
		try{
			SiteInfo siteInfo = siteInfoMapper.selectByPrimaryKey(Long.valueOf(siteId));
			SitePicture example = new SitePicture();
			example.setSiteId(Long.valueOf(siteId));
			example.setType("T1");
			SitePicture sitePiture2 = sitePictureCustMapper.selectBySiteIdAndType(example);
			if(sitePiture2!=null){
				siteDetail.setImagePath2(sitePiture2.getPictureAddr());
			}
			SitePicture example1 = new SitePicture();
			example1.setSiteId(Long.valueOf(siteId));
			example1.setType("T2");
			SitePicture sitePiture3 = sitePictureCustMapper.selectBySiteIdAndType(example1);
			if(sitePiture3!=null){
				siteDetail.setImagePath1(sitePiture3.getPictureAddr());
			}
			
			if(siteInfo!=null){
				siteDetail.setAgentService(siteInfo.getAgentService());
				siteDetail.setAreaCovered(siteInfo.getAreaCovered());
				siteDetail.setBuildingArea(siteInfo.getBuildingArea());
				siteDetail.setCablingType(siteInfo.getCablingType());
				siteDetail.setCompensateCapacity(siteInfo.getCompensateCapacity());
				siteDetail.setContactTel(siteInfo.getContactTel());
				siteDetail.setContaminationLevel(siteInfo.getContaminationLevel());
				siteDetail.setCreateTime(siteInfo.getCreateTime());
				siteDetail.setDutyType(siteInfo.getDutyType());
				siteDetail.setEquipmentCode(siteInfo.getEquipmentCode());
				siteDetail.setEquipmentNum(siteInfo.getEquipmentNum());
				siteDetail.setEquipmentOwner(siteInfo.getEquipmentOwner());
				siteDetail.setHasRingNetwork(siteInfo.getHasRingNetwork());
				siteDetail.setId(siteInfo.getId());
				siteDetail.setImagePath3(siteInfo.getImagePath());
				siteDetail.setImportantDegree(siteInfo.getImportantDegree());
				siteDetail.setIsHub(siteInfo.getIsHub());
				siteDetail.setIsIndependent(siteInfo.getIsIndependent());
				siteDetail.setIsIntelligent(siteInfo.getIsIntelligent());
				siteDetail.setIsUnderground(siteInfo.getIsUnderground());
				siteDetail.setLatitudePoint(siteInfo.getLatitudePoint());
				siteDetail.setLongitudePoint(siteInfo.getLongitudePoint());
				siteDetail.setPreventionType(siteInfo.getPreventionType());
				siteDetail.setRegionFeatures(siteInfo.getRegionFeatures());
				siteDetail.setRemark(siteInfo.getRemark());
				siteDetail.setServiceGroup(siteInfo.getServiceGroup());
				siteDetail.setShortName(siteInfo.getShortName());
				siteDetail.setSiteAddr(siteInfo.getSiteAddr());
				siteDetail.setSiteCode(siteInfo.getSiteCode());
				siteDetail.setSiteLevel(siteInfo.getSiteLevel());
				siteDetail.setSiteName(siteInfo.getSiteName());
				siteDetail.setSiteType(siteInfo.getSiteType());
				siteDetail.setState(siteInfo.getState());
				siteDetail.setTotalCapacity(siteInfo.getTotalCapacity());
				siteDetail.setUpdateTime(siteInfo.getUpdateTime());
				siteDetail.setUserId(siteInfo.getUserId());
				siteDetail.setVoltageGrade(siteInfo.getVoltageGrade());
				siteDetail.setWorkTime(siteInfo.getWorkTime());
				
				
				result.setCode("000");
				result.setMessage("获取成功");
				result.setSiteDetail(siteDetail);
			}
		}catch(Exception e){
			result.setCode("999");
			result.setMessage("获取失败");
			result.setSiteDetail(null);
		}
		
	return JSONObject.toJSONString(result);
	}
	
}
