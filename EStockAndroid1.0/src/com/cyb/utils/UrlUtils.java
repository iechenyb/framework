package com.cyb.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import android.annotation.SuppressLint;
import android.os.StrictMode;

public class UrlUtils {
	@SuppressLint("NewApi")
	public static String sendRequestByUri(String uri,Map<String,String> params ) {
		String ret = "[]";
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
		System.out.println(uri);
		HttpPost httpRequest = new HttpPost(uri);
		List<NameValuePair> lst = new ArrayList<NameValuePair>();
		Set<String> keys = params.keySet( );
		try {
			if(keys != null) {
			Iterator<String> iterator = keys.iterator();
			while(iterator.hasNext( )) {
				Object key = iterator.next( );
				Object value = params.get(key);
				if(value!=null&&!"".equals(value.toString())){
				 System.out.println(key+","+value);
				 lst.add(new BasicNameValuePair(key.toString(), value.toString()));
				}
			}
		    httpRequest.setEntity(new UrlEncodedFormEntity(lst,HTTP.UTF_8));
			HttpResponse rep = new DefaultHttpClient().execute(httpRequest);
			if(rep.getStatusLine().getStatusCode()!=404){
				 ret = EntityUtils.toString(rep.getEntity());
			}
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
	public static void main(String[] args) {/*
		Map map = new HashMap();
		map.put("name", "chenyb");
		map.put("age", "20");
		Set keys = map.keySet( );
		if(keys != null) {
			Iterator iterator = keys.iterator( );
			while(iterator.hasNext( )) {
				Object key = iterator.next( );
				Object value = map.get(key);
				System.out.println(key+","+value);
			}
		}
	*/}
}
