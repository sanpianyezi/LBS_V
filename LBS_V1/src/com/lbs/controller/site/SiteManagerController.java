package com.lbs.controller.site;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.mybatis.generator.internal.util.StringUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lbs.controller.FileUploadController;
import com.lbs.dao.FuncInfoMapper;
import com.lbs.dao.SiteInfoCustMapper;
import com.lbs.dao.SiteInfoMapper;
import com.lbs.dao.SitePictureMapper;
import com.lbs.dao.UserInfoCustMapper;
import com.lbs.dao.UserInfoMapper;
import com.lbs.dao.UserRoleCustMapper;
import com.lbs.model.SiteInfo;
import com.lbs.model.SiteInfoExample;
import com.lbs.model.SiteInfoExample.Criteria;
import com.lbs.model.SitePicture;
import com.lbs.model.SitePictureExample;
import com.lbs.model.UserInfo;
import com.lbs.model.UserInfoExample;
import com.lbs.utils.DateUtils;
import com.lbs.utils.ExportExcel;
import com.lbs.utils.FileUpload;
import com.lbs.utils.MathUtils;
import com.lbs.vo.BootStrapResult;
import com.lbs.vo.SiteImagesVO;

import jxl.Sheet;
import jxl.Workbook;


@Controller
@RequestMapping(value="manger")
public class SiteManagerController {

	@Autowired
	UserInfoMapper userInfoMapper;
	@Autowired
	SiteInfoMapper siteInfoMapper;
	@Autowired
	FuncInfoMapper funcInfoMapper;
	@Autowired
	UserRoleCustMapper userRoleCustMapper;
	
	@Autowired
	UserInfoCustMapper userInfoCustMapper;
	
	@Autowired
	SitePictureMapper sitePictureMapper;
	
