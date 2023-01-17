package org.sid.DTO.group.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import org.sid.DTO.UtilsClass.StudentUtil;



@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddStudentGroupResp {
    private Integer group_id;
    private String group_abbreviation ; 
    private List<StudentUtil> listStudents = new ArrayList<StudentUtil>();

    public void pushStudent(String student_name , Integer student_id)
    {
        StudentUtil studentUtil = new StudentUtil();
        studentUtil.setStudent_name(student_name);
        studentUtil.setStudent_id(student_id);
    }  
}

