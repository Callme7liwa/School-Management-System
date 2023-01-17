package org.sid.DAL;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.sid.DTO.UtilsClass.FieldUtil;
import org.sid.DTO.UtilsClass.ModulFieldsUtil;
import org.sid.DTO.UtilsClass.ModulGroupUtil;
import org.sid.DTO.UtilsClass.ModulProfessorUtil;
import org.sid.DTO.modul.Request.CreateModulDto;
import org.sid.DTO.modul.Response.ModulFields;
import org.sid.DTO.modul.Response.ModulGroups;
import org.sid.DTO.modul.Response.ModulProfessors;
import org.sid.DTO.modul.Response.ModulResponseDto;
import org.sid.connection.DBConnection;
import org.sid.entities.Module;
import org.sid.repositories.ModuleRepository;
import org.sid.utils.FunctionUtils;

public class ModuleRepositoryImpl extends RepositoryImplSuper<Module> implements ModuleRepository  {

    @Override
    public Boolean saveModule(CreateModulDto modul) throws IOException, SQLException {
        try {
            this.dbConnection = new DBConnection()  ; 
            this.query = " INSERT INTO moduls (modul_name , modul_abbreviation , modul_creationDate)"+
                         " VALUES(?,?,?)";
            this.statement = this.dbConnection.connect().prepareStatement(this.query);
            this.statement.setString(1, modul.getModul_name());
            this.statement.setString(2, modul.getModul_abbreviation());
            this.statement.setString(3, modul.getModul_creationDate());
            return  this.statement.execute();

        }catch(Exception e)
        {
            e.printStackTrace();
        }finally{
            this.dbConnection.disconnect();
            this.statement.close();
        }
        return false ; 
    }

