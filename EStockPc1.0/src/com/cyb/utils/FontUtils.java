package com.cyb.utils;

import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.StandardChartTheme;

public class FontUtils {
	/**
	 * resolution the unicode question.
	 * @return
	 */
  public static StandardChartTheme getStandardChartTheme(){
	  //ChartFactory.setChartTheme(FontUtils.getStandardChartTheme()); 
	//����������ʽ  
	   StandardChartTheme standardChartTheme=new StandardChartTheme("CN");  
	   //���ñ�������  
	   standardChartTheme.setExtraLargeFont(new Font("����",Font.BOLD,20)); //���� 
	   //����ͼ��������  
	   standardChartTheme.setRegularFont(new Font("����",Font.PLAIN,15));  
	   //�������������  
	   standardChartTheme.setLargeFont(new Font("����",Font.PLAIN,15));  
	   return standardChartTheme;
  }
}
