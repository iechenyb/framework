package com.cyb.pc.study;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.IntervalMarker;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.Layer;
import org.jfree.ui.LengthAdjustmentType;
import org.jfree.ui.TextAnchor;

public class DrawLineChart {

	public DrawLineChart() {
		this.createChart();
	}

	// ������ݼ� �������������Ϊ�˲��������д��һ���Զ��������ݵ����ӣ�
	public DefaultCategoryDataset createDataset() {

		DefaultCategoryDataset linedataset = new DefaultCategoryDataset();
		// ��������
		String series = "the value of xue tang value"; // seriesָ�ľ��Ǳ����������������
		// ��� �������ߵ�������þ���Ҫ��ϵ��serise
		// ����˵setSeriesPaint ���������ߵ���ɫ

		// ��������(������)
		String[] time = new String[15];
		String[] timeValue = { "6-1", "6-2", "6-3", "6-4", "6-5", "6-6",
				"6-7", "6-8", "6-9", "6-10", "6-11", "6-12", "6-13",
				"6-14", "6-15" };
		for (int i = 0; i < 15; i++) {
			time[i] = timeValue[i];
		}
		// ����������ֵ
		for (int i = 0; i < 15; i++) {
			java.util.Random r = new java.util.Random();
			linedataset.addValue(i + i * 9.34 + r.nextLong() % 100, // ֵ
					series, // ����������
					time[i]); // ��Ӧ�ĺ���
		}

		return linedataset;
	}

	// ����ͼ�����JFreeChart
	/*
	 * ������Ŀ������JFreeChart������������� Plot �䳣�������У�CategoryPlot, MultiplePiePlot,
	 * PiePlot , XYPlot
	 * 
	 * **
	 */
	public JFreeChart createChart() {
		JFreeChart chart = null;
		try {
			// ����ͼ�����
			 chart = ChartFactory.createLineChart("Qutoes data 600868",// ������Ŀ���ַ�������
					"time", // ����
					"value", // ����
					this.createDataset(), // ������ݼ�
					PlotOrientation.VERTICAL, // ͼ�귽��ֱ
					true, // ��ʾͼ��
					false, // �������ɹ���
					false // ��������URL��ַ
					);
			// ������Ŀ������chart ��������chart�ı�����ɫ

			// ����ͼ��
			CategoryPlot plot = chart.getCategoryPlot();
			// ͼ�����Բ���
			plot.setBackgroundPaint(Color.white);
			plot.setDomainGridlinesVisible(true); // ���ñ����������Ƿ�ɼ�
			plot.setDomainGridlinePaint(Color.BLACK); // ���ñ�����������ɫ
			plot.setRangeGridlinePaint(Color.GRAY);
			plot.setNoDataMessage("no data");// û������ʱ��ʾ������˵����
			// ���������Բ���
			NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
			rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
			rangeAxis.setAutoRangeIncludesZero(true); // �Զ�����
			rangeAxis.setUpperMargin(0.20);
			rangeAxis.setLabelAngle(Math.PI / 2.0);
			rangeAxis.setAutoRange(false);
			// ������Ⱦ���� ��Ҫ�Ƕ�����������
			LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot
					.getRenderer();
			renderer.setBaseItemLabelsVisible(true);
			renderer.setSeriesPaint(0, Color.black); // �������ߵ���ɫ
			renderer.setBaseShapesFilled(true);
			renderer.setBaseItemLabelsVisible(true);
			renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(
					ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
			renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
			/*
			 * �����StandardCategoryItemLabelGenerator()����ǿ���£���ʱ�����*��������ͷ���Σ�Standard
			 * **ItemLabelGenerator��ͨ�õ� ��Ϊ�Ҵ���*����CategoryPlot ���Ժܶ����ö���Category���
			 * ��XYPlot ��Ӧ������ �� StandardXYItemLabelGenerator
			 */
			// ���ڱ����Ա ���ָ���һ�����ͷ������뵽�����������Ʒ�����˼
			// ���Ǳ����еİɣ�Ŀǰֻ�����������ˡ���
			renderer.setBaseItemLabelFont(new Font("Dialog", 1, 14)); // ������ʾ�۵�������״
			plot.setRenderer(renderer);
			// ������Ⱦ����
			double lowpress = 4.5;
			double uperpress = 8; // �趨����Ѫ��ֵ�ķ�Χ
			
			IntervalMarker inter = new IntervalMarker(lowpress, uperpress);
			inter.setLabelOffsetType(LengthAdjustmentType.EXPAND); // ��Χ������������
			inter.setPaint(Color.LIGHT_GRAY);// ���ɫ

			inter.setLabelFont(new Font("SansSerif", 41, 14));
			inter.setLabelPaint(Color.RED);
			inter.setLabel("normal"); // �趨����˵������
			plot.addRangeMarker(inter, Layer.BACKGROUND); // ���mark��ͼ��
															// BACKGROUNDʹ�����������������ǰ��

			// �����ļ������
			File fos_jpg = new File("d://bloodSugarChart.jpg");
			// ������ĸ������
			ChartUtilities.saveChartAsJPEG(fos_jpg, chart, // ͳ��ͼ�����
					700, // ��
					500 // ��
					);
			//new SetBackPic("d://bloodSugarChart.jpg");  
			return chart;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return chart;
	}

	// ������
	public static void main(String[] args) {
		DrawLineChart my = new DrawLineChart();
	}

}