package org.sid.controller;

import jakarta.servlet.http.HttpServlet;
import org.sid.map.Mapper;
import org.sid.map.MapperImpl;
import org.sid.services.FreelancerService;
import org.sid.services.FreelancerServiceImpl;
import org.sid.services.absence.AbsenceService;
import org.sid.services.absence.AbsenceServiceImpl;
import org.sid.services.authentication.AuthenticationService;
import org.sid.services.authentication.AuthenticationServiceImpl;
import org.sid.services.event.EventService;
import org.sid.services.event.EventServiceImpl;
import org.sid.services.files.FileService;
import org.sid.services.files.FileServiceImpl;
import org.sid.services.filiere.FieldService;
import org.sid.services.filiere.FieldServiceImpl;
import org.sid.services.group.GroupService;
import org.sid.services.group.GroupServiceImpl;
import org.sid.services.modul.ModuleService;
import org.sid.services.modul.ModuleServiceImpl;
import org.sid.services.professor.ProfessorService;
import org.sid.services.professor.ProfessorServiceImpl;
import org.sid.services.student.StudentService;
import org.sid.services.student.StudentServiceImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public abstract  class SupperController extends HttpServlet {

    static private AuthenticationService authenticationService ;
    static private FreelancerService freelancerService ;
    static private StudentService studentService ;
    static private ProfessorService professorService ;
    static private ModuleService moduleService ;
    static private GroupService groupService ;
    static private FieldService fieldService ;
    static private AbsenceService absenceService ;
    static private FileService fileService ; 
    static private Mapper mapper;
    static private EventService eventService ; 

    public static EventService getEventServiceInstance() {
        if(eventService == null)
            eventService = new EventServiceImpl();
        return eventService;
    }

    public static AuthenticationService getAuthenticationServiceInstance() {
        if(authenticationService == null)
            authenticationService = new AuthenticationServiceImpl();
        return authenticationService;
    }

    public static FileService getFileServiceInstance()
    {
        if(fileService == null)
            fileService = new FileServiceImpl();
        return fileService;
    }

    public static Mapper getMapperInstance() {
        if(mapper == null)
            mapper = new MapperImpl();
        return mapper;
    }

    public static StudentService getStudentServiceInstance()
    {
        if(Objects.isNull(studentService))
            studentService = new StudentServiceImpl();
        return studentService ;
    }
    public static ProfessorService getProfessorServiceInstance()
    {
        if(Objects.isNull(professorService))
            professorService = new ProfessorServiceImpl();
        return professorService ;
    }
    public static FieldService getFieldServiceInstance()
    {
        if(Objects.isNull(fieldService))
            fieldService = new FieldServiceImpl();
        return fieldService ;
    }
    public static GroupService getGroupServiceInstance()
    {
        if(Objects.isNull(groupService))
            groupService = new GroupServiceImpl();
        return groupService ;
    }
    public static ModuleService getModuleServiceInstance()
    {
        if(Objects.isNull(moduleService))
            moduleService = new ModuleServiceImpl();
        return moduleService ;
    }
    public static AbsenceService getAbsenceServiceInstance()
    {
        if(Objects.isNull(absenceService))
            absenceService = new AbsenceServiceImpl();
        return absenceService ;
    }
    public FreelancerService getFreelancerService() throws SQLException, IOException {
        if(freelancerService == null)
            freelancerService = new FreelancerServiceImpl() ;
        return freelancerService;
    }


}
