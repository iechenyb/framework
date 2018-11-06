package com.cyb.pc.study;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BorderLayoutTest {
	static boolean x = false;

	public static void main(String[] args) {
		JFrame frame = new JFrame("BorderLayout");
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		
		JPanel north = new JPanel();
		north.setBackground(Color.red);
		JButton stBtn1 = new JButton("north");
		north.add(stBtn1);
		pane.add(north, BorderLayout.NORTH);
		
		JPanel east = new JPanel();
		east.setBackground(Color.green);
		JButton stBtn = new JButton("east");
		east.add(stBtn);
		pane.add(east, BorderLayout.EAST);


		JPanel west = new JPanel();
		west.setBackground(Color.blue);
		Dimension d = new Dimension(100, 50);
		pane.setPreferredSize(d);
		pane.add(west, BorderLayout.WEST);
		

		JButton stop = new JButton("west");
		west.add(stop);
		stop.setBounds(0, 0, 1000, 50);
		
		JPanel south = new JPanel();
		south.setBackground(Color.CYAN);
		JButton cbtn = new JButton("south");
		south.add(cbtn);
		pane.add(south, BorderLayout.SOUTH);

		JPanel center = new JPanel();
		center.setBackground(Color.magenta);
		JButton cff = new JButton("center");
		center.add(cff);
		pane.add(center, BorderLayout.CENTER);
		
		
		frame.add(pane);
		frame.setVisible(true);
		frame.setBounds(100, 100, 600, 600);

	}

}
