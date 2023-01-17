package org.sid.DAL;

import java.io.IOException;
import java.sql.SQLException;

import org.sid.DTO.event.Request.EventRequest;
import org.sid.connection.DBConnection;
import org.sid.repositories.EventsRepository;
import org.sid.utils.FunctionUtils;
import org.sid.entities.*;

import java.util.ArrayList;
import java.util.List;


public class EventsRepositoryImpl   extends RepositoryImplSuper<Event> implements EventsRepository{

    @Override
    public Boolean addEvent(EventRequest request) throws IOException, SQLException {
        try {
            this.dbConnection = new DBConnection() ; 
            this.query = "INSERT INTO events(event_title , event_description , event_date , event_local , event_filePath,event_fileExtension)"+
                         " VALUES (?,?,?,?,?)";
            this.statement = this.dbConnection.connect().prepareStatement(query);
            this.statement.setString(1, request.getEvent_title());
            this.statement.setString(2, request.getEvent_description());
            this.statement.setDate(  3, request.getEvent_date());
            this.statement.setString(4, request.getEvent_local());
            this.statement.setString(5, request.getEvent_filePath());
            this.statement.setString(6, request.getEvent_fileExtension());
            Boolean booleanResult = this.statement.execute();
            return booleanResult ; 
        }catch(Exception e )
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Event getEvent(Integer event_id) throws IOException, SQLException {
        try {
            this.dbConnection = new DBConnection() ; 
            this.query = " SELECT e.event_id , e.event_title , e.event_description , e.event_date ,e.event_local , e.event_filePath , e.event_fileExtension"+
                         " FROM events e" + 
                         " WHERE e.event_id ="+event_id ;
            this.statement = this.dbConnection.connect().prepareStatement(query);
            this.resultSet = this.statement.executeQuery();
            this.t = null ;
            while(this.resultSet.next())
            {
                this.t = FunctionUtils.extractInformationEventFromResultSet(resultSet);
            }
            return this.t;
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Event> getEvents() throws IOException, SQLException {
        try {
            this.dbConnection = new DBConnection() ; 
            this.query = " SELECT e.event_id , e.event_title , e.event_description , e.event_date ,e.event_local"+
                         " FROM events e" ;
            this.statement = this.dbConnection.connect().prepareStatement(query);
            this.resultSet = this.statement.executeQuery();
            this.list_t  = new ArrayList<Event>();
            this.t = null ;
            while(this.resultSet.next())
            {
                this.t = FunctionUtils.extractInformationEventFromResultSet(resultSet);
                this.list_t.add(t);
            }
            return this.list_t;
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean updateEvent(Event eventUpdate) throws IOException, SQLException {
        try {
            this.dbConnection = new DBConnection() ; 
            this.query = " UPDATE events  " +
            " SET event_title = ?  , event_description = ? , event_date = ? , event_local = ?  , event_filePath = ? , event_fileExtension = ?" + 
            " WHERE event_id =  ? ";
            this.statement = this.dbConnection.connect().prepareStatement(query);
            this.statement.setString(1, eventUpdate.getEvent_title());
            this.statement.setString(2, eventUpdate.getEvent_description());
            this.statement.setDate(3, eventUpdate.getEvent_date());
            this.statement.setString(4,eventUpdate.getEvent_local());
            this.statement.setString(5,eventUpdate.getEvent_filePath());
            this.statement.setString(6,eventUpdate.getEvent_fileExtension());
            this.statement.setInt(7,eventUpdate.getEvent_id());
            Boolean booleanResult = this.statement.execute();
            return booleanResult;
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean deleteEvent(Integer event_id) throws IOException, SQLException {
        try {
            this.dbConnection = new DBConnection() ; 
            this.query = "DELETE FROM events WHERE event_id="+event_id; 
            this.statement = this.dbConnection.connect().prepareStatement(query);
            Boolean booleanResult = this.statement.execute() ; 
            return booleanResult ; 
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean deleteFile(Integer event_id) throws IOException, SQLException {
        try {
            this.dbConnection = new DBConnection() ; 
            this.query = "UPDATE events"+
            " SET  event_filePath=?   " +
            " WHERE event_id=?" ;
            this.statement = this.dbConnection.connect().prepareStatement(query);
            this.statement.setString(1, null);
            this.statement.setInt(2 , event_id);
            Boolean booleanResult = this.statement.execute();
            return booleanResult;
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    

    
    
}
