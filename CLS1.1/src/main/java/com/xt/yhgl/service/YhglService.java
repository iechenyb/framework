package com.xt.yhgl.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xt.yhgl.dao.YhglDao;
import com.xt.yhgl.po.User;

@Service("yhglService")
public class YhglService {
	@Resource(name="yhglDao")
	public YhglDao yhglDao; 
	public List<User> findUserList(){
		return this.yhglDao.findUserList();
	}
	public void save(User user){
		this.yhglDao.save(user);
	}
	public void delete(User user){
		this.yhglDao.delete(user);
	}
	public void update(User user){
		this.yhglDao.update(user);
	}
}
