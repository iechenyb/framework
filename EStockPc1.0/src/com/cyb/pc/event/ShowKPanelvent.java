package com.cyb.pc.event;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import com.cyb.pc.Contants;
import com.cyb.pc.gwjl.KLineCombinePanel;
import com.cyb.utils.ConfigUtils;

public class ShowKPanelvent extends BaseEvent implements ActionListener {
	public JPanel center = null;
	public JFrame window = null;
	public ShowKPanelvent(JFrame window,JPanel center){
		this.center = center;
		this.window = window;
	}
	public void actionPerformed(ActionEvent e) {
		JButton obj = (JButton)e.getSource();
		System.out.println(e.getActionCommand()+"#"+obj.getName());
		center.removeAll();
		Contants.gwjl.east.removeAll();
		JFreeChart chart= new KLineCombinePanel(Contants.stock).createChart();
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(Integer.valueOf(ConfigUtils.get("CENTERW")), Integer.valueOf(ConfigUtils.get("CENTERH"))));  
		center.add(chartPanel);
		refresh(window);
		Contants.curPage ="MINPAGE";
		
	}

}
