package com.xt.base;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class BaseDao<T> {
	Log log = LogFactory.getLog(BaseDao.class);
	@Resource(name="hibernateTemplate")
	public HibernateTemplate hibernateTemplate; 
	@Resource(name="jdbcTemplate1")
	public JdbcTemplate jdbcTemplate;
	@Resource(name="sessionFactory1")
	public SessionFactory sessionFactory;
	public Session getSession(){
			Session session = null ;
			try {
				session = sessionFactory.getCurrentSession();
				if(session==null){
					session = sessionFactory.openSession();
				}
			} catch (Exception e) {
				return sessionFactory.openSession();
			}
			return session;
		}
	public void close(Session session){
		if(session!=null){
			//session.flush();
			session.close();
		}
	}
	public void save(T t){
		 this.getSession().save(t);
		 log.info("保存成功！");
	}
	  
	 public void delete(T t){
		 this.getSession().delete(t);
		 log.info("删除成功！");
	 }
	 
	 public void update(T t){
		 this.getSession().update(t);
		 log.info("更新成功！");
	 }
}
