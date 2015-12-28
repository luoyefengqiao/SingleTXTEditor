package cn.pwc.frame;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;

/**
 * 自定义Frame继承JScrollPane（滚动条Pane）
 * @author luoyefengqiao
 *
 */

public class MyTextFrame extends JScrollPane{

	private static final long serialVersionUID = 3457865043647867318L;
	
	private JTextPane textPane;
	
	public MyTextFrame() {
		
		textPane=new JTextPane();
		setViewportView(textPane);
		
	}

	public JTextPane getTextPane() {
		return textPane;
	}
	
	

}
