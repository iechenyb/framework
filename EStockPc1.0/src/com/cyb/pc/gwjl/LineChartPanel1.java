package com.cyb.pc.gwjl;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.time.Minute;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.TextAnchor;

import com.cyb.pc.bean.Stock;
import com.cyb.utils.ConfigUtils;
import com.cyb.utils.DateUtil;
import com.cyb.utils.FontUtils;
import com.cyb.utils.UrlUtils;

public class LineChartPanel1 {
	public double max=0.0;
    public double min=0.0;
    public Stock stock;
    Font font = new Font("隶书", Font.BOLD, 16);
    public LineChartPanel1(Stock stock){
    	this.stock = stock;
    }
	public JFreeChart createChart() {
		TimeSeriesCollection lineDataset = getDataSet();
		//应用主题样式  
		ChartFactory.setChartTheme(FontUtils.getStandardChartTheme()); 
		JFreeChart chart = ChartFactory.createTimeSeriesChart("分钟行情线", "交易时间",
				"最新价格", lineDataset, false, true, false);
		   
		// =============显示各数据点及其数值start====================
		XYPlot plot = (XYPlot) chart.getPlot();
		/*CategoryPlot plot1 = (CategoryPlot) chart.getPlot();
		// 获取显示线条的对象
		LineAndShapeRenderer lasp = (LineAndShapeRenderer) plot1.getRenderer();
		// 设置拐点是否可见/是否显示拐点
		lasp.setBaseShapesVisible(true);
		// 设置拐点不同用不同的形状
		lasp.setDrawOutlines(true);
		// 设置线条是否被显示填充颜色
		lasp.setUseFillPaint(true);
		// 设置拐点颜色
		lasp.setBaseFillPaint(Color.blue);//蓝色
		// 设置折线加粗
		lasp.setSeriesStroke(0, new BasicStroke(3F));*/
		//set y 
		ValueAxis rangeAxis = plot.getRangeAxis();
		rangeAxis.setAxisLinePaint(Color.BLACK); // 设置轴线颜色
		rangeAxis.setUpperBound(max); // 设置坐标最大值
		rangeAxis.setLowerBound(min);
		rangeAxis.setAxisLineStroke(new BasicStroke(1.0f));     // 设置轴线粗细
		// DateAxis cAxis = (DateAxis) plot.getDomainAxis();
		// cAxis.setAutoTickUnitSelection(false);
		XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer) plot
				.getRenderer();
		/*xylineandshaperenderer.setToolTipGenerator(new StandardXYToolTipGenerator("{0}: ({1}, {2})",  
                new SimpleDateFormat("yy-MM-dd HH:mm:ss"), new DecimalFormat("#,##0")));  */
		// 设置日期显示格式
		//set x
		DateAxis dateaxiss = (DateAxis) plot.getDomainAxis();
		SimpleDateFormat frm = new SimpleDateFormat("HH:mm");
		dateaxiss.setDateFormatOverride(frm);
		// 设置网格背景颜色
		chart.setBackgroundPaint(Color.YELLOW);
		// 设置网格竖线颜色
		plot.setDomainGridlinePaint(Color.gray);
		// 设置网格横线颜色
		plot.setRangeGridlinePaint(Color.gray);
		// 设置曲线图与xy轴的距离
		plot.setAxisOffset(new RectangleInsets(0D, 0D, 0D, 10D));
		// plot.setAxisOffset(new RectangleInsets(0D, 0D, 20D, 1D));
		// 设置曲线是否显示数据点
		xylineandshaperenderer.setBaseShapesVisible(false);
		// 设置曲线显示各数据点的值
		XYItemRenderer xyitem = plot.getRenderer();
		xyitem.setBaseItemLabelsVisible(false);
		xyitem.setBasePositiveItemLabelPosition(new ItemLabelPosition(
				ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
		xyitem.setBaseItemLabelGenerator(new StandardXYItemLabelGenerator());
		xyitem.setBaseItemLabelFont(font);
		plot.setRenderer(xyitem);
		// =============显示各数据点及其数值end======================
		// 设置子标题
		/*TextTitle subtitle = new TextTitle("设备编号:" + equipment_id, new Font(
				"黑体", Font.BOLD, 12));
		chart.addSubtitle(subtitle);*/
		// 设置主标题
		chart.setTitle(new TextTitle(stock.getName()+"("+stock.getCode()+")",
				font));
		chart.setAntiAlias(false);
		return chart ;
	}

	private  TimeSeriesCollection getDataSet() {
		
	    
		DefaultPieDataset dataset = new DefaultPieDataset();
		// TimeSeries timeSeries2012 = new TimeSeries("2011年", Day.class);
		// 时间曲线数据集合
		TimeSeriesCollection lineDataset = new TimeSeriesCollection();
		TimeSeries timeSeries2011 = new TimeSeries("价格", Minute.class);
		// TimeSeries timeSeries2012 = new TimeSeries("二刀良品率", Day.class);
		// 构造数据集合
		lineDataset.addSeries(timeSeries2011);
        // 调用getClientLevelCount()得到所有的数据
		// / StateReportManger sta=new StateReportManger();
		String url =ConfigUtils.get("WebPath")+ConfigUtils.get("LINEJSON")+"?code="+stock.getCode_();
		String html = UrlUtils.downJsonStrFromHttpUrl(url);
		JSONObject data = JSONArray.fromObject(html).getJSONObject(0);
		max = Double.valueOf(data.get("max").toString())+0.1;
		min = Double.valueOf(data.get("min").toString())-0.1;
		String time = data.get("time").toString();
		String y = data.get("y").toString().replace("\"", "");
		String x = data.get("x").toString().replace("\"", "");
		String[] timeArr = x.substring(1, x.length()-1).split(",");
		String[] valArr = y.substring(1, y.length()-1).split(",");
		int len = valArr.length;
		if(timeArr.length<=valArr.length){
			len = timeArr.length;
		}
		System.out.println(JSONArray.fromObject(timeArr).toString());
		System.out.println(JSONArray.fromObject(valArr).toString());
		String day = time.substring(0,4)+time.substring(5,7)+time.substring(8,10);
		for (int i=0;i<len;i++) {// 遍历，用到Map的.
			String minute = timeArr[i].replace(":", "")+"00";
			Date curMinute = (Date) DateUtil.Calendar(day+minute).getTime();
			if(!"-".equals(valArr[i])){
				timeSeries2011.add(new Minute(curMinute),Double.parseDouble(valArr[i]));
			}/*else{
				timeSeries2011.add(new Minute(curMinute),0.0);
			}*/
			// dataset.setValue((String)entry.getKey(),
			// Double.parseDouble(String.valueOf(entry.getValue())));//设置数据
		}
		return lineDataset;

	}

}