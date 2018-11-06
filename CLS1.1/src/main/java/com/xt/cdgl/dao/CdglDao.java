package com.xt.cdgl.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cyb.utils.UUIDUtils;
import com.xt.base.BaseDao;
import com.xt.cdgl.po.SysMenu;

@Repository("cdglDao")
@Transactional
public class CdglDao extends BaseDao<SysMenu>{
 Log log = LogFactory.getLog(CdglDao.class); 
 public void addTest(SysMenu menu){
		  try{
			 Session session = this.getSession();
			 menu.setPath("chenyb/company"); 
			//打印事务是否存在  
			log.info("打印事务是否存在:"+session.getTransaction().isActive());  
			 session.save(menu);
			 //this.getSession().save(menu);
			 SysMenu menu1 = new SysMenu();
			 menu1.setMenuId(UUIDUtils.getUUID());
			 menu1.setLevel(2);
			 menu1.setCreateTime("2015");//时间设置成14，检查事务处理机制
			 session.save(menu1);
			 List<Map<String, Object>> lst = this.jdbcTemplate.queryForList("select * from sys_menu");
			log.info("查询hibernate的执行结果：\n"+lst);//检验hibernate的执行结果可见性(不可见)
		  }catch(RuntimeException  e){
			  e.printStackTrace();
		  }
	  }
  public void add(SysMenu menu){
	  try{
		 Session session = this.getSession();
		//打印事务是否存在  
		log.info("打印事务是否存在:"+session.getTransaction().isActive());  
		 menu.setRank(getRank(menu.getParentId()));
		 session.save(menu);
	  }catch(RuntimeException  e){
		  e.printStackTrace();
	  }
  }
  public  Map<String,Object> getMenuById(String id){
	  Map<String,Object> ret = null;
	  try{
		//打印事务是否存在  
		  ret = this.jdbcTemplate.queryForMap("select * from sys_menu where menuid='"+id+"'");
	  }catch(RuntimeException  e){
		 log.info("根据menuid查询菜单信息失败！menuid="+id);
	  }
	  return ret;
  }
  public void updateMenu(SysMenu menu){
	  try{
		 Session session = this.getSession();
		//打印事务是否存在  
		log.info("打印事务是否存在:"+session.getTransaction().isActive());  
		 session.update(menu);
	  }catch(RuntimeException  e){
		  e.printStackTrace();
	  }
  }
  public int getRank(String parentId){
	  int rank = 0;
	  //rank = this.jdbcTemplate.queryForInt("select iF(count(*)=0 or count(*) is null,0,count(*)) from sys_menu where parentid='"+parentId+"'");
	  try {
		//rank = this.jdbcTemplate.queryForInt("select count(*) from sys_menu where parentid='"+parentId+"'");
	} catch (DataAccessException e) {
		e.printStackTrace();
	}
	  return rank+1;
  }
  public int delMenu(String id){
	  int ret = 0;
	  try{
		  String sql="delete from sys_menu where menuid='"+id+"'";
		 log.info(sql);
		  this.jdbcTemplate.execute(sql);
		  ret=1;
	  }catch(Exception e){
		  e.printStackTrace();
	  }
	  return ret;
  }
  public Map<String,Object> getSubMenuList(String parentId){
		  List<Map<String,Object>> data = this.jdbcTemplate.queryForList("select * from sys_menu where parentid='"+parentId+"'");
		  Map<String,Object> ret = new HashMap<String, Object>();
		  ret.put("list", data);
		  return ret;
  }
  public Map<String,Object> getMenuTree(String root){
	  String sql1 = "select * from sys_menu where menubs='"+root+"' order by rank";
	  Map<String,Object> tree =  this.jdbcTemplate.queryForMap(sql1);
	  String sql2= "select * from sys_menu where parentbs='"+tree.get("menubs")+"'";
	  List<Map<String,Object>> data = this.jdbcTemplate.queryForList(sql2);
	 log.info(sql1+"\n"+sql2);
	  Map<String,Object> menu0 = null;
	  Map<String,Object> menu = null;
	  List<Map<String,Object>> subMenus = new ArrayList<Map<String,Object>>();
	  if(data!=null&&data.size()>0){
		  for(int i=0;i<data.size();i++){
			  menu = data.get(i);
			  menu0 = new HashMap<String,Object>();
			  menu0.put("text", menu.get("menuname"));
			  if("0".equals(menu.get("isleaf").toString())){//非叶子节点时读取子节点
				  getChildren(menu0,menu.get("menubs").toString());
			  }
			  menu0.put("attributes", menu);
			  subMenus.add(menu0);
		  }
		  tree.put("text", "系统菜单");
		  tree.put("children", subMenus);
	  }
	  return tree;
  }
  public void getChildren(Map<String,Object> menu,String pid){
	  String sql2= "select * from sys_menu where parentbs='"+pid+"'";
	  List<Map<String,Object>> data = this.jdbcTemplate.queryForList(sql2);
	  Map<String,Object> menu0 = null;
	  Map<String,Object> menu_ = null;
	  List<Map<String,Object>> subMenus = new ArrayList<Map<String,Object>>();
	  if(data!=null&&data.size()>0){
		  for(int i=0;i<data.size();i++){
			  menu_ = data.get(i);
			  menu0 = new HashMap<String,Object>();
			  menu0.put("text", menu_.get("menuname"));
			  if("0".equals(menu_.get("isleaf").toString())){//非叶子节点时读取子节点
				  getChildren(menu0,menu_.get("menubs").toString());
			  }
			  menu0.put("attributes", menu_);
			  subMenus.add(menu0);
		  }
		  menu.put("children", subMenus);
		 
	  }
	  
  }
  public Map<String,Object> getMenuTree1(String root){
	  String sql1 = "select * from sys_menu where menubs='"+root+"' order by rank";
	  Map<String,Object> tree =  this.jdbcTemplate.queryForMap(sql1);
	  String sql2= "select * from sys_menu where parentbs='"+tree.get("menubs")+"'";
	  List<Map<String,Object>> data = this.jdbcTemplate.queryForList(sql2);
	 log.info(sql1+"\n"+sql2);
	  Map<String,Object> menu = null;
	  List<Map<String,Object>> subMenus = new ArrayList<Map<String,Object>>();
	  if(data!=null&&data.size()>0){
		  for(int i=0;i<data.size();i++){
			  menu = data.get(i);
			  menu.put("blank",getBlank(3));
			  if("0".equals(menu.get("isleaf").toString())){//非叶子节点时读取子节点
				  getChildren1(menu);
			  }
			  subMenus.add(menu);
		  }
		  tree.put("children", subMenus);
	  }
	  return tree;
  }
  public void getChildren1(Map<String,Object> menu){
	  String sql2= "select * from sys_menu where parentbs='"+menu.get("menubs")+"'";
	  List<Map<String,Object>> data = this.jdbcTemplate.queryForList(sql2);
	  Map<String,Object> menu_ = null;
	  List<Map<String,Object>> subMenus = new ArrayList<Map<String,Object>>();
	  if(data!=null&&data.size()>0){
		  for(int i=0;i<data.size();i++){
			  menu_ = data.get(i);
			  menu_.put("blank",getBlank(3));
			  if("0".equals(menu_.get("isleaf").toString())){//非叶子节点时读取子节点
				  getChildren1(menu_);
			  }
			  subMenus.add(menu_);
		  }
		  menu.put("children", subMenus);
	  }
	  
  }
  public String getBlank(int level){
	  StringBuffer blank = new StringBuffer("");
	  for(int i=0;i<level;i++){
		  blank.append("&nbsp;&nbsp;");
	  }
	  return blank.toString();
  }
}
