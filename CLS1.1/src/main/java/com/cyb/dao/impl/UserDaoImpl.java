package com.cyb.dao.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.cyb.dao.UserDao;
import com.cyb.utils.UUIDUtils;
import com.xt.cdgl.po.SysMenu;
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl implements UserDao {
	
	protected static Logger log = Logger.getLogger(UserDaoImpl.class);
	
	public String test(SysMenu menu){
		add(menu);
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	public void add(SysMenu menu){
		  try{
			 Session session = this.getSession();
			//打印事务是否存在  
			 System.out.println("打印事务是否存在:"+session.getTransaction().isActive());  
			 menu.setPath("chenyb/company"); 
			 session.save(menu);
			 SysMenu menu1 = new SysMenu();
			 menu1.setMenuId(UUIDUtils.getUUID());
			 menu1.setLevel(20);
			 menu1.setCreateTime("20160101");//时间设置成14，检查事务处理机制
			 session.save(menu1);
			 List<Map<String, Object>> lst = this.jdbcTemplate.queryForList("select * from sys_menu");
			 System.out.println("查询hibernate的执行结果：\n"+lst);//检验hibernate的执行结果可见性
		  }catch(DataAccessException e){
			  e.printStackTrace();
		  }
	  }
}
