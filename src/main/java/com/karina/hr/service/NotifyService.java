package com.karina.hr.service;

import com.karina.hr.model.Event;
import com.karina.hr.schedule.EmailTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

@Service
public class NotifyService {
    @Autowired
    private MailService mailService;

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    private Map<Long, Timer> timerMap = new HashMap<>();

    public void schedule(Event event) {
        Date thirtyMinutesBefore = convert(event.getDateTime().minus(1, ChronoUnit.MINUTES));
        getTimer(event).schedule(new EmailTask(event), thirtyMinutesBefore);
    }

    public void updateSchedule(Event event) {
        if (event.getDateTime() != null) {

            Date thirtyMinutesBefore = convert(event.getDateTime().minus(1, ChronoUnit.MINUTES));
            Timer timer = getTimer(event);
            timer.cancel();
            timer.purge();
            timer.schedule(new EmailTask(event),thirtyMinutesBefore);
        }


    }

    private Timer getTimer(Event event) {
        return timerMap.computeIfAbsent(event.getId(), k -> new Timer("NotifyServiceTimer", true));

    }

    private Date convert(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
