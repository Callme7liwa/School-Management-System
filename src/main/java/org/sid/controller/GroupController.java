package org.sid.controller;

import java.io.IOException;
import java.util.List;

import org.sid.DTO.UtilsClass.FileUtil;
import org.sid.DTO.group.request.AddDocRequest;
import org.sid.DTO.group.request.AddModulGroupReq;
import org.sid.DTO.group.request.AddProfessorGroupRequest;
import org.sid.DTO.group.request.AffectationModulRequest;
import org.sid.DTO.group.response.AddProfessorGroupResp;
import org.sid.DTO.group.response.AddStudentGroupResp;
import org.sid.DTO.group.response.DocumentsGroup;
import org.sid.DTO.group.response.InfoGroupDaoResponse;
import org.sid.DTO.group.response.ModulProfessor;
import org.sid.entities.Group;
import org.sid.entities.Module;
import org.sid.entities.Professor;
import org.sid.entities.Student;
import org.sid.map.Mapper;
import org.sid.services.files.FileService;
import org.sid.services.group.GroupService;
import org.sid.utils.KeyUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig
@WebServlet(name = "GroupController"  , value = {"/groups" ,  "/group" , 
                                                 "/group_students" , "/group_documents","/group_professors" ,"/group_moduls",
                                                 "/group_addStudent" , "/group_addGroup" ,  "/group_addDocuments" , "/group_addProfessor" , "/group_addModul", 
                                                 "/affectation_group_modul", "/getAffectation_moduls",
                                                 "/group_postStudent" , "/group_postProfessor" , "/group_postModul" ,  "/create_group" , 
                                                 "/edit_group" , "/update_group" , 
                                                 "/delete_group"})
public class GroupController extends SupperController {

