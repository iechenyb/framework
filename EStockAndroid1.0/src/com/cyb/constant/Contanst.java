package com.cyb.constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Contanst {
   public static String USERNAME = ""; 
   public static int DB_VERSION = 1;
   public static String DB_NAME ="test.db";
   public static Map<Integer,String> map = new HashMap<Integer,String>();
   static{
	   map.put(1, "股往今来");
	   map.put(2, "数据存储");
	   map.put(3, "嵌入网页");
	   map.put(4, "contentProvider");
	   map.put(5, "组件通信");
	   map.put(6, "桌面组件");
	   map.put(7, "多媒体");
	   map.put(8, "手机服务");
	   map.put(9, "定位服务");
	   map.put(10, "手机服务");
	   map.put(11, "固定列");
   }
   public static int menu_len = 1;
   public static Map<Integer,String> menus = new HashMap<Integer,String>();
   static{
	   menus.put(1, "搜索");
	   menus.put(2, "自选股票");
	   menus.put(3, "上涨榜");
	   menus.put(4, "下跌榜");
	   menus.put(5, "涨停榜");
	   menus.put(6, "跌停榜");
	   menus.put(7, "停牌榜");
	   menus.put(8, "行业分类");
	   menus.put(9, "大盘指数");
	   menus.put(10, "新版测试");
	   menus.put(11, "收盘行情");
	   menus.put(12, "行业统计");
	   menus.put(13, "今日涨跌");
	   menus.put(14, "分钟行情");
	   menus.put(15, "分钟行情面积");
	   menus.put(16, "分钟行情面积2");
	   menus.put(17, "更多");
   }
   public static String hangyestr ="A#农林牧渔,B#采矿业,C#制造业,D#水电煤气,E#建筑业,F#批发零售 ,G#运输仓储 ,H#住宿餐饮 ,I#信息技术 ,J#金融业 ,K#房地产 ,L#商务服务 ,M#科研服务 ,N#公共环保 ,O#居民服务 ,P#教育 ,Q#卫生 ,R#文化传播 ,S#综合 ";
   public static Map<String,String> HYMAP = new HashMap<String, String>();
   public static List<Map<String,String>> indsutrys = new ArrayList<Map<String,String>>();
   static{
	  String[] hangyearr =  hangyestr.split(",");
	  Map tmpMap = null;
	  for(int i=0;i<hangyearr.length;i++){
		  tmpMap = new HashMap();
		  tmpMap.put(hangyearr[i].split("#")[0], hangyearr[i].split("#")[1]);
		  HYMAP.put(hangyearr[i].split("#")[0], hangyearr[i].split("#")[1]);
		  indsutrys.add(tmpMap);
	  }
   }

   public static String SERVER ="http://zhuhx520.xicp.net";
   public static String PREOJECTNAME="/EStock";
   public static String WEBPATH = SERVER+PREOJECTNAME;
}
