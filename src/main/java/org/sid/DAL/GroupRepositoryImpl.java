package org.sid.DAL;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.sid.DTO.UtilsClass.GroupDocUtil;
import org.sid.DTO.UtilsClass.ModulProfessorAffectationUtil;
import org.sid.DTO.UtilsClass.ModulProfessorUtil;
import org.sid.DTO.UtilsClass.ProfessorUtil;
import org.sid.DTO.UtilsClass.StudentUtil;
import org.sid.DTO.group.request.AddDocRequest;
import org.sid.DTO.group.request.AddModulGroupReq;
import org.sid.DTO.group.request.AddProfessorGroupRequest;
import org.sid.DTO.group.request.AffectationModulRequest;
import org.sid.DTO.group.response.AddProfessorGroupResp;
import org.sid.DTO.group.response.AddStudentGroupResp;
import org.sid.DTO.group.response.DocumentsGroup;
import org.sid.DTO.group.response.InfoGroupDaoResponse;
import org.sid.DTO.group.response.ModulProfessor;
import org.sid.connection.DBConnection;
import org.sid.entities.Group;
import org.sid.entities.Module;
import org.sid.entities.Professor;
import org.sid.entities.Student;
import org.sid.repositories.GroupRepository;
import org.sid.utils.FunctionUtils;


public class GroupRepositoryImpl extends RepositoryImplSuper<Group> implements GroupRepository {


    // **************************************************** GET METHOD **************************************************************************************//

