package org.sid.controller;

import java.io.IOException;
import java.sql.SQLException;

import org.sid.entities.Group;
import org.sid.entities.Module;

import org.sid.entities.Professor;
import org.sid.services.professor.ProfessorService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.*;

@WebServlet(name = "ProfessorController", value = {  "/professors" ,  "/professor" , "/professor_personalInformation"  , 
                                                     "/create_professor" , "/post_professor" , "/edit_professor" , "/update_professor" ,
                                                     "/professor_moduls" , "/professor_groups"
                                                    })
public class ProfessorController extends SupperController{

    private final ProfessorService professorService ;

    public ProfessorController() {
        this.professorService = this.getProfessorServiceInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        
        switch(action)
        {
            case  "/professors" : 
                    getProfessors(req, resp);
                    break ; 
            case  "/professor" : 
                    getProfessor(req, resp);   
                    break ; 
            case "/professor_moduls":
                    getModuls(req,resp);
                    break ; 
            case "/professor_groups" : 
                    getGroups(req,resp);
                    break ; 
            case "/professor_personalInformation":
                    getPersonnalInformation(req,resp);
                    break ; 
            case  "/create_professor" : 
                    create_professor(req , resp)  ;
                    break ; 
            case  "/edit_professor" : break ; 
            default : getProfessors(req, resp); break ;  
        }
    }
    

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }

    // *************************************************** GET METHOD ******************************************* //

    private void getPersonnalInformation(HttpServletRequest req , HttpServletResponse resp) throws ServletException , IOException {
        try {   
            Integer professor_id = Integer.parseInt(req.getParameter("professor_id"));
            Professor professor = this.professorService.getProfessor(professor_id);
            req.setAttribute("professor", professor);
            req.getRequestDispatcher("vues/dashboard/professors/UpdateProfessor.jsp").forward(req, resp);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    private void getGroups(HttpServletRequest req , HttpServletResponse resp) throws ServletException , IOException {
        try {
            Integer professor_id = Integer.parseInt(req.getParameter("professor_id"));
            List<Group> groups = this.professorService.getGroups(professor_id);
            System.out.println("the groups of the professor are =>" + groups);
            req.setAttribute("groups", groups);
            req.getRequestDispatcher("vues/dashboard/professors/ProfessorGroups.jsp").forward(req, resp);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void getModuls(HttpServletRequest req , HttpServletResponse resp) throws ServletException , IOException {
        try {
            Integer professor_id = Integer.parseInt(req.getParameter("professor_id"));
            String professor_name = req.getParameter("fn");
            String professor_secondName = req.getParameter("sn");
            List<Module>  moduls = this.professorService.getModuls(professor_id);
            System.out.println("the moduls of the professor are =>" + moduls);
            req.setAttribute("moduls", moduls);
            req.setAttribute("professor_name", professor_name);
            req.setAttribute("professor_secondName", professor_secondName);
            req.getRequestDispatcher("vues/dashboard/professors/ProfessorModuls.jsp").forward(req, resp);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    private void getProfessors(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        try {
            List<Professor> professors= this.professorService.getProfessors();
            req.setAttribute("professors", professors);
            req.getRequestDispatcher("vues/dashboard/professors/Professors.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void getProfessor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int professor_id = Integer.parseInt(req.getParameter("id"));
            Professor professor = this.professorService.getProfessor(professor_id);
            req.setAttribute("professor", professor);
            req.getRequestDispatcher("vues/dashboard/professors/Professor.jsp").forward(req, resp);
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    private void create_professor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("vues/dashboard/professors/AddProfessor.jsp").forward(req, resp);
    }

    private void edit_professor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
