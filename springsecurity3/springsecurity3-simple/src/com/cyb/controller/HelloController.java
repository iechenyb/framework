package com.cyb.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @RequestMapping(value={"/welcome","/"},method=RequestMethod.GET)
    public String welcome(){
        return "index";
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')") 
    @RequestMapping(value={"/get","/"},method=RequestMethod.GET)
    @ResponseBody
    public String get(){
        return "123456789";
    }
}
