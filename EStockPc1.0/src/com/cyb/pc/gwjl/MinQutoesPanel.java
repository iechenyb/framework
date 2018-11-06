package com.cyb.pc.gwjl;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import com.cyb.pc.Contants;
import com.cyb.pc.bean.Stock;
import com.cyb.pc.study.SetBackPic;
import com.cyb.utils.ConfigUtils;
import com.cyb.utils.UrlUtils;

public class MinQutoesPanel {
	public Font font = new Font("SansSerif", 41, 24);
    public double max=0.0;
    public double min=0.0;
    public Stock stock;
    public MinQutoesPanel(Stock stock){
    	this.stock = stock;
    }
	// 获得数据集 （这里的数据是为了测试我随便写的一个自动生成数据的例子）
	public DefaultCategoryDataset createDataset() {

		DefaultCategoryDataset linedataset = new DefaultCategoryDataset();
		// 曲线名称
		String series = "价格分钟曲线"; // series指的就是报表里的那条数据线
		// 因此 对数据线的相关设置就需要联系到serise
		// 比如说setSeriesPaint 设置数据线的颜色
		String url =ConfigUtils.get("WebPath")+ConfigUtils.get("LINEJSON")+"?code="+stock.getCode_();
		
		String html = UrlUtils.downJsonStrFromHttpUrl(url);
		JSONObject data = JSONArray.fromObject(html).getJSONObject(0);
		max = Double.valueOf(data.get("realmax").toString());
		min = Double.valueOf(data.get("realmin").toString());
		String y = data.get("y").toString().replace("\"", "");
		String x = data.get("x").toString().replace("\"", "");
		String[] timeArr = x.substring(1, x.length()-1).split(",");
		String[] valArr = y.substring(1, y.length()-1).split(",");
		int len = valArr.length;
		if(timeArr.length<=valArr.length){
			len = timeArr.length;
		}
		for(int i=0;i<len;i++){
			if(!"-".equals(valArr[i])){
				linedataset.addValue(Double.valueOf(valArr[i]), // 值
				series, // 哪条数据线
				timeArr[i]); // 对应的横轴
			}
		}
		System.out.println("x="+timeArr);
		System.out.println("y="+valArr);
		return linedataset;
	}

	public JFreeChart createChart() throws IOException {
		// 绘图数据集
		DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
		// 如果把createLineChart改为createLineChart3D就变为了3D效果的折线图
		JFreeChart chart = ChartFactory.createLineChart(stock.getName()+"("+stock.getCode()+")", "价格分钟曲线", "价格",
				this.createDataset(), PlotOrientation.VERTICAL, // 绘制方向
				true, // 显示图例
				true, // 采用标准生成器
				false // 是否生成超链接
				);
		chart.getTitle().setFont(font); // 设置标题字体
		chart.getLegend().setItemFont(font);// 设置图例类别字体
		chart.setBackgroundPaint(Color.white);// 设置背景色
		// 获取绘图区对象
		CategoryPlot plot = chart.getCategoryPlot();
		plot.setBackgroundPaint(Color.white); // 设置绘图区背景色
		plot.setRangeGridlinePaint(Color.gray); // 设置水平方向背景线颜色
		plot.setRangeGridlinesVisible(true);// 设置是否显示水平方向背景线,默认值为true
		plot.setDomainGridlinePaint(Color.white); // 设置垂直方向背景线颜色
		plot.setDomainGridlinesVisible(true); // 设置是否显示垂直方向背景线,默认值为false

		CategoryAxis domainAxis = plot.getDomainAxis();
		domainAxis.setLabelFont(font); // 设置横轴字体
		domainAxis.setTickLabelFont(font);// 设置坐标轴标尺值字体
		domainAxis.setLowerMargin(0.01);// 左边距 边框距离
		domainAxis.setUpperMargin(0.01);// 右边距 边框距离,防止最后边的一个数据靠近了坐标轴。
		domainAxis.setMaximumCategoryLabelLines(2);

		ValueAxis rangeAxis = plot.getRangeAxis();
		rangeAxis.setLabelFont(font);
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());// Y轴显示整数
		//rangeAxis.setAutoRangeMinimumSize(0); // 最小跨度
		//rangeAxis.setUpperMargin(0.18);// 上边距,防止最大的一个数据靠近了坐标轴。
		rangeAxis.setAutoRange(true); // 不自动分配Y轴数据
		rangeAxis.setTickMarkStroke(new BasicStroke(0.0f)); // 设置坐标标记大小
		rangeAxis.setTickMarkPaint(Color.BLACK); // 设置坐标标记颜色
		rangeAxis.setLowerBound(min);
		rangeAxis.setUpperBound(max);
		// 获取折线对象
		LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot
				.getRenderer();
		BasicStroke realLine = new BasicStroke(1.8f); // 设置实线
		// 设置虚线
		float dashes[] = { 5.0f };
		BasicStroke brokenLine = new BasicStroke(2.2f, // 线条粗细
				BasicStroke.CAP_ROUND, // 端点风格
				BasicStroke.JOIN_ROUND, // 折点风格
				1f, dashes, 0.6f);
		/*for (int i = 0; i < dataSet.getRowCount(); i++) {
			if (i % 2 == 0)
				renderer.setSeriesStroke(i, realLine); // 利用实线绘制
			else
				renderer.setSeriesStroke(i, brokenLine); // 利用虚线绘制
		}*/

		plot.setNoDataMessage("无对应的数据，请重新查询。");
		plot.setNoDataMessageFont(font);// 字体的大小
		plot.setNoDataMessagePaint(Color.RED);// 字体颜色
		// 创建文件输出流
		File fos_jpg = new File("d://bloodSugarChart1.jpg");
		// 输出到哪个输出流
		ChartUtilities.saveChartAsJPEG(fos_jpg, chart, // 统计图表对象
				700, // 宽
				500 // 高
				);
		//new SetBackPic("d://bloodSugarChart1.jpg");
		return chart;
	}

	public static void main(String[] args) {
		try {
			//new MinQutoesPanel();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
