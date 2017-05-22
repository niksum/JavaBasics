package com.niksum.java.quartz.scheduling;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

public class JobObserver implements JobListener{
	private static final String jobObs = "JOB_OBSERVER";
	
	public String getName() {
		return jobObs;
	}

	public void jobToBeExecuted(JobExecutionContext context) {
		System.out.println(jobObs + " listened to the execution start request for JobName --> "+ context.getJobDetail().getKey().toString());
	}

	public void jobExecutionVetoed(JobExecutionContext context) {
		System.out.println(jobObs + " listened to the vetoed of JobName --> "+ context.getJobDetail().getKey().toString());
		
	}

	public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
		System.out.println(jobObs + " listened to the execution stop request for JobName --> "+ context.getJobDetail().getKey().toString());
	}

}
