package org.sid.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.sid.DTO.absence.Request.DeleteAbsenceRequest;
import org.sid.DTO.absence.Request.NewAbsenceRequest;
import org.sid.DTO.absence.Response.AbsenceResponsDto;
import org.sid.DTO.level.Response.LevelListResponseDTO;
import org.sid.DTO.mark.Request.EditMarkRequest;
import org.sid.DTO.mark.Request.UpdateMarkRequest;
import org.sid.DTO.mark.Response.MarkResponse;
import org.sid.DTO.student.request.StudentRequest;
import org.sid.DTO.student.request.UpdatePersonnalStudent;
import org.sid.DTO.student.response.StudentScholarInfo;
import org.sid.entities.Field;
import org.sid.entities.Student;
import org.sid.map.Mapper;
import org.sid.services.files.FileService;
import org.sid.services.filiere.FieldService;
import org.sid.services.student.StudentService;
import org.sid.utils.KeyUtils;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@MultipartConfig
@WebServlet(name = "StudentController",
            value = {"/students" ,  "/student" , "/personal_information" ,
                     "/scholar_information"  ,   "/create_student" , "/post_student" , "/edit_student" ,
                      "/update_student" , "/absences" , "/marks" ,"/addAbsence_modul" , "/editAbsence_modul" , 
                      "/editMark_modul",
                      "/update_student_personnal",
                      "/levels"
                     })
public class StudentsController extends  SupperController{

    private final StudentService studentService ;
    private final FileService  fileService ; 
    private final FieldService fieldService ;
    private final Mapper mapper;


    public StudentsController( ) {
        this.mapper = this.getMapperInstance();
        this.studentService = this.getStudentServiceInstance();
        this.fieldService = this.getFieldServiceInstance();
        this.fileService = this.getFileServiceInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        System.out.println("im in student controller and the action is :" + action);
        switch(action)
        {
            case  "/students"  :
                getInfoStudents(req,resp);
                break ;
            case "/student" : 
                getInfoStudent(req,resp);
                break ;
            case "/personal_information" : 
                getPersonalInfoStudent(req,resp);
                break;
            case "/scholar_information" : 
                getScholarInfoStudent(req,resp);
                break ; 
            case "/marks":
                getMarkStudent(req,resp);
                break ;  
            case "/create_student":
                List<Field> fields;
                createStudent(req, resp);
                break ; 
            case "/absences":
                getAbsencesStudent(req,resp); 
                break ;
            case "/addAbsence_modul":
                addAbsenceModul(req,resp);
                break ; 
            case "/editAbsence_modul":
                editAbsenceModul(req,resp);
                break ; 
            case "/editMark_modul":
                editMark(req,resp);
                break ; 
            case "/levels":
                getLevels(req,resp);
                break ; 
            default : break ; 
            }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        System.out.println("hi im in post method and the action is " + action);
        switch(action)
        {
            case "save_student" : saveStudent(req,resp);break ; 
            case "update_student_personnal" : updateStudentPersonnal(req,resp);break ; 
            case "save_absence" : saveAbsence(req,resp); break ; 
            case "delete_absence" : deleteAbsence(req,resp) ; break ; 
            case "update_mark" : updateMark(req,resp);break;
            default : return  ; 
        }
    }

