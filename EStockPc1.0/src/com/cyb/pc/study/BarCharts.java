package com.cyb.pc.study;

import java.awt.Color;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
public class BarCharts extends ApplicationFrame {
 public BarCharts(String s) {
  super(s);
  setContentPane(createDemoBar());
 }
 // ������ʾͼ������
 public static JPanel createDemoBar() {
  JFreeChart jfreechart = createChart(createDataset());
  return new ChartPanel(jfreechart);
 }
 // ����ͼ��������JFreeChart
 public static JFreeChart createChart(CategoryDataset dataset) {
  JFreeChart chart = ChartFactory.createBarChart3D("fruitsales", //����3D��״ͼ
    "fruit",//��������
    "number",//��������
    dataset,//���ݼ�
    PlotOrientation.VERTICAL,//������ʾ
    true,//��ʾÿ����ɫ���ӵ�����
    false, false);
  CategoryPlot plot = chart.getCategoryPlot();//����ͼ�ĸ߼�����
  BarRenderer3D renderer = new BarRenderer3D();//3D�����޸�
  renderer.setBaseOutlinePaint(Color.BLACK);//���ñ߿���ɫΪblack
  renderer.setWallPaint(Color.gray); //����wall����ɫΪgray
  renderer
    .setItemLabelGenerator(new StandardCategoryItemLabelGenerator());//������������,API�о�Ȼû��StandardCategoryItemLabelGenerator�����
  //renderer.setItemLabelFont(new Font("����",Font.PLAIN,12));//����������������
  renderer.setItemLabelsVisible(true);//��ItemLabel����
  plot.setRenderer(renderer);//���޸ĺ������ֵ���浽ͼ��
  plot.setForegroundAlpha(0.6f);//����͸����
  return chart;
 }
 // ��������
 public static CategoryDataset createDataset() {
  double[][] data = new double[][] { { 672, 766, 223, 540, 126 },
    { 325, 521, 210, 340, 106 }, { 332, 256, 523, 240, 526 } };// ��������
  String[] rowKeys = { "apple", "banana", "li" };// �б�־
  String[] columnKeys = { "beijing", "shanghai", "guangzhou", "chengdu", "shengzhen" };// �б�־
  CategoryDataset linedataset = DatasetUtilities.createCategoryDataset(
    rowKeys, columnKeys, data); // �������ݼ�
  return linedataset;
 }
 public static void main(String[] args) {
	 BarCharts fjc = new BarCharts("bar");
	 fjc.pack();
	 RefineryUtilities.centerFrameOnScreen(fjc);
	 fjc.setVisible(true);
 }
 public static void  display(){
	 BarCharts fjc = new BarCharts("bar");
	 fjc.pack();
	 RefineryUtilities.centerFrameOnScreen(fjc);
	 fjc.setVisible(true);
 }
}