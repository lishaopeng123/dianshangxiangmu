package cn.com.shop.user.service;

import cn.com.shop.user.pojo.User;

public interface UserService {

	void inster(User user);//注册

	User findUsernameAndPassword(User user);//登陆


}
