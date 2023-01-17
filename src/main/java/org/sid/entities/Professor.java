package org.sid.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Professor extends User{
    private Integer professor_id ;
    private String professor_name ;
    private String professor_secondName ;
    private String professor_email ;
    private Date professor_birthday ;
    private String professor_gender ; 
    private String professor_cin ;
    private String professor_city ;
    private String professor_country ;
    private String professor_nationality;
    private String professor_adress ;
    private String professor_password ;
    private String professor_postalCode ; 
    private String professor_phoneNumber;
    private String professor_departementName ; 
    private Integer professor_modulNumber ; 
    private Integer professor_groupNumber ; 
}
