package com.lbs.controller.front;

import java.io.IOException;
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
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.lbs.controller.site.SiteManagerController;
import com.lbs.dao.FuncInfoMapper;
import com.lbs.dao.SiteInfoCustMapper;
import com.lbs.dao.SiteInfoMapper;
import com.lbs.dao.UserInfoCustMapper;
import com.lbs.dao.UserInfoMapper;
import com.lbs.dao.UserRoleCustMapper;
import com.lbs.dao.UserSiteMapMapper;
import com.lbs.model.SiteInfo;
import com.lbs.model.SiteInfoExample;
import com.lbs.model.SitePicture;
import com.lbs.model.SitePictureExample;
import com.lbs.model.UserInfo;
import com.lbs.model.UserInfoExample;
import com.lbs.model.UserInfoExample.Criteria;
import com.lbs.model.UserSiteMap;
import com.lbs.model.UserSiteMapExample;
import com.lbs.utils.DateUtils;
import com.lbs.utils.FileUpload;
import com.lbs.vo.BootStrapResult;
import com.lbs.vo.SiteImagesVO;
import com.lbs.vo.SiteInfoVO;

/**
 * 前端用户管理配置
 * @author wanchuanye
 *
 */
@Controller
@RequestMapping(value="front")
public class FrontManagerController {

	@Autowired
	UserInfoMapper userInfoMapper;
	@Autowired
	FuncInfoMapper funcInfoMapper;
	@Autowired
	UserRoleCustMapper userRoleCustMapper;
	
	@Autowired
	UserInfoCustMapper userInfoCustMapper;
	
	@Autowired
	SiteInfoMapper siteInfoMapper;
	
	@Autowired
	SiteInfoCustMapper siteInfoCustMapper;
	
	@Autowired
	UserSiteMapMapper userSiteMapMapper;
	
	Logger logger = LoggerFactory.getLogger(FrontManagerController.class);

	/*
	 * 进入后端用户管理
	 */
	@RequestMapping(value="/FrontUserManager", method=RequestMethod.GET)
	public ModelAndView FrontUserManager(HttpServletRequest request,HttpServletResponse response ,ModelAndView model) {
		
		model.setViewName("front/FrontUserManager");
		model.addObject("title","后端用户配置");
		return model;
	}
	
	
	
	
	@RequestMapping(value="/FrontjsonList", method=RequestMethod.GET)
	@ResponseBody
	public String FrontjsonList(HttpServletRequest request,HttpServletResponse response ,String pageNumber,String sortOrder,String pageSize,String userName ,String realName,String telNo,ModelAndView model) throws IOException{
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
			List<String> powersList = new ArrayList<String>();
			powersList.add("00");
			powersList.add("01");
			criteria.andPowersIn(powersList);
			userList =userInfoMapper.selectByExample(example);
		}else if("02".equals(userInfo.getPowers())){
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
			List<String> powersList = new ArrayList<String>();
			powersList.add("00");
			powersList.add("01");
			criteria.andPowersIn(powersList);
			criteria.andParentIdEqualTo(userId);
			userList =userInfoMapper.selectByExample(example);
			
		}
		
