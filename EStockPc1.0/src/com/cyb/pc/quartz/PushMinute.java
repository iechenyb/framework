package com.cyb.pc.quartz;

import java.awt.Dimension;
import java.util.Date;

import javax.swing.JLabel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import com.cyb.pc.Contants;
import com.cyb.pc.gwjl.GwjlMainEnter;
import com.cyb.pc.gwjl.LineChartPanel1;
import com.cyb.utils.ConfigUtils;
import com.cyb.utils.DateUtil;

public class PushMinute implements Runnable{
    public GwjlMainEnter pc =null;
	public PushMinute(){
		pc = Contants.gwjl;
    }
	public void run() {/*
		while(true){
			if("MINPAGE".equals(Contants.curPage)){
				pc.center.removeAll();
				pc.east.removeAll();
				JFreeChart chart = new LineChartPanel1(Contants.stock).createChart();
				ChartPanel chartPanel = new ChartPanel(chart);
				chartPanel.setPreferredSize(new Dimension(Integer.valueOf(ConfigUtils.get("CENTERW")), Integer.valueOf(ConfigUtils.get("CENTERH"))));
				pc.center.add(chartPanel);
				pc.east.add(new JLabel("更新时间:"+DateUtil.format(new Date(), "yyyy年MM月dd日HH时mm分ss秒")));
			}
			try {
				System.out.println(DateUtil.format(new Date(), "yyyy年MM月dd日HH时mm分ss秒")+",push the minute qutoes of "+Contants.stock);
				Thread.sleep(Long.valueOf(ConfigUtils.get("PUSHINTERVAL"))*1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	*/}
}
