package com.cyb.pc.gwjl;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RectangleInsets;

import com.cyb.pc.bean.Stock;
import com.cyb.utils.ConfigUtils;
import com.cyb.utils.UrlUtils;
 
public class LineChartPanel
{
	public double max=0.0;
    public double min=0.0;
    public Stock stock;
    Font font = new Font("隶书", Font.BOLD, 16);
    public LineChartPanel(Stock stock){
    	this.stock = stock;
    }

  public  XYDataset createDataset()
  {
    XYSeries localXYSeries1 = new XYSeries("First");
    String url =ConfigUtils.get("WebPath")+ConfigUtils.get("LINEJSON")+"?code="+stock.getCode_();
	String html = UrlUtils.downJsonStrFromHttpUrl(url);
	JSONObject data = JSONArray.fromObject(html).getJSONObject(0);
	max = Double.valueOf(data.get("max").toString());
	min = Double.valueOf(data.get("min").toString());
	String time = data.get("time").toString();
	String y = data.get("y").toString().replace("\"", "");
	String x = data.get("x").toString().replace("\"", "");
	String[] timeArr = x.substring(1, x.length()-1).split(",");
	String[] valArr = y.substring(1, y.length()-1).split(",");
	int len = valArr.length;
	if(timeArr.length<=valArr.length){
		len = timeArr.length;
	}
	System.out.println(timeArr);
	System.out.println(valArr);
	String day = time.substring(0,4)+time.substring(5,7)+time.substring(8,10);
	for (int i=0;i<len;i++) {// 遍历，用到Map的.
		Double minute = Double.valueOf(timeArr[i].replace(":", ""));
		//Date curMinute = (Date) DateUtil.Calendar(day+minute).getTime();
		if(!"-".equals(valArr[i])){
			 localXYSeries1.add(minute,Double.valueOf(valArr[i]));
		}
	}
    XYSeriesCollection localXYSeriesCollection = new XYSeriesCollection();
    localXYSeriesCollection.addSeries(localXYSeries1);

    return localXYSeriesCollection;
  }
 
  private  JFreeChart createChart()
  {
    JFreeChart localJFreeChart = 
    		ChartFactory.createXYLineChart("Line Chart Demo 2", 
    				"X", "Y", createDataset(),
    				PlotOrientation.VERTICAL, true, true, false);
    localJFreeChart.setBackgroundPaint(Color.white);
    XYPlot localXYPlot = (XYPlot)localJFreeChart.getPlot();
    localXYPlot.setBackgroundPaint(Color.lightGray);
    localXYPlot.setAxisOffset(new RectangleInsets(5.0D, 5.0D, 5.0D, 5.0D));
    localXYPlot.setDomainGridlinePaint(Color.white);
    localXYPlot.setRangeGridlinePaint(Color.white);
    XYLineAndShapeRenderer localXYLineAndShapeRenderer = (XYLineAndShapeRenderer)localXYPlot.getRenderer();
    localXYLineAndShapeRenderer.setBaseShapesVisible(true);
    localXYLineAndShapeRenderer.setBaseShapesFilled(true);
    NumberAxis localNumberAxis = (NumberAxis)localXYPlot.getRangeAxis();
    localNumberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
    return localJFreeChart;
  }
 
  public JPanel createDemoPanel()
  {
    JFreeChart localJFreeChart = createChart();
    return new ChartPanel(localJFreeChart);
  }
 
  public static void main(String[] paramArrayOfString)
  {
    /*LineChartPanel localLineChartDemo2 = new LineChartPanel("Line Chart Demo 2");
    localLineChartDemo2.pack();
    RefineryUtilities.centerFrameOnScreen(localLineChartDemo2);
    localLineChartDemo2.setVisible(true);*/
  }
}