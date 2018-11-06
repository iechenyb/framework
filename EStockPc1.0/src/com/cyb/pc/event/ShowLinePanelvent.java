package com.cyb.pc.event;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import com.cyb.pc.Contants;
import com.cyb.pc.bean.Stock;
import com.cyb.pc.gwjl.KLineCombinePanel;
import com.cyb.pc.gwjl.LineChartPanel1;
import com.cyb.pc.gwjl.MinQutoesPanel;
import com.cyb.pc.quartz.PushMinute;
import com.cyb.utils.ConfigUtils;

public class ShowLinePanelvent extends BaseEvent implements ActionListener {
	public JPanel center = null;
	public JFrame window = null;
	public ShowLinePanelvent(JFrame window,JPanel center){
		this.center = center;
		this.window = window;
	}
	public void actionPerformed(ActionEvent e) {
		JButton obj = (JButton)e.getSource();
		System.out.println(e.getActionCommand()+"#"+obj.getName());
		JFreeChart chart;
		try {
			center.removeAll();
			//chart = new MinQutoesPanel(Contants.stock).createChart();
			chart = new LineChartPanel1(Contants.stock).createChart();
			ChartPanel chartPanel = new ChartPanel(chart);
			chartPanel.setPreferredSize(new Dimension(Integer.valueOf(ConfigUtils.get("CENTERW")), Integer.valueOf(ConfigUtils.get("CENTERH"))));   
			center.add(chartPanel);
			Contants.curPage ="MINPAGE";
			if(!Contants.isPushing){
				PushMinute psh = new PushMinute();
				Contants.pushThreadPool.execute(psh);
				Contants.isPushing = true;
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		refresh(window);
	}

}
