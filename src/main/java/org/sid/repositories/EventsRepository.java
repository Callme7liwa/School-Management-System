package org.sid.repositories;

import java.io.IOException;
import java.sql.SQLException;

import org.sid.DTO.event.Request.EventRequest;
import org.sid.entities.Event;
import java.util.List;
public interface EventsRepository {
    
    Boolean addEvent(EventRequest request)  throws IOException, SQLException;

    Event getEvent(Integer event_id) throws IOException, SQLException;

    List<Event> getEvents()throws IOException, SQLException;

    Boolean updateEvent(Event eventUpdate)throws IOException, SQLException;

    Boolean deleteEvent(Integer event_id) throws IOException, SQLException;

    Boolean deleteFile(Integer event_id)throws IOException, SQLException;   


}
