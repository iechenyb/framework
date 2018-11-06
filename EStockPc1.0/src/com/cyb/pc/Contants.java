package com.cyb.pc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.cyb.pc.bean.Stock;
import com.cyb.pc.gwjl.GwjlMainEnter;

public class Contants {
	//ExecutorService cachedThreadPool = Executors.newCachedThreadPool();  
	public static ExecutorService pushThreadPool = Executors.newFixedThreadPool(1);  
	public static boolean isPushing = false;
	public static String curPage = "";
	public static String username ="";
	public static GwjlMainEnter gwjl = null;
	public static Stock stock = new Stock();
	public static int width = 0;
	public static int height = 0;
	public static List<String> menusbar = new ArrayList<String>();
	static {
		menusbar.add("沪深指数");
		menusbar.add("行业分类");
		menusbar.add("涨跌分析");
		menusbar.add("自选股票");   
		menusbar.add("搜索"); 
		menusbar.add("意见箱");
		menusbar.add("登陆");
		menusbar.add("注册");
		menusbar.add("联系我们");
	}
	public static int menusbar_hszs = 0;
	public static int menusbar_hyfl = 1;
	public static int menusbar_zdfx = 2;
	public static int menusbar_zxgp = 3;
	public static List<String> dpzsLst = new ArrayList<String>();
	static{
		dpzsLst.add("sh000001#上证指数");
		dpzsLst.add("sz399001#深证成指");
		dpzsLst.add("sz399006#创业板综");
	}
	//type= sz xd tp 1 2
	public static String pp = "0";//平盘
	public static String zt = "1";//涨停
	public static String dt = "2";//跌停
	public static String sz = "sz";//上涨
    public static String xd = "xd";//下跌
	public static String tp = "tp";//停牌
	public static List<String> zdfxLst = new ArrayList<String>();
	static{
		zdfxLst.add(pp+"#平盘");
		zdfxLst.add(zt+"#涨停");
		zdfxLst.add(sz+"#上涨");
		zdfxLst.add(xd+"#下跌");
		zdfxLst.add(tp+"#停牌");
		zdfxLst.add(dt+"#跌停");
	}
    public static Map<String,String> zdbzMap = new HashMap<String,String>();
    static{
	  zdbzMap.put(pp, "平盘");
	  zdbzMap.put(zt, "涨停");
	  zdbzMap.put(dt, "跌停");
	  zdbzMap.put(sz, "上涨");
	  zdbzMap.put(xd, "下跌");
	  zdbzMap.put(tp, "停牌");
    }	
}
