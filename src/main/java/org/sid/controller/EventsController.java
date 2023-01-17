package org.sid.controller;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import jakarta.servlet.annotation.MultipartConfig;

import org.sid.DTO.UtilsClass.FileUtil;
import org.sid.DTO.event.Request.EventRequest;
import org.sid.entities.Event;
import org.sid.map.Mapper;
import org.sid.services.event.EventService;
import org.sid.services.files.FileService;
import org.sid.utils.KeyUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig
@WebServlet(name = "StudentController",
            value = {"/events" , "/event" , "/edit_event" , "/add_event" , "/delete_Eventfile"})
public class EventsController  extends  SupperController {
    
    private EventService eventService ; 
    private Mapper mapper ; 
    private FileService fileService ; 

    public EventsController()
    {
        this.eventService = this.getEventServiceInstance() ; 
        this.mapper = this.getMapperInstance();
        this.fileService = this.getFileServiceInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        System.out.println("im in post method  , and the action => " + action);
        switch(action)
        {
            case "post_event" : postEvent(req,resp);break ; 
            case "update_event" : updateEvent(req,resp);break ; 
            case "delete_event" : deleteEvent(req,resp);break ; 
            default : break ; 
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String action = req.getServletPath() ; 
        System.out.println("im in get  method  , and the action => " + action);

        switch(action)
        {
            case "/events" : getEvents(req,resp);break ; 
            case "/event"  : getEvent(req,resp);break ; 
            case "/add_event" : getAddEvent(req,resp);break ; 
            case "/edit_event" : getEditEvent(req,resp);break ; 
            case "/delete_Eventfile" : deleteFile(req,resp);break ; 
            default : break ; 
        }
    }

    // ******************************** GET METHODS ******************************** //
    
    private void getAddEvent(HttpServletRequest req , HttpServletResponse resp) throws ServletException , IOException{
        req.getRequestDispatcher("vues/dashboard/evenements/AddEvents.jsp").forward(req, resp);
    }

    private void getEditEvent(HttpServletRequest req , HttpServletResponse resp) throws ServletException , IOException{
        try {
            System.out.println("here in edti event ");
            Integer event_id = Integer.parseInt(req.getParameter("event_id"));
            Event event = this.eventService.getEvent(event_id);
            req.setAttribute("event", event);
            req.getRequestDispatcher("vues/dashboard/evenements/EditEvent.jsp").forward(req, resp);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    private void getEvents(HttpServletRequest req , HttpServletResponse resp) throws ServletException , IOException{
        try {
            List<Event> events = this.eventService.getEvents();
            req.setAttribute("events", events);
            req.getRequestDispatcher("vues/dashboard/evenements/Events.jsp").forward(req, resp);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    private void getEvent(HttpServletRequest req , HttpServletResponse resp) throws ServletException , IOException{
        try {
            Integer event_id = Integer.parseInt(req.getParameter("event_id"));
            System.out.println("this is the id =>" + event_id);
            Event event  = this.eventService.getEvent(event_id);
            System.out.println("this is the event =>" + event);
            req.setAttribute("event", event);
            req.getRequestDispatcher("vues/dashboard/evenements/EventInformations.jsp").forward(req, resp);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    private void deleteFile(HttpServletRequest req , HttpServletResponse resp) throws ServletException , IOException{
        try {
            Integer event_id = Integer.parseInt(req.getParameter("event_id"));
            Boolean booleanResult = this.eventService.deleteFile(event_id);
            resp.sendRedirect(KeyUtils.PREFIX_REDIRECTING+"edit_event?event_id="+event_id);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    // ******************************** POST METHODS ******************************* //
    
    private void postEvent(HttpServletRequest req , HttpServletResponse resp) throws ServletException , IOException{
        try{
            System.out.println("----- IN CLASS EVENTS CONTROLLER ---- ");
            Part filePart = req.getPart("event_file");
            FileUtil fileUtil = this.fileService.uploadFileEvent(filePart, KeyUtils.UPLOAD_EVENTS_PATH);
            EventRequest eventRequest = this.mapper.mapRequestToEventRequest(req);
            eventRequest.setEvent_filePath(fileUtil.getFile_path());
            eventRequest.setEvent_fileExtension(fileUtil.getFile_extension());
            Boolean booleanResult = this.eventService.addEvent(eventRequest);
            resp.sendRedirect(KeyUtils.PREFIX_REDIRECTING+"events");
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    private void updateEvent(HttpServletRequest req , HttpServletResponse resp) throws ServletException , IOException{
        try{
            Event event = this.mapper.mapRequestToEventEntity(req);
            Part part = req.getPart("file");
            if(!Objects.isNull(part))
            {
                System.out.println("the part is not null ! => this is the name : " + part.getSubmittedFileName());
                FileUtil fileUtil = this.fileService.uploadFileEvent(part, KeyUtils.UPLOAD_EVENTS_PATH );
                event.setEvent_filePath(fileUtil.getFile_path());
                event.setEvent_fileExtension(fileUtil.getFile_extension());
                System.out.println("the file util => " + fileUtil);
            }
            else {
                System.out.println("the part is not null !");
            }
            Boolean booleanResult = this.eventService.updateEvent(event);
            resp.sendRedirect(KeyUtils.PREFIX_REDIRECTING+"event?id="+event.getEvent_id());
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    private void deleteEvent(HttpServletRequest req , HttpServletResponse resp) throws ServletException , IOException{
        try {
            Integer event_id = Integer.parseInt(req.getParameter("event_id"));
            Boolean booleanResult = this.eventService.deleteEvent(event_id);
            resp.sendRedirect(KeyUtils.PREFIX_REDIRECTING+"/events");
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
