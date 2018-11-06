package com.cyb.pc.study;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.category.DefaultCategoryDataset;

public class SwingFrameWithJFreeChart {
	static class DemoTableModel extends AbstractTableModel implements
			TableModel {
		private static final long serialVersionUID = 1L;
		private Object[][] data;

		public DemoTableModel(int rows, int column) {
			this.data = new Object[rows][column];
		}

		public int getColumnCount() {
			return 16;
		}

		public int getRowCount() {
			return this.data.length;
		}

		public Object getValueAt(int row, int column) {
			return this.data[row][column];
		}

		public void setValueAt(Object value, int row, int column) {
			this.data[row][column] = value;
			fireTableDataChanged();
		}

		public String getColumnName(int column) {

			return null;
		}

	}

	public static JTable getJTable(int row, int column) {
		DemoTableModel model = new DemoTableModel(row, column);
		JTable jtable = new JTable(model);
		return jtable;
	}

	public static void main(String args[]) {
		String[] str = new String[16];
		for (int i = 1; i < 13; i++) {
			str[i - 1] = "08" + (i < 10 ? ("0" + i) : "" + i);
		}
		str[12] = "0901";
		str[13] = "0902";
		str[14] = "0903";
		str[15] = "0904";
		// 折点值
		float[] value = new float[16];
		for (int i = 0; i < value.length; i++) {
			value[i] = i + 2;
		}

		DefaultCategoryDataset dgd = new DefaultCategoryDataset();
		for (int i = 0; i < value.length; i++) {
			dgd.addValue(value[i], "2007年", str[i]);
		}
		
		JFreeChart jfc = ChartFactory.createLineChart("标题", "", "二", dgd,
				PlotOrientation.VERTICAL, true, true, false);
		// 取得统计图表的第一个图例
		LegendTitle legend = jfc.getLegend(0);
		legend.setVisible(false);
		// 按曲线图创建chartPanel
		ChartPanel chartPanel = new ChartPanel(jfc);

		JPanel content = new JPanel(new BorderLayout());
		content.add(chartPanel, BorderLayout.CENTER);
		// JLayeredPane jlp=new JLayeredPane();
		// jlp.add(chartPanel,new Integer(100));

		// 创建table
		final MyCellRenderer2 mcr = new MyCellRenderer2();
		JTable jtable = new JTable(new DemoTableModel(3, value.length + 1)) {
			public TableCellRenderer getCellRenderer(int row, int column) {
				return mcr;
			}
		};

		// JTable jtable = getJTable(3, value.length + 1);
		JPanel tablePanel = new JPanel(new BorderLayout());
		tablePanel.setPreferredSize(new Dimension(800, 52));
		tablePanel.add(new JScrollPane(jtable));
		// jtable.setForeground(Color.RED);
		// jtable.setSelectionForeground(Color.RED);
		jtable.setValueAt("黄色标题", 0, 0);
		jtable.setValueAt("蓝色标题", 1, 0);
		jtable.setValueAt("红色标题", 2, 0);
		content.add(tablePanel, BorderLayout.SOUTH);

		JFrame jf = new JFrame();
		jf.add(content);
		// jf.add(jlp);
		jf.pack();
		jf.setVisible(true);
	}
}

class MyCellRenderer2 extends DefaultTableCellRenderer {
	private static final long serialVersionUID = 1L;

	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {

		Component cell = super.getTableCellRendererComponent(table, value,
				isSelected, hasFocus, row, column);
		// 指定行的颜色
		if (row == 0)
			cell.setForeground(Color.YELLOW);
		if (row == 2)
			cell.setForeground(Color.BLUE);
		if (row == 1)
			cell.setForeground(Color.RED);
		return cell;
	}
}