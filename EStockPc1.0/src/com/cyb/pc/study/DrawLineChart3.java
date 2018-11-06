package com.cyb.pc.study;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;

import org.jfree.chart.ChartPanel;

import org.jfree.chart.JFreeChart;

import org.jfree.chart.axis.NumberAxis;

import org.jfree.chart.plot.CategoryPlot;

import org.jfree.chart.plot.PlotOrientation;

import org.jfree.data.category.DefaultCategoryDataset;

import org.jfree.ui.ApplicationFrame;

import org.jfree.ui.RefineryUtilities;

public class DrawLineChart3 extends ApplicationFrame {

	private static final long serialVersionUID = 1L;

	public DrawLineChart3(String s) {

		super(s);

		setContentPane(createDemoLine());

	}

	public static void main(String[] args) {

		DrawLineChart3 fjc = new DrawLineChart3("zhe xian tu");

		fjc.pack();

		RefineryUtilities.centerFrameOnScreen(fjc);

		fjc.setVisible(true);

	}

	// ������ʾͼ������

	public static JPanel createDemoLine() {

		JFreeChart jfreechart = createChart(createDataset());

		return new ChartPanel(jfreechart);

	}

	// ����ͼ��������JFreeChart

	public static JFreeChart createChart(DefaultCategoryDataset linedataset) {

		// ����ͼ�����

		JFreeChart chart = ChartFactory.createLineChart("season one", // ����ͼ����

				"time", // ����������

				"money(million)", // ����������

				linedataset, // ����

				PlotOrientation.VERTICAL, // ˮƽ��ʾͼ��

				true, // include legend

				true, // tooltips

				false // urls

				);

		CategoryPlot plot = chart.getCategoryPlot();

		plot.setRangeGridlinesVisible(true); // �Ƿ���ʾ������

		plot.setBackgroundAlpha(0.3f); // ���ñ���͸����

		NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();

		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

		rangeAxis.setAutoRangeIncludesZero(true);

		rangeAxis.setUpperMargin(0.20);

		rangeAxis.setLabelAngle(Math.PI / 2.0);

		return chart;

	}

	// ��������

	public static DefaultCategoryDataset createDataset() {

		DefaultCategoryDataset linedataset = new DefaultCategoryDataset();

		// ����������

		String series1 = "bridge";

		String series2 = "tv";

		String series3 = "washer";

		// ��������(������)

		String type1 = "1month";

		String type2 = "2month";

		String type3 = "3month";

		linedataset.addValue(0.0, series1, type1);

		linedataset.addValue(4.2, series1, type2);

		linedataset.addValue(3.9, series1, type3);

		linedataset.addValue(1.0, series2, type1);

		linedataset.addValue(5.2, series2, type2);

		linedataset.addValue(7.9, series2, type3);

		linedataset.addValue(2.0, series3, type1);

		linedataset.addValue(9.2, series3, type2);

		linedataset.addValue(8.9, series3, type3);

		return linedataset;

	}

}