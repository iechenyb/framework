package com.cyb.pc.gwjl;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.cyb.pc.Contants;
import com.cyb.pc.event.StockClickedEvent;
import com.cyb.utils.ConfigUtils;
import com.cyb.utils.UrlUtils;
import com.sun.corba.se.impl.orbutil.closure.Constant;

public class StockListPanel extends JTable {
	private static final long serialVersionUID = 1L;

	private  DefaultTableModel model;

	static String[] header = new String[] { "code_","股票代码", "股票名称", "最新价","涨跌幅","涨跌","开盘", "昨收", "最高", "最低", "成交量","成交额" };
	public StockListPanel() {};
	public StockListPanel(String  type) {
		model = new DefaultTableModel(header, 0);
		this.setModel(model);
		if(type.equals("default")){
			if(Contants.username.equals("")){
				Contants.username= ConfigUtils.get("username");
			}
			String url=ConfigUtils.get("WebPath")+ConfigUtils.get("MYCONCERNS")+"?username="+Contants.username;
			initStockList(url);
		}else{
			 int menuType = Integer.valueOf(type.split("#")[0]);
			 if(menuType==Contants.menusbar_hyfl){
			     String url=ConfigUtils.get("WebPath")+ConfigUtils.get("HYFL")+"?type="+type.split("#")[1];
			     initStockList(url);
		     }else  if(menuType==Contants.menusbar_zdfx){
			     String url=ConfigUtils.get("WebPath")+ConfigUtils.get("ZDFX")+"?type="+type.split("#")[1];
			     initStockList(url);
		     }
		}
	}
	
	public void initStockList(String url){
		String html = UrlUtils.downJsonStrFromHttpUrl(url);
		JSONArray arr = JSONArray.fromObject(html);
		Vector<String> stock = null;
		for(int i=0;i<arr.size();i++){
			JSONObject obj = arr.getJSONObject(i);
			stock = new Vector<String>();
			stock.add(obj.getString("CODE_"));
			stock.add(obj.getString("CODEONLY"));
			stock.add(obj.getString("NAME_"));
			stock.add(obj.getString("PRICE_"));
			stock.add(obj.getString("A").replace("-", ""));
			stock.add(obj.getString("A1").replace("-", ""));
			stock.add(obj.getString("OPEN_"));
			stock.add(obj.getString("PRECLOSE_"));
			stock.add(obj.getString("HIGH_"));
			stock.add(obj.getString("LOW_"));
			stock.add(obj.getString("VOLUME"));
			stock.add(obj.getString("TURNVOLUME"));
			model.addRow(stock);
		}
	}
	public void initDefaultValue() {
		Vector<String> value = new Vector<String>();
		value.add("0");
		value.add("simon");
		value.add("bdoy");
		value.add("21");
		model.addRow(value);
		Vector<String> value1 = new Vector<String>();
		value1.add("1");
		value1.add("simon2");
		value1.add("boy1");
		value1.add("21");
		model.addRow(value1);
		Vector<String> value2 = new Vector<String>();
		value2.add("2");
		value2.add("simon2");
		value2.add("bowey");
		value2.add("21");
		model.addRow(value2);
	}
	
	public void hideColumn(JTable table, int index) {
		TableColumn tc = table.getColumnModel().getColumn(index);
		tc.setMaxWidth(0);
		tc.setPreferredWidth(0);
		tc.setMinWidth(0);
		tc.setWidth(0);
		table.getTableHeader().getColumnModel().getColumn(index).setMaxWidth(0);
		table.getTableHeader().getColumnModel().getColumn(index).setMinWidth(0);
	}
	public  JScrollPane init(){
		StockListPanel table = this;
		table.hideColumn(table, 0);
		table.setBounds(0, 0, 800, 600);
		table.addMouseListener(new StockClickedEvent(table,model)); // 在这个内部类中添加了mouseadaper这个类，这是没有注意的。
		JScrollPane scroll = new JScrollPane(table);
		//设置居中
		DefaultTableCellRenderer   r   =   new   DefaultTableCellRenderer();   
		r.setHorizontalAlignment(JLabel.CENTER); 
		table.setDefaultRenderer(Object.class,   r);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scroll.setPreferredSize(new Dimension(Integer.valueOf(ConfigUtils.get("CENTERW")), Integer.valueOf(ConfigUtils.get("CENTERH"))));  
		return scroll;
	}

	public static void main(String[] args) {
		
		StockListPanel table = new StockListPanel("default");
		table.hideColumn(table, 0);
		table.addMouseListener(new StockClickedEvent(table,null)); // 在这个内部类中添加了mouseadaper这个类，这是没有注意的。
		JScrollPane scroll = new JScrollPane(table);
		
		JFrame f = new JFrame();
		f.getContentPane().setLayout(new BorderLayout());
		f.getContentPane().add(scroll, BorderLayout.CENTER);
		f.setSize(800, 600);
		f.setLocation(250, 250);
		f.setVisible(true);
	}
}