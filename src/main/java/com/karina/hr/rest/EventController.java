package com.karina.hr.rest;

import com.karina.hr.model.Event;
import com.karina.hr.service.EventService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Collections;
import java.util.List;

@RestController()
public class EventController {
    @Autowired
    EventService eventService;


    @GetMapping(path = "/events" , produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Event> getEvents() {
        return eventService.findAllEvents() ;
    }

    @GetMapping(path = "/events/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Event getEvent(@PathVariable(value = "id") Long eventId) {
        return eventService.findEventByID(eventId);
    }

    @PostMapping(path = "/events", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Event createEvent(@RequestBody Event event) {
        return eventService.insertEvent(event);
    }

    @ApiOperation(value = "Remove an event by specified ID")
    @DeleteMapping(path = "/events/{id}")
    public void removeEvent(@PathVariable(value = "id") Long eventId) {
        eventService.deleteEvent(eventId);
    }

    @ApiOperation(value = "edit and update event")
    @PutMapping(path ="/events"  )
    public Event editEvent(@RequestBody Event event){
        return eventService.editEvent(event);
    }
}
