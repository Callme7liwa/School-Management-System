package org.sid.DTO.UtilsClass;

import java.sql.Date;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AbsenceUtil {

    
    private Date absenDate  ; 
    private Integer absence_hours ; 
    
}
