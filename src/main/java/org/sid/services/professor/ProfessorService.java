package org.sid.services.professor;

import java.io.IOException;
import java.sql.SQLException;

import org.sid.DTO.authentication.AuthenticationRequest;
import org.sid.entities.Module;
import org.sid.entities.Group;
import org.sid.entities.Professor;
import java.util.*;


public interface ProfessorService {

    public Professor authenticateProfessor (AuthenticationRequest authenticationRequest) throws IOException, SQLException, IOException, SQLException;

    public List<Professor> getProfessors() throws IOException, SQLException;
    public Professor getProfessor(Integer professor_id) throws IOException, SQLException;

    public Professor getProfessor(int professor_id) throws IOException, SQLException;

    public List<Module> getModuls(int professor_id) throws IOException , SQLException ; 
    public List<Group> getGroups(int professor_id) throws IOException , SQLException ; 
    

}
