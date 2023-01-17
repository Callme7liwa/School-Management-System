package org.sid.utils;

import org.sid.DTO.UtilsClass.ModulProfessorAffectationUtil;
import org.sid.DTO.group.response.InfoGroupDaoResponse;
import org.sid.DTO.group.response.ModulProfessor;
import org.sid.DTO.level.Response.LevelResponseDto;
import org.sid.DTO.modul.Response.ModulResponseDto;
import org.sid.entities.Event;
import org.sid.entities.Field;
import org.sid.entities.Group;
import org.sid.entities.Module;
import org.sid.entities.Professor;
import org.sid.entities.Student;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;


public class FunctionUtils {

    public static  Student extractInfoStudentFromResultSet(ResultSet resultSet) throws SQLException
    {
        Student student = new Student();
        student.setStudent_id(resultSet.getInt("student_id"));
        student.setStudent_name(resultSet.getString("student_name"));
        student.setStudent_secondName(resultSet.getString("student_secondName"));
        student.setStudent_nationality(resultSet.getString("student_nationality"));
        student.setStudent_email(resultSet.getString("student_email"));
        student.setStudent_birthday(resultSet.getDate("student_birthday"));
        student.setStudent_gender(resultSet.getString("student_gender"));
        student.setStudent_cin(resultSet.getString("student_cin"));
        student.setStudent_cne(resultSet.getString("student_cne"));
        student.setStudent_country(resultSet.getString("student_country"));
        student.setStudent_city(resultSet.getString("student_city"));
        student.setStudent_phone(resultSet.getString("student_phoneNumber"));
        student.setStudent_adress(resultSet.getString("student_adress"));
        student.setStudent_image(resultSet.getString("student_image"));
        return student ;
    }

    public static LevelResponseDto extractInfoLevelFromResultSet(ResultSet resultSet) throws SQLException {
        LevelResponseDto level = new LevelResponseDto() ; 
        Integer level_id = Integer.parseInt(resultSet.getString("level_id"));
        String  level_abbreviation = resultSet.getString("level_abbreviation");
        level.setLevel_id(level_id);
        level.setLevel_abbreviation(level_abbreviation);
        return level ; 
    }

    

    public static Professor extractInfoProfessorFromResultSet(ResultSet resultSet) throws SQLException {

        Professor professor = new Professor();

        professor.setProfessor_id(resultSet.getInt("professor_id"));
        System.out.println("the professor id => " + professor.getProfessor_id());
        professor.setProfessor_name(resultSet.getString("professor_name"));
        professor.setProfessor_email(resultSet.getString("professor_email"));
        return professor;

    }

    public static Professor  exctractInfoProfessorFromResultSet(ResultSet resultSet) throws SQLException {
        Professor professor = new Professor();
        professor.setProfessor_id(resultSet.getInt("professor_id"));
        professor.setProfessor_name(resultSet.getString("professor_name"));
        professor.setProfessor_secondName(resultSet.getString("professor_secondName"));
        professor.setProfessor_email(resultSet.getString("professor_email"));
        professor.setProfessor_adress(resultSet.getString("professor_adress"));
        professor.setProfessor_cin(resultSet.getString("professor_cin"));
        professor.setProfessor_country(resultSet.getString("professor_country"));
        professor.setProfessor_city(resultSet.getString("professor_city"));
        professor.setProfessor_birthday(resultSet.getDate("professor_birthday"));
        professor.setProfessor_phoneNumber(resultSet.getString("professor_phoneNumber"));
        professor.setProfessor_postalCode(resultSet.getString("professor_postalCode"));
        professor.setProfessor_gender(resultSet.getString("professor_gender"));
        return professor ; 
    }

    public static Module extractInfoModuleFromResultSet(ResultSet resultSet) throws SQLException 
    {
        Module module = new Module();
        module.setModul_id(resultSet.getInt("modul_id"));
        module.setModul_abbreviation(resultSet.getString("modul_abbreviation"));
        module.setModul_name(resultSet.getString("modul_name"));
        return module ; 
    }

