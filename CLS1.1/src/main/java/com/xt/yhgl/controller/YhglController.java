package com.xt.yhgl.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cyb.utils.DateUtil;
import com.xt.yhgl.po.User;
import com.xt.yhgl.service.YhglService;

@Controller
@RequestMapping("yhgl")
public class YhglController {
 @Resource(name="yhglService")
 public YhglService yhglService;
 
 @RequestMapping("/add")
 @ResponseBody
 public JSONObject addYh(@RequestBody User user){
	 try{
		 //hibernate会自动生成uuid
		 user.setCreateTime(DateUtil.date2long14(new Date()).toString());
		 user.setPassword("1");
		 this.yhglService.save(user);
		 System.out.println(user+",id="+user.getId());
	 }catch(Exception e){
		 e.printStackTrace();
	 }
	 return JSONObject.fromObject(user);//返回带有id的user，放置到user列表
 }
 
 @RequestMapping("/all")
 @ResponseBody
 public JSONArray getAllUser(){
	 List<User> lst= null;
	 try{
		 lst = this.yhglService.findUserList();
	 }catch(Exception e){
		 e.printStackTrace();
		 JSONArray.fromObject("[]");
	 }
	 return JSONArray.fromObject(lst);
 }
 @RequestMapping("/del")
 @ResponseBody
 public String delete(String id ){
	 try{
		 User user = new User();
		 user.setId(id);
		 this.yhglService.delete(user);
	 }catch(Exception e){
		 e.printStackTrace();
		 JSONArray.fromObject("[]");
	 }
	 System.out.println("delete成功！id="+id);
	 return "1";
 }
 @RequestMapping("/delObj")
 @ResponseBody
 public String delete(@RequestBody User user ){
	 try{
		 this.yhglService.delete(user);
	 }catch(Exception e){
		 e.printStackTrace();
		 JSONArray.fromObject("[]");
	 }
	 System.out.println("delete成功！id="+user.getId());
	 return "1";
 }
 @RequestMapping("/mod")
 @ResponseBody
 public JSONArray modify(@RequestBody User user){
	 try{
		
		this.yhglService.update(user);
	 }catch(Exception e){
		 e.printStackTrace();
		 JSONArray.fromObject("[]");
	 }
	 System.out.println("修改成功！");
	 return JSONArray.fromObject("success");
 }
}
