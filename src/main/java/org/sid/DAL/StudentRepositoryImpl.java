package org.sid.DAL;

import org.sid.DTO.UtilsClass.GroupUtil;
import org.sid.DTO.absence.Request.CreateAbsenceDto;
import org.sid.DTO.absence.Request.DeleteAbsenceRequest;
import org.sid.DTO.absence.Request.NewAbsenceRequest;
import org.sid.DTO.absence.Response.AbsenceOneResponsDto;
import org.sid.DTO.absence.Response.AbsenceResponsDto;
import org.sid.DTO.level.Response.LevelListResponseDTO;
import org.sid.DTO.level.Response.LevelResponseDto;
import org.sid.DTO.mark.Request.UpdateMarkRequest;
import org.sid.DTO.mark.Response.MarkResponse;
import org.sid.DTO.student.request.StudentRequest;
import org.sid.DTO.student.request.UpdatePersonnalStudent;
import org.sid.DTO.student.response.StudentScholarInfo;
import org.sid.connection.DBConnection;
import org.sid.entities.Student;
import org.sid.repositories.StudentRepository;
import org.sid.utils.AbsenceDate;
import org.sid.utils.FunctionUtils;
import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl  extends RepositoryImplSuper<Student> implements StudentRepository {


    @Override
    public Boolean saveStudent(StudentRequest student) throws IOException, SQLException {
        try {
            this.dbConnection = new DBConnection();
            this.query = "INSERT INTO Student(student_name,student_secondName,student_email ,student_birthday,student_gender,student_city,student_country,student_nationality,student_cin,student_cne,student_adress,student_phoneNumber) VALUES(?,?,?,?,?,?,?,?)";
            this.statement = this.dbConnection.connect().prepareStatement(query);
    
            this.statement.setString(1,student.getStudent_name());
            this.statement.setString(2,student.getStudent_secondName());
            this.statement.setString(3,student.getStudent_email());
            this.statement.setString(4,  student.getStudent_birthday());
            this.statement.setString(5,student.getStudent_gender());
            this.statement.setString(6,student.getStudent_city());
            this.statement.setString(7,student.getStudent_country());
            this.statement.setString(8,student.getStudent_nationality());
            this.statement.setString(9,student.getStudent_cin());
            this.statement.setString(10,student.getStudent_cne());
            this.statement.setString(11, student.getStudent_adress());
            this.statement.setString(12, student.getStudent_phone());
            this.statement.execute();
            this.statement.close();
            this.dbConnection.disconnect();
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally {
            this.statement.close();
            this.dbConnection.disconnect();
        }
        return false ;
    }
    

    @Override
    public Student getStudent(int studentId) throws IOException, SQLException {
        this.dbConnection = new DBConnection();
        // this.query = " SELECT student_id , student_name , student_secondName , student_email , student_birthday , student_nationality , student_country , student_city , student_adress , student_phoneNumber , student_gender"+
        //              " FROM students WHERE student_id=?";
        this.query = " SELECT * "+
                     " FROM students WHERE student_id=?";
        this.statement = this.dbConnection.connect().prepareStatement(query);
        this.statement.setInt(1, studentId);
        this.resultSet = this.statement.executeQuery();
        this.t=new Student();
        while(this.resultSet.next())
        {
            this.t=FunctionUtils.extractInfoStudentFromResultSet(this.resultSet);
        }
        this.statement.close();
        this.resultSet.close();
        this.dbConnection.disconnect();
        return this.t   ;
    }

    @Override
    public List<Student> getStudents() throws IOException, SQLException  {
        this.dbConnection = new DBConnection();
        this.query = "SELECT * FROM students";
        this.statement = this.dbConnection.connect().prepareStatement(query);
        this.resultSet = statement.executeQuery();
        this.list_t = new ArrayList<Student>();
        this.t = new Student();
        while(this.resultSet.next())
        {
            this.t =  FunctionUtils.extractInfoStudentFromResultSet(this.resultSet);
            this.list_t.add(this.t);
        }
        System.out.println("on a trouver jusqu'a " + this.list_t.size());
        this.statement.close();
        this.resultSet.close();
        this.dbConnection.disconnect();
        return this.list_t; 
    }

    @Override
    public Boolean deleteStudent(Integer studentId) throws IOException, SQLException {
        this.dbConnection = new DBConnection();
        this.query = "SELECT * FROM students where student_id="+studentId ; 
        this.statement = this.dbConnection.connect().prepareStatement(query);
        if(statement.executeUpdate() > 0)
            return true ; 
        return false ;  
    }

    @Override
    public Boolean updateStudent(UpdatePersonnalStudent student) throws IOException, SQLException {
        this.dbConnection = new DBConnection();
        // this.query = " UPDATE students " +
        //              " SET student_name = "+student.getStudent_name()+
        //              " , " +
        //              "  student_secondName = "+student.getStudent_name()+
        //              " , " +
        //              "  student_city = "+student.getStudent_city()+
        //              " , " +
        //              "  student_country = "+student.getStudent_country()+
        //              " , " +
        //              "  student_phoneNumber = "+student.getStudent_phone()+
        //              " , " +
        //              "  student_nationality = "+student.getStudent_nationality()+
        //              " , " +
        //              "  student_gender = "+student.getStudent_gender()+
        //              " , " +
        //              "  student_birthday = "+student.getStudent_birthday()+
        //              " , " +
        //              "  student_image =" + student.getStudent_image() + 
        //              " , " +
        //              "  student_email =" +student.getStudent_email() + 
        //              "  WHERE student_id = "+ student.getStudent_id()  ; 
        this.query = " UPDATE students  " +
                     " SET student_name = ?  , student_secondName = ? , student_city = ? , student_country = ? , " + 
                     " student_phoneNumber = ? , student_nationality = ? , student_gender = ?  , " +
                     " student_birthday = ? , student_image = ?  , student_email = ? "  + 
                     " WHERE student_id =  ? ";

        System.out.println("the value of the gender => " + student.getStudent_gender());
        this.statement  = this.dbConnection.connect().prepareStatement(this.query);
        this.statement.setString(1, student.getStudent_name());
        this.statement.setString(2, student.getStudent_secondName());
        this.statement.setString(3, student.getStudent_city());
        this.statement.setString(4 ,student.getStudent_country() );
        this.statement.setString(5 ,student.getStudent_phone());
        this.statement.setString(6 ,student.getStudent_nationality());
        this.statement.setString(7 ,student.getStudent_gender());
        this.statement.setString(8 ,student.getStudent_birthday());
        this.statement.setString(9 ,student.getStudent_image());
        this.statement.setString(10 ,student.getStudent_email());
        this.statement.setInt(11 ,student.getStudent_id());
        Boolean booleanResult = this.statement.execute();
        return booleanResult ; 
    }

    @Override
    public List<Student> getStudentsByYear(String level_name) throws IOException, SQLException {
            return null ; 
    }

    @Override
    public List<Student> getStudentsByGroup(Integer group_id) throws IOException, SQLException {
        this.dbConnection = new DBConnection();
        this.query = "SELECT s.* " +
                " FROM students s  , student_group sp"+
                " WHERE  s.student_id=sp.student_id"+
                " AND sp.group_id="+group_id;
        this.statement = this.dbConnection.connect().prepareStatement(query);
        this.resultSet = this.statement.executeQuery();
        this.list_t = new ArrayList<>();
        while(this.resultSet.next())
        {
            this.t=FunctionUtils.extractInfoStudentFromResultSet(this.resultSet);
            this.list_t.add(this.t);
        }
        this.statement.close();
        this.resultSet.close();
        this.dbConnection.disconnect();
        return this.list_t ;
    }

    //  CALLED FROM FIELD SERVICE 
    @Override
    public List<Student> getStudentsByField(Integer field_id) throws IOException, SQLException {
        try {
            this.dbConnection = new DBConnection();
            this.query = "SELECT f.student_id , f.student_name , f.student_secondName , f.student_email FROM student f where f.field_id="+field_id;
            this.statement = this.dbConnection.connect().prepareStatement(query);
            this.resultSet = this.statement.executeQuery();
            // Clear 
            this.list_t = new ArrayList<>();
            while(this.resultSet.next())
            {
                this.t.setStudent_id(this.resultSet.getInt("student_id"));
                this.t.setStudent_name(this.resultSet.getString("student_name"));
                this.t.setStudent_secondName(this.resultSet.getString("student_secondName"));
                this.t.setStudent_email(this.resultSet.getString("student_email"));
                this.list_t.add(this.t);
            }
        }catch(Exception e)
        {

        }finally{
            this.statement.close();
            this.dbConnection.disconnect();
        }
        return this.list_t ; 
    }

    @Override
    public Student AuthenticateStudent(String email, String password) throws IOException, SQLException {
        try {
            this.dbConnection = new DBConnection()  ;
            this.query = "SELECT * FROM students"+
                        " WHERE student_email= ?"+
                        " AND student_password=?" ; 
            this.statement = this.dbConnection.connect().prepareStatement(this.query);   
            statement.setString(1,email);
            statement.setString(2,password);
            this.resultSet = this.statement.executeQuery();
            this.t = new Student();
            if(this.resultSet.next())
            {
                this.t.setStudent_id(this.resultSet.getInt("student_id"));
                this.t.setStudent_name(this.resultSet.getString("student_name"));
                this.t.setStudent_email(this.resultSet.getString("student_email"));
                this.t.setStudent_password(this.resultSet.getString("student_password"));
                return this.t ; 
            }
            return null ; 
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
    public List<AbsenceResponsDto> getAbsences(Integer student_id) throws IOException, SQLException {
        try {
            this.dbConnection = new DBConnection() ; 

            // this.query = " SELECT m.modul_id , m.modul_name , m.modul_abbreviation "+
            //              " FROM moduls m   "+
            //              " WHERE m.modul_id IN ( " +
            //              " SELECT DISTINCT(modul_id) " +
            //              " FROM group_absences ga" + 
            //              " WHERE ga.student_id="+student_id+") " ;
            this.query = " SELECT m.modul_id , m.modul_name , m.modul_abbreviation "+
                         " FROM moduls m   "+
                         " WHERE m.modul_id IN ( " +
                            " SELECT gm.modul_id " +
                            " FROM group_moduls gm" + 
                            " WHERE gm.group_id IN ( " +
                                " SELECT g.group_id " +
                                " FROM groups g " + 
                                " WHERE g.level_id IN ( " + 
                                    " SELECT s.student_id " + 
                                    " FROM students s " + 
                                    " WHERE s.student_id="+student_id+
                                    " ) " +
                                " ) " +
                            " )" ;
            this.statement = this.dbConnection.connect().prepareStatement(this.query);
            this.resultSet = this.statement.executeQuery();
            ResultSet resultSetSecond ;
            Integer modul_id ; 
            List < AbsenceResponsDto> absencesList = new ArrayList<>();
            while(this.resultSet.next())
            {
                AbsenceResponsDto absenceResponsDto = new AbsenceResponsDto();
                modul_id = this.resultSet.getInt("modul_id"); 
                absenceResponsDto.setModul_id( modul_id);
                absenceResponsDto.setStudent_id(student_id);
                absenceResponsDto.setModul_name(this.resultSet.getString("modul_name"));
                absenceResponsDto.setModul_abbreviation(this.resultSet.getString("modul_abbreviation")); 
                this.query = "SELECT ga.absence_date , ga.absence_hours "
                            + " FROM student_absences ga "
                            + " WHERE ga.student_id="+student_id
                            + " AND ga.modul_id="+modul_id; 
                this.statement = this.dbConnection.connect().prepareStatement(this.query);   
                resultSetSecond = this.statement.executeQuery(); 
                AbsenceDate absenceDate = null ; 
                while(resultSetSecond.next())
                {
                    absenceDate = new AbsenceDate();
                    absenceDate.setAbsence_date(resultSetSecond.getDate("absence_date"));
                    absenceDate.setAbsence_hour(resultSetSecond.getInt("absence_hours"));
                    absenceResponsDto.getAbsenceDates().add(absenceDate);
                }
                absencesList.add(absenceResponsDto);
            }
            return absencesList;
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally{
            this.dbConnection.disconnect();
            this.resultSet.close();
            this.statement.close();
        }
        return null;
    }

    @Override
    public AbsenceResponsDto getAbsence(Integer modul_id, Integer student_id) throws IOException, SQLException {
        try {
            this.dbConnection = new DBConnection()  ; 
            this.query = "SELECT  m.modul_name , m.modul_abbreviation FROM moduls m WHERE m.modul_id="+modul_id ; 
            this.statement = this.dbConnection.connect().prepareStatement(query);
            this.resultSet = this.statement.executeQuery();
            AbsenceResponsDto absenceResponsDto = new AbsenceResponsDto();
            while(this.resultSet.next())
            {
                absenceResponsDto.setModul_id(modul_id);
                absenceResponsDto.setModul_name(this.resultSet.getString("modul_name"));
                absenceResponsDto.setModul_name(this.resultSet.getString("modul_abbreviation"));
            }
            this.query = "   SELECT ga.absence_date ga.absence_hours "
                        + " FROM group_absences ga "
                        + " WHERE ga.student_id="+student_id
                        + " AND ga.modul_id="+modul_id; 
            this.statement = this.dbConnection.connect().prepareStatement(query);
            this.resultSet = this.statement.executeQuery();
            while(this.resultSet.next())
            {
                AbsenceDate absenceDate = new AbsenceDate();
                absenceDate.setAbsence_date(this.resultSet.getDate("modul_date"));
                absenceDate.setAbsence_hour(this.resultSet.getInt("absence_hours"));
                absenceResponsDto.getAbsenceDates().add(absenceDate);
            }
            return absenceResponsDto;
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally{
            this.statement.close(); 
            this.resultSet.close();
            this.dbConnection.disconnect();
        }
        return null;
    }

    @Override
    public AbsenceOneResponsDto getOneAbsence(Integer modul_id, Integer student_id, Date absence_date)
            throws IOException, SQLException {
            
                try {
                    this.dbConnection = new DBConnection()  ; 
                    this.query = "SELECT  m.modul_name , m.modul_abbreviation FROM moduls m WHERE m.modul_id="+modul_id ; 
                    this.statement = this.dbConnection.connect().prepareStatement(query);
                    this.resultSet = this.statement.executeQuery();
                    AbsenceOneResponsDto absenceResponsDto = new AbsenceOneResponsDto();
                    while(this.resultSet.next())
                    {
                        absenceResponsDto.setModul_id(modul_id);
                        absenceResponsDto.setModul_name(this.resultSet.getString("modul_name"));
                        absenceResponsDto.setModul_name(this.resultSet.getString("modul_abbreviation"));
                    }
                    this.query = "   SELECT ga.absence_date ga.absence_hours "
                                + " FROM group_absences ga "
                                + " WHERE ga.student_id="+student_id
                                + " AND ga.modul_id="+modul_id
                                + " AND ga.absence_date="+absence_date ;
                    this.statement = this.dbConnection.connect().prepareStatement(query);
                    this.resultSet = this.statement.executeQuery();

                    while(this.resultSet.next())
                    {
                        absenceResponsDto.setAbsence_hours(this.resultSet.getInt("modul_hours"));
                        absenceResponsDto.setAbsence_date(this.resultSet.getDate("absence_date"));
                    }
                    return absenceResponsDto;
                }catch(Exception e)
                {
                    e.printStackTrace();
                }finally{
                    this.statement.close(); 
                    this.resultSet.close();
                    this.dbConnection.disconnect();
                }
                return null;
    }

    @Override
    public  List<CreateAbsenceDto> getModulsToAdd(Integer student_id) throws IOException, SQLException {

        try {
            this.dbConnection = new DBConnection();
            this.query = " SELECT m.modul_id, m.modul_name " 
            + " FROM moduls m "
            + " WHERE m.modul_id NOT IN ("
                                        + " SELECT DISTINCT ( sa.modul_id ) "
                                        + " FROM student_absences as" 
                                        + ")" 
            + " AND modul_id IN ( " 
                                + " SELECT ma.modul_id"
                                + " FROM group_id IN ("
                                                    + " SELECT ma.modul_id"
                                                    + " FROM group_moduls"
                                                    + " WHERE group_id IN ("
                                                                        + " SELECT gs.group_id "
                                                                        + " FROM   group_student gs"
                                                                        + " WHERE  gs.student_id="+student_id
                                                                        + " AND    gs.groupId IN ("
                                                                                                + " SELECT group_id"
                                                                                                + " FROM groups p"
                                                                                                + " WHERE level_id IN ("
                                                                                                                    + " SELECT level_id"
                                                                                                                    + " FROM students "
                                                                                                                    + " WHERE student_id="+student_id
                                                                                                                    + ")"
                                                                                                + ")"
                                                                        + ")"
                                                    + ")"
                                + ")";
            this.statement = this.dbConnection.connect().prepareStatement(this.query);
            this.resultSet = this.statement.executeQuery();
            List<CreateAbsenceDto> moduls = new  ArrayList<CreateAbsenceDto>();
            while(this.resultSet.next())
            {
                String modulName = this.resultSet.getString("modul_name");
                Integer modulId = this.resultSet.getInt("modul_id");
                CreateAbsenceDto createAbsenceDto = new CreateAbsenceDto();
                createAbsenceDto.getModul().setModul_id(modulId);
                createAbsenceDto.getModul().setModul_name(modulName);
                moduls.add(createAbsenceDto);
            }
            return moduls ; 
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally{

        }

        return null;
    }

    @Override
    public Boolean saveNewAbsence(NewAbsenceRequest newAbsenceRequest) throws IOException, SQLException{
        try {
            this.dbConnection = new DBConnection();
            this.query = "INSERT INTO student_absences (student_id , modul_id , absence_date , absence_hours)"
                         +"VALUES(?,?,?,?)" ;
            this.statement = this.dbConnection.connect().prepareStatement(query);
            this.statement.setInt(1, newAbsenceRequest.getStudent_id());
            this.statement.setInt(2, newAbsenceRequest.getModul_id());
            this.statement.setString(3,newAbsenceRequest.getAbsence_date());
            this.statement.setInt(4, newAbsenceRequest.getAbsence_hours());
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
    public Boolean deleteAbsence(DeleteAbsenceRequest deleteAbsenceRequest) throws IOException, SQLException {
        try {
            this.dbConnection = new DBConnection();
            this.query = "DELETE sa.* FROM student_absences sa WHERE sa.student_id=? AND sa.modul_id =? AND sa.absence_date=? " ;
            this.statement = this.dbConnection.connect().prepareStatement(query);
            this.statement.setInt(1, deleteAbsenceRequest.getStudent_id());
            this.statement.setInt(2, deleteAbsenceRequest.getModul_id());
            this.statement.setString(3,deleteAbsenceRequest.getAbsence_date());
            Boolean resultState = this.statement.execute();
            System.out.println("the result is  =>" + resultState);
            return resultState;
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally {
            this.statement.close();
            this.dbConnection.disconnect();
        }   
        return null;
    }


    @Override
    public List<Date> getDates(Integer student_id) throws IOException, SQLException {
        try {
            this.dbConnection = new DBConnection();
            this.query = "SELECT DISTINCT(gs.affectation_date)" + 
                        " FROM student_groups gs" +
                        " WHERE gs.student_id="+student_id;
            this.statement = this.dbConnection.connect().prepareStatement(query);
            this.resultSet = this.statement.executeQuery();
            List<Date> listDates = new ArrayList<Date>();
            while(this.resultSet.next())
            {
                listDates.add(this.resultSet.getDate("affectation_date"));
            }
            return listDates;
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally {
            this.statement.close();
            this.dbConnection.disconnect();
        }   
        return null;
    }


    @Override
    public List<MarkResponse> getMarks(Integer student_id) throws IOException, SQLException {
        try {
            this.dbConnection = new DBConnection() ; 
            this.query = " SELECT m.modul_id , m.modul_name , m.modul_abbreviation "+
                        "  FROM moduls m   "+
                        "  WHERE m.modul_id IN ( " +
                            " SELECT gm.modul_id " +
                            " FROM group_moduls gm" + 
                            " WHERE gm.group_id IN ( " +
                                " SELECT g.group_id " +
                                " FROM groups g " + 
                                " WHERE g.level_id IN ( " + 
                                    " SELECT s.student_id " + 
                                    " FROM students s " + 
                                    " WHERE s.student_id="+student_id+
                                " ) " +
                            " ) " +
                        " )" ;
            this.statement = this.dbConnection.connect().prepareStatement(query);
            this.resultSet = this.statement.executeQuery();
            List<MarkResponse> marks = new ArrayList<MarkResponse>();

            while(this.resultSet.next())
            {
                MarkResponse markInfo = new MarkResponse();
                markInfo.setModul_id(this.resultSet.getInt("modul_id"));
                markInfo.setModul_name(this.resultSet.getString("modul_name"));
                markInfo.setModul_abbreviation(this.resultSet.getString("modul_abbreviation"));
                markInfo.setStudent_id(student_id);
                marks.add(markInfo);
            }
            this.resultSet.close();
            this.statement.close();
            for(int i=0 ; i<marks.size() ; i++)
            {
                this.query = " SELECT sm.mark_value"+
                             " FROM student_marks sm"+
                             " WHERE sm.student_id="+student_id+
                             " AND sm.modul_id="+marks.get(i).getModul_id();
                this.statement = this.dbConnection.connect().prepareStatement(query);
                this.resultSet = this.statement.executeQuery();
                while(this.resultSet.next())
                {
                    marks.get(i).setMark(this.resultSet.getFloat("mark_value"));
                }
            }
            return marks;
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
    public Boolean updateMark(UpdateMarkRequest updateMarkRequest) throws IOException, SQLException {
        try {
            this.dbConnection = new DBConnection() ; 
            this.query = " UPDATE student_marks" + 
                         " SET mark_value = "+updateMarkRequest.getModul_mark()+
                         " WHERE modul_id = "+updateMarkRequest.getModul_id() + 
                         " AND student_id = "+updateMarkRequest.getStudent_id();
            this.statement = this.dbConnection.connect().prepareStatement(query);
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
    public List<LevelResponseDto> getLevels() throws IOException, SQLException {
        try {
            this.dbConnection = new DBConnection() ; 
            this.query = "SELECT l.level_id , l.level_abbreviation "+
                        " FROM levels " + 
                        " WHERE l.level_id IN ( " + 
                        " SELECT DISTINCT(s.level_id) FROM students s " ;
            this.statement = this.dbConnection.connect().prepareStatement(query);
            this.resultSet = this.statement.executeQuery();
            List<LevelResponseDto> levels = new ArrayList<LevelResponseDto>();
            while(this.resultSet.next())
            {
                LevelResponseDto level  = FunctionUtils.extractInfoLevelFromResultSet(this.resultSet);
                levels.add(level);
            }
            return levels ; 
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally{

        }
        return null;
    }


    @Override
    public StudentScholarInfo getScholarInfo(Integer student_id) throws IOException, SQLException {
        try {
            this.dbConnection = new DBConnection();
            this.query = " SELECT s.student_id , s.student_cne , s.student_name , s.student_secondName ,  " +
                         " (SELECT l.level_name FROM levels l WHERE l.level_id  = s.level_id ) student_level ,"+
                         " (SELECT f.field_name FROM fields f WHERE f.field_id = s.field_id) student_field"+
                         " FROM students s" +
                         " WHERE s.student_id = "+student_id;
            this.statement = this.dbConnection.connect().prepareStatement(this.query);
            this.resultSet = this.statement.executeQuery();
            StudentScholarInfo scholarInfo = new StudentScholarInfo();
            while(this.resultSet.next())
            {
                scholarInfo.setStudent_id(this.resultSet.getInt("student_id"));
                scholarInfo.setStudent_secondName(this.resultSet.getString("student_secondName"));
                scholarInfo.setStudent_name(this.resultSet.getString("student_name"));
                scholarInfo.setStudent_level(this.resultSet.getString("student_level"));
                scholarInfo.setStudent_field(this.resultSet.getString("student_field"));
            }
            this.resultSet.close();
            this.query = " SELECT g.group_name , (SELECT l.level_name  FROM levels l WHERE g.level_id  = l.level_id) group_level "
                         +" FROM groups g , student_groups sg "
                         +" WHERE sg.student_id = "+student_id
                         +" AND   sg.group_id= g.group_id"
                         +" GROUP BY g.group_id";
            this.statement = this.dbConnection.connect().prepareStatement(this.query);
            this.resultSet = this.statement.executeQuery();
            GroupUtil groupUtil = null ; 
            while(this.resultSet.next())
            {
                 groupUtil = new GroupUtil();
                 groupUtil.setGroup_name(this.resultSet.getString("group_name"));
                 groupUtil.setGroup_level(this.resultSet.getString("group_level"));
                 scholarInfo.getGroups().add(groupUtil);
            }
            return scholarInfo;
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally{
            this.resultSet.close();
            this.statement.close();
            this.dbConnection.disconnect();
        }
        return null ;
    }

    @Override
    public List<LevelListResponseDTO> getListYears() throws IOException, SQLException {
       try {
            this.dbConnection = new DBConnection() ; 
            this.query = " SELECT l.level_id , l.level_name , l.level_abbreviation, " + 
                         " (SELECT COUNT(g.level_id) FROM groups g WHERE g.level_id=l.level_id)  as level_groupNumber "+
                         " FROM levels l " ;
            this.statement = this.dbConnection.connect().prepareStatement(query);
            this.resultSet = this.statement.executeQuery();
            List<LevelListResponseDTO> levels = new ArrayList<LevelListResponseDTO>();
            while(this.resultSet.next())
            {
                LevelListResponseDTO level = new LevelListResponseDTO();
                level.setLevel_id(this.resultSet.getInt("level_id"));
                level.setLevel_abbreviation(this.resultSet.getString("level_abbreviation"));
                level.setLevel_name(this.resultSet.getString("level_name"));
                level.setLevel_groups(this.resultSet.getInt("level_groupNumber"));
                levels.add(level);
            }
            return levels ; 
       }catch(Exception e)
       {
            e.printStackTrace();
       }
        return null;
    }

    
    

    

    


}