    private final GroupService groupService ;
    private final Mapper mapper ; 
    private final FileService fileService ; 
    public GroupController( ) {
        this.groupService = this.getGroupServiceInstance();
        this.mapper = this.getMapperInstance();
        this.fileService  = this.getFileServiceInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        switch(action)
        {
            case "/groups" : getGroups(req,resp); break ; 
            case "/group"  : getGroup(req, resp); break ; 
            case "/group_students" : getStudentsGroup(req,resp) ; break ; 
            case "/group_professors" : getProfessorsGroup(req , resp) ; break ; 
            case "/group_moduls" : getModulsGroup(req,resp) ; break;
            case "/group_addStudent" : groupAddStudent(req , resp) ; break ; 
            case "/group_addProfessor" : groupAddProfessor(req , resp) ; break ; 
            case "/group_addModul" : groupAddModul(req , resp) ; break ; 
            case "/create_group" : createGroup(req, resp); break ; 
            case "/edit_group" : editGroup(req, resp); break ;
            case "/group_addDocuments" : addDocumentToGroup(req,resp) ; break ; 
            case "/group_documents" : getDocuments(req,resp) ; break ; 
            case "/affectation_group_modul" : getAddAffectationGroupModul(req,resp);break ;  
            case "/getAffectation_moduls" : getAffectationModuls(req,resp);break ; 
            default : getGroups(req, resp); break ; 
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String action = req.getParameter("action");
        System.out.println("Here im in group controller and the action is => " + action);
        switch(action)
        {
            case "upload_documents" : uploadDocuments(req,resp);break ;
            case "add_modul" : postModulGroup(req,resp);break ;  
            case "add_affectation" : addAffectation(req,resp);break ; 
            case "add_professor" : addProfessor(req,resp);break ; 
            default  : break ; 
        }   
    }

    // ********************************************** GET METHODS ********************************************************* //
    
    private void getAffectationModuls(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {
        try {
            Integer group_id = Integer.parseInt(req.getParameter("group_id"));
            ModulProfessor affectations = this.groupService.getModuleAffectedToProfessors(group_id);
            System.out.println("all of the affectations =>" + affectations);
            req.setAttribute("affectations", affectations);
            req.getRequestDispatcher("vues/dashboard/groups/AffectationModuls.jsp").forward(req, resp);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void getAddAffectationGroupModul(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {
        try {
            Integer group_id = Integer.parseInt(req.getParameter("group_id"));
            String group_abbreviation = req.getParameter("group_abbreviation");
            String field_abbreviation = req.getParameter("field_abbreviation");
            List<Module> moduls = this.groupService.getModulsNonAffectedToProfessors(group_id);
            System.out.println("the modules =>" + moduls);
            List<Professor> professors = this.groupService.getProfessors(group_id);
            System.out.println("the professors =>" + professors);
            req.setAttribute("moduls", moduls);
            req.setAttribute("professors", professors);
            req.setAttribute("group_id", group_id);
            req.setAttribute("group_abbreviation", group_abbreviation);
            req.setAttribute("field_abbreviation", field_abbreviation);
            req.getRequestDispatcher("vues/dashboard/groups/AddAffectationGroup.jsp").forward(req, resp);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void getModulsGroup(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {
        try {
            Integer group_id = Integer.parseInt(req.getParameter("group_id"));
            List<Module> moduls = this.groupService.getModulsAffected(group_id);
            System.out.println("all of the moduls of the groups are =>"+moduls);
            req.setAttribute("moduls", moduls);
            req.getRequestDispatcher("vues/dashboard/groups/GroupModuls.jsp").forward(req, resp);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void getDocuments(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException {
        try {
            Integer group_id = Integer.parseInt(req.getParameter("group_id"));
            DocumentsGroup groupDocuments = this.groupService.getDocumentsGroup(group_id);
            System.out.println("all the docs are =>" + groupDocuments);
            req.setAttribute("groupDocuments", groupDocuments);
            req.getRequestDispatcher("vues/dashboard/groups/GroupDocuments.jsp").forward(req, resp);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void groupAddStudent(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException
    {
        try {
            Integer  group_id = Integer.parseInt(req.getParameter("group_id"));
            AddStudentGroupResp addStudentGroupResp   = this.groupService.getStudentsToAdd(group_id);
            System.out.println("the response is => => " + addStudentGroupResp);
            req.setAttribute("group_id" , addStudentGroupResp.getGroup_id()); 
            req.setAttribute("group_abbreviation" , addStudentGroupResp.getGroup_abbreviation()); 
            req.setAttribute("students" , addStudentGroupResp.getListStudents()); 
            req.getRequestDispatcher("vues/dashboard/groups/AddStudentGroup.jsp").forward(req, resp);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    private void groupAddProfessor(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException
    {
        try {
            Integer  group_id = Integer.parseInt(req.getParameter("group_id"));
            AddProfessorGroupResp addProfessorGroupResp = this.groupService.getProfessorsToAdd(group_id);
            req.setAttribute("group_id" , addProfessorGroupResp.getGroup_id()); 
            req.setAttribute("group_abbreviation" , addProfessorGroupResp.getGroup_abbreviation()); 
            req.setAttribute("professors", addProfessorGroupResp.getProfessors());
            req.getRequestDispatcher("vues/dashboard/groups/AddProfessorGroup.jsp").forward(req, resp);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    private void groupAddModul(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException
    {
        try {
            Integer  group_id = Integer.parseInt(req.getParameter("group_id"));
            String group_abbreviation = req.getParameter("ga");
            List<Module> moduls = this.groupService.getModulsNonAffected(group_id);
            req.setAttribute("moduls", moduls);
            req.setAttribute("group_id", group_id);
            req.setAttribute("group_abbreviation", group_abbreviation);
            req.getRequestDispatcher("vues/dashboard/groups/AddModulGroup.jsp").forward(req, resp);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void getGroups(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException
    {
        try {
            List<Group> groups = this.groupService.getGroups();
            System.out.println("the result in group controller =>" + groups);
            req.setAttribute("groups", groups);
            req.getRequestDispatcher("vues/dashboard/groups/Groups.jsp").forward(req, resp);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void getGroup(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException
    {
        try {
            Integer group_id = Integer.parseInt(req.getParameter("group_id"));
            InfoGroupDaoResponse infoGroupDaoResponse = this.groupService.getGroup(group_id);
            req.setAttribute("group", infoGroupDaoResponse.getGroup());
            req.setAttribute("field", infoGroupDaoResponse.getGroup().getField());
            req.setAttribute("studentsNumber", infoGroupDaoResponse.getStudents_number());
            req.setAttribute("professorsNumber", infoGroupDaoResponse.getProfessors_number());
            req.setAttribute("modulsNumber", infoGroupDaoResponse.getModuls_number());
            req.getRequestDispatcher("vues/dashboard/groups/Group.jsp").forward(req, resp);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void getStudentsGroup(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException
    {
        try {
            Integer group_id = Integer.parseInt(req.getParameter("group_id"));
            List<Student> students = this.groupService.getStudents(group_id);
            req.setAttribute("students", students);
            req.getRequestDispatcher("vues/dashboard/groups/StudentGroup.jsp").forward(req, resp);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    private void getProfessorsGroup(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException
    {
        try {
            Integer group_id = Integer.parseInt(req.getParameter("group_id"));
            List<Professor> professors = this.groupService.getProfessors(group_id);
            req.setAttribute("professors", professors);
            req.getRequestDispatcher("vues/dashboard/groups/ProfessorGroup.jsp").forward(req, resp);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    // ********************************************* POST METHODS ********************************************************** //

    private void addProfessor(HttpServletRequest req , HttpServletResponse resp) throws ServletException , IOException {
        try {
            AddProfessorGroupRequest addProfessorGroupRequest = mapper. mapRequestToAddProfessorGroupReq(req);
            System.out.println("the professor =>"+addProfessorGroupRequest);
            Boolean booleanResult = this.groupService.addProfessorToGroup(addProfessorGroupRequest);    
            resp.sendRedirect(KeyUtils.PREFIX_REDIRECTING + "group?group_id="+addProfessorGroupRequest.getGroup_id());
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void  addAffectation(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException{
        try {
            // AffectationModulRequest affectationRequest = this.mapper.mapRequestToAffectationModulReq(req);
            Integer group_id = Integer.parseInt(req.getParameter("group_id")) ;
            Integer modul_id = Integer.parseInt(req.getParameter("modul_id")) ;
            Integer professor_id = Integer.parseInt(req.getParameter("professor_id")) ;
            AffectationModulRequest affectationModulRequest = new AffectationModulRequest();
            affectationModulRequest.setGroup_id(group_id);
            affectationModulRequest.setModul_id(modul_id);
            affectationModulRequest.setProfessor_id(professor_id);
            System.out.println("Affectation Request =>" + affectationModulRequest);
            this.groupService.addAffectationProfessorToModul(affectationModulRequest);
            resp.sendRedirect(KeyUtils.PREFIX_REDIRECTING+"group?group_id="+affectationModulRequest.getGroup_id());
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    private void createGroup(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException{
        req.getRequestDispatcher("vues/dashboard/groups/AddGroup.jsp").forward(req, resp);
    }

    private void editGroup(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException{
        req.getRequestDispatcher("vues/dashboard/groups/UpdateGroup.jsp").forward(req, resp);
    }

    private void addDocumentToGroup(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException{
        Integer group_id = Integer.parseInt(req.getParameter("group_id"));
        String field_name = req.getParameter("field_abbreviation");
        String group_abbreviation = req.getParameter("group_abbreviation");
        req.setAttribute("group_id", group_id);
        req.setAttribute("group_abbreviation", group_abbreviation);
        req.setAttribute("field_name", field_name);
        req.getRequestDispatcher("vues/dashboard/groups/addDocGroup.jsp").forward(req, resp);
    }

    private AddDocRequest uploadDocuments(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException{
         try {
             Part filePart = req.getPart("file");
             if(filePart != null )
             {
                AddDocRequest addDocRequest = mapper.mapRequestToAddDocumentReq(req);
                String whichFolder = addDocRequest.getGroup_abbreviation()+"/";
                FileUtil fileUtil  =  fileService.uploadFile(filePart,KeyUtils.UPLOAD_GROUP_PATH,whichFolder , addDocRequest.getFile_name());
                addDocRequest.setFile_path(fileUtil.getFile_path());
                addDocRequest.setFile_extension(fileUtil.getFile_extension());
                groupService.addDocument(addDocRequest);
                resp.sendRedirect(KeyUtils.PREFIX_REDIRECTING + "group?group_id="+addDocRequest.getGroup_id());
            }
            
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    return null ; 
       
    }

    private void postModulGroup(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException{

        try {  
            System.out.println("here im in post modul group");
            AddModulGroupReq addModulGroupReq = this.mapper.mapRequestToAddModulReq(req);
            System.out.println("the info contained inside of " + addModulGroupReq);
            Boolean booleanResult = this.groupService.addModulGroup(addModulGroupReq);
            resp.sendRedirect(KeyUtils.PREFIX_REDIRECTING+"group?group_id="+addModulGroupReq.getGroup_id());
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    /* ********************************************************************************************************************* */
   


    
    
}
