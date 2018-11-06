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
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //得到屏幕的尺寸 
		//screenSize.width //宽度
		//screenSize.height //高度
		setSize(screenSize.width, screenSize.height);
		setTitle("股往金来");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JEditorPane editorpane = new JEditorPane();
		// 放到滚动窗格中才能滚动查看所有内容
		JScrollPane scrollpane = new JScrollPane(editorpane);
		// 设置是显示网页 html 文件,可选项
		// editorpane.setcontenttype("text/html");
		// 设置成只读，如果是可编辑，你会看到显示的样子也是不一样的，true显示界面
		editorpane.setEditable(false);
		// 要能响应网页中的链接，则必须加上超链监听器
		editorpane.addHyperlinkListener(this);
		String path = "http://121.42.144.78/ws/line.zc?code=sh000001";
		try {
			editorpane.setPage(path);
		} catch (IOException e) {
			System.out.println("读取页面 " + path + " 出错. " + e.getMessage());
		}
		Container container = getContentPane();
		// 让editorpane总是填满整个窗体
		container.add(scrollpane, BorderLayout.CENTER);
	}

	// 超链监听器，处理对超级链接的点击事件，但对按钮的点击还捕获不到
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
