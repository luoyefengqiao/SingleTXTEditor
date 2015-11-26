package cn.pwc.util;

import java.io.File;

public class FileCheckUtil {
	
	
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
