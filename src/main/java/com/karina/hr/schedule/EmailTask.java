package com.karina.hr.schedule;

import com.karina.hr.model.Event;
import com.karina.hr.service.MailService;

import java.util.TimerTask;

public class EmailTask extends TimerTask {
    private final Event event;
    public EmailTask(Event event) {
        this.event=event;

    }

    @Override
    public void run() {
        //todo send email
        System.out.println(event);


    }
}
