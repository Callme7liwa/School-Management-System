package org.sid.repositories;

import org.sid.DAL.StudentRepositoryImpl;
import org.sid.DTO.absence.Request.CreateAbsenceDto;
import org.sid.DTO.absence.Request.DeleteAbsenceRequest;
import org.sid.DTO.absence.Request.NewAbsenceRequest;
import org.sid.DTO.absence.Response.AbsenceOneResponsDto;
import org.sid.DTO.absence.Response.AbsenceResp;
import org.sid.DTO.absence.Response.AbsenceResponsDto;
import org.sid.DTO.level.Response.LevelListResponseDTO;
import org.sid.DTO.level.Response.LevelResponseDto;
import org.sid.DTO.mark.Request.UpdateMarkRequest;
import org.sid.DTO.mark.Response.MarkResponse;
import org.sid.DTO.student.request.StudentRequest;
import org.sid.DTO.student.request.UpdatePersonnalStudent;
import org.sid.DTO.student.response.StudentScholarInfo;
import org.sid.entities.Absence;
import org.sid.entities.Module;
import org.sid.entities.Professor;
import org.sid.entities.Student;
import org.sid.entities.User;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.Year;
import java.util.List;

public interface StudentRepository {

    public Boolean saveStudent(StudentRequest student) throws IOException, SQLException;
    public Student getStudent(int studentId) throws IOException, SQLException;
    public List<Student> getStudents() throws IOException, SQLException ;
    public Boolean deleteStudent(Integer studentId) throws IOException, SQLException ;
    public Boolean updateStudent(UpdatePersonnalStudent student) throws IOException, SQLException ;
    public List<Student> getStudentsByYear(String level_name) throws  IOException , SQLException ;
    public List<Student> getStudentsByGroup(Integer group_id) throws  IOException , SQLException ;
    public List<Student> getStudentsByField(Integer field_id) throws IOException , SQLException ;
    public List<Date> getDates(Integer student_id) throws IOException , SQLException ; 
    public StudentScholarInfo getScholarInfo(Integer student_id) throws IOException , SQLException ; 

    public Student AuthenticateStudent(String email , String password) throws IOException , SQLException ;

    public List<AbsenceResponsDto> getAbsences(Integer stundent) throws IOException , SQLException;

    public AbsenceResponsDto getAbsence(Integer modul_id , Integer student_id) throws IOException , SQLException;

    public AbsenceOneResponsDto getOneAbsence(Integer modul_id , Integer student_id , Date absence_date) throws IOException , SQLException ;

    public List<CreateAbsenceDto> getModulsToAdd(Integer student_id) throws IOException , SQLException;

    //Absences
    public Boolean saveNewAbsence(NewAbsenceRequest newAbsenceRequest) throws IOException , SQLException;
    public Boolean deleteAbsence(DeleteAbsenceRequest deleteAbsenceRequest) throws IOException , SQLException ;
    // Marks
    public List<MarkResponse> getMarks(Integer student_id) throws IOException , SQLException ;
    public Boolean updateMark(UpdateMarkRequest updateMarkRequest) throws IOException , SQLException ; 
    // Levels 
    public List<LevelResponseDto> getLevels() throws IOException , SQLException ; 
    // Students
    public List<LevelListResponseDTO> getListYears() throws IOException , SQLException ; 


}
