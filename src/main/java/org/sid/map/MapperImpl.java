package org.sid.map;

import jakarta.servlet.http.HttpServletRequest;

import java.sql.Date;

import org.sid.DTO.absence.Request.DeleteAbsenceRequest;
import org.sid.DTO.absence.Request.NewAbsenceRequest;
import org.sid.DTO.authentication.AuthenticationRequest;
import org.sid.DTO.event.Request.EventRequest;
import org.sid.DTO.field.request.FieldSaveRequest;
import org.sid.DTO.field.request.FieldUpdateRequest;
import org.sid.DTO.group.request.AddDocRequest;
import org.sid.DTO.group.request.AddModulGroupReq;
import org.sid.DTO.group.request.AddProfessorGroupRequest;
import org.sid.DTO.group.request.AffectationModulRequest;
import org.sid.DTO.group.request.GroupSaveDtoReq;
import org.sid.DTO.mark.Request.EditMarkRequest;
import org.sid.DTO.mark.Request.UpdateMarkRequest;
import org.sid.DTO.modul.Request.CreateModulDto;
import org.sid.DTO.student.request.StudentRequest;
import org.sid.DTO.student.request.UpdatePersonnalStudent;
import org.sid.entities.Event;

public class MapperImpl  implements  Mapper{

    @Override
    public AuthenticationRequest mapRequestToAuthenticateReq(HttpServletRequest request) {
            AuthenticationRequest authenticationRequest = new AuthenticationRequest() ;
            authenticationRequest.setEmail(request.getParameter("email"));
            authenticationRequest.setPassword(request.getParameter("password"));
            return authenticationRequest ;
    }

    @Override
    public NewAbsenceRequest mapRequestToNewAbsenceReq(HttpServletRequest request) {
        Integer student_id = Integer.parseInt(request.getParameter("student_id"));
        Integer modul_id = Integer.parseInt(request.getParameter("modul_id"));
        Integer absence_hours = Integer.parseInt(request.getParameter("absence_hours"));
        String absence_date = request.getParameter("absence_date");
        NewAbsenceRequest newAbsenceRequest = new NewAbsenceRequest() ; 
        newAbsenceRequest.setStudent_id(student_id);
        newAbsenceRequest.setModul_id(modul_id);
        newAbsenceRequest.setAbsence_hours(absence_hours);
        newAbsenceRequest.setAbsence_date(absence_date);
        return newAbsenceRequest;
    }

    @Override
    public DeleteAbsenceRequest mapRequestToDeleteAbsenceReq(HttpServletRequest request) {
        Integer student_id = Integer.parseInt(request.getParameter("student_id"));
        Integer modul_id = Integer.parseInt(request.getParameter("modul_id"));
        String absence_date = request.getParameter("absence_date");
        DeleteAbsenceRequest deleteAbsenceRequest = new DeleteAbsenceRequest() ; 
        deleteAbsenceRequest.setStudent_id(student_id);
        deleteAbsenceRequest.setModul_id(modul_id);
        deleteAbsenceRequest.setAbsence_date(absence_date);
        return deleteAbsenceRequest;
    }

    @Override
    public CreateModulDto mapRequesToCreateModulReq(HttpServletRequest request) {
        String modul_name = request.getParameter("modul_name");
        String modul_abbreviation = request.getParameter("modul_abbreviation");
        String modul_creationDate = request.getParameter("modul_creationDate");
        CreateModulDto createModulDto = new CreateModulDto();
        createModulDto.setModul_name(modul_name);
        createModulDto.setModul_abbreviation(modul_abbreviation);
        createModulDto.setModul_creationDate(modul_creationDate);
        return createModulDto;
    }

    @Override
    public EditMarkRequest mapRequestToEditMarkReq(HttpServletRequest request) {
        Integer modul_id = Integer.parseInt(request.getParameter("modul_id")) ;
        Integer student_id = Integer.parseInt(request.getParameter("student_id"));
        String modul_abbreviation = request.getParameter("modul_abbreviation");
        Float modul_mark= Float.parseFloat(request.getParameter("modul_mark"));
        EditMarkRequest editMarkRequest = new EditMarkRequest() ; 
        editMarkRequest.setModul_id(modul_id);
        editMarkRequest.setStudent_id(student_id);
        editMarkRequest.setModul_abbreviation(modul_abbreviation);
        editMarkRequest.setModul_mark(modul_mark);
        return editMarkRequest;
    }

