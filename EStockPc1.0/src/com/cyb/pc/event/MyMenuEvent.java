package com.cyb.pc.event;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import com.cyb.pc.Contants;
import com.cyb.pc.gwjl.LineChartPanel1;
import com.cyb.pc.gwjl.StockListPanel;
import com.cyb.pc.gwjl.ZdfxPieChartPanel;
import com.cyb.pc.quartz.PushMinute;
import com.cyb.utils.ConfigUtils;

public class MyMenuEvent  extends BaseEvent implements ActionListener{
	public JPanel center = null;
	public JFrame window = null;
	public MyMenuEvent(JFrame window,JPanel center){
		this.center = center;
		this.window = window;
	}
	public void actionPerformed(ActionEvent e) {
		try{
		JMenuItem obj = (JMenuItem)e.getSource();
		System.out.println("操作菜单信息："+e.getActionCommand()+"#"+e.getID()+"#"+obj.getName());
		//你需要跳转到的地方
		center.removeAll();
		Contants.stock.setName(e.getActionCommand());//obj.getName()
		//stock.setCode_;
		int menuType = Integer.valueOf(obj.getName().split("#")[0]);
		if(menuType==Contants.menusbar_hszs){
			if("zdtj".equals(obj.getName().split("#")[1])){
				JFreeChart chart= new ZdfxPieChartPanel().createChart();
				ChartPanel chartPanel = new ChartPanel(chart);
				chartPanel.setPreferredSize(new Dimension(Integer.valueOf(ConfigUtils.get("CENTERW")), Integer.valueOf(ConfigUtils.get("CENTERH"))));   
				center.add(chartPanel);
				Contants.curPage ="ZDTJ";
			}else{
				Contants.stock.setCode_(obj.getName().split("#")[1]);
				Contants.stock.setCode(Contants.stock.getCode_().substring(2,Contants.stock.getCode_().length()));
				JFreeChart chart= new LineChartPanel1(Contants.stock).createChart();
				ChartPanel chartPanel = new ChartPanel(chart);
				chartPanel.setPreferredSize(new Dimension(Integer.valueOf(ConfigUtils.get("CENTERW")), Integer.valueOf(ConfigUtils.get("CENTERH"))));    
				center.add(chartPanel);
				Contants.curPage ="MINPAGE";
				if(!Contants.isPushing){
					PushMinute psh = new PushMinute();
					Contants.pushThreadPool.execute(psh);
					Contants.isPushing = true;
				}
			}
		}else if(menuType==Contants.menusbar_hyfl){
			JScrollPane panel = new StockListPanel(obj.getName()).init();
			center.add(panel);
			Contants.curPage ="HYFL";
		}else if(menuType==Contants.menusbar_zdfx){
			JScrollPane panel = new StockListPanel(obj.getName()).init();
			center.add(panel);
			Contants.curPage ="ZDFX";
		}else if(menuType==Contants.menusbar_zxgp){
			Contants.curPage ="MINPAGE";
			Contants.stock.setCode_(obj.getName().split("#")[1]);
			Contants.stock.setCode(Contants.stock.getCode_().substring(2,Contants.stock.getCode_().length()));
			JFreeChart chart= new LineChartPanel1(Contants.stock).createChart();
			ChartPanel chartPanel = new ChartPanel(chart);
			chartPanel.setPreferredSize(new Dimension(Integer.valueOf(ConfigUtils.get("CENTERW")), Integer.valueOf(ConfigUtils.get("CENTERH"))));  
			center.add(chartPanel);
			if(!Contants.isPushing){
				PushMinute psh = new PushMinute();
				new Thread(psh).start();
				Contants.isPushing = true;
			}
		}else{
			System.out.println("menu code err!");
		}
		refresh(window);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
