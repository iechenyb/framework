package com.xt.yhgl.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.xt.base.BaseDao;
import com.xt.yhgl.po.User;

@Repository("yhglDao")
@Transactional
public class YhglDao extends BaseDao<User> {
 
 public List<User> findUserList(){
	   //from后面是对象，不是表名
	   String hql="from User";//使用命名参数，推荐使用，易读。
	   Query query=this.getSession().createQuery(hql);	   
	   List<User> list=query.list();
	   return list;
 }

}
