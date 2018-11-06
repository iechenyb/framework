package com.cyb.pc.gwjl;

import java.util.Date;

import org.jfree.data.time.Minute;

import net.sf.json.JSONArray;

import com.cyb.pc.Contants;
import com.cyb.utils.UrlUtils;

public class Test {

	public static void main(String[] args) {
		/*String content = UrlUtils.downJsonStrFromHttpUrl("http://121.42.144.78/phone/myConcerns.zc?username=13938469072");
		JSONArray data = JSONArray.fromObject(content);
		int len = data.size();
		for(int i=0;i<len;i++){
			System.out.println(data.getJSONObject(i).getString("NAME_")+data.getJSONObject(i).getString("CODE_"));
		}
		*/
		System.out.println(Minute.parseMinute("201501011023"));
		Minute min = new Minute(new Date());
		System.out.println("2016年03月18日09时41分37".substring(0, 4));
		System.out.println("2016年03月18日09时41分37".substring(5, 7));
		System.out.println("2016年03月18日09时41分37".substring(8, 10));
	}

}
