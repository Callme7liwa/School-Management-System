package org.sid.DTO.absence.Response;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AbsenceOneResponsDto {

    private Integer modul_id ; 
    private Integer student_id ;
    private String modul_name ; 
    private String modul_abbreviation ;  
    private Date absence_date ; 
    private Integer absence_hours ; 
    
}
