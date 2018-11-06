package com.cyb.pc.study;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GridTable {

	JFrame jframe = new JFrame();  
    // 初始化窗口  
    public void initFrame() {  
        // 利用JPanel添加背景图片  
        jframe.setTitle("测试");  
	   	 String[] columnName = { "姓名", "性别", "单位", "参加项目", "备注" }; 
	   	 String[][] rowData = { { "张三", "男", "计算机系", "100 米 ,200 米", "" }, 
	   	 { "李四", "男", "化学系", "100 米，铅球", "" }, 
	   	 }; 
	   	            // 创建表格
	   	JTable table = new JTable(new DefaultTableModel(rowData, columnName));
	   	table.setEnabled(false);
	   	table.addComponentListener(new ComponentListener() {
			
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub
				System.out.println("x");
			}
			
			public void componentResized(ComponentEvent e) {
				// TODO Auto-generated method stub
				System.out.println("y");
			}
			
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub
				System.out.println("z");
			}
			
			public void componentHidden(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	   	jframe.add(table);
	   	jframe.setBounds(10, 10, 500, 400);
        jframe.pack();  
        jframe.setVisible(true);  
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    }  
  
    public static void main(String[] args) {  
        new GridTable().initFrame();  
    }  
  
}
