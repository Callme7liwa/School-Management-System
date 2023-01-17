package org.sid.DTO.student.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    private String student_name ;
    private String student_secondName ;
    private String student_email ;
    private String student_birthday ;
    private String student_phone ; 
    private String student_gender ;
    private String student_nationality;
    private String student_cne ;
    private String student_cin ;
    private String student_city ;
    private String student_country ;
    private String student_adress ;
    private Integer field_id ; 
}
