package com.cyb.pc.gwjl;

import java.awt.Color;//��ɫϵͳ
import java.text.SimpleDateFormat;//ʱ���ʽ
import java.util.HashMap;
import java.util.Map;
import java.awt.Paint;//����ϵͳ
import java.io.File;
import java.io.IOException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.jfree.data.time.*;
import org.jfree.data.time.ohlc.OHLCSeries;
import org.jfree.data.time.ohlc.OHLCSeriesCollection;
import org.jfree.ui.RectangleInsets;
import org.jfree.chart.renderer.xy.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.*;

import com.cyb.pc.Contants;
import com.cyb.pc.bean.Stock;
import com.cyb.pc.study.SetBackPic;
import com.cyb.utils.ConfigUtils;
import com.cyb.utils.UrlUtils;

public class KLineCombinePanel {
	public long minDate;
	public long maxDate;
	public Stock stock;
	public KLineCombinePanel(Stock stock){
		this.stock = stock;
	}
	public static void main(String[] args) {
		//new KLineCombinePanel(stock).createChart();
	}

	public JFreeChart createChart() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");// �������ڸ�ʽ
		double highValue = Double.MIN_VALUE;// ����K�����ݵ��е����ֵ
		double minValue = Double.MAX_VALUE;// ����K�����ݵ��е���Сֵ
		double high2Value = Double.MIN_VALUE;// ���óɽ��������ֵ
		double min2Value = Double.MAX_VALUE;// ���óɽ��������ֵ
		OHLCSeries series = new OHLCSeries("");
		// �߿������������У���ƱK��ͼ���ĸ����ݣ������ǿ����ߣ��ͣ���
		String url =ConfigUtils.get("WebPath")+ConfigUtils.get("KJSON")+"?code="+stock.getCode_();
		String html = UrlUtils.downJsonStrFromHttpUrl(url);
		if(html==null||"".equals(html)){
			System.out.println("html = "+html);
			return  null;
		}
		JSONObject data = JSONArray.fromObject(html).getJSONObject(0);
		JSONArray ks = data.getJSONArray("ks");
		JSONArray date = data.getJSONArray("dates");// .toString().replace("\"",
		Map<String,String> timeMap = new HashMap<String,String>();											// "");
		// ����K�����ݵ����ݼ�����������Ϊfinal������Ҫ�������ڲ��������õ�
		final OHLCSeriesCollection seriesCollection = new OHLCSeriesCollection();
		// �����ɽ������ݵļ���
		TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();
		int len = ks.size();
		System.out.println(date);
		TimeSeries series2 = new TimeSeries("");// ��Ӧʱ��ɽ�������
		maxDate = minDate = Long.valueOf(date.get(0).toString()
				.replace("-", ""));
		for (int i = 0; i < len; i++) {
			JSONArray k = ks.getJSONArray(i);
			String time = date.get(i).toString().replace("-", "");
			if(timeMap.containsKey(time)){
				continue;
			}else{
				timeMap.put(time, time);
			}
			if (Long.valueOf(time) > maxDate) {
				maxDate = Long.valueOf(time);
			}
			if (Long.valueOf(time) < minDate) {
				minDate = Long.valueOf(time);
			}
			int year = Integer.valueOf(time.substring(0, 4));
			int month = Integer.valueOf(time.substring(4, 6));
			int day = Integer.valueOf(time.substring(6, 8));
			Day curDay = new Day(day, month, year);
			// open close low high from url
			series.add(curDay, k.getDouble(0), k.getDouble(3), k.getDouble(2),
					k.getDouble(1));
			series2.add(curDay, k.getDouble(0));
		}
		System.out.println(minDate + "->" + maxDate);
		seriesCollection.addSeries(series);
		timeSeriesCollection.addSeries(series2);
		// ��ȡK�����ݵ����ֵ�����ֵ
		int seriesCount = seriesCollection.getSeriesCount();// һ���ж��ٸ����У�ĿǰΪһ��
		for (int i = 0; i < seriesCount; i++) {
			int itemCount = seriesCollection.getItemCount(i);// ÿһ�������ж��ٸ�������
			for (int j = 0; j < itemCount; j++) {
				if (highValue < seriesCollection.getHighValue(i, j)) {// ȡ��i�������еĵ�j������������ֵ
					highValue = seriesCollection.getHighValue(i, j);
				}
				if (minValue > seriesCollection.getLowValue(i, j)) {// ȡ��i�������еĵ�j�����������Сֵ
					minValue = seriesCollection.getLowValue(i, j);
				}
			}
		}
		// ��ȡ���ֵ�����ֵ
		int seriesCount2 = timeSeriesCollection.getSeriesCount();// һ���ж��ٸ����У�ĿǰΪһ��
		for (int i = 0; i < seriesCount2; i++) {
			int itemCount = timeSeriesCollection.getItemCount(i);// ÿһ�������ж��ٸ�������
			for (int j = 0; j < itemCount; j++) {
				if (high2Value < timeSeriesCollection.getYValue(i, j)) {// ȡ��i�������еĵ�j���������ֵ
					high2Value = timeSeriesCollection.getYValue(i, j);
				}
				if (min2Value > timeSeriesCollection.getYValue(i, j)) {// ȡ��i�������еĵ�j���������ֵ
					min2Value = timeSeriesCollection.getYValue(i, j);
				}
			}
		}
		final CandlestickRenderer candlestickRender = new CandlestickRenderer();// ����K��ͼ�Ļ�ͼ������������Ϊfinal������Ҫ�������ڲ��������õ�
		candlestickRender.setUseOutlinePaint(true); // �����Ƿ�ʹ���Զ���ı߿��ߣ������Դ��ı߿��ߵ���ɫ�������й���Ʊ�г���ϰ��
		candlestickRender
				.setAutoWidthMethod(CandlestickRenderer.WIDTHMETHOD_AVERAGE);// ������ζ�K��ͼ�Ŀ�Ƚ����趨
		candlestickRender.setAutoWidthGap(0.001);// ���ø���K��ͼ֮��ļ��
		candlestickRender.setUpPaint(Color.RED);// ���ù�Ʊ���ǵ�K��ͼ��ɫ
		candlestickRender.setDownPaint(Color.GREEN);// ���ù�Ʊ�µ���K��ͼ��ɫ
		DateAxis x1Axis = new DateAxis();// ����x�ᣬҲ����ʱ����
		x1Axis.setAutoRange(false);// ���ò������Զ�����ʱ�䷶Χ
		try {
			x1Axis.setRange(dateFormat.parse(minDate + ""),
					dateFormat.parse(maxDate + ""));// ����ʱ�䷶Χ��ע��ʱ������ֵҪ�����е�ʱ�����ֵҪ��һ��
		} catch (Exception e) {
			e.printStackTrace();
		}
		x1Axis.setTimeline(SegmentedTimeline.newMondayThroughFridayTimeline());// ����ʱ������ʾ�Ĺ���������������������������������Щû�н��׵�����(�ܶ��˶���֪���д˷���)��ʹͼ�ο���ȥ����
		x1Axis.setAutoTickUnitSelection(false);// ���ò������Զ�ѡ��̶�ֵ
		x1Axis.setTickMarkPosition(DateTickMarkPosition.MIDDLE);// ���ñ�ǵ�λ��
		x1Axis.setStandardTickUnits(DateAxis.createStandardDateTickUnits());// ���ñ�׼��ʱ��̶ȵ�λ
		x1Axis.setTickUnit(new DateTickUnit(DateTickUnit.DAY, 7));// ����ʱ��̶ȵļ����һ������Ϊ��λ
		x1Axis.setDateFormatOverride(new SimpleDateFormat("yyyyMMdd"));// ������ʾʱ��ĸ�ʽ
		NumberAxis y1Axis = new NumberAxis();// �趨y�ᣬ����������
		y1Axis.setAutoRange(false);// ����ʹ���Զ��趨��Χ
		y1Axis.setRange(minValue * 0.9, highValue * 1.1);// �趨y��ֵ�ķ�Χ�������ֵҪ��һЩ�������ֵҪ��һЩ������ͼ�ο�����������Щ
		y1Axis.setTickUnit(new NumberTickUnit(
				(highValue * 1.1 - minValue * 0.9) / 10));// ���ÿ̶���ʾ���ܶ�
		XYPlot plot1 = new XYPlot(seriesCollection, x1Axis, y1Axis,
				candlestickRender);// ���û�ͼ�������
		plot1.setDomainCrosshairVisible(true);
		plot1.setRangeCrosshairVisible(true);
		plot1.setBackgroundPaint(Color.white);
		plot1.setDomainGridlinePaint(Color.gray);
		plot1.setRangeGridlinePaint(Color.gray);
		plot1.setAxisOffset(new RectangleInsets(5D, 5D, 5D, 5D));
		XYBarRenderer xyBarRender = new XYBarRenderer() {
			private static final long serialVersionUID = 1L;// Ϊ�˱�����־�����Ϣ�����趨��ֵ

			public Paint getItemPaint(int i, int j) {// �����ڲ������������յĳɽ�������ͼ����ɫ��K��ͼ����ɫ����һ��
				if (seriesCollection.getCloseValue(i, j) > seriesCollection
						.getOpenValue(i, j)) {// ���̼۸��ڿ��̼ۣ���Ʊ���ǣ�ѡ�ù�Ʊ���ǵ���ɫ
					return candlestickRender.getUpPaint();
				} else {
					return candlestickRender.getDownPaint();
				}
			}
		};
		xyBarRender.setMargin(0.1);// ��������ͼ֮��ļ��
		NumberAxis y2Axis = new NumberAxis();// ����Y�ᣬΪ��ֵ,��������ã��ο������y������
		y2Axis.setAutoRange(false);
		y2Axis.setRange(min2Value * 0.9, high2Value * 1.1);
		y2Axis.setTickUnit(new NumberTickUnit(
				(high2Value * 1.1 - min2Value * 0.9) / 4));
		XYPlot plot2 = new XYPlot(timeSeriesCollection, null, y2Axis,
				xyBarRender);// �����ڶ�����ͼ���������Ҫ��ʱ��x����Ϊ��nullֵ����ΪҪ���һ����ͼ���������x��
		CombinedDomainXYPlot combineddomainxyplot = new CombinedDomainXYPlot(
				x1Axis);// ����һ��ǡ��������ͼ�����������x��Ϊ������
		combineddomainxyplot.add(plot1, 2);// ���ͼ��������󣬺���������Ǽ�������������Ӧ��ռ�ݶ�������2/3
		combineddomainxyplot.add(plot2, 1);// ���ͼ��������󣬺���������Ǽ�������������Ӧ��ռ�ݶ�������1/3
		combineddomainxyplot.setGap(10);// ��������ͼ���������֮��ļ���ռ�
		JFreeChart chart = new JFreeChart(stock.getName()+"("+stock.getCode()+")",
				JFreeChart.DEFAULT_TITLE_FONT, combineddomainxyplot, false);
		ChartFrame frame = new ChartFrame("sssss", chart);
		chart.setBackgroundPaint(Color.white);
		// frame.pack();
		// frame.setVisible(true);
		File fos_jpg = new File("d://bloodSugarChart3.jpg");
		try {
			ChartUtilities.saveChartAsJPEG(fos_jpg, chart, // ͳ��ͼ�����
					800, // ��
					500 // ��
					);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return chart;
	}
}