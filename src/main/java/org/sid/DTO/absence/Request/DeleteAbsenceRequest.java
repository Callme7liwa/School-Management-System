package org.sid.DTO.absence.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeleteAbsenceRequest {
    private Integer student_id ; 
    private Integer modul_id ; 
    private String absence_date ; 
}
