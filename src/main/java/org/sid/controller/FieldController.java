package org.sid.controller;

import java.io.IOException;
import java.sql.SQLException;

import org.sid.DTO.field.request.FieldSaveRequest;
import org.sid.DTO.field.request.FieldUpdateRequest;
import org.sid.DTO.field.response.FieldEditResponseDao;
import org.sid.DTO.field.response.FieldResponseDao;
import org.sid.entities.Field;
import org.sid.entities.Group;
import org.sid.entities.Student;
import org.sid.map.Mapper;
import org.sid.services.filiere.FieldService;
import org.sid.utils.KeyUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.*;


@WebServlet(name = "FieldController", value = {"/fields" ,  "/field" , "/field_students"  , "/field_groups","/create_field" , "/post_field" , "/edit_field" , "/update_field" , "/delete_field"})
public class FieldController extends SupperController {
    
    private final FieldService filiereService;
    private final Mapper mapper ;

    public FieldController( ) {
        this.filiereService = this.getFieldServiceInstance();
        this.mapper = this.getMapperInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        switch(action)
        {
            case "/fields" : getFields(req, resp)  ; break ; 
            case "/field" :  getField(req , resp)  ; break ; 
            case "/field_students" : getStudentField(req,resp) ; break ;  
            case "/create_field" : createField(req , resp)  ; break ; 
            case "/edit_field" : editField(req ,resp)  ; break ; 
            case "/field_groups" : getGroupsField(req,resp);break ;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action =  req.getParameter("action");
        switch(action)
        {
            case "/create_field" : create_field(req,resp);break ; 
            case "/update_field" : update_field(req,resp);break ; 
            default : break ; 
        }
        super.doPost(req, resp);
    }

    //********************************************* POST METHODS ************************************************/

    private void create_field(HttpServletRequest req , HttpServletResponse resp) throws ServletException , IOException {
            FieldSaveRequest fieldSaveRequest = mapper.mapRequestToSaveFieldReq(req);
            try {
                Boolean resultState = this.filiereService.saveField(fieldSaveRequest);
                resp.sendRedirect(KeyUtils.PREFIX_REDIRECTING+"fields?resultState="+resultState);;
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    }

    private void update_field(HttpServletRequest req , HttpServletResponse resp) throws ServletException , IOException {
        FieldUpdateRequest fieldUpdateRequest = mapper.mapRequestToUpdateFieldReq(req);
        try {
            Boolean resultState = this.filiereService.updateField(fieldUpdateRequest);
            resp.sendRedirect(KeyUtils.PREFIX_REDIRECTING+"field?field_id="+fieldUpdateRequest.getField_id());
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void getFields(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException 
    {
        try {
            List<Field> fields = this.filiereService.getFields();
            System.out.println("the fields are "+ fields);
            req.setAttribute("fields", fields);
            req.getRequestDispatcher("vues/dashboard/Fields/Fields.jsp").forward(req, resp);   
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void getField(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException
    {
        try {
            Integer field_id = Integer.parseInt(req.getParameter("field_id")) ;
            System.out.println("the field_id" + field_id);
            FieldResponseDao fieldResponseDao =  this.filiereService.getField(field_id);
            req.setAttribute("fieldInfo", fieldResponseDao);
            req.getRequestDispatcher("vues/dashboard/Fields/Field.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void createField(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException
    {
        req.getRequestDispatcher("vues/dashboard/Fields/AddField.jsp").forward(req, resp);
    }

    private void editField(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException
    {
        try {
            Integer field_id = Integer.parseInt(req.getParameter("field_id"));
            FieldEditResponseDao field = this.filiereService.getFieldEdit(field_id);
            req.setAttribute("field", field);
            req.getRequestDispatcher("vues/dashboard/Fields/UpdateField.jsp").forward(req, resp);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void getStudentField(HttpServletRequest req , HttpServletResponse resp) throws ServletException , IOException 
    {
        try {
            Integer field_id = Integer.parseInt(req.getParameter("field_id"));
            List<Student> studentsField = this.filiereService.getStudentsField(field_id);
            req.setAttribute("students", studentsField);
            req.getRequestDispatcher("vues/dashboard/Fields/FieldStudent.jsp").forward(req, resp);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void getGroupsField(HttpServletRequest req , HttpServletResponse response) throws ServletException , IOException {
        try {
            Integer field_id = Integer.parseInt(req.getParameter("field_id"));
            List<Group> groups = this.filiereService.getGroupByField(field_id);
            req.setAttribute("groups", groups);
            req.getRequestDispatcher("vues/dashboard/Fields/FieldGroup.jsp").forward(req, response);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}