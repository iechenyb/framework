package com.cyb.pc.study;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame implements ActionListener {
	GridBagLayout g = new GridBagLayout();
	GridBagConstraints c = new GridBagConstraints();

	LoginFrame(String str) {
		super(str);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //�õ���Ļ�ĳߴ� 
		//screenSize.width //���
		//screenSize.height //�߶�
		setSize(screenSize.width, screenSize.height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(g);
		// ���÷���
		addComponent();
		submit.addActionListener(this);
		setVisible(true);
		setLocationRelativeTo(null);// �������ʾ;
	}

	// ����������н���������е����;
	// ʹ�õ����������;ϣ��¥���ܿ���;
	public void addComponent() {
		// ������Ϣ�Ǽ�
		noteInformation = new JLabel("������Ϣ�Ǽǣ�");
		add(g, c, noteInformation, 0, 0, 1, 1);
		// �û���
		userName = new JLabel("�û�����");
		add(g, c, userName, 0, 1, 1, 1);
		// �û��������
		textUserName = new JTextField(10);
		add(g, c, textUserName, 1, 1, 2, 1);
		// ���룺
		password = new JLabel("���룺");
		add(g, c, password, 0, 2, 1, 1);
		// ���������
		textUserPassword = new JTextField(10);
		add(g, c, textUserPassword, 1, 2, 2, 1);
		// �Ա�
		sex = new JLabel("�Ա�:");
		add(g, c, sex, 0, 3, 1, 1);
		// �� Ů��ѡ��
		sexMan = new JRadioButton("��");
		add(g, c, sexMan, 1, 3, 1, 1);
		sexGirl = new JRadioButton("Ů");
		add(g, c, sexGirl, 2, 3, 1, 1);
		ButtonGroup group = new ButtonGroup();
		group.add(sexMan);
		group.add(sexGirl);
		// ��������
		birthday = new JLabel("��������:");
		add(g, c, birthday, 0, 4, 1, 1);
		// ��ѡ��������
		String[] YEARS = new String[65];
		for (int i = 1950, k = 0; i <= 2014; i++, k++) {
			YEARS[k] = i + "��";
		}
		year = new JComboBox(YEARS);
		add(g, c, year, 1, 4, 1, 1);
		// ��ѡ������
		month = new JComboBox(MONTH);
		add(g, c, month, 2, 4, 1, 1);
		// submit��ť
		submit = new JButton("submit");
		c.insets = new Insets(7, 0, 4, 0);
		add(g, c, submit, 1, 5, 1, 1);

		result = new JTextArea(15, 20);
		add(g, c, result, 0, 6, 3, 4);

	}

	public void add(GridBagLayout g, GridBagConstraints c, JComponent jc,
			int x, int y, int gw, int gh) {
		c.gridx = x;
		c.gridy = y;
		c.anchor = GridBagConstraints.WEST;
		c.gridwidth = gw;
		c.gridheight = gh;
		g.setConstraints(jc, c);
		add(jc);
	}

	public static void main(String args[]) {
		new LoginFrame("������Ϣ�ǼǱ�");
	}

	JLabel noteInformation, userName, password;
	JLabel sex, birthday;
	JTextField textUserName, textUserPassword;
	JRadioButton sexMan, sexGirl;
	JComboBox year, month;
	JButton submit;
	JTextArea result;

	final String[] MONTH = { "1��", "2��", "3��", "4��", "5��", "6��", "7��", "8��",
			"9��", "10��", "11��", "12��" };

	public void actionPerformed(ActionEvent arg0) {
		String s = textUserName.getText();
		String t = textUserPassword.getText();
		String k = sexMan.getText();
		String v = sexGirl.getText();
		String a = (String) year.getSelectedItem();
		String b = (String) month.getSelectedItem();
		String num = "�û�����" + s + "\n" + "����: " + t + "\n �Ա�: "
				+ (k == null ? v : k) + "\n" + "��������:" + a + " " + b;
		result.setText(num);
	}

}
