package org.sid.services.event;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.sid.DTO.event.Request.EventRequest;
import org.sid.entities.Event;
import org.sid.repositories.EventsRepository;
import org.sid.services.SupperService;

public class EventServiceImpl implements EventService {

    private EventsRepository eventsRepository ; 
    public EventServiceImpl() {
        eventsRepository = SupperService.getEventsRepositoryInstance();
    }

    @Override
    public Boolean addEvent(EventRequest request) throws IOException, SQLException {
        Boolean booleanResult = this.eventsRepository.addEvent(request);
        return booleanResult;
    }

    @Override
    public Event getEvent(Integer event_id) throws IOException, SQLException {
        Event event = this.eventsRepository.getEvent(event_id);
        return event;
    }

    @Override
    public List<Event> getEvents() throws IOException, SQLException {
        List<Event> events = this.eventsRepository.getEvents();
        return events;
    }

    @Override
    public Boolean updateEvent(Event eventUpdate) throws IOException, SQLException {
        Boolean booleanResult = this.eventsRepository.updateEvent(eventUpdate);
        return booleanResult;
    }

    @Override
    public Boolean deleteEvent(Integer event_id) throws IOException, SQLException {
        boolean booleanResult = this.eventsRepository.deleteEvent(event_id);
        return booleanResult;
    }

    @Override
    public Boolean deleteFile(Integer event_id) throws IOException, SQLException {
        boolean booleanResult = this.eventsRepository.deleteFile(event_id);
        return null;
    }
    
}
