package cn.com.shop.user.service.Impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.shop.user.mapper.UserMapper;
import cn.com.shop.user.pojo.User;
import cn.com.shop.user.pojo.UserExample;
import cn.com.shop.user.pojo.UserExample.Criteria;
import cn.com.shop.user.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override//注册
	public void inster(User user) {
		//user.setState("1");//1 激活 0 未激活
		//String code = UUID.randomUUID().toString();
		//user.setCode(code);
		userMapper.insert(user);
	}

	
	//登陆
	@Override
	public User findUsernameAndPassword(User user) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
			criteria.andUsernameEqualTo(user.getUsername());
			criteria.andPasswordEqualTo(user.getPassword());
		List<User> ulist = userMapper.selectByExample(example);
		if(ulist.size()>0){
			return ulist.get(0);
		}else{
			return null;
		}
		
	}



}
