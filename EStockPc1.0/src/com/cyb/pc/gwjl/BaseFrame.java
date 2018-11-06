package com.cyb.pc.gwjl;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.cyb.pc.Contants;
import com.cyb.utils.ConfigUtils;

public class BaseFrame {
	JPanel mainPane = new JPanel();
	public JFrame window = new JFrame("π…Õ˘ΩÒ¿¥");;
	public JPanel north = new JPanel();
	public JPanel east = new JPanel();
	public JPanel center = new JPanel();
	public JPanel south = new JPanel();	
	public JPanel west = new JPanel();
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screenSize = kit.getScreenSize();
	public JPanel backgroundimage = new JPanel() {  
		private static final long serialVersionUID = 1L;
			protected void paintComponent(Graphics g) {  
                ImageIcon icon = new ImageIcon(ConfigUtils.get("log"));  
                Image img = icon.getImage();  
                g.drawImage(img, 0, 0, icon.getIconWidth(),icon.getIconHeight(), icon.getImageObserver());
                window.setSize(icon.getIconWidth(), icon.getIconHeight());  
            }  
    };  
	public void refresh(){
		window.pack();
		window.setBounds(0, 0, Contants.width, Contants.height*95/100);
	}
}
