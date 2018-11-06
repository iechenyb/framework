package com.xt.cdgl.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xt.cdgl.dao.CdglDao;
import com.xt.cdgl.po.SysMenu;
@Service("cdglService")
public class CdglService {
	@Resource(name="cdglDao")
	public CdglDao cdglDao; 
	 public void addTest(SysMenu menu){
		  this.cdglDao.addTest(menu);
	 }
	 public void add(SysMenu menu){
		  this.cdglDao.add(menu);
	  }
	 public Map<String,Object> getSubMenuList(String parentId){
		 return this.cdglDao.getSubMenuList(parentId);
	 }
	 public int delMenu(String id){
		 return this.cdglDao.delMenu(id);
	 }
	  public void updateMenu(SysMenu menu){
		   this.cdglDao.updateMenu(menu);
	  }
	  public Map<String,Object> getMenuTree(String root){
		  return this.cdglDao.getMenuTree(root);
	  }
	  public Map<String,Object> getMenuTree1(String root){
		  return this.cdglDao.getMenuTree1(root);
	  }
	  public  Map<String,Object> getMenuById(String id){
		  return this.cdglDao.getMenuById(id);
	  }
}
