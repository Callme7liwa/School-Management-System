package org.sid.DAL;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.sid.connection.DBConnection;
import org.sid.entities.Group;
import org.sid.entities.Module;
import org.sid.entities.Professor;
import org.sid.repositories.ProfessorRepository;
import org.sid.utils.FunctionUtils;

public class ProfessorRepositoryImpl extends RepositoryImplSuper<Professor> implements ProfessorRepository{

    @Override
    public Professor saveProfessor(Professor professor) throws IOException , SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Professor updateProfessor(Professor professor) throws IOException , SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Professor getProfessor(int professor_id) throws IOException , SQLException {
        try {
            this.dbConnection  = new DBConnection();
            this.query = "SELECT * FROM professors where professor_id = ?" ; 
            this.statement = this.dbConnection.connect().prepareStatement(this.query);
            this.statement.setInt(1, professor_id);
            this.resultSet = this.statement.executeQuery();
            this.t = new Professor();
            while(this.resultSet.next())
            {
                this.t = FunctionUtils.exctractInfoProfessorFromResultSet(resultSet);
            }
    
            this.query =" SELECT COUNT(DISTINCT(pg.group_id))  groups_number FROM professor_groups pg WHERE pg.professor_id="+professor_id;
            this.statement = this.dbConnection.connect().prepareStatement(query);
            this.resultSet = this.statement.executeQuery() ; 
            while(this.resultSet.next())
            {
                this.t.setProfessor_groupNumber(this.resultSet.getInt("groups_number"));
            }
            this.query =" SELECT COUNT(DISTINCT(pm.modul_id))  moduls_number FROM professor_moduls pm WHERE pm.professor_id="+professor_id;
            this.statement = this.dbConnection.connect().prepareStatement(query);
            this.resultSet = this.statement.executeQuery() ; 
            while(this.resultSet.next())
            {
                this.t.setProfessor_modulNumber(this.resultSet.getInt("moduls_number"));
            }
            this.query =" SELECT d.departement_name FROM departements d , professors p where d.departement_id=p.departement_id and p.professor_id="+professor_id;
            this.statement = this.dbConnection.connect().prepareStatement(query);
            this.resultSet = this.statement.executeQuery() ; 
            while(this.resultSet.next())
            {
                this.t.setProfessor_departementName(this.resultSet.getString("departement_name"));
            }
            return this.t ; 
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally{
            this.dbConnection.disconnect();
            this.statement.close();
            this.resultSet.close();
        }
        return null;
    }

    @Override
    public Boolean deleteProfessor(int professor_id) throws IOException , SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Professor> getProfessors() throws IOException , SQLException {
        this.dbConnection  = new DBConnection();
        this.query = "SELECT * FROM professors" ; 
        this.statement = this.dbConnection.connect().prepareStatement(this.query);
        this.resultSet = this.statement.executeQuery();
        this.t = new Professor();
        this.list_t = new ArrayList<>();
        while(this.resultSet.next())
        {
            this.t = FunctionUtils.exctractInfoProfessorFromResultSet(resultSet);
            this.list_t.add(this.t);
        }
        return this.list_t;
    }

    @Override
    public Professor authenticateProfessor(String professor_email, String professor_password) throws IOException, SQLException {
        try {
            this.dbConnection = new DBConnection() ;
            this.query = "SELECT * FROM professors WHERE professor_email="+professor_email+"AND professor_password="+professor_password ; 
            this.statement = this.dbConnection.connect().prepareStatement(this.query);
            this.resultSet = this.statement.executeQuery();
            while(this.resultSet.next())
            {
                this.t.setProfessor_id(this.resultSet.getInt("professor_id"));
                this.t.setProfessor_name(this.resultSet.getString("professor_name"));
                this.t.setProfessor_email(this.resultSet.getString("professor_email"));
                this.t.setProfessor_password(this.resultSet.getString("professor_password"));
                return this.t;
            }
        }catch (Exception e)
        {
                e.printStackTrace();
        }finally {
                 this.statement.close();
                 this.dbConnection.disconnect();
        }
        return null;
    }

    
    @Override
    public List<Module> getModules(int professor_id) throws IOException , SQLException {
        try {
            this.dbConnection = new DBConnection() ; 
            this.query = " SELECT m.modul_id ,  m.modul_name , m.modul_abbreviation " + 
                         " FROM moduls m   " + 
                         " WHERE m.modul_id IN (" + 
                            " SELECT DISTINCT(pm.modul_id) " + 
                            " FROM professor_moduls pm" +
                            " WHERE pm.professor_id="+professor_id+
                        ")";
            this.statement = this.dbConnection.connect().prepareStatement(query);
            this.resultSet = this.statement.executeQuery();
            List<Module> moduls = new ArrayList<Module>();
            while(this.resultSet.next())
            {
                Module modul = FunctionUtils.extractInfoModuleFromResultSet(resultSet);
                moduls.add(modul);
            }
            return moduls;
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally{
            this.resultSet.close();
            this.statement.close();
            this.dbConnection.disconnect();
        }
        return null;
    }


    @Override
    public List<Group> getGroups(Integer professor_id) throws IOException, SQLException {
        try {
            this.dbConnection = new DBConnection()  ; 
            this.query = "SELECT g.group_id , g.group_name , g.group_abbreviation ,  g.group_creationDate , g.field_id , " +
                         " (SELECT f.field_abbreviation  FROM  fields f  WHERE  f.field_id = g.field_id ) as field_abbreviation , " +
                         " (SELECT f.field_name  FROM  fields f  WHERE  f.field_id = g.field_id ) as field_name , " +
                         " (SELECT l.level_abbreviation  FROM  levels l  WHERE  l.level_id = g.level_id ) as group_year"+
                         " FROM  groups g" ;
            this.statement = this.dbConnection.connect().prepareStatement(query);
            this.resultSet = this.statement.executeQuery();
            List<Group> groups = new ArrayList<Group>();
            while(this.resultSet.next())
            {
               Group group = FunctionUtils.extractInfoGroupFromResultSet(resultSet);
               System.out.println("the group in group repository impl =>" + this.t);
               groups.add(group);
            }
            return groups;
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally{
            this.statement.close();
            this.dbConnection.disconnect();
        }
        return null;
    }

    @Override
    public Professor getPersonalInformation(Integer professor_id) throws IOException, SQLException {
        this.dbConnection  = new DBConnection();
        this.query = "SELECT * FROM professors where professor_id = ?" ; 
        this.statement = this.dbConnection.connect().prepareStatement(this.query);
        this.statement.setInt(1, professor_id);
        this.resultSet = this.statement.executeQuery();
        this.t = null;
        while(this.resultSet.next())
        {
            this.t = FunctionUtils.exctractInfoProfessorFromResultSet(resultSet);
            return this.t;
        }
        return this.t;
    }

}
