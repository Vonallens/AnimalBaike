package com.animal.controller;


import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.animal.service.SeachRecordService;
/**
 * 导航控制器，主要负责跳转页面
 * @author fys
 *
 */
@Controller
@RequestMapping("Navigation")
public class NavigationController {

    @Autowired
    private SeachRecordService seachRecordService;
	/**
	 * 跳转到首页
	 * @return
	 */
	@RequestMapping(value="goToIndex",method=RequestMethod.GET)
    public String goToIndex() {
        return "index";
    }
	/**
	 * 跳转到关于我们界面
	 * @return
	 */
	@RequestMapping(value="goToDiscoverAnimal",method=RequestMethod.GET)
    public String goToDiscoverAnimal(HttpSession session) {
		session.setAttribute("listAnimalInfo", null);
        return "public/discoveranimal";
    }
	/**
	 * 跳转到亲近自然界面
	 * @return
	 */
	@RequestMapping(value="goToContactNature",method=RequestMethod.GET)
    public String goToContactNature() {
        return "public/contactnature";
    }
	/**
	 * 跳转到分享动物界面
	 * @return
	 */
	@RequestMapping(value="goToShareAnimal",method=RequestMethod.GET)
    public String goToShareAnimal() {
        return "public/shareanimal";
    }
	/**
	 * 跳转到搜索排行界面
	 * @return
	 */
	@RequestMapping(value="goToSeachRank",method=RequestMethod.GET)
    public String goToSeachRank(HttpSession session) {
		//去到搜索排行界面，默认展示总排行
		List<Map<String,String>> map =seachRecordService.getSeachRank();
		List<Map<String,String>> tempFlag = (List<Map<String, String>>) session.getAttribute("seachRankList");
		if(tempFlag==null){
			session.setAttribute("seachRankList", map);
			session.setAttribute("rankType", "all");
		}
		
        return "public/seachrank";
    }
	/**
	 * 跳转到关于我们界面
	 * @return
	 */
	@RequestMapping(value="goToAboutUs",method=RequestMethod.GET)
    public String goToAboutUs() {
        return "public/aboutus";
    }
	/**
	 * 跳转到登陆界面
	 */
	@RequestMapping(value="goToLogin",method=RequestMethod.GET)
    public String goToLogin() {
            return "login";
    }

	/**
	 * 跳转到注册界面
	 */
	@RequestMapping(value="goToRegister",method=RequestMethod.GET)
    public String goToRegister() {
            return "register";
    }

	/**
	 * 跳转到个人中心
	 */
	@RequestMapping(value="goToUserInfo",method=RequestMethod.GET)
    public String goToUserInfo() {
            return "public/userinfo";
    }

	/**
	 * 退出登陆
	 */
	@RequestMapping(value="goSignOut",method=RequestMethod.GET)
	public String  goSignOut(HttpSession session,HttpServletRequest ss,HttpServletResponse response) throws IOException{
		 //清空所有session中的值
         session.invalidate(); 
         return "index";
	}
}
