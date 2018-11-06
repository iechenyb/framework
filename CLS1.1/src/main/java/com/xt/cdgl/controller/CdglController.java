package com.xt.cdgl.controller;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cyb.utils.DateUtil;
import com.cyb.utils.UUIDUtils;
import com.xt.cdgl.po.SysMenu;
import com.xt.cdgl.service.CdglService;
@Controller
@RequestMapping("cdgl")
public class CdglController {
	@Resource(name="cdglService")
	public CdglService cdglService; 
	@RequestMapping("/db")
	@ResponseBody
	public JSONArray test(){
		SysMenu menu = new SysMenu();
		try{
			menu.setMenuId(UUIDUtils.getUUID());
			menu.setLevel(1);
			menu.setRank(1);
			menu.setMenuName("root");
			menu.setParentId(UUIDUtils.getUUID());
			//menu.setCreateTime(DateUtil.date2int8(new Date()));
			menu.setPath("/xxx/yyy");
			System.out.println("execute...");
			this.cdglService.addTest(menu);
			System.out.println("success");
		}catch(Exception e){
			e.printStackTrace();
		}
		return JSONArray.fromObject(menu);
	}
	@RequestMapping("/add")
	public ModelAndView addMenu(@ModelAttribute SysMenu menu){
		ModelAndView view = new ModelAndView();
		view.setViewName("cdgl/addMenu");
		System.out.println("charset:name: "+menu.getMenuName());
		view.addObject("parentId", menu.getParentId());
		view.addObject("parentBs", menu.getParentBs());
		try{
			menu.setMenuId(UUIDUtils.getUUID());
			menu.setPath("ls");
			menu.setCreateTime(DateUtil.date2long14(new Date()).toString());
			System.out.println("execute...");
			this.cdglService.add(menu);
			System.out.println("success");
		}catch(Exception e){
			e.printStackTrace();
		}
		return view;
	}
	@RequestMapping("/mod")
	public ModelAndView modMenu(@ModelAttribute SysMenu menu){
		ModelAndView view = new ModelAndView();
		view.setViewName("cdgl/addMenu");
		view.addObject("parentId", menu.getParentId());
		view.addObject("parentBs", menu.getParentBs());
		System.out.println("charset:name: "+menu.getMenuName());
		try{
			menu.setPath("ls");
			menu.setCreateTime(DateUtil.date2long14(new Date()).toString());
			System.out.println("execute...");
			this.cdglService.updateMenu(menu);
			System.out.println(" update success");
		}catch(Exception e){
			e.printStackTrace();
		}
		return view;
	}
	@RequestMapping("/del")
	@ResponseBody
	public int delMenu(String id){
		int ret = 0;
		try{
			ret = this.cdglService.delMenu(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return ret;
	}
	@RequestMapping("/getMenu")
	@ResponseBody
	public JSONArray getMenu(String id){
		Map<String,Object> ret = null;
		try{
			ret = this.cdglService.getMenuById(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return JSONArray.fromObject(ret);
	}
	@RequestMapping("/sub")
	@ResponseBody
	public JSONArray subList(String parentId){
		Map<String,Object> ret = this.cdglService.getSubMenuList(parentId);
		return JSONArray.fromObject(ret.get("list"));
	}
	@RequestMapping("/tree")
	@ResponseBody
	public JSONArray menuTree(String root){
		Map<String,Object> ret = this.cdglService.getMenuTree(root);
		return JSONArray.fromObject(ret);
	}
	@RequestMapping("/tree1")
	@ResponseBody
	public JSONArray menuTree1(String root){
		Map<String,Object> ret = this.cdglService.getMenuTree1(root);
		return JSONArray.fromObject(ret);
	}
}