	@Autowired
	SiteInfoCustMapper siteInfoCustMapper;
	Logger logger = LoggerFactory.getLogger(SiteManagerController.class);
	/*
	 * 进入后端用户管理
	 */
	@RequestMapping(value="/SiteManager", method=RequestMethod.GET)
	public ModelAndView SiteManager(HttpServletRequest request,HttpServletResponse response ,ModelAndView model) {
		
		
		List<String> belongAreaList = siteInfoCustMapper.selectSiteAreaList();
		model.addObject("belongAreaList",belongAreaList);
		model.setViewName("siteManager/AdminSiteManager");
		model.addObject("title","后端站点配置");
		return model;
	}
	
	
	
	
	@RequestMapping(value="/SitejsonList", method=RequestMethod.GET)
	@ResponseBody
	public String SitejsonList(HttpServletRequest request,HttpServletResponse response ,String pageNumber,String sortOrder,String sortName,String pageSize,String siteCode ,String siteName , String siteType,String siteAddr,String updateUserName,String belongArea ,ModelAndView model) throws IOException{
		String sessionId = request.getSession().getId();
		long userId = (long) request.getSession().getAttribute(sessionId);
		UserInfo userInfo = new UserInfo();
		userInfo = userInfoMapper.selectByPrimaryKey(Long.valueOf(userId));
		int pagesize = Integer.valueOf(pageSize);
		String pageNum = String.valueOf((Integer.valueOf(pageNumber)-1)*pagesize);
		List<SiteInfo> siteList = new ArrayList<SiteInfo>();
		int count =0;
		if("99".equals(userInfo.getPowers())){
			SiteInfoExample example = new SiteInfoExample();
			Criteria criteria= example.createCriteria();
			if(StringUtils.isNotBlank(siteCode)){
				criteria.andSiteCodeEqualTo(Long.valueOf(siteCode));
			}
			if(StringUtils.isNotBlank(siteName)){
				criteria.andSiteNameEqualTo(siteName);
			}
			if(StringUtils.isNotBlank(siteType)){
				criteria.andSiteTypeEqualTo(siteType);
			}
			if(StringUtils.isNotBlank(siteAddr)){
				criteria.andSiteAddrLike("%"+siteAddr+"%");
			}
			if(StringUtils.isNotBlank(updateUserName)){
				UserInfoExample example1 = new UserInfoExample();
				example1.createCriteria().andUserNameEqualTo(updateUserName);
				List<UserInfo> uiList = userInfoMapper.selectByExample(example1);
				List<Long> userIdList = new ArrayList<Long>();
				for(int i=0;i<uiList.size();i++){
					userIdList.add(uiList.get(i).getId());
				}
				if(userIdList.size()>0){
					criteria.andUserIdIn(userIdList);
				}
				
			}
			if(StringUtils.isNotBlank(belongArea)){
				criteria.andBelongAreaLike("%"+belongArea+"%");
			}
			siteList =siteInfoMapper.selectByExample(example);
			count = siteList.size();
			if(sortOrder!=null){
				example.setOrderByClause("id "+ sortOrder+" limit "+pageNum+", "+pageSize);
			}else{
				example.setOrderByClause("id limit "+pageNum+", "+pageSize);
			}
			siteList =siteInfoMapper.selectByExample(example);
		}
		else if("02".equals(userInfo.getPowers())){
			List<Long> childUserList = userInfoCustMapper.selectChildUserListByParentId(userId);
			SiteInfoExample example = new SiteInfoExample();
			Criteria criteria = example.createCriteria();
			if(StringUtils.isNotBlank(siteCode)){
				criteria.andSiteCodeEqualTo(Long.valueOf(siteCode));
			}
			if(StringUtils.isNotBlank(siteName)){
				criteria.andSiteNameEqualTo(siteName);
			}
			if(StringUtils.isNotBlank(siteType)){
				criteria.andSiteTypeEqualTo(siteType);
			}
			if(StringUtils.isNotBlank(siteAddr)){
				criteria.andSiteAddrLike("%"+siteAddr+"%");
			}
			if(StringUtils.isNotBlank(updateUserName)){
				UserInfoExample example1 = new UserInfoExample();
				example1.createCriteria().andUserNameEqualTo(updateUserName);
				List<UserInfo> uiList = userInfoMapper.selectByExample(example1);
				List<Long> userIdList = new ArrayList<Long>();
				for(int i=0;i<childUserList.size();i++){
					Long childId = childUserList.get(i);
					for(int j=0;j<uiList.size();j++){
						if(childId == uiList.get(j).getId())
						userIdList.add(uiList.get(j).getId());
					}
				}
				if(userIdList.size()>0){
					criteria.andUserIdIn(userIdList);
				}
				
			}else{
				criteria.andUserIdIn(childUserList);
			}
			if(StringUtils.isNotBlank(belongArea)){
				criteria.andBelongAreaLike("%"+belongArea+"%");
			}
			siteList =siteInfoMapper.selectByExample(example);
			count = siteList.size();
			if(sortOrder!=null){
				example.setOrderByClause("id "+ sortOrder+" limit "+pageNum+", "+pageSize);
			}else{
				example.setOrderByClause("id limit "+pageNum+", "+pageSize);
			}
			siteList =siteInfoMapper.selectByExample(example);
		}else if("01".equals(userInfo.getPowers())){
			SiteInfoExample example = new SiteInfoExample();
			Criteria criteria = example.createCriteria();
			if(StringUtils.isNotBlank(siteCode)){
				criteria.andSiteCodeEqualTo(Long.valueOf(siteCode));
			}
			if(StringUtils.isNotBlank(siteName)){
				criteria.andSiteNameEqualTo(siteName);
			}
			if(StringUtils.isNotBlank(siteType)){
				criteria.andSiteTypeEqualTo(siteType);
			}
			if(StringUtils.isNotBlank(siteAddr)){
				criteria.andSiteAddrLike("%"+siteAddr+"%");
			}
			if(StringUtils.isNotBlank(belongArea)){
				criteria.andBelongAreaLike("%"+belongArea+"%");
			}
			criteria.andUserIdEqualTo(userId);
			siteList =siteInfoMapper.selectByExample(example);
			count = siteList.size();
			if(sortOrder!=null){
				example.setOrderByClause("id "+ sortOrder+" limit "+pageNum+", "+pageSize);
			}else{
				example.setOrderByClause("id limit "+pageNum+", "+pageSize);
			}
			siteList =siteInfoMapper.selectByExample(example);
		}
		for(SiteInfo siteInfo :siteList){
			siteInfo.setCreateTime(siteInfo.getCreateTime().replace("-", ""));
			siteInfo.setImagePath(siteInfo.getImagePath()!=null?siteInfo.getImagePath().split(",")[0]:null);
			if(siteInfo.getUserId()==0){
				siteInfo.setUpdateTime("admin");
			}else{
				siteInfo.setUpdateTime((userInfoMapper.selectByPrimaryKey(siteInfo.getUserId()).getUserName()));
			}
		}
		
		BootStrapResult result = new BootStrapResult();
		result.setTotal(count);
		result.setRows(new ArrayList(siteList));
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
	 
	@RequestMapping(value="/deleteAdminSite", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> deleteAdminSite(HttpServletRequest request,HttpServletResponse response ,String siteIds,ModelAndView model) throws IOException{
		Map<String ,Object> map = new HashMap<String , Object>();
		
		String[] siteList = siteIds.split(",");
		try{
			for(int i=0;i<siteList.length;i++){
				siteInfoMapper.deleteByPrimaryKey(Long.valueOf(siteList[i]));
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
	
	 
	@RequestMapping(value="/ToAddAdminSite", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView ToAddAdminSite(HttpServletRequest request,HttpServletResponse response ,ModelAndView model) {
		List<String> belongAreaList = siteInfoCustMapper.selectSiteAreaList();
		model.addObject("belongAreaList",belongAreaList);
		model.setViewName("siteManager/AddAdminSite");
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
	 
	@RequestMapping(value="/AddAdminSite", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> AddAdminSite(HttpServletRequest request,HttpServletResponse response ,String siteCode,String siteType,String siteName,String serviceGroup,String voltageGrade,String workTime,                     String isIntelligent, String isHub, String siteLevel ,String dutyType, String agentService, String cablingType, String contaminationLevel, String siteAddr, String areaCovered, String buildingArea, String regionFeatures, String contactTel, String shortName, String equipmentOwner, String remark, String totalCapacity, String equipmentNum, String importantDegree, String isUnderground, String isIndependent, String preventionType, String hasRingNetwork, String compensateCapacity, String equipmentCode, String longitudePoint, String latitudePoint,   String belongArea,                                                                                                            ModelAndView model) throws IOException{
		Map<String ,Object> map = new HashMap<String , Object>();
		String sessionId = request.getSession().getId();
		long userId = (long) request.getSession().getAttribute(sessionId);
		UserInfo userInfo1 = new UserInfo();
		userInfo1 = userInfoMapper.selectByPrimaryKey(Long.valueOf(userId));
		if(!"01".equals(userInfo1.getPowers())){
			map.put("error", true);
			map.put("message", "只有采集员可添加!");
			return map;
		}
		if(StringUtils.isBlank(siteCode)){
			map.put("error", true);
			map.put("message", "站点编号必填!");
			return map;
		}
		try{
		SiteInfoExample example = new SiteInfoExample();
		example.createCriteria().andSiteCodeEqualTo(Long.valueOf(siteCode));
		List<SiteInfo> siList = siteInfoMapper.selectByExample(example );
		if(siList.size()>0){
			map.put("error", true);
			map.put("message", "站点编号已存在!");
			return map;
		}
		}catch(Exception e){
			map.put("error", true);
			map.put("message", "站点编号格式只能数字!");
			return map;
		}
		SiteInfo siteInfo = new SiteInfo();
		siteInfo.setSiteCode(Long.valueOf(siteCode));
		siteInfo.setSiteType(siteType);
		siteInfo.setSiteName(siteName);
		siteInfo.setServiceGroup(serviceGroup);
		siteInfo.setVoltageGrade(voltageGrade);
		siteInfo.setWorkTime(workTime);
		siteInfo.setIsIntelligent(isIntelligent);
		siteInfo.setIsHub(isHub);
		siteInfo.setSiteLevel(siteLevel);
		siteInfo.setDutyType(dutyType);
		siteInfo.setAgentService(agentService);
		siteInfo.setCablingType(cablingType);
		siteInfo.setContaminationLevel(contaminationLevel);
		siteInfo.setSiteAddr(siteAddr);
		
		if(areaCovered!=null && MathUtils.IsDouble(areaCovered)){
			siteInfo.setAreaCovered(new BigDecimal(areaCovered));
		}
		if(buildingArea!=null && MathUtils.IsDouble(buildingArea)){
			siteInfo.setBuildingArea(new BigDecimal(buildingArea));
		}
		
		siteInfo.setRegionFeatures(regionFeatures);
		siteInfo.setContactTel(contactTel);
		siteInfo.setShortName(shortName);
		siteInfo.setEquipmentOwner(equipmentOwner);
		siteInfo.setRemark(remark);
		if(totalCapacity!=null && MathUtils.IsDouble(totalCapacity)){
			siteInfo.setTotalCapacity(new BigDecimal(totalCapacity));
		}
		if(equipmentNum!=null && MathUtils.IsDouble(equipmentNum)){
			siteInfo.setEquipmentNum(Short.valueOf(equipmentNum));
		}
		siteInfo.setImportantDegree(importantDegree);
		siteInfo.setIsUnderground(isUnderground);
		siteInfo.setIsIndependent(isIndependent);
		siteInfo.setPreventionType(preventionType);
		siteInfo.setHasRingNetwork(hasRingNetwork);
		if(compensateCapacity!=null && MathUtils.IsDouble(compensateCapacity)){
			siteInfo.setCompensateCapacity(Long.valueOf(compensateCapacity));
		}
		siteInfo.setEquipmentCode(equipmentCode);
		if(longitudePoint!=null && MathUtils.IsDouble(longitudePoint)){
			siteInfo.setLongitudePoint(new BigDecimal(longitudePoint));
		}
		if(latitudePoint!=null && MathUtils.IsDouble(latitudePoint)){
			siteInfo.setLatitudePoint(new BigDecimal(latitudePoint));
		}
		siteInfo.setBelongArea(belongArea);
		siteInfo.setState("N");
		siteInfo.setUserId(userId);
		siteInfo.setComeFrom("管理添加");
		siteInfo.setCreateTime(DateUtils.getTimeString().replaceAll("-","").replaceAll(":","").replaceAll(" ","").substring(0, 14));
		siteInfo.setUpdateTime(DateUtils.getTimeString().replaceAll("-","").replaceAll(":","").replaceAll(" ","").substring(0, 14));
		
		try{
			siteInfoMapper.insert(siteInfo);
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
	
	 
	@RequestMapping(value="/ToUpdateAdminSite", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView ToUpdateAdminSite(HttpServletRequest request,HttpServletResponse response ,String id ,ModelAndView model) {
		SiteInfo siteInfo = new SiteInfo();
		try{
			siteInfo = siteInfoMapper.selectByPrimaryKey(Long.valueOf(id));
			List<String> belongAreaList = siteInfoCustMapper.selectSiteAreaList();
			model.addObject("belongAreaList",belongAreaList);
			siteInfo.setCreateTime(siteInfo.getCreateTime().replace("-", ""));
		}catch(Exception e){
			e.printStackTrace();
//			map.put("error", true);
		}
		model.addObject("siteInfo",siteInfo);
		model.setViewName("siteManager/UpdateAdminSite");
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
	 
	@RequestMapping(value="/SaveAdminSite", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> SaveAdminSite(HttpServletRequest request,HttpServletResponse response ,String id,String siteCode,String siteType,String siteName,String serviceGroup,String voltageGrade,String workTime,                     String isIntelligent, String isHub, String siteLevel ,String dutyType, String agentService, String cablingType, String contaminationLevel, String siteAddr, String areaCovered, String buildingArea, String regionFeatures, String contactTel, String shortName, String equipmentOwner, String remark, String totalCapacity, String equipmentNum, String importantDegree, String isUnderground, String isIndependent, String preventionType, String hasRingNetwork, String compensateCapacity, String equipmentCode, String longitudePoint, String latitudePoint,String state  ,String belongArea                                                                          ,ModelAndView model) throws IOException{
		Map<String ,Object> map = new HashMap<String , Object>();
		
		SiteInfo siteInfo = new SiteInfo();
		siteInfo = siteInfoMapper.selectByPrimaryKey(Long.valueOf(id));
		if(StringUtils.isNotBlank(siteCode)){
			siteInfo.setSiteCode(Long.valueOf(siteCode));
		}
		if(StringUtils.isNotBlank(siteType)){
			siteInfo.setSiteType(siteType);
		}
		if(StringUtils.isNotBlank(siteName)){
			siteInfo.setSiteName(siteName);
		}
		if(StringUtils.isNotBlank(serviceGroup)){
			siteInfo.setServiceGroup(serviceGroup);
		}
		if(StringUtils.isNotBlank(voltageGrade)){
			siteInfo.setVoltageGrade(voltageGrade);
		}
		if(StringUtils.isNotBlank(workTime)){
			siteInfo.setWorkTime(workTime);
		}
		
		if(StringUtils.isNotBlank(isIntelligent)){
			siteInfo.setIsIntelligent(isIntelligent);
		}
		if(StringUtils.isNotBlank(isHub)){
			siteInfo.setIsHub(isHub);
		}
		if(StringUtils.isNotBlank(siteLevel)){
			siteInfo.setSiteLevel(siteLevel);
		}
		if(StringUtils.isNotBlank(dutyType)){
			siteInfo.setDutyType(dutyType);
		}
		if(StringUtils.isNotBlank(agentService)){
			siteInfo.setAgentService(agentService);
		}
		if(StringUtils.isNotBlank(cablingType)){
			siteInfo.setCablingType(cablingType);
		}
		if(StringUtils.isNotBlank(contaminationLevel)){
			siteInfo.setContaminationLevel(contaminationLevel);
		}
		if(StringUtils.isNotBlank(siteAddr)){
			siteInfo.setSiteAddr(siteAddr);
		}
		if(StringUtils.isNotBlank(areaCovered)){
			siteInfo.setAreaCovered(new BigDecimal(areaCovered));
		}
		if(StringUtils.isNotBlank(buildingArea)){
			siteInfo.setBuildingArea(new BigDecimal(buildingArea));
		}
		if(StringUtils.isNotBlank(regionFeatures)){
			siteInfo.setRegionFeatures(regionFeatures);
		}
		if(StringUtils.isNotBlank(contactTel)){
			siteInfo.setContactTel(contactTel);
		}
		if(StringUtils.isNotBlank(shortName)){
			siteInfo.setShortName(shortName);
		}
		if(StringUtils.isNotBlank(equipmentOwner)){
			siteInfo.setEquipmentOwner(equipmentOwner);
		}
		if(StringUtils.isNotBlank(remark)){
			siteInfo.setRemark(remark);
		}
		if(StringUtils.isNotBlank(totalCapacity)){
			siteInfo.setTotalCapacity(new BigDecimal(totalCapacity));
		}
		if(StringUtils.isNotBlank(equipmentNum)){
			siteInfo.setEquipmentNum(Short.valueOf(equipmentNum));
		}
		if(StringUtils.isNotBlank(importantDegree)){
			siteInfo.setImportantDegree(importantDegree);
		}
		if(StringUtils.isNotBlank(isUnderground)){
			siteInfo.setIsUnderground(isUnderground);
		}
		if(StringUtils.isNotBlank(isIndependent)){
			siteInfo.setIsIndependent(isIndependent);
		}
		if(StringUtils.isNotBlank(preventionType)){
			siteInfo.setPreventionType(preventionType);
		}
		if(StringUtils.isNotBlank(hasRingNetwork)){
			siteInfo.setHasRingNetwork(hasRingNetwork);
		}
		if(StringUtils.isNotBlank(compensateCapacity)){
			siteInfo.setCompensateCapacity(Long.valueOf(compensateCapacity));
		}
		if(StringUtils.isNotBlank(equipmentCode)){
			siteInfo.setEquipmentCode(equipmentCode);
		}
		if(StringUtils.isNotBlank(longitudePoint)){
			siteInfo.setLongitudePoint(new BigDecimal(longitudePoint));
		}
		if(StringUtils.isNotBlank(latitudePoint)){
			siteInfo.setLatitudePoint(new BigDecimal(latitudePoint));
		}
		if(StringUtils.isNotBlank(state)){
			siteInfo.setState(state);
		}
		if(StringUtils.isNotBlank(belongArea)){
			siteInfo.setBelongArea(belongArea);
		}
		
		siteInfo.setUpdateTime(DateUtils.getTimeString().replaceAll("-","").replaceAll(":","").replaceAll(" ","").substring(0, 14));
		
		
		try{
			siteInfoMapper.updateByPrimaryKey(siteInfo);
			map.put("success", true);
		}catch(Exception e){
			e.printStackTrace();
			map.put("error", true);
		}
	return map;
	}
	
	
	
	@RequestMapping(value="/ToUpdateSiteImages", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView ToUpdateSiteImages(HttpServletRequest request,HttpServletResponse response ,String id ,ModelAndView model) {
		SiteInfo siteInfo = new SiteInfo();
		SiteImagesVO siteImagesVo = new SiteImagesVO();
		try{
			
			siteInfo = siteInfoMapper.selectByPrimaryKey(Long.valueOf(id));
			if(siteInfo!=null){
				siteImagesVo.setSiteId(Long.valueOf(id));
				if(siteInfo.getImagePath()!=null){
					siteImagesVo.setSiteImages(siteInfo.getImagePath());
				}
			}
			
			
			
			SitePictureExample example = new SitePictureExample();
			example.createCriteria().andSiteIdEqualTo(Long.valueOf(id));
			List<SitePicture> list = sitePictureMapper.selectByExample(example );
			for(SitePicture sitePicture : list){
				if("T1".equals(sitePicture.getType())){
					siteImagesVo.setImages1Id(sitePicture.getId());
					siteImagesVo.setImages1Path(sitePicture.getPictureAddr());
				}
				if("T2".equals(sitePicture.getType())){
					siteImagesVo.setImages2Id(sitePicture.getId());
					siteImagesVo.setImages2Path(sitePicture.getPictureAddr());
				}
			}
		}catch(Exception e){
			e.printStackTrace();
//			map.put("error", true);
		}
		model.addObject("siteImagesVo",siteImagesVo);
		model.setViewName("siteManager/AdminSiteImages");
		return model;
	}
	
	/**
	 * 进入图片管理页面
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	
	 
	@RequestMapping(value="/ToUpdateSiteImages1", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView ToUpdateSiteImages1(HttpServletRequest request,HttpServletResponse response ,String id ,ModelAndView model) {
		SiteInfo siteInfo = new SiteInfo();
		SiteImagesVO siteImagesVo = new SiteImagesVO();
		try{
			siteInfo = siteInfoMapper.selectByPrimaryKey(Long.valueOf(id));
			if(siteInfo!=null&&siteInfo.getImagePath()!=null){
				siteImagesVo.setSiteId(Long.valueOf(id));
				siteImagesVo.setSiteImages(siteInfo.getImagePath());
			}
			
			
			SitePictureExample example = new SitePictureExample();
			example.createCriteria().andSiteIdEqualTo(Long.valueOf(id));
			List<SitePicture> list = sitePictureMapper.selectByExample(example );
			for(SitePicture sitePicture : list){
				if("T1".equals(sitePicture.getType())){
					siteImagesVo.setImages1Id(sitePicture.getId());
					siteImagesVo.setImages1Path(sitePicture.getPictureAddr());
				}
				if("T2".equals(sitePicture.getType())){
					siteImagesVo.setImages2Id(sitePicture.getId());
					siteImagesVo.setImages2Path(sitePicture.getPictureAddr());
				}
			}
		}catch(Exception e){
			e.printStackTrace();
//			map.put("error", true);
		}
		model.addObject("siteImagesVo",siteImagesVo);
		model.setViewName("siteManager/UpdateAdminSite");
		return model;
	}
	
	
	
	 @RequestMapping("/uploadImages")
	    @ResponseBody
	    public  Map<String,Object> uploadImages( HttpServletRequest request, HttpServletResponse response) throws IOException {
		 
//		 @RequestParam("sitePhoto") MultipartFile file,@RequestParam("siteId") String siteId,
		 MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		 String siteId = request.getParameter("siteId");
		 MultipartFile file = multipartRequest.getFile("sitePhoto");
		 MultipartFile file1 = multipartRequest.getFile("sitePhoto1");
		 MultipartFile file2 = multipartRequest.getFile("sitePhoto2");
		 MultipartFile file3 = multipartRequest.getFile("sitePhoto3");
		 String siteImages = request.getParameter("siteImages");
		 
		 String imagesList[] = siteImages.split(",");
	       Map<String ,Object> map = new HashMap<String,Object>();
	       try{
	    	   if((file==null || file.isEmpty())&&(file1==null || file1.isEmpty())&&(file2==null || file2.isEmpty())&&(file3==null || file3.isEmpty())){
	    		   map.put("success", true);
	    		   map.put("message", "请选择上传图片!");
	    	   }else{
				       if(file!=null&&!file.isEmpty()){
				    	   //删除文件
				    	   if(imagesList.length>0){
				    		   FileUpload.deleteImages(imagesList[0], request);
				    		   String filePath = FileUpload.uploadImages(file,siteId,"T01"+System.currentTimeMillis(), request);
					    	   logger.info("filePath:" + filePath);
					    	   siteImages = siteImages.replace(imagesList[0], filePath);
				    	   }else{
				    		   String filePath = FileUpload.uploadImages(file,siteId,"T01"+System.currentTimeMillis(), request);
					    	   logger.info("filePath:" + filePath);
				    		   siteImages =  filePath;
				    	   }
				    	   
				    	  
				       }
				       
				       
				       if(file1!=null&&!file1.isEmpty()){
				    	   //删除文件
				    	   if(imagesList.length>1){
				    		   FileUpload.deleteImages(imagesList[1], request);
				    		   String filePath = FileUpload.uploadImages(file1,siteId,"T01"+System.currentTimeMillis(), request);
					    	   logger.info("filePath:" + filePath);
					    	   siteImages = siteImages.replace(imagesList[1], filePath);
				    	   }else{
				    		   String filePath = FileUpload.uploadImages(file1,siteId,"T01"+System.currentTimeMillis(), request);
					    	   logger.info("filePath:" + filePath);
				    		   siteImages += ","+filePath;
				    	   }
				    	   
				    	  
				       }
				       
				       if(file2!=null&&!file2.isEmpty()){
				    	   //删除文件
				    	   if(imagesList.length>2){
				    		   FileUpload.deleteImages(imagesList[2], request);
				    		   String filePath = FileUpload.uploadImages(file2,siteId,"T01"+System.currentTimeMillis(), request);
					    	   logger.info("filePath:" + filePath);
					    	   siteImages = siteImages.replace(imagesList[2], filePath);
				    	   }else{
				    		   String filePath = FileUpload.uploadImages(file2,siteId,"T01"+System.currentTimeMillis(), request);
					    	   logger.info("filePath:" + filePath);
				    		   siteImages += ","+filePath;
				    	   }
				    	   
				    	  
				       }
				       
				       if(file3!=null&&!file3.isEmpty()){
				    	   //删除文件
				    	   if(imagesList.length>3){
				    		   FileUpload.deleteImages(imagesList[3], request);
				    		   String filePath = FileUpload.uploadImages(file3,siteId,"T01"+System.currentTimeMillis(), request);
					    	   logger.info("filePath:" + filePath);
					    	   siteImages = siteImages.replace(imagesList[3], filePath);
				    	   }else{
				    		   String filePath = FileUpload.uploadImages(file3,siteId,"T01"+System.currentTimeMillis(), request);
					    	   logger.info("filePath:" + filePath);
				    		   siteImages += ","+filePath;
				    	   }
				    	   
				    	  
				       }
				       
				       
				    	   SiteInfo siteInfo = new SiteInfo();
				    	   siteInfo.setId(Long.valueOf(siteId));
				    	   siteInfo.setImagePath(siteImages);
				    	   siteInfo.setUpdateTime(DateUtils.getTimeString().replaceAll("-","").replaceAll(":","").replaceAll(" ","").substring(0, 14));
				    		   siteInfoMapper.updateByPrimaryKeySelective(siteInfo);
				    		   map.put("success", true);
				    		   map.put("message", "上传图片成功!");
	      
	    	 
	       
	       
	    	   }   
	    	   }catch(Exception e){
	    		   e.printStackTrace();
	    		   logger.info("上传图片失败");
	    		   map.put("error", true);
	    		   map.put("message", "上传图片失败!");
	    	   }
//	        response.setContentType("text/html;charset=utf8");
//	        response.getWriter().write("<img src='"+filePath+"'/>");
	        return map;
	    }
	 
	 
	 @RequestMapping("/uploadImages1")
	    @ResponseBody
	    public  Map<String,Object> uploadImages1( HttpServletRequest request, HttpServletResponse response) throws IOException {
	       Map<String ,Object> map = new HashMap<String,Object>();
	       
	       MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
	       String images1Id = request.getParameter("images1Id");
	       String siteId = request.getParameter("siteId");
	       String images1Path = request.getParameter("images1Path");
	       MultipartFile images1file = multipartRequest.getFile("images1Photo");
	       MultipartFile images1file1 = multipartRequest.getFile("images1Photo1");
	       MultipartFile images1file2 = multipartRequest.getFile("images1Photo2");
	       MultipartFile images1file3 = multipartRequest.getFile("images1Photo3");
	       String imagesList[] = images1Path.split(",");
	       try{
	     
	    	   if((images1file==null || images1file.isEmpty())&&(images1file1==null || images1file1.isEmpty())&&(images1file2==null || images1file2.isEmpty())&&(images1file3==null || images1file3.isEmpty())){
	    		   map.put("success", true);
	    		   map.put("message", "请选择上传图片!");
	    	   }else{
	    		   
	    	   }
	       if(images1file!=null&&!images1file.isEmpty()){
	    	 //删除文件
//	    	   if(StringUtils.isNoneBlank(images1Id)){
//		    	   SitePicture temp = sitePictureMapper.selectByPrimaryKey(Long.valueOf(images1Id));
//		    	   if(temp!=null && temp.getPictureAddr()!=null){
//		    		   FileUpload.deleteImages(temp.getPictureAddr(), request);
//		    	   }
//	    	   }
//	    	   String filePath = FileUpload.uploadImages(images1file,siteId,"T1"+System.currentTimeMillis(), request);
//	    	   logger.info("filePath:" + filePath);
	    	   
	    	   if(imagesList.length>0){
	    		   FileUpload.deleteImages(imagesList[0], request);
	    		   String filePath = FileUpload.uploadImages(images1file,siteId,"T1"+System.currentTimeMillis(), request);
		    	   logger.info("filePath:" + filePath);
		    	   images1Path = images1Path.replace(imagesList[0], filePath);
	    	   }else{
	    		   String filePath = FileUpload.uploadImages(images1file,siteId,"T1"+System.currentTimeMillis(), request);
		    	   logger.info("filePath:" + filePath);
		    	   images1Path =  filePath;
	    	   }
	       }
	       
	       if(images1file1!=null&&!images1file1.isEmpty()){
	    	   //删除文件
	    	   if(imagesList.length>1){
	    		   FileUpload.deleteImages(imagesList[1], request);
	    		   String filePath = FileUpload.uploadImages(images1file1,siteId,"T1"+System.currentTimeMillis(), request);
		    	   logger.info("filePath:" + filePath);
		    	   images1Path = images1Path.replace(imagesList[1], filePath);
	    	   }else{
	    		   String filePath = FileUpload.uploadImages(images1file1,siteId,"T1"+System.currentTimeMillis(), request);
		    	   logger.info("filePath:" + filePath);
		    	   images1Path += ","+filePath;
	    	   }
	    	   
	    	  
	       }
	       
	       if(images1file2!=null&&!images1file2.isEmpty()){
	    	   //删除文件
	    	   if(imagesList.length>2){
	    		   FileUpload.deleteImages(imagesList[2], request);
	    		   String filePath = FileUpload.uploadImages(images1file2,siteId,"T1"+System.currentTimeMillis(), request);
		    	   logger.info("filePath:" + filePath);
		    	   images1Path = images1Path.replace(imagesList[2], filePath);
	    	   }else{
	    		   String filePath = FileUpload.uploadImages(images1file2,siteId,"T1"+System.currentTimeMillis(), request);
		    	   logger.info("filePath:" + filePath);
		    	   images1Path += ","+filePath;
	    	   }
	    	   
	    	  
	       }
	       
	       if(images1file3!=null&&!images1file3.isEmpty()){
	    	   //删除文件
	    	   if(imagesList.length>3){
	    		   FileUpload.deleteImages(imagesList[3], request);
	    		   String filePath = FileUpload.uploadImages(images1file3,siteId,"T1"+System.currentTimeMillis(), request);
		    	   logger.info("filePath:" + filePath);
		    	   images1Path = images1Path.replace(imagesList[3], filePath);
	    	   }else{
	    		   String filePath = FileUpload.uploadImages(images1file3,siteId,"T1"+System.currentTimeMillis(), request);
		    	   logger.info("filePath:" + filePath);
		    	   images1Path += ","+filePath;
	    	   }
	    	   
	    	  
	       }
	       
	    	   
	    	   SitePicture sitePicture = new SitePicture();
	    	  if(StringUtils.isNoneBlank(images1Id)){
	    		  sitePicture.setId(Long.valueOf(images1Id));
	    		  sitePicture.setPictureAddr(images1Path);
	    		  sitePicture.setUpdateTime(DateUtils.getTimeString().replaceAll("-","").replaceAll(":","").replaceAll(" ","").substring(0, 14));
	    		  sitePictureMapper.updateByPrimaryKeySelective(sitePicture);
	    	  }else{
	    		  
	    		  
	    		  SitePictureExample example = new SitePictureExample();
	    		  example.createCriteria().andSiteIdEqualTo(Long.valueOf(siteId)).andTypeEqualTo("T1");
	    		  List<SitePicture> list = sitePictureMapper.selectByExample(example);
	    		  
	    		  if(list.size()>0){
	    			  sitePicture.setId(list.get(0).getId());
	    			  sitePicture.setPictureAddr(images1Path);
	    			  sitePicture.setUpdateTime(DateUtils.getTimeString().replaceAll("-","").replaceAll(":","").replaceAll(" ","").substring(0, 14));
		    		  sitePictureMapper.updateByPrimaryKeySelective(sitePicture);
	    		  }else{
	    			  String sessionId = request.getSession().getId();
	    			String userId =  request.getSession().getAttribute(sessionId).toString();
	    			  sitePicture.setSiteId(Long.valueOf(siteId));
	    			  sitePicture.setPictureAddr(images1Path);
	    			  sitePicture.setState("N");
	    			  sitePicture.setType("T1");
	    			  sitePicture.setCreateTime(DateUtils.getTimeString().replaceAll("-","").replaceAll(":","").replaceAll(" ","").substring(0, 14));
	    			  sitePicture.setUpdateTime(DateUtils.getTimeString().replaceAll("-","").replaceAll(":","").replaceAll(" ","").substring(0, 14));
	    			  sitePicture.setUserId(userId);
	    			  sitePictureMapper.insert(sitePicture);
	    		  }
	    	  }
//	    	  
//	    	  if(!images2file.isEmpty()){
//		    	   String filePath = FileUpload.uploadImages(images2file,siteId,"T2", request);
//		    	   logger.info("filePath:" + filePath);
//		    	   SitePicture sitePicture = new SitePicture();
//		    	  if(images2Id!=null){
//		    		  sitePicture.setId(Long.valueOf(images2Id));
//		    		  sitePicture.setPictureAddr(filePath);
//		    		  sitePicture.setUpdateTime(DateUtils.getTimeString().replaceAll("-","").replaceAll(":","").replaceAll(" ","").substring(0, 14));
//		    		  sitePictureMapper.updateByPrimaryKeySelective(sitePicture);
//		    	  }else{
//		    		  
//		    		  
//		    		  SitePictureExample example = new SitePictureExample();
//		    		  example.createCriteria().andSiteIdEqualTo(Long.valueOf(siteId)).andTypeEqualTo("T2");
//		    		  List<SitePicture> list = sitePictureMapper.selectByExample(example);
//		    		  
//		    		  if(list.size()>0){
//		    			  sitePicture.setId(list.get(0).getId());
//		    			  sitePicture.setPictureAddr(filePath);
//		    			  sitePicture.setUpdateTime(DateUtils.getTimeString().replaceAll("-","").replaceAll(":","").replaceAll(" ","").substring(0, 14));
//			    		  sitePictureMapper.updateByPrimaryKeySelective(sitePicture);
//		    		  }else{
//		    			  sitePicture.setSiteId(Long.valueOf(siteId));
//		    			  sitePicture.setPictureAddr(filePath);
//		    			  sitePicture.setState("N");
//		    			  sitePicture.setType("T2");
//		    			  sitePicture.setCreateTime(DateUtils.getTimeString().replaceAll("-","").replaceAll(":","").replaceAll(" ","").substring(0, 14));
//		    			  sitePicture.setCreateTime(DateUtils.getTimeString().replaceAll("-","").replaceAll(":","").replaceAll(" ","").substring(0, 14));
//		    			  sitePictureMapper.insert(sitePicture);
//		    		  }
//		    	  }
//	    	  }
	    		   map.put("success", true);
	    		   return map;
	    	   }catch(Exception e){
	    		   e.printStackTrace();
	    		   logger.info("上传图片失败");
	    		   map.put("error", true);
	    		   map.put("message", "上传图片失败!");
	    		   return map;
	    	   }
//	        response.setContentType("text/html;charset=utf8");
//	        response.getWriter().write("<img src='"+filePath+"'/>");
//	        return map;
	    }
	 
	 @RequestMapping("/uploadImages2")
	    @ResponseBody
	    public  Map<String,Object> uploadImages2( HttpServletRequest request, HttpServletResponse response) throws IOException {
	       Map<String ,Object> map = new HashMap<String,Object>();
	       
	       MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
	       String images2Id = request.getParameter("images2Id");
	       String siteId = request.getParameter("siteId");
	       String images2Path = request.getParameter("images2Path");
	       MultipartFile images2file = multipartRequest.getFile("images2Photo");
	       MultipartFile images2file1 = multipartRequest.getFile("images2Photo1");
	       MultipartFile images2file2 = multipartRequest.getFile("images2Photo2");
	       MultipartFile images2file3 = multipartRequest.getFile("images2Photo3");
	       String imagesList[] = images2Path.split(",");
	       
	       try{
	     
	    	   if((images2file==null || images2file.isEmpty())&&(images2file1==null || images2file1.isEmpty())&&(images2file2==null || images2file2.isEmpty())&&(images2file3==null || images2file3.isEmpty())){
	    		   map.put("success", true);
	    		   map.put("message", "请选择上传图片!");
	    	   }else{
	    		   
	    	   }
	       if(images2file!=null&&!images2file.isEmpty()){

//	    	  
//	    	  if(!images2file.isEmpty()){
//	    		  //删除文件
//	    		  if(StringUtils.isNoneBlank(images2Id)){
//			    	   SitePicture temp = sitePictureMapper.selectByPrimaryKey(Long.valueOf(images2Id));
//			    	   if(temp!=null && temp.getPictureAddr()!=null){
//			    		   FileUpload.deleteImages(temp.getPictureAddr(), request);
//			    	   }
//	    		  }
//		    	   
//		    	   String filePath = FileUpload.uploadImages(images2file,siteId,"T2"+System.currentTimeMillis(), request);
//		    	   logger.info("filePath:" + filePath);
	    	   
	    	   if(imagesList.length>0){
	    		   FileUpload.deleteImages(imagesList[0], request);
	    		   String filePath = FileUpload.uploadImages(images2file,siteId,"T2"+System.currentTimeMillis(), request);
		    	   logger.info("filePath:" + filePath);
		    	   images2Path = images2Path.replace(imagesList[0], filePath);
	    	   }else{
	    		   String filePath = FileUpload.uploadImages(images2file,siteId,"T2"+System.currentTimeMillis(), request);
		    	   logger.info("filePath:" + filePath);
		    	   images2Path =  filePath;
	    	   }
	       }
	       
	       if(images2file1!=null&&!images2file1.isEmpty()){
	    	   //删除文件
	    	   if(imagesList.length>1){
	    		   FileUpload.deleteImages(imagesList[1], request);
	    		   String filePath = FileUpload.uploadImages(images2file1,siteId,"T2"+System.currentTimeMillis(), request);
		    	   logger.info("filePath:" + filePath);
		    	   images2Path = images2Path.replace(imagesList[1], filePath);
	    	   }else{
	    		   String filePath = FileUpload.uploadImages(images2file1,siteId,"T2"+System.currentTimeMillis(), request);
		    	   logger.info("filePath:" + filePath);
		    	   images2Path += ","+filePath;
	    	   }
	    	   
	    	  
	       }
	       
	       if(images2file2!=null&&!images2file2.isEmpty()){
	    	   //删除文件
	    	   if(imagesList.length>2){
	    		   FileUpload.deleteImages(imagesList[2], request);
	    		   String filePath = FileUpload.uploadImages(images2file2,siteId,"T2"+System.currentTimeMillis(), request);
		    	   logger.info("filePath:" + filePath);
		    	   images2Path = images2Path.replace(imagesList[2], filePath);
	    	   }else{
	    		   String filePath = FileUpload.uploadImages(images2file2,siteId,"T2"+System.currentTimeMillis(), request);
		    	   logger.info("filePath:" + filePath);
		    	   images2Path += ","+filePath;
	    	   }
	    	   
	    	  
	       }
	       
	       if(images2file3!=null&&!images2file3.isEmpty()){
	    	   //删除文件
	    	   if(imagesList.length>3){
	    		   FileUpload.deleteImages(imagesList[3], request);
	    		   String filePath = FileUpload.uploadImages(images2file3,siteId,"T2"+System.currentTimeMillis(), request);
		    	   logger.info("filePath:" + filePath);
		    	   images2Path = images2Path.replace(imagesList[3], filePath);
	    	   }else{
	    		   String filePath = FileUpload.uploadImages(images2file3,siteId,"T2"+System.currentTimeMillis(), request);
		    	   logger.info("filePath:" + filePath);
		    	   images2Path += ","+filePath;
	    	   }
	    	   
	    	  
	       }
	    	   
	    	   
	    	   
		    	   SitePicture sitePicture = new SitePicture();
		    	  if(StringUtils.isNoneBlank(images2Id)){
		    		  sitePicture.setId(Long.valueOf(images2Id));
		    		  sitePicture.setPictureAddr(images2Path);
		    		  sitePicture.setUpdateTime(DateUtils.getTimeString().replaceAll("-","").replaceAll(":","").replaceAll(" ","").substring(0, 14));
		    		  sitePictureMapper.updateByPrimaryKeySelective(sitePicture);
		    	  }else{
		    		  
		    		  
		    		  SitePictureExample example = new SitePictureExample();
		    		  example.createCriteria().andSiteIdEqualTo(Long.valueOf(siteId)).andTypeEqualTo("T2");
		    		  List<SitePicture> list = sitePictureMapper.selectByExample(example);
		    		  
		    		  if(list.size()>0){
		    			  sitePicture.setId(list.get(0).getId());
		    			  sitePicture.setPictureAddr(images2Path);
		    			  sitePicture.setUpdateTime(DateUtils.getTimeString().replaceAll("-","").replaceAll(":","").replaceAll(" ","").substring(0, 14));
			    		  sitePictureMapper.updateByPrimaryKeySelective(sitePicture);
		    		  }else{
		    			  String sessionId = request.getSession().getId();
			    			String userId =  request.getSession().getAttribute(sessionId).toString();
		    			  sitePicture.setSiteId(Long.valueOf(siteId));
		    			  sitePicture.setPictureAddr(images2Path);
		    			  sitePicture.setState("N");
		    			  sitePicture.setType("T2");
		    			  sitePicture.setCreateTime(DateUtils.getTimeString().replaceAll("-","").replaceAll(":","").replaceAll(" ","").substring(0, 14));
		    			  sitePicture.setUpdateTime(DateUtils.getTimeString().replaceAll("-","").replaceAll(":","").replaceAll(" ","").substring(0, 14));
		    			  sitePicture.setUserId(userId);
		    			  sitePictureMapper.insert(sitePicture);
		    		  }
		    	  }
	    		   map.put("success", true);
	    		   return map;
	    	   }catch(Exception e){
	    		   e.printStackTrace();
	    		   logger.info("上传图片失败");
	    		   map.put("message", "上传图片失败!");
	    		   map.put("error", true);
	    		   return map;
	    	   }
//	        response.setContentType("text/html;charset=utf8");
//	        response.getWriter().write("<img src='"+filePath+"'/>");
//	        return map;
	    }
	 
	 
	 @RequestMapping(value="/ToAddBatch", method=RequestMethod.POST)
		@ResponseBody
		public ModelAndView ToAddBatch(HttpServletRequest request,HttpServletResponse response ,String id ,ModelAndView model) {
			
			model.setViewName("siteManager/AddBatchSite");
			return model;
		}
	 
	 
	 @RequestMapping("/uploadBatchSite")
	    @ResponseBody
	    public  Map<String,Object> uploadBatchSite(@RequestParam("siteBatch") MultipartFile siteBatch,   HttpServletRequest request, HttpServletResponse response) throws IOException {
	       Map<String ,Object> map = new HashMap<String,Object>();
	
	    	  if(!siteBatch.isEmpty()){
		    	   String filePath = FileUpload.uploadFile(siteBatch, request);
		    	   logger.info("filePath:" + filePath);

		    	   String fileName1 = siteBatch.getOriginalFilename();
		    	   int count,skilp,num;
		    	   count=skilp=num=0;
		    	   Workbook rwb = null;
		    	   try{
		    	    InputStream is = new FileInputStream(filePath);
		    	    rwb = Workbook.getWorkbook(is);
		    	    // 获取第一张Sheet表
		    	    Sheet rs = rwb.getSheet(0);
		    	    for (int k = 1; k < rs.getRows(); k++){
		    	    	count++;
		    	     String siteCode=rs.getCell(0, k)==null?null:rs.getCell(0, k).getContents();
		    	     String siteType=rs.getCell(1, k)==null?null:rs.getCell(1, k).getContents();
		    	     String siteName = rs.getCell(2, k)==null?"":rs.getCell(2, k).getContents();
		    	     String serviceGroup=rs.getCell(3, k)==null?null:rs.getCell(3, k).getContents();
		    	     String voltageGrade=rs.getCell(4, k)==null?null:rs.getCell(4, k).getContents();
		    	     String workTime = rs.getCell(5, k)==null?null:rs.getCell(5, k).getContents();
		    	     String isIntelligent=rs.getCell(6, k)==null?null:rs.getCell(6, k).getContents();
		    	     String isHub=rs.getCell(7, k)==null?null:rs.getCell(7, k).getContents();
		    	     String siteLevel = rs.getCell(8, k)==null?null:rs.getCell(8, k).getContents();
		    	     String dutyType=rs.getCell(9, k)==null?null:rs.getCell(9, k).getContents();
		    	     String agentService=rs.getCell(10, k)==null?null:rs.getCell(10, k).getContents();
		    	     String cablingType = rs.getCell(11, k)==null?null:rs.getCell(11, k).getContents();
		    	     String contaminationLevel=rs.getCell(12, k)==null?null:rs.getCell(12, k).getContents();
		    	     String siteAddr=rs.getCell(13, k)==null?null:rs.getCell(13, k).getContents();
		    	     String areaCovered = rs.getCell(14, k)==null?null:rs.getCell(14, k).getContents();
		    	     String buildingArea=rs.getCell(15, k)==null?null:rs.getCell(15, k).getContents();
		    	     String regionFeatures=rs.getCell(16, k)==null?null:rs.getCell(16, k).getContents();
		    	     String contactTel = rs.getCell(17, k)==null?null:rs.getCell(17, k).getContents();
		    	     String shortName=rs.getCell(18, k)==null?null:rs.getCell(18, k).getContents();
		    	     String equipmentOwner=rs.getCell(19, k)==null?null:rs.getCell(19, k).getContents();
		    	     String remark = rs.getCell(20, k)==null?null:rs.getCell(20, k).getContents();
		    	     String totalCapacity=rs.getCell(21, k)==null?null:rs.getCell(21, k).getContents();
		    	     String equipmentNum=rs.getCell(22, k)==null?null:rs.getCell(22, k).getContents();
		    	     String importantDegree = rs.getCell(23, k)==null?null:rs.getCell(23, k).getContents();
		    	     String isUnderground=rs.getCell(24, k)==null?null:rs.getCell(24, k).getContents();
		    	     String isIndependent = rs.getCell(25, k)==null?null:rs.getCell(25, k).getContents();
		    	     String preventionType=rs.getCell(26, k)==null?null:rs.getCell(26, k).getContents();
		    	     String hasRingNetwork=rs.getCell(27, k)==null?null:rs.getCell(27, k).getContents();
		    	     String compensateCapacity = rs.getCell(28, k)==null?null:rs.getCell(28, k).getContents();
		    	     String equipmentCode=rs.getCell(29, k)==null?null:rs.getCell(29, k).getContents();
		    	     String longitudePoint=rs.getCell(30, k)==null?null:rs.getCell(30, k).getContents();
		    	     String latitudePoint = rs.getCell(31, k)==null?null:rs.getCell(31, k).getContents();
		    	     String belongArea = rs.getCell(32, k)==null?null:rs.getCell(32, k).getContents();
		    	     
		    	   try{
		    		   SiteInfoExample example = new SiteInfoExample();
		    		  example.createCriteria().andSiteCodeEqualTo(Long.valueOf(siteCode));
		    		  List<SiteInfo> siList = siteInfoMapper.selectByExample(example );
		    		  if(siList.size()>0){
		    			  skilp++;
			    	      break;   
		    		  }
		    	   }catch(Exception e){
		    		   skilp++;
			    	      break;  
		    	   }
		    	     
		    	     if(siteCode.equals("")||siteName.equals("")||siteName.equals("")||siteName.equals("")){
		    	      skilp++;
		    	      break;
		    	     }else{
		    	     //插库
		    	    	 try{
		    	    		 	num++;
		    	    		 	//写数据库
		    	    		 	SiteInfo siteInfo = new SiteInfo();
		    	    		 	if(StringUtils.isNotBlank(siteCode)){
		    	    		 		siteInfo.setSiteCode(Long.valueOf(siteCode));
		    	    		 	}
		    	    		 	if(StringUtils.isNotBlank(siteType)){
		    	    		 		siteInfo.setSiteType(siteType);
		    	    		 	}
		    	    		 	if(StringUtils.isNotBlank(siteName)){
		    	    		 		siteInfo.setSiteName(siteName);
		    	    		 	}
		    	    		 	if(StringUtils.isNotBlank(serviceGroup)){
		    	    		 		siteInfo.setServiceGroup(serviceGroup);
		    	    		 	}
		    	    		 	if(StringUtils.isNotBlank(voltageGrade)){
		    	    		 		siteInfo.setVoltageGrade(voltageGrade);
		    	    		 	}
		    	    		 	if(StringUtils.isNotBlank(workTime)){
		    	    		 		siteInfo.setWorkTime(workTime);
		    	    		 	}
		    	    		 	if(StringUtils.isNotBlank(isIntelligent)){
		    	    		 		siteInfo.setIsIntelligent(isIntelligent);
		    	    		 	}
		    	    		 	if(StringUtils.isNotBlank(isHub)){
		    	    		 		siteInfo.setIsHub(isHub);
		    	    		 	}
		    	    		 	if(StringUtils.isNotBlank(siteLevel)){
		    	    		 		siteInfo.setSiteLevel(siteLevel);
		    	    		 	}
		    	    		 	if(StringUtils.isNotBlank(dutyType)){
		    	    		 		siteInfo.setDutyType(dutyType);
		    	    		 	}
		    	    		 	if(StringUtils.isNotBlank(agentService)){
		    	    		 		siteInfo.setAgentService(agentService);
		    	    		 	}
		    	    		 	if(StringUtils.isNotBlank(cablingType)){
		    	    		 		siteInfo.setCablingType(cablingType);
		    	    		 	}
		    	    		 	if(StringUtils.isNotBlank(contaminationLevel)){
		    	    		 		siteInfo.setContaminationLevel(contaminationLevel);
		    	    		 	}
		    	    		 	if(StringUtils.isNotBlank(siteAddr)){
		    	    		 		siteInfo.setSiteAddr(siteAddr);
		    	    		 	}
		    	    		 	if(StringUtils.isNotBlank(areaCovered)){
		    	    		 		siteInfo.setAreaCovered(new BigDecimal(areaCovered));
		    	    		 	}
		    	    		 	if(StringUtils.isNotBlank(buildingArea)){
		    	    		 		siteInfo.setBuildingArea(new BigDecimal(buildingArea));
		    	    		 	}
		    	    		 	if(StringUtils.isNotBlank(regionFeatures)){
		    	    		 		siteInfo.setRegionFeatures(regionFeatures);
		    	    		 	}
		    	    		 	if(StringUtils.isNotBlank(contactTel)){
		    	    		 		siteInfo.setContactTel(contactTel);
		    	    		 	}
		    	    		 	if(StringUtils.isNotBlank(shortName)){
		    	    		 		siteInfo.setShortName(shortName);
		    	    		 	}
		    	    		 	if(StringUtils.isNotBlank(equipmentOwner)){
		    	    		 		siteInfo.setEquipmentOwner(equipmentOwner);
		    	    		 	}
		    	    		 	if(StringUtils.isNotBlank(remark)){
		    	    		 		siteInfo.setRemark(remark);
		    	    		 	}
		    	    		 	if(StringUtils.isNotBlank(totalCapacity)){
		    	    		 		siteInfo.setTotalCapacity(new BigDecimal(totalCapacity));
		    	    		 	}
		    	    		 	if(StringUtils.isNotBlank(equipmentNum)){
		    	    		 		siteInfo.setEquipmentNum(Short.valueOf(equipmentNum));
		    	    		 	}
		    	    		 	if(StringUtils.isNotBlank(importantDegree)){
		    	    		 		siteInfo.setImportantDegree(importantDegree);
		    	    		 	}
		    	    		 	if(StringUtils.isNotBlank(isUnderground)){
		    	    		 		siteInfo.setIsUnderground(isUnderground);
		    	    		 	}
		    	    		 	if(StringUtils.isNotBlank(isIndependent)){
		    	    		 		siteInfo.setIsIndependent(isIndependent);
		    	    		 	}
		    	    		 	if(StringUtils.isNotBlank(preventionType)){
		    	    		 		siteInfo.setPreventionType(preventionType);
		    	    		 	}
		    	    		 	if(StringUtils.isNotBlank(hasRingNetwork)){
		    	    		 		siteInfo.setHasRingNetwork(hasRingNetwork);
		    	    		 	}
		    	    		 	if(StringUtils.isNotBlank(compensateCapacity)){
		    	    		 		siteInfo.setCompensateCapacity(Long.valueOf(compensateCapacity));
		    	    		 	}
		    	    		 	if(StringUtils.isNotBlank(equipmentCode)){
		    	    		 		siteInfo.setEquipmentCode(equipmentCode);
		    	    		 	}
		    	    		 	if(StringUtils.isNotBlank(longitudePoint)){
		    	    		 		siteInfo.setLongitudePoint(new BigDecimal(longitudePoint));
		    	    		 	}
		    	    		 	if(StringUtils.isNotBlank(latitudePoint)){
		    	    		 		siteInfo.setLatitudePoint(new BigDecimal(latitudePoint));
		    	    		 	}
		    	    		 	if(StringUtils.isNotBlank(belongArea)){
		    	    		 		siteInfo.setBelongArea(belongArea);
		    	    		 	}
		    	    		 	siteInfo.setComeFrom("批量上传");
		    	    			siteInfo.setState("N");
		    	    			siteInfo.setUserId(Long.valueOf(0));
		    	    			siteInfo.setCreateTime(DateUtils.getTimeString().replaceAll("-","").replaceAll(":","").replaceAll(" ","").substring(0, 14));
		    	    			siteInfo.setUpdateTime(DateUtils.getTimeString().replaceAll("-","").replaceAll(":","").replaceAll(" ","").substring(0, 14));
		    	    			
		    	    			
		    	    			siteInfoMapper.insertSelective(siteInfo);
		    	    		 	
		    	    		 	
		    	    	 }catch(Exception e){
		    	    		 e.printStackTrace();
		    	    		 skilp++;
		    	    	 }
		    	        }
		    	    }
		    	    map.put("success", true);
		    	    rwb.close();
		    	   }catch (Exception e){
		    		   logger.info("批量导入站点失败");
		    		   map.put("error", true);
		    		   map.put("message", "导入模版有误");
//		    	    e.printStackTrace();
		    	    
		    	   }
		    
		    	   
	    	  }
	    		  
//	        response.setContentType("text/html;charset=utf8");
//	        response.getWriter().write("<img src='"+filePath+"'/>");
	        return map;
	    }
	 
	 //导出Excel
	 @RequestMapping(value="/downBatch", method=RequestMethod.GET)
		@ResponseBody
		public void downBatch(HttpServletRequest request,HttpServletResponse response ,String siteCode ,String siteName , String siteType,String siteAddr,String updateUserName,String belongArea,ModelAndView model) throws IOException{
			String sessionId = request.getSession().getId();
			long userId = (long) request.getSession().getAttribute(sessionId);
			UserInfo userInfo = new UserInfo();
			userInfo = userInfoMapper.selectByPrimaryKey(Long.valueOf(userId));
			
			List<SiteInfo> siteList = new ArrayList<SiteInfo>();
			if("99".equals(userInfo.getPowers())){
				SiteInfoExample example = new SiteInfoExample();
				Criteria criteria= example.createCriteria();
				if(StringUtils.isNotBlank(siteCode)){
					criteria.andSiteCodeEqualTo(Long.valueOf(siteCode));
				}
				if(StringUtils.isNotBlank(siteName)){
					criteria.andSiteNameEqualTo(siteName);
				}
				if(StringUtils.isNotBlank(siteType)){
					criteria.andSiteTypeEqualTo(siteType);
				}
				if(StringUtils.isNotBlank(siteAddr)){
					criteria.andSiteAddrLike("%"+siteAddr+"%");
				}
				if(StringUtils.isNotBlank(updateUserName)){
					UserInfoExample example1 = new UserInfoExample();
					example1.createCriteria().andUserNameEqualTo(updateUserName);
					List<UserInfo> uiList = userInfoMapper.selectByExample(example1);
					List<Long> userIdList = new ArrayList<Long>();
					for(int i=0;i<uiList.size();i++){
						userIdList.add(uiList.get(i).getId());
					}
					if(userIdList.size()>0){
						criteria.andUserIdIn(userIdList);
					}
					
				}
				if(StringUtils.isNotBlank(belongArea)){
					criteria.andBelongAreaEqualTo(belongArea);
				}
				
				example.setOrderByClause("id ");
				siteList =siteInfoMapper.selectByExample(example);
			}
			else if("02".equals(userInfo.getPowers())){
				List<Long> childUserList = userInfoCustMapper.selectChildUserListByParentId(userId);
				SiteInfoExample example = new SiteInfoExample();
				Criteria criteria = example.createCriteria();
				if(StringUtils.isNotBlank(siteCode)){
					criteria.andSiteCodeEqualTo(Long.valueOf(siteCode));
				}
				if(StringUtils.isNotBlank(siteName)){
					criteria.andSiteNameEqualTo(siteName);
				}
				if(StringUtils.isNotBlank(siteType)){
					criteria.andSiteTypeEqualTo(siteType);
				}
				if(StringUtils.isNotBlank(siteAddr)){
					criteria.andSiteAddrLike("%"+siteAddr+"%");
				}
				if(StringUtils.isNotBlank(updateUserName)){
					UserInfoExample example1 = new UserInfoExample();
					example1.createCriteria().andUserNameEqualTo(updateUserName);
					List<UserInfo> uiList = userInfoMapper.selectByExample(example1);
					List<Long> userIdList = new ArrayList<Long>();
					for(int i=0;i<childUserList.size();i++){
						Long childId = childUserList.get(i);
						for(int j=0;j<uiList.size();j++){
							if(childId == uiList.get(j).getId())
							userIdList.add(uiList.get(j).getId());
						}
					}
					if(userIdList.size()>0){
						criteria.andUserIdIn(userIdList);
					}
					
				}else{
					criteria.andUserIdIn(childUserList);
				}
				if(StringUtils.isNotBlank(belongArea)){
					criteria.andBelongAreaEqualTo(belongArea);
				}
				example.setOrderByClause("id ");
				siteList =siteInfoMapper.selectByExample(example);
			}else if("01".equals(userInfo.getPowers())){
				SiteInfoExample example = new SiteInfoExample();
				Criteria criteria = example.createCriteria();
				if(StringUtils.isNotBlank(siteCode)){
					criteria.andSiteCodeEqualTo(Long.valueOf(siteCode));
				}
				if(StringUtils.isNotBlank(siteName)){
					criteria.andSiteNameEqualTo(siteName);
				}
				if(StringUtils.isNotBlank(siteType)){
					criteria.andSiteTypeEqualTo(siteType);
				}
				if(StringUtils.isNotBlank(siteAddr)){
					criteria.andSiteAddrLike("%"+siteAddr+"%");
				}
				if(StringUtils.isNotBlank(belongArea)){
					criteria.andBelongAreaEqualTo(belongArea);
				}
				criteria.andUserIdEqualTo(userId);
				example.setOrderByClause("id ");
				siteList =siteInfoMapper.selectByExample(example);
			}
			
			
			for(SiteInfo siteInfo :siteList){
				if(siteInfo.getUserId()==0){
					siteInfo.setUpdateTime("admin");
				}else{
					siteInfo.setUpdateTime((userInfoMapper.selectByPrimaryKey(siteInfo.getUserId()).getUserName()));
				}
			}
			
			
			//导出Excel
			String[] excelNameArray ={"站点编号","站点类别","站点名称","维护班组","电压等级","投产日期","是否智能变电站","是否枢纽站","变电站重要等级","值班方式","是否代修","布置方式","污秽等级","站址","占地面积(m2)","建筑面积(m2)","地区特称","联系电话","变电站简称","设备主人","备注","配变总容量(KVA)","配变台数","重要程度","是否地下站","是否独立建筑物","防误方式","是否具有环网","无功补偿容量(kVar)","设备类型编码","经度","纬度","所属地区"};
			
			ExportExcel.exportExcel(response, excelNameArray, siteList);
			
			
			BootStrapResult result = new BootStrapResult();
			result.setTotal(siteList.size());
			result.setRows(new ArrayList(siteList));
			result.setMessages("成功");
//			model.addObject("userList",userList);
//		System.out.println("ss");
//		return JSONObject.toJSONString(result);
		}
	 
	 
	 
	 /*
		 * 删除站点图片
		 */
		@RequestMapping(value="/delImages", method=RequestMethod.POST)
		@ResponseBody
		public Map<String,Object> delImages(HttpServletRequest request,HttpServletResponse response ,String siteId ,String imagesPath,String postion ,ModelAndView model){
			Map<String,Object> map = new HashMap<String,Object>();
			
			
			try{
				String delpath = imagesPath.split(",")[Integer.valueOf(postion)-1];
				if("1".equals(postion)){
					
					
		    		   FileUpload.deleteImages(delpath, request);
		    		   if(imagesPath.split(",").length==1){
		    			   imagesPath = imagesPath.replace(delpath, "");
		    		   }else{
		    			   imagesPath = imagesPath.replace(delpath+",", "");
		    		   }
		    	   }else{
		    		   FileUpload.deleteImages(delpath, request);
		    		   imagesPath = imagesPath.replace(","+delpath, "");
		    	   }
				
				 SiteInfo siteInfo = new SiteInfo();
		    	   siteInfo.setId(Long.valueOf(siteId));
		    	   siteInfo.setImagePath(imagesPath);
		    	   siteInfo.setUpdateTime(DateUtils.getTimeString().replaceAll("-","").replaceAll(":","").replaceAll(" ","").substring(0, 14));
		    		   siteInfoMapper.updateByPrimaryKeySelective(siteInfo);
			}catch(Exception e){
				map.put("code", "011");//插入失败
				map.put("message", "添加站点成功插入数据库异常");
				return map;
			}
			
				
			map.put("code", "000");//登录成功
			map.put("message", "删除图片成功");
			return map;
		}
		
		
		
		 /*
		 * 删除CAD和站点平面图图片
		 */
		@RequestMapping(value="/delImages1", method=RequestMethod.POST)
		@ResponseBody
		public Map<String,Object> delImages1(HttpServletRequest request,HttpServletResponse response ,String imagesId ,String imagesPath,String postion ,ModelAndView model){
			Map<String,Object> map = new HashMap<String,Object>();
			
			
			try{
				String delpath = imagesPath.split(",")[Integer.valueOf(postion)-1];
				if("1".equals(postion)){
					
					
		    		   FileUpload.deleteImages(delpath, request);
		    		   if(imagesPath.split(",").length==1){
		    			   imagesPath = imagesPath.replace(delpath, "");
		    		   }else{
		    			   imagesPath = imagesPath.replace(delpath+",", "");
		    		   }
		    	   }else{
		    		   FileUpload.deleteImages(delpath, request);
		    		   imagesPath = imagesPath.replace(","+delpath, "");
		    	   }
				
				 SitePicture sitePicture = new SitePicture();
				 sitePicture.setId(Long.valueOf(imagesId));
				 sitePicture.setPictureAddr(imagesPath);
				 sitePicture.setUpdateTime(DateUtils.getTimeString().replaceAll("-","").replaceAll(":","").replaceAll(" ","").substring(0, 14));
				 sitePictureMapper.updateByPrimaryKeySelective(sitePicture);
			}catch(Exception e){
				map.put("code", "011");//插入失败
				map.put("message", "添加站点成功插入数据库异常");
				return map;
			}
			
				
			map.put("code", "000");//登录成功
			map.put("message", "删除图片成功");
			return map;
		}
		
}
