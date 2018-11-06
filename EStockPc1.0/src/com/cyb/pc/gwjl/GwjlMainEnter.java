package com.cyb.pc.gwjl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import com.cyb.pc.Contants;
import com.cyb.pc.bean.Stock;
import com.cyb.pc.event.ShowKPanelvent;
import com.cyb.pc.event.ShowLinePanelvent;
import com.cyb.utils.ConfigUtils;

public class GwjlMainEnter extends BaseFrame{
	public void start(){
	   try{
		ConfigUtils.init();
		Stock stock = new Stock();
		stock.setCode("000001");
		stock.setCode_("sh000001");
		stock.setName("上证指数");
		Contants.stock = stock;
		Contants.width = screenSize.width-200;
		Contants.height = screenSize.height-200;
		mainPane.setLayout(new BorderLayout());
		
	    north = MenuUtils.getMenus(window,center);//center to add click event
		north.setBackground(Color.white);
		mainPane.add(north, BorderLayout.NORTH);
			    
		west.setBackground(Color.white);
		JButton lineBtn = new JButton("分时线");
		lineBtn.setName("line");
		west.add(lineBtn);
		west.setPreferredSize(new Dimension(100, 2*30));
		lineBtn.addActionListener(new ShowLinePanelvent(window,center));
		
		JButton kBtn2 = new JButton("k线");
		kBtn2.setName("k");
		kBtn2.addActionListener(new ShowKPanelvent(window,center));
		west.add(kBtn2);
		
		JButton searchBtn = new JButton("搜索");
		searchBtn.setName("search");
		
		mainPane.add(west, BorderLayout.WEST);
		west.setPreferredSize(new Dimension(150, 2*30));
		east.setBackground(Color.white);
		east.add(searchBtn);
		east.removeAll();
		//east = new StockInforPanel().GridLayoutDemo();
		mainPane.add(east, BorderLayout.EAST);
		/*JFreeChart chart = new MinQutoesPanel(stock).createChart();
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(Integer.valueOf(ConfigUtils.get("CENTERW")), Integer.valueOf(ConfigUtils.get("CENTERH"))));  
		center.add(chartPanel);*/
		center.add(new StockListPanel("default").init());
		center.setBackground(Color.white);
		Contants.curPage ="STOCKLIST";
		mainPane.add(center, BorderLayout.CENTER);
		
		window.add(mainPane);
		/*window.setLocation(0, 0);
		window.setSize(Contants.width, Contants.height ); */
		window.pack(); 
		window.setVisible(true);
		ImageIcon i = new ImageIcon(System.getProperty("user.dir")+ConfigUtils.get("log"));
		window.setIconImage(i.getImage());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(50, 50, Contants.width, Contants.height*95/100);
		window.addWindowListener(new WindowAdapter()  //为了关闭窗口
		  {
		   public void windowClosing(WindowEvent e)
		   {
			   Contants.gwjl = null;
			   Contants.pushThreadPool.shutdown();
			   Contants.pushThreadPool = null;
		       System.exit(0);
		   }
		});
	   }catch(Exception e){
		  e.printStackTrace();
	   }
	}
	
	public static void main(String[] args) {
		Contants.gwjl = new GwjlMainEnter();
		Contants.gwjl.start();
		System.out.println(Contants.gwjl.window);
	}

}
