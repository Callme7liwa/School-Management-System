package org.sid.services.student;

import org.sid.DAL.StudentRepositoryImpl;
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
import org.sid.repositories.StudentRepository;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl  implements  StudentService{

    private StudentRepository studentRepository ;

    public StudentServiceImpl()
    {
        studentRepository = new StudentRepositoryImpl();
    }

    @Override
    public Boolean saveStudent(StudentRequest student) throws IOException, SQLException {
         Boolean resultState = studentRepository.saveStudent(student);
         return resultState ;
    }



    @Override
    public Student getStudent(int studentId) throws IOException, SQLException {
        Student student = studentRepository.getStudent(studentId);
        return student ;
    }

    @Override
    public List<Student> getStudents() throws IOException, SQLException {
        List<Student> students  = this.studentRepository.getStudents() ; 
        return students ;  
    }

    @Override
    public Boolean deleteStudent(Long studentId) throws IOException, SQLException {
        return null;
    }

    @Override
    public Boolean updateStudent(UpdatePersonnalStudent student) throws IOException, SQLException {
        Boolean booleanResult = this.studentRepository.updateStudent(student);
        return booleanResult;
    }

    @Override
    public List<Module> getModules(Long studentId) throws IOException, SQLException {
        return null;
    }

    @Override
    public List<Professor> getProfessors(Long studentId) throws IOException, SQLException {
        return null;
    }

    @Override
    public List<Absence> getAbsences(Long studentId) throws IOException, SQLException {
        return null;
    }

    @Override
    public Student authenticateStudent(AuthenticationRequest authenticationRequest) throws IOException, SQLException {
        System.out.println("im in student service  , this is my email before : " + authenticationRequest.getEmail());
        Student student = this.studentRepository.AuthenticateStudent(authenticationRequest.getEmail(), authenticationRequest.getPassword());
        System.out.println("im in student service , this is my email after : " + student.getStudent_email());
        return student ; 
    }

    @Override
    public List<AbsenceResponsDto> getAbsences(Integer student_id) throws IOException, SQLException {
        List<AbsenceResponsDto> absences = this.studentRepository.getAbsences(student_id);
        return absences ; 
    }

    @Override
    public Boolean saveNewAbsence(NewAbsenceRequest newAbsenceRequest) throws IOException, SQLException {
        Boolean resultState = this.studentRepository.saveNewAbsence(newAbsenceRequest);
        return resultState;
    }

    @Override
    public Boolean deleteAbsence(DeleteAbsenceRequest deleteAbsenceRequest) throws IOException, SQLException {
        Boolean resultState = this.studentRepository.deleteAbsence(deleteAbsenceRequest);
        return null;
    }

    @Override
    public List<String> getDates(Integer student_id) throws IOException, SQLException {
        List<Date> dates = this.studentRepository.getDates(student_id);
        List<String> stringDates = new ArrayList<String>();
        for(Date date : dates)
        {
            String values = date.toString().substring(0, 4);
            stringDates.add(values);
        }
        List<String> years = stringDates.stream().distinct().toList();
        return years;
    }

    @Override
    public List<MarkResponse> getMarks(Integer student_id) throws IOException, SQLException {
        List<MarkResponse> marks = this.studentRepository.getMarks(student_id);
        return marks;
    }

    @Override
    public Boolean updateMark(UpdateMarkRequest markRequest) throws IOException, SQLException {
        Boolean resultState = this.studentRepository.updateMark(markRequest);
        return null;
    }

    @Override
    public StudentScholarInfo getStudentScholarInfo(Integer stundet_id) throws IOException, SQLException {
        StudentScholarInfo scholarInfo = this.studentRepository.getScholarInfo(stundet_id);
        return scholarInfo;
    }

    @Override
    public List<LevelListResponseDTO> getListYears() throws IOException, SQLException {
        List<LevelListResponseDTO> levels = this.studentRepository.getListYears();
        return levels;
    }
    
}
