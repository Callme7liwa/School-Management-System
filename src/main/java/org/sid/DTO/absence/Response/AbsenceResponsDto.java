package org.sid.DTO.absence.Response;

import java.util.ArrayList;
import java.util.List;

import org.sid.utils.AbsenceDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AbsenceResponsDto {

    private Integer modul_id ;
    private Integer student_id; 
    private String modul_name ; 
    private String modul_abbreviation ; 
    private List<AbsenceDate> absenceDates  = new ArrayList<>();

    
}
