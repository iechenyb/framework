package com.cyb.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cyb.bean.JsonObj;
import com.cyb.bean.UserTmp;
import com.cyb.service.UserService;
/**
 * 注意1：
 * hibernate底层的异常无法捕获，在controller方法里最好用catch捕获异常。
 * 否则，后台日志也不会报错，导致检查错误麻烦。
 * 注意2：
 * jsonarry 在转换对象的时候，如果存在某个属性值为null，则返回json时会报404错误，
 * 建议用“”代替
 * 注意3：
 * 前段传json时，设置三个注解参数，如：
 * @ResponseBody   //返回json的时候，必须加  @responseBody注解
	@RequestMapping(value = "/pushJsonList")
	public JSONArray acceptJson(@RequestBody
	并且ajax再写请求时，注意参数 method=post和参数类型的控制参数
 * @author DHUser
 *
 */
@Controller
@RequestMapping("user")
public class UserController {
	Logger log = Logger.getLogger(UserController.class);
	@Resource(name="userService")
	UserService userService;
	
	@RequestMapping(value="/jsp")
	public ModelAndView login(@ModelAttribute UserTmp user,HttpServletRequest request,HttpSession session) throws IOException {
		  ModelAndView view = new ModelAndView();
		  view.addObject("username", user.getUsername());
		  view.addObject("password", user.getPassword());
		  session.setAttribute("user", user);
		  session.setAttribute("username", user.getUsername());
		  view.setViewName("index");
		  return view;
	 }
	@ResponseBody   //返回json的时候，必须加  @responseBody注解
	@RequestMapping(value = "/tree", method = RequestMethod.GET)
	public JSONArray tree() {
		List<Map<String,Object>> tree = new ArrayList<Map<String, Object>>();
		Map<String,Object> node1 = new HashMap<String,Object>();
		Map<String,Object> node2 = new HashMap<String,Object>();
		Map<String,Object> node3 = new HashMap<String,Object>();
		Map<String,Object> node4 = new HashMap<String,Object>();
		node1.put("text", "节点1");
		node2.put("text", "节点2");
		node3.put("text", "节点3");
		node4.put("text", "节点4");
		
		List<Map<String,Object>> sub_1_3 = new ArrayList<Map<String, Object>>();
		Map<String,Object> node5 = new HashMap<String,Object>();
		Map<String,Object> node6= new HashMap<String,Object>();
		Map<String,Object> node7 = new HashMap<String,Object>();
		Map<String,Object> node8 = new HashMap<String,Object>();
		node5.put("text", "节点1.1");
		node6.put("text", "节点1.2");
		node7.put("text", "节点1.3");
		node8.put("text", "节点1.4");
		sub_1_3.add(node5);sub_1_3.add(node6);sub_1_3.add(node7);sub_1_3.add(node8);
		
		List<Map<String,Object>> sub_1_3_1 = new ArrayList<Map<String, Object>>();
		Map<String,Object> node9 = new HashMap<String,Object>();
		Map<String,Object> node10= new HashMap<String,Object>();
		Map<String,Object> node11= new HashMap<String,Object>();
		Map<String,Object> node12 = new HashMap<String,Object>();
		
		node9.put("text", "节点1.3.1");
		node10.put("text", "节点1.3.2");
		node11.put("text", "节点1.3.3");
		node12.put("text", "节点1.3.4");
		sub_1_3_1.add(node9);sub_1_3_1.add(node10);sub_1_3_1.add(node11);sub_1_3_1.add(node12);
		node1.put("children", sub_1_3);
		node7.put("children", sub_1_3_1);
		tree.add(node1);tree.add(node2);tree.add(node3);tree.add(node4);
		return JSONArray.fromObject(tree);
	}
	@ResponseBody   //返回json的时候，必须加  @responseBody注解
	@RequestMapping(value = "/json", method = RequestMethod.GET)
	public JSONArray jsontest() {
		Map map = new HashMap();
		map.put("k1", "11111");
		map.put("k2", "22222");
		System.out.println("map = "+map);
		return JSONArray.fromObject(map);
	}
	@ResponseBody   //返回json的时候，必须加  @responseBody注解
	@RequestMapping(value = "/db", method = RequestMethod.GET)
	public JSONArray testdb() {
		Map map = new HashMap();
		try{
			map.put("k1", "11111");
			map.put("k2", "22222");
			System.out.println("map = "+map);
			this.userService.addtest();
		}catch(Exception e){
			e.printStackTrace();
		}
		return JSONArray.fromObject(map);
	}
	
	@ResponseBody   //返回json的时候，必须加  @responseBody注解
	@RequestMapping(value = "/pushJsonObj")
	public JSONArray acceptJson(@RequestBody JsonObj user) {
		try{
			System.out.println("name="+user.getName()+",password="+user.getPassword());
		}catch(Exception e){
			e.printStackTrace();
		}
		return JSONArray.fromObject(user);
	}
	@ResponseBody   //返回json的时候，必须加  @responseBody注解
	@RequestMapping(value = "/pushJsonList")
	public JSONArray acceptJson(@RequestBody List<JsonObj> users) {
		try{
			System.out.println("users="+users.size()+","+users.get(0).getName());
		}catch(Exception e){
			e.printStackTrace();
		}
		return JSONArray.fromObject(users);
	}
	@ResponseBody   //返回json的时候，必须加  @responseBody注解
	@RequestMapping(value = "/kd")
	public String acceptJson(String html) {
		try{
			System.out.println("html="+html);
		}catch(Exception e){
			e.printStackTrace();
		}
		return html;
	}
}
