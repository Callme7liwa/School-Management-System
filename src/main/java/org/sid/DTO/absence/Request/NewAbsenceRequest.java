package org.sid.DTO.absence.Request;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewAbsenceRequest {

    private Integer student_id ; 
    private Integer modul_id ; 
    private String absence_date ; 
    private Integer absence_hours ; 
    
}
