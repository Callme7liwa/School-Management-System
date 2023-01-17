package org.sid.services.group;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

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


public interface GroupService {


    public List<Group> getGroups() throws IOException, SQLException;
    public List<Student> getStudents(Integer group_id) throws IOException , SQLException ; 
    public AddStudentGroupResp getStudentsToAdd(Integer group_id) throws IOException , SQLException ; 
    public AddProfessorGroupResp getProfessorsToAdd(Integer group_id)  throws IOException , SQLException ; 
    public List<Professor> getProfessors(Integer group_id) throws IOException , SQLException ; 
    public InfoGroupDaoResponse getGroup(Integer group_id) throws IOException, SQLException;
    public Boolean addDocument(AddDocRequest addDocRequest)  throws IOException, SQLException; 
    DocumentsGroup getDocumentsGroup(Integer group_id)throws IOException , SQLException ; 
    List<Module> getModulsNonAffected(Integer group_id) throws IOException , SQLException ; 
    List<Module> getModulsAffected(Integer group_id) throws IOException , SQLException ; 
    Boolean addModulGroup(AddModulGroupReq addModulGroupReq) throws IOException , SQLException ; 

    //
    public List<Module> getModulsNonAffectedToProfessors(Integer group_id)     throws IOException, SQLException ;
    public Boolean addAffectationProfessorToModul(AffectationModulRequest affectationModulRequest) throws IOException , SQLException ;
    //
    public ModulProfessor getModuleAffectedToProfessors(Integer group_id)throws IOException, SQLException ;
    //
    public Boolean addProfessorToGroup(AddProfessorGroupRequest request) throws IOException , SQLException ; 



    
}
