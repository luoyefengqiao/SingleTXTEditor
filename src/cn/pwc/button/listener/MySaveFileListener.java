package cn.pwc.button.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import cn.pwc.frame.MyTextFrame;
import cn.pwc.util.FileCheckUtil;
import cn.pwc.util.TXTSaveMethod;

/**
 * �Զ��尴ť����¼�������
 * ���������ļ���ť�¼�
 * @author luoyefengqiao
 *
 */

public class MySaveFileListener implements ActionListener{

	private JComponent component;
	private JTabbedPane tabbedPane;
	private List<MyTextFrame> myTextFrames;
	private JFileChooser fileChooser_save;
	private File file=null;
	
	public MySaveFileListener(JComponent component,JTabbedPane tabbedPane,List<MyTextFrame> myTextFrames) {
		this.component=component;
		this.tabbedPane=tabbedPane;
		this.myTextFrames=myTextFrames;
		fileChooser_save=new JFileChooser();
		fileChooser_save.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		fileChooser_save.setAcceptAllFileFilterUsed(false);
		fileChooser_save.setFileFilter(new FileNameExtensionFilter("�ı��ļ�(.txt)", "txt"));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		fileChooser_save.showSaveDialog(component);
		

		file=fileChooser_save.getSelectedFile();
		
		file=FileCheckUtil.CheckSaveFile(file);
		
		if (file!=null&&!file.exists()) {
			//��̨�߳�ִ�з�������ֹ���濨��
			new Thread(new TXTSaveMethod(file, myTextFrames.get(tabbedPane.getSelectedIndex()).getTextPane())).start();
		}
		if(file!=null&&file.exists()){
			JOptionPane.showMessageDialog(component, "����ʧ�ܣ��ļ��Ѵ��ڣ�");
		}
		
	}

}
