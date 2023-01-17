package org.sid.DAL;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.sid.entities.Field;
import org.sid.entities.Group;
import org.sid.entities.Student;
import org.sid.DTO.field.request.FieldSaveRequest;
import org.sid.DTO.field.request.FieldUpdateRequest;
import org.sid.DTO.field.response.FieldEditResponseDao;
import org.sid.DTO.field.response.FieldResponseDao;
import org.sid.connection.DBConnection;
import org.sid.repositories.FieldRepository;
import org.sid.utils.FunctionUtils;

public class FieldRepositoryImpl extends RepositoryImplSuper<Field> implements FieldRepository{


    @Override
    public Boolean saveField(FieldSaveRequest fieldSaveRequest)  throws IOException , SQLException{
        try {
        this.dbConnection = new DBConnection();
        this.query = "INSERT INTO fields (field_name,field_abbreviation,field_description,field_creationDate) VALUES(?,?,?)";
        this.statement = this.dbConnection.connect().prepareStatement(query);
        this.statement.setString(1, fieldSaveRequest.getField_name());
        this.statement.setString(2, fieldSaveRequest.getField_abbreviation());
        this.statement.setString(3, fieldSaveRequest.getField_description());
        this.statement.setString(4, fieldSaveRequest.getField_creationDate());
        return this.statement.execute();
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally{
            this.statement.close();
            this.dbConnection.disconnect();
        }
        return false ; 
    }

    public FieldResponseDao getField(Integer field_id) throws IOException , SQLException {
        System.out.println("the id in field repository is => " + field_id);
        try {
            this.dbConnection = new DBConnection();
            this.query = "SELECT f.field_id , f.field_name , f.field_abbreviation  , "+
                         " (SELECT COUNT(*) FROM students WHERE field_id="+field_id+") as student_number , "+
                         " (SELECT COUNT(*) FROM groups   WHERE field_id="+field_id+") as group_number " +
                         " FROM fields f" + 
                         " WHERE f.field_id="+field_id+
                         " GROUP BY f.field_id";
            this.statement = this.dbConnection.connect().prepareStatement(query);
            this.resultSet = this.statement.executeQuery();
            FieldResponseDao fieldResponseDao  = new FieldResponseDao();
            while(this.resultSet.next())
            {   
                this.t = new Field();
                this.t.setField_id(this.resultSet.getInt("field_id"));
                this.t.setField_name(this.resultSet.getString("field_name"));
                this.t.setField_abbreviation(this.resultSet.getString("field_abbreviation"));
                System.out.println("all informations about the field are => " + this.t);
                System.out.println("all informations about the field are 2=> " + this.resultSet);
                fieldResponseDao.setField(this.t);
                fieldResponseDao.setStudent_number(this.resultSet.getInt("student_number"));
                fieldResponseDao.setGroup_number(this.resultSet.getInt("group_number"));
            }
            return fieldResponseDao ; 
            }catch(Exception e)
            {
                e.printStackTrace();
            }finally{
                this.statement.close();
                this.dbConnection.disconnect();
            }
        return null ;
    }

    @Override
    public List<Field> getFields() throws IOException, SQLException {
        try {
            this.dbConnection = new DBConnection();
            this.query = "SELECT * FROM fields";
            this.statement = this.dbConnection.connect().prepareStatement(query);
            this.resultSet = this.statement.executeQuery();
            this.t = new Field() ; 
            List<Field> fields = new ArrayList<Field>();
            while(this.resultSet.next())
            {
                this.t = new Field() ; 
                this.t.setField_id(this.resultSet.getInt("field_id"));
                this.t.setField_name(this.resultSet.getString("field_name"));
                this.t.setField_abbreviation(this.resultSet.getString("field_abbreviation"));
                this.t.setField_description(this.resultSet.getString("field_description"));
                fields.add(this.t);
            }
            return fields;
        }catch(Exception e ){
            e.printStackTrace();
        }finally{
           this.statement.close();
           this.dbConnection.disconnect(); 
        }
        return null  ;
    }

    @Override
    public List<Student> getStudentsField(Integer field_id) throws IOException, SQLException {
        try {
            this.dbConnection = new DBConnection();
            this.query = "SELECT * FROM students  WHERE  field_id="+field_id;
            this.statement = this.dbConnection.connect().prepareStatement(query);
            this.resultSet = this.statement.executeQuery();
            List<Student> students = new ArrayList<Student>();
            while(this.resultSet.next())
            {
                Student student = FunctionUtils.extractInfoStudentFromResultSet(resultSet) ;
                System.out.println("the student is => " + student);
                students.add(student); 
            }
            return students;
        }catch(Exception e ){
            e.printStackTrace();
        }finally{
           this.statement.close();
           this.dbConnection.disconnect(); 
        }
        return null  ;
    }

    @Override
    public List<Group> getGroupsByField(Integer field_id) throws IOException, SQLException {
        try {
            this.dbConnection = new DBConnection()  ; 
            this.query = "SELECT g.group_id , g.group_name , g.group_abbreviation , g.group_creationDate , g.field_id ,"+
                         " (SELECT f.field_abbreviation  FROM  fields f  WHERE  f.field_id = g.field_id ) as field_abbreviation , "+
                    " (SELECT f.field_name  FROM  fields f  WHERE  f.field_id = g.field_id ) as field_name , "+
                    " (SELECT l.level_abbreviation  FROM  levels l  WHERE  l.level_id = g.level_id ) as group_year "+
                         " FROM  groups g"+ 
                         " WHERE g.field_id="+field_id ;
            this.statement = this.dbConnection.connect().prepareStatement(query);
            this.resultSet = this.statement.executeQuery();
            List<Group> groupsOfField = new ArrayList<Group>();
            Group group  = new Group();
            while(this.resultSet.next())
            {
               group = FunctionUtils.extractInfoGroupFromResultSet(resultSet);
               groupsOfField.add(group);
            }
            return groupsOfField;
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
    public FieldEditResponseDao getFieldEdit(Integer field_id) throws IOException, SQLException {
        try {
            this.dbConnection = new DBConnection() ; 
            this.query = "SELECT f.field_id , f.field_name , f.field_abbreviation , f.field_creationDate , f.field_description FROM fields f " ; 
            this.statement = this.dbConnection.connect().prepareStatement(this.query);
            this.resultSet = this.statement.executeQuery();
            FieldEditResponseDao  fieldEditResponseDao = new FieldEditResponseDao();
            while(this.resultSet.next())
            {
                fieldEditResponseDao.setField_id(this.resultSet.getInt("field_id"));
                fieldEditResponseDao.setField_name(this.resultSet.getString("field_name"));
                fieldEditResponseDao.setField_abbreviation(this.resultSet.getString("field_abbreviation"));
                fieldEditResponseDao.setField_creationDate(this.resultSet.getDate("field_creationDate"));
                fieldEditResponseDao.setField_description(this.resultSet.getString("field_abbreviation"));
                System.out.println("the all informations =>" + fieldEditResponseDao);
                System.out.println("the date is =>" + fieldEditResponseDao.getField_creationDate());
                return fieldEditResponseDao;
            }
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
    public Boolean updateField(FieldUpdateRequest fieldUpdateRequest) throws SQLException {
        try {
            this.dbConnection = new DBConnection() ; 
            this.query = "UPDATE fields"+
                         " SET field_name="+fieldUpdateRequest.getField_name()+
                         " SET field_abbreviation="+fieldUpdateRequest.getField_abbreviation()+
                         " SET field_creationDate="+fieldUpdateRequest.getField_creationDate()+
                         " SET field_description="+fieldUpdateRequest.getField_description() +
                         " WHERE field_id="+fieldUpdateRequest.getField_id();
            this.statement = this.dbConnection.connect().prepareStatement(query);
            return this.statement.execute();
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally{
            this.statement.close();
            this.dbConnection.disconnect();
        }
        return null;
    }
    
}
