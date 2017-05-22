package com.niksum.java.quartz.scheduling;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


public class JobTodo implements Job{
	public static int count = 0;
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		count++;
		JobDataMap map = arg0.getJobDetail().getJobDataMap();
		String name = map.getString("name");
		System.out.println("starting the job "+name + " . Count is "+count);
		try {
			System.out.println(" >>>>> Going to sleep <<<<<< ");
			Thread.sleep(3000);
			System.out.println(" >>>>> Wakeing <<<<<< ");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		
//		System.out.println("finishing the job "+name);
//		map.put("output", "output1");
	}

}
