package com.cyb.pc.study;

import java.awt.Font;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
public class PieCharts  extends ApplicationFrame{
 public PieCharts(String s){
     super(s);
     setContentPane(createDemoPanel());
   }
 
 // 生成显示图表的面板
   public static JPanel createDemoPanel(){
     JFreeChart jfreechart = createChart(createDataset());
     return new ChartPanel(jfreechart);
   }
   
// 生成饼图数据集对象
   public static PieDataset createDataset(){
     DefaultPieDataset defaultpiedataset = new DefaultPieDataset();
     defaultpiedataset.setValue("TYPE1",10.02D);
     defaultpiedataset.setValue("TYPE2",20.23D);
     defaultpiedataset.setValue("TYPE3",60.02D);
     defaultpiedataset.setValue("TYPE4",10.02D);
     defaultpiedataset.setValue("TYPE5",5.11D);
     
     return defaultpiedataset;
   }
   
   //生成图表主对象JFreeChart
   public static JFreeChart createChart(PieDataset piedataset){
     //定义图表对象
     JFreeChart jfreechart = ChartFactory.createPieChart("CityInfoPort",piedataset,true,true,false);
     //获得图表显示对象
     PiePlot pieplot = (PiePlot)jfreechart.getPlot();
     //设置图表标签字体
     pieplot.setLabelFont(new Font("SansSerif",Font.BOLD,12));
     pieplot.setNoDataMessage("No data available");
     pieplot.setCircular(true);
     pieplot.setLabelGap(0.01D);//间距
     
     return jfreechart;
   }
   
   public static void main(String[] args){
      PieCharts fjc = new PieCharts("CityInfoPort");
      fjc.pack();
      RefineryUtilities.centerFrameOnScreen(fjc);
      fjc.setVisible(true);
    }
 
}