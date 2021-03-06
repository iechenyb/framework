package com.cyb.pc.gwjl;

import java.awt.Color;//颜色系统
import java.text.SimpleDateFormat;//时间格式
import java.util.HashMap;
import java.util.Map;
import java.awt.Paint;//画笔系统
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
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");// 设置日期格式
		double highValue = Double.MIN_VALUE;// 设置K线数据当中的最大值
		double minValue = Double.MAX_VALUE;// 设置K线数据当中的最小值
		double high2Value = Double.MIN_VALUE;// 设置成交量的最大值
		double min2Value = Double.MAX_VALUE;// 设置成交量的最低值
		OHLCSeries series = new OHLCSeries("");
		// 高开低收数据序列，股票K线图的四个数据，依次是开，高，低，收
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
		// 保留K线数据的数据集，必须申明为final，后面要在匿名内部类里面用到
		final OHLCSeriesCollection seriesCollection = new OHLCSeriesCollection();
		// 保留成交量数据的集合
		TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();
		int len = ks.size();
		System.out.println(date);
		TimeSeries series2 = new TimeSeries("");// 对应时间成交量数据
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
		// 获取K线数据的最高值和最低值
		int seriesCount = seriesCollection.getSeriesCount();// 一共有多少个序列，目前为一个
		for (int i = 0; i < seriesCount; i++) {
			int itemCount = seriesCollection.getItemCount(i);// 每一个序列有多少个数据项
			for (int j = 0; j < itemCount; j++) {
				if (highValue < seriesCollection.getHighValue(i, j)) {// 取第i个序列中的第j个数据项的最大值
					highValue = seriesCollection.getHighValue(i, j);
				}
				if (minValue > seriesCollection.getLowValue(i, j)) {// 取第i个序列中的第j个数据项的最小值
					minValue = seriesCollection.getLowValue(i, j);
				}
			}
		}
		// 获取最高值和最低值
		int seriesCount2 = timeSeriesCollection.getSeriesCount();// 一共有多少个序列，目前为一个
		for (int i = 0; i < seriesCount2; i++) {
			int itemCount = timeSeriesCollection.getItemCount(i);// 每一个序列有多少个数据项
			for (int j = 0; j < itemCount; j++) {
				if (high2Value < timeSeriesCollection.getYValue(i, j)) {// 取第i个序列中的第j个数据项的值
					high2Value = timeSeriesCollection.getYValue(i, j);
				}
				if (min2Value > timeSeriesCollection.getYValue(i, j)) {// 取第i个序列中的第j个数据项的值
					min2Value = timeSeriesCollection.getYValue(i, j);
				}
			}
		}
		final CandlestickRenderer candlestickRender = new CandlestickRenderer();// 设置K线图的画图器，必须申明为final，后面要在匿名内部类里面用到
		candlestickRender.setUseOutlinePaint(true); // 设置是否使用自定义的边框线，程序自带的边框线的颜色不符合中国股票市场的习惯
		candlestickRender
				.setAutoWidthMethod(CandlestickRenderer.WIDTHMETHOD_AVERAGE);// 设置如何对K线图的宽度进行设定
		candlestickRender.setAutoWidthGap(0.001);// 设置各个K线图之间的间隔
		candlestickRender.setUpPaint(Color.RED);// 设置股票上涨的K线图颜色
		candlestickRender.setDownPaint(Color.GREEN);// 设置股票下跌的K线图颜色
		DateAxis x1Axis = new DateAxis();// 设置x轴，也就是时间轴
		x1Axis.setAutoRange(false);// 设置不采用自动设置时间范围
		try {
			x1Axis.setRange(dateFormat.parse(minDate + ""),
					dateFormat.parse(maxDate + ""));// 设置时间范围，注意时间的最大值要比已有的时间最大值要多一天
		} catch (Exception e) {
			e.printStackTrace();
		}
		x1Axis.setTimeline(SegmentedTimeline.newMondayThroughFridayTimeline());// 设置时间线显示的规则，用这个方法就摒除掉了周六和周日这些没有交易的日期(很多人都不知道有此方法)，使图形看上去连续
		x1Axis.setAutoTickUnitSelection(false);// 设置不采用自动选择刻度值
		x1Axis.setTickMarkPosition(DateTickMarkPosition.MIDDLE);// 设置标记的位置
		x1Axis.setStandardTickUnits(DateAxis.createStandardDateTickUnits());// 设置标准的时间刻度单位
		x1Axis.setTickUnit(new DateTickUnit(DateTickUnit.DAY, 7));// 设置时间刻度的间隔，一般以周为单位
		x1Axis.setDateFormatOverride(new SimpleDateFormat("yyyyMMdd"));// 设置显示时间的格式
		NumberAxis y1Axis = new NumberAxis();// 设定y轴，就是数字轴
		y1Axis.setAutoRange(false);// 不不使用自动设定范围
		y1Axis.setRange(minValue * 0.9, highValue * 1.1);// 设定y轴值的范围，比最低值要低一些，比最大值要大一些，这样图形看起来会美观些
		y1Axis.setTickUnit(new NumberTickUnit(
				(highValue * 1.1 - minValue * 0.9) / 10));// 设置刻度显示的密度
		XYPlot plot1 = new XYPlot(seriesCollection, x1Axis, y1Axis,
				candlestickRender);// 设置画图区域对象
		plot1.setDomainCrosshairVisible(true);
		plot1.setRangeCrosshairVisible(true);
		plot1.setBackgroundPaint(Color.white);
		plot1.setDomainGridlinePaint(Color.gray);
		plot1.setRangeGridlinePaint(Color.gray);
		plot1.setAxisOffset(new RectangleInsets(5D, 5D, 5D, 5D));
		XYBarRenderer xyBarRender = new XYBarRenderer() {
			private static final long serialVersionUID = 1L;// 为了避免出现警告消息，特设定此值

			public Paint getItemPaint(int i, int j) {// 匿名内部类用来处理当日的成交量柱形图的颜色与K线图的颜色保持一致
				if (seriesCollection.getCloseValue(i, j) > seriesCollection
						.getOpenValue(i, j)) {// 收盘价高于开盘价，股票上涨，选用股票上涨的颜色
					return candlestickRender.getUpPaint();
				} else {
					return candlestickRender.getDownPaint();
				}
			}
		};
		xyBarRender.setMargin(0.1);// 设置柱形图之间的间隔
		NumberAxis y2Axis = new NumberAxis();// 设置Y轴，为数值,后面的设置，参考上面的y轴设置
		y2Axis.setAutoRange(false);
		y2Axis.setRange(min2Value * 0.9, high2Value * 1.1);
		y2Axis.setTickUnit(new NumberTickUnit(
				(high2Value * 1.1 - min2Value * 0.9) / 4));
		XYPlot plot2 = new XYPlot(timeSeriesCollection, null, y2Axis,
				xyBarRender);// 建立第二个画图区域对象，主要此时的x轴设为了null值，因为要与第一个画图区域对象共享x轴
		CombinedDomainXYPlot combineddomainxyplot = new CombinedDomainXYPlot(
				x1Axis);// 建立一个恰当的联合图形区域对象，以x轴为共享轴
		combineddomainxyplot.add(plot1, 2);// 添加图形区域对象，后面的数字是计算这个区域对象应该占据多大的区域2/3
		combineddomainxyplot.add(plot2, 1);// 添加图形区域对象，后面的数字是计算这个区域对象应该占据多大的区域1/3
		combineddomainxyplot.setGap(10);// 设置两个图形区域对象之间的间隔空间
		JFreeChart chart = new JFreeChart(stock.getName()+"("+stock.getCode()+")",
				JFreeChart.DEFAULT_TITLE_FONT, combineddomainxyplot, false);
		ChartFrame frame = new ChartFrame("sssss", chart);
		chart.setBackgroundPaint(Color.white);
		// frame.pack();
		// frame.setVisible(true);
		File fos_jpg = new File("d://bloodSugarChart3.jpg");
		try {
			ChartUtilities.saveChartAsJPEG(fos_jpg, chart, // 统计图表对象
					800, // 宽
					500 // 高
					);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return chart;
	}
}