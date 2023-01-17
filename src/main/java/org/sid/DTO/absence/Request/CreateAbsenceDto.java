package org.sid.DTO.absence.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateAbsenceDto {

    private Integer   student_id;
    private ModulUtil modul ;

    
    
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public class ModulUtil  {
            Integer modul_id ; 
            String modul_name ;
    }

    
}

