package com.cyb.pc.event;

import javax.swing.JFrame;

import com.cyb.pc.Contants;

public class BaseEvent {
	public void refresh(JFrame window){
		window.pack();
		window.setBounds(0, 0, Contants.width, Contants.height*95/100);
	}
}
