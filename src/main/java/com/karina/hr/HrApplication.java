package com.karina.hr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

@SpringBootApplication
public class HrApplication {

	public static void main(String[] args) throws IllegalArgumentException ,IllegalStateException,NumberFormatException {
		SpringApplication.run(HrApplication.class, args);
		LocalDateTime time= LocalDateTime.now();

//		Date d = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(s);
//
//		Timer timer=new Timer("timer");
//		timer.schedule(new TimerTask() {
//			@Override
//			public void run() {
//				System.out.println("timer is running"+time);
//
//			}
//		}, Long.parseLong("2019-10-30T11:54:00"));

	}
	}

