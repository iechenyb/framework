package com.cyb.pc.study;

import javax.swing.JFrame;
 import javax.swing.JLabel;
 
 public class NinghtMutilNinght extends JFrame {
      private JLabel label = new JLabel("");
 
      public NinghtMutilNinght() {
           this.add(label);
           String s = fun();
           label.setText("<html>" + s + "</html>");
      }
 
      private String fun() {
           StringBuffer sb = new StringBuffer();
           for (int i = 1; i <= 9; i++) {
                for (int j = 1; j <= i; j++) {
                     sb.append(j + "X" + i + "=" + i * j + " ");
                }
                sb.append("<br>");
           }
           return sb.toString();
      }

      public static void main(String[] args) {
           NinghtMutilNinght t = new NinghtMutilNinght();
           t.setVisible(true);
           t.pack();
           t.setDefaultCloseOperation(EXIT_ON_CLOSE);
      }
 }