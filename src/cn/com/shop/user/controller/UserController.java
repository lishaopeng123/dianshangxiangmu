package cn.com.shop.user.controller;

import java.util.UUID;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.runner.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.shop.user.pojo.User;
import cn.com.shop.user.service.UserService;
import netscape.javascript.JSObject;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService uservice;
	
	//去注册页面
	@RequestMapping("/registPage")
	public String registPage(){
		
		return "register";
	}
	
	//注册
	@RequestMapping("/regist")
	public String regist(User user,String captcha,HttpServletRequest request){
		
		String checkcode = (String) request.getSession().getAttribute("checkcode");
		if(!captcha.equalsIgnoreCase(checkcode)){
			request.setAttribute("err", "验证码错误");
			return "register";
		}else{
			user.setState("0");
			String code = UUID.randomUUID().toString();
			user.setCode(code);
			uservice.inster(user);
			return "msg";
		}
		
	}
	
	
	
	//去登陆界面
	@RequestMapping("/loginPage")
	public String loginPage(){
		
		return "login";
	}
	
	//登陆
	@RequestMapping("/login")
	public String login(User user,HttpServletRequest request,String captcha){
		
		
		User u = uservice.findUsernameAndPassword(user);
		if(u==null){
			
			request.setAttribute("err", "用户名或密码错误");
			return "login";
		}
		String checkcode = (String) request.getSession().getAttribute("checkcode");
		if(!captcha.equalsIgnoreCase(checkcode)){
			//验证码错误
			request.setAttribute("err", "验证码错误");
			return "login";
		}else{
			//跳转到商品页
			request.getSession().setAttribute("u", u);
			return "redirect:/index.action";
		}
		
//		if(u==null){
//			
//			request.setAttribute("err", "用户名或密码错误");
//			return "login";
//		}else{
//			
//			request.getSession().setAttribute("u", u);
//			return "redirect:/index.action";
//		}
		
		
	}
	
	
	

	//退出
	@RequestMapping("/exit")
	public String exit(HttpServletRequest request){
		//直接销毁session对象
		request.getSession().invalidate();
		return "index";
	}
	
}
