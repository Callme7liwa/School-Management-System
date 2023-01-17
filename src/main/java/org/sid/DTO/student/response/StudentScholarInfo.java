package org.sid.DTO.student.response;
import java.util.*;

import org.sid.DTO.UtilsClass.GroupUtil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentScholarInfo {

    private Integer student_id ; 
    private String student_name ; 
    private String student_secondName ; 
    private String student_cne ;
    private String student_level ; 
    private String student_inscriptionDate ; 
    private String student_field ; 
    private List<GroupUtil> groups  = new ArrayList<GroupUtil>() ; 
}
