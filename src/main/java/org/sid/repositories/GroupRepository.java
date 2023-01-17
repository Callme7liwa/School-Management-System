package org.sid.repositories;

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
import org.sid.entities.Professor;
import org.sid.entities.Student;
import org.sid.entities.Module;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface GroupRepository {

    List<Group> getGroups() throws  IOException , SQLException ;
    InfoGroupDaoResponse getGroup(Integer group_id) throws  IOException , SQLException ;
    List<Student> getStudents(Integer group_id ) throws  IOException , SQLException ;
    List<Professor> getProfessors(Integer group_id) throws IOException , SQLException ; 
    List<Group> getGroupByLevel(Integer level_id) throws IOException , SQLException;
    List<Group> getGroupByField(Integer field_id) throws IOException , SQLException ;
    AddStudentGroupResp getStudentToAdd(Integer group_id) throws IOException , SQLException ;
    AddProfessorGroupResp getProfessorsToAdd(Integer group_id) throws IOException , SQLException ; 
    Boolean addDocument(AddDocRequest addDocRequest)throws IOException , SQLException ; 
    DocumentsGroup getDocumentsGroup(Integer group_id)throws IOException , SQLException ;
    //
    List<Module> getModulsNonAffected(Integer group_id) throws IOException , SQLException ; 
    List<Module> getModulsAffected(Integer group_id) throws IOException , SQLException ; 
    Boolean addModulGroup(AddModulGroupReq addModulGroupReq) throws IOException , SQLException ; 
    //
    public List<Module> getModulsNonAffectedToProfessors(Integer group_id)     throws IOException, SQLException ;
    public Boolean addAffectationProfessorToModul(AffectationModulRequest affectationModulRequest) throws IOException , SQLException ;
    //
    public ModulProfessor getModuleAffectedToProfessors(Integer group_id)throws IOException, SQLException ;
    public Boolean addProfessorToGroup(AddProfessorGroupRequest request) throws IOException , SQLException ; 

}
