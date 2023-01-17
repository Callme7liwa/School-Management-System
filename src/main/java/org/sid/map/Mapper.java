package org.sid.map;

import jakarta.servlet.http.HttpServletRequest;

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

public interface Mapper {

    public AuthenticationRequest mapRequestToAuthenticateReq( HttpServletRequest request);
    public NewAbsenceRequest mapRequestToNewAbsenceReq(HttpServletRequest request);
    public DeleteAbsenceRequest mapRequestToDeleteAbsenceReq(HttpServletRequest request);
    public CreateModulDto mapRequesToCreateModulReq(HttpServletRequest request);
    public EditMarkRequest mapRequestToEditMarkReq(HttpServletRequest request);
    public UpdateMarkRequest mapRequestToUpdateMarkReq(HttpServletRequest request);

    public FieldSaveRequest mapRequestToSaveFieldReq(HttpServletRequest request);
    public GroupSaveDtoReq mapRequestToSaveGroupReq(HttpServletRequest request);
    public FieldUpdateRequest mapRequestToUpdateFieldReq(HttpServletRequest request);

    public StudentRequest mapRequestToSaveStudentReq(HttpServletRequest request);
    public UpdatePersonnalStudent mapRequestToUpdatePersonnalReq(HttpServletRequest request);

    public AddDocRequest mapRequestToAddDocumentReq(HttpServletRequest request);
    public AddModulGroupReq mapRequestToAddModulReq(HttpServletRequest request);
    public AddProfessorGroupRequest mapRequestToAddProfessorGroupReq(HttpServletRequest request);

    public AffectationModulRequest mapRequestToAffectationModulReq(HttpServletRequest request);

    public EventRequest mapRequestToEventRequest(HttpServletRequest request);
    public Event mapRequestToEventEntity(HttpServletRequest request);
}
