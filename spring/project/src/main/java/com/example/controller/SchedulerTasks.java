package com.example.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerTasks {

	//스케줄러
//	 @Scheduled(cron = "*/5 * * * * *")
//	    public void firstTask() {
//	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//	        Date now = new Date();
//	        String strDate = sdf.format(now);
//	        System.out.println("현재시간:  " + strDate);
//	        System.out.println("5초");
//	    }
}
