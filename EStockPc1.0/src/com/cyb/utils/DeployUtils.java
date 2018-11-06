package com.cyb.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DeployUtils {
	//�����ļ����������ļ�
	public static void copy(File[] fl, File file) {
	    if (!file.exists()) // ����ļ��в�����
	        file.mkdir(); // �����µ��ļ���
	    for (int i = 0; i < fl.length; i++) {
	        if (fl[i].isFile()) { // ������ļ����;͸����ļ�
	        	/*if(fl[i].getName().equals("App.properties")){
	        		System.out.println(fl[i].getName());
	        	}*/
	            try {
	                FileInputStream fis = new FileInputStream(fl[i]);
	                FileOutputStream out = new FileOutputStream(new File(file
	                        .getPath()
	                        + File.separator + fl[i].getName()));
	                int count = fis.available();
	                byte[] data = new byte[count];
	                if ((fis.read(data)) != -1) {
	                    out.write(data); // �����ļ�����
	                }
	                out.close(); // �ر������
	                fis.close(); // �ر�������
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	        if (fl[i].isDirectory()) { // ������ļ�������
	            File des = new File(file.getPath() + File.separator
	                    + fl[i].getName());
	            des.mkdir(); // ��Ŀ���ļ����д�����ͬ���ļ���
	            copy(fl[i].listFiles(), des); // �ݹ���÷�������
	        }
	    }
	}    
	
	public static void copyEstock(){
		File sourFile = null, desFile = null;
	    String sourFolder = "D:\\apache-tomcat-7.0.52\\webapps\\EStockSvn"; // �����޸�Դ�ļ���·��
	    String desFolder = "D:\\chenyb\\myproject\\deploy\\EStock"; // �����޸�Ŀ���ļ���·��
	    sourFile = new File(sourFolder);
	    if (!sourFile.isDirectory() || !sourFile.exists()) {
	        System.out.println("Դ�ļ��в�����");
	    }else{ desFile = new File(desFolder);
		    desFile.mkdir();
		    copy(sourFile.listFiles(), desFile); //����copy()����
		    System.out.println("�ļ��и��Ƴɹ���");
	    }
	}
	public static void copyBackServer(){
		File sourFile = null, desFile = null;
	    String sourFolder = "D:\\apache-tomcat-7.0.52\\webapps\\BackServerSvn"; // �����޸�Դ�ļ���·��
	    String desFolder = "D:\\chenyb\\myproject\\deploy\\BackServer"; // �����޸�Ŀ���ļ���·��
	    sourFile = new File(sourFolder);
	    if (!sourFile.isDirectory() || !sourFile.exists()) {
	        System.out.println("Դ�ļ��в�����");
	    }else{ desFile = new File(desFolder);
		    desFile.mkdir();
		    copy(sourFile.listFiles(), desFile); //����copy()����
		    System.out.println("�ļ��и��Ƴɹ���");
	    }
	}
	
	public static void resetApp1(){
		File sourFile = null, desFile = null;
	    String src = "D:\\apache-tomcat-7.0.52\\webapps\\EStockSvn\\WEB-INF\\classes\\AppServer.properties"; // �����޸�Դ�ļ���·��
	    String dest = "D:\\chenyb\\myproject\\deploy\\EStock\\WEB-INF\\classes\\App.properties"; // �����޸�Ŀ���ļ���·��
	    try {
			FileUtils.copyFile(src, dest);
			System.out.println("�ļ����Ƴɹ���");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void resetApp2(){
		File sourFile = null, desFile = null;
	    String src = "D:\\apache-tomcat-7.0.52\\webapps\\BackServerSvn\\WEB-INF\\classes\\AppServer.properties"; // �����޸�Դ�ļ���·��
	    String dest = "D:\\chenyb\\myproject\\deploy\\BackServer\\WEB-INF\\classes\\App.properties"; // �����޸�Ŀ���ļ���·��
	    try {
			FileUtils.copyFile(src, dest);
			System.out.println("�ļ����Ƴɹ���");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   /* if (!sourFile.isDirectory() || !sourFile.exists()) {
	        System.out.println("Դ�ļ��в�����");
	    }else{ desFile = new File(desFolder);
		    desFile.mkdir();
		    copy(sourFile.listFiles(), desFile); //����copy()����
		    System.out.println("�ļ��и��Ƴɹ���");
	    }*/
	}
	public static void main(String[] args) {
		copyEstock();
		//copyBackServer();
		resetApp1();
		//resetApp2();
	}
}
