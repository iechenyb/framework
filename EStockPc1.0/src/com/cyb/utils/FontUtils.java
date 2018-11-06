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
	//创建主题样式  
	   StandardChartTheme standardChartTheme=new StandardChartTheme("CN");  
	   //设置标题字体  
	   standardChartTheme.setExtraLargeFont(new Font("宋书",Font.BOLD,20)); //隶书 
	   //设置图例的字体  
	   standardChartTheme.setRegularFont(new Font("宋书",Font.PLAIN,15));  
	   //设置轴向的字体  
	   standardChartTheme.setLargeFont(new Font("宋书",Font.PLAIN,15));  
	   return standardChartTheme;
  }
}
