package com.niksum.java.quartz.scheduling;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.jobs.FileScanJob;

public class FileUpdateSchedular {
	public static void main(String[] args) {
		try {
			JobKey jobKey = new JobKey("FileScanJobNik", "group1");
			Scheduler sch = new StdSchedulerFactory().getScheduler();
			
			JobDetail jd = JobBuilder.newJob(FileScanJob.class).withIdentity(jobKey).build();
			
			Trigger trigr = TriggerBuilder.newTrigger().withIdentity("FileScanTriggerNik","group1")
					.withSchedule(SimpleScheduleBuilder.simpleSchedule()
							.withIntervalInSeconds(10))
					.build();

//			JobDataMap data = new JobDataMap();
//			data.put(FileScanJob.FILE_NAME, "C:\\summi\\test\\todo.txt");
//			data.put(FileScanJob.FILE_SCAN_LISTENER_NAME, "listener");

			jd.getJobDataMap().put(FileScanJob.FILE_NAME, "C:/summi/test/todo.txt");
			jd.getJobDataMap().put(FileScanJob.FILE_SCAN_LISTENER_NAME, "listener");

//			sch.getListenerManager().addJobListener(new MyFileListener(), KeyMatcher.keyEquals(jobKey));
			sch.getContext().put("listener", new MyFileListener());
			
			sch.start();
			sch.scheduleJob(jd, trigr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
