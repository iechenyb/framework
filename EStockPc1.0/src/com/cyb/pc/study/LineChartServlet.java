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

		JFreeChart chart = ChartFactory.createTimeSeriesChart("", "日期2011",
				"产品良品率", lineDataset, true, true, true);

		// =============显示各数据点及其数值start====================
		XYPlot plot = (XYPlot) chart.getPlot();
		ValueAxis rangeAxis = plot.getRangeAxis();
		rangeAxis.setAxisLineStroke(new BasicStroke(2.0f)); // 设置轴线粗细
		rangeAxis.setAxisLinePaint(Color.BLACK); // 设置轴线颜色
		rangeAxis.setUpperBound(100f); // 设置坐标最大值
		rangeAxis.setLowerBound(50f);

		// DateAxis cAxis = (DateAxis) plot.getDomainAxis();
		// cAxis.setAutoTickUnitSelection(false);

		XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer) plot
				.getRenderer();

		// 设置日期显示格式
		DateAxis dateaxiss = (DateAxis) plot.getDomainAxis();
		SimpleDateFormat frm = new SimpleDateFormat("MM月dd日");

		dateaxiss.setDateFormatOverride(frm);
		// 设置网格背景颜色

		plot.setBackgroundPaint(Color.white);

		// 设置网格竖线颜色

		plot.setDomainGridlinePaint(Color.pink);

		// 设置网格横线颜色

		plot.setRangeGridlinePaint(Color.pink);

		// 设置曲线图与xy轴的距离

		plot.setAxisOffset(new RectangleInsets(0D, 0D, 0D, 10D));
		// plot.setAxisOffset(new RectangleInsets(0D, 0D, 20D, 1D));

		// 设置曲线是否显示数据点

		xylineandshaperenderer.setBaseShapesVisible(true);

		// 设置曲线显示各数据点的值

		XYItemRenderer xyitem = plot.getRenderer();

		xyitem.setBaseItemLabelsVisible(true);

		xyitem.setBasePositiveItemLabelPosition(new ItemLabelPosition(
				ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));

		xyitem.setBaseItemLabelGenerator(new StandardXYItemLabelGenerator());

		xyitem.setBaseItemLabelFont(new Font("Dialog", 1, 10));

		plot.setRenderer(xyitem);

		// =============显示各数据点及其数值end======================

		// 设置子标题

		TextTitle subtitle = new TextTitle("设备编号:" + equipment_id, new Font(
				"黑体", Font.BOLD, 12));

		chart.addSubtitle(subtitle);

		// 设置主标题

		chart.setTitle(new TextTitle("设备良品率折线图",
				new Font("黑体", Font.ITALIC, 16)));

		chart.setAntiAlias(true);

		ChartUtilities.writeChartAsJPEG(res.getOutputStream(), 1.0f, chart,
				800, 400, null);

	}

	private TimeSeriesCollection getDataSet() {

		DefaultPieDataset dataset = new DefaultPieDataset();

		// TimeSeries timeSeries2012 = new TimeSeries("2011年", Day.class);

		// 时间曲线数据集合

		TimeSeriesCollection lineDataset = new TimeSeriesCollection();
		TimeSeries timeSeries2011 = new TimeSeries("良品率", Day.class);
		// TimeSeries timeSeries2012 = new TimeSeries("二刀良品率", Day.class);
		// 构造数据集合
		lineDataset.addSeries(timeSeries2011);

        // 调用getClientLevelCount()得到所有的数据
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
		for (Iterator iter = map.entrySet().iterator(); iter.hasNext();) {// 遍历，用到Map的.
			Map.Entry entry = (Map.Entry) iter.next();
			String s = (String) entry.getKey();
			int MM = Integer.parseInt(s.substring(5, 7));
			int dd = Integer.parseInt(s.substring(8, 10));
			int yyyy = Integer.parseInt(s.substring(0, 4));
			timeSeries2011.add(new Day(dd, MM, yyyy),
					Double.parseDouble(String.valueOf(entry.getValue())));

			// dataset.setValue((String)entry.getKey(),
			// Double.parseDouble(String.valueOf(entry.getValue())));//设置数据

		}

		return lineDataset;

	}

}