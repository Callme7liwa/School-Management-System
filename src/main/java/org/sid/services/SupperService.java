package org.sid.services;

import java.util.Objects;

import org.sid.DAL.AbsenceRepositoryImpl;
import org.sid.DAL.EventsRepositoryImpl;
import org.sid.DAL.FieldRepositoryImpl;
import org.sid.DAL.GroupRepositoryImpl;
import org.sid.DAL.ModuleRepositoryImpl;
import org.sid.DAL.ProfessorRepositoryImpl;
import org.sid.DAL.StudentRepositoryImpl;
import org.sid.repositories.AbsenceRepository;
import org.sid.repositories.EventsRepository;
import org.sid.repositories.FieldRepository;
import org.sid.repositories.GroupRepository;
import org.sid.repositories.ModuleRepository;
import org.sid.repositories.ProfessorRepository;
import org.sid.repositories.StudentRepository;

public class SupperService {

    static private StudentRepository studentRepository ;
    static private ProfessorRepository professorRepository ;
    static private ModuleRepository moduleRepository ;
    static private GroupRepository groupRepository ;
    static private FieldRepository fieldRepository ;
    static private AbsenceRepository absenceRepository ;
    static private EventsRepository eventsRepository ; 


    public static EventsRepository getEventsRepositoryInstance()
    {
        if(Objects.isNull(eventsRepository))
            eventsRepository = new EventsRepositoryImpl();
        return eventsRepository ;
    }
    public static StudentRepository getStudentRepositoryInstance()
    {
        if(Objects.isNull(studentRepository))
            studentRepository = new StudentRepositoryImpl();
        return studentRepository ;
    }
    public static ProfessorRepository getProfessorRepositoryInstance()
    {
        if(Objects.isNull(professorRepository))
            professorRepository = new ProfessorRepositoryImpl();
        return professorRepository ;
    }
    public static ModuleRepository getModuleRepositoryInstance()
    {
        if(Objects.isNull(moduleRepository))
            moduleRepository = new ModuleRepositoryImpl();
        return moduleRepository ;
    }
    public static FieldRepository getFieldRepositoryInstance()
    {
        if(Objects.isNull(fieldRepository))
            fieldRepository = new FieldRepositoryImpl();
        return fieldRepository ;
    }
    public static AbsenceRepository getAbsenceRepositoryInstance()
    {
        if(Objects.isNull(groupRepository))
            absenceRepository = new AbsenceRepositoryImpl();
        return absenceRepository ;
    }
    public static GroupRepository getGroupRepositoryInstance()
    {
        if(Objects.isNull(groupRepository))
            groupRepository = new GroupRepositoryImpl();
        return groupRepository ;
    }
    
}
