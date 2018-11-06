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
	Font font = new Font("����", Font.BOLD, 16);
	 private static final Paint[] COLORS = { Color.RED, Color.YELLOW,  
         Color.GRAY, Color.MAGENTA, Color.ORANGE, Color.GREEN/*,  
         Color.DARK_GRAY, Color.CYAN, Color.PINK, Color.BLUE,  
         Color.LIGHT_GRAY*/ };  
	// ������ʾͼ������
	public  JPanel createDemoPanel() {
		JFreeChart jfreechart = createChart();
		return new ChartPanel(jfreechart);
	}

	// ���ɱ�ͼ���ݼ�����
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
	// ����ͼ��������JFreeChart
	public  JFreeChart createChart() {
		// ����ͼ�����
		JFreeChart jfreechart = ChartFactory.createPieChart("�ǵ�ͳ��",
				createDataset(), true, true, false);
		// ���ͼ����ʾ����
		PiePlot pieplot = (PiePlot) jfreechart.getPlot();
		// ����ͼ���ǩ����
		pieplot.setLabelFont(font);
		pieplot.setNoDataMessage("No data available");
		pieplot.setCircular(true);
		pieplot.setLabelGap(0.01D);// ���
		pieplot.setSectionPaint("ƽ��",new Color(128,128,136));        
		pieplot.setSectionPaint("�µ�",new Color(51,150,51));
		pieplot.setSectionPaint("��ͣ",new Color(255,51,255));        
		pieplot.setSectionPaint("����",Color.red);
		pieplot.setSectionPaint("ͣ��",new Color(186,186,186));        
		pieplot.setSectionPaint("��ͣ",new Color(51,153,51));
		pieplot.setBackgroundPaint(Color.white);
		pieplot.setLabelFont(font); 
		jfreechart.setTitle(new TextTitle("�ǵ�ͳ��", font));
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