package com.cyb;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
public class Test {
	public static void testJson(){
		 String jsonMessage = "{\"����\":\"88\",\"��ѧ\":\"78\",\"�����\":\"99\"}";
		  String value1 = null;
		  try
		  {
		   //���ַ���ת����jsonObject����
		   JSONObject myJsonObject = new JSONObject(jsonMessage);
		   //��ȡ��Ӧ��ֵ
		   value1 = myJsonObject.getString("��ѧ");
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
		   //���ַ���ת����jsonObject����
		   JSONObject myJsonObject = new JSONObject(data);
		   //��ȡ��Ӧ��ֵ
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
		 String jsonMessage = "{\"����\":\"88\",\"��ѧ\":\"78\",\"�����\":\"99\"}";
		  String value1 = null;
		  try
		  {
		   //���ַ���ת����jsonObject����
		   JSONObject myJsonObject = new JSONObject(jsonMessage);
		   //��ȡ��Ӧ��ֵ
		   value1 = myJsonObject.getString("��ѧ");
		   System.out.println("test value="+value1);
		  }
		  catch (Exception e)
		  {
			  e.printStackTrace();
		  }
}
}