    @Override
    public UpdateMarkRequest mapRequestToUpdateMarkReq(HttpServletRequest request) {
        
        Integer modul_id = Integer.parseInt(request.getParameter("modul_id")) ;
        Integer student_id = Integer.parseInt(request.getParameter("student_id"));
        Float modul_mark = Float.parseFloat(request.getParameter("modul_mark"));

        UpdateMarkRequest updateMarkRequest = new UpdateMarkRequest();
        updateMarkRequest.setModul_mark(modul_mark);
        updateMarkRequest.setModul_id(modul_id);
        updateMarkRequest.setStudent_id(student_id);

        return updateMarkRequest;
    }

    @Override
    public FieldSaveRequest mapRequestToSaveFieldReq(HttpServletRequest request) {
        String field_name = request.getParameter("field_name");
        String field_abbreviation = request.getParameter("field_abbreviation");
        String field_creationDate = request.getParameter("field_creationDate");
        String field_description= request.getParameter("field_description");
        FieldSaveRequest fieldSaveRequest = new FieldSaveRequest() ; 
        fieldSaveRequest.setField_name(field_name);
        fieldSaveRequest.setField_abbreviation(field_abbreviation);
        fieldSaveRequest.setField_description(field_description);
        fieldSaveRequest.setField_creationDate(field_creationDate);
        return fieldSaveRequest;
    }
    
    @Override
    public GroupSaveDtoReq mapRequestToSaveGroupReq(HttpServletRequest request) {
        String group_name = request.getParameter("group_name");
        String group_abbreviation = request.getParameter("group_abbreviation");
        String group_creationDate = request.getParameter("group_creationDate");
        Integer level_id = Integer.parseInt(request.getParameter("level_id"));
        
        GroupSaveDtoReq groupSaveDtoReq = new GroupSaveDtoReq();
        groupSaveDtoReq.setGroup_abbreviation(group_abbreviation);
        groupSaveDtoReq.setGroup_name(group_name);
        groupSaveDtoReq.setLevel_id(level_id);
        groupSaveDtoReq.setGroup_creationDate(group_creationDate);
        return groupSaveDtoReq;
    }
    
    @Override
    public FieldUpdateRequest mapRequestToUpdateFieldReq(HttpServletRequest request) {
        Integer field_id = Integer.parseInt(request.getParameter("field_id"));
        String field_name = request.getParameter("field_name");
        String field_abbreviation = request.getParameter("field_abbreviation");
        String field_creationDate = request.getParameter("field_creationDate");    
        String field_description = request.getParameter("field_description");   
        FieldUpdateRequest fieldUpdateRequest = new FieldUpdateRequest();
        fieldUpdateRequest.setField_id(field_id);
        fieldUpdateRequest.setField_name(field_name);
        fieldUpdateRequest.setField_abbreviation(field_abbreviation);
        fieldUpdateRequest.setField_creationDate(field_creationDate);
        return fieldUpdateRequest;
    }

    @Override
    public StudentRequest mapRequestToSaveStudentReq(HttpServletRequest request) {
        String student_name = request.getParameter("student_name");
        String student_secondName = request.getParameter("student_secondName");
        String student_phoneNumber = request.getParameter("student_phone");
        String student_email = request.getParameter("student_email");
        String student_birthday = request.getParameter("student_birthday");
        String student_gender = request.getParameter("student_gender");
        String student_nationality = request.getParameter("student_nationality");
        String student_cin = request.getParameter("student_cin");
        String student_cne = request.getParameter("student_cne");
        String student_city = request.getParameter("student_city");
        String student_postal = request.getParameter("student_postal");
        Integer student_field = Integer.parseInt(request.getParameter("student_field")) ;

        StudentRequest studentRequest = new StudentRequest();
        studentRequest.setStudent_name(student_name);
        studentRequest.setStudent_secondName(student_secondName);
        studentRequest.setStudent_email(student_email);
        studentRequest.setStudent_phone(student_phoneNumber);
        studentRequest.setStudent_birthday(student_birthday);
        studentRequest.setStudent_gender(student_gender);
        studentRequest.setStudent_nationality(student_nationality);
        studentRequest.setStudent_cin(student_cin);
        studentRequest.setStudent_cne(student_cne);
        studentRequest.setStudent_city(student_city);
        studentRequest.setStudent_adress(student_postal);
        studentRequest.setField_id(student_field);

        return studentRequest;
    }

