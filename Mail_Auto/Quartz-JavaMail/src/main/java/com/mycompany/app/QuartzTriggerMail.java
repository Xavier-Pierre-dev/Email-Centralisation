package com.mycompany.app;


import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzTriggerMail {

	public static void main(String[] args) throws SchedulerException, InterruptedException {
		// TODO Auto-generated method stub
		

		
		
		
		//cron expression was obtained using this website : http://www.cronmaker.com/;jsessionid=node0r3gw7ng10mapv05i2tszu36l2090433.node0?0
		//other website for cron expression https://www.freeformatter.com/cron-expression-generator-quartz.html this one can describe when will be trigger the cron job
		//Note that you need to have separate job, trigger and scheduler if you want perform multiple cronjob in same time
		JobDetail jobCron = JobBuilder.newJob(JobMail1.class).build();
		
		//Trigger t1Cron = TriggerBuilder.newTrigger().withIdentity("CronTrigger").withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * 1/1 * ? *")).build();
		Trigger t1Cron = TriggerBuilder.newTrigger().withIdentity("CronTrigger").withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(120).repeatForever()).build();
		
		Scheduler scCron = StdSchedulerFactory.getDefaultScheduler();
		scCron.start();
		scCron.scheduleJob(jobCron, t1Cron);
		
		//5 minute run before shutdown 
		//1000ms x 60 x 5 = 1s x 60 x 5 = 1min x 5 = 5min
		Thread.sleep(1000 * 60 * 5);
		scCron.shutdown();

	}
}

