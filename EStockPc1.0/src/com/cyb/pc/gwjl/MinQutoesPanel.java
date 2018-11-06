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
	// ������ݼ� �������������Ϊ�˲��������д��һ���Զ��������ݵ����ӣ�
	public DefaultCategoryDataset createDataset() {

		DefaultCategoryDataset linedataset = new DefaultCategoryDataset();
		// ��������
		String series = "�۸��������"; // seriesָ�ľ��Ǳ����������������
		// ��� �������ߵ�������þ���Ҫ��ϵ��serise
		// ����˵setSeriesPaint ���������ߵ���ɫ
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
				linedataset.addValue(Double.valueOf(valArr[i]), // ֵ
				series, // ����������
				timeArr[i]); // ��Ӧ�ĺ���
			}
		}
		System.out.println("x="+timeArr);
		System.out.println("y="+valArr);
		return linedataset;
	}

	public JFreeChart createChart() throws IOException {
		// ��ͼ���ݼ�
		DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
		// �����createLineChart��ΪcreateLineChart3D�ͱ�Ϊ��3DЧ��������ͼ
		JFreeChart chart = ChartFactory.createLineChart(stock.getName()+"("+stock.getCode()+")", "�۸��������", "�۸�",
				this.createDataset(), PlotOrientation.VERTICAL, // ���Ʒ���
				true, // ��ʾͼ��
				true, // ���ñ�׼������
				false // �Ƿ����ɳ�����
				);
		chart.getTitle().setFont(font); // ���ñ�������
		chart.getLegend().setItemFont(font);// ����ͼ���������
		chart.setBackgroundPaint(Color.white);// ���ñ���ɫ
		// ��ȡ��ͼ������
		CategoryPlot plot = chart.getCategoryPlot();
		plot.setBackgroundPaint(Color.white); // ���û�ͼ������ɫ
		plot.setRangeGridlinePaint(Color.gray); // ����ˮƽ���򱳾�����ɫ
		plot.setRangeGridlinesVisible(true);// �����Ƿ���ʾˮƽ���򱳾���,Ĭ��ֵΪtrue
		plot.setDomainGridlinePaint(Color.white); // ���ô�ֱ���򱳾�����ɫ
		plot.setDomainGridlinesVisible(true); // �����Ƿ���ʾ��ֱ���򱳾���,Ĭ��ֵΪfalse

		CategoryAxis domainAxis = plot.getDomainAxis();
		domainAxis.setLabelFont(font); // ���ú�������
		domainAxis.setTickLabelFont(font);// ������������ֵ����
		domainAxis.setLowerMargin(0.01);// ��߾� �߿����
		domainAxis.setUpperMargin(0.01);// �ұ߾� �߿����,��ֹ���ߵ�һ�����ݿ����������ᡣ
		domainAxis.setMaximumCategoryLabelLines(2);

		ValueAxis rangeAxis = plot.getRangeAxis();
		rangeAxis.setLabelFont(font);
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());// Y����ʾ����
		//rangeAxis.setAutoRangeMinimumSize(0); // ��С���
		//rangeAxis.setUpperMargin(0.18);// �ϱ߾�,��ֹ����һ�����ݿ����������ᡣ
		rangeAxis.setAutoRange(true); // ���Զ�����Y������
		rangeAxis.setTickMarkStroke(new BasicStroke(0.0f)); // ���������Ǵ�С
		rangeAxis.setTickMarkPaint(Color.BLACK); // ������������ɫ
		rangeAxis.setLowerBound(min);
		rangeAxis.setUpperBound(max);
		// ��ȡ���߶���
		LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot
				.getRenderer();
		BasicStroke realLine = new BasicStroke(1.8f); // ����ʵ��
		// ��������
		float dashes[] = { 5.0f };
		BasicStroke brokenLine = new BasicStroke(2.2f, // ������ϸ
				BasicStroke.CAP_ROUND, // �˵���
				BasicStroke.JOIN_ROUND, // �۵���
				1f, dashes, 0.6f);
		/*for (int i = 0; i < dataSet.getRowCount(); i++) {
			if (i % 2 == 0)
				renderer.setSeriesStroke(i, realLine); // ����ʵ�߻���
			else
				renderer.setSeriesStroke(i, brokenLine); // �������߻���
		}*/

		plot.setNoDataMessage("�޶�Ӧ�����ݣ������²�ѯ��");
		plot.setNoDataMessageFont(font);// ����Ĵ�С
		plot.setNoDataMessagePaint(Color.RED);// ������ɫ
		// �����ļ������
		File fos_jpg = new File("d://bloodSugarChart1.jpg");
		// ������ĸ������
		ChartUtilities.saveChartAsJPEG(fos_jpg, chart, // ͳ��ͼ�����
				700, // ��
				500 // ��
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