    private void saveStudent(HttpServletRequest req , HttpServletResponse resp) throws ServletException , IOException{
        try {
            StudentRequest studentRequest = mapper.mapRequestToSaveStudentReq(req);
            Boolean resultState = this.studentService.saveStudent(studentRequest);
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private Boolean updateStudentPersonnal(HttpServletRequest req , HttpServletResponse resp) throws ServletException {
       try {
            UpdatePersonnalStudent updateRequest = mapper.mapRequestToUpdatePersonnalReq(req);
            Part filePart = req.getPart("student_image");
            if(filePart != null )
            {
              String fileName =    this.fileService.uploadImage(filePart, KeyUtils.IMAGES_STUDENTS_PATH , updateRequest.getStudent_id());
              updateRequest.setStudent_image(fileName);
              resp.sendRedirect(KeyUtils.PREFIX_REDIRECTING+"student?id="+updateRequest.getStudent_id());
            }
            else
            {
                updateRequest.setStudent_image(req.getParameter("student_oldImage"));
            }
            return studentService.updateStudent(updateRequest);
       }catch(Exception e)
       {
            e.printStackTrace();
        }
        return null ;
    } 


    private void editMark(HttpServletRequest req , HttpServletResponse resp) throws ServletException , IOException{
        try {
            EditMarkRequest editMarkRequest  = mapper.mapRequestToEditMarkReq(req);
            req.setAttribute("mark", editMarkRequest);
            System.out.println(editMarkRequest);
            req.getRequestDispatcher("vues/dashboard/students/UpdateMark.jsp").forward(req, resp);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void updateMark(HttpServletRequest req , HttpServletResponse resp) throws ServletException , IOException{
         try {
            UpdateMarkRequest updateMarkRequest = mapper.mapRequestToUpdateMarkReq(req);
            Boolean resultState = this.studentService.updateMark(updateMarkRequest);
            resp.sendRedirect(KeyUtils.PREFIX_REDIRECTING+"marks?id="+updateMarkRequest.getStudent_id()+"&resultat="+resultState);
         }catch(Exception e)
         {
            e.printStackTrace();
         }
    }

    private void deleteAbsence(HttpServletRequest req , HttpServletResponse resp) throws ServletException , IOException{
        try {
            DeleteAbsenceRequest deleteAbsenceRequest = mapper.mapRequestToDeleteAbsenceReq(req);
            Boolean resultStat = this.studentService.deleteAbsence(deleteAbsenceRequest);
            resp.sendRedirect("/pfa/absences?id="+deleteAbsenceRequest.getStudent_id());
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void saveAbsence(HttpServletRequest req , HttpServletResponse resp) throws ServletException , IOException {
        try {
           NewAbsenceRequest newAbsenceRequest = mapper.mapRequestToNewAbsenceReq(req);
           Boolean resultState = this.studentService.saveNewAbsence(newAbsenceRequest);
           resp.sendRedirect("/pfa/absences?id="+newAbsenceRequest.getStudent_id());
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    private void getInfoStudents(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        try {
            List<Student> students = studentService.getStudents();
            req.setAttribute("students" , students);
            req.getRequestDispatcher("vues/dashboard/students/Students.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void getInfoStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        int student_id = Integer.parseInt(req.getParameter("id"));
        try {
            Student student = studentService.getStudent(student_id);
            req.setAttribute("student", student);
            req.getRequestDispatcher("vues/dashboard/students/Student.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void getPersonalInfoStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException , IOException
    {
        int student_id = Integer.parseInt(req.getParameter("id"));
        try {
            Student student = studentService.getStudent(student_id);
            req.setAttribute("student", student);
            req.getRequestDispatcher("vues/dashboard/students/InformationPersonal.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void getAbsencesStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException , IOException
    {
        int student_id = Integer.parseInt(req.getParameter("id"));
        try {
            // Get absences 
            List<AbsenceResponsDto> absences = this.studentService.getAbsences(student_id);
            List<String> years = this.studentService.getDates(student_id);
            req.setAttribute("absences", absences);
            req.setAttribute("years",years);
            req.getRequestDispatcher("vues/dashboard/students/Absence.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void getScholarInfoStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException , IOException
    {
        int student_id = Integer.parseInt(req.getParameter("id"));
        try {
            StudentScholarInfo scholarInfo = this.studentService.getStudentScholarInfo(student_id);
            System.out.println(scholarInfo);
            req.setAttribute("student", scholarInfo);
            req.getRequestDispatcher("vues/dashboard/students/InformationScholar.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void getMarkStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException , IOException
    {
        int student_id = Integer.parseInt(req.getParameter("id"));
        try {
            // Get marks 
            List<String> years = this.studentService.getDates(student_id);
            List<MarkResponse> marks = this.studentService.getMarks(student_id);
            req.setAttribute("years", years);
            req.setAttribute("marks", marks);
            System.out.println("the all of marks =>" + marks);
            req.getRequestDispatcher("vues/dashboard/students/Mark.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void createStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException , IOException 
    {
        try {
            List<Field> fields = this.fieldService.getFields();
            System.out.println("the field in students" + fields);
            req.setAttribute("fields", fields); 
            req.getRequestDispatcher("vues/dashboard/students/AddStudent.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addAbsenceModul(HttpServletRequest req, HttpServletResponse resp) throws ServletException , IOException
    {
        try {
            String modul_abbreviation = req.getParameter("mb");
            Integer student_id = Integer.parseInt(req.getParameter("si"));
            Integer modul_id = Integer.parseInt(req.getParameter("mi"));
            req.setAttribute("student_id", student_id);
            req.setAttribute("modul_id", modul_id);
            req.setAttribute("modul_abbreviation", modul_abbreviation);
            req.getRequestDispatcher("vues/dashboard/students/AddAbsenceModul.jsp").forward(req, resp);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void getLevels(HttpServletRequest req , HttpServletResponse resp) throws ServletException , IOException
    {
        try {   
            List<LevelListResponseDTO> levels = this.studentService.getListYears();
            req.setAttribute("levels", levels);
            req.getRequestDispatcher("vues/dashboard/students/Levels.jsp").forward(req, resp);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void editAbsenceModul(HttpServletRequest req , HttpServletResponse resp) throws ServletException , IOException
    {
        try {
            String modul_abbreviation = req.getParameter("mb");
            Integer student_id = Integer.parseInt(req.getParameter("si"));
            Integer modul_id = Integer.parseInt(req.getParameter("mi"));
            Integer absence_hours = Integer.parseInt(req.getParameter("ah"));
            String absence_date_string=req.getParameter("da");
            req.setAttribute("student_id", student_id);
            req.setAttribute("modul_id", modul_id);
            req.setAttribute("modul_abbreviation", modul_abbreviation);
            req.setAttribute("date_absence",absence_date_string);
            req.setAttribute("absence_hours", absence_hours);
            req.getRequestDispatcher("vues/dashboard/students/UpdateAbsenceDate.jsp").forward(req, resp);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}



