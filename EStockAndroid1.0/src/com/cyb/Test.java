package com.cyb;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
public class Test {
	public static void testJson(){
		 String jsonMessage = "{\"语文\":\"88\",\"数学\":\"78\",\"计算机\":\"99\"}";
		  String value1 = null;
		  try
		  {
		   //将字符串转换成jsonObject对象
		   JSONObject myJsonObject = new JSONObject(jsonMessage);
		   //获取对应的值
		   value1 = myJsonObject.getString("数学");
		   System.out.println("test value="+value1);
		  }
		  catch (Exception e)
		  {
			  e.printStackTrace();
		  }
	}
	public static void toJsonObject(String data){
		  String value1 = null;
		  try
		  {
		   //将字符串转换成jsonObject对象
		   JSONObject myJsonObject = new JSONObject(data);
		   //获取对应的值
		   value1 = myJsonObject.getString("canLogin");
		   System.out.println("test value="+value1);
		  }
		  catch (Exception e)
		  {
			  e.printStackTrace();
		  }
	}
  public static void main(String[] args) {
	  
	    Map<String, Object> map = new HashMap<String, Object>();
		map.put("canLogin", false);
//		String strMap = JSONArray.toJSONObject(map).toString();
//		System.out.println(strMap);
//		JSONObject obj = JSONArray.fromObject(strMap).getJSONObject(0);
//		System.out.println(obj.getBoolean("canLogin"));
//		JSONObject myJsonObject = new JSONObject(jsonMessage);
		 String jsonMessage = "{\"语文\":\"88\",\"数学\":\"78\",\"计算机\":\"99\"}";
		  String value1 = null;
		  try
		  {
		   //将字符串转换成jsonObject对象
		   JSONObject myJsonObject = new JSONObject(jsonMessage);
		   //获取对应的值
		   value1 = myJsonObject.getString("数学");
		   System.out.println("test value="+value1);
		  }
		  catch (Exception e)
		  {
			  e.printStackTrace();
		  }
}
}
