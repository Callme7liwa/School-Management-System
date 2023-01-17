package org.sid.DTO.student.request;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdatePersonnalStudent {

    private Integer student_id ; 
    private String student_name ; 
    private String student_secondName ; 
    private String student_cin ; 
    private String student_birthday;
    private String student_gender ; 
    private String student_nationality ; 
    private String student_email ; 
    private String student_country ; 
    private String student_city ; 
    private String student_adress ; 
    private String student_phone ; 
    private String student_image ; 
    
}
