package com.cyb.pc.study;

import java.awt.*;
import java.io.IOException;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLFrameHyperlinkEvent;

public class DisplayHtml extends JFrame implements HyperlinkListener {
	public DisplayHtml() throws Exception {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //�õ���Ļ�ĳߴ� 
		//screenSize.width //���
		//screenSize.height //�߶�
		setSize(screenSize.width, screenSize.height);
		setTitle("��������");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JEditorPane editorpane = new JEditorPane();
		// �ŵ����������в��ܹ����鿴��������
		JScrollPane scrollpane = new JScrollPane(editorpane);
		// ��������ʾ��ҳ html �ļ�,��ѡ��
		// editorpane.setcontenttype("text/html");
		// ���ó�ֻ��������ǿɱ༭����ῴ����ʾ������Ҳ�ǲ�һ���ģ�true��ʾ����
		editorpane.setEditable(false);
		// Ҫ����Ӧ��ҳ�е����ӣ��������ϳ���������
		editorpane.addHyperlinkListener(this);
		String path = "http://121.42.144.78/ws/line.zc?code=sh000001";
		try {
			editorpane.setPage(path);
		} catch (IOException e) {
			System.out.println("��ȡҳ�� " + path + " ����. " + e.getMessage());
		}
		Container container = getContentPane();
		// ��editorpane����������������
		container.add(scrollpane, BorderLayout.CENTER);
	}

	// ����������������Գ������ӵĵ���¼������԰�ť�ĵ�������񲻵�
	public void hyperlinkupdate(HyperlinkEvent e) {
		if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
			JEditorPane pane = (JEditorPane) e.getSource();
			if (e instanceof HTMLFrameHyperlinkEvent) {
				HTMLFrameHyperlinkEvent evt = (HTMLFrameHyperlinkEvent) e;
				HTMLDocument doc = (HTMLDocument) pane.getDocument();
				doc.processHTMLFrameHyperlinkEvent(evt);
			} else {
				try {
					pane.setPage(e.getURL());
				} catch (Throwable t) {
					t.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		JFrame frame = new DisplayHtml();
		frame.setVisible(true);
	}

	
	public void hyperlinkUpdate(HyperlinkEvent e) {
		// TODO Auto-generated method stub
		System.out.println("SDFSFSDFSFDSFS");
		
	}
}
