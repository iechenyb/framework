package com.cyb.pc.study;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.*;

import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickMarkPosition;
import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.axis.DateTickUnitType;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.SegmentedTimeline;
import org.jfree.chart.plot.CombinedDomainXYPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.CandlestickRenderer;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.DataUtilities;
import org.jfree.data.time.MovingAverage;
import org.jfree.data.xy.AbstractIntervalXYDataset;
import org.jfree.data.xy.DefaultOHLCDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.OHLCDataItem;
import org.jfree.data.xy.OHLCDataset;
import org.jfree.data.xy.XYDataset;

import com.cyb.utils.DateUtil;

public class DrawKLINE0 {
 public static ChartPanel charPanel = null;
 private static final Color COLOR_close = new Color(41, 36, 33);// ���̼���ɫ ������
 private static final Color COLOR_MA5 = new Color(138, 43, 226);// 5�վ�����ɫ ��
 private static final Color COLOR_MA10 = new Color(30, 144, 255);// 10�վ�����ɫ ��
 private static final Color COLOR_MA15 = new Color(255, 165, 0);// 15�վ�����ɫ
                 // ����
 private static final Color COLOR_MA20 = new Color(255, 0, 255);// 20�վ�����ɫ
                 // ���
 private static final Color COLOR_MA30 = new Color(240, 230, 140);// 30�վ�����ɫ
                  // �ƺ�
 private static final Color COLOR_MA60 = new Color(0, 0, 128);// 60�վ�����ɫ
                 // ����
 private static final Color COLOR_MA120 = new Color(34, 193, 34);// 120�վ�����ɫ
                 // ɭ����
 private static final Color COLOR_MAVOL5 = new Color(138, 43, 226);// 5�վ�����ɫ
                  // ���
 private static final Color COLOR_MAVOL10 = new Color(255, 0, 0);// 10�վ�����ɫ ��
 private static int W_P = 3;// �۸���
 private static int W_V = 1;// �ɽ������
 private static int WIDTH = 900;
 private static int HEIGHT = 600;
 private static int P_H = (int) (HEIGHT * (1.0 * W_P / (W_P + W_V)));// �۸�߶�
 private static int V_H = (int) (HEIGHT * (1.0 * W_V / (W_P + W_V)));// �ɽ����߶�
 private static Color upColor = Color.RED.brighter();// ��Ʊ���ǵ���ɫ ����ɫ ���̼۴��ڿ��̼�
 private static Color downColor = Color.GREEN.brighter();// ��Ʊ�µ�����ɫ ����ɫ
               // ���̼�С�����̼�

 public static void main(String[] args) {

  JFreeChart chart = buildChart();// ����
  ChartFrame chartFrame = new ChartFrame("��Ʊ�������ͼ", chart);
  charPanel = chartFrame.getChartPanel();
  // �����˵���
  JMenuBar mnb = new JMenuBar();
  // �����˵�
  /* 1 */JMenu mnuSystem = new JMenu("ϵͳ(S)");
  /* 2 */JMenu mnuSystem1 = new JMenu("����(T)");
  // �����˵���
  JMenuItem mniCopy = new JMenuItem("����");
  mniCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_MASK));//���ÿ�ݼ�Ctrl+C
  mniCopy.addActionListener(new MyListener1());
      JMenuItem mniSaveas = new JMenuItem("���Ϊ");
  mniSaveas.addActionListener(new MyListener1()); 
  JMenuItem mniPrint = new JMenuItem("��ӡ");
  mniPrint.addActionListener(new MyListener1());
  
  
  JMenuItem mniEditChartProperties = new JMenuItem("����");
  mniEditChartProperties.addActionListener(new MyListener1()); 
  // ���˵�����ӵ��˵���
  mnuSystem.add(mniCopy);
  mnuSystem.add(mniSaveas);
  mnuSystem.addSeparator();
  mnuSystem.add(mniPrint);
  mnuSystem.addSeparator();
  mnuSystem1.add(mniEditChartProperties );
  // ���˵���ӵ��˵�����
  /* 1 */mnb.add(mnuSystem);
  /* 1 */mnb.add(mnuSystem1);
  
  // ���˵����ҿ��ڿ����
  chartFrame.setJMenuBar(mnb);
  chartFrame.setSize(WIDTH, HEIGHT);// ���óߴ�
  chartFrame.setVisible(true);// ����Ϊ�ɼ�
 }
 public static JFreeChart buildChart() {
  // X������
  DateAxis domainAxis = new DateAxis();// ���������ᣨ��ΪX�ᣩ Ҳ���� ʱ����
  // ����ʱ������ʾ�Ĺ���������������������������������Щû�н��׵�����,ʹͼ�ο���ȥ����
  domainAxis.setTimeline(SegmentedTimeline
    .newMondayThroughFridayTimeline());// SegmentedTimelineΪ�ָ�ʱ���ߵ���˼
  domainAxis.setAutoTickUnitSelection(false);// ���ò������Զ�ѡ��̶�ֵ
  domainAxis.setTickMarkPosition(DateTickMarkPosition.MIDDLE);// �������ڱ�ǩ��λ��
                 // ����Ҫ��AutoTickUnitSelection��false��
  domainAxis.setStandardTickUnits(DateAxis.createStandardDateTickUnits());// ���ñ�׼��ʱ��̶ȵ�λ
  // ����������ݱ�ǩ������ֻ��ʾ������ǩ����Ҫ��AutoTickUnitSelection��false��
  //domainAxis.setTickUnit(new DateTickUnit(DateTickUnitType.DAY, 1));//
  // ����ʱ��̶ȵļ����һ������Ϊ��λ
  domainAxis.setTickUnit(new DateTickUnit(DateTickUnitType.DAY, 7));// ����ʱ��̶ȵļ����һ������Ϊ��λ
   //domainAxis.setTickUnit(new DateTickUnit(DateTickUnitType.DAY, 30));
  // ����ʱ��̶ȵļ����һ������Ϊ��λ
  domainAxis.setDateFormatOverride(new SimpleDateFormat("yyyy-MM-dd"));// ������ʾʱ��ĸ�ʽ
                  // ���ü򵥵�ʱ����ʾ��ʽ����-�죩ȡ����Ҫ���õ�ʱ����ʾ��ʽ
  domainAxis.setLowerMargin(0.02D);// �µ���Χ
  domainAxis.setUpperMargin(0.02D);// ���Ƿ�Χ
  // �۸���(Plot)
  // Y������
  NumberAxis priceAxis = new NumberAxis() {// Y������(����) ���ü۸��ᣨ��ΪY�ᣩΪ������
   private static final long serialVersionUID = -8962863563900391155L;

   @Override
   // ȡ��
   public Paint getTickLabelPaint() {// �滭 ��ȡ���ǺŵĻ滭���
    return Color.BLACK;
   }

   @Override
   public NumberFormat getNumberFormatOverride() {// �趨������ʾ��ʽ
    return new DecimalFormat("0.00");
   }

   @Override
   public boolean getAutoRangeIncludesZero() {// ���Զ�����0�۸���
    return false;
   }
  };
  // priceAxis.Y��
  // �۸�ͼ��(������)ss

  XYPlot pricePlot = new XYPlot(null, domainAxis, priceAxis, null);
  // ����1
  final OHLCDataset priceDataset = getPriceDataSet("000001");// MSFT
  // ����ͼ�趨
  CandlestickRenderer priceRenderer = new CandlestickRenderer();
  priceRenderer.setSeriesPaint(0, Color.black);// ��������ɫ
  priceRenderer.setDrawVolume(true);// ���ɽ���
  priceRenderer.setUpPaint(upColor); // ����
  priceRenderer.setDownPaint(downColor);// �µ�
  // ���̼۵���
  // 1���priceDataset
  XYDataset xyDataset1 = createAverageDataset(priceDataset, 1, 0);// ��ȡ����Դ
  XYSplineRenderer xyRender1 = new XYSplineRenderer() {//����һ���µ���Ⱦ��ָ���ľ���
   private static final long serialVersionUID = 1859309003413288563L;

   @Override
   public Boolean getSeriesShapesVisible(int series) {
    return false;
   }

   @Override
   public Paint getSeriesPaint(int series) {
    return COLOR_close;
   }
  };
  // ����ͼ�趨
  // 5�����
  XYDataset xyDataset5 = createAverageDataset(priceDataset, 5, 0);// ��ȡ����Դ
  XYSplineRenderer xyRender5 = new XYSplineRenderer() {
   private static final long serialVersionUID = 1859309003413288563L;

   @Override
   public Boolean getSeriesShapesVisible(int series) {
    return false;
   }

   @Override
   public Paint getSeriesPaint(int series) {
    return COLOR_MA5;
   }
  };
  // 10�����
  XYDataset xyDataset10 = createAverageDataset(priceDataset, 10, 0);
  XYSplineRenderer xyRender10 = new XYSplineRenderer() {
   private static final long serialVersionUID = 1664318080312451661L;

   @Override
   public Boolean getSeriesShapesVisible(int series) {
    return false;
   }

   @Override
   public Paint getSeriesPaint(int series) {
    return COLOR_MA10;
   }
  };
  // 15�����
  XYDataset xyDataset15 = createAverageDataset(priceDataset, 15, 0);
  XYSplineRenderer xyRender15 = new XYSplineRenderer() {
   private static final long serialVersionUID = 5338323939520574140L;

   @Override
   public Boolean getSeriesShapesVisible(int series) {
    return false;
   }

   @Override
   public Paint getSeriesPaint(int series) {
    return COLOR_MA15;
   }
  };
  // 20�����
  XYDataset xyDataset20 = createAverageDataset(priceDataset, 20, 0);
  XYSplineRenderer xyRender20 = new XYSplineRenderer() {
   private static final long serialVersionUID = 2041484824762200102L;

   @Override
   public Boolean getSeriesShapesVisible(int series) {
    return false;
   }

   @Override
   public Paint getSeriesPaint(int series) {
    return COLOR_MA20;
   }
  };

  // 30�����
  XYDataset xyDataset30 = createAverageDataset(priceDataset, 30, 0);
  XYSplineRenderer xyRender30 = new XYSplineRenderer() {
   private static final long serialVersionUID = 2041484824762200102L;

   @Override
   public Boolean getSeriesShapesVisible(int series) {
    return false;
   }

   @Override
   public Paint getSeriesPaint(int series) {
    return COLOR_MA30;
   }
  };
  // 60�����
  XYDataset xyDataset60 = createAverageDataset(priceDataset, 60, 0);
  XYSplineRenderer xyRender60 = new XYSplineRenderer() {
   private static final long serialVersionUID = 2041484824762200102L;

   @Override
   public Boolean getSeriesShapesVisible(int series) {
    return false;
   }

   @Override
   public Paint getSeriesPaint(int series) {
    return COLOR_MA60;
   }
  };
  // 120�����
  XYDataset xyDataset120 = createAverageDataset(priceDataset, 120, 0);
  XYSplineRenderer xyRender120 = new XYSplineRenderer() {
   private static final long serialVersionUID = 2041484824762200102L;

   @Override
   public Boolean getSeriesShapesVisible(int series) {
    return false;
   }

   @Override
   public Paint getSeriesPaint(int series) {
    return COLOR_MA120;
   }
  };
  Paint gradientP = new GradientPaint(0, 0, new Color(252, 252, 200), 0,
    P_H, new Color(252, 252, 252));// �� �۸��ݶ� ����ɫ �����ϣ�100,170,200��
  Paint gradientV = new GradientPaint(0, 0, new Color(252, 252, 252), 0,
    V_H, new Color(200, 150, 130));// �� �ɽ����ݶ� ����ɫ ��(189,252,201)����
  pricePlot.setDataset(0, priceDataset);
  pricePlot.setRenderer(0, priceRenderer);
  pricePlot.setDataset(1, xyDataset5);
  pricePlot.setRenderer(1, xyRender5);
  pricePlot.setDataset(2, xyDataset10);
  pricePlot.setRenderer(2, xyRender10);
  pricePlot.setDataset(3, xyDataset15);
  pricePlot.setRenderer(3, xyRender15);
  pricePlot.setDataset(4, xyDataset20);
  pricePlot.setRenderer(4, xyRender20);
  pricePlot.setDataset(5, xyDataset30);
  pricePlot.setRenderer(5, xyRender30);
  pricePlot.setDataset(6, xyDataset60);
  pricePlot.setRenderer(6, xyRender60);
  pricePlot.setDataset(7, xyDataset120);
  pricePlot.setRenderer(7, xyRender120);
  pricePlot.setDataset(8, xyDataset1);
  pricePlot.setRenderer(8, xyRender1);
  pricePlot.setBackgroundPaint(gradientP);// ���� ����ɫ
  // ��������(Plot)
  // IntervalXYDataset volumeDataset = getVolumeDataset(priceDataset,24L *
  // 60 * 60 * 1000);
  XYDataset volumeDataset = getVolumeDataset(priceDataset,
    24L * 60 * 60 * 1000);
  // Each bar is 24 hours wide��ÿ��Ϊ24Сʱ��.XY���ݼ������
  // PS:��24���һ��L��ʾ24Ϊ������
  NumberAxis volumeAxis = new NumberAxis() {
   private static final long serialVersionUID = -4910537548590143802L;

   @Override
   public NumberFormat getNumberFormatOverride() {// �趨��ʾ��ʽ
    return new DecimalFormat("0.00E00") {
     private static final long serialVersionUID = 8224078094493778288L;

     @Override
     public StringBuffer format(double number,
       StringBuffer result, FieldPosition fieldPosition) {// ����
                    // ��ʾ
      String sb = super.format(number, result, fieldPosition)
        .toString();
      String[] ctx = sb.split("E");// ������ �ָ�ɡ�E��
              // ctx=Context������
      String first = ctx[0];
      String second = ctx[1];
      double fValue = Double.valueOf(first);
      int sValue = Integer.valueOf(second);
      if (fValue <= 0.001d) {
       return new StringBuffer("0");
      }
      int tcount = 0;// ����
      String suffix = "";// ��׺/��β
      if (sValue < 3) {
       tcount = sValue;
       suffix = "";
      } else if (sValue < 6) {
       tcount = sValue - 3;
       suffix = "K";
      } else if (sValue < 9) {
       tcount = sValue - 6;
       suffix = "M";
      } else if (sValue < 12) {
       tcount = sValue - 9;
       suffix = "G";
      } else if (sValue < 15) {
       tcount = sValue - 12;
       suffix = "T";
      } else {
       return new StringBuffer("NaN");// �淶����:NaN�������κ��������Լ�;float��doule���������ֵNaN
      }
      String symbol = "";// �Ǻ�
      if (tcount == 0) {
       symbol = "0.00";
      } else if (tcount == 1) {
       symbol = "00.0";
      } else if (tcount == 2) {
       symbol = "000";
      }
      DecimalFormat format = new DecimalFormat(symbol);// С���ı�ʾ

      return new StringBuffer(format.format(fValue
        * Math.pow(10, tcount))).append(suffix);// �����ʾ
                  // ��ʾΪ��ѧ��ʽ�ļ���.���Ϻ�׺
     }
    };
   }

   @Override
   public Paint getTickLabelPaint() {
    return Color.black;
   }
  };
  // XYPlot pricePlot = new XYPlot(null, domainAxis, priceAxis, null);
  
  XYBarRenderer volumeRenderer = new XYBarRenderer() {
   private static final long serialVersionUID = -4237832644518701189L;

//   @Override
   
   public Paint getSeriesPaint(int series) {
    
    return Color.blue.brighter();
  }
   

  };// ʵ����һ����{}���ӣ�

  // volumePlot����
  XYPlot volumePlot = new XYPlot(volumeDataset, null, volumeAxis,
    volumeRenderer);
  // XYPlot plot2=new
  // XYPlot(timeSeriesCollection,null,y2Axis,xyBarRender);
  volumePlot.setBackgroundPaint(gradientV);// ������ɫΪ����ɫ

  // 5�������
  XYDataset xyDatasetVOL5 = createAverageDataset(volumeDataset, 5, 0);
  XYSplineRenderer xyRenderVOL5 = new XYSplineRenderer() {
   private static final long serialVersionUID = 2041484824762200102L;

   @Override
   public Boolean getSeriesShapesVisible(int series) {
    return false;
   }

   @Override
   public Paint getSeriesPaint(int series) {
    return COLOR_MAVOL5;
   }
  };
  // 10�������
  XYDataset xyDatasetVOL10 = createAverageDataset(volumeDataset, 10, 0);
  XYSplineRenderer xyRenderVOL10 = new XYSplineRenderer() {
   private static final long serialVersionUID = 2041484824762200102L;

   @Override
   public Boolean getSeriesShapesVisible(int series) {
    return false;
   }

   @Override
   public Paint getSeriesPaint(int series) {
    return COLOR_MAVOL10;
   }
  };
  volumePlot.setDataset(0, volumeDataset);
  volumePlot.setRenderer(0, volumeRenderer);
  volumePlot.setDataset(1, xyDatasetVOL5);
  volumePlot.setRenderer(1, xyRenderVOL5);
  volumePlot.setDataset(2, xyDatasetVOL10);
  volumePlot.setRenderer(2, xyRenderVOL10);
  // �Ѹ�����ͳһ����
  CombinedDomainXYPlot mainPlot = new CombinedDomainXYPlot(domainAxis);
  mainPlot.add(pricePlot, 2);
  mainPlot.add(volumePlot, 1);
  mainPlot.setGap(5.0d);// �趨����֮��ļ��
  // �Զ���ͼ��
  LegendItemCollection legendItemCollection = createLegendItems();
  mainPlot.setFixedLegendItems(legendItemCollection);

  return new JFreeChart("�չA", null, mainPlot, true);
 }

 // �Զ���ͼ��
 private static LegendItemCollection createLegendItems() {
  LegendItemCollection legenditemcollection1 = new LegendItemCollection();
  LegendItem legenditem1 = new LegendItem("MA5", "-", "5�վ�����", null,
    Plot.DEFAULT_LEGEND_ITEM_BOX, COLOR_MA5);
  LegendItem legenditem2 = new LegendItem("MA10", "-", "10�վ�����", null,
    Plot.DEFAULT_LEGEND_ITEM_BOX, COLOR_MA10);
  LegendItem legenditem3 = new LegendItem("MA15", "-", "15�վ�����", null,
    Plot.DEFAULT_LEGEND_ITEM_BOX, COLOR_MA15);
  LegendItem legenditem4 = new LegendItem("MA20", "-", "20�վ�����", null,
    Plot.DEFAULT_LEGEND_ITEM_BOX, COLOR_MA20);
  LegendItem legenditem5 = new LegendItem("MA30", "-", "30�վ�����", null,
    Plot.DEFAULT_LEGEND_ITEM_BOX, COLOR_MA30);
  LegendItem legenditem6 = new LegendItem("MA60", "-", "60�վ�����", null,
    Plot.DEFAULT_LEGEND_ITEM_BOX, COLOR_MA60);
  LegendItem legenditem7 = new LegendItem("MA120", "-", "120�վ�����", null,
    Plot.DEFAULT_LEGEND_ITEM_BOX, COLOR_MA120);
  LegendItem legenditem8 = new LegendItem("close", "-", "������", null,
    Plot.DEFAULT_LEGEND_ITEM_BOX, COLOR_close);
  LegendItem legenditem11 = new LegendItem("MAVOL5", "-", "5�վ�������", null,
    Plot.DEFAULT_LEGEND_ITEM_BOX, COLOR_MAVOL5);
  LegendItem legenditem12 = new LegendItem("MAVOL10", "-", "10�վ�������",
    null, Plot.DEFAULT_LEGEND_ITEM_BOX, COLOR_MAVOL10);

  legenditemcollection1.add(legenditem1);
  legenditemcollection1.add(legenditem2);
  legenditemcollection1.add(legenditem3);
  legenditemcollection1.add(legenditem4);
  legenditemcollection1.add(legenditem5);
  legenditemcollection1.add(legenditem6);
  legenditemcollection1.add(legenditem7);
  legenditemcollection1.add(legenditem8);
  legenditemcollection1.add(legenditem11);
  legenditemcollection1.add(legenditem12);


  return legenditemcollection1;// ��ͼ���Ĳɼ�

 }

 protected static OHLCDataset getPriceDataSet(String symbol) {
  List<OHLCDataItem> dataItems = new ArrayList<OHLCDataItem>();
  try {
//   String strUrl = "http://ichart.finance.yahoo.com/table.csv?s="
//     + symbol + "&a=8&b=1&c=2009&d=12&e=30&f=2009&ignore=.csv";
//   URL url = new URL(strUrl);
//   BufferedReader in = new BufferedReader(new InputStreamReader(url                   
//     .openStream()));
    BufferedReader in = new BufferedReader(new FileReader("d://SZ000001.TXT"));
   DateFormat df = new SimpleDateFormat("yyyyMMdd");
   String inputLine;
   in.readLine();
   int i=0;
   while ((inputLine = in.readLine()) != null) {
    StringTokenizer st = new StringTokenizer(inputLine, ",");
    i = i+1;
    Date date = DateUtil.nextSomeDay(new Date(), i);
//    Date date = df.parse(DateUtil.date2long8(tmp)+"");
    double open = Double.parseDouble( st.nextToken());//nextToken() ���ڷ�����һ��ƥ����ֶ�
    double high = Double.parseDouble( st.nextToken());
    double low = Double.parseDouble( st.nextToken());
    double close = Double.parseDouble( st.nextToken());
    double volume = Double.parseDouble( st.nextToken());
    // double adjClose = Double.parseDouble( st.nextToken() );
    OHLCDataItem item = new OHLCDataItem(date, open, high, low,
      close, volume);//����������ʾ
    dataItems.add(item);
   }
   in.close();
  } catch (Exception e) {
   e.printStackTrace();
  }
  Collections.reverse(dataItems);
  OHLCDataItem[] data = dataItems.toArray(new OHLCDataItem[dataItems
    .size()]);
  return new DefaultOHLCDataset("", data);
 }

 protected static IntervalXYDataset getVolumeDataset( // XY����Դ��� ��ȡ�ɽ�������Դ
   final OHLCDataset priceDataset, final long barWidthInMilliseconds) {
  return new AbstractIntervalXYDataset() {
   private static final long serialVersionUID = 2289539752052175826L;

   public int getSeriesCount() {
    return priceDataset.getSeriesCount();
   }

   @SuppressWarnings("unchecked")
   public Comparable getSeriesKey(int series) {
    return priceDataset.getSeriesKey(series) + "-Volume";
   }

   public int getItemCount(int series) {
    return priceDataset.getItemCount(series);
   }

   public Number getX(int series, int item) {
    return priceDataset.getX(series, item);
   }

   public Number getY(int series, int item) {
    return priceDataset.getVolume(series, item);
   }

   public Number getStartX(int series, int item) {
    return priceDataset.getX(series, item).doubleValue()
      - barWidthInMilliseconds / 2;
   }

   public Number getEndX(int series, int item) {
    return priceDataset.getX(series, item).doubleValue()
      + barWidthInMilliseconds / 2;
   }
   public Number getStartY(int series, int item) {
    return new Double(0.0d);
   }

   public Number getEndY(int series, int item) {
    return priceDataset.getVolume(series, item);
   }
  };
 }

 /**
  * ת��ΪN�վ���
  * 
  * @param day
  * @return
  */
 private static XYDataset createAverageDataset(final XYDataset source,
   final int day, final int daySkip) {
  XYDataset xyDataset = MovingAverage.createMovingAverage(source, day
    + "�վ���", 24L * 60 * 60 * 1000 * day, // day��Ϊһ������
    24L * 60 * 60 * 1000 * daySkip); // �ʼ��daySkip������
  return xyDataset;
 }


}
class MyListener1 implements ActionListener{

 public void actionPerformed(ActionEvent e) {
  // System.out.println(e.getActionCommand());
  DrawKLINE0 panel = new DrawKLINE0();
  if ("���Ϊ".equals(e.getActionCommand())) {
   
   try {
    panel.charPanel.doSaveAs();
   } catch (IOException e1) {
    // TODO Auto-generated catch block
    e1.printStackTrace();
   }
  }else if ("����".equals(e.getActionCommand())) {
   
    panel.charPanel.doCopy();
  }else if ("��ӡ".equals(e.getActionCommand())) {
   
   panel.charPanel.createChartPrintJob();
 }else if("����".equals(e.getActionCommand())){
  panel.charPanel.doEditChartProperties();
 }
 }
 
}