    @Override
    public ModulResponseDto getModule(Integer modul_id) throws IOException, SQLException {
        try {
            
            this.dbConnection = new DBConnection() ; 
            this.query = "SELECT m.modul_id , m.modul_name , m.modul_abbreviation , m.modul_creationDate  , " + 
                         " (SELECT COUNT(pm.professor_id)  FROM professor_moduls pm WHERE m.modul_id=pm.modul_id) as professors_number , "+
                         " (SELECT COUNT(gm.group_id) 'groups_number' FROM group_moduls gm WHERE m.modul_id=gm.modul_id) groups_number "+
                        " FROM moduls m "+
                        " WHERE m.modul_id="+modul_id ;
            this.statement = this.dbConnection.connect().prepareStatement(this.query);
            this.resultSet = this.statement.executeQuery();
            ModulResponseDto modul = null ; 
            while(this.resultSet.next())
            {
                modul = FunctionUtils.extractInfoModulExtraFromResultSet(resultSet);
                break ; 
            }
            this.resultSet.close();
            this.statement.close();
            this.dbConnection.disconnect();
            if(modul != null )
            {
                this.query = " SELECT f.field_id , f.field_abbreviation, f.field_name " + 
                             " FROM fields f  , groups p " + 
                             " WHERE f.field_id = p.field_id"+
                             " AND p.group_id IN ("+
                             " SELECT gm.group_id FROM group_moduls gm WHERE  gm.modul_id = "+modul.getModul_id()+  
                             ")"+
                             "GROUP BY f.field_id";
                this.statement = this.dbConnection.connect().prepareStatement(this.query);
                this.resultSet = this.statement.executeQuery();
                while(this.resultSet.next())
                {
                    FieldUtil fieldUtil = new FieldUtil();
                    fieldUtil.setField_id(this.resultSet.getInt("field_id"));
                    fieldUtil.setField_abbreviation(this.resultSet.getString("field_abbreviation"));
                    modul.getFields().add(fieldUtil);
                }
            }
            return modul;
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
    public List<ModulResponseDto> getModules() throws IOException, SQLException {
        this.dbConnection = new DBConnection() ; 
        this.query = "SELECT m.modul_id , m.modul_name , m.modul_abbreviation , m.modul_creationDate  , " + 
                     " (SELECT COUNT(pm.professor_id)  FROM professor_moduls pm WHERE m.modul_id=pm.modul_id) as professors_number , "+
                     " (SELECT COUNT(gm.group_id) 'groups_number' FROM group_moduls gm WHERE m.modul_id=gm.modul_id) groups_number "+
                    " FROM moduls m " ;
        this.statement = this.dbConnection.connect().prepareStatement(this.query);
        this.resultSet = this.statement.executeQuery();
        List<ModulResponseDto> moduls = new ArrayList<ModulResponseDto>();
        while(this.resultSet.next())
        {
            ModulResponseDto modul = FunctionUtils.extractInfoModulExtraFromResultSet(resultSet);
            moduls.add(modul);
        }
        this.resultSet.close();
        this.statement.close();
        this.dbConnection.disconnect();
        for(int i=0 ; i<moduls.size() ; i++)
        {
            this.query = " SELECT f.field_id , f.field_abbreviation, f.field_name " + 
                         " FROM fields f  , groups p " + 
                         " WHERE f.field_id = p.field_id"+
                         " AND p.group_id IN ("+
                         " SELECT gm.group_id FROM group_moduls gm WHERE  gm.modul_id = "+moduls.get(i).getModul_id()+  
                         ")"+
                         "GROUP BY f.field_id";
            this.statement = this.dbConnection.connect().prepareStatement(this.query);
            this.resultSet = this.statement.executeQuery();
            while(this.resultSet.next())
            {
                FieldUtil fieldUtil = new FieldUtil();
                fieldUtil.setField_id(this.resultSet.getInt("field_id"));
                fieldUtil.setField_abbreviation(this.resultSet.getString("field_abbreviation"));
                moduls.get(i).getFields().add(fieldUtil);
            }
        }
        return moduls;
    }

    @Override
    public Boolean deleteModule(Long moduleId) throws IOException, SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Module updateModule(Module Module) throws IOException, SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Module> getModulesByStudent(Long studentId) throws IOException, SQLException {
        this.dbConnection = new DBConnection();
        this.query =
        "SELECT m.* "+
        "FROM module m , group_module gm , students s "+
        "where s.student_id="+studentId+"and s.group_id = gm.group_id and m.module_id=gm.module_id"+
        "group by m.id";
        this.statement = this.dbConnection.connect().prepareStatement(query);
        this.resultSet = statement.executeQuery();
        this.list_t  = new ArrayList<>();
        Module module = new Module();
        while(this.resultSet.next())
        {
            module=FunctionUtils.extractInfoModuleFromResultSet(this.resultSet);
            this.list_t.add(module);
        }
        return this.list_t;
    }

    @Override
    public List<Module> getModulesByProfessor(Long professorId) throws IOException, SQLException {
        this.dbConnection = new DBConnection();
        this.query =
                "SELECT m.* "+
                        "FROM  group_module gm "+
                        "where gm.professorId = professorId"+
                        "group by m.id";
        this.statement = this.dbConnection.connect().prepareStatement(query);
        this.resultSet = statement.executeQuery();
        this.list_t = new ArrayList<>();

        while(this.resultSet.next())
        {
            this.t=FunctionUtils.extractInfoModuleFromResultSet(this.resultSet);
            this.list_t.add(this.t);
        }
        this.resultSet.close();
        this.statement.close();
        this.dbConnection.disconnect();
        return this.list_t;
    }

    @Override
    public List<Module> getModulesByGroup(Long groupId) throws IOException, SQLException {
        this.dbConnection = new DBConnection();
        this.query =
                "SELECT m.* "+
                        "FROM module m , group_module gm"+
                        "where s.id= and s.groupId = gm.groupId and m.id=gm.modulId"+
                        "group by m.id";

        this.statement = this.dbConnection.connect().prepareStatement(query);
        this.resultSet = statement.executeQuery();
        this.list_t = new ArrayList<>();
        while(this.resultSet.next())
        {
            this.t=FunctionUtils.extractInfoModuleFromResultSet(this.resultSet);
            this.list_t.add(this.t);
        }
        this.resultSet.close();
        this.statement.close();
        this.dbConnection.disconnect();
        return this.list_t;
    }

    @Override
    public List<Module> getModulesByField(Long groupId, int year , String fieldName) throws IOException, SQLException {
        this.dbConnection = new DBConnection();
        this.query =
                "SELECT m.* "+
                        "FROM module m , group_module gm , group g"+
                        "where s.id= and s.groupId = gm.groupId and m.id=gm.modulId and g.fieldName="+fieldName
                        +"group by m.id";
        this.statement = this.dbConnection.connect().prepareStatement(query);
        this.resultSet = statement.executeQuery();
        this.list_t = new ArrayList<>();
        while(this.resultSet.next())
        {
            this.t=FunctionUtils.extractInfoModuleFromResultSet(this.resultSet);
            this.list_t.add(this.t);
        }
        this.resultSet.close();
        this.statement.close();
        this.dbConnection.disconnect();
        return this.list_t;
    }

    @Override
    public ModulFields getFieldsByModul(Integer modul_id) throws IOException, SQLException {
        try {
            this.dbConnection  = new DBConnection() ; 
            this.query = "SELECT m.modul_id , m.modul_name, m.modul_abbreviation FROM moduls m WHERE m.modul_id="+modul_id;
            this.statement = this.dbConnection.connect().prepareStatement(query);
            this.resultSet = this.statement.executeQuery();
            ModulFields fields = new ModulFields() ; 
            ModulFieldsUtil field = null ; 
            while(this.resultSet.next())
            {
                fields.setModul_id(modul_id);
                fields.setModul_abbreviation(this.resultSet.getString("modul_abbreviation"));
                fields.setModul_name(this.resultSet.getString("modul_name"));
            }
            this.dbConnection.disconnect(); 
            this.statement.close();
            this.resultSet.close();

            this.query = " SELECT f.field_id , f.field_abbreviation, f.field_name " + 
                         " FROM fields f  , groups p " + 
                         " WHERE f.field_id = p.field_id"+
                         " AND p.group_id IN ("+
                         " SELECT gm.group_id FROM group_moduls gm WHERE  gm.modul_id = "+modul_id+  
                         ")"+
                         " GROUP BY f.field_id";
            this.statement = this.dbConnection.connect().prepareStatement(query);
            this.resultSet = this.statement.executeQuery();
            while(this.resultSet.next())
            {
                field = new ModulFieldsUtil() ; 
                field.setField_id(this.resultSet.getInt("field_id"));
                field.setField_name(this.resultSet.getString("field_name"));
                field.setField_abbreviation(this.resultSet.getString("field_abbreviation"));
                fields.getFields().add(field);
            }
            return fields ; 
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ModulGroups getGroupsByModul(Integer modul_id) throws IOException, SQLException {
        try {
            this.dbConnection  = new DBConnection() ; 
            this.query = "SELECT m.modul_id , m.modul_name, m.modul_abbreviation FROM moduls m WHERE m.modul_id="+modul_id;
            this.statement = this.dbConnection.connect().prepareStatement(query);
            this.resultSet = this.statement.executeQuery();
            ModulGroups groups = new ModulGroups() ; 
            ModulGroupUtil group = null ; 
            while(this.resultSet.next())
            {
                groups.setModul_id(modul_id);
                groups.setModul_abbreviation(this.resultSet.getString("modul_abbreviation"));
                groups.setModul_name(this.resultSet.getString("modul_name"));
            }
            this.dbConnection.disconnect(); 
            this.statement.close();
            this.resultSet.close();

            this.query = " SELECT g.group_id , g.group_abbreviation, g.group_name , (SELECT f.field_name FROM fields f WHERE f.field_id=g.field_id) field_abbreviation " + 
                         " FROM  groups g " + 
                         " WHERE g.group_id IN ("+
                         " SELECT gm.group_id FROM group_moduls gm WHERE  gm.modul_id = "+modul_id+  
                         ")";
            this.statement = this.dbConnection.connect().prepareStatement(query);
            this.resultSet = this.statement.executeQuery();
            while(this.resultSet.next())
            {
                group = new ModulGroupUtil() ; 
                group.setGroup_id(this.resultSet.getInt("group_id"));
                group.setGroup_name(this.resultSet.getString("group_name"));
                group.setGroup_abbreviation(this.resultSet.getString("group_abbreviation"));
                group.setGroup_fieldAbbreviation(this.resultSet.getString("field_abbreviation"));
                groups.getGroups().add(group);
            }
            return groups ; 
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ModulProfessors getProfessorsByModul(Integer modul_id) throws IOException, SQLException {
        try {
            this.dbConnection  = new DBConnection() ; 
            this.query = "SELECT m.modul_id , m.modul_name , m.modul_abbreviation FROM moduls m WHERE m.modul_id="+modul_id;
            this.statement = this.dbConnection.connect().prepareStatement(query);
            this.resultSet = this.statement.executeQuery();
            ModulProfessors professors = new ModulProfessors() ; 
            ModulProfessorUtil professor = null ; 
            while(this.resultSet.next())
            {
                professors.setModul_id(modul_id);
                professors.setModul_abbreviation(this.resultSet.getString("modul_abbreviation"));
                professors.setModul_name(this.resultSet.getString("modul_name"));
            }
            this.dbConnection.disconnect(); 
            this.statement.close();
            this.resultSet.close();

            this.query = " SELECT p.professor_id, p.professor_name , p.professor_secondName , p.professor_imagePath  , (SELECT d.departement_name from departements d where d.departement_id = p.departement_id) departement_name" +
                        " FROM professors p  ,  professor_moduls pm " +
                        " WHERE p.professor_id = pm.professor_id "+
                        " AND pm.modul_id = "+modul_id;
                         
            this.statement = this.dbConnection.connect().prepareStatement(query);
            this.resultSet = this.statement.executeQuery();
            while(this.resultSet.next())
            {
                professor = new ModulProfessorUtil() ; 
                professor.setProfessor_id(this.resultSet.getInt("professor_id"));
                professor.setProfessor_name(this.resultSet.getString("professor_name"));
                professor.setProfessor_secondName(this.resultSet.getString("professor_secondName"));
                professor.setProfessor_image(this.resultSet.getString("professor_imagePath"));
                professor.setProfessor_departementName(this.resultSet.getString("departement_name"));
                professors.getProfessors().add(professor);
            }
            return professors ; 
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Module getModul(Integer modul_id) throws IOException, SQLException {
        try {
            this.dbConnection = new DBConnection() ; 
            this.query = "SELECT m.modul_name , m.modul_abbreviation , m.modul_creationDate   FROM moduls  m WHERE m.modul_id="+modul_id ; 
            this.statement = this.dbConnection.connect().prepareStatement(this.query);
            this.resultSet = this.statement.executeQuery();
            Module module = null ; 
            while(this.resultSet.next())
            {
                module = new Module();
                module.setModul_id(modul_id);
                module.setModul_abbreviation(this.resultSet.getString("modul_abbreviation"));
                module.setModul_name(this.resultSet.getString("modul_name"));
                module.setModul_creationDate(this.resultSet.getDate("modul_creationDate"));
            }
            return module ; 
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    




}
