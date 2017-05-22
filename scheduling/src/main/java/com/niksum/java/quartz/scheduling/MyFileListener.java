package com.niksum.java.quartz.scheduling;

import java.io.File;
import java.sql.Timestamp;

public class MyFileListener implements org.quartz.jobs.FileScanListener{
	
	public void fileUpdated(String fileName) {
		File file  = new File(fileName);
		Timestamp time = new Timestamp(file.lastModified());
		System.out.println(file.getName() + " file has been modified @ " +time);
	}
}
