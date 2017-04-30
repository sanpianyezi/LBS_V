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
import com.lbs.dao.SiteInfoCustMapper;
import com.lbs.dao.UserInfoCustMapper;
import com.lbs.dao.UserInfoMapper;
import com.lbs.dao.UserRoleCustMapper;
import com.lbs.model.FuncInfo;
import com.lbs.model.FuncInfoExample;
import com.lbs.model.UserInfo;
import com.lbs.model.UserInfoExample;
import com.lbs.vo.FuncInfoVO;
import com.mysql.jdbc.StringUtils;

/**
 * 管理员用户登录
 * @author wanchuanye
 *
 */
@Controller
@RequestMapping(value="/admin")
public class AdminLogin {
	
	@Autowired
	UserInfoMapper userInfoMapper;
	@Autowired
	FuncInfoMapper funcInfoMapper;
	@Autowired
	UserRoleCustMapper userRoleCustMapper;
	
	@Autowired
	UserInfoCustMapper userInfoCustMapper;
	


	/*
	 * 用户登录
	 */
	@RequestMapping(value="/login", method=RequestMethod.POST)
	@ResponseBody
	public void login(HttpServletRequest request,HttpServletResponse response ,String username,String password ,ModelAndView model) throws IOException{
		Map<String,Object> map = new HashMap<String ,Object>();
		String userName = username.trim();
		String passWord = password;
//		System.out.println(response.getCharacterEncoding());
		if(StringUtils.isNullOrEmpty(userName)){
			map.put("code", "011");//用户名不存在
			map.put("message", "用户名不存在");
//			response.setContentType("text/html;charset=UTF-8"); 
//			response.getWriter().print("用户名不存在"); 
			request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            String loginPage = "http://"+request.getHeader("Host")+"/LBS_V1";
            StringBuilder builder = new StringBuilder();
            builder.append("<script type=\"text/javascript\">");
            builder.append("alert('用户名不存在，请重新登录！');");
            builder.append("window.top.location.href='");
            builder.append(loginPage);
            builder.append("';");
            builder.append("</script>");
            out.print(builder.toString());
		}else{
			UserInfo userInfo = userInfoCustMapper.selectByUserName(userName);
			if(userInfo==null){
				map.put("code", "011");//用户名不存在
				map.put("message", "用户名不存在");
//				response.setContentType("text/html;charset=UTF-8"); 
//				response.getWriter().print("用户名不存在"); 
				request.setCharacterEncoding("UTF-8");
	            response.setCharacterEncoding("UTF-8");
	            PrintWriter out = response.getWriter();
	            String loginPage = "http://"+request.getHeader("Host")+"/LBS_V1";
	            StringBuilder builder = new StringBuilder();
	            builder.append("<script type=\"text/javascript\">");
	            builder.append("alert('用户名不存在，请重新登录！');");
	            builder.append("window.top.location.href='");
	            builder.append(loginPage);
	            builder.append("';");
	            builder.append("</script>");
	            out.print(builder.toString());
			}else{
				passWord = passWord.trim();
				if(StringUtils.isNullOrEmpty(passWord)){
					map.put("code", "021");//密码错误
					map.put("message", "密码错误");
//					response.setContentType("text/html;charset=UTF-8"); 
//					response.getWriter().print("密码错误"); 
					request.setCharacterEncoding("UTF-8");
		            response.setCharacterEncoding("UTF-8");
		            PrintWriter out = response.getWriter();
		            String loginPage = "http://"+request.getHeader("Host")+"/LBS_V1";
		            StringBuilder builder = new StringBuilder();
		            builder.append("<script type=\"text/javascript\">");
		            builder.append("alert('密码错误，请重新登录！');");
		            builder.append("window.top.location.href='");
		            builder.append(loginPage);
		            builder.append("';");
		            builder.append("</script>");
		            out.print(builder.toString());
				}else{
					if(!passWord.equals(userInfo.getPassWord())){
						map.put("code", "031");//用户名密码不匹配
						map.put("message", "用户名密码不匹配");
//						response.setContentType("text/html;charset=UTF-8"); 
//						response.getWriter().print("用户名密码不匹配");
						request.setCharacterEncoding("UTF-8");
			            response.setCharacterEncoding("UTF-8");
			            PrintWriter out = response.getWriter();
			            String loginPage = "http://"+request.getHeader("Host")+"/LBS_V1";
			            StringBuilder builder = new StringBuilder();
			            builder.append("<script type=\"text/javascript\">");
			            builder.append("alert('用户名密码不匹配，请重新登录！');");
			            builder.append("window.top.location.href='");
			            builder.append(loginPage);
			            builder.append("';");
			            builder.append("</script>");
			            out.print(builder.toString());
					}else{
			
						HttpSession session = request.getSession();
						String sessionId = session.getId();
						session.setAttribute(sessionId, userInfo.getId());
						session.setAttribute("userName", userName);
						session.setAttribute(userName, userInfo);
						map.put("code", "000");//登录成功
						map.put("message", "登陆成功");
						map.put("userInfo", JSON.toJSONString(userInfo));
//						request.setCharacterEncoding("UTF-8");
//			            response.setCharacterEncoding("UTF-8");
//			            PrintWriter out = response.getWriter();
//			            String loginPage = "http://"+request.getHeader("Host")+"/LBS_V1/admin/index?num=1";
//			            StringBuilder builder = new StringBuilder();
//			            builder.append("<script type=\"text/javascript\">");
//			            builder.append("alert('登录成功！');");
//			            builder.append("window.top.location.href='");
//			            builder.append(loginPage);
//			            builder.append("';");
//			            builder.append("</script>");
//			            out.print(builder.toString());
						response.sendRedirect("http://"+request.getHeader("Host")+"/LBS_V1/admin/index");
					}
				}
			}
		}
	}
	
