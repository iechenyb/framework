package com.cyb.dao.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.cyb.bean.UserTmp;


@Repository("hibernateDao")
public class HibernateDaoImpl extends BaseDaoImpl {
	public void testSaveNoSetId(){
		Session session = getSession();
		UserTmp user = new UserTmp();
		user.setPassword("sdfsdf");
		user.setUsername("username");
		session.save(user);
		System.out.println("---------------");  
		System.out.println(user.getId()+","+user.getUsername());
		System.out.println("---------------");  
		UserTmp usertmp = (UserTmp) session.load(UserTmp.class, user.getId());
		System.out.println("----------usertmp-----"+usertmp);  
		close(session);//必须关闭，否则事务不会提交
	}
	public void testUpdateLoadObject(){
		Session session = getSession();
		UserTmp user = (UserTmp) session.load(UserTmp.class, "40289053533f613601533f613e2c0002");
		user.setPassword("chenyb1111");
		user.setUsername("username1111");
		session.update(user);
		close(session);//必须关闭，否则事务不会提交
	}
	public void testUpdateNewObject(){
		Session session = getSession();
		UserTmp user = new UserTmp();
		user.setId("40289053533f613601533f613e2c0002");
		user.setEmail("hibernateseted@qq.com");
		session.update(user);
		close(session);//必须关闭，否则事务不会提交
	}
	public void testDeleteLoadObject(){
		Session session = getSession();
		UserTmp user = (UserTmp) session.load(UserTmp.class, "40289053533f613601533f613e2c0002");
		session.delete(user);
		close(session);//必须关闭，否则事务不会提交
	}
	public void testDeleteNewObject(){
		Session session = getSession();
		UserTmp user = new UserTmp();
		user.setId("40289053533f65d701533f65de690002");
		session.delete(user);
		close(session);//必须关闭，否则事务不会提交
	}
	public Iterator<UserTmp> getSomeUser(String name)throws HibernateException
	{
		Session session = getSession();
		String subSQL = " select c  ";
		String queryString = subSQL+" from User as c where c.username like :name"; 
		Query query = session.createQuery(queryString);
		query.setString("name", "%"+name+"%");
		Iterator<UserTmp> it= query.iterate();
		return it;
	} 
	public List<UserTmp> getUserList(String name){
		Session session = getSession();
		Query query = session.createSQLQuery("select * from usr t where username like'%"+name+"%' ") .addEntity(UserTmp.class);//返回对象 
		return query.list();
	}
	public Map getUserMap(String name){
		Session session = getSession();
		Query query = session.createSQLQuery("select * from usr t where username ='"+name+"' ")
				.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);//返回一个map,KEY:为DB中名称一致（大小写一致）  
		//遍历list时就可以
		Map map = (Map)query.list().get(0);
		return map;
	}
}
