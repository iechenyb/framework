package com.jmx;

import java.util.List;

public interface Controller1MBean {
	 public String  connectServer(String host);
	 public List<String> showDir(String dir);
	 public String createDir(String dir,String data);
	 public  void setDirData(String dir,String data);
	 public  void delDirData(String path);
}