	/*
	 * 登出
	 */
	@RequestMapping(value="/loginout", method=RequestMethod.GET)
	public ModelAndView test2(HttpServletRequest request,HttpServletResponse response ,ModelAndView model) throws IOException{
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
		response.sendRedirect("http://"+request.getHeader("Host")+"/LBS_V1/");
		return null;
	}
	
	
	
	/**
	 * 管理登录
	 * @throws IOException 
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response, ModelAndView model) throws IOException {
		HttpSession session = request.getSession();
		String sessionId = session.getId();
		Long userId = (Long) session.getAttribute(sessionId);
		String userName = (String ) session.getAttribute("userName");
		if(userName ==null){
			request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            String loginPage = "http://"+request.getHeader("Host")+"/LBS_V1/";
            StringBuilder builder = new StringBuilder();
            builder.append("<script type=\"text/javascript\">");
            builder.append("alert('Session timeout,Please login again!');");
            builder.append("window.top.location.href='");
            builder.append(loginPage);
            builder.append("';");
            builder.append("</script>");
            out.print(builder.toString());
            return null;
		}else{
			UserInfo userInfo = (UserInfo) session.getAttribute(userName);
//			UserInfoExample example = new UserInfoExample();
//			List<UserInfo> list = new ArrayList<>();
//			int size = list.size();
//			int pageNum = 1;
//			
//			if(size%10 ==0){
//				pageNum = size/10;
//			}else{
//				pageNum = size/10+1;
//			}
			
//			 List<UserInfo> userList = new ArrayList<>();
//			 list = userInfoMapper.selectByExample(example);
//			 int startnum = 10*(num-1) +1;
//			 int endnum = 10*num;
//			 for(int i=startnum;i<list.size()&&i<endnum;i++){
//				 userList.add(list.get(i));
//			}
			 List<FuncInfoVO> menuList = new ArrayList<FuncInfoVO>();
			List<FuncInfo> funcInfoList = userRoleCustMapper.selectFuncByUserId(userId);
			for(int i=0 ;i< funcInfoList.size();i++){
				FuncInfo func = funcInfoList.get(i);
				if("00".equals(func.getFuncType())){
					FuncInfoVO funcInfoVO = new FuncInfoVO();
					funcInfoVO.setFuncId(func.getFuncId());
					funcInfoVO.setFuncName(func.getFuncName());
					List<FuncInfo> childFuncList = new ArrayList<FuncInfo>();
					long parentId = func.getFuncId();
					for(int j=0;j<funcInfoList.size();j++){
						FuncInfo temp = funcInfoList.get(j);
						if(temp.getFuncParentId()==parentId){
							childFuncList.add(temp);
						}
					}
					funcInfoVO.setFuncInfoList(childFuncList);
					menuList.add(funcInfoVO);
				}
			
			}
			
			model.addObject("menuList",menuList);
			model.setViewName("adminIndex");
//			model.addObject("userList",userList);
			model.addObject("userInfo",userInfo);
//			model.addObject("pageNum",pageNum);
			return model;
		}
		
		
		
		
		
	}
}
