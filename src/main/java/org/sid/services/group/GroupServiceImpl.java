package org.sid.services.group;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.sid.DTO.group.request.AddDocRequest;
import org.sid.DTO.group.request.AddModulGroupReq;
import org.sid.DTO.group.request.AddProfessorGroupRequest;
import org.sid.DTO.group.request.AffectationModulRequest;
import org.sid.DTO.group.response.AddProfessorGroupResp;
import org.sid.DTO.group.response.AddStudentGroupResp;
import org.sid.DTO.group.response.DocumentsGroup;
import org.sid.DTO.group.response.InfoGroupDaoResponse;
import org.sid.DTO.group.response.ModulProfessor;
import org.sid.DTO.modul.Response.ModulFields;
import org.sid.DTO.modul.Response.ModulGroups;
import org.sid.entities.Group;
import org.sid.entities.Module;
import org.sid.entities.Professor;
import org.sid.entities.Student;
import org.sid.repositories.GroupRepository;
import org.sid.services.SupperService;

public class GroupServiceImpl  implements  GroupService{

    public GroupRepository groupRepository ; 

    public GroupServiceImpl (){
        this.groupRepository = SupperService.getGroupRepositoryInstance();
    }
    @Override
    public List<Group> getGroups() throws IOException, SQLException {
        List<Group> groups = this.groupRepository.getGroups();
        return groups;
    }

    @Override
    public InfoGroupDaoResponse getGroup(Integer group_id) throws IOException, SQLException {
        InfoGroupDaoResponse infoGroupDaoResponse = this.groupRepository.getGroup(group_id) ; 
        return infoGroupDaoResponse;
    }
    @Override
    public List<Student> getStudents(Integer group_id) throws IOException, SQLException {
        List<Student> students = this.groupRepository.getStudents(group_id);
        return students;
    }
    @Override
    public List<Professor> getProfessors(Integer group_id) throws IOException, SQLException {
        List<Professor> professors = this.groupRepository.getProfessors(group_id);
        return professors;
    }
    @Override
    public AddStudentGroupResp getStudentsToAdd(Integer group_id) throws IOException, SQLException {
        AddStudentGroupResp students = this.groupRepository.getStudentToAdd(group_id);
        return students ; 
    }
    @Override
    public AddProfessorGroupResp getProfessorsToAdd(Integer group_id) throws IOException, SQLException {
        AddProfessorGroupResp professors = this.groupRepository.getProfessorsToAdd(group_id);
        return professors;
    }
    @Override
    public Boolean addDocument(AddDocRequest addDocRequest) throws IOException, SQLException {
        Boolean booleanResult = this.groupRepository.addDocument(addDocRequest);
        return booleanResult;
    }
    @Override
    public DocumentsGroup getDocumentsGroup(Integer group_id) throws IOException, SQLException {
        DocumentsGroup documentsGroup = this.groupRepository.getDocumentsGroup(group_id);
        return documentsGroup;
    }
    @Override
    public List<Module> getModulsNonAffected(Integer group_id) throws IOException, SQLException {
        List<Module> modules = this.groupRepository.getModulsNonAffected(group_id);
        return modules;
    }
    @Override
    public List<Module> getModulsAffected(Integer group_id) throws IOException, SQLException {
        List<Module> modules = this.groupRepository.getModulsAffected(group_id);
        return modules;
    }
    @Override
    public Boolean addModulGroup(AddModulGroupReq addModulGroupReq) throws IOException, SQLException {
        Boolean booleanResult = this.groupRepository.addModulGroup(addModulGroupReq);
        return booleanResult;
    }
    @Override
    public List<Module> getModulsNonAffectedToProfessors(Integer group_id) throws IOException, SQLException {
        List<Module> modulesNonAffected = this.groupRepository.getModulsNonAffectedToProfessors(group_id);
        return modulesNonAffected;
    }
    @Override
    public Boolean addAffectationProfessorToModul(AffectationModulRequest affectationModulRequest)
            throws IOException, SQLException {
        Boolean booleanResult = this.groupRepository.addAffectationProfessorToModul(affectationModulRequest);
        return booleanResult;
    }
    @Override
    public ModulProfessor getModuleAffectedToProfessors(Integer group_id) throws IOException, SQLException {
        ModulProfessor modulProfessor = this.groupRepository.getModuleAffectedToProfessors(group_id);
        return modulProfessor;
    }
    @Override
    public Boolean addProfessorToGroup(AddProfessorGroupRequest request) throws IOException, SQLException {
        Boolean booleanResult = this.groupRepository.addProfessorToGroup(request);
        return booleanResult;
    }
   
 
    


}
