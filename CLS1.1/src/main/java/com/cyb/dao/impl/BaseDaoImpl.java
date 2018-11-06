package com.cyb.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.JdbcTemplate;

public class BaseDaoImpl {
	@Resource(name="jdbcTemplate")
	JdbcTemplate jdbcTemplate; 
	@Resource(name="sessionFactory")
	SessionFactory sessionFactory;
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
			session.flush();
			session.close();
		}
	}
}
