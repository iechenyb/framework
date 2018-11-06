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
	   throw new Exception("ɾ�����������ܳ���model����������");
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
	     //addValueWithThread(value);//��������������Խ��
	     addValueWithoutThread(value);//������������Խ��,�������ڼ���һ���߳�
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
	     * ����Ӽ�¼��ɾ����¼��һ���߳����ߣ��������ҳ��ˢ�µ�ʱ������Խ�������
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
	  * ����һ����Ӽ�¼��һ��ɾ����¼�����������Խ������
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
          public void mouseClicked(MouseEvent e) {//������굥��ʱ��Ӧ
             //�õ�ѡ�е����е�����ֵ
            int r= table.getSelectedRow();
            int c= table.getSelectedColumn();
            //�õ�ѡ�еĵ�Ԫ���ֵ������ж����ַ���
            Object value= table.getValueAt(r, c);
            int x = model.findColumn("id");
            
            String info=r+"��"+c+"��ֵ : "+value.toString()+",fix value="+table.getValueAt(r, x);
            //table.getColumnModel()
            javax.swing.JOptionPane.showMessageDialog(null,info);
          }
      }); //������ڲ����������mouseadaper����࣬����û��ע��ġ�
	  JScrollPane scroll = new JScrollPane(table);
	  f.getContentPane().add(scroll, BorderLayout.CENTER);

	  f.setSize(800, 600);
	  f.setLocation(250, 250);
	  f.setVisible(true);

	  table.testInsertValue();
	 }
	}