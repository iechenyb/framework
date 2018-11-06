package com.cyb.pc.study;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;

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

public class DrawLineChart2 {
	public Font font  =new Font("SansSerif", 41, 14);
	// ������ݼ� �������������Ϊ�˲��������д��һ���Զ��������ݵ����ӣ�
		public DefaultCategoryDataset createDataset() {

			DefaultCategoryDataset linedataset = new DefaultCategoryDataset();
			// ��������
			String series = "the value of xue tang value"; // seriesָ�ľ��Ǳ����������������
			// ��� �������ߵ�������þ���Ҫ��ϵ��serise
			// ����˵setSeriesPaint ���������ߵ���ɫ

			// ��������(������)
			String[] time = new String[15];
			String[] timeValue = { "6-1", "6-2", "6-3", "6-4", "6-5", "6-6",
					"6-7", "6-8", "6-9", "6-10", "6-11", "6-12", "6-13",
					"6-14", "6-15" };
			for (int i = 0; i < 15; i++) {
				time[i] = timeValue[i];
			}
			// ����������ֵ
			for (int i = 0; i < 15; i++) {
				java.util.Random r = new java.util.Random();
				double val = i + i * 9.34 + r.nextLong() % 100;
				if(val<0){val = i+9.0*i/4;}
				linedataset.addValue(val, // ֵ
						series, // ����������
						time[i]); // ��Ӧ�ĺ���
			}
			// ����������ֵ
			for (int i = 0; i < 15; i++) {
				java.util.Random r = new java.util.Random();
				double val = i + i * 2.34 + r.nextLong() % 100;
				if(val<0){val = i+9.0*i/4;}
				linedataset.addValue(val, // ֵ
						series, // ����������
						time[i]); // ��Ӧ�ĺ���
			}
			return linedataset;
		}
  public DrawLineChart2 () throws IOException{
      // ��ͼ���ݼ�  
      DefaultCategoryDataset dataSet = new DefaultCategoryDataset();  
      //�����createLineChart��ΪcreateLineChart3D�ͱ�Ϊ��3DЧ��������ͼ       
      JFreeChart  chart = ChartFactory.createLineChart("ͼ�����", 
    		  "X�����", "Y�����", this.createDataset(),  
              PlotOrientation.VERTICAL, // ���Ʒ���  
              true, // ��ʾͼ��  
              true, // ���ñ�׼������  
              false // �Ƿ����ɳ�����  
              );  
      chart.getTitle().setFont(font); // ���ñ�������  
      chart.getLegend().setItemFont(font);// ����ͼ���������  
      chart.setBackgroundPaint(Color.white);// ���ñ���ɫ   
      //��ȡ��ͼ������  
      CategoryPlot plot = chart.getCategoryPlot();  
      plot.setBackgroundPaint(Color.LIGHT_GRAY); // ���û�ͼ������ɫ  
      plot.setRangeGridlinePaint(Color.WHITE); // ����ˮƽ���򱳾�����ɫ  
      plot.setRangeGridlinesVisible(true);// �����Ƿ���ʾˮƽ���򱳾���,Ĭ��ֵΪtrue  
      plot.setDomainGridlinePaint(Color.WHITE); // ���ô�ֱ���򱳾�����ɫ  
      plot.setDomainGridlinesVisible(true); // �����Ƿ���ʾ��ֱ���򱳾���,Ĭ��ֵΪfalse  
        
        
      CategoryAxis domainAxis = plot.getDomainAxis();     
      domainAxis.setLabelFont(font); // ���ú�������  
      domainAxis.setTickLabelFont(font);// ������������ֵ����  
      domainAxis.setLowerMargin(0.01);// ��߾� �߿����  
      domainAxis.setUpperMargin(0.06);// �ұ߾� �߿����,��ֹ���ߵ�һ�����ݿ����������ᡣ  
      domainAxis.setMaximumCategoryLabelLines(2);  
        
      ValueAxis rangeAxis = plot.getRangeAxis();  
      rangeAxis.setLabelFont(font);   
      rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());//Y����ʾ����  
      rangeAxis.setAutoRangeMinimumSize(1);   //��С���  
      rangeAxis.setUpperMargin(0.18);//�ϱ߾�,��ֹ����һ�����ݿ����������ᡣ     
      rangeAxis.setLowerBound(0);   //��Сֵ��ʾ0  
      rangeAxis.setAutoRange(false);   //���Զ�����Y������  
      rangeAxis.setTickMarkStroke(new BasicStroke(1.6f));     // ���������Ǵ�С  
      rangeAxis.setTickMarkPaint(Color.BLACK);     // ������������ɫ  

        
        
   // ��ȡ���߶���  
      LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();  
      BasicStroke realLine = new BasicStroke(1.8f); // ����ʵ��  
      // ��������  
      float dashes[] = { 5.0f };   
      BasicStroke brokenLine = new BasicStroke(2.2f, // ������ϸ  
              BasicStroke.CAP_ROUND, // �˵���  
              BasicStroke.JOIN_ROUND, // �۵���  
              8f, dashes, 0.6f);   
      for (int i = 0; i < dataSet.getRowCount(); i++) {  
          if (i % 2 == 0)  
              renderer.setSeriesStroke(i, realLine); // ����ʵ�߻���  
          else  
              renderer.setSeriesStroke(i, brokenLine); // �������߻���  
      }  
        
      plot.setNoDataMessage("�޶�Ӧ�����ݣ������²�ѯ��");  
      plot.setNoDataMessageFont(font);//����Ĵ�С  
      plot.setNoDataMessagePaint(Color.RED);//������ɫ 
   // �����ļ������
	File fos_jpg = new File("d://bloodSugarChart1.jpg");
	// ������ĸ������
	ChartUtilities.saveChartAsJPEG(fos_jpg, chart, // ͳ��ͼ�����
			700, // ��
			500 // ��
			);
	new SetBackPic("d://bloodSugarChart1.jpg");  
      
  }
  public static void main(String[] args) {
	try {
		new DrawLineChart2();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
