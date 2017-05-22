package com.niksum.java.quartz.scheduling;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class Painter implements Job {

	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("Painter Job to execute --> " + context.getJobDetail().getKey().toString());
	}
}
