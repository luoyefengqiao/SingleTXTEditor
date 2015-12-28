package cn.pwc.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JTextPane;

/**
 * TXT文件输入流方法类
 * 继承Runnable接口允许后台线程执行方法
 * @author luoyefengqiao
 *
 */

public class TXTOpenMethod implements Runnable{
	private JTextPane textPane;
	private File file;
	public TXTOpenMethod(File file,JTextPane textPane) {
		this.file=file;
		this.textPane=textPane;
	}
	@Override
	public void run() {
		
		FileInputStream inputStream=null;
		InputStreamReader inputStreamReader=null;
		BufferedReader bufferedReader=null;
		try {
			inputStream=new FileInputStream(file);
			inputStreamReader=new InputStreamReader(inputStream, "utf-8");
			bufferedReader=new BufferedReader(inputStreamReader);
			
			StringBuilder stringBuilder=new StringBuilder();
			String string;
			while((string=bufferedReader.readLine())!=null){
				stringBuilder.append(string);
				stringBuilder.append("\n");
			}
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			textPane.setText(stringBuilder.toString());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	

}
