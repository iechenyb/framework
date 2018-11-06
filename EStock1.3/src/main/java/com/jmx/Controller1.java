package com.jmx;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.zookeeper.KeeperException;

import com.zookeeper.ZookeeperClient;


public class Controller1 implements Controller1MBean {  
   private static final Log log = LogFactory.getLog(Controller1.class);
   ZookeeperClient client = null;
   public String  connectServer(String host){
	    client = new ZookeeperClient();
	    if(StringUtils.isEmpty(host)){
		   host = "192.168.16.211:2181";
		}
		// 连接zookeeper
		try {
			client.connectZookeeper(host);
		} catch (Exception e) {
			e.printStackTrace();
			return "zookeeper连接失败！";
		} 
		log.info("zookeeper连接成功！");
		return "zookeeper连接成功！";
   }
   public List<String> showDir(String dir){
	   try {
		List<String> children = client.getChildren(dir);
		return children;
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	} 
   } 
   public String createDir(String dir,String data){
	   try {
		    String result = client.createNode(dir, data.getBytes());
			log.info(result + "节点创建成功！");
		return result;
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	} 
   } 
   public  void setDirData(String dir,String data){
	   try {
		client.setData(dir, data.getBytes(), data.length());
	} catch (KeeperException e) {
		e.printStackTrace();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
   }
   public  void delDirData(String path){
	   try {
		client.deleteNode(path, 0);
	} catch (KeeperException e) {
		e.printStackTrace();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
   }
   
}  
