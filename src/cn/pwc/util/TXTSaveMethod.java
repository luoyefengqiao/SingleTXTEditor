package cn.pwc.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.JTextPane;


/**
 * TXT输出流方法类
 * 继承Runnable接口允许后台线程执行方法
 * @author luoyefengqiao
 *
 */
public class TXTSaveMethod implements Runnable{

	private JTextPane textPane;
	private File file;
	public TXTSaveMethod(File file,JTextPane textPane) {
		this.textPane=textPane;
		this.file=file;
	}
	
	@Override
	public void run() {
		
		FileOutputStream outputStream=null;
		OutputStreamWriter outputStreamWriter=null;
		BufferedWriter bufferedWriter=null;
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			outputStream=new FileOutputStream(file);
			outputStreamWriter=new OutputStreamWriter(outputStream, "utf-8");
			bufferedWriter=new BufferedWriter(outputStreamWriter);
			
			bufferedWriter.write(textPane.getText());
			bufferedWriter.flush();
			bufferedWriter.close();
			outputStreamWriter.close();
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
