package cn.pwc.frame;

import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import cn.pwc.button.listener.MyOpenFileListener;
import cn.pwc.button.listener.MySaveFileListener;
import cn.pwc.pane.ClosableTabbedPane;

public class StartFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6706812291609226576L;
	
	private List<MyTextFrame> myTextFrames=new ArrayList<>();
	
	private JMenuItem menuItem_save;

	/**
	 * Create the frame.
	 */
	public StartFrame() {
		setTitle("简易记事本");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 150, 600, 400);
		
		
		
		/**
		 * init_TabbedPane
		 */
		JTabbedPane textOpenTabList=new ClosableTabbedPane(){
			public boolean tabAboutToClose(int tabIndex) {
				
				myTextFrames.remove(tabIndex);
				
				//判断集合长度，若集合为空，则保存按钮失效
				if (myTextFrames.size()<=0) {
					menuItem_save.setEnabled(false);
				}
				else {
					menuItem_save.setEnabled(true);
				}
				
				return true; 
			}
			
		};
		
		MyTextFrame myTextFrame=new MyTextFrame();
		myTextFrames.add(myTextFrame);
		textOpenTabList.addTab("新文本", myTextFrame);
		getContentPane().add(textOpenTabList);
		
		/**
		 * init_Menu
		 */
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu menu_file = new JMenu("\u6587\u4EF6");
		menuBar.add(menu_file);
		JMenuItem menuItem_new = new JMenuItem("\u65B0\u5EFA");
		menuItem_new.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MyTextFrame myTextFrame=new MyTextFrame();
				myTextFrames.add(myTextFrame);
				textOpenTabList.addTab("新文本", myTextFrame);
				
				//判断集合长度，若集合不为空，则保存按钮恢复功能
				if (myTextFrames.size()>0) {
					menuItem_save.setEnabled(true);
				}
			}
		});
		menu_file.add(menuItem_new);


		JMenuItem menuItem_open = new JMenuItem("\u6253\u5F00");
		menuItem_open.addActionListener(new MyOpenFileListener(menuItem_open, textOpenTabList,myTextFrames));
		menu_file.add(menuItem_open);
		menuItem_save = new JMenuItem("\u4FDD\u5B58");
		menuItem_save.addActionListener(new MySaveFileListener(menuItem_save, textOpenTabList,myTextFrames));
		menu_file.add(menuItem_save);
		
		JMenu menu_help = new JMenu("\u5E2E\u52A9");
		menuBar.add(menu_help);
		JMenuItem menuItem_about = new JMenuItem("\u5173\u4E8E");
		menuItem_about.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(menuItem_about, "POWERED BY 落叶枫桥");
			}
		});
		menu_help.add(menuItem_about);
		
	}
	
}
