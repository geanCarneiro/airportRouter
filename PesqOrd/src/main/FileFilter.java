package main;

import java.io.File;
import java.io.FilenameFilter;

public class FileFilter implements FilenameFilter{

	@Override
	public boolean accept(File arg0, String arg1) {
		// TODO Auto-generated method stub
		return arg1.endsWith(".txt");
	}

	

}
