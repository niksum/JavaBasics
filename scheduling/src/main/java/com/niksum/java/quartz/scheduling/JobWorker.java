package com.niksum.java.quartz.scheduling;

import java.util.ArrayList;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;



public class JobWorker {
	public static void main(String[] args) throws Exception{
		JobKey painterJobKey = new JobKey("Painter Key", "Worker Group");
		JobKey electricianJobKey = new JobKey("Electrician Key", "Worker Group");
		JobKey donstructorJobKey = new JobKey("Constructor Key", "Worker Group");
		
		JobKey[] jobKeyArr = {painterJobKey, electricianJobKey, donstructorJobKey};
		JobDetail[] jobDetailArr = new JobDetail[3];
		
		
		Trigger[] triggerArr = new Trigger[3];
		TriggerKey[] triggerKeyArr = {new TriggerKey("Painter trigger Key", "Worker Group"),
				new TriggerKey("Electrician trigger Key", "Worker Group"),
				new TriggerKey("Constructor trigger Key", "Worker Group")};
		

		
		List<Class<? extends Job>> jobClzList = new ArrayList();
		jobClzList.add(Painter.class);
		jobClzList.add(Electrician.class);
		jobClzList.add(Constructor.class);
		
		Scheduler sch = new StdSchedulerFactory().getScheduler();
		sch.start();
		
		for (int i = 0; i < jobDetailArr.length; i++) {
			jobDetailArr[i] = JobBuilder.newJob(jobClzList.get(i))
					.withIdentity(jobKeyArr[i])
					.build();
			
			triggerArr[i] = TriggerBuilder.newTrigger()
					.withIdentity(triggerKeyArr[i])
					.withSchedule(SimpleScheduleBuilder.simpleSchedule()
							.withIntervalInSeconds(1)
							.repeatForever())
					.build();
			
			sch.scheduleJob(jobDetailArr[i], triggerArr[i]);
		}
		
		Thread.sleep(5000);
		sch.shutdown();
	}
}
