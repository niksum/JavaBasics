package com.niksum.java.quartz.scheduling;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.KeyMatcher;

public class JobScheduler {
	public static void main(String[] args) throws Exception{
		System.out.println("**** Starting ***** ");
		JobKey jobKey = new JobKey("dummyJobName", "group1");
		
		JobDetail jobDetail = 
				JobBuilder.newJob(JobTodo.class)
				.withIdentity(jobKey)
				.build();
		
		Trigger trigger = 
				TriggerBuilder.newTrigger()
				.withIdentity("dummyTriggerName", "group1")
				.withSchedule(
						SimpleScheduleBuilder.simpleSchedule()
						.withIntervalInSeconds(1)
						.withRepeatCount(9))
						.build();
		
		jobDetail.getJobDataMap().put("name", "Test Map Data");
		
		SchedulerFactory factory = new StdSchedulerFactory();
		Scheduler sch = factory.getScheduler();
		sch.getListenerManager().addJobListener(new JobObserver(), KeyMatcher.keyEquals(jobKey));
		sch.start();
		sch.scheduleJob(jobDetail, trigger);		
		Thread.sleep(15000);
		System.out.println("**** Bye bye ***** ");
		sch.shutdown();
	}
}
