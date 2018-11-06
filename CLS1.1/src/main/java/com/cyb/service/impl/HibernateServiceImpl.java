package com.cyb.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cyb.dao.impl.HibernateDaoImpl;

@Service("hibernateService")
public class HibernateServiceImpl {
	@Resource(name = "hibernateDao")
	public HibernateDaoImpl hibernateDao;
	
}
