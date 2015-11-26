package cn.pwc.enter;

import java.awt.EventQueue;

import cn.pwc.frame.StartFrame;

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
