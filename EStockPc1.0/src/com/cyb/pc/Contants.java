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
		menusbar.add("����ָ��");
		menusbar.add("��ҵ����");
		menusbar.add("�ǵ�����");
		menusbar.add("��ѡ��Ʊ");   
		menusbar.add("����"); 
		menusbar.add("�����");
		menusbar.add("��½");
		menusbar.add("ע��");
		menusbar.add("��ϵ����");
	}
	public static int menusbar_hszs = 0;
	public static int menusbar_hyfl = 1;
	public static int menusbar_zdfx = 2;
	public static int menusbar_zxgp = 3;
	public static List<String> dpzsLst = new ArrayList<String>();
	static{
		dpzsLst.add("sh000001#��ָ֤��");
		dpzsLst.add("sz399001#��֤��ָ");
		dpzsLst.add("sz399006#��ҵ����");
	}
	//type= sz xd tp 1 2
	public static String pp = "0";//ƽ��
	public static String zt = "1";//��ͣ
	public static String dt = "2";//��ͣ
	public static String sz = "sz";//����
    public static String xd = "xd";//�µ�
	public static String tp = "tp";//ͣ��
	public static List<String> zdfxLst = new ArrayList<String>();
	static{
		zdfxLst.add(pp+"#ƽ��");
		zdfxLst.add(zt+"#��ͣ");
		zdfxLst.add(sz+"#����");
		zdfxLst.add(xd+"#�µ�");
		zdfxLst.add(tp+"#ͣ��");
		zdfxLst.add(dt+"#��ͣ");
	}
    public static Map<String,String> zdbzMap = new HashMap<String,String>();
    static{
	  zdbzMap.put(pp, "ƽ��");
	  zdbzMap.put(zt, "��ͣ");
	  zdbzMap.put(dt, "��ͣ");
	  zdbzMap.put(sz, "����");
	  zdbzMap.put(xd, "�µ�");
	  zdbzMap.put(tp, "ͣ��");
    }	
}
