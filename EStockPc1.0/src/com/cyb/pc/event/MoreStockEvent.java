package com.cyb.pc.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;

import com.cyb.pc.Contants;
import com.cyb.pc.gwjl.GwjlMainEnter;
import com.cyb.pc.gwjl.StockListPanel;

public class MoreStockEvent extends BaseEvent implements ActionListener{
	public String type;
	public GwjlMainEnter pc ;
	public MoreStockEvent(String type){
		this.type = type;
		 pc = Contants.gwjl;
	}
	public void actionPerformed(ActionEvent e) {
		if(type.equals("myconcern")){
			try {
				pc.center.removeAll();
				JScrollPane stockList = new StockListPanel("default").init();
				pc.center.add(stockList);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			refresh(pc.window);
		}
	}

}
