package me.pwcong.enter;

import java.awt.EventQueue;

import me.pwcong.frame.StartFrame;

public class Start {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new StartFrame().setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