    @Override
    public InfoGroupDaoResponse getGroup(Integer group_id) throws IOException, SQLException {
        try {
            this.dbConnection = new DBConnection() ; 
            this.query = "SELECT g.group_id , g.group_name , g.group_abbreviation , g.group_creationDate , g.field_id , "+
                        " ( SELECT COUNT(*) FROM student_groups sp WHERE sp.group_id = g.group_id ) AS students_number , "+
                        " ( SELECT COUNT(*) FROM group_moduls gp WHERE gp.group_id = g.group_id ) AS moduls_number , "+
                        " ( SELECT f.field_abbreviation FROM fields f WHERE f.field_id = g.field_id ) AS field_abbreviation , " +
                        " ( SELECT f.field_name FROM fields f WHERE f.field_id = g.field_id ) AS field_name , " +
                        " ( SELECT COUNT(*) FROM professor_groups pg WHERE pg.group_id = g.group_id ) AS professors_number , " +
                        " (SELECT l.level_name FROM  levels l  WHERE  l.level_id = g.level_id ) as group_year " + 
                        " FROM groups g WHERE g.group_id="+group_id;
            this.statement = this.dbConnection.connect().prepareStatement(query);
            this.resultSet = this.statement.executeQuery();
            InfoGroupDaoResponse responseDao = null ; 
            while(this.resultSet.next())
            {
                 responseDao = FunctionUtils.extractSpecialInfoGroupFromResultSet(resultSet);
                 System.out.println("THE SPECIAL INFO OF THE FIELD ARE" + responseDao);
            }
            return responseDao;
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally{
            this.resultSet.close();
            this.statement.close();
            this.dbConnection.disconnect();;
        }
        return null;
    }

    @Override
    public List<Group> getGroups() throws IOException, SQLException {
        try {
            this.dbConnection = new DBConnection()  ; 
            this.query = "SELECT g.group_id , g.group_name , g.group_abbreviation , g.group_creationDate ,  g.field_id , "+
                         " (SELECT f.field_abbreviation  FROM  fields f  WHERE  f.field_id = g.field_id ) as field_abbreviation , "+
                         " (SELECT f.field_name  FROM  fields f  WHERE  f.field_id = g.field_id ) as field_name , "+
                         " (SELECT l.level_abbreviation  FROM  levels l  WHERE  l.level_id = g.level_id ) as group_year "+
                         " FROM  groups g" ;
            this.statement = this.dbConnection.connect().prepareStatement(query);
            this.resultSet = this.statement.executeQuery();
            this.list_t = new ArrayList<Group>();
            this.t = new Group();
            while(this.resultSet.next())
            {
               this.t = FunctionUtils.extractInfoGroupFromResultSet(resultSet);
               System.out.println("the group in group repository impl =>" + this.t);
               this.list_t.add(this.t);
            }
            return this.list_t;
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
    public List<Group> getGroupByLevel(Integer level_id) throws IOException, SQLException {
        
        try {
            this.dbConnection = new DBConnection()  ; 
            this.query = "SELECT g.field_id ,  g.group_name , g.group_creationDate" +
                         "FROM groups p "+
                         "WHERE p.level_id ="+level_id  ;
            this.statement = this.dbConnection.connect().prepareStatement(this.query);
            this.resultSet = this.statement.executeQuery();
            this.list_t = new ArrayList<>();
            while(this.resultSet.next())
            {
                this.t.setGroup_id(this.resultSet.getInt("group_id"));
                this.t.setGroup_name(this.resultSet.getString("group_name"));
                this.t.setGroup_creationDate(this.resultSet.getDate("group_description"));
                this.list_t.add(this.t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.statement.close();
            this.dbConnection.disconnect();
        }
        return this.list_t ; 
    }

    // CALLED FROM FIELD SERVICE
    @Override
    public List<Group> getGroupByField(Integer field_id) throws IOException, SQLException {
        try {
            this.dbConnection = new DBConnection()  ; 
            this.query = "SELECT g.group_id ,  g.group_name , g.group_creationDate" +
                         "FROM groups p "+
                         "WHERE p.field_id ="+field_id  ;
            this.statement = this.dbConnection.connect().prepareStatement(this.query);
            this.resultSet = this.statement.executeQuery();
            this.list_t = new ArrayList<>();
            while(this.resultSet.next())
            {
                this.t.setGroup_id(this.resultSet.getInt("group_id"));
                this.t.setGroup_name(this.resultSet.getString("group_name"));
                this.t.setGroup_creationDate(this.resultSet.getDate("group_creationDate"));
                this.list_t.add(this.t);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally{
            this.statement.close();
            this.dbConnection.disconnect();
        }
        return this.list_t;
    }

    @Override
    public List<Student> getStudents(Integer group_id) throws IOException, SQLException {
        try {
            this.dbConnection = new DBConnection()  ; 
            this.query = "SELECT s.* FROM students s , student_groups sp WHERE sp.group_id="+group_id+" AND s.student_id = sp.student_id";

            this.statement = this.dbConnection.connect().prepareStatement(this.query);
            this.resultSet = this.statement.executeQuery();
            List<Student> students = new ArrayList<>();
            while(this.resultSet.next())
            {
                Student student = new Student();
                student = FunctionUtils.extractInfoStudentFromResultSet(resultSet);
                students.add(student);
            }
            return students ; 
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally{
            this.statement.close();
            this.dbConnection.disconnect();
        }
        return  null;
    }

    @Override
    public List<Professor> getProfessors(Integer group_id) throws IOException, SQLException {
        try {
            this.dbConnection = new DBConnection()  ; 
            this.query = "SELECT p.* FROM professors p , professor_groups pg  WHERE pg.group_id="+group_id+" AND p.professor_id = pg.professor_id ORDER BY p.professor_name , p.professor_secondName";
            this.statement = this.dbConnection.connect().prepareStatement(this.query);
            this.resultSet = this.statement.executeQuery();
            List<Professor> professors = new ArrayList<>();
            while(this.resultSet.next())
            {
                Professor professor = FunctionUtils.extractInfoProfessorFromResultSet(resultSet);
                System.out.println(" the id of professor is =>" + professor.getProfessor_id());
                professors.add(professor);
            }
            return professors ; 
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally{
            this.statement.close();
            this.dbConnection.disconnect();
        }
        return  null;
    }

    @Override
    public AddStudentGroupResp getStudentToAdd(Integer group_id) throws IOException, SQLException {
        try {
            this.dbConnection = new DBConnection();
            this.query = "SELECT level_id , field_id , group_abbreviation from groups where group_id="+group_id;
            this.statement = this.dbConnection.connect().prepareStatement(this.query);
            this.resultSet = this.statement.executeQuery();
            int level_id = 0   , field_id = 0  ;
            String group_abbreviation=""; 
            while(this.resultSet.next())
            {
                level_id = this.resultSet.getInt("level_id");
                field_id = this.resultSet.getInt("field_id");
                group_abbreviation = this.resultSet.getString("group_abbreviation");
            }
            this.resultSet.close();
            this.statement.close();
            // Student should be in the same level , and the field of the group , and we verify firstly every one is not already in the group . 
            this.query = " SELECT s.student_id , s.student_name , s.student_secondName " +
                         " FROM students s " + 
                         " WHERE s.student_id NOT IN  ( SELECT DISTINCT(student_id) FROM student_groups) "+
                         " AND s.level_id="+level_id+
                         " AND s.field_id="+field_id;
            this.statement = this.dbConnection.connect().prepareStatement(this.query);
            this.resultSet = this.statement.executeQuery();
            AddStudentGroupResp addStudentGroupResp = new AddStudentGroupResp();
            addStudentGroupResp.setGroup_id(group_id);
            addStudentGroupResp.setGroup_abbreviation(group_abbreviation);
            while(this.resultSet.next())
            {
                String fullName = this.resultSet.getString("student_name")+" "+this.resultSet.getString("student_secondName"); 
                Integer student_id = this.resultSet.getInt("student_id");
                addStudentGroupResp.getListStudents().add(new StudentUtil(fullName,student_id));
            }
            return addStudentGroupResp ; 
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
    public AddProfessorGroupResp getProfessorsToAdd(Integer group_id) throws IOException, SQLException {
        try {

            this.dbConnection = new DBConnection();
            this.query = "SELECT group_abbreviation from groups where group_id="+group_id;
            this.statement = this.dbConnection.connect().prepareStatement(this.query);
            this.resultSet = this.statement.executeQuery();
            String group_abbreviation=""; 
            while(this.resultSet.next())
            {
                group_abbreviation = this.resultSet.getString("group_abbreviation");
            }
            this.resultSet.close();
            this.statement.close();
            //
            AddProfessorGroupResp addProfessorGroupResp = new AddProfessorGroupResp() ; 
            addProfessorGroupResp.setGroup_id(group_id);
            addProfessorGroupResp.setGroup_abbreviation(group_abbreviation);
            this.query = 
            " SELECT p.professor_id , p.professor_name , p.professor_secondName , (SELECT d.departement_name FROM departements d WHERE p.departement_id = d.departement_id) as departement_name  " + 
            " FROM professors p " + 
            " WHERE  p.professor_id NOT IN ( SELECT DISTINCT(pg.professor_id) FROM professor_groups pg WHERE pg.group_id = "+group_id+")";
            this.statement = this.dbConnection.connect().prepareStatement(this.query);
            this.resultSet = this.statement.executeQuery() ; 
            while(this.resultSet.next())
            {
                Integer professor_id = this.resultSet.getInt("professor_id");
                String fullName = this.resultSet.getString("professor_name")+" "+this.resultSet.getString("professor_secondName"); 
                String departement_name = this.resultSet.getString("departement_name");
                addProfessorGroupResp.getProfessors().add(new ProfessorUtil(professor_id , fullName , departement_name));
            }
            return addProfessorGroupResp ; 
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
    public  DocumentsGroup getDocumentsGroup(Integer group_id) throws IOException, SQLException {
        try {
            this.dbConnection = new DBConnection() ; 
            this.query = "SELECT g.group_name , g.group_abbreviation FROM groups g WHERE g.group_id="+group_id ;
            this.statement = this.dbConnection.connect().prepareStatement(query);
            this.resultSet = this.statement.executeQuery(query);
            DocumentsGroup documentsGroup = new DocumentsGroup() ; 
            while(this.resultSet.next())
            {
                documentsGroup.setGroup_id(group_id);
                documentsGroup.setGroup_abbreviation(this.resultSet.getString("group_abbreviation"));
                documentsGroup.setGroup_name(this.resultSet.getString("group_name"));
            }
            this.resultSet.close(); 
            this.dbConnection.disconnect(); 
            this.statement.close(); 

            this.query = "SELECT gd.doc_name , gd.group_doc_path , gd.doc_extension FROM group_docs gd WHERE gd.group_id="+group_id ; 
            this.statement = this.dbConnection.connect().prepareStatement(query);
            this.resultSet = this.statement.executeQuery();
            GroupDocUtil groupDocUtil = null ; 
            while(this.resultSet.next())
            {
                groupDocUtil = new GroupDocUtil();
                groupDocUtil.setDocument_name(this.resultSet.getString("doc_name"));
                groupDocUtil.setDocument_path(this.resultSet.getString("group_doc_path"));
                groupDocUtil.setDocument_extension(this.resultSet.getString("doc_extension"));
                documentsGroup.getDocuments().add(groupDocUtil);
            }
            return documentsGroup ; 
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally{
            this.dbConnection.disconnect();
            this.resultSet.close();
            this.statement.close();
        }
        return null ;
    }

    @Override
    public List<Module> getModulsNonAffected(Integer group_id) throws IOException, SQLException {
        try {
            this.dbConnection = new DBConnection()  ; 
            this.query = "SELECT m.modul_name , m.modul_abbreviation , m.modul_id " +
                         " FROM moduls m " + 
                         " WHERE m.modul_id NOT IN ( "+
                         " SELECT m.modul_id"+
                         " FROM group_moduls gm"+
                         " WHERE gm.group_id="+group_id+
                         ") ";
            this.statement = this.dbConnection.connect().prepareStatement(query);
            this.resultSet = this.statement.executeQuery();
            List<Module> moduls = new ArrayList<Module>();
            Module modul = null ; 
            while(this.resultSet.next())
            {
                modul = new Module();
                modul.setModul_id(this.resultSet.getInt("modul_id"));
                modul.setModul_name(this.resultSet.getString("modul_name"));
                modul.setModul_abbreviation(this.resultSet.getString("modul_abbreviation"));
                moduls.add(modul);
            }
            return moduls ; 
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Module> getModulsAffected(Integer group_id) throws IOException, SQLException {
        try {
            this.dbConnection = new DBConnection()  ; 
            this.query = "SELECT m.modul_name , m.modul_abbreviation , m.modul_id " +
                         " FROM moduls m " + 
                         " WHERE m.modul_id  IN ( "+
                         " SELECT m.modul_id"+
                         " FROM group_moduls gm"+
                         " WHERE gm.group_id="+group_id+
                         ") ";
            this.statement = this.dbConnection.connect().prepareStatement(query);
            this.resultSet = this.statement.executeQuery();
            List<Module> moduls = new ArrayList<Module>();
            Module modul = null ; 
            while(this.resultSet.next())
            {
                modul = new Module();
                modul.setModul_id(this.resultSet.getInt("modul_id"));
                modul.setModul_name(this.resultSet.getString("modul_name"));
                modul.setModul_abbreviation(this.resultSet.getString("modul_abbreviation"));
                moduls.add(modul);
            }
            return moduls ; 
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally {
            this.dbConnection.disconnect(); 
            this.statement.close();
        }
        return null;
    }

    @Override
    public List<Module> getModulsNonAffectedToProfessors(Integer group_id)     throws IOException, SQLException { 
        try{
            this.dbConnection  = new DBConnection();
            this.query = " SELECT m.modul_id , m.modul_name ,m.modul_abbreviation" + 
                         " FROM moduls m " + 
                         " WHERE m.modul_id IN ( SELECT gm.modul_id FROM group_moduls gm WHERE gm.group_id="+group_id+")"+ 
                         " AND   m.modul_id NOT IN (SELECT gmp.modul_id FROM  group_modul_professor gmp WHERE gmp.group_id="+group_id+") " ; 
            this.statement = this.dbConnection.connect().prepareStatement(this.query);
            this.resultSet = this.statement.executeQuery(query);
            List<Module> modules = new ArrayList<Module>() ;
            while(this.resultSet.next())
            {
                Module module = new Module() ; 
                module.setModul_id(this.resultSet.getInt("modul_id"));
                module.setModul_name(this.resultSet.getString("modul_name"));
                module.setModul_abbreviation(this.resultSet.getString("modul_abbreviation"));
                modules.add(module);
            }
            return modules ; 
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally {
            this.dbConnection.disconnect(); 
            this.statement.close();
        }
        return null;
    }

    @Override
    public ModulProfessor getModuleAffectedToProfessors(Integer group_id) throws IOException, SQLException {
        try {
            this.dbConnection  = new DBConnection();
            this.query = " SELECT g.group_id , g.group_name , g.group_abbreviation FROM groups g where g.group_id="+group_id;
            this.statement = this.dbConnection.connect().prepareStatement(query);
            this.resultSet = this.statement.executeQuery();
            ModulProfessor modulProfessor = new ModulProfessor() ; 
            while(this.resultSet.next())
            {
                modulProfessor.setGroup_id(resultSet.getInt("group_id"));
                modulProfessor.setGroup_name(resultSet.getString("group_name"));
                modulProfessor.setGroup_abbreviation(resultSet.getString("group_abbreviation"));
            }
            this.resultSet.close();
            this.statement.close();
            this.query = " SELECT m.modul_id , m.modul_name , m.modul_abbreviation ,"+
                         " p.professor_id , p.professor_name , p.professor_secondName , p.professor_imagePath  " + 
                         " FROM professors p , moduls m , group_modul_professor gmp "+
                         " WHERE gmp.group_id="+group_id+
                         " AND gmp.modul_id =m.modul_id"+
                         " AND gmp.professor_id=p.professor_id";
                        
            this.statement = this.dbConnection.connect().prepareStatement(query);
            this.resultSet = this.statement.executeQuery();
            while(this.resultSet.next())
            {
                ModulProfessorAffectationUtil affectation = FunctionUtils.extractInformationModulProfessorFromResultSet(resultSet);
                modulProfessor.getModuls_professors().add(affectation);
            }
            return modulProfessor;
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }


    //******************************************************** POST *********************************************************** */

    @Override
    public Boolean addDocument(AddDocRequest addDocRequest) throws IOException, SQLException {
        try {
            this.dbConnection = new DBConnection() ; 
            this.query = "INSERT INTO group_docs  (group_id , group_doc_path , doc_name , doc_extension)"+
                         "VALUES (?,?,?,?)";
            this.statement = this.dbConnection.connect().prepareStatement(query);
            this.statement.setInt( 1, addDocRequest.getGroup_id());
            this.statement.setString(2, addDocRequest.getFile_path());
            this.statement.setString(3, addDocRequest.getFile_name());
            this.statement.setString(4, addDocRequest.getFile_extension());
            return this.statement.execute();
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally{
            this.dbConnection.disconnect();
            this.statement.close();
        }
        return false;
    } 

    @Override
    public Boolean addModulGroup(AddModulGroupReq addModulGroupReq) throws IOException, SQLException {
        
        try{
            this.dbConnection  = new DBConnection();
            this.query = "INSERT INTO group_moduls(modul_id,group_id,affectation_date )"+
                         " VALUES(?,?,?)" ; 
            this.statement = this.dbConnection.connect().prepareStatement(this.query);
            this.statement.setInt(1 , addModulGroupReq.getModul_id());
            this.statement.setInt(2, addModulGroupReq.getGroup_id());
            this.statement.setString(3,addModulGroupReq.getAffectation_date());
            Boolean booleanResult = this.statement.execute();
            return booleanResult;
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally {
            this.dbConnection.disconnect(); 
            this.statement.close();
        }
        return false;
    }

   
    @Override
    public Boolean addAffectationProfessorToModul(AffectationModulRequest affectationModulRequest)
            throws IOException, SQLException {
        try {
            this.dbConnection  = new DBConnection();
            this.query = " INSERT INTO group_modul_professor (modul_id , professor_id , group_id)  " +
                         " VALUES(?,?,?)";
            this.statement = this.dbConnection.connect().prepareStatement(query);
            this.statement.setInt(1,affectationModulRequest.getModul_id());
            this.statement.setInt(2,affectationModulRequest.getProfessor_id());
            this.statement.setInt(3,affectationModulRequest.getGroup_id());
            Boolean booleanResult = this.statement.execute();
            return booleanResult;
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean addProfessorToGroup(AddProfessorGroupRequest request) throws IOException, SQLException {
        try {
            this.dbConnection = new DBConnection() ; 
            this.query = " INSERT INTO professor_groups (group_id , professor_id )" + 
                         " VALUES( ? , ? )"  ; 
            this.statement = this.dbConnection.connect().prepareStatement(query);
            this.statement.setInt(1, request.getGroup_id());
            this.statement.setInt(2, request.getProfessor_id());
            Boolean booleanResult = this.statement.execute();
            return booleanResult ; 
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

 


    
}
