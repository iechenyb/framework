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
	   map.put(1, "��������");
	   map.put(2, "���ݴ洢");
	   map.put(3, "Ƕ����ҳ");
	   map.put(4, "contentProvider");
	   map.put(5, "���ͨ��");
	   map.put(6, "�������");
	   map.put(7, "��ý��");
	   map.put(8, "�ֻ�����");
	   map.put(9, "��λ����");
	   map.put(10, "�ֻ�����");
	   map.put(11, "�̶���");
   }
   public static int menu_len = 1;
   public static Map<Integer,String> menus = new HashMap<Integer,String>();
   static{
	   menus.put(1, "����");
	   menus.put(2, "��ѡ��Ʊ");
	   menus.put(3, "���ǰ�");
	   menus.put(4, "�µ���");
	   menus.put(5, "��ͣ��");
	   menus.put(6, "��ͣ��");
	   menus.put(7, "ͣ�ư�");
	   menus.put(8, "��ҵ����");
	   menus.put(9, "����ָ��");
	   menus.put(10, "�°����");
	   menus.put(11, "��������");
	   menus.put(12, "��ҵͳ��");
	   menus.put(13, "�����ǵ�");
	   menus.put(14, "��������");
	   menus.put(15, "�����������");
	   menus.put(16, "�����������2");
	   menus.put(17, "����");
   }
   public static String hangyestr ="A#ũ������,B#�ɿ�ҵ,C#����ҵ,D#ˮ��ú��,E#����ҵ,F#�������� ,G#����ִ� ,H#ס�޲��� ,I#��Ϣ���� ,J#����ҵ ,K#���ز� ,L#������� ,M#���з��� ,N#�������� ,O#������� ,P#���� ,Q#���� ,R#�Ļ����� ,S#�ۺ� ";
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
