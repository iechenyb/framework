package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;


public class CrossWebFilter implements Filter {


    public CrossWebFilter() {
       
    }


	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		 
		 HttpServletResponse resp = (HttpServletResponse) response;
		 resp.addHeader("Access-Control-Allow-Origin", "*"); 
		 // 如果存在自定义的header参数，需要在此处添加，逗号分隔 
		 resp.addHeader( "Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, " + "If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, " + "Content-Type, X-E4M-With"); 
		 resp.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		 chain.doFilter(request, resp);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}
	/**
	 *  XMLHttpRequest cannot load http://localhost:8081/CLS1.1/cdgl/tree.cs?root=MENUROOT. 
	 *  No 'Access-Control-Allow-Origin' header is present on the requested resource. 
	 *  Origin 'http://localhost:8089' is therefore not allowed access. The response had HTTP status code 404.
	 */

}
