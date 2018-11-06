package com.cyb.pc.gwjl;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javafx.scene.chart.BarChart;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JToolBar;

import com.cyb.pc.study.BarCharts;
import com.cyb.utils.ConfigUtils;


public class Welcome {
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screenSize = kit.getScreenSize();
	int width = screenSize.width;
	int height = screenSize.height;
	JPopupMenu pop;
	JMenuItem item1;
	JMenuItem item2;
	JFrame window;
	JPanel p;
	JToolBar bar;
	public static JPanel GImage = null; 
	public String path = ConfigUtils.get("backgroundPic");  
	public Welcome() {
		width = screenSize.width;
		height = screenSize.height;
		window = new JFrame("股往今来");
		GImage = new JPanel() {  
		private static final long serialVersionUID = 1L;
			protected void paintComponent(Graphics g) {  
                ImageIcon icon = new ImageIcon(Welcome.this.path);  
                Image img = icon.getImage();  
                g.drawImage(img, 0, 0, icon.getIconWidth(),icon.getIconHeight(), icon.getImageObserver());
//                g.drawImage(img, 0, 0, width,height, icon.getImageObserver());
                window.setSize(icon.getIconWidth(), icon.getIconHeight());  
            }  
        };  
		JMenuBar menubar1 = new JMenuBar();
		p = new JPanel();
		window.setContentPane(p);
		window.setJMenuBar(menubar1);
		JMenu menu1 = new JMenu("沪深指数");
		JMenu menu2 = new JMenu("行业分类");
		JMenu menu3 = new JMenu("涨跌分析");
		JMenu menu4 = new JMenu("自选股");
		menubar1.add(menu1);
		menubar1.add(menu2);
		menubar1.add(menu3);
		menubar1.add(menu4);
		item1 = new JMenuItem("上证指数");
		item2 = new JMenuItem("深证成指");
		JMenuItem item3 = new JMenuItem("创业板指");
		JMenuItem item4 = new JMenuItem("农林牧渔");
		JMenuItem item5 = new JMenuItem("采矿业");
		JMenuItem item6 = new JMenuItem("上涨榜");
		JMenuItem item7 = new JMenuItem("涨停榜");
		JMenuItem item8 = new JMenuItem("中国银行");
		JMenuItem item9 = new JMenuItem("中国联通");
		JMenuItem item10 = new JMenuItem("梅雁吉祥");
		menu1.add(item1);
		item1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//你需要跳转到的地方
				BarCharts.display();
			}
		});
		menu1.addSeparator();
		menu1.add(item2);
		menu1.addSeparator();
		menu1.add(item3);
		menu2.add(item4);
		menu2.addSeparator();
		menu2.add(item5);
		menu3.add(item6);
		menu3.addSeparator();
		menu3.add(item7);
		menu4.add(item8);
		menu4.addSeparator();
		menu4.add(item9);
		menu4.addSeparator();
		menu4.add(item10);
		bar = new JToolBar();
		/*JButton button1 = new JButton("工具1");
		JButton button2 = new JButton("工具2");
		JButton button3 = new JButton("工具3");
		bar.add(button1);
		bar.add(button2);
		bar.add(button3);*/
		BorderLayout bord = new BorderLayout();
		p.setLayout(bord);
		p.add("North", bar);
		window.setLocation(150, 50);
		window.setSize(width * 90 / 100, height*90/100 );
		window.add(GImage);  
		window.pack(); 
		window.setVisible(true);
		ImageIcon i = new ImageIcon("C:\\Users\\WEIBO\\workspace\\UtilCenter\\src\\com\\cyb\\pc\\gwjl\\tigger.gif");
		window.setIconImage(i.getImage());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args)

	{
		try {
			ConfigUtils.init();
			new Welcome();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
