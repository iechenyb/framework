package com.cyb.pc.gwjl;

import java.awt.Color;
import java.awt.Font;
import java.awt.Paint;
import java.util.List;

import javax.swing.JPanel;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import com.cyb.utils.ConfigUtils;
import com.cyb.utils.UrlUtils;

public class ZdfxPieChartPanel {
	Font font = new Font("隶书", Font.BOLD, 16);
	 private static final Paint[] COLORS = { Color.RED, Color.YELLOW,  
         Color.GRAY, Color.MAGENTA, Color.ORANGE, Color.GREEN/*,  
         Color.DARK_GRAY, Color.CYAN, Color.PINK, Color.BLUE,  
         Color.LIGHT_GRAY*/ };  
	// 生成显示图表的面板
	public  JPanel createDemoPanel() {
		JFreeChart jfreechart = createChart();
		return new ChartPanel(jfreechart);
	}

	// 生成饼图数据集对象
	public  PieDataset createDataset() {
		DefaultPieDataset defaultpiedataset = new DefaultPieDataset();
		String url =ConfigUtils.get("WebPath")+ConfigUtils.get("DPFX");
		String html = UrlUtils.downJsonStrFromHttpUrl(url);
		if(!html.equals("[]")){
			JSONArray data = JSONArray.fromObject(html).getJSONObject(0).getJSONArray("lst");
			double total =0;
			for(int i=0;i<data.size();i++){
				JSONObject obj = data.getJSONObject(i);
				total = total+obj.getDouble("value");
			}
			for(int i=0;i<data.size();i++){
				JSONObject obj = data.getJSONObject(i);
				defaultpiedataset.setValue(obj.getString("name"), obj.getDouble("value")*100/total);
			}
		}
		/*defaultpiedataset.setValue("TYPE1", 10.02D);
		defaultpiedataset.setValue("TYPE2", 20.23D);	
		defaultpiedataset.setValue("TYPE3", 60.02D);
		defaultpiedataset.setValue("TYPE4", 10.02D);
		defaultpiedataset.setValue("TYPE5", 5.11D);*/
		return defaultpiedataset;
	}
	

 public void setColor(PiePlot plot, CategoryDataset dataset) {  
     List keys = dataset.getRowKeys();  
     for (int i = 0; i < keys.size(); i++) {  
         plot.setSectionPaint(keys.get(i).toString(), COLORS[i  
                 % COLORS.length]);  
     }  
 }  
	// 生成图表主对象JFreeChart
	public  JFreeChart createChart() {
		// 定义图表对象
		JFreeChart jfreechart = ChartFactory.createPieChart("涨跌统计",
				createDataset(), true, true, false);
		// 获得图表显示对象
		PiePlot pieplot = (PiePlot) jfreechart.getPlot();
		// 设置图表标签字体
		pieplot.setLabelFont(font);
		pieplot.setNoDataMessage("No data available");
		pieplot.setCircular(true);
		pieplot.setLabelGap(0.01D);// 间距
		pieplot.setSectionPaint("平盘",new Color(128,128,136));        
		pieplot.setSectionPaint("下跌",new Color(51,150,51));
		pieplot.setSectionPaint("涨停",new Color(255,51,255));        
		pieplot.setSectionPaint("上涨",Color.red);
		pieplot.setSectionPaint("停牌",new Color(186,186,186));        
		pieplot.setSectionPaint("跌停",new Color(51,153,51));
		pieplot.setBackgroundPaint(Color.white);
		pieplot.setLabelFont(font); 
		jfreechart.setTitle(new TextTitle("涨跌统计", font));
		jfreechart.getLegend().setItemFont(font);
		/*pieplot.setLabelGenerator(new StandardPieItemLabelGenerator("{0}={1}({2})", 
                NumberFormat.getNumberInstance(), 
                new DecimalFormat("0.00%"))); */
		//setColor(pieplot,(CategoryDataset)createDataset());
		return jfreechart;
	}

	public static void main(String[] args) {
		//ZdfxPieChar//ts fjc = new ZdfxPieCharts("CityInfoPort");
	}

}