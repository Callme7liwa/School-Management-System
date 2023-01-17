package org.sid.services.filiere;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import org.sid.DTO.field.request.FieldSaveRequest;
import org.sid.DTO.field.request.FieldUpdateRequest;
import org.sid.DTO.field.response.FieldEditResponseDao;
import org.sid.DTO.field.response.FieldResponseDao;
import org.sid.entities.Field;
import org.sid.entities.Group;
import org.sid.entities.Student;
import org.sid.repositories.FieldRepository;
import org.sid.repositories.GroupRepository;
import org.sid.repositories.StudentRepository;
import org.sid.services.SupperService;

public class FieldServiceImpl implements  FieldService {

    private FieldRepository fieldRepository ; 
    private StudentRepository studentRepository ; 
    private GroupRepository groupRepository ; 

    public FieldServiceImpl()
    {
        this.fieldRepository = SupperService.getFieldRepositoryInstance();
    }

    @Override
    public Boolean saveField(FieldSaveRequest fieldSaveRequest) throws IOException, SQLException {
        return this.fieldRepository.saveField(fieldSaveRequest);
    }

    @Override
    public FieldResponseDao getField(Integer field_id) throws IOException, SQLException  {
        FieldResponseDao fieldResponseDao =  this.fieldRepository.getField(field_id);
        return fieldResponseDao ; 
    }

    @Override
    public List<Group> getGroupByField(Integer field_id) throws IOException, SQLException {
        List<Group> fieldGroups =  this.fieldRepository.getGroupsByField(field_id);
        return fieldGroups ; 
    }
    
    @Override
    public List<Student> getStudentByField(Integer field_id) throws IOException, SQLException {
        return this.studentRepository.getStudentsByField(field_id);
    }

    @Override
    public List<Field> getFields() throws IOException, SQLException {
        List<Field> fields = this.fieldRepository.getFields();
        return fields;
    }

    @Override
    public List<Student> getStudentsField(Integer field_id) throws IOException, SQLException {
        List<Student> students = this.fieldRepository.getStudentsField(field_id);
        return students;
    }

    @Override
    public FieldEditResponseDao getFieldEdit(Integer field_id) throws IOException, SQLException {
        FieldEditResponseDao fieldEditResponseDao = this.fieldRepository.getFieldEdit(field_id);
        return fieldEditResponseDao;
    }

    @Override
    public Boolean updateField(FieldUpdateRequest fieldUpdateRequest) throws IOException, SQLException {
        Boolean resultState  = this.fieldRepository.updateField(fieldUpdateRequest);
        return null;
    }



}
