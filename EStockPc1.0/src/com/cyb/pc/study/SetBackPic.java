package com.cyb.pc.study;

import java.awt.Graphics;  
import java.awt.Image;  
import java.io.File;  
  
import javax.swing.ImageIcon;  
import javax.swing.JFrame;  
import javax.swing.JPanel;  
  
public class SetBackPic {  
  
    JFrame jframe = new JFrame();  
    public String path = "d:\\Desert.jpg";  
    public static JPanel GImage = null;  
  
    public SetBackPic(String path) {  
    	this.path = path;
        initFrame();  
    }  
    public SetBackPic() {  
        initFrame();  
    }  
    // ≥ı ºªØ¥∞ø⁄  
    public void initFrame() {  
        // ¿˚”√JPanelÃÌº”±≥æ∞Õº∆¨  
        GImage = new JPanel() {  
            protected void paintComponent(Graphics g) {  
                ImageIcon icon = new ImageIcon(SetBackPic.this.path);  
                Image img = icon.getImage();  
                g.drawImage(img, 0, 0, icon.getIconWidth(),  
                        icon.getIconHeight(), icon.getImageObserver());  
                jframe.setSize(icon.getIconWidth()+50, icon.getIconHeight()+50);  
  
            }  
        };  
        jframe.setTitle("≤‚ ‘±≥æ∞Õº∆¨");  
        jframe.add(GImage);  
        jframe.pack();  
        jframe.setVisible(true);  
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    }  
  
    public static void main(String[] args) {  
        new SetBackPic();  
    }  
  
}  