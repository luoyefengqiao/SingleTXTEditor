package cn.pwc.util;

import java.io.File;

/**
 * �ļ���У�鷽��
 * @author luoyefengqiao
 *
 */

public class FileCheckUtil {
	
	/*
	 * �򿪵��ļ���׺У��
	 */
	public static File CheckOpenFile(File file){
		String checkString;
		
		if (file==null) {
			return null;
		}
		
		checkString=file.getName();
		if(checkString.indexOf(".txt")==-1)
		{
			return null;
		}
		
		return file;
	}
	
	/*
	 * ������ļ���׺У�飬�Զ�����.txt
	 */
	public static File CheckSaveFile(File file){
		String checkString;
		
		if (file==null) {
			return null;
		}
		
		checkString=file.getName();
		if (checkString.indexOf(".txt")==-1) {
			return new File(file.getAbsolutePath()+".txt");
		}
		
		return file;
	}
}