		for(UserInfo userInfo1 :userList){
			userInfo1.setRsvd1(userInfoMapper.selectByPrimaryKey(userInfo1.getParentId()).getUserName());
			userInfo1.setRsvd2(userInfo1.getId()+"|"+userInfo1.getPowers());
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
	 
	@RequestMapping(value="/deleteFrontUser", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> deleteFrontUser(HttpServletRequest request,HttpServletResponse response ,String userIds,ModelAndView model) throws IOException{
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
	
	 
	@RequestMapping(value="/ToAddFrontUser", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView ToAddAdminUser(HttpServletRequest request,HttpServletResponse response ,ModelAndView model) {
		
		model.setViewName("front/AddFrontUser");
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
	 
	@RequestMapping(value="/AddFrontUser", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> AddAdminUser(HttpServletRequest request,HttpServletResponse response ,String userName,String passWord,String realName,String telNo,String powers,String email,ModelAndView model) throws IOException{
		Map<String ,Object> map = new HashMap<String , Object>();
		String sessionId = request.getSession().getId();
		long userId = (long) request.getSession().getAttribute(sessionId);
		UserInfo userInfo1 = new UserInfo();
		userInfo1 = userInfoMapper.selectByPrimaryKey(Long.valueOf(userId));
		if(!"02".equals(userInfo1.getPowers())){
			map.put("error", true);
			map.put("message", "只有前端管理员可添加!");
			return map;
		}
		if(StringUtils.isBlank(userName)){
			map.put("error", true);
			map.put("message", "用户名不能为空!");
			return map;
		}
		if(StringUtils.isBlank(powers)){
			map.put("error", true);
			map.put("message", "用户权限不能为空!");
			return map;
		}
		UserInfo ui = userInfoCustMapper.selectByUserName(userName);
		if(ui != null){
			map.put("error", true);
			map.put("message", "用户名已存在!");
			return map;
		}
		UserInfo userInfo = new UserInfo();
		if(StringUtils.isNotBlank(userName)){
			userInfo.setUserName(userName);
		}
		if(StringUtils.isNotBlank(passWord)){
			userInfo.setPassWord(passWord);
		}else{
			userInfo.setPassWord("111111");
		}
		if(StringUtils.isNotBlank(realName)){
			userInfo.setRealName(realName);
		}
		if(StringUtils.isNotBlank(telNo)){
			userInfo.setTelNo(telNo);
		}
		if(StringUtils.isNotBlank(powers)){
			userInfo.setPowers(powers);
		}
		if(StringUtils.isNotBlank(email)){
			userInfo.setEmail(email);
		}
		userInfo.setState("N");
		
		userInfo.setRegTime(DateUtils.getTimeString().replaceAll("-","").replaceAll(":","").replaceAll(" ","").substring(0, 14));
		userInfo.setLogNtime(DateUtils.getTimeString().replaceAll("-","").replaceAll(":","").replaceAll(" ","").substring(0, 14));
		userInfo.setParentId(userId);
		
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
	
	 
	@RequestMapping(value="/ToUpdateFrontUser", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView ToUpdateFrontUser(HttpServletRequest request,HttpServletResponse response ,String id ,ModelAndView model) {
		UserInfo userInfo = new UserInfo();
		try{
			userInfo = userInfoMapper.selectByPrimaryKey(Long.valueOf(id));
			userInfo.setRsvd1(userInfoMapper.selectByPrimaryKey(userInfo.getParentId()).getUserName());
		}catch(Exception e){
			
		}
		
		model.addObject("userInfo",userInfo);
		model.setViewName("front/UpdateFrontUser");
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
	 
	@RequestMapping(value="/SaveFrontUser", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> SaveAdminUser(HttpServletRequest request,HttpServletResponse response ,String id,String userName,String passWord , String realName,String telNo,String powers,String email,String state,ModelAndView model) throws IOException{
		Map<String ,Object> map = new HashMap<String , Object>();
		
		UserInfo userInfo = userInfoMapper.selectByPrimaryKey(Long.valueOf(id));
		
		if(StringUtils.isNotBlank(userName)){
			userInfo.setUserName(userName);
		}
		if(StringUtils.isNotBlank(passWord)){
			userInfo.setPassWord(passWord);
		}else{
			userInfo.setPassWord("111111");
		}
		if(StringUtils.isNotBlank(realName)){
			userInfo.setRealName(realName);
		}
		if(StringUtils.isNotBlank(telNo)){
			userInfo.setTelNo(telNo);
		}
		if(StringUtils.isNotBlank(powers)){
			userInfo.setPowers(powers);
		}
		if(StringUtils.isNotBlank(email)){
			userInfo.setEmail(email);
		}
		if(StringUtils.isNotBlank(state)){
			userInfo.setState(state);
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
	
	
	
	@RequestMapping(value="/ParentIdformatter", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> ParentIdformatter(HttpServletRequest request,HttpServletResponse response ,String parentId,ModelAndView model) {
		Map<String, String> map = new HashMap<String,String>();
		UserInfo userInfo = userInfoMapper.selectByPrimaryKey(Long.valueOf(parentId));
		String userName = "";
		if(userInfo!=null && userInfo.getUserName()!=null){
			userName = userInfo.getUserName();
		}
		map.put("code", "success");
		map.put("userName", userName);
		return map;
	}
	
	
	
	
	
	
	
	/**
	 * 进入用户配置站点页面
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	
	 
	@RequestMapping(value="/SetSiteForUser", method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView SetSiteForUser(HttpServletRequest request,HttpServletResponse response ,String userId, ModelAndView model) {
		
		UserSiteMapExample example = new UserSiteMapExample();
		com.lbs.model.UserSiteMapExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(Long.valueOf(userId));
		List<UserSiteMap> userSiteList = userSiteMapMapper.selectByExample(example );
		List<Long> hasSiteList = new ArrayList<Long>();
		for(UserSiteMap userSiteMap : userSiteList){
			hasSiteList.add(userSiteMap.getSiteId());
		}
		
		List<SiteInfo> hasSiteListResult = new ArrayList<SiteInfo>();
		List<SiteInfo> notSiteListResult = new ArrayList<SiteInfo>();
		if(hasSiteList.size()>0){
			SiteInfoExample hasSiteExample = new SiteInfoExample();
			com.lbs.model.SiteInfoExample.Criteria hasSitecriteria = hasSiteExample.createCriteria();
			hasSitecriteria.andIdIn(hasSiteList);
			hasSiteListResult = siteInfoMapper.selectByExample(hasSiteExample );
			
			SiteInfoExample noSiteExample = new SiteInfoExample();
			com.lbs.model.SiteInfoExample.Criteria noSitecriteria = noSiteExample.createCriteria();
			noSitecriteria.andIdNotIn(hasSiteList);
			notSiteListResult = siteInfoMapper.selectByExample(noSiteExample );
		}else{
			SiteInfoExample noSiteExample = new SiteInfoExample();
			com.lbs.model.SiteInfoExample.Criteria noSitecriteria = noSiteExample.createCriteria();
			notSiteListResult = siteInfoMapper.selectByExample(noSiteExample );
		}
		
		
		List<String> belongAreaList = siteInfoCustMapper.selectSiteAreaList();
		model.addObject("belongAreaList",belongAreaList);
		model.addObject("hasSiteListResult",hasSiteListResult);
		model.addObject("notSiteListResult",notSiteListResult);
		model.addObject("userId",userId);
		model.setViewName("traj/UserSiteSet");
		return model;
	}
	
	
	
	/**
	 * 进入用户配置站点页面
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	
	 
	@RequestMapping(value="/UserSiteSitejsonList", method=RequestMethod.GET)
	@ResponseBody
	public String UserSiteSitejsonList(HttpServletRequest request,HttpServletResponse response ,String userId,String pageNumber,String sortOrder,String sortName,String pageSize,String siteCode ,String siteName , String siteType,String siteAddr,String updateUserName,String belongArea,String bdflag, ModelAndView model) throws IOException{
		SiteInfoVO siteInfoTemp = new SiteInfoVO();
		int count =0;
		int pagesize = Integer.valueOf(pageSize);
		int pageNum = (Integer.valueOf(pageNumber)-1)*pagesize;
		
		if(StringUtils.isNotBlank(siteCode)){
			siteInfoTemp.setSiteCode(Long.valueOf(siteCode));
		}
		if(StringUtils.isNotBlank(siteName)){
			siteInfoTemp.setSiteName(siteName);
		}
		if(StringUtils.isNotBlank(siteType)){
			siteInfoTemp.setSiteType(siteType);
		}
		if(StringUtils.isNotBlank(siteAddr)){
			siteInfoTemp.setSiteAddr(siteAddr);
		}
		if(StringUtils.isNotBlank(updateUserName)){
			siteInfoTemp.setUserId(Long.valueOf(updateUserName));
		}
		if(StringUtils.isNotBlank(belongArea)){
			siteInfoTemp.setBelongArea(belongArea);
		}
		
		List<SiteInfoVO> allsiteList = new ArrayList<SiteInfoVO>();
		List<SiteInfoVO> BangsiteList = new ArrayList<SiteInfoVO>();
		List<SiteInfoVO> NotBangsiteList = new ArrayList<SiteInfoVO>();
	
		if("ALL".equals(bdflag)){
			BangsiteList = siteInfoCustMapper.selectListByUserId(Long.valueOf(userId),null,null);
			allsiteList =    siteInfoCustMapper.selectALLSiteList(siteInfoTemp);
			
			count = allsiteList.size();
			siteInfoTemp.setPageNum(pageNum);
			siteInfoTemp.setPageSize(pagesize);
			allsiteList =    siteInfoCustMapper.selectALLSiteList(siteInfoTemp);
		}else if("1".equals(bdflag)){
			BangsiteList = siteInfoCustMapper.selectListByUserId(Long.valueOf(userId),null,null);
			count = BangsiteList.size();
			allsiteList =   siteInfoCustMapper.selectListByUserId(Long.valueOf(userId),pageNum,pagesize);
			
		}else if("0".equals(bdflag)){
			BangsiteList = siteInfoCustMapper.selectListByUserId(Long.valueOf(userId),null,null);
			allsiteList =   siteInfoCustMapper.selectALLSiteList(siteInfoTemp);
			List<SiteInfoVO> NotBangsiteListTemp = new ArrayList<SiteInfoVO>();
			for(SiteInfoVO siteInfo :allsiteList){
				boolean flag = false;
				for(SiteInfoVO temp :BangsiteList){
					if(temp.getId() == siteInfo.getId()){
						flag = true;
					}
				}
				
				if(!flag){
					siteInfo.setOperator(userId+"|"+siteInfo.getId()+"|C");
					if(siteInfo.getUserId()==0){
						siteInfo.setUpdateTime("admin");
					}else{
						siteInfo.setUpdateTime((userInfoMapper.selectByPrimaryKey(siteInfo.getUserId()).getUserName()));
					}
					NotBangsiteListTemp.add(siteInfo);
				}
			}
			count = NotBangsiteListTemp.size();
			if(pageNum==0){
				pageNum=1;
			}
			int begin = pageNum-1;
			int end = (pageNum)*pagesize>=count?count:(pageNum)*pagesize;
					for(int i=begin;i<end;i++){
						NotBangsiteList.add(NotBangsiteListTemp.get(i));
					}
					BootStrapResult result = new BootStrapResult();
					result.setTotal(count);
					result.setRows(new ArrayList(NotBangsiteList));
					result.setMessages("成功");
				return JSONObject.toJSONString(result);
			
		}
		for(SiteInfoVO siteInfo :allsiteList){
			boolean flag = false;
			for(SiteInfoVO temp :BangsiteList){
				if(temp.getId() == siteInfo.getId()){
					flag = true;
				}
			}
			
			if(flag){
				siteInfo.setOperator(userId+"|"+siteInfo.getId()+"|N");
			}else{
				siteInfo.setOperator(userId+"|"+siteInfo.getId()+"|C");
			}
			
			if(siteInfo.getUserId()==0){
				siteInfo.setUpdateTime("admin");
			}else{
				siteInfo.setUpdateTime((userInfoMapper.selectByPrimaryKey(siteInfo.getUserId()).getUserName()));
			}
		}
		
		BootStrapResult result = new BootStrapResult();
		result.setTotal(count);
		result.setRows(new ArrayList(allsiteList));
		result.setMessages("成功");
//		model.addObject("userList",userList);
//	System.out.println("ss");
	return JSONObject.toJSONString(result);
	}
	
	
	
	
	@RequestMapping(value="/jiebang", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> jiebang(HttpServletRequest request,HttpServletResponse response ,String userId,String siteId,ModelAndView model) throws IOException{
		
		Map<String,String> map = new HashMap<String,String>();
		try{
		UserSiteMapExample example = new UserSiteMapExample();
		example.createCriteria().andUserIdEqualTo(Long.valueOf(userId)).andSiteIdEqualTo(Long.valueOf(siteId));
		List<UserSiteMap> userSiteList =  userSiteMapMapper.selectByExample(example );
		
		for(UserSiteMap userSiteMap : userSiteList){
			userSiteMap.setStat("C");
			userSiteMap.setUpdateTime(DateUtils.getTimeString().replaceAll("-","").replaceAll(":","").replaceAll(" ","").substring(0, 14));
			userSiteMapMapper.updateByPrimaryKey(userSiteMap);
		}
		map.put("code", "success");
		
		}catch(Exception e){
			map.put("code", "false");
		}
		return map;
	}
	
	
	
	
	@RequestMapping(value="/bangding", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> bangding(HttpServletRequest request,HttpServletResponse response ,String userId,String siteId,ModelAndView model) throws IOException{
		
		Map<String,String> map = new HashMap<String,String>();
		try{
		UserSiteMapExample example = new UserSiteMapExample();
		example.createCriteria().andUserIdEqualTo(Long.valueOf(userId)).andSiteIdEqualTo(Long.valueOf(siteId));
		List<UserSiteMap> userSiteList =  userSiteMapMapper.selectByExample(example );
		if(userSiteList.size()>0){
			for(UserSiteMap userSiteMap : userSiteList){
				userSiteMap.setStat("N");
				userSiteMap.setUpdateTime(DateUtils.getTimeString().replaceAll("-","").replaceAll(":","").replaceAll(" ","").substring(0, 14));
				userSiteMapMapper.updateByPrimaryKey(userSiteMap);
			}
			map.put("code", "success");
		}else{
			UserSiteMap userSiteMap = new UserSiteMap();
			userSiteMap.setUserId(Long.valueOf(userId));
			userSiteMap.setSiteId(Long.valueOf(siteId));
			userSiteMap.setStat("N");
			userSiteMap.setCreateTime(DateUtils.getTimeString().replaceAll("-","").replaceAll(":","").replaceAll(" ","").substring(0, 14));
			userSiteMap.setUpdateTime(DateUtils.getTimeString().replaceAll("-","").replaceAll(":","").replaceAll(" ","").substring(0, 14));
			userSiteMapMapper.insert(userSiteMap);
			map.put("code", "success");
		}
		}catch(Exception e){
			e.printStackTrace();
			map.put("code", "false");
		}
		return map;
	}
	
	
	
	@RequestMapping(value="/ToUpdateUserImages", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView ToUpdateUserImages(HttpServletRequest request,HttpServletResponse response ,String id ,ModelAndView model) {
		UserInfo userInfo = new UserInfo();
			userInfo = userInfoMapper.selectByPrimaryKey(Long.valueOf(id));
		model.addObject("userInfo",userInfo);
		model.setViewName("front/AdminUserImages");
		return model;
	}
	
	
	@RequestMapping("/uploadImages")
    @ResponseBody
    public  Map<String,Object> uploadImages(@RequestParam("userPhoto") MultipartFile file,@RequestParam("userId") String userId, HttpServletRequest request, HttpServletResponse response) throws IOException {
       Map<String ,Object> map = new HashMap<String,Object>();
       try{
       if(!file.isEmpty()){
    	 //删除文件
    	   UserInfo temp = userInfoMapper.selectByPrimaryKey(Long.valueOf(userId));
    	   if(temp!=null && temp.getImagePath()!=null){
    		   FileUpload.deleteImages(temp.getImagePath(), request);
    	   }
    	   
    	   String filePath = FileUpload.uploadImages(file,userId,"USER"+System.currentTimeMillis(), request);
    	   logger.info("filePath:" + filePath);
    	   UserInfo userInfo = new UserInfo();
    	   userInfo.setId(Long.valueOf(userId));
    	   userInfo.setImagePath(filePath);
    	   userInfo.setLogNtime(DateUtils.getTimeString().replaceAll("-","").replaceAll(":","").replaceAll(" ","").substring(0, 14));
    		   userInfoMapper.updateByPrimaryKeySelective(userInfo);
    		   
    		   map.put("success", true);
    		   map.put("message", "上传成功!");
       }else{
    	   map.put("error", true);
    	   map.put("message", "上传文件为空!");
       }
          
    	   }catch(Exception e){
    		   logger.info("上传图片失败");
    		   map.put("error", true);
    		   map.put("message", "上传失败!");
    	   }
        return map;
    }
	
	
	
	
	/**
	 * 批量绑定选择站点
	 * @param request
	 * @param response
	 * @param userIds
	 * @param model
	 * @return
	 * @throws IOException
	 */
	 
	@RequestMapping(value="/selectBangding", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> selectBangding(HttpServletRequest request,HttpServletResponse response ,String userId,String siteIds,ModelAndView model) throws IOException{
		Map<String ,Object> map = new HashMap<String , Object>();
		
		String[] siteList = siteIds.split(",");
		try{
			for(int i=0;i<siteList.length;i++){
				String siteId = siteList[i];
				UserSiteMapExample example = new UserSiteMapExample();
				example.createCriteria().andUserIdEqualTo(Long.valueOf(userId)).andSiteIdEqualTo(Long.valueOf(siteId));
				List<UserSiteMap> userSiteList =  userSiteMapMapper.selectByExample(example );
				if(userSiteList.size()>0){
					for(UserSiteMap userSiteMap : userSiteList){
						userSiteMap.setStat("N");
						userSiteMap.setUpdateTime(DateUtils.getTimeString().replaceAll("-","").replaceAll(":","").replaceAll(" ","").substring(0, 14));
						userSiteMapMapper.updateByPrimaryKey(userSiteMap);
					}
					map.put("success", true);
				}else{
					UserSiteMap userSiteMap = new UserSiteMap();
					userSiteMap.setUserId(Long.valueOf(userId));
					userSiteMap.setSiteId(Long.valueOf(siteId));
					userSiteMap.setStat("N");
					userSiteMap.setCreateTime(DateUtils.getTimeString().replaceAll("-","").replaceAll(":","").replaceAll(" ","").substring(0, 14));
					userSiteMap.setUpdateTime(DateUtils.getTimeString().replaceAll("-","").replaceAll(":","").replaceAll(" ","").substring(0, 14));
					userSiteMapMapper.insert(userSiteMap);
					map.put("success", true);
				}
			}
		}catch(Exception e){
			map.put("error", true);
		}
	return map;
	}
	
	
	
	/**
	 * 批量解绑选择站点
	 * @param request
	 * @param response
	 * @param userIds
	 * @param model
	 * @return
	 * @throws IOException
	 */
	 
	@RequestMapping(value="/selectJiebang", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> selectJiebang(HttpServletRequest request,HttpServletResponse response ,String userId,String siteIds,ModelAndView model) throws IOException{
		Map<String ,Object> map = new HashMap<String , Object>();
		
		String[] siteList = siteIds.split(",");
		try{
			for(int i=0;i<siteList.length;i++){
				String siteId = siteList[i];
				UserSiteMapExample example = new UserSiteMapExample();
				example.createCriteria().andUserIdEqualTo(Long.valueOf(userId)).andSiteIdEqualTo(Long.valueOf(siteId));
				List<UserSiteMap> userSiteList =  userSiteMapMapper.selectByExample(example );
				
				for(UserSiteMap userSiteMap : userSiteList){
					userSiteMap.setStat("C");
					userSiteMap.setUpdateTime(DateUtils.getTimeString().replaceAll("-","").replaceAll(":","").replaceAll(" ","").substring(0, 14));
					userSiteMapMapper.updateByPrimaryKey(userSiteMap);
				}
				map.put("success", true);
			}
		}catch(Exception e){
			map.put("error", true);
		}
	return map;
	}	
	
	
	
	
	/**
	 * 批量绑定选择站点 按查询条件绑定
	 * @param request
	 * @param response
	 * @param userIds
	 * @param model
	 * @return
	 * @throws IOException
	 */
	 
	@RequestMapping(value="/btnBangding", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> btnBangding(HttpServletRequest request,HttpServletResponse response ,String userId,String siteCode,String siteName,String siteType,String siteAddr,String updateUserName,String belongArea,ModelAndView model) throws IOException{
		Map<String ,Object> map = new HashMap<String , Object>();
		
		//先查询siteList
		SiteInfoVO siteInfoTemp = new SiteInfoVO();
		if(StringUtils.isNoneBlank(siteCode)){
			siteInfoTemp.setSiteCode(Long.valueOf(siteCode));
		}
		if(StringUtils.isNoneBlank(siteName)){
			siteInfoTemp.setSiteName(siteName);
		}
		if(StringUtils.isNoneBlank(siteType)){
			siteInfoTemp.setSiteType(siteType);
		}
		if(StringUtils.isNoneBlank(siteAddr)){
			siteInfoTemp.setSiteAddr(siteAddr);
		}
		if(StringUtils.isNoneBlank(updateUserName)){
			siteInfoTemp.setUserId(Long.valueOf(updateUserName));
		}
		if(StringUtils.isNoneBlank(belongArea)){
			siteInfoTemp.setBelongArea(belongArea);
		}
		
		List<SiteInfoVO> siteList = siteInfoCustMapper.selectALLSiteList(siteInfoTemp);
		
		try{
			for(SiteInfoVO siteInfoVO : siteList){
				Long siteId = siteInfoVO.getId();
				UserSiteMapExample example = new UserSiteMapExample();
				example.createCriteria().andUserIdEqualTo(Long.valueOf(userId)).andSiteIdEqualTo(siteId);
				List<UserSiteMap> userSiteList =  userSiteMapMapper.selectByExample(example );
				if(userSiteList.size()>0){
					for(UserSiteMap userSiteMap : userSiteList){
						userSiteMap.setStat("N");
						userSiteMap.setUpdateTime(DateUtils.getTimeString().replaceAll("-","").replaceAll(":","").replaceAll(" ","").substring(0, 14));
						userSiteMapMapper.updateByPrimaryKey(userSiteMap);
					}
					map.put("code", "success");
				}else{
					UserSiteMap userSiteMap = new UserSiteMap();
					userSiteMap.setUserId(Long.valueOf(userId));
					userSiteMap.setSiteId(Long.valueOf(siteId));
					userSiteMap.setStat("N");
					userSiteMap.setCreateTime(DateUtils.getTimeString().replaceAll("-","").replaceAll(":","").replaceAll(" ","").substring(0, 14));
					userSiteMap.setUpdateTime(DateUtils.getTimeString().replaceAll("-","").replaceAll(":","").replaceAll(" ","").substring(0, 14));
					userSiteMapMapper.insert(userSiteMap);
					map.put("code", "success");
				}
			}
		}catch(Exception e){
			map.put("code", "error");
		}
	return map;
	}	
	
	
	
	
	/**
	 * 批量解绑选择站点 按查询条件绑定
	 * @param request
	 * @param response
	 * @param userIds
	 * @param model
	 * @return
	 * @throws IOException
	 */
	 
	@RequestMapping(value="/btnJiebang", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> btnJiebang(HttpServletRequest request,HttpServletResponse response ,String userId,String siteCode,String siteName,String siteType,String siteAddr,String updateUserName,String belongArea,ModelAndView model) throws IOException{
		Map<String ,Object> map = new HashMap<String , Object>();
		
		//先查询siteList
		SiteInfoVO siteInfoTemp = new SiteInfoVO();
		if(StringUtils.isNoneBlank(siteCode)){
			siteInfoTemp.setSiteCode(Long.valueOf(siteCode));
		}
		if(StringUtils.isNoneBlank(siteName)){
			siteInfoTemp.setSiteName(siteName);
		}
		if(StringUtils.isNoneBlank(siteType)){
			siteInfoTemp.setSiteType(siteType);
		}
		if(StringUtils.isNoneBlank(siteAddr)){
			siteInfoTemp.setSiteAddr(siteAddr);
		}
		if(StringUtils.isNoneBlank(updateUserName)){
			siteInfoTemp.setUserId(Long.valueOf(updateUserName));
		}
		if(StringUtils.isNoneBlank(belongArea)){
			siteInfoTemp.setBelongArea(belongArea);
		}
		
		List<SiteInfoVO> siteList = siteInfoCustMapper.selectALLSiteList(siteInfoTemp);
		
		try{
			for(SiteInfoVO siteInfoVO : siteList){
				Long siteId = siteInfoVO.getId();
				UserSiteMapExample example = new UserSiteMapExample();
				example.createCriteria().andUserIdEqualTo(Long.valueOf(userId)).andSiteIdEqualTo(siteId);
				List<UserSiteMap> userSiteList =  userSiteMapMapper.selectByExample(example );
				
				for(UserSiteMap userSiteMap : userSiteList){
					userSiteMap.setStat("C");
					userSiteMap.setUpdateTime(DateUtils.getTimeString().replaceAll("-","").replaceAll(":","").replaceAll(" ","").substring(0, 14));
					userSiteMapMapper.updateByPrimaryKey(userSiteMap);
				}
				map.put("code", "success");
			}
		}catch(Exception e){
			map.put("code", "error");
		}
	return map;
	}		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
