package com.cyb.pc.gwjl;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StockInforPanel extends JPanel {
	Font font = new Font("宋体", Font.PLAIN, 12);

	public JPanel createPanel() {
		JPanel panel = new JPanel();
		JLabel name = new JLabel("");
		name.setText("<html>nameval<br></html>");
		name.setFont(font);
		panel.add(name);
		JLabel open = new JLabel("");
		open.setText("<html>nameval<br></html>");
		open.setFont(font);
		panel.add(open);
		JLabel high = new JLabel("");
		high.setText("<html>nameval<br></html>");
		high.setFont(font);
		panel.add(high);
		JLabel low = new JLabel("");
		low.setText("<html>nameval<br></html>");
		low.setFont(font);
		panel.add(low);
		JLabel close = new JLabel("");
		close.setText("<html>nameval<br></html>");
		close.setFont(font);
		panel.add(close);
		JLabel price = new JLabel("");
		price.setText("<html>nameval<br></html>");
		price.setFont(font);
		panel.add(price);
		return this;
	}

	private static final long serialVersionUID = 1834511718758119719L;

	static final int WIDTH = 300;

	static final int HEIGHT = 150;

	JFrame loginframe;

	// /按照网格组布局方式排列组件的方法

	// /x指控件位于第几列。

	// /y指控件位于第几行。

	// /w指控件需要占几列。

	// /h指控件需要占几行。

	public void add(Component c, GridBagConstraints constraints, int x, int y,
			int w, int h)

	{

		constraints.gridx = x;

		constraints.gridy = y;

		constraints.gridwidth = w;

		constraints.gridheight = h;

		// constraints.insets=new Insets(0,0,0,0);

		// constraints.ipadx=10;

		// constraints.ipady=10;

		// constraints.fill = GridBagConstraints.BOTH;

		// 按照网格组布局方式排列组件

		add(c, constraints); // 这个地方是调用的父类的add方法

	} // 此方法用来添加控件到容器中

	// /这是一个构造器方法

	// / loginframe是就是指这个界面的框架

	// / setDefaultCloseOperation这是一个使得窗口上面的关闭控件有效的类库方法

	// / lay是一个网格组布局管理器的对象。

	// / nameinput是用来输入用户名的文本域。

	// / passwordinput是用来输入密码的文本域。

	// / title是用来显示标题的标签。

	// / name是用来显示“姓名”的标签。

	// / password是用来显示“密码”的标签。

	// / ok是一个按钮，使进入系统。

	// / cancel是一个按钮，使退出界面和系统。

	// / ok.addActionListener是一个进入系统动作事件监听方法。

	// / cancel.addActionListener是一个退出系统和界面动作事件的监听方法。
	StockInforPanel(){
		
	}
	StockInforPanel(String x)

	{

		GridBagLayout lay = new GridBagLayout();

		setLayout(lay); // 这里panel的布局使用grid

		JLabel name = new JLabel("用户名");

		JLabel password = new JLabel("密 码");
		JLabel nameinput = new JLabel("用户名");

		JLabel passwordinput = new JLabel("密 码");
		
		
		JLabel name1 = new JLabel("用户名");

		JLabel password1 = new JLabel("密 码");
		JLabel nameinput1 = new JLabel("用户名");

		JLabel passwordinput1 = new JLabel("密 码");

		GridBagConstraints constraints = new GridBagConstraints();

		constraints.fill = GridBagConstraints.NONE;

		constraints.anchor = GridBagConstraints.EAST;

		constraints.weightx = 5;

		constraints.weighty = 5;
		constraints.gridheight=2;

		add(name, constraints, 0, 1, 1, 1);

		add(password, constraints, 1, 1, 1, 1);

		add(nameinput, constraints, 2, 1, 1, 1);

		add(passwordinput, constraints, 3, 1, 1, 1);
		
		
		add(name1, constraints, 0, 2, 1, 1);

		add(password1, constraints, 1, 2, 1, 1);

		add(nameinput1, constraints, 2, 2, 1, 1);

		add(passwordinput1, constraints, 3, 2, 1, 1);
		this.setPreferredSize(new Dimension(150, 2*30));
	}
	
	 public JPanel GridLayoutDemo() {

	     this.setLayout(new GridLayout(0,2));   
	     this.add(new JLabel("用户名"));
	     this.add(new JLabel("用户名"));
	     this.add(new JLabel("用户名"));
	     this.add(new JLabel("用户名"));
	     this.add(new JLabel("用户名"));
	     this.setPreferredSize(new Dimension(150, 2*30));
	     //设置为网格布局，未指定行数
	     return this;
	 }
}
