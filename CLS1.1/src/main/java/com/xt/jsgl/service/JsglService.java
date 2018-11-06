package com.xt.jsgl.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xt.jsgl.dao.JsglDao;
@Service("jsglService")
public class JsglService {
	@Resource(name="jsglDao")
	public JsglDao jsglDao; 
}
