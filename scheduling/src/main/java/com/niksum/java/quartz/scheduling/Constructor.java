package com.niksum.java.quartz.scheduling;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class Constructor implements Job {

	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("Constructor Job to execute --> " + context.getJobDetail().getKey().toString());
	}
}