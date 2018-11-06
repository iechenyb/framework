package com.cyb.pc.study;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieToolTipGenerator;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.TextAnchor;

public class LineChartServlet extends HttpServlet {

	String equipment_id = "";

	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		res.setContentType("image/jpeg");
		equipment_id = "xxxx";
		// System.out.print(equipment_id);
		TimeSeriesCollection lineDataset = getDataSet();

		JFreeChart chart = ChartFactory.createTimeSeriesChart("", "����2011",
				"��Ʒ��Ʒ��", lineDataset, true, true, true);

		// =============��ʾ�����ݵ㼰����ֵstart====================
		XYPlot plot = (XYPlot) chart.getPlot();
		ValueAxis rangeAxis = plot.getRangeAxis();
		rangeAxis.setAxisLineStroke(new BasicStroke(2.0f)); // �������ߴ�ϸ
		rangeAxis.setAxisLinePaint(Color.BLACK); // ����������ɫ
		rangeAxis.setUpperBound(100f); // �����������ֵ
		rangeAxis.setLowerBound(50f);

		// DateAxis cAxis = (DateAxis) plot.getDomainAxis();
		// cAxis.setAutoTickUnitSelection(false);

		XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer) plot
				.getRenderer();

		// ����������ʾ��ʽ
		DateAxis dateaxiss = (DateAxis) plot.getDomainAxis();
		SimpleDateFormat frm = new SimpleDateFormat("MM��dd��");

		dateaxiss.setDateFormatOverride(frm);
		// �������񱳾���ɫ

		plot.setBackgroundPaint(Color.white);

		// ��������������ɫ

		plot.setDomainGridlinePaint(Color.pink);

		// �������������ɫ

		plot.setRangeGridlinePaint(Color.pink);

		// ��������ͼ��xy��ľ���

		plot.setAxisOffset(new RectangleInsets(0D, 0D, 0D, 10D));
		// plot.setAxisOffset(new RectangleInsets(0D, 0D, 20D, 1D));

		// ���������Ƿ���ʾ���ݵ�

		xylineandshaperenderer.setBaseShapesVisible(true);

		// ����������ʾ�����ݵ��ֵ

		XYItemRenderer xyitem = plot.getRenderer();

		xyitem.setBaseItemLabelsVisible(true);

		xyitem.setBasePositiveItemLabelPosition(new ItemLabelPosition(
				ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));

		xyitem.setBaseItemLabelGenerator(new StandardXYItemLabelGenerator());

		xyitem.setBaseItemLabelFont(new Font("Dialog", 1, 10));

		plot.setRenderer(xyitem);

		// =============��ʾ�����ݵ㼰����ֵend======================

		// �����ӱ���

		TextTitle subtitle = new TextTitle("�豸���:" + equipment_id, new Font(
				"����", Font.BOLD, 12));

		chart.addSubtitle(subtitle);

		// ����������

		chart.setTitle(new TextTitle("�豸��Ʒ������ͼ",
				new Font("����", Font.ITALIC, 16)));

		chart.setAntiAlias(true);

		ChartUtilities.writeChartAsJPEG(res.getOutputStream(), 1.0f, chart,
				800, 400, null);

	}

	private TimeSeriesCollection getDataSet() {

		DefaultPieDataset dataset = new DefaultPieDataset();

		// TimeSeries timeSeries2012 = new TimeSeries("2011��", Day.class);

		// ʱ���������ݼ���

		TimeSeriesCollection lineDataset = new TimeSeriesCollection();
		TimeSeries timeSeries2011 = new TimeSeries("��Ʒ��", Day.class);
		// TimeSeries timeSeries2012 = new TimeSeries("������Ʒ��", Day.class);
		// �������ݼ���
		lineDataset.addSeries(timeSeries2011);

        // ����getClientLevelCount()�õ����е�����
		// / StateReportManger sta=new StateReportManger();
		 Map map=new HashMap<String,String>();
		map.put("2015-01-02", 23);
		map.put("2015-01-03", 23);
		map.put("2015-01-04", 23);
		map.put("2015-01-05", 23);
		map.put("2015-01-06", 23);
		map.put("2015-01-07", 23);
		map.put("2015-01-08", 23);
		map.put("2015-01-09", 23);
		map.put("2015-01-12", 23);
		map.put("2015-01-13", 23);
		map.put("2015-01-14", 23);
		map.put("2015-01-15", 23);
		for (Iterator iter = map.entrySet().iterator(); iter.hasNext();) {// �������õ�Map��.
			Map.Entry entry = (Map.Entry) iter.next();
			String s = (String) entry.getKey();
			int MM = Integer.parseInt(s.substring(5, 7));
			int dd = Integer.parseInt(s.substring(8, 10));
			int yyyy = Integer.parseInt(s.substring(0, 4));
			timeSeries2011.add(new Day(dd, MM, yyyy),
					Double.parseDouble(String.valueOf(entry.getValue())));

			// dataset.setValue((String)entry.getKey(),
			// Double.parseDouble(String.valueOf(entry.getValue())));//��������

		}

		return lineDataset;

	}

}