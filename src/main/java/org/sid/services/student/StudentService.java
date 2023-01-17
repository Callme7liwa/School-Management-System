package org.sid.services.student;

import org.sid.DTO.absence.Request.DeleteAbsenceRequest;
import org.sid.DTO.absence.Request.NewAbsenceRequest;
import org.sid.DTO.absence.Response.AbsenceResponsDto;
import org.sid.DTO.authentication.AuthenticationRequest;
import org.sid.DTO.level.Response.LevelListResponseDTO;
import org.sid.DTO.mark.Request.UpdateMarkRequest;
import org.sid.DTO.mark.Response.MarkResponse;
import org.sid.DTO.student.request.StudentRequest;
import org.sid.DTO.student.request.UpdatePersonnalStudent;
import org.sid.DTO.student.response.StudentScholarInfo;
import org.sid.entities.Absence;
import org.sid.entities.Module;
import org.sid.entities.Professor;
import org.sid.entities.Student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface StudentService {

    public Boolean saveStudent(StudentRequest student) throws IOException, SQLException;
    public Student getStudent(int studentId) throws IOException, SQLException;
    public StudentScholarInfo getStudentScholarInfo(Integer stundet_id) throws IOException , SQLException;
    public List<Student> getStudents() throws IOException, SQLException ;
    public Boolean deleteStudent(Long studentId) throws IOException, SQLException ;
    public Boolean updateStudent(UpdatePersonnalStudent student) throws IOException, SQLException ;
    public List<Module> getModules(Long studentId) throws IOException, SQLException;
    public List<Professor> getProfessors(Long studentId) throws IOException , SQLException ;
    public List<Absence> getAbsences(Long studentId) throws IOException , SQLException ;
    public Student authenticateStudent(AuthenticationRequest authenticationRequest) throws IOException , SQLException;

    // Absences 
    public List<String> getDates(Integer student_id) throws IOException , SQLException ; 
    public List<AbsenceResponsDto> getAbsences(Integer student_id) throws IOException  , SQLException ; 
    public Boolean saveNewAbsence(NewAbsenceRequest newAbsenceRequest) throws IOException, SQLException;
    public Boolean deleteAbsence(DeleteAbsenceRequest deleteAbsenceRequest) throws IOException , SQLException ; 
    // Marks 
    public List<MarkResponse> getMarks(Integer student_id) throws IOException , SQLException ; 
    public Boolean updateMark(UpdateMarkRequest markRequest) throws IOException , SQLException ; 
    // Year
    public List<LevelListResponseDTO> getListYears() throws IOException , SQLException ; 

}
