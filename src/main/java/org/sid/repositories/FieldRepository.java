package org.sid.repositories;

import java.io.IOException;
import java.sql.SQLException;

import java.util.*;
import org.sid.entities.Field;
import org.sid.entities.Group;
import org.sid.entities.Student;
import org.sid.DTO.field.request.FieldSaveRequest;
import org.sid.DTO.field.request.FieldUpdateRequest;
import org.sid.DTO.field.response.FieldEditResponseDao;
import org.sid.DTO.field.response.FieldResponseDao;

public interface FieldRepository {

    public Boolean saveField(FieldSaveRequest fieldSaveRequest) throws IOException , SQLException;
    public FieldResponseDao getField(Integer field_id) throws IOException , SQLException ; 
    public FieldEditResponseDao getFieldEdit(Integer field_id) throws IOException , SQLException ; 
    public List<Field> getFields() throws IOException , SQLException ; 
    public List<Student> getStudentsField(Integer field_id) throws IOException , SQLException ;
    public List<Group> getGroupsByField(Integer field_id) throws IOException , SQLException ;
    public Boolean updateField(FieldUpdateRequest fieldUpdateRequest) throws SQLException;
}
