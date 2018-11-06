package com.cyb.pc.event;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import com.cyb.pc.Contants;
import com.cyb.pc.bean.Stock;
import com.cyb.pc.gwjl.GwjlMainEnter;
import com.cyb.pc.gwjl.LineChartPanel1;
import com.cyb.pc.gwjl.StockListPanel;
import com.cyb.pc.quartz.PushMinute;
import com.cyb.utils.ConfigUtils;

public class StockClickedEvent implements MouseListener{
	public StockListPanel table;
	public  DefaultTableModel model;
	public GwjlMainEnter pc ;
	public StockClickedEvent(StockListPanel table,DefaultTableModel model) {
		this.table = table;
		this.model = model;
		pc = Contants.gwjl;
	}
	public void mouseClicked(MouseEvent e) {
		try{
			// 得到选中的行列的索引值
			int r = table.getSelectedRow();
			int c = table.getSelectedColumn();
			// 得到选中的单元格的值，表格中都是字符串
			Object value = table.getValueAt(r, c);
			int code_idx = model.findColumn("code_");
			int name_idx = model.findColumn("股票名称");
			int cdoe_idx = model.findColumn("股票代码");
			String info = r + "行" + c + "列值 : " + value.toString()
					+ ",fix value=" + table.getValueAt(r, code_idx);
			Stock stock = new Stock();
			stock.setCode_(table.getValueAt(r, code_idx).toString());
			stock.setCode(table.getValueAt(r, cdoe_idx).toString());
			stock.setName(table.getValueAt(r, name_idx).toString());
			//javax.swing.JOptionPane.showMessageDialog(null, info);	
			pc.center.removeAll();
			Contants.stock = stock;
			if(!Contants.isPushing){
				PushMinute psh = new PushMinute();
				Contants.isPushing = true;
				Contants.pushThreadPool.execute(psh);
			}
			JFreeChart chart = new LineChartPanel1(stock).createChart();
			ChartPanel chartPanel = new ChartPanel(chart);
			chartPanel.setPreferredSize(new Dimension(Integer.valueOf(ConfigUtils.get("CENTERW")), Integer.valueOf(ConfigUtils.get("CENTERH"))));  
			Contants.curPage ="MINPAGE";
			pc.center.add(chartPanel);
			pc.refresh();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

}