    @Override
    public UpdatePersonnalStudent mapRequestToUpdatePersonnalReq(HttpServletRequest request) {
        Integer student_id = Integer.parseInt(request.getParameter("student_id")) ;
        String student_name = request.getParameter("student_name");
        String student_secondName = request.getParameter("student_secondName");
        String student_phone = request.getParameter("student_phone");
        String student_email = request.getParameter("student_email");
        String student_birthday = request.getParameter("student_birthday");

        String student_gender = null ; 
        if(request.getParameter("student_gender") != null)
        {
            student_gender = request.getParameter("student_gender");
        }
        else {
            student_gender = request.getParameter("student_oldGender");
        }
        String student_nationality = request.getParameter("student_nationality");
        String student_cin = request.getParameter("student_cin");
        String student_city = request.getParameter("student_city");
        String student_postal = request.getParameter("student_postal");
        String student_country = request.getParameter("student_country");

        UpdatePersonnalStudent studentRequest = new UpdatePersonnalStudent();
        studentRequest.setStudent_id(student_id);
        studentRequest.setStudent_name(student_name);
        studentRequest.setStudent_secondName(student_secondName);
        studentRequest.setStudent_phone(student_phone);
        studentRequest.setStudent_cin(student_cin);
        studentRequest.setStudent_email(student_email);
        studentRequest.setStudent_birthday(student_birthday);
        studentRequest.setStudent_gender(student_gender);
        studentRequest.setStudent_nationality(student_nationality);
        studentRequest.setStudent_city(student_city);
        studentRequest.setStudent_adress(student_postal);
        studentRequest.setStudent_country(student_country);
        return studentRequest;
    }

    @Override
    public AddDocRequest mapRequestToAddDocumentReq(HttpServletRequest request) {

        Integer group_id = Integer.parseInt(request.getParameter("group_id")) ;
        String file_name = request.getParameter("file_name");
        String group_abbreviation = request.getParameter("group_abbreviation");
        AddDocRequest  addDocRequest = new AddDocRequest();
        addDocRequest.setFile_name(file_name);
        addDocRequest.setGroup_id(group_id);
        addDocRequest.setGroup_abbreviation(group_abbreviation);
        return addDocRequest;
    }

    @Override
    public AddModulGroupReq mapRequestToAddModulReq(HttpServletRequest request) {
        Integer group_id = Integer.parseInt(request.getParameter("group_id")) ;
        Integer modul_id = Integer.parseInt(request.getParameter("modul_id")) ;
        AddModulGroupReq addModulGroupReq = new AddModulGroupReq();
        addModulGroupReq.setGroup_id(group_id);
        addModulGroupReq.setModul_id(modul_id);
     //   addModulGroupReq.setAffectation_date(affectation_date);
        return addModulGroupReq;
    }

    @Override
    public AffectationModulRequest mapRequestToAffectationModulReq(HttpServletRequest request) {
        Integer group_id = Integer.parseInt(request.getParameter("group_id")) ;
        Integer modul_id = Integer.parseInt(request.getParameter("modul_id")) ;
        Integer professor_id = Integer.parseInt(request.getParameter("professor_id")) ;
        AffectationModulRequest affectationModulRequest = new AffectationModulRequest();
        affectationModulRequest.setGroup_id(group_id);
        affectationModulRequest.setModul_id(modul_id);
        affectationModulRequest.setProfessor_id(professor_id);
        return affectationModulRequest;
    }

    @Override
    public EventRequest mapRequestToEventRequest(HttpServletRequest request) {
        String  event_title = request.getParameter("event_title");
        String  event_description = request.getParameter("event_description");
        Date  event_date = Date.valueOf(request.getParameter("event_date"));
        String  event_local = request.getParameter("event_local");
        EventRequest event = new EventRequest() ; 
        event.setEvent_title(event_title);
        event.setEvent_description(event_description);
        event.setEvent_local(event_local);
        event.setEvent_date(event_date);
        return event;
    }
    @Override
    public Event mapRequestToEventEntity (HttpServletRequest request) {
        Integer  event_id = Integer.parseInt(request.getParameter("event_id"));
        String  event_title = request.getParameter("event_title");
        String  event_description = request.getParameter("event_description");
        Date  event_date = Date.valueOf(request.getParameter("event_date"));
        String  event_local = request.getParameter("event_local");
        String event_filePath = request.getParameter("event_filePath");
        String event_fileExtension = request.getParameter("event_fileExtension");
        Event event = new Event() ; 
        event.setEvent_id(event_id);
        event.setEvent_title(event_title);
        event.setEvent_description(event_description);
        event.setEvent_local(event_local);
        event.setEvent_date(event_date);
        event.setEvent_filePath(event_filePath);
        event.setEvent_fileExtension(event_fileExtension);
        return event;
    }

    @Override
    public AddProfessorGroupRequest mapRequestToAddProfessorGroupReq(HttpServletRequest request) {
        Integer group_id = Integer.parseInt(request.getParameter("group_id")) ;
        Integer professor_id = Integer.parseInt(request.getParameter("professor_id")) ;
        AddProfessorGroupRequest addProfessorGroupRequest = new AddProfessorGroupRequest();
        addProfessorGroupRequest.setGroup_id(group_id);
        addProfessorGroupRequest.setProfessor_id(professor_id);
        return addProfessorGroupRequest;
    }

}
