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
	Font font = new Font("����", Font.PLAIN, 12);

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

	// /���������鲼�ַ�ʽ��������ķ���

	// /xָ�ؼ�λ�ڵڼ��С�

	// /yָ�ؼ�λ�ڵڼ��С�

	// /wָ�ؼ���Ҫռ���С�

	// /hָ�ؼ���Ҫռ���С�

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

		// ���������鲼�ַ�ʽ�������

		add(c, constraints); // ����ط��ǵ��õĸ����add����

	} // �˷���������ӿؼ���������

	// /����һ������������

	// / loginframe�Ǿ���ָ�������Ŀ��

	// / setDefaultCloseOperation����һ��ʹ�ô�������Ĺرտؼ���Ч����ⷽ��

	// / lay��һ�������鲼�ֹ������Ķ���

	// / nameinput�����������û������ı���

	// / passwordinput����������������ı���

	// / title��������ʾ����ı�ǩ��

	// / name��������ʾ���������ı�ǩ��

	// / password��������ʾ�����롱�ı�ǩ��

	// / ok��һ����ť��ʹ����ϵͳ��

	// / cancel��һ����ť��ʹ�˳������ϵͳ��

	// / ok.addActionListener��һ������ϵͳ�����¼�����������

	// / cancel.addActionListener��һ���˳�ϵͳ�ͽ��涯���¼��ļ���������
	StockInforPanel(){
		
	}
	StockInforPanel(String x)

	{

		GridBagLayout lay = new GridBagLayout();

		setLayout(lay); // ����panel�Ĳ���ʹ��grid

		JLabel name = new JLabel("�û���");

		JLabel password = new JLabel("�� ��");
		JLabel nameinput = new JLabel("�û���");

		JLabel passwordinput = new JLabel("�� ��");
		
		
		JLabel name1 = new JLabel("�û���");

		JLabel password1 = new JLabel("�� ��");
		JLabel nameinput1 = new JLabel("�û���");

		JLabel passwordinput1 = new JLabel("�� ��");

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
	     this.add(new JLabel("�û���"));
	     this.add(new JLabel("�û���"));
	     this.add(new JLabel("�û���"));
	     this.add(new JLabel("�û���"));
	     this.add(new JLabel("�û���"));
	     this.setPreferredSize(new Dimension(150, 2*30));
	     //����Ϊ���񲼾֣�δָ������
	     return this;
	 }
}
