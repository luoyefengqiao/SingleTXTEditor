package cn.pwc.util;

import java.io.File;

/**
 * 文件名校验方法
 * @author luoyefengqiao
 *
 */

public class FileCheckUtil {
	
	/*
	 * 打开的文件后缀校验
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
	 * 保存的文件后缀校验，自动加上.txt
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
