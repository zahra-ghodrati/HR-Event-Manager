package com.karina.hr.service;

import com.karina.hr.model.Employee;
import com.karina.hr.model.Event;
import com.karina.hr.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {
    @Autowired
    EventRepository eventRepository;

    @Autowired
    MailService mailService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    private NotifyService notifyService;


    public List<Event> findAllEvents() {
        return eventRepository.findAll();
    }

    public Event findEventByID(Long eventID) {
        return eventRepository.findById(eventID).get();
    }

    public void deleteEvent(Long eventID) {
        eventRepository.deleteById(eventID);
    }

    public Event insertEvent(Event event) {
        List<String> emails = new ArrayList<>();
        eventRepository.save(event);

//        List<Employee> employeeList = employeeService.findAllEmploees();
//        for (Employee employee : employeeList) {
//            if (!StringUtils.isEmpty(employee.getEmail()))
//                emails.add(employee.getEmail());
//        }
//
//        mailService.sendEmail(emails.toArray(new String[emails.size()]), event.getName(), event.getDateTime().toString());

        notifyService.schedule(event);

        return event;
    }

    public Event editEvent(Event event) {
        event= eventRepository.save(event);
        notifyService.updateSchedule(event);
        return event;
    }
}
