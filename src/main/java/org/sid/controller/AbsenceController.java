package org.sid.controller;

import java.io.IOException;

import org.sid.services.absence.AbsenceService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="absence_controller" , value ={"/absences_student" , "/absence_module"})
public class AbsenceController extends SupperController {

    private final AbsenceService absenceService;

    public AbsenceController() {
        this.absenceService = this.getAbsenceServiceInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        switch(action)
        {
            
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }
}
