package cn.pwc.button.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JTabbedPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import cn.pwc.frame.MyTextFrame;
import cn.pwc.util.FileCheckUtil;
import cn.pwc.util.TXTOpenMethod;

/**
 * 自定义按钮点击事件监听器
 * 监听打开文件按钮
 * @author luoyefengqiao
 *
 */

public class MyOpenFileListener implements ActionListener{

	private JComponent component;
	private JTabbedPane tabbedPane;
	private List<MyTextFrame> myTextFrames;
	private JFileChooser fileChooser_open;
	private File file;
	public MyOpenFileListener(JComponent component,JTabbedPane tabbedPane,List<MyTextFrame> myTextFrames) {
		this.component=component;
		this.tabbedPane=tabbedPane;
		this.myTextFrames=myTextFrames;
		fileChooser_open=new JFileChooser();
		fileChooser_open.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		fileChooser_open.setAcceptAllFileFilterUsed(false);
		fileChooser_open.setFileFilter(new FileNameExtensionFilter("文本文件(.txt)", "txt"));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		fileChooser_open.showOpenDialog(component);
		
		file=fileChooser_open.getSelectedFile();
		
		file=FileCheckUtil.CheckOpenFile(file);
		
		if(file!=null&&file.exists())
		{
			MyTextFrame myTextFrame=new MyTextFrame();
			myTextFrames.add(myTextFrame);
			tabbedPane.addTab(file.getName(), myTextFrame);
			new Thread(new TXTOpenMethod(file, myTextFrame.getTextPane())).start();
		}
		
		
	}

}
