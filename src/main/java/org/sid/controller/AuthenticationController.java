package org.sid.controller;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.sid.DTO.authentication.AuthenticationRequest;
import org.sid.entities.Professor;
import org.sid.entities.Student;
import org.sid.map.Mapper;
import org.sid.services.authentication.AuthenticationService;
import org.sid.services.student.StudentService;
import org.sid.utils.KeyUtils;
import org.sid.utils.Validator;
import org.sid.services.professor.ProfessorService; 

import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "AuthenticationController", value = {"/authentication" , "/login" , "/dashboard"  })
public class AuthenticationController extends  SupperController {

    private final Mapper mapper;
    private final StudentService studentService ; 
    private final ProfessorService professorService ; 

    public AuthenticationController( ) {
        this.mapper = this.getMapperInstance();
        this.studentService = this.getStudentServiceInstance();
        this.professorService = this.getProfessorServiceInstance();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        switch (action)
        {
            case "/login" :
                processUrlLogin(req,resp);
                break ;
            case "/dashboard" :
                req.getRequestDispatcher("vues/dashboard/Dashboard.jsp").forward(req,resp);
                break;
            default :
                req.getRequestDispatcher("vues/authentication/login.jsp").forward(req,resp);
                break ;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action  = req.getParameter("action");
        switch (action){
            case "authenticate" :
                processAuthentication(req,resp);
                break ;
            default:
                System.out.println("Im in default method . ");
        }
    }

    // Appelé lorsque on tente d'acceder a login page .
    private void processUrlLogin(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException
    {
        req.setAttribute(KeyUtils.TYPE_USER  , req.getParameter("as"));
        req.getRequestDispatcher("vues/authentication/login.jsp").forward(req,resp);
    }
    // Appelé lorsqu'on essaye de s'authentifier . 
    private void processAuthentication(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException
    {
        // Validation //
        String user_type = req.getParameter(KeyUtils.TYPE_USER);
        String error = "";
        if(!Validator.checkEmail(req.getParameter("email")))
        {
            error="please enter a valid email !";
            req.setAttribute(KeyUtils.ERROR_KEY, error);
            req.setAttribute("user_type", user_type);
            req.getRequestDispatcher("vues/authentication/login.jsp").forward(req, resp);
        }
        else{
            AuthenticationRequest authRequest = this.mapper.mapRequestToAuthenticateReq(req);
            try {
                switch(user_type)
                {
                    case "student" : 
                            System.out.println("im in student ");  
                            Student student = this.studentService.authenticateStudent(authRequest); 
                            if(Objects.nonNull(student))  
                            {
                                HttpSession session = req.getSession();
                                session.setAttribute(KeyUtils.USER_KEY,student);
                                session.setAttribute(KeyUtils.TYPE_USER , "student");
                                session.setMaxInactiveInterval(KeyUtils.MAX_INACTIVE_INTERVAL);
                                resp.sendRedirect(KeyUtils.PREFIX_REDIRECTING+"dashboard");
                            }
                            else
                            {
                                error = "Authentication Information are not valid !";
                                req.setAttribute(KeyUtils.ERROR_KEY, error);
                                req.getRequestDispatcher("vues/authentication/login.jsp").forward(req, resp);
                            }
                            break ; 
                    case "professor" : 
                            System.out.println("im in professor ");  
                            Professor professor = this.professorService.authenticateProfessor(authRequest); 
                            if(Objects.nonNull(professor))  
                            {
                                HttpSession session = req.getSession();
                                session.setAttribute(KeyUtils.USER_KEY,professor);
                                session.setAttribute(KeyUtils.TYPE_USER , "professor");
                                session.setMaxInactiveInterval(KeyUtils.MAX_INACTIVE_INTERVAL);
                                resp.sendRedirect(KeyUtils.PREFIX_REDIRECTING+"dashboard");
                            }
                            else
                            {
                                error = "Authentication Information are not valid !";
                                req.setAttribute(KeyUtils.ERROR_KEY, error);
                                req.getRequestDispatcher("vues/authentication/login.jsp").forward(req, resp);
                            }
                            break ; 
                    case "admin" : 
                            System.out.println("im in Admin ");  
                            break ; 
                    default : System.out.println("im in default "); break ; 
                }
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
