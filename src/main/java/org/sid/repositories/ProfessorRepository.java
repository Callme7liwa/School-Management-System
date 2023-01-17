package org.sid.repositories;

import org.sid.entities.Group;
import org.sid.entities.Module;
import org.sid.entities.Professor;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface ProfessorRepository {

    public Professor saveProfessor(Professor professor) throws IOException , SQLException ;
    public Professor updateProfessor(Professor professor) throws IOException , SQLException ;
    public Professor getProfessor(int professor_id) throws IOException , SQLException ;
    public Professor getPersonalInformation(Integer professor_id)throws IOException , SQLException ;
    public Boolean deleteProfessor(int professor_id) throws IOException , SQLException ;
    public List<Professor> getProfessors() throws IOException , SQLException ;
    public List<Module> getModules(int professor_id) throws IOException , SQLException ;
    public List<Group> getGroups(Integer professor_id) throws IOException , SQLException ; 
    public Professor authenticateProfessor(String professor_email , String professor_password) throws IOException, SQLException  ;
    
}