    public static ModulResponseDto extractInfoModulExtraFromResultSet(ResultSet resultSet) throws SQLException {
        ModulResponseDto modulResponseDto = new ModulResponseDto();
        modulResponseDto.setModul_id(resultSet.getInt("modul_id"));
        modulResponseDto.setModul_name(resultSet.getString("modul_name"));
        modulResponseDto.setModul_abbreviation(resultSet.getString("modul_abbreviation"));
        modulResponseDto.setModul_creationDate(resultSet.getDate("modul_creationDate"));
        modulResponseDto.setProfessor_numbers(resultSet.getInt("professors_number"));
        modulResponseDto.setGroups_number(resultSet.getInt("groups_number"));
        return modulResponseDto ; 
    }

    public static Field extractInfoFieldFromResultSet(ResultSet resultSet) throws SQLException {
        Field  field = new Field();
        field.setField_id(resultSet.getInt("field_id"));
        field.setField_name(resultSet.getString("field_name"));
        field.setField_abbreviation(resultSet.getString("field_abbreviation"));
        field.setField_description(resultSet.getString("field_description"));
        field.setField_creationDate(resultSet.getDate("field_creationDate"));
        return field ; 
    }

    public static Group extractInfoGroupFromResultSet(ResultSet resultSet) throws SQLException {
        Group group = new Group();
        try {
            group.setGroup_id(resultSet.getInt("group_id"));
            group.setGroup_name(resultSet.getString("group_name"));
            group.setGroup_abbreviation(resultSet.getString("group_abbreviation"));
            group.setGroup_creationDate(resultSet.getDate("group_creationDate"));
            group.setGroup_year(resultSet.getString("group_year"));
            Field field = new Field();
            field.setField_id(resultSet.getInt("field_id"));
            field.setField_name(resultSet.getString("field_name"));
            field.setField_abbreviation(resultSet.getString("field_abbreviation"));
            group.setField(field);
            return group ; 
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return group ; 
    }

    public static InfoGroupDaoResponse extractSpecialInfoGroupFromResultSet(ResultSet resultSet) throws SQLException {
        InfoGroupDaoResponse infoGroupDaoResponse = new InfoGroupDaoResponse();
        Group group = extractInfoGroupFromResultSet(resultSet);
        infoGroupDaoResponse.setGroup(group);
        infoGroupDaoResponse.setStudents_number(resultSet.getInt("students_number"));
        infoGroupDaoResponse.setProfessors_number(resultSet.getInt("professors_number"));
        infoGroupDaoResponse.setModuls_number(resultSet.getInt("moduls_number"));
        return infoGroupDaoResponse ; 
    }

    public static ModulProfessorAffectationUtil extractInformationModulProfessorFromResultSet(ResultSet resultSet) throws SQLException {
        ModulProfessorAffectationUtil affectation = new ModulProfessorAffectationUtil() ; 
        affectation.setModul_id(resultSet.getInt("modul_id"));
        affectation.setModul_name(resultSet.getString("modul_name"));
        affectation.setModul_abbreviation(resultSet.getString("modul_abbreviation"));
        affectation.setProfessor_id(resultSet.getInt("professor_id"));
        affectation.setProfessor_name(resultSet.getString("professor_name"));
        affectation.setProfessor_secondName(resultSet.getString("professor_secondName"));
        affectation.setProfessor_imagePath(resultSet.getString("professor_imagePath"));
        System.out.println("affectation in fonction util > " + affectation);
        return affectation ; 
    }

    public static Event extractInformationEventFromResultSet(ResultSet resultSet) throws SQLException { 
        Event event = new Event();
        event.setEvent_id(resultSet.getInt("event_id"));
        event.setEvent_title(resultSet.getString("event_title"));
        event.setEvent_description(resultSet.getString("event_description"));
        event.setEvent_local(resultSet.getString("event_local"));
        event.setEvent_date(resultSet.getDate("event_date"));
        event.setEvent_filePath(resultSet.getString("event_filePath"));
        event.setEvent_fileExtension(resultSet.getString("event_fileExtension"));
        return event ; 
    }

    public static Timestamp getCurrentDate(String dateFormat  ) {

        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        return date ;
    }

    public static Optional<String> getExtensionByStringHandling(String filename) {
        return Optional.ofNullable(filename)
          .filter(f -> f.contains("."))
          .map(f -> f.substring(filename.lastIndexOf(".") + 1));
    }



}
