package com.cyb.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cyb.dao.UserDao;
import com.cyb.service.UserService;
import com.cyb.utils.DateUtil;
import com.cyb.utils.UUIDUtils;
import com.xt.cdgl.po.SysMenu;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource(name = "userDao")
	public UserDao userdao;
	public String addtest(){
		SysMenu menu = new SysMenu();
		menu.setMenuId(UUIDUtils.getUUID());
		menu.setLevel(1);
		menu.setRank(1);
		menu.setMenuName("root");
		menu.setParentId(UUIDUtils.getUUID());
		//menu.setCreateTime(DateUtil.date2int8(new Date()));
		menu.setPath("/xxx/yyy");
		System.out.println("execute...");
		this.userdao.test(menu);
		return "";
	}
}
