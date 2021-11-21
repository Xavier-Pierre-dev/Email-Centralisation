package com.mycompany.app;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class JobMail1 implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		
		System.out.println("JobMail.java --->>> Time is : " + new Date());
		
		/**
		 * Utility method to send simple HTML email
		 * @param session
		 * @param toEmail => msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
		 * @param subject => msg.setSubject(subject, "UTF-8");
		 * @param body => msg.setText(body, "UTF-8");
		 * 
		 * Use to generate => Transport.send(msg); 
		 *  
		 */
		String sendTo = "Email";
		EmailUtil.sendEmail(sendTo,
				"Email Testing JobMail1 with simple time scheduler trigger", 
				"Email Testing Body : This mail will every 2min after the execution of the program");
		
	}

	
}
