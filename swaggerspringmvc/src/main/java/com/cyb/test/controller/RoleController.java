package com.cyb.test.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mangofactory.swagger.plugin.EnableSwagger;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Controller
@EnableSwagger
@RequestMapping("/role")
@Api(value = "RoleController", description = "角色管理模块")
public class RoleController {
 
	@RequestMapping(value="/get/{id}",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "根据id获取角色信息", httpMethod = "GET", 
	//produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
	//response = String.class, 
	notes = "方法详细描述")
	/*@ApiImplicitParams({
        //@ApiImplicitParam(name = "id", value = "唯一id", required = true, dataType = "Integer", paramType = "path"),
	})*/
	@ApiResponses(value = {  
	          @ApiResponse(code = 400, message = "No Name Provided")  
	 })
	public String get(@ApiParam(value = "唯一id") @PathVariable("id") Integer id){
        System.out.println("get"+id);
       return ("hello:"+id);
    }
	@ResponseBody
    @RequestMapping(value="/add",method=RequestMethod.POST)
    public Map<String,Object> post(@ApiParam(value = "唯一id")  @RequestParam(value = "id", required = true) Integer id){
        System.out.println("post"+id);
        Map<String,Object> res = new HashMap<String,Object>();
        res.put("id", id);
        return res;
    }
    @ResponseBody
    @RequestMapping(value="/update",method=RequestMethod.PUT)
    public String put(@RequestParam(value = "id", required = true) Integer id){
        System.out.println("put"+id);
        return "/hello"+id;
    }
    @ResponseBody
    @RequestMapping(value="/delete",method=RequestMethod.DELETE)
    public String delete(@RequestParam(value = "id", required = true) Integer id){
        System.out.println("delete"+id);
        return "/hello"+id;
    } 
}
