package org.sid.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public  class Student extends User {
    private Integer student_id ;
    private String student_name ;
    private String student_secondName ;
    private String student_email ;
    private Date student_birthday ;
    private String student_gender ;
    private String student_nationality;
    private String student_cne ;
    private String student_cin ;
    private String student_city ;
    private String student_country ;
    private String student_adress ;
    private String student_password ;
    private String student_phone;
    private String student_image;
}
