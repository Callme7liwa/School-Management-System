package org.sid.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.sid.DTO.modul.Response.ModulResponseDto;
import org.sid.entities.Module;
import org.sid.services.group.GroupServiceImpl;
import org.sid.services.modul.ModuleService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "CoursController"  , value = {"/cours" , "/add_cours"})
public class CoursController  extends SupperController{
    private final ModuleService moduleService ;

    public CoursController(ModuleService moduleService) {
        this.moduleService = SupperController.getModuleServiceInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        switch(action) {
            case "/add_module" : break ;
            case "/modules" : getModuls(req,resp) ;  break ;
            default : getModuls(req,resp);  break ;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }


    private void getModuls(HttpServletRequest req , HttpServletResponse resp) throws ServletException , IOException {
        try {
            System.out.println("Before calling the method !");
            List<ModulResponseDto> moduls = this.moduleService.getModules() ; 
            System.out.println("the full of moduls are =>" + moduls);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }   
}
