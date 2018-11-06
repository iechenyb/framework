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
    Font font = new Font("����", Font.BOLD, 16);
    public LineChartPanel1(Stock stock){
    	this.stock = stock;
    }
	public JFreeChart createChart() {
		TimeSeriesCollection lineDataset = getDataSet();
		//Ӧ��������ʽ  
		ChartFactory.setChartTheme(FontUtils.getStandardChartTheme()); 
		JFreeChart chart = ChartFactory.createTimeSeriesChart("����������", "����ʱ��",
				"���¼۸�", lineDataset, false, true, false);
		   
		// =============��ʾ�����ݵ㼰����ֵstart====================
		XYPlot plot = (XYPlot) chart.getPlot();
		/*CategoryPlot plot1 = (CategoryPlot) chart.getPlot();
		// ��ȡ��ʾ�����Ķ���
		LineAndShapeRenderer lasp = (LineAndShapeRenderer) plot1.getRenderer();
		// ���ùյ��Ƿ�ɼ�/�Ƿ���ʾ�յ�
		lasp.setBaseShapesVisible(true);
		// ���ùյ㲻ͬ�ò�ͬ����״
		lasp.setDrawOutlines(true);
		// ���������Ƿ���ʾ�����ɫ
		lasp.setUseFillPaint(true);
		// ���ùյ���ɫ
		lasp.setBaseFillPaint(Color.blue);//��ɫ
		// �������߼Ӵ�
		lasp.setSeriesStroke(0, new BasicStroke(3F));*/
		//set y 
		ValueAxis rangeAxis = plot.getRangeAxis();
		rangeAxis.setAxisLinePaint(Color.BLACK); // ����������ɫ
		rangeAxis.setUpperBound(max); // �����������ֵ
		rangeAxis.setLowerBound(min);
		rangeAxis.setAxisLineStroke(new BasicStroke(1.0f));     // �������ߴ�ϸ
		// DateAxis cAxis = (DateAxis) plot.getDomainAxis();
		// cAxis.setAutoTickUnitSelection(false);
		XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer) plot
				.getRenderer();
		/*xylineandshaperenderer.setToolTipGenerator(new StandardXYToolTipGenerator("{0}: ({1}, {2})",  
                new SimpleDateFormat("yy-MM-dd HH:mm:ss"), new DecimalFormat("#,##0")));  */
		// ����������ʾ��ʽ
		//set x
		DateAxis dateaxiss = (DateAxis) plot.getDomainAxis();
		SimpleDateFormat frm = new SimpleDateFormat("HH:mm");
		dateaxiss.setDateFormatOverride(frm);
		// �������񱳾���ɫ
		chart.setBackgroundPaint(Color.YELLOW);
		// ��������������ɫ
		plot.setDomainGridlinePaint(Color.gray);
		// �������������ɫ
		plot.setRangeGridlinePaint(Color.gray);
		// ��������ͼ��xy��ľ���
		plot.setAxisOffset(new RectangleInsets(0D, 0D, 0D, 10D));
		// plot.setAxisOffset(new RectangleInsets(0D, 0D, 20D, 1D));
		// ���������Ƿ���ʾ���ݵ�
		xylineandshaperenderer.setBaseShapesVisible(false);
		// ����������ʾ�����ݵ��ֵ
		XYItemRenderer xyitem = plot.getRenderer();
		xyitem.setBaseItemLabelsVisible(false);
		xyitem.setBasePositiveItemLabelPosition(new ItemLabelPosition(
				ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
		xyitem.setBaseItemLabelGenerator(new StandardXYItemLabelGenerator());
		xyitem.setBaseItemLabelFont(font);
		plot.setRenderer(xyitem);
		// =============��ʾ�����ݵ㼰����ֵend======================
		// �����ӱ���
		/*TextTitle subtitle = new TextTitle("�豸���:" + equipment_id, new Font(
				"����", Font.BOLD, 12));
		chart.addSubtitle(subtitle);*/
		// ����������
		chart.setTitle(new TextTitle(stock.getName()+"("+stock.getCode()+")",
				font));
		chart.setAntiAlias(false);
		return chart ;
	}

	private  TimeSeriesCollection getDataSet() {
		
	    
		DefaultPieDataset dataset = new DefaultPieDataset();
		// TimeSeries timeSeries2012 = new TimeSeries("2011��", Day.class);
		// ʱ���������ݼ���
		TimeSeriesCollection lineDataset = new TimeSeriesCollection();
		TimeSeries timeSeries2011 = new TimeSeries("�۸�", Minute.class);
		// TimeSeries timeSeries2012 = new TimeSeries("������Ʒ��", Day.class);
		// �������ݼ���
		lineDataset.addSeries(timeSeries2011);
        // ����getClientLevelCount()�õ����е�����
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
		for (int i=0;i<len;i++) {// �������õ�Map��.
			String minute = timeArr[i].replace(":", "")+"00";
			Date curMinute = (Date) DateUtil.Calendar(day+minute).getTime();
			if(!"-".equals(valArr[i])){
				timeSeries2011.add(new Minute(curMinute),Double.parseDouble(valArr[i]));
			}/*else{
				timeSeries2011.add(new Minute(curMinute),0.0);
			}*/
			// dataset.setValue((String)entry.getKey(),
			// Double.parseDouble(String.valueOf(entry.getValue())));//��������
		}
		return lineDataset;

	}

}