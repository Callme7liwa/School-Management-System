package org.sid.services.professor;

import org.sid.entities.Module;
import org.sid.entities.Group;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.sid.DAL.ProfessorRepositoryImpl;
import org.sid.DTO.authentication.AuthenticationRequest;
import org.sid.entities.Professor;
import org.sid.repositories.ProfessorRepository;
import org.sid.services.SupperService;

public class ProfessorServiceImpl  implements  ProfessorService{

    private final ProfessorRepository professorRepository ; 

    public ProfessorServiceImpl ()
    {
        this.professorRepository = SupperService.getProfessorRepositoryInstance();
    }


    @Override
    public Professor authenticateProfessor(AuthenticationRequest authenticationRequest) throws IOException, SQLException {
        Professor professor = this.professorRepository.authenticateProfessor(authenticationRequest.getEmail(), authenticationRequest.getPassword());
        return professor;
    }


    @Override
    public List<Professor> getProfessors() throws IOException, SQLException {
       List<Professor> professors = this.professorRepository.getProfessors();
       return professors;
    }


    @Override
    public Professor getProfessor(int professor_id) throws IOException, SQLException {
        Professor professor = this.professorRepository.getProfessor(professor_id);
        return professor ;
    }


    @Override
    public List<Module> getModuls(int professor_id) throws IOException, SQLException {
        List<Module> modules = this.professorRepository.getModules(professor_id);
        return modules;
    }


    @Override
    public List<Group> getGroups(int professor_id) throws IOException, SQLException {
        List<Group> groups = this.professorRepository.getGroups(professor_id);
        return groups;
    }


    @Override
    public Professor getProfessor(Integer professor_id) throws IOException, SQLException {
        Professor professor = this.professorRepository.getProfessor(professor_id);
        return professor;
    }
}
