package com.cyb.pc.study;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class ThreadTable extends JTable {
	 private static DefaultTableModel model;

	 static String[] header = new String[] { "id", "name", "sex", "age" };

	 public ThreadTable() {
	  model = new DefaultTableModel(header, 0);
	  this.setModel(model);
	 }

	 public void deleteRows(int rowCount) throws Exception {
	  if (rowCount >= model.getColumnCount()) {
	   throw new Exception("删除的行数不能超过model的总行数！");
	  } else {
	   for (int i = rowCount - 1; i >= 0; i--) {
	    model.removeRow(i);
	   }
	  }
	 }

	 public void testInsertValue() {
	  Vector<String> value = new Vector<String>();
	  value.add("0");
	  value.add("simon");
	  value.add("bdoy");
	  value.add("21");
	 
	  addValueWithThread(value);
	  Vector<String> value1 = new Vector<String>();
	  value1.add("1");
	  value1.add("simon2");
	  value1.add("boy1");
	  value1.add("21");
	  addValueWithThread(value1);
	  Vector<String> value2 = new Vector<String>();
	  value2.add("2");
	  value2.add("simon2");
	  value2.add("bowey");
	  value2.add("21");
	  addValueWithThread(value2);
	  /*Thread thread = new Thread() {
	   public void run() {
	    for (int i = 0; i < 100000; i++) {
	     //addValueWithThread(value);//这个方法不会出现越界
	     addValueWithoutThread(value);//这个方法会出现越界,差别就在于加入一个线程
	     try {
	      sleep(10);
	     } catch (InterruptedException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	     }
	    }
	   }
	  };
	  thread.start();*/
	 }
	    /**
	     * 将添加记录和删除记录在一个线程里走，不会出现页面刷新的时候，数组越界的问题
	     * @param value
	     */
	 public void addValueWithThread(final Vector value) {
	  Thread thread = new Thread() {
	   public void run() {
	    Runnable runnable = new Runnable() {
	     public void run() {
	      model.addRow(value);
	      if (model.getRowCount() > 5) {
	       try {
	        deleteRows(2);
	       } catch (Exception e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	       }
	      }
	     }
	    };
	    SwingUtilities.invokeLater(runnable);
	   }
	  };
	  thread.start();
	 }
	 /**
	  * 这样一边添加记录，一边删除记录，会出现数组越界的情况
	  * @param value
	  */
	 public void addValueWithoutThread(final Vector value) {
	      model.addRow(value);
	      if (model.getRowCount() > 5) {
	       try {
	        deleteRows(2);
	       } catch (Exception e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	       }
	      }
	 }
	 
	 public  void hideColumn(JTable table,int index){ 
		    TableColumn tc= table.getColumnModel().getColumn(index); 
		    tc.setMaxWidth(0); 
		    tc.setPreferredWidth(0); 
		    tc.setMinWidth(0); 
		    tc.setWidth(0); 
		    table.getTableHeader().getColumnModel().getColumn(index).setMaxWidth(0); 
		    table.getTableHeader().getColumnModel().getColumn(index).setMinWidth(0); 
		}
	 public static void main(String[] args) {
	 

	  JFrame f = new JFrame();
	  f.getContentPane().setLayout(new BorderLayout());
	
	  final ThreadTable table = new ThreadTable();
	  table.hideColumn(table,0);
	  table.addMouseListener(new java.awt.event.MouseAdapter(){
          public void mouseClicked(MouseEvent e) {//仅当鼠标单击时响应
             //得到选中的行列的索引值
            int r= table.getSelectedRow();
            int c= table.getSelectedColumn();
            //得到选中的单元格的值，表格中都是字符串
            Object value= table.getValueAt(r, c);
            int x = model.findColumn("id");
            
            String info=r+"行"+c+"列值 : "+value.toString()+",fix value="+table.getValueAt(r, x);
            //table.getColumnModel()
            javax.swing.JOptionPane.showMessageDialog(null,info);
          }
      }); //在这个内部类中添加了mouseadaper这个类，这是没有注意的。
	  JScrollPane scroll = new JScrollPane(table);
	  f.getContentPane().add(scroll, BorderLayout.CENTER);

	  f.setSize(800, 600);
	  f.setLocation(250, 250);
	  f.setVisible(true);

	  table.testInsertValue();
	 }
	}