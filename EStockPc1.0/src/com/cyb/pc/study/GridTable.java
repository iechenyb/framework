package com.cyb.pc.study;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GridTable {

	JFrame jframe = new JFrame();  
    // ��ʼ������  
    public void initFrame() {  
        // ����JPanel��ӱ���ͼƬ  
        jframe.setTitle("����");  
	   	 String[] columnName = { "����", "�Ա�", "��λ", "�μ���Ŀ", "��ע" }; 
	   	 String[][] rowData = { { "����", "��", "�����ϵ", "100 �� ,200 ��", "" }, 
	   	 { "����", "��", "��ѧϵ", "100 �ף�Ǧ��", "" }, 
	   	 }; 
	   	            // �������
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
