package org.sid.controller;

import java.io.IOException;

import java.util.*;

import org.sid.DTO.modul.Request.CreateModulDto;
import org.sid.DTO.modul.Response.ModulFields;
import org.sid.DTO.modul.Response.ModulGroups;
import org.sid.DTO.modul.Response.ModulProfessors;
import org.sid.DTO.modul.Response.ModulResponseDto;
import org.sid.map.Mapper;
import org.sid.services.modul.ModuleService;
import org.sid.utils.KeyUtils;

import org.sid.entities.Module;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name="modulscontroller",value = {"/moduls" , "/modul","/create_modul" , "/edit_modul", "/get_fields" , "/get_professors" , "/get_groups"  })
public class ModulsController  extends SupperController{

    private final ModuleService moduleService ;
    private final Mapper mapper ; 

    public ModulsController( ) {
        this.moduleService = this.getModuleServiceInstance();
        this.mapper = this.getMapperInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        switch(action)
        {
            case "/moduls" : getModuls(req,resp); break ; 
            case "/modul"  : getModul(req,resp);break ; 
            case "/edit_modul" : editModul(req,resp);break ; 
            case "/create_modul" : create_modul(req,resp); break ; 
            case "/get_professors" : get_professors(req,resp);break ; 
            case "/get_fields" : get_fields(req,resp) ; break ; 
            case "/get_groups" : get_groups(req,resp) ; break ; 
            default : getModuls(req, resp); break ; 
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch(action)
        {
            case "post_modul" : post_modul(req,resp); break ; 
            case "update_modul": update_modul(req,resp);break ; 
            default : break ; 
        }
    }

    // ***************************************** POST METHODES *************************************************** //

    private void post_modul(HttpServletRequest req , HttpServletResponse resp) throws ServletException , IOException
    {
        CreateModulDto createModulDto = this.mapper.mapRequesToCreateModulReq(req);
        System.out.println("the request to create  a modul => " + createModulDto);
        try {
            Boolean resultState=this.moduleService.saveModule(createModulDto);
            resp.sendRedirect(KeyUtils.PREFIX_REDIRECTING+"moduls?result="+resultState);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void update_modul(HttpServletRequest req , HttpServletResponse resp) throws ServletException , IOException{

    }

    // ***************************************** GET METHODES *************************************************** //

    private void editModul (HttpServletRequest req , HttpServletResponse resp) throws ServletException , IOException { 
        try {
            Integer modul_id = Integer.parseInt(req.getParameter("modul_id"));
            Module module = this.moduleService.getModul(modul_id);
            System.out.println("informations about module => " + module);
            req.setAttribute("modul", module);
            req.getRequestDispatcher("vues/dashboard/moduls/EditModul.jsp").forward(req, resp);

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    private void get_professors (HttpServletRequest req , HttpServletResponse resp) throws ServletException , IOException { 
        Integer modul_id = Integer.parseInt(req.getParameter("modul_id"));
        try {
            ModulProfessors professors  = this.moduleService.getProfessorsByModul(modul_id);
            System.out.print("professors of the modul are => "+professors);
            req.setAttribute("modulProfessors", professors);
            req.getRequestDispatcher("vues/dashboard/moduls/ModulProfessors.jsp").forward(req, resp);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void get_fields(HttpServletRequest req , HttpServletResponse resp) throws ServletException , IOException { 
        Integer modul_id = Integer.parseInt(req.getParameter("modul_id"));
        try {
            ModulFields modulFields = this.moduleService.getFieldsByModul(modul_id);
            req.setAttribute("modulFields", modulFields);
            req.getRequestDispatcher("vues/dashboard/moduls/ModulFields.jsp").forward(req, resp);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void get_groups(HttpServletRequest req , HttpServletResponse resp) throws ServletException , IOException { 
        Integer modul_id = Integer.parseInt(req.getParameter("modul_id"));
        try {
            ModulGroups groups = this.moduleService.getGroupsByModul(modul_id);
            System.out.print("group of the modul are =>" + groups);
            req.setAttribute("modulGroups", groups );
            req.getRequestDispatcher("vues/dashboard/moduls/ModulGroups.jsp").forward(req, resp);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void getModul (HttpServletRequest req , HttpServletResponse resp) throws ServletException , IOException {
        Integer modul_id = Integer.parseInt(req.getParameter("modul_id"));
        try {
            ModulResponseDto modul = this.moduleService.getModule(modul_id);
            System.out.println("the full inforamtions about the modul => " + modul);
            req.setAttribute("modul", modul);
            req.getRequestDispatcher("vues/dashboard/moduls/Modul.jsp").forward(req, resp);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void getModuls(HttpServletRequest req , HttpServletResponse resp) throws ServletException , IOException {
        try {
            System.out.println("Before calling the method !");
            List<ModulResponseDto> moduls = this.moduleService.getModules() ; 
            System.out.println("the full of moduls are =>" + moduls);
            req.setAttribute("moduls", moduls);
            req.getRequestDispatcher("vues/dashboard/moduls/Moduls.jsp").forward(req, resp);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }  
    
    private void create_modul(HttpServletRequest req , HttpServletResponse resp) throws ServletException , IOException {
        try {
            req.getRequestDispatcher("vues/dashboard/moduls/AddModul.jsp").forward(req, resp);
        }catch(Exception e )
        {
            e.printStackTrace();
        }
    }

   
}